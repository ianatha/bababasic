package org.puffinbasic.file

import org.puffinbasic.domain.PuffinBasicSymbolTable

interface PuffinBasicFile {
    fun setFieldParams(
        symbolTable: PuffinBasicSymbolTable,
        recordParts: List<Int>
    )

    val currentRecordNumber: Int
    val fileSizeInBytes: Long
    fun readLine(): String?
    fun readBytes(n: Int): ByteArray?
    fun print(s: String)
    fun writeByte(b: Byte)
    fun eof(): Boolean
    fun put(recordNumber: Int, symbolTable: PuffinBasicSymbolTable)
    operator fun get(recordNumber: Int, symbolTable: PuffinBasicSymbolTable)
    fun isOpen(): Boolean
    fun close()
    enum class FileOpenMode {
        INPUT, OUTPUT, APPEND, RANDOM
    }

    enum class FileAccessMode(@JvmField val mode: String) {
        READ_ONLY("r"), WRITE_ONLY("w"), READ_WRITE("rw")
    }

    enum class LockMode {
        SHARED, READ, WRITE, READ_WRITE, DEFAULT
    }

    enum class FileState {
        OPEN, CLOSED
    }

    companion object {
        const val DEFAULT_RECORD_LEN = 128
    }
}

interface PuffinBasicExtendedFile : PuffinBasicFile {
    fun inputDialog(prompt: String): String?
}
