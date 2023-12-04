package io.atha.libbababasic.file

import io.atha.libbababasic.error.RuntimeError
import io.atha.libbababasic.file.BBFile.FileAccessMode
import io.atha.libbababasic.file.BBFile.FileOpenMode
import io.atha.libbababasic.runtime.Environment
import java.nio.file.FileVisitOption
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.PathWalkOption

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
                BBSequentialAccessInputFile(getMappedPath(filename))
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

    fun kill(filespec: String) {
        // TODO: implement
        // delete files from the storage folder that match filespec
        val storageFolder = getMappedPath("")
        val matcher = FileMatcher(filespec)
        Files.walkFileTree(
            Path(storageFolder),
            setOf(FileVisitOption.FOLLOW_LINKS),
            Int.MAX_VALUE,
            matcher
        )

        matcher.matchedFiles.forEach { file ->
            try {
                Files.delete(file)
                println("Deleted file: $file")
            } catch (e: Exception) {
                println("Failed to delete file: $file")
                e.printStackTrace()
            }
        }
    }
}

class FileMatcher(private val spec: String) : SimpleFileVisitor<Path>() {
    val matchedFiles = mutableListOf<Path>()

    override fun visitFile(file: Path?, attrs: BasicFileAttributes?): FileVisitResult {
        if (file != null && Files.isRegularFile(file) && matchesSpec(file.fileName.toString(), spec)) {
            matchedFiles.add(file)
        }
        return FileVisitResult.CONTINUE
    }
}

fun matchesSpec(fileName: String, spec: String): Boolean {
    return fileName.matches(spec.replace(".", "\\.").replace("*", ".*").toRegex())
}

