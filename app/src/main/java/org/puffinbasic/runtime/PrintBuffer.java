package org.puffinbasic.runtime;

import it.unimi.dsi.fastutil.bytes.ByteArrayList;
import it.unimi.dsi.fastutil.bytes.ByteList;
import org.puffinbasic.file.PuffinBasicFile;

public class PrintBuffer {

    private static final byte SPACE = (byte) ' ';
    private final ByteList buffer;
    private int cursor;

    public PrintBuffer() {
        this.buffer = new ByteArrayList();
    }

    public void appendAtCursor(String value) {
        for (int i = buffer.size(); i < cursor + value.length(); i++) {
            buffer.add(SPACE);
        }
        for (int i = 0; i < value.length(); i++) {
            buffer.set(cursor++, (byte) value.charAt(i));
        }
    }

    public void flush(PuffinBasicFile file) {
        for (int i = 0; i < buffer.size(); i++) {
            file.writeByte(buffer.getByte(i));
        }
        for (int i = 0; i < buffer.size(); i++) {
            buffer.set(i, SPACE);
        }
        buffer.clear();
        cursor = 0;
    }
}
