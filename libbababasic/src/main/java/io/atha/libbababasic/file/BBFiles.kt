package io.atha.libbababasic.file

import io.atha.libbababasic.error.RuntimeError
import io.atha.libbababasic.file.BBFile.FileAccessMode
import io.atha.libbababasic.file.BBFile.FileOpenMode
import io.atha.libbababasic.runtime.Environment

class BBFiles(@JvmField val sys: BBUIFile, val env: Environment) {
    private val files: MutableMap<Int, BBFile> = mutableMapOf()

    // write a function that asks the user for a folder to use as the root for storage
    fun getMappedPath(x: String): String {
        return env.getStorageFolder() + "/" + x
    }

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
                    getMappedPath(filename),
                    accessMode!!,
                    recordLen
                )
            }

            FileOpenMode.INPUT -> {
                BBSequentialAccessInputFile(getMappedPath(filename) + filename)
            }

            FileOpenMode.OUTPUT -> {
                BBSequentialAccessOutputFile(getMappedPath(filename), false)
            }

            else -> {
                BBSequentialAccessOutputFile(getMappedPath(filename), true)
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