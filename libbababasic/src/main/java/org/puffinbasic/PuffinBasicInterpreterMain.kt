package org.puffinbasic

import com.google.common.base.Strings
import net.sourceforge.argparse4j.ArgumentParsers
import net.sourceforge.argparse4j.impl.Arguments
import net.sourceforge.argparse4j.inf.ArgumentParserException
import net.sourceforge.argparse4j.inf.Namespace
import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.puffinbasic.antlr4.PuffinBasicLexer
import org.puffinbasic.antlr4.PuffinBasicParser
import org.puffinbasic.domain.PuffinBasicSymbolTable
import org.puffinbasic.error.PuffinBasicRuntimeError
import org.puffinbasic.error.PuffinBasicSyntaxError
import org.puffinbasic.error.PuffinError
import org.puffinbasic.file.PuffinUserInterfaceFile
import org.puffinbasic.file.SystemInputOutputFile
import org.puffinbasic.parser.LinenumberListener
import org.puffinbasic.parser.LinenumberListener.ThrowOnDuplicate
import org.puffinbasic.parser.PuffinBasicIR
import org.puffinbasic.parser.PuffinBasicIRListener
import org.puffinbasic.parser.PuffinBasicImportPath
import org.puffinbasic.parser.PuffinBasicSourceFile
import org.puffinbasic.runtime.BabaSystem
import org.puffinbasic.runtime.Environment
import org.puffinbasic.runtime.PuffinBasicRuntime
import org.puffinbasic.runtime.SystemEnv
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.time.Duration
import java.time.Instant
import kotlin.math.max

object PuffinBasicInterpreterMain {
    private const val UNKNOWN_SOURCE_FILE = "<UNKNOWN>"

    @JvmStatic
    fun main(args: Array<String>) {
        val userOptions = org.puffinbasic.PuffinBasicInterpreterMain.parseCommandLineArgs(*args)
        val mainSource = userOptions.filename
        val t0 = Instant.now()
        val sourceCode = org.puffinbasic.PuffinBasicInterpreterMain.loadSource(mainSource)
        org.puffinbasic.PuffinBasicInterpreterMain.logTimeTaken("LOAD", t0, userOptions.timing)
        val stdinout = SystemInputOutputFile(System.`in`, System.out)
        try {
            org.puffinbasic.PuffinBasicInterpreterMain.interpretAndRun(
                userOptions,
                mainSource,
                sourceCode,
                stdinout,
                SystemEnv()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            System.exit(1)
        }
    }

    private fun parseCommandLineArgs(vararg args: String): org.puffinbasic.PuffinBasicInterpreterMain.UserOptions {
        val parser = ArgumentParsers
            .newFor("PuffinBasic")
            .build()
        parser.addArgument("-d", "--logduplicate")
            .help("Log error on duplicate")
            .action(Arguments.storeTrue())
        parser.addArgument("-l", "--list")
            .help("Print Sorted Source Code")
            .action(Arguments.storeTrue())
        parser.addArgument("-i", "--ir")
            .help("Print IR")
            .action(Arguments.storeTrue())
        parser.addArgument("-t", "--timing")
            .help("Print timing")
            .action(Arguments.storeTrue())
        parser.addArgument("-g", "--graphics")
            .help("Enable graphics")
            .action(Arguments.storeTrue())
        parser.addArgument("file").nargs(1)
        var res: Namespace? = null
        try {
            res = parser.parseArgs(args)
        } catch (e: ArgumentParserException) {
            parser.handleError(e)
            System.exit(1)
        }
        checkNotNull(res)
        return org.puffinbasic.PuffinBasicInterpreterMain.UserOptions(
            res.getBoolean("logduplicate"),
            res.getBoolean("list"),
            res.getBoolean("ir"),
            res.getBoolean("timing"),
            res.getBoolean("graphics"),
            res.getList<Any>("file")[0] as String
        )
    }

    private fun loadSource(filename: String?): String {
        val sb = StringBuilder()
        try {
            Files.lines(Paths.get(filename), StandardCharsets.US_ASCII).use { stream ->
                stream.forEach { s: String? ->
                    sb.append(s).append(
                        BabaSystem.lineSeparator()
                    )
                }
            }
        } catch (e: IOException) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
                "Failed to read source code: " + filename + ", error: " + e.message
            )
        }
        return sb.toString()
    }

    @Throws(PuffinBasicRuntimeError::class)
    fun interpretAndRun(
        userOptions: org.puffinbasic.PuffinBasicInterpreterMain.UserOptions,
        sourceCode: String,
        stdinout: PuffinUserInterfaceFile?,
        env: Environment?
    ) {
        org.puffinbasic.PuffinBasicInterpreterMain.interpretAndRun(
            userOptions,
            org.puffinbasic.PuffinBasicInterpreterMain.UNKNOWN_SOURCE_FILE,
            sourceCode,
            stdinout,
            env
        )
    }

    @JvmStatic()
    @Throws(PuffinBasicSyntaxError::class)
    public fun checkSyntax(
        sourceFilename: String?,
        sourceCode: String,
        throwOnDuplicate: ThrowOnDuplicate = ThrowOnDuplicate.THROW,
    ): PuffinBasicSourceFile {
        val importPath = PuffinBasicImportPath(sourceFilename)
        val sourceFile = org.puffinbasic.PuffinBasicInterpreterMain.syntaxCheckAndSortByLineNumber(
            importPath,
            sourceFilename,
            sourceCode,
            throwOnDuplicate,
            org.puffinbasic.PuffinBasicInterpreterMain.SourceFileMode.MAIN
        )
        if (sourceFile.sourceCode.isEmpty()) {
            throw PuffinBasicSyntaxError(
                "Failed to parse source code! Check if a linenumber is missing"
            )
        }
        return sourceFile
    }

    @Throws(PuffinError::class)
    fun interpretAndRun(
        userOptions: org.puffinbasic.PuffinBasicInterpreterMain.UserOptions,
        sourceFilename: String?,
        sourceCode: String,
        stdinout: PuffinUserInterfaceFile?,
        env: Environment?
    ) {
        val t1 = Instant.now()
        val sourceFile = org.puffinbasic.PuffinBasicInterpreterMain.checkSyntax(
            sourceFilename,
            sourceCode,
            if (userOptions.logOnDuplicate) ThrowOnDuplicate.LOG else ThrowOnDuplicate.THROW
        )
        org.puffinbasic.PuffinBasicInterpreterMain.logTimeTaken("SORT", t1, userOptions.timing)
        org.puffinbasic.PuffinBasicInterpreterMain.log("LIST", userOptions.listSourceCode)
        org.puffinbasic.PuffinBasicInterpreterMain.log(
            sourceFile.sourceCode,
            userOptions.listSourceCode
        )
        val t2 = Instant.now()
        val ir =
            org.puffinbasic.PuffinBasicInterpreterMain.generateIR(sourceFile, userOptions.graphics)
        org.puffinbasic.PuffinBasicInterpreterMain.logTimeTaken("IR", t2, userOptions.timing)
        org.puffinbasic.PuffinBasicInterpreterMain.log("IR", userOptions.printIR)
        if (userOptions.printIR) {
            ir.getInstructions().withIndex().forEach { (i, instruction) ->
                org.puffinbasic.PuffinBasicInterpreterMain.log("$i: $instruction", true)
            }
        }
        org.puffinbasic.PuffinBasicInterpreterMain.log("RUN", userOptions.timing)
        val t3 = Instant.now()
        val runtime = PuffinBasicRuntime(ir, stdinout!!, env!!)
        runtime.run()
        org.puffinbasic.PuffinBasicInterpreterMain.logTimeTaken("RUN", t3, userOptions.timing)
    }

    private fun log(s: String, log: Boolean) {
        if (log) {
            println(s)
        }
    }

    private fun logTimeTaken(tag: String, t1: Instant, log: Boolean) {
        val duration = Duration.between(t1, Instant.now())
        val timeSec = duration.seconds + duration.nano / 1000000000.0
        org.puffinbasic.PuffinBasicInterpreterMain.log("[$tag] time taken = $timeSec s", log)
    }

    private fun run(ir: PuffinBasicIR, out: PuffinUserInterfaceFile, env: Environment) {
        val runtime = PuffinBasicRuntime(ir, out, env)
        try {
            runtime.run()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    private fun generateIR(sourceFile: PuffinBasicSourceFile, graphics: Boolean): PuffinBasicIR {
        val symbolTable = PuffinBasicSymbolTable()
        val ir = PuffinBasicIR(symbolTable)
        for (importFile in sourceFile.importFiles) {
            org.puffinbasic.PuffinBasicInterpreterMain.generateIR(importFile, ir, graphics)
        }
        org.puffinbasic.PuffinBasicInterpreterMain.generateIR(sourceFile, ir, graphics)
        return ir
    }

    private fun generateIR(
        sourceFile: PuffinBasicSourceFile,
        ir: PuffinBasicIR,
        graphics: Boolean
    ) {
        val `in` = sourceFile.sourceCodeStream
        val lexer = org.puffinbasic.antlr4.PuffinBasicLexer(`in`)
        val tokens = CommonTokenStream(lexer)
        val parser = org.puffinbasic.antlr4.PuffinBasicParser(tokens)
        val tree = parser.prog()
        val walker = ParseTreeWalker()
        val irListener = PuffinBasicIRListener(sourceFile, `in`, ir, graphics)
        walker.walk(irListener, tree)
        irListener.semanticCheckAfterParsing()
    }

    private fun syntaxCheckAndSortByLineNumber(
        importPath: PuffinBasicImportPath,
        sourceFile: String?,
        input: String,
        throwOnDuplicate: ThrowOnDuplicate,
        sourceFileMode: org.puffinbasic.PuffinBasicInterpreterMain.SourceFileMode
    ): PuffinBasicSourceFile {
        val `in` = CharStreams.fromString(input)
        val syntaxErrorListener =
            org.puffinbasic.PuffinBasicInterpreterMain.ThrowingErrorListener(input)
        val lexer = org.puffinbasic.antlr4.PuffinBasicLexer(`in`)
        lexer.removeErrorListeners()
        lexer.addErrorListener(syntaxErrorListener)
        val tokens = CommonTokenStream(lexer)
        val parser = org.puffinbasic.antlr4.PuffinBasicParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(syntaxErrorListener)
        val tree = parser.prog()
        val walker = ParseTreeWalker()
        val linenumListener = LinenumberListener(`in`, throwOnDuplicate)
        walker.walk(linenumListener, tree)
        if (sourceFileMode == org.puffinbasic.PuffinBasicInterpreterMain.SourceFileMode.LIB) {
            if (linenumListener.hasLineNumbers()) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.IMPORT_ERROR,
                    "Lib $sourceFile should not have line numbers!"
                )
            }
            if (linenumListener.libtag == null) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.IMPORT_ERROR,
                    "Lib $sourceFile should set a LIBTAG!"
                )
            }
        }
        val importSourceFiles = LinkedHashSet<PuffinBasicSourceFile>()
        for (importFilename in linenumListener.getImportFiles()) {
            val importedInput =
                org.puffinbasic.PuffinBasicInterpreterMain.loadSource(importPath.find(importFilename))
            val importSourceFile =
                org.puffinbasic.PuffinBasicInterpreterMain.syntaxCheckAndSortByLineNumber(
                    importPath, importFilename, importedInput,
                    throwOnDuplicate, org.puffinbasic.PuffinBasicInterpreterMain.SourceFileMode.LIB
                )
            importSourceFiles.add(importSourceFile)
            importSourceFiles.addAll(importSourceFile.importFiles)
        }
        val sortedCode = linenumListener.sortedCode
        return PuffinBasicSourceFile(
            sourceFile!!,
            linenumListener.libtag,
            sortedCode,
            CharStreams.fromString(sortedCode),
            importSourceFiles
        )
    }

    private enum class SourceFileMode {
        MAIN, LIB
    }

    private class ThrowingErrorListener(private val input: String) :
        BaseErrorListener() {
        override fun syntaxError(
            recognizer: Recognizer<*, *>?,
            offendingSymbol: Any?,
            line: Int,
            charPositionInLine: Int,
            msg: String,
            e: RecognitionException?
        ) {
            val lineIndex = line - 1
            val lines =
                input.split(BabaSystem.lineSeparator().toRegex()).dropLastWhile { it.isEmpty() }
                    .toTypedArray()
            var inputLine: String
            if (lineIndex >= 0 && lineIndex < lines.size) {
                inputLine = lines[lineIndex]
                if (charPositionInLine >= 0 && charPositionInLine <= inputLine.length) {
                    inputLine = (inputLine + BabaSystem.lineSeparator()
                            + Strings.repeat(" ", max(0, charPositionInLine)) + '^')
                }
            } else {
                inputLine = "<LINE OUT OF RANGE>"
            }
            throw PuffinBasicSyntaxError(
                "[" + line + ":" + charPositionInLine + "] " + msg + BabaSystem.lineSeparator()
                        + inputLine,
                line,
                charPositionInLine
            )
        }
    }

    class UserOptions(
        val logOnDuplicate: Boolean,
        val listSourceCode: Boolean,
        val printIR: Boolean,
        val timing: Boolean,
        val graphics: Boolean,
        val filename: String?
    ) {
        companion object {
            fun ofTest(): org.puffinbasic.PuffinBasicInterpreterMain.UserOptions {
                return org.puffinbasic.PuffinBasicInterpreterMain.UserOptions(
                    false, false, false, false, false, null
                )
            }
        }
    }
}