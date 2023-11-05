package io.atha.quickbasic.terminal

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import com.termux.terminal.TerminalEmulator
import com.termux.terminal.TerminalOutput
import com.termux.terminal.TerminalSession
import com.termux.terminal.TerminalSessionClient
import io.atha.quickbasic.RunDatum
import io.atha.utils.ByteQueue
import org.puffinbasic.PuffinBasicInterpreterMain
import org.puffinbasic.PuffinBasicInterpreterMain.interpretAndRun
import org.puffinbasic.error.PuffinBasicInternalError
import org.puffinbasic.error.PuffinBasicRuntimeError
import org.puffinbasic.error.PuffinBasicSyntaxError
import org.puffinbasic.runtime.SystemEnv
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.util.UUID

/**
 * A terminal session, consisting of a process coupled to a terminal interface.
 *
 *
 * The subprocess will be executed by the constructor, and when the size is made known by a call to
 * [.updateSize] terminal emulation will begin and threads will be spawned to handle the subprocess I/O.
 * All terminal emulation and callback methods will be performed on the main thread.
 *
 *
 * The child process may be exited forcefully by using the [.finishIfRunning] method.
 *
 *
 * NOTE: The terminal session may outlive the EmulatorView, so be careful with callbacks!
 */
class BabaTerminalSession(
    /** Callback which gets notified when a session finishes or changes title.  */
    var mClient: TerminalSessionClient,
    private val mActivity: Activity,
    val datum: RunDatum
) : TerminalOutput(), TerminalSession {
    private var execProcess: Thread? = null
    private val mHandle = UUID.randomUUID().toString()
    var mEmulator: TerminalEmulator? = null

    /**
     * A queue written to from a separate thread when the process outputs, and read by main thread to process by
     * terminal emulator.
     */
    val mProcessToTerminalIOQueue = ByteQueue(4096)

    /**
     * A queue written to from the main thread due to user interaction, and read by another thread which forwards by
     * writing to the [.mTerminalFileDescriptor].
     */
    private val mTerminalToProcessIOQueue = ByteQueue(4096)

    /** Buffer to write translate code points into utf8 before writing to mTerminalToProcessIOQueue  */
    private val mUtf8InputBuffer = ByteArray(5)

    /** The exit status of the shell process. Only valid if $[.mShellPid] is -1.  */
    private var mShellExitStatus = 0

    /** Set by the application for user identification of session, not by terminal.  */
    private var mSessionName: String? = null
    val mMainThreadHandler: Handler = MainThreadHandler()

    override fun updateTerminalSessionClient(client: TerminalSessionClient) {
        mClient = client
        if (mEmulator != null) mEmulator!!.updateTerminalSessionClient(client)
    }

    /** Inform the attached pty of the new size and reflow or initialize the emulator.  */
    override fun updateSize(columns: Int, rows: Int) {
        if (mEmulator == null) {
            initializeEmulator(columns, rows)
        } else {
//            JNI.setPtyWindowSize(mTerminalFileDescriptor, rows, columns)
            mEmulator!!.resize(columns, rows)
        }
    }

    /** The terminal title as set through escape sequences or null if none set.  */
    override fun getTitle(): String? {
        return if (mEmulator == null) null else mEmulator!!.title
    }

    private val mTranscriptRows = 1000

    /**
     * Set the terminal emulator's window size and start terminal emulation.
     *
     * @param columns The number of columns in the terminal window.
     * @param rows    The number of rows in the terminal window.
     */
    override fun initializeEmulator(columns: Int, rows: Int) {
        mEmulator = TerminalEmulator(this, columns, rows, mTranscriptRows, mClient)
        val fileName = "editor.bas"
        val userOptions = org.puffinbasic.PuffinBasicInterpreterMain.UserOptions(
            logOnDuplicate = false,
            listSourceCode = false,
            printIR = false,
            timing = false,
            graphics = false,
            filename = fileName,
        )
        val stdin = AndroidSystemInAndOut(mActivity)
        object : Thread("TermSessionInputReader") {
            override fun run() {
                try {
                    stdin.getStdout().use { termIn ->
                        val buffer = ByteArray(4096)
                        while (true) {
                            val read: Int = termIn.read(buffer)
                            if (read == -1) return@use
                            if (read > 0) {
                                if (!mProcessToTerminalIOQueue.write(buffer, 0, read)) return@use
                                mMainThreadHandler.sendEmptyMessage(MSG_NEW_INPUT)
                            }
                        }
                    }
                } catch (e: Exception) {
                    Log.e("qb", "stdin listening copier", e)
                    // Ignore, just shutting down.
                }
                Log.i("qb", "TermSessionInputReader ended")
            }
        }.start()

        execProcess = object : Thread("Run") {
            override fun run() {
                Log.i("qb", "Running script: ${datum.src}")
                var processExitCode = 0
                try {
                    interpretAndRun(
                        userOptions,
                        fileName,
                        datum.src + "\n",
                        stdin,
                        SystemEnv(),
                    )
                    sleep(250)
                } catch (e: PuffinBasicInternalError) {
                    Log.e("qb", "error", e)
                    stdin.outputText("!!! INTERNAL ERROR: ${e.message}")
                    processExitCode = 1
                } catch (e: PuffinBasicRuntimeError) {
                    Log.e("qb", "error", e)
                    stdin.outputText("!!! RUNTIME ERROR: ${e.message}")
                    processExitCode = 128
                } catch (e: PuffinBasicSyntaxError) {
                    Log.e("qb", "error", e)
                    stdin.outputText("!!! SYNTAX ERROR: ${e.message}")
                    processExitCode = 2
                } catch (e: InterruptedException) {
                    Log.e("qb", "error", e)
                    processExitCode = 200
                }
                Log.i("qb", "DONE")
                mMainThreadHandler.sendMessage(
                    mMainThreadHandler.obtainMessage(
                        MSG_PROCESS_EXITED,
                        processExitCode
                    )
                )
                execProcess = null
            }
        }
        object : Thread("TermSessionOutputWriter") {
            override fun run() {
                val buffer = ByteArray(4096)
                try {
                    stdin.getStdin().use { termOut ->
                        while (true) {
                            val bytesToWrite: Int = mTerminalToProcessIOQueue.read(buffer, true)
                            if (bytesToWrite == -1) return
                            termOut.write(buffer, 0, bytesToWrite)
                        }
                    }
                } catch (e: IOException) {
                    // Ignore.
                }
            }
        }.start()
        execProcess!!.start()
    }

    /** Write data to the shell process.  */
    override fun write(data: ByteArray, offset: Int, count: Int) {
        Log.i("qb", "mTerminalToProcessIOQueue.write")
        mTerminalToProcessIOQueue.write(data, offset, count)
    }

    /** Write the Unicode code point to the terminal encoded in UTF-8.  */
    override fun writeCodePoint(prependEscape: Boolean, codePoint: Int) {
        require(!(codePoint > 1114111 || codePoint in 0xD800..0xDFFF)) {
            // 1114111 (= 2**16 + 1024**2 - 1) is the highest code point, [0xD800,0xDFFF] is the surrogate range.
            "Invalid code point: $codePoint"
        }
        var bufferPosition = 0
        if (prependEscape) mUtf8InputBuffer[bufferPosition++] = 27
        if (codePoint <=  /* 7 bits */127) {
            mUtf8InputBuffer[bufferPosition++] = codePoint.toByte()
        } else if (codePoint <=  /* 11 bits */2047) {
            /* 110xxxxx leading byte with leading 5 bits */
            mUtf8InputBuffer[bufferPosition++] = (192 or (codePoint shr 6)).toByte()
            /* 10xxxxxx continuation byte with following 6 bits */mUtf8InputBuffer[bufferPosition++] =
                (128 or (codePoint and 63)).toByte()
        } else if (codePoint <=  /* 16 bits */65535) {
            /* 1110xxxx leading byte with leading 4 bits */
            mUtf8InputBuffer[bufferPosition++] = (224 or (codePoint shr 12)).toByte()
            /* 10xxxxxx continuation byte with following 6 bits */mUtf8InputBuffer[bufferPosition++] =
                (128 or (codePoint shr 6 and 63)).toByte()
            /* 10xxxxxx continuation byte with following 6 bits */mUtf8InputBuffer[bufferPosition++] =
                (128 or (codePoint and 63)).toByte()
        } else { /* We have checked codePoint <= 1114111 above, so we have max 21 bits = 0b111111111111111111111 */
            /* 11110xxx leading byte with leading 3 bits */
            mUtf8InputBuffer[bufferPosition++] = (240 or (codePoint shr 18)).toByte()
            /* 10xxxxxx continuation byte with following 6 bits */mUtf8InputBuffer[bufferPosition++] =
                (128 or (codePoint shr 12 and 63)).toByte()
            /* 10xxxxxx continuation byte with following 6 bits */mUtf8InputBuffer[bufferPosition++] =
                (128 or (codePoint shr 6 and 63)).toByte()
            /* 10xxxxxx continuation byte with following 6 bits */mUtf8InputBuffer[bufferPosition++] =
                (128 or (codePoint and 63)).toByte()
        }
        write(mUtf8InputBuffer, 0, bufferPosition)
    }

    override fun getEmulator(): TerminalEmulator {
        return mEmulator!!
    }

    /** Notify the [.mClient] that the screen has changed.  */
    private fun notifyScreenUpdate() {
        mClient.onTextChanged(this)
    }

    /** Reset state for terminal emulator state.  */
    override fun reset() {
        mEmulator!!.reset()
        notifyScreenUpdate()
    }

    /** Finish this terminal session by sending SIGKILL to the shell.  */
    override fun finishIfRunning() {
        if (isRunning) {
            execProcess?.interrupt()
        }
    }

    /** Cleanup resources when the process exits.  */
    fun cleanupResources(exitStatus: Int) {
        synchronized(this) {
            mShellExitStatus = exitStatus
        }

        // Stop the reader and writer threads, and close the I/O streams
        mTerminalToProcessIOQueue.close()
        mProcessToTerminalIOQueue.close()
    }

    override fun titleChanged(oldTitle: String, newTitle: String) {
        mClient.onTitleChanged(this)
    }

    @Synchronized
    override fun isRunning(): Boolean {
        return execProcess != null && execProcess!!.isAlive
    }

    /** Only valid if not [.isRunning].  */
    @Synchronized
    override fun getExitStatus(): Int {
        return mShellExitStatus
    }

    override fun onCopyTextToClipboard(text: String) {
        mClient.onCopyTextToClipboard(this, text)
    }

    override fun onPasteTextFromClipboard() {
        mClient.onPasteTextFromClipboard(this)
    }

    override fun onBell() {
        mClient.onBell(this)
    }

    override fun onColorsChanged() {
        mClient.onColorsChanged(this)
    }

    override fun getPid(): Int {
        return 0
    }

    override fun getCwd(): String? {
        return null
    }

    override fun setSessionName(name: String) {
        mSessionName = name
    }

    override fun getSessionName(): String {
        return mSessionName!!
    }

    override fun getHandle(): String {
        return mHandle
    }

    @SuppressLint("HandlerLeak")
    internal inner class MainThreadHandler : Handler(Looper.getMainLooper()) {
        private val mReceiveBuffer = ByteArray(4 * 1024)
        override fun handleMessage(msg: Message) {
            val bytesRead = mProcessToTerminalIOQueue.read(mReceiveBuffer, false)
            if (bytesRead > 0) {
                mEmulator!!.append(mReceiveBuffer, bytesRead)
                notifyScreenUpdate()
            }
            if (msg.what == MSG_PROCESS_EXITED) {
                val exitCode = msg.obj as Int
                cleanupResources(exitCode)
                var exitDescription = "\r\n[Process completed"
                if (exitCode > 0) {
                    // Non-zero process exit.
                    exitDescription += " (code $exitCode)"
                } else if (exitCode < 0) {
                    // Negated signal.
                    exitDescription += " (signal " + -exitCode + ")"
                }
                exitDescription += "]"
                val bytesToWrite = exitDescription.toByteArray(StandardCharsets.UTF_8)
                mEmulator!!.append(bytesToWrite, bytesToWrite.size)
                notifyScreenUpdate()
                mClient.onSessionFinished(this@BabaTerminalSession)
            }
        }
    }

    companion object {
        private const val MSG_NEW_INPUT = 1
        private const val MSG_PROCESS_EXITED = 4
    }
}