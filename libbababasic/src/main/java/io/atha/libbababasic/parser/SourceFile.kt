package io.atha.libbababasic.parser

import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CodePointCharStream
import java.util.Objects

class SourceFile(
    val relativePath: String,
    val libtag: String?,
    @JvmField val sourceCode: String,
    sourceCodeStream: CodePointCharStream,
    importFiles: LinkedHashSet<SourceFile>?
) {
    @JvmField
    val sourceCodeStream: CharStream

    @JvmField
    val importFiles: LinkedHashSet<SourceFile>

    init {
        this.sourceCodeStream = sourceCodeStream
        this.importFiles = LinkedHashSet(importFiles)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val that = other as SourceFile
        return libtag == that.libtag
    }

    override fun hashCode(): Int {
        return Objects.hash(libtag)
    }

    override fun toString(): String {
        return relativePath
    }
}