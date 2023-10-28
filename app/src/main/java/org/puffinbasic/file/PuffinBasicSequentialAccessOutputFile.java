package org.puffinbasic.file;

import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.IO_ERROR;

import com.google.common.base.Preconditions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.puffinbasic.domain.PuffinBasicSymbolTable;
import org.puffinbasic.error.PuffinBasicRuntimeError;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import it.unimi.dsi.fastutil.ints.IntList;

public class PuffinBasicSequentialAccessOutputFile implements PuffinBasicFile {

    private final String filename;
    private final PrintStream out;
    private long bytesAccessed;
    private PuffinBasicFile.FileState fileState;
    private String lastLine;

    public PuffinBasicSequentialAccessOutputFile(
            @NotNull String filename, boolean append) {
        Preconditions.checkNotNull(filename);

        this.filename = filename;
        this.bytesAccessed = 0;

        try {
            this.out = new PrintStream(new BufferedOutputStream(new FileOutputStream(filename, append)));
        } catch (FileNotFoundException e) {
            throw new PuffinBasicRuntimeError(
                    IO_ERROR,
                    "Failed to open file '" + filename + "' for writing, error: "
                            + e.getMessage()
            );
        }

        this.fileState = PuffinBasicFile.FileState.OPEN;
    }

    @Override
    public void setFieldParams(PuffinBasicSymbolTable symbolTable, IntList recordParts) {
        throw getIllegalAccess();
    }

    @Override
    public int getCurrentRecordNumber() {
        return (int) (bytesAccessed / PuffinBasicFile.DEFAULT_RECORD_LEN);
    }

    @Override
    public long getFileSizeInBytes() {
        return 0;
    }

    @Override
    public String readLine() {
        throw getIllegalAccess();
    }

    @Override
    public byte[] readBytes(int n) {
        throw getIllegalAccess();
    }

    @Override
    public void print(String s) {
        bytesAccessed += s.length();
        out.print(s);
    }

    @Override
    public void writeByte(byte b) {
        bytesAccessed++;
        try {
            out.write((char) b);
        } catch (Exception e) {
            throw new PuffinBasicRuntimeError(
                    IO_ERROR,
                    "Failed to write buffer to output, error: " + e.getMessage()
            );
        }
    }

    @Override
    public boolean eof() {
        return false;
    }

    @Override
    public void put(@Nullable Integer recordNumber, PuffinBasicSymbolTable symbolTable) {
        throw getIllegalAccess();
    }

    @Override
    public void get(@Nullable Integer recordNumber, PuffinBasicSymbolTable symbolTable) {
        throw getIllegalAccess();
    }

    private PuffinBasicRuntimeError getIllegalAccess() {
        return new PuffinBasicRuntimeError(
                ILLEGAL_FILE_ACCESS,
                "Not implemented for SequentialAccessOutputFile!"
        );
    }

    @Override
    public boolean isOpen() {
        return fileState == PuffinBasicFile.FileState.OPEN;
    }

    @Override
    public void close() {
        assertOpen();
        try {
            this.out.close();
        } catch (Exception e) {
            throw new PuffinBasicRuntimeError(
                    IO_ERROR,
                    "Failed to close file '" + filename + "', error: " + e.getMessage()
            );
        }
        this.fileState = PuffinBasicFile.FileState.CLOSED;
    }

    private void assertOpen() {
        if (!isOpen()) {
            throw new PuffinBasicRuntimeError(
                    ILLEGAL_FILE_ACCESS,
                    "File " + filename + " is not open!"
            );
        }
    }
}
