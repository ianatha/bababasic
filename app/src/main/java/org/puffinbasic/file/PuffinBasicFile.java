package org.puffinbasic.file;

import org.jetbrains.annotations.Nullable;
import org.puffinbasic.domain.PuffinBasicSymbolTable;

import it.unimi.dsi.fastutil.ints.IntList;

public interface PuffinBasicFile {

    int DEFAULT_RECORD_LEN = 128;

    void setFieldParams(
            PuffinBasicSymbolTable symbolTable,
            IntList recordParts
    );

    int getCurrentRecordNumber();

    long getFileSizeInBytes();

    String readLine();

    byte[] readBytes(int n);

    void print(String s);

    void writeByte(byte b);

    boolean eof();

    void put(@Nullable Integer recordNumber, PuffinBasicSymbolTable symbolTable);

    void get(@Nullable Integer recordNumber, PuffinBasicSymbolTable symbolTable);

    boolean isOpen();

    void close();

    enum FileOpenMode {
        INPUT,
        OUTPUT,
        APPEND,
        RANDOM
    }

    enum FileAccessMode {
        READ_ONLY("r"),
        WRITE_ONLY("w"),
        READ_WRITE("rw");

        public final String mode;

        FileAccessMode(String mode) {
            this.mode = mode;
        }
    }

    enum LockMode {
        SHARED,
        READ,
        WRITE,
        READ_WRITE,
        DEFAULT
    }

    enum FileState {
        OPEN,
        CLOSED
    }
}
