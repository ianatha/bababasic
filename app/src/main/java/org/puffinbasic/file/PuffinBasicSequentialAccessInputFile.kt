package org.puffinbasic.file

import com.google.common.base.Preconditions
import org.puffinbasic.domain.PuffinBasicSymbolTable
import org.puffinbasic.error.PuffinBasicRuntimeError
import java.io.BufferedReader
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException
import java.nio.charset.StandardCharsets

class PuffinBasicSequentialAccessInputFile(
    filename: String
) : PuffinBasicFile {
    private val filename: String
    private var `in`: BufferedReader? = null
    private var bytesAccessed: Long
    private var fileState: PuffinBasicFile.FileState
    private var lastLine: String? = null

    init {
        Preconditions.checkNotNull(filename)
        this.filename = filename
        bytesAccessed = 0
        try {
            `in` = BufferedReader(FileReader(filename))
        } catch (e: FileNotFoundException) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
                "Failed to open file '" + filename + "' for reading, error: "
                        + e.message
            )
        }
        fileState = PuffinBasicFile.FileState.OPEN
    }

    override fun setFieldParams(symbolTable: PuffinBasicSymbolTable, recordParts: List<Int>) {
        throwIllegalAccess()
    }

    override val currentRecordNumber: Int
        get() {
            assertOpen()
            return (bytesAccessed / PuffinBasicFile.DEFAULT_RECORD_LEN).toInt()
        }

    override val fileSizeInBytes: Long
        get() {
            assertOpen()
            return File(filename).length()
        }

    override fun readLine(): String {
        assertOpen()
        return try {
            if (lastLine == null) {
                lastLine = `in`!!.readLine()
            }
            bytesAccessed += lastLine!!.length.toLong()
            val result = lastLine!!.stripTrailing()
            lastLine = null
            result
        } catch (e: IOException) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
                "Failed to read line!, error: " + e.message
            )
        }
    }

    override fun readBytes(n: Int): ByteArray {
        val line = readLine().toByteArray(StandardCharsets.US_ASCII)
        return if (n >= line.size) {
            line
        } else {
            val copy = ByteArray(Math.min(n, line.size))
            System.arraycopy(line, 0, copy, 0, n)
            copy
        }
    }

    override fun print(s: String) {
        throwIllegalAccess()
    }

    override fun writeByte(b: Byte) {
        throwIllegalAccess()
    }

    override fun eof(): Boolean {
        assertOpen()
        try {
            lastLine = `in`!!.readLine()
        } catch (e: IOException) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
                "Failed to read line!, error: " + e.message
            )
        }
        return lastLine == null
    }

    override fun put(recordNumber: Int, symbolTable: PuffinBasicSymbolTable) {
        throwIllegalAccess()
    }

    override fun get(recordNumber: Int, symbolTable: PuffinBasicSymbolTable) {
        throwIllegalAccess()
    }

    private fun throwIllegalAccess() {
        throw PuffinBasicRuntimeError(
            PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not implemented for SequentialAccessInputFile!"
        )
    }

    override fun isOpen(): Boolean {
        return fileState == PuffinBasicFile.FileState.OPEN
    }

    override fun close() {
        assertOpen()
        try {
            `in`!!.close()
        } catch (e: Exception) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
                "Failed to close file '" + filename + "', error: " + e.message
            )
        }
        fileState = PuffinBasicFile.FileState.CLOSED
    }

    private fun assertOpen() {
        if (!isOpen()) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
                "File $filename is not open!"
            )
        }
    }
}