package io.atha.libbababasic.file

import io.atha.libbababasic.domain.SymbolTable
import io.atha.libbababasic.error.RuntimeError
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.PrintStream
import java.nio.charset.StandardCharsets

class SystemInputOutputFile(
    `in`: InputStream?,
    private val out: PrintStream
) : BBUIFile {
    private val `in`: BufferedReader

    init {
        this.`in` = BufferedReader(InputStreamReader(`in`))
    }

    override fun inputDialog(prompt: String): String? {
        // TODO: print prompt
        return readLine()
    }

    override fun peekHasChar(): Boolean {
        return `in`.ready()
    }

    override fun takeInputChar(): Char? {
        return null
    }

    override fun outputText(text: String) {
        out.print(text)
    }

    override fun setFieldParams(symbolTable: SymbolTable, recordParts: List<Int>) {
        throw RuntimeError(
            RuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not supported for System IN/OUT!"
        )
    }

    override val currentRecordNumber: Int
        get() = 0
    override val fileSizeInBytes: Long
        get() = 0

    override fun readBytes(n: Int): ByteArray {
        val line = readLine()!!.toByteArray(StandardCharsets.US_ASCII)
        return if (n >= line.size) {
            line
        } else {
            val copy = ByteArray(Math.min(n, line.size))
            System.arraycopy(line, 0, copy, 0, n)
            copy
        }
    }

    override fun readLine(): String? {
        return try {
            `in`.readLine().stripTrailing()
        } catch (e: IOException) {
            throw RuntimeError(
                RuntimeError.ErrorCode.IO_ERROR,
                "Failed to read line!"
            )
        }
    }

    override fun print(s: String) {
        out.print(s)
    }

    override fun writeByte(b: Byte) {
        try {
            out.write(Char(b.toUShort()).code)
        } catch (e: Exception) {
            throw RuntimeError(
                RuntimeError.ErrorCode.IO_ERROR,
                "Failed to write buffer to output, error: " + e.message
            )
        }
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
        throw RuntimeError(
            RuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not supported for System IN/OUT!"
        )
    }
}