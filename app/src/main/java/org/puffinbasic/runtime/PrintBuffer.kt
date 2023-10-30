package org.puffinbasic.runtime

import it.unimi.dsi.fastutil.bytes.ByteArrayList
import it.unimi.dsi.fastutil.bytes.ByteList
import org.puffinbasic.file.PuffinBasicFile

class PrintBuffer {
    private val buffer: ByteList
    private var cursor = 0

    init {
        buffer = ByteArrayList()
    }

    fun appendAtCursor(value: String) {
        for (i in buffer.size until cursor + value.length) {
            buffer.add(SPACE)
        }
        for (element in value) {
            buffer[cursor++] = element.code.toByte()
        }
    }

    fun flush(file: PuffinBasicFile) {
        for (i in buffer.indices) {
            file.writeByte(buffer.getByte(i))
        }
        for (i in buffer.indices) {
            buffer[i] = SPACE
        }
        buffer.clear()
        cursor = 0
    }

    companion object {
        private const val SPACE = ' '.code.toByte()
    }
}