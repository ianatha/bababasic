package org.puffinbasic.file

import com.google.common.base.Preconditions
import org.puffinbasic.domain.PuffinBasicSymbolTable
import org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId
import org.puffinbasic.error.PuffinBasicInternalError
import org.puffinbasic.error.PuffinBasicRuntimeError
import org.puffinbasic.file.PuffinBasicFile.FileAccessMode
import java.io.FileNotFoundException
import java.io.IOException
import java.io.RandomAccessFile
import java.nio.ByteBuffer
import java.util.Arrays

class PuffinBasicRandomAccessFile(
    filename: String,
    accessMode: FileAccessMode,
    recordLen: Int
) : PuffinBasicFile {
    private val filename: String
    private val accessMode: FileAccessMode
    private var file: RandomAccessFile? = null
    private val recordLength: Int
    private val recordBuffer: ByteArray
    private var recordParts: MutableList<Int> = mutableListOf()
    private var currentFilePosBytes: Long
    private var lastGetRecordNumber: Int
    private var lastPutRecordNumber: Int
    private var fileState: PuffinBasicFile.FileState

    init {
        Preconditions.checkNotNull(filename)
        Preconditions.checkArgument(recordLen > 0)
        Preconditions.checkNotNull(accessMode)
        this.filename = filename
        this.accessMode = accessMode
        recordLength = recordLen
        recordBuffer = ByteArray(recordLength)
        lastGetRecordNumber = -1
        lastPutRecordNumber = lastGetRecordNumber
        currentFilePosBytes = 0
        try {
            file = RandomAccessFile(filename, accessMode.mode)
        } catch (e: FileNotFoundException) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
                "Failed to open file '" + filename + "' for writing, error: "
                        + e.message
            )
        }
        fileState = PuffinBasicFile.FileState.OPEN
    }

    override fun setFieldParams(
        symbolTable: PuffinBasicSymbolTable,
        recordParts: List<Int>
    ) {
        Preconditions.checkNotNull(symbolTable)
        Preconditions.checkNotNull(recordParts)
        var totalComputedLength = 0
        for (recordPart in recordParts) {
            val entry = symbolTable[recordPart]!!
            val value = entry.value
            val dataType = entry.type!!.atomTypeId
            if (dataType !== PuffinBasicAtomTypeId.STRING) {
                throw PuffinBasicInternalError(
                    "Expected String recordPart but found: $dataType"
                )
            }
            totalComputedLength += value!!.fieldLength
        }
        if (totalComputedLength != recordLength) {
            throw PuffinBasicInternalError(
                "Sum of capacity of recordParts (=" + totalComputedLength
                        + ") don't match recordLength (=" + recordLength + ")"
            )
        }
        this.recordParts = recordParts.toMutableList()
    }

    override val currentRecordNumber: Int
        get() {
            assertOpen()
            return (currentFilePosBytes / recordLength).toInt()
        }

    override val fileSizeInBytes: Long
        get() {
            assertOpen()
            return try {
                file!!.length()
            } catch (e: IOException) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
                    "Failed to get length of the file '" + filename
                            + "', error: " + e.message
                )
            }
        }

    override fun eof(): Boolean {
        return currentFilePosBytes >= fileSizeInBytes
    }

    override fun put(recordNumber: Int, symbolTable: PuffinBasicSymbolTable) {
        var recordNumber = recordNumber
        assertOpen()
        if (accessMode == FileAccessMode.READ_ONLY) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
                "File $filename is open for read-only"
            )
        }
        if (recordNumber == null) {
            recordNumber = lastPutRecordNumber + 1
        }
        seekToRecord(recordNumber)
        lastPutRecordNumber = recordNumber

        // Create a new buffer and fill with spaces.
        val bb = clearAndGetRecordBuffer()
        for (i in recordParts.indices) {
            val entry = symbolTable[recordParts[i]]!!.value!!
            var value = entry.string!!
            val valueLength = value.length
            val fieldLength = entry.fieldLength

            // Put first fieldLength bytes only
            if (fieldLength < valueLength) {
                value = value.substring(0, fieldLength)
            }
            bb.put(value.toByteArray())

            // If fieldLength > valueLength, skip fieldLength - valueLength
            if (fieldLength > valueLength) {
                bb.position(bb.position() + fieldLength - valueLength)
            }
        }

        // Write the record buffer to file
        try {
            file!!.write(recordBuffer)
        } catch (e: IOException) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
                "Failed to write to file '" + filename + "', error: " + e.message
            )
        }
        updateCurrentBytePos()
    }

    override fun get(recordNumber: Int, symbolTable: PuffinBasicSymbolTable) {
        var recordNumber = recordNumber
        assertOpen()
        if (accessMode == FileAccessMode.WRITE_ONLY) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
                "File $filename is open for write-only"
            )
        }
        if (recordNumber == null) {
            recordNumber = lastGetRecordNumber + 1
        }
        seekToRecord(recordNumber)
        lastGetRecordNumber = recordNumber

        // Seek to record number and read the record into record buffer
        try {
            file!!.readFully(recordBuffer)
        } catch (e: IOException) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
                "Failed to read from file '" + filename
                        + ", recordNumber: " + recordNumber
                        + "', error: " + e.message
            )
        }
        val bb = ByteBuffer.wrap(recordBuffer)
        for (i in recordParts.indices) {
            val entry = symbolTable[recordParts[i]]!!.value!!
            val fieldLength = entry.fieldLength
            val strBytes = ByteArray(fieldLength)
            bb[strBytes]
            entry.string = String(strBytes)
        }
        updateCurrentBytePos()
    }

    private fun clearAndGetRecordBuffer(): ByteBuffer {
        Arrays.fill(recordBuffer, 0, recordBuffer.size, ' '.code.toByte())
        return ByteBuffer.wrap(recordBuffer)
    }

    private fun updateCurrentBytePos() {
        currentFilePosBytes += recordLength.toLong()
    }

    private fun getRecordBytePos(recordNumber: Long): Long {
        return recordNumber * recordLength
    }

    private fun seekToRecord(recordNumber: Int) {
        // Seek only when record number is not sequential
        try {
            val destPosBytes = getRecordBytePos(recordNumber.toLong())
            if (destPosBytes != currentFilePosBytes) {
                file!!.seek(destPosBytes)
                currentFilePosBytes = destPosBytes
            }
        } catch (e: IOException) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
                "Failed to read from file '" + filename + "', error: " + e.message
            )
        }
    }

    private fun assertOpen() {
        if (!isOpen()) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
                "File $filename is not open!"
            )
        }
    }

    override fun isOpen(): Boolean {
        return fileState == PuffinBasicFile.FileState.OPEN
    }

    override fun close() {
        assertOpen()
        try {
            file!!.close()
        } catch (e: Exception) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
                "Failed to close file '" + filename + "', error: " + e.message
            )
        }
        fileState = PuffinBasicFile.FileState.CLOSED
    }

    override fun readBytes(n: Int): ByteArray {
        throw PuffinBasicRuntimeError(
            PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Can't read single bytes from RandomAccessFile!"
        )
    }

    override fun print(s: String) {
        throw PuffinBasicRuntimeError(
            PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not implemented for RandomAccessFile!"
        )
    }

    override fun readLine(): String {
        throw PuffinBasicRuntimeError(
            PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not implemented for RandomAccessFile!"
        )
    }

    override fun writeByte(b: Byte) {
        throw PuffinBasicRuntimeError(
            PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not implemented for RandomAccessFile!"
        )
    }
}