package io.atha.libbababasic

import io.atha.libbababasic.domain.SymbolTable
import io.atha.libbababasic.error.BBError
import io.atha.libbababasic.error.RuntimeError
import io.atha.libbababasic.error.SyntaxError
import io.atha.libbababasic.file.BBUIFile
import io.atha.libbababasic.file.SystemInputOutputFile
import io.atha.libbababasic.grammar.BabaBASICLexer
import io.atha.libbababasic.grammar.BabaBASICParser
import io.atha.libbababasic.parser.IR
import io.atha.libbababasic.parser.IRListener
import io.atha.libbababasic.parser.ImportPath
import io.atha.libbababasic.parser.LinenumberListener
import io.atha.libbababasic.parser.LinenumberListener.ThrowOnDuplicate
import io.atha.libbababasic.parser.SourceFile
import io.atha.libbababasic.runtime.BBRuntime
import io.atha.libbababasic.runtime.BabaSystem
import io.atha.libbababasic.runtime.Environment
import io.atha.libbababasic.runtime.SystemEnv
import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer
import org.antlr.v4.runtime.tree.ParseTreeWalker
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.time.Duration
import java.time.Instant
import kotlin.math.max

object InterpreterMain {
    private const val UNKNOWN_SOURCE_FILE = "<UNKNOWN>"

