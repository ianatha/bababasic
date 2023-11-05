package io.atha.libbababsic_android

import android.app.Activity
import io.atha.libbababasic.domain.SymbolTable
import io.atha.libbababasic.error.RuntimeError
import io.atha.libbababasic.file.BBUIFile
import io.atha.libbababasic.runtime.BabaSystem
import io.atha.utils.CircularByteBuffer
import java.io.InputStream
import java.io.OutputStream


class AndroidSystemInAndOut(private val context: Activity) : BBUIFile {
    private val bufOut = CircularByteBuffer(4096)
    private val bufIn = CircularByteBuffer(4096)

    override fun inputDialog(prompt: String): String {
        var result: StringBuffer = StringBuffer()
        do {
            val c = takeInputCharBlocking()
            if (c == "\r") {
                break
            } else if (c.toByteArray()[0] == 127.toByte()) {
                if (result.isNotEmpty()) {
                    result.deleteCharAt(result.length - 1)
                    outputText("\b \b")
                }
            } else {
                outputText(c)
                result.append(c)
            }
        } while (c != "\r")
        outputText(BabaSystem.lineSeparator())
        return result.toString()
    }

    private fun takeInputCharBlocking(): String {
        val b = bufIn.inputStream.read()
        val c = b.toChar()
        val s = c.toString()
        return s
    }

    override fun takeInputChar(): String {
        return if (bufIn.available > 0) {
            val b = bufIn.inputStream.read()
            val c = b.toChar()
            val s = c.toString()
            s
        } else {
            ""
        }
    }

    override fun outputText(s: String) {
        bufOut.outputStream.write(s.toByteArray(Charsets.UTF_8))
    }

    override fun setFieldParams(symbolTable: SymbolTable, recordParts: List<Int>) {
        throw RuntimeError(
            RuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
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
        bufOut.outputStream.write(b.toInt())
    }

    override fun eof(): Boolean {
        return false
    }

    override fun put(recordNumber: Int, symbolTable: SymbolTable) {
        throw RuntimeError(
            RuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not supported for System IN/OUT!"
        )
    }

    override fun get(recordNumber: Int, symbolTable: SymbolTable) {
        throw RuntimeError(
            RuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not supported for System IN/OUT!"
        )
    }

    override fun isOpen(): Boolean {
        return true
    }

    override fun close() {
        bufOut.outputStream.close()
    }

    fun getStdout(): InputStream {
        return bufOut.inputStream
    }

    fun getStdin(): OutputStream {
        return bufIn.outputStream
    }
}