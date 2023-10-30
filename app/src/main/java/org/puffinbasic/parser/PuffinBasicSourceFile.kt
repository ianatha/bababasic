package org.puffinbasic.parser

import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CodePointCharStream
import java.util.Objects

class PuffinBasicSourceFile(
    val relativePath: String,
    val libtag: String?,
    @JvmField val sourceCode: String,
    sourceCodeStream: CodePointCharStream,
    importFiles: LinkedHashSet<PuffinBasicSourceFile>?
) {
    @JvmField
    val sourceCodeStream: CharStream

    @JvmField
    val importFiles: LinkedHashSet<PuffinBasicSourceFile>

    init {
        this.sourceCodeStream = sourceCodeStream
        this.importFiles = LinkedHashSet(importFiles)
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as PuffinBasicSourceFile
        return libtag == that.libtag
    }

    override fun hashCode(): Int {
        return Objects.hash(libtag)
    }

    override fun toString(): String {
        return relativePath
    }
}