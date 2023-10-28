package org.puffinbasic.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CodePointCharStream;

import java.util.LinkedHashSet;
import java.util.Objects;

public class PuffinBasicSourceFile {

    private final String relativePath;
    private final String libtag;
    private final String sourceCode;
    private final CharStream sourceCodeStream;
    private final LinkedHashSet<PuffinBasicSourceFile> importFiles;

    public PuffinBasicSourceFile(
            String relativePath,
            String libtag,
            String sourceCode,
            CodePointCharStream sourceCodeStream,
            LinkedHashSet<PuffinBasicSourceFile> importFiles) {
        this.relativePath = relativePath;
        this.libtag = libtag;
        this.sourceCode = sourceCode;
        this.sourceCodeStream = sourceCodeStream;
        this.importFiles = new LinkedHashSet<>(importFiles);
    }

    public LinkedHashSet<PuffinBasicSourceFile> getImportFiles() {
        return importFiles;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public String getLibtag() {
        return libtag;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public CharStream getSourceCodeStream() {
        return sourceCodeStream;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PuffinBasicSourceFile that = (PuffinBasicSourceFile) o;
        return libtag.equals(that.libtag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libtag);
    }

    @Override
    public String toString() {
        return getRelativePath();
    }
}
