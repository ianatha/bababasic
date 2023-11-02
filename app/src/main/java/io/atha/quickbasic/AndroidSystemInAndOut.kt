package io.atha.quickbasic

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.text.InputType
import android.util.Log
import android.widget.EditText
import org.puffinbasic.domain.PuffinBasicSymbolTable
import org.puffinbasic.error.PuffinBasicRuntimeError
import org.puffinbasic.file.PuffinBasicExtendedFile
import org.puffinbasic.runtime.BabaSystem
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.PipedInputStream
import java.io.PipedOutputStream
import java.io.PipedReader
import java.io.PipedWriter
import java.io.PrintStream
import java.nio.charset.StandardCharsets
import java.util.concurrent.CountDownLatch


class AndroidSystemInAndOut(val context: Activity) : PuffinBasicExtendedFile {
    val buf = CircularByteBuffer(4096)

    override fun inputDialog(prompt: String): String? {
        var result: String? = null
        val latch = CountDownLatch(1)
        context.runOnUiThread {
            val builder = AlertDialog.Builder(context)
            builder.setTitle(prompt)
            val input = EditText(context)
            input.inputType = InputType.TYPE_CLASS_TEXT
            builder.setView(input)
            builder.setPositiveButton(
                "OK"
            ) { _, _ ->
                result = input.text.toString()
                latch.countDown()
            }
            builder.setNegativeButton(
                "Cancel"
            ) { dialog, _ ->
                dialog.cancel()
                latch.countDown()
            }
            builder.show()
        }
        latch.await()
        outputText(" " + result!! + BabaSystem.lineSeparator())
        return result
    }

    fun outputText(s: String) {
        buf.outputStream.write(s.toByteArray(Charsets.UTF_8))
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
        buf.outputStream.write(b.toInt())
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
        throw PuffinBasicRuntimeError(
            PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not supported for System IN/OUT!"
        )
    }


    fun getStdout(): InputStream {
        return buf.inputStream
    }
}