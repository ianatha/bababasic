package io.atha.libbababasic.parser

import io.atha.libbababasic.error.RuntimeError
import java.io.File
import java.nio.file.Paths
import java.util.Arrays
import java.util.stream.Collectors

class ImportPath(mainPath: String?) {
    private val mainModulePath: String?
    private val searchPaths: List<String>

    init {
        mainModulePath = if (mainPath != null) File(mainPath).parent else "."
        searchPaths = getSearchPaths()
    }

    private fun getSearchPaths(): List<String> {
        val searchPaths: MutableList<String> = ArrayList()
        val paths = System.getenv(PUFFIN_BASIC_PATH_ENVVAR)
        if (paths != null) {
            searchPaths.addAll(
                Arrays.stream(
                    paths.split(File.pathSeparator.toRegex()).dropLastWhile { it.isEmpty() }
                        .toTypedArray()).collect(Collectors.toList()))
        }
        mainModulePath?.let { searchPaths.add(it) }
        return searchPaths
    }

    fun find(relativePath: String): String {
        for (searchPath in searchPaths) {
            val file = Paths.get(searchPath, relativePath).toFile()
            if (file.exists()) {
                return file.path
            }
        }
        throw RuntimeError(
            RuntimeError.ErrorCode.IMPORT_ERROR,
            "Search failed for relative path: $relativePath"
        )
    }

    companion object {
        private const val PUFFIN_BASIC_PATH_ENVVAR = "PUFFIN_BASIC_PATH"
    }
}