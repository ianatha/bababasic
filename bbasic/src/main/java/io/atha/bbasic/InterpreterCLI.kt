package io.atha.bbasic

import io.atha.bbasic.awt.AWTGraphicsRuntime
import io.atha.bbasic.awt.AWTSoundState
import io.atha.bbasic.awt.SystemEnv
import io.atha.bbasic.awt.SystemInputOutputFile
import io.atha.libbababasic.Interpreter.interpretAndRun
import io.atha.libbababasic.Interpreter.loadSource
import io.atha.libbababasic.UserOptions
import java.time.Instant
import kotlin.system.exitProcess

object InterpreterCLI {
    private const val UNKNOWN_SOURCE_FILE = "<UNKNOWN>"

    @JvmStatic
    fun main(args: Array<String>) {
        val userOptions = UserOptions.ofTest()
        userOptions.filename = args[0]
//            parseCommandLineArgs(*args)
        val mainSource = userOptions.filename!!
        val t0 = Instant.now()
        val sourceCode = loadSource(mainSource)
        val stdinout = SystemInputOutputFile(System.`in`, System.out)
        try {
            interpretAndRun(
                userOptions,
                sourceCode,
                stdinout,
                SystemEnv(),
                AWTGraphicsRuntime(),
                AWTSoundState(),
            )
        } catch (e: Exception) {
            e.printStackTrace()
            exitProcess(1)
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
}