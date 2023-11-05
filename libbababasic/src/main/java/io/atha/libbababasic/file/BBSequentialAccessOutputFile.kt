package io.atha.libbababasic.file

import com.google.common.base.Preconditions
import io.atha.libbababasic.domain.SymbolTable
import io.atha.libbababasic.error.RuntimeError
import java.io.BufferedOutputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.PrintStream

class BBSequentialAccessOutputFile(
    filename: String, append: Boolean
) : BBFile {
    private val filename: String
    private var out: PrintStream? = null
    private var bytesAccessed: Long
    private var fileState: BBFile.FileState
    private val lastLine: String? = null

    init {
        Preconditions.checkNotNull(filename)
        this.filename = filename
        bytesAccessed = 0
        try {
            out = PrintStream(BufferedOutputStream(FileOutputStream(filename, append)))
        } catch (e: FileNotFoundException) {
            throw RuntimeError(
                RuntimeError.ErrorCode.IO_ERROR,
                "Failed to open file '" + filename + "' for writing, error: "
                        + e.message
            )
        }
        fileState = BBFile.FileState.OPEN
    }

    override fun setFieldParams(symbolTable: SymbolTable, recordParts: List<Int>) {
        throw illegalAccess
    }

    override val currentRecordNumber: Int
        get() = (bytesAccessed / BBFile.DEFAULT_RECORD_LEN).toInt()

    override val fileSizeInBytes: Long
        get() = 0

    override fun readLine(): String {
        throw illegalAccess
    }

    override fun readBytes(n: Int): ByteArray {
        throw illegalAccess
    }

    override fun print(s: String) {
        bytesAccessed += s.length.toLong()
        out!!.print(s)
    }

    override fun writeByte(b: Byte) {
        bytesAccessed++
        try {
            out!!.write(Char(b.toUShort()).code)
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
        throw illegalAccess
    }

    override fun get(recordNumber: Int, symbolTable: SymbolTable) {
        throw illegalAccess
    }

    private val illegalAccess: RuntimeError
        private get() = RuntimeError(
            RuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not implemented for SequentialAccessOutputFile!"
        )

    override fun isOpen(): Boolean {
        return fileState == BBFile.FileState.OPEN
    }

    override fun close() {
        assertOpen()
        try {
            out!!.close()
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