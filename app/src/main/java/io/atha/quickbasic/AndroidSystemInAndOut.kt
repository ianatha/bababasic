package io.atha.quickbasic

import android.util.Log
import io.github.rosemoe.sora.widget.CodeEditor
import it.unimi.dsi.fastutil.ints.IntList
import org.puffinbasic.domain.PuffinBasicSymbolTable
import org.puffinbasic.error.PuffinBasicRuntimeError
import org.puffinbasic.file.PuffinBasicFile
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintStream
import java.lang.StringBuilder
import java.nio.charset.StandardCharsets

public class AndroidSystemInAndOut(val editor: CodeEditor) : PuffinBasicFile {
    private val `in`: BufferedReader
    private val out: PrintStream

    init {
        this.`in` = BufferedReader(InputStreamReader(System.`in`))
        this.out = System.out

        editor.setText(editor.text.toString() + "\n\nREM --- OUTPUT START\n")
    }

    override fun setFieldParams(symbolTable: PuffinBasicSymbolTable, recordParts: IntList) {
        throw PuffinBasicRuntimeError(
            PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not supported for System IN/OUT!"
        )
    }

    override fun getCurrentRecordNumber(): Int {
        return 0
    }

    override fun getFileSizeInBytes(): Long {
        return 0
    }

    override fun readBytes(n: Int): ByteArray {
        val line = readLine().toByteArray(StandardCharsets.US_ASCII)
        return if (n >= line.size) {
            line
        } else {
            val copy = ByteArray(Math.min(n, line.size))
            System.arraycopy(line, 0, copy, 0, n)
            copy
        }
    }

    override fun readLine(): String {
        return try {
            `in`.readLine().stripTrailing()
        } catch (e: IOException) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
                "Failed to read line!"
            )
        }
    }

    override fun print(s: String) {
        editor.setText("${editor.text}REM $s\n")
        out.print(s)
    }

    private val buf = StringBuilder()

    override fun writeByte(b: Byte) {
        buf.append(Char(b.toUShort()))
        var index: Int
        while (buf.indexOf('\n').also { index = it } >= 0) {
            val line = buf.substring(0, index + 1).trim() // Including the newline
            this.print(line)
            buf.delete(0, index + 1) // Remove the printed data from the buffer
        }
//        try {
//            out.write(Char(b.toUShort()).code)
//        } catch (e: Exception) {
//            throw PuffinBasicRuntimeError(
//                PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
//                "Failed to write buffer to output, error: " + e.message
//            )
//        }
    }

    override fun eof(): Boolean {
        return false
    }

    override fun put(recordNumber: Int?, symbolTable: PuffinBasicSymbolTable) {
        throw PuffinBasicRuntimeError(
            PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not supported for System IN/OUT!"
        )
    }

    override fun get(recordNumber: Int?, symbolTable: PuffinBasicSymbolTable) {
        throw PuffinBasicRuntimeError(
            PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not supported for System IN/OUT!"
        )
    }

    override fun isOpen(): Boolean {
        return true
    }

    override fun close() {
        throw PuffinBasicRuntimeError(
            PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FILE_ACCESS,
            "Not supported for System IN/OUT!"
        )
    }
}