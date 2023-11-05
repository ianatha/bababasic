package org.puffinbasic.file

import org.puffinbasic.error.PuffinBasicRuntimeError
import org.puffinbasic.file.PuffinBasicFile.FileAccessMode
import org.puffinbasic.file.PuffinBasicFile.FileOpenMode

class PuffinBasicFiles(@JvmField val sys: PuffinUserInterfaceFile) {
    private val files: MutableMap<Int, PuffinBasicFile> = mutableMapOf()

    fun open(
        fileNumber: Int,
        filename: String,
        openMode: FileOpenMode,
        accessMode: FileAccessMode?,
        recordLen: Int
    ): PuffinBasicFile {
        assertPositiveFileNumber(fileNumber)
        val file: PuffinBasicFile = when (openMode) {
            FileOpenMode.RANDOM -> {
                PuffinBasicRandomAccessFile(
                    filename,
                    accessMode!!,
                    recordLen
                )
            }

            FileOpenMode.INPUT -> {
                PuffinBasicSequentialAccessInputFile(filename)
            }

            FileOpenMode.OUTPUT -> {
                PuffinBasicSequentialAccessOutputFile(filename, false)
            }

            else -> {
                PuffinBasicSequentialAccessOutputFile(filename, true)
            }
        }
        val existing = files[fileNumber]
        if (existing != null && existing.isOpen()) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
                "FileNumber: " + fileNumber
                        + " is already open, cannot open another file: "
                        + filename + " with same file number."
            )
        }
        files[fileNumber] = file
        return file
    }

    private fun assertPositiveFileNumber(fileNumber: Int) {
        if (fileNumber < 0) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM,
                "File number: $fileNumber cannot be negative"
            )
        }
    }

    operator fun get(fileNumber: Int): PuffinBasicFile {
        assertPositiveFileNumber(fileNumber)
        return files[fileNumber]
            ?: throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
                "Failed to find file for fileNumber: $fileNumber"
            )
    }

    fun closeAll() {
        for (file in files.values) {
            if (file.isOpen()) {
                file.close()
            }
        }
    }
}