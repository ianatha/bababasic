package io.atha.libbababasic.file

import io.atha.libbababasic.domain.SymbolTable

interface BBFile {
    fun setFieldParams(
        symbolTable: SymbolTable,
        recordParts: List<Int>
    )

    val currentRecordNumber: Int
    val fileSizeInBytes: Long
    fun readLine(): String?
    fun readBytes(n: Int): ByteArray?
    fun print(s: String)
    fun writeCodepoint(c: Int) {
        c.toChar().toString().toByteArray(Charsets.UTF_8).forEach { writeByte(it) }
    }
    fun writeByte(b: Byte)
    fun eof(): Boolean
    fun put(recordNumber: Int, symbolTable: SymbolTable)
    operator fun get(recordNumber: Int, symbolTable: SymbolTable)
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