    @JvmStatic
    fun main(args: Array<String>) {
        val userOptions = UserOptions.ofTest()
        userOptions.filename = args[0]
//            parseCommandLineArgs(*args)
        val mainSource = userOptions.filename
        val t0 = Instant.now()
        val sourceCode = loadSource(mainSource)
        logTimeTaken(
            "LOAD",
            t0,
            userOptions.timing
        )
        val stdinout = SystemInputOutputFile(System.`in`, System.out)
        try {
            interpretAndRun(
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

//    private fun parseCommandLineArgs(vararg args: String): UserOptions {
//        val parser = ArgumentParsers
//            .newFor("PuffinBasic")
//            .build()
//        parser.addArgument("-d", "--logduplicate")
//            .help("Log error on duplicate")
//            .action(Arguments.storeTrue())
//        parser.addArgument("-l", "--list")
//            .help("Print Sorted Source Code")
//            .action(Arguments.storeTrue())
//        parser.addArgument("-i", "--ir")
//            .help("Print IR")
//            .action(Arguments.storeTrue())
//        parser.addArgument("-t", "--timing")
//            .help("Print timing")
//            .action(Arguments.storeTrue())
//        parser.addArgument("-g", "--graphics")
//            .help("Enable graphics")
//            .action(Arguments.storeTrue())
//        parser.addArgument("file").nargs(1)
//        var res: Namespace? = null
//        try {
//            res = parser.parseArgs(args)
//        } catch (e: ArgumentParserException) {
//            parser.handleError(e)
//            System.exit(1)
//        }
//        checkNotNull(res)
//        return UserOptions(
//            res.getBoolean("logduplicate"),
//            res.getBoolean("list"),
//            res.getBoolean("ir"),
//            res.getBoolean("timing"),
//            res.getBoolean("graphics"),
//            res.getList<Any>("file")[0] as String
//        )
//    }

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
            throw RuntimeError(
                RuntimeError.ErrorCode.IO_ERROR,
                "Failed to read source code: " + filename + ", error: " + e.message
            )
        }
        return sb.toString()
    }

    @Throws(RuntimeError::class)
    fun interpretAndRun(
        userOptions: UserOptions,
        sourceCode: String,
        stdinout: BBUIFile?,
        env: Environment?
    ) {
        interpretAndRun(
            userOptions,
            UNKNOWN_SOURCE_FILE,
            sourceCode,
            stdinout,
            env
        )
    }

    @JvmStatic()
    @Throws(SyntaxError::class)
    fun checkSyntax(
        sourceFilename: String?,
        sourceCode: String,
        throwOnDuplicate: ThrowOnDuplicate = ThrowOnDuplicate.THROW,
    ): SourceFile {
        val importPath = ImportPath(sourceFilename)
        val sourceFile =
            syntaxCheckAndSortByLineNumber(
                importPath,
                sourceFilename,
                sourceCode,
                throwOnDuplicate,
                SourceFileMode.MAIN
            )
        if (sourceFile.sourceCode.isEmpty()) {
            throw SyntaxError(
                "Failed to parse source code! Check if a linenumber is missing"
            )
        }
        return sourceFile
    }

    @Throws(BBError::class)
    fun interpretAndRun(
        userOptions: UserOptions,
        sourceFilename: String?,
        sourceCode: String,
        stdinout: BBUIFile?,
        env: Environment?
    ) {
        val t1 = Instant.now()
        val sourceFile = checkSyntax(
            sourceFilename,
            sourceCode,
            if (userOptions.logOnDuplicate) ThrowOnDuplicate.LOG else ThrowOnDuplicate.THROW
        )
        logTimeTaken(
            "SORT",
            t1,
            userOptions.timing
        )
        log("LIST", userOptions.listSourceCode)
        log(
            sourceFile.sourceCode,
            userOptions.listSourceCode
        )
        val t2 = Instant.now()
        val ir =
            generateIR(
                sourceFile,
                userOptions.graphics
            )
        logTimeTaken("IR", t2, userOptions.timing)
        log("IR", userOptions.printIR)
        if (userOptions.printIR) {
            ir.getInstructions().withIndex().forEach { (i, instruction) ->
                log("$i: $instruction", true)
            }
        }
        log("RUN", userOptions.timing)
        val t3 = Instant.now()
        val runtime = BBRuntime(ir, stdinout!!, env!!)
        runtime.run()
        logTimeTaken(
            "RUN",
            t3,
            userOptions.timing
        )
    }

    private fun log(s: String, log: Boolean) {
        if (log) {
            println(s)
        }
    }

    private fun logTimeTaken(tag: String, t1: Instant, log: Boolean) {
        val duration = Duration.between(t1, Instant.now())
        val timeSec = duration.seconds + duration.nano / 1000000000.0
        log("[$tag] time taken = $timeSec s", log)
    }

    private fun run(ir: IR, out: BBUIFile, env: Environment) {
        val runtime = BBRuntime(ir, out, env)
        try {
            runtime.run()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    private fun generateIR(sourceFile: SourceFile, graphics: Boolean): IR {
        val symbolTable = SymbolTable()
        val ir = IR(symbolTable)
        for (importFile in sourceFile.importFiles) {
            generateIR(importFile, ir, graphics)
        }
        generateIR(sourceFile, ir, graphics)
        return ir
    }

    private fun generateIR(
        sourceFile: SourceFile,
        ir: IR,
        graphics: Boolean
    ) {
        val `in` = sourceFile.sourceCodeStream
        val lexer = BabaBASICLexer(`in`)
        val tokens = CommonTokenStream(lexer)
        val parser = BabaBASICParser(tokens)
        val tree = parser.prog()
        val walker = ParseTreeWalker()
        val irListener = IRListener(sourceFile, `in`, ir, graphics)
        walker.walk(irListener, tree)
        irListener.semanticCheckAfterParsing()
    }

    private fun syntaxCheckAndSortByLineNumber(
        importPath: ImportPath,
        sourceFile: String?,
        input: String,
        throwOnDuplicate: ThrowOnDuplicate,
        sourceFileMode: SourceFileMode
    ): SourceFile {
        val `in` = CharStreams.fromString(input)
        val syntaxErrorListener =
            ThrowingErrorListener(input)
        val lexer = BabaBASICLexer(`in`)
        lexer.removeErrorListeners()
        lexer.addErrorListener(syntaxErrorListener)
        val tokens = CommonTokenStream(lexer)
        val parser = BabaBASICParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(syntaxErrorListener)
        val tree = parser.prog()
        val walker = ParseTreeWalker()
        val linenumListener = LinenumberListener(`in`, throwOnDuplicate)
        walker.walk(linenumListener, tree)
        if (sourceFileMode == SourceFileMode.LIB) {
            if (linenumListener.hasLineNumbers()) {
                throw RuntimeError(
                    RuntimeError.ErrorCode.IMPORT_ERROR,
                    "Lib $sourceFile should not have line numbers!"
                )
            }
            if (linenumListener.libtag == null) {
                throw RuntimeError(
                    RuntimeError.ErrorCode.IMPORT_ERROR,
                    "Lib $sourceFile should set a LIBTAG!"
                )
            }
        }
        val importSourceFiles = LinkedHashSet<SourceFile>()
        for (importFilename in linenumListener.getImportFiles()) {
            val importedInput =
                loadSource(
                    importPath.find(
                        importFilename
                    )
                )
            val importSourceFile =
                syntaxCheckAndSortByLineNumber(
                    importPath,
                    importFilename,
                    importedInput,
                    throwOnDuplicate,
                    SourceFileMode.LIB
                )
            importSourceFiles.add(importSourceFile)
            importSourceFiles.addAll(importSourceFile.importFiles)
        }
        val sortedCode = linenumListener.sortedCode
        return SourceFile(
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
                            + " ".repeat(max(0, charPositionInLine)) + '^')
                }
            } else {
                inputLine = "<LINE OUT OF RANGE>"
            }
            throw SyntaxError(
                "[" + line + ":" + charPositionInLine + "] " + msg + BabaSystem.lineSeparator()
                        + inputLine,
                line,
                charPositionInLine
            )
        }
    }
}

class UserOptions(
    val logOnDuplicate: Boolean,
    val listSourceCode: Boolean,
    val printIR: Boolean,
    val timing: Boolean,
    val graphics: Boolean,
    var filename: String?
) {
    companion object {
        fun ofTest(): UserOptions {
            return UserOptions(
                false, false, false, false, false, null
            )
        }
    }
}