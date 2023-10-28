package org.puffinbasic.file;

import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.IO_ERROR;

import com.google.common.base.Preconditions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.puffinbasic.domain.PuffinBasicSymbolTable;
import org.puffinbasic.error.PuffinBasicRuntimeError;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import it.unimi.dsi.fastutil.ints.IntList;

public class PuffinBasicSequentialAccessInputFile implements PuffinBasicFile {

    private final String filename;
    private final BufferedReader in;
    private long bytesAccessed;
    private FileState fileState;
    private String lastLine;

    public PuffinBasicSequentialAccessInputFile(
            @NotNull String filename) {
        Preconditions.checkNotNull(filename);

        this.filename = filename;
        this.bytesAccessed = 0;

        try {
            this.in = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            throw new PuffinBasicRuntimeError(
                    IO_ERROR,
                    "Failed to open file '" + filename + "' for reading, error: "
                            + e.getMessage()
            );
        }

        this.fileState = FileState.OPEN;
    }

    @Override
    public void setFieldParams(PuffinBasicSymbolTable symbolTable, IntList recordParts) {
        throwIllegalAccess();
    }

    @Override
    public int getCurrentRecordNumber() {
        assertOpen();
        return (int) (bytesAccessed / PuffinBasicFile.DEFAULT_RECORD_LEN);
    }

    @Override
    public long getFileSizeInBytes() {
        assertOpen();
        return new File(filename).length();
    }

    @Override
    public String readLine() {
        assertOpen();
        try {
            if (lastLine == null) {
                lastLine = in.readLine();
            }
            bytesAccessed += lastLine.length();
            var result = lastLine.stripTrailing();
            lastLine = null;
            return result;
        } catch (IOException e) {
            throw new PuffinBasicRuntimeError(
                    IO_ERROR,
                    "Failed to read line!, error: " + e.getMessage()
            );
        }
    }

    @Override
    public byte[] readBytes(int n) {
        byte[] line = readLine().getBytes(StandardCharsets.US_ASCII);
        if (n >= line.length) {
            return line;
        } else {
            byte[] copy = new byte[Math.min(n, line.length)];
            System.arraycopy(line, 0, copy, 0, n);
            return copy;
        }
    }

    @Override
    public void print(String s) {
        throwIllegalAccess();
    }

    @Override
    public void writeByte(byte b) {
        throwIllegalAccess();
    }

    @Override
    public boolean eof() {
        assertOpen();
        try {
            this.lastLine = in.readLine();
        } catch (IOException e) {
            throw new PuffinBasicRuntimeError(
                    IO_ERROR,
                    "Failed to read line!, error: " + e.getMessage()
            );
        }
        return lastLine == null;
    }

    @Override
    public void put(@Nullable Integer recordNumber, PuffinBasicSymbolTable symbolTable) {
        throwIllegalAccess();
    }

    @Override
    public void get(@Nullable Integer recordNumber, PuffinBasicSymbolTable symbolTable) {
        throwIllegalAccess();
    }

    private void throwIllegalAccess() {
        throw new PuffinBasicRuntimeError(
                ILLEGAL_FILE_ACCESS,
                "Not implemented for SequentialAccessInputFile!"
        );
    }

    @Override
    public boolean isOpen() {
        return fileState == FileState.OPEN;
    }

    @Override
    public void close() {
        assertOpen();
        try {
            this.in.close();
        } catch (Exception e) {
            throw new PuffinBasicRuntimeError(
                    IO_ERROR,
                    "Failed to close file '" + filename + "', error: " + e.getMessage()
            );
        }
        this.fileState = FileState.CLOSED;
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
