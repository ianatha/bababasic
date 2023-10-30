package org.puffinbasic.file

import com.google.common.base.Preconditions
import org.puffinbasic.domain.PuffinBasicSymbolTable
import org.puffinbasic.error.PuffinBasicRuntimeError
import java.io.BufferedOutputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.PrintStream

class PuffinBasicSequentialAccessOutputFile(
    filename: String, append: Boolean
) : PuffinBasicFile {
    private val filename: String
    private var out: PrintStream? = null
    private var bytesAccessed: Long
    private var fileState: PuffinBasicFile.FileState
    private val lastLine: String? = null

    init {
        Preconditions.checkNotNull(filename)
        this.filename = filename
        bytesAccessed = 0
        try {
            out = PrintStream(BufferedOutputStream(FileOutputStream(filename, append)))
        } catch (e: FileNotFoundException) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
                "Failed to open file '" + filename + "' for writing, error: "
                        + e.message
            )
        }
        fileState = PuffinBasicFile.FileState.OPEN
    }

    override fun setFieldParams(symbolTable: PuffinBasicSymbolTable, recordParts: List<Int>) {
        throw illegalAccess
    }

    override val currentRecordNumber: Int
        get() = (bytesAccessed / PuffinBasicFile.DEFAULT_RECORD_LEN).toInt()

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
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
                "Failed to write buffer to output, error: " + e.message
            )
        }
    }

    override fun eof(): Boolean {
        return false
    }

    override fun put(recordNumber: Int, symbolTable: PuffinBasicSymbolTable) {
        throw illegalAccess
    }

    override fun get(recordNumber: Int, symbolTable: PuffinBasicSymbolTable) {
        throw illegalAccess
    }

    private val illegalAccess: PuffinBasicRuntimeError
        private get() = PuffinBasicRuntimeError(
            PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not implemented for SequentialAccessOutputFile!"
        )

    override fun isOpen(): Boolean {
        return fileState == PuffinBasicFile.FileState.OPEN
    }

    override fun close() {
        assertOpen()
        try {
            out!!.close()
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