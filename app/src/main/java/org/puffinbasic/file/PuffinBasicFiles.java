package org.puffinbasic.file;

import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS;

import org.puffinbasic.error.PuffinBasicRuntimeError;
import org.puffinbasic.file.PuffinBasicFile.FileAccessMode;
import org.puffinbasic.file.PuffinBasicFile.FileOpenMode;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

public class PuffinBasicFiles {

    public final PuffinBasicFile sys;
    private final Int2ObjectMap<PuffinBasicFile> files;

    public PuffinBasicFiles(PuffinBasicFile sys) {
        this.files = new Int2ObjectOpenHashMap<>();
        this.sys = sys;
    }

    public PuffinBasicFile open(
            int fileNumber,
            String filename,
            FileOpenMode openMode,
            FileAccessMode accessMode,
            int recordLen) {
        assertPositiveFileNumber(fileNumber);
        PuffinBasicFile file;
        if (openMode == FileOpenMode.RANDOM) {
            file = new PuffinBasicRandomAccessFile(
                    filename,
                    accessMode,
                    recordLen
            );
        } else if (openMode == FileOpenMode.INPUT) {
            file = new PuffinBasicSequentialAccessInputFile(filename);
        } else if (openMode == FileOpenMode.OUTPUT) {
            file = new PuffinBasicSequentialAccessOutputFile(filename, false);
        } else {
            file = new PuffinBasicSequentialAccessOutputFile(filename, true);
        }

        var existing = files.get(fileNumber);
        if (existing != null && existing.isOpen()) {
            throw new PuffinBasicRuntimeError(
                    ILLEGAL_FILE_ACCESS,
                    "FileNumber: " + fileNumber
                            + " is already open, cannot open another file: "
                            + filename + " with same file number."
            );
        }

        files.put(fileNumber, file);
        return file;
    }

    private void assertPositiveFileNumber(int fileNumber) {
        if (fileNumber < 0) {
            throw new PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM,
                    "File number: " + fileNumber + " cannot be negative"
            );
        }
    }

    public PuffinBasicFile get(int fileNumber) {
        assertPositiveFileNumber(fileNumber);
        var file = files.get(fileNumber);
        if (file == null) {
            throw new PuffinBasicRuntimeError(
                    ILLEGAL_FILE_ACCESS,
                    "Failed to find file for fileNumber: " + fileNumber
            );
        }
        return file;
    }

    public void closeAll() {
        for (var file : files.values()) {
            if (file.isOpen()) {
                file.close();
            }
        }
    }
}
