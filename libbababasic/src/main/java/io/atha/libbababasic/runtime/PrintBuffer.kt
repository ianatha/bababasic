package io.atha.libbababasic.runtime

import io.atha.libbababasic.file.BBFile

class PrintBuffer {
    private val buffer: MutableList<Byte> = mutableListOf()
    private var cursor = 0

    fun appendAtCursor(value: String) {
        for (i in buffer.size until cursor + value.length) {
            buffer.add(SPACE)
        }
        for (element in value) {
            buffer[cursor++] = element.code.toByte()
        }
    }

    fun flush(file: BBFile) {
        for (i in buffer.indices) {
            file.writeByte(buffer[i])
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