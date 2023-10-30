package org.puffinbasic.parser

import com.google.common.base.Preconditions
import it.unimi.dsi.fastutil.ints.Int2ObjectAVLTreeMap
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.misc.Interval
import org.puffinbasic.antlr4.PuffinBasicBaseListener
import org.puffinbasic.antlr4.PuffinBasicParser.ElsestmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.GosubstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.GotostmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.ImportstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.LibtagstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.LineContext
import org.puffinbasic.antlr4.PuffinBasicParser.ThenContext
import org.puffinbasic.error.PuffinBasicRuntimeError
import org.puffinbasic.error.PuffinBasicSyntaxError
import org.puffinbasic.runtime.Types
import java.util.SortedMap
import java.util.concurrent.atomic.AtomicInteger

class LinenumberListener(
    input: CharStream,
    throwOnDuplicate: ThrowOnDuplicate
) : PuffinBasicBaseListener() {
    private val linenumGenerator: AtomicInteger = AtomicInteger()
    private val input: CharStream
    private val throwOnDuplicate: ThrowOnDuplicate
    private val sortedLines: SortedMap<Int, String>
    private val importFiles: MutableSet<String>
    private var numLinenum = 0
    private var numNoLinenum = 0
    private var numStmtWithLinenum = 0
    var libtag: String? = null
        private set

    init {
        this.input = Preconditions.checkNotNull(input)
        this.throwOnDuplicate = Preconditions.checkNotNull(throwOnDuplicate)
        sortedLines = Int2ObjectAVLTreeMap()
        importFiles = LinkedHashSet()
    }

    fun hasLineNumbers(): Boolean {
        return numLinenum > 0
    }

    val sortedCode: String
        get() {
            checkLinenumberMode()
            return java.lang.String.join("", sortedLines.values)
        }

    fun getImportFiles(): Set<String> {
        return importFiles
    }

    private fun checkLinenumberMode() {
        if (numLinenum > 0 && numNoLinenum > 0) {
            throw PuffinBasicSyntaxError(
                "Cannot mix linenumber and no-linenumber mode!"
            )
        }
        if (numNoLinenum > 0) {
            if (numStmtWithLinenum > 0) {
                throw PuffinBasicSyntaxError(
                    "GOTO/GOSUB/RETURN linenumber cannot be used in no-linenumber mode!"
                )
            }
        }
    }

    override fun exitLine(ctx: LineContext) {
        val line = input.getText(Interval(ctx.start.startIndex, ctx.stop.stopIndex))
        val linenum: Int
        if (line.isBlank()) {
            return
        }
        if (ctx.linenum() != null) {
            linenum = parseLinenum(ctx.linenum().DECIMAL().text)
            numLinenum++
        } else {
            linenum = linenumGenerator.incrementAndGet()
            numNoLinenum++
        }
        val oldLine = sortedLines.put(linenum, line)
        if (oldLine != null) {
            val message = "Duplicate line number!" + System.lineSeparator() +
                    "OLD:" + System.lineSeparator() +
                    oldLine +
                    "NEW:" + System.lineSeparator() +
                    line
            if (throwOnDuplicate == ThrowOnDuplicate.THROW) {
                throw PuffinBasicSyntaxError(message)
            } else {
                System.err.println(message)
            }
        }
    }

    override fun exitGosubstmt(ctx: GosubstmtContext) {
        numStmtWithLinenum++
    }

    override fun exitGotostmt(ctx: GotostmtContext) {
        numStmtWithLinenum++
    }

    override fun exitThen(ctx: ThenContext) {
        if (ctx.linenum() != null) {
            numStmtWithLinenum++
        }
    }

    override fun exitElsestmt(ctx: ElsestmtContext) {
        if (ctx.linenum() != null) {
            numStmtWithLinenum++
        }
    }

    override fun exitImportstmt(ctx: ImportstmtContext) {
        val filename = Types.unquote(ctx.filename.STRING().text)!!
        importFiles.add(filename)
    }

    override fun exitLibtagstmt(ctx: LibtagstmtContext) {
        val tag = Types.unquote(ctx.tag.STRING().text)
        libtag = if (libtag == null) {
            tag
        } else {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.IMPORT_ERROR,
                "Multiple libtags found: $tag, previous: $libtag"
            )
        }
    }

    enum class ThrowOnDuplicate {
        THROW, LOG
    }

    companion object {
        @JvmStatic
        fun parseLinenum(txt: String): Int {
            return try {
                txt.toInt()
            } catch (e: NumberFormatException) {
                throw PuffinBasicSyntaxError("Bad line number: '$txt'")
            }
        }
    }
}

