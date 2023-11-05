package io.atha.libbababasic.file

import com.google.common.base.Preconditions
import io.atha.libbababasic.domain.SymbolTable
import io.atha.libbababasic.error.RuntimeError
import java.io.BufferedReader
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException
import java.nio.charset.StandardCharsets

class BBSequentialAccessInputFile(
    filename: String
) : BBFile {
    private val filename: String
    private var `in`: BufferedReader? = null
    private var bytesAccessed: Long
    private var fileState: BBFile.FileState
    private var lastLine: String? = null

    init {
        Preconditions.checkNotNull(filename)
        this.filename = filename
        bytesAccessed = 0
        try {
            `in` = BufferedReader(FileReader(filename))
        } catch (e: FileNotFoundException) {
            throw RuntimeError(
                RuntimeError.ErrorCode.IO_ERROR,
                "Failed to open file '" + filename + "' for reading, error: "
                        + e.message
            )
        }
        fileState = BBFile.FileState.OPEN
    }

    override fun setFieldParams(symbolTable: SymbolTable, recordParts: List<Int>) {
        throwIllegalAccess()
    }

    override val currentRecordNumber: Int
        get() {
            assertOpen()
            return (bytesAccessed / BBFile.DEFAULT_RECORD_LEN).toInt()
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
            throw RuntimeError(
                RuntimeError.ErrorCode.IO_ERROR,
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
            throw RuntimeError(
                RuntimeError.ErrorCode.IO_ERROR,
                "Failed to read line!, error: " + e.message
            )
        }
        return lastLine == null
    }

    override fun put(recordNumber: Int, symbolTable: SymbolTable) {
        throwIllegalAccess()
    }

    override fun get(recordNumber: Int, symbolTable: SymbolTable) {
        throwIllegalAccess()
    }

    private fun throwIllegalAccess() {
        throw RuntimeError(
            RuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not implemented for SequentialAccessInputFile!"
        )
    }

    override fun isOpen(): Boolean {
        return fileState == BBFile.FileState.OPEN
    }

    override fun close() {
        assertOpen()
        try {
            `in`!!.close()
        } catch (e: Exception) {
            throw RuntimeError(
                RuntimeError.ErrorCode.IO_ERROR,
                "Failed to close file '" + filename + "', error: " + e.message
            )
        }
        fileState = BBFile.FileState.CLOSED
    }

    private fun assertOpen() {
        if (!isOpen()) {
            throw RuntimeError(
                RuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
                "File $filename is not open!"
            )
        }
    }
}