package io.atha.libbababsic_android

import android.app.Activity
import android.util.Log
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
            Log.i("input", "buffer: ${result.toString()}")
            val c = takeInputCharBlocking()
            Log.i("input", "c: $c")
//            , byteArraySize: ${c.toByteArray().size}, len: ${c.length}")
            if (c == '\r') {
                break
            } else if (c == 127.toChar()) {
                if (result.isNotEmpty()) {
                    result.deleteCharAt(result.length - 1)
                    outputText("\b \b")
                }
            } else {
                outputText(c.toString())
                result.append(c)
            }
        } while (c != '\r')
        outputText(BabaSystem.lineSeparator())
        return result.toString()
    }

    private fun takeInputCharBlocking(): Char {
        val mask1Byte = 0b10000000
        val mask2Byte = 0b11000000
        val mask3Byte = 0b11100000
        val mask4Byte = 0b11110000

        val b1 = bufIn.inputStream.read()
        return when {
            b1 and mask1Byte == 0 -> b1.toChar()
            b1 and mask2Byte == mask2Byte && b1 and 0b00100000 == 0 -> readMultiByteChar(b1, 2)
            b1 and mask3Byte == mask3Byte && b1 and 0b00010000 == 0 -> readMultiByteChar(b1, 3)
            b1 and mask4Byte == mask4Byte && b1 and 0b00001000 == 0 -> readMultiByteChar(b1, 4)
            else -> throw RuntimeException("Invalid UTF-8 byte: $b1")
        }
    }

    private fun readMultiByteChar(firstByte: Int, totalBytes: Int): Char {
        val bytes = ByteArray(totalBytes)
        bytes[0] = firstByte.toByte()
        for (i in 1 until totalBytes) {
            bytes[i] = bufIn.inputStream.read().toByte()
        }
        return String(bytes, Charsets.UTF_8).first()
    }

    override fun takeInputChar(): Char? {
        return if (bufIn.available > 0) {
            takeInputCharBlocking()
        } else {
            null
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