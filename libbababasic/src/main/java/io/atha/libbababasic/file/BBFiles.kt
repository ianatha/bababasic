package io.atha.libbababasic.file

import io.atha.libbababasic.error.RuntimeError
import io.atha.libbababasic.file.BBFile.FileAccessMode
import io.atha.libbababasic.file.BBFile.FileOpenMode

class BBFiles(@JvmField val sys: BBUIFile) {
    private val files: MutableMap<Int, BBFile> = mutableMapOf()

    fun open(
        fileNumber: Int,
        filename: String,
        openMode: FileOpenMode,
        accessMode: FileAccessMode?,
        recordLen: Int
    ): BBFile {
        assertPositiveFileNumber(fileNumber)
        val file: BBFile = when (openMode) {
            FileOpenMode.RANDOM -> {
                BBRandomAccessFile(
                    filename,
                    accessMode!!,
                    recordLen
                )
            }

            FileOpenMode.INPUT -> {
                BBSequentialAccessInputFile(filename)
            }

            FileOpenMode.OUTPUT -> {
                BBSequentialAccessOutputFile(filename, false)
            }

            else -> {
                BBSequentialAccessOutputFile(filename, true)
            }
        }
        val existing = files[fileNumber]
        if (existing != null && existing.isOpen()) {
            throw RuntimeError(
                RuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
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
            throw RuntimeError(
                RuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM,
                "File number: $fileNumber cannot be negative"
            )
        }
    }

    operator fun get(fileNumber: Int): BBFile {
        assertPositiveFileNumber(fileNumber)
        return files[fileNumber]
            ?: throw RuntimeError(
                RuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
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