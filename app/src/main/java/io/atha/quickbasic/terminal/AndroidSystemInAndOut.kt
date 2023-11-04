package io.atha.quickbasic.terminal

import android.app.Activity
import android.app.AlertDialog
import android.text.InputType
import android.util.Log
import android.widget.EditText
import io.atha.utils.CircularByteBuffer
import org.puffinbasic.domain.PuffinBasicSymbolTable
import org.puffinbasic.error.PuffinBasicRuntimeError
import org.puffinbasic.file.PuffinUserInterfaceFile
import org.puffinbasic.runtime.BabaSystem
import java.io.InputStream
import java.io.OutputStream
import java.util.concurrent.CountDownLatch


class AndroidSystemInAndOut(private val context: Activity) : PuffinUserInterfaceFile {
    private val bufout = CircularByteBuffer(4096)
    private val bufin = CircularByteBuffer(4096)

    override fun inputDialog(prompt: String): String? {
        var result: StringBuffer = StringBuffer()
        do {
            val c = takeInputCharBlocking()
            if (c == "\r") {
                break;
            } else if (c.toByteArray()[0] == 127.toByte()) {
                if (result.isNotEmpty()) {
                    result.deleteCharAt(result.length - 1)
                    outputText("\b \b")
                }
            } else {
                outputText(c)
                result.append(c)
            }
        } while (c != "\r");
        outputText(BabaSystem.lineSeparator());
        return result.toString()
    }

    private fun takeInputCharBlocking(): String {
        val b = bufin.inputStream.read()
        val c = b.toChar()
        val s = c.toString()
        return s
    }

    override fun takeInputChar(): String {
        return if (bufin.available > 0) {
            val b = bufin.inputStream.read()
            val c = b.toChar()
            val s = c.toString()
            s
        } else {
            ""
        }
    }

    override fun outputText(s: String) {
        bufout.outputStream.write(s.toByteArray(Charsets.UTF_8))
    }

    override fun setFieldParams(symbolTable: PuffinBasicSymbolTable, recordParts: List<Int>) {
        throw PuffinBasicRuntimeError(
            PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not supported for System IN/OUT!"
        )
    }

    override fun readBytes(n: Int): ByteArray {
        TODO("Not supported")
//        val line = readLine().toByteArray(StandardCharsets.US_ASCII)
//        return if (n >= line.size) {
//            line
//        } else {
//            val copy = ByteArray(Math.min(n, line.size))
//            System.arraycopy(line, 0, copy, 0, n)
//            copy
//        }
    }

    override val currentRecordNumber: Int
        get() = 0

    override val fileSizeInBytes: Long
        get() = 0

    override fun readLine(): String {
        TODO("Not supported")
//        return try {
//            `in`.readLine().stripTrailing()
//        } catch (e: IOException) {
//            throw PuffinBasicRuntimeError(
//                PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
//                "Failed to read line!"
//            )
//        }
    }

    override fun print(s: String) {
        outputText(s)
//        out.print(s)
    }

//    private val buf = StringBuilder()

    override fun writeByte(b: Byte) {
        bufout.outputStream.write(b.toInt())
    }

    override fun eof(): Boolean {
        return false
    }

    override fun put(recordNumber: Int, symbolTable: PuffinBasicSymbolTable) {
        throw PuffinBasicRuntimeError(
            PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not supported for System IN/OUT!"
        )
    }

    override fun get(recordNumber: Int, symbolTable: PuffinBasicSymbolTable) {
        throw PuffinBasicRuntimeError(
            PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not supported for System IN/OUT!"
        )
    }

    override fun isOpen(): Boolean {
        return true
    }

    override fun close() {
        bufout.outputStream.close()
    }

    fun getStdout(): InputStream {
        return bufout.inputStream
    }

    fun getStdin(): OutputStream {
        return bufin.outputStream
    }
}