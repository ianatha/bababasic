package io.atha.libbababasic

import kotlin.test.assertEquals
import kotlin.test.Ignore
import kotlin.test.Test
import io.atha.libbababasic.error.RuntimeError
import io.atha.libbababasic.file.SystemInputOutputFile
import io.atha.libbababasic.runtime.BabaSystem
import io.atha.libbababasic.runtime.Environment
import io.atha.libbababasic.runtime.SoundState
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.PrintStream
import java.net.URL
import java.nio.file.Files
import java.nio.file.Path
import java.time.Instant
import kotlin.test.BeforeTest
import kotlin.test.assertFailsWith

class IntegrationTest {
    private var env: Environment? = null
    private var soundState: SoundState = object : SoundState {
        override fun close() {}
        override fun load(file: String?): Int = 0
        override fun play(id: Int) {}
        override fun stop(id: Int) {}
        override fun loop(id: Int) {}
    }

    @BeforeTest
    fun setup() {
        env = object : Environment {
            val map = mutableMapOf<String, String>()

            override fun get(key: String): String {
                return map[key] ?: ""
            }

            override fun set(key: String, value: String) {
                map[key] = value
            }

            override fun getStorageFolder(): String {
                return ""
            }
        }
    }

    @Test
    fun testForLoop() = runTest("forloop.bas", "forloop.bas.output")

    @Test
    fun testNestedForLoop() =runTest("nested_forloop.bas", "nested_forloop.bas.output")
    @Test
    fun testScalarVariable() = runTest("scalar_var.bas", "scalar_var.bas.output")
    @Test fun testArrayVariable() = runTest("array_var.bas", "array_var.bas.output")

    @Test fun testArrayCopy() = runTest("array_copy.bas", "array_copy.bas.output")

    @Test fun testArrayFunc() = runTest("array_func.bas", "array_func.bas.output")

    @Test fun testWhile() = runTest("while.bas", "while.bas.output")

    @Test fun testExpr() = runTest("expr.bas", "expr.bas.output")

    @Ignore("test fails on CI")
    @Test fun testFunc() = runTest("func.bas", "func.bas.output")

    @Test fun testFunc2() = runTest("func2.bas", "func2.bas.output")

    @Test
    fun testIf() = runTest("if.bas", "if.bas.output")

    @Test
    fun testIfThenBegin() = runTest("ifthenbegin.bas", "ifthenbegin.bas.output")

    @Test
    fun testReadData() = runTest("readdata.bas", "readdata.bas.output")

    @Test
    fun testGosub() = runTest("gosub.bas", "gosub.bas.output")

    fun testGosublabel() = runTest("gosublabel.bas", "gosublabel.bas.output")

    @Test fun testGotoLabel() = runTest("gotolabel.bas", "gotolabel.bas.output")

    @Test fun testGotoLabelCaseInsensitive() = runTest("gotolabel_case_insensitive.bas", "gotolabel.bas.output")

    @Test
    fun testDef() = runTest("def.bas", "def.bas.output")
    @Test
    fun testUdf() = runTest("udf.bas", "udf.bas.output")

    @Test
    fun testStrStmt() = runTest("strstmt.bas", "strstmt.bas.output")

    @Test
    fun testPrintUsing() = runTest("printusing.bas", "printusing.bas.output")

    @Test
    fun testWrite() = runTest("write.bas", "write.bas.output")

    @Test
    fun testSwap() = runTest("swap.bas", "swap.bas.output")

    @Test
    fun testRef() = runTest("ref.bas", "ref.bas.output")

    @Test
    @Ignore("TODO: reinstate support for files")
    @Throws(IOException::class)
    fun testRandomAccessFile() {
        val tmpdir = System.getProperty("java.io.tmpdir")
        val filename = ("puffin_basic_test_random_access_file_"
                + Instant.now().epochSecond + ".data")
        env!!["TEST_TMP_DIR"] = tmpdir!!
        env!!["TEST_FILENAME"] = filename!!
        runTest("randomaccessfile.bas", "randomaccessfile.bas.output")
        Files.delete(Path.of(tmpdir, filename))
    }

    @Test
    @Ignore("TODO: ensure prompt not displayed for files")
    @Throws(IOException::class)
    fun testSequentialAccessFile() {
        val tmpdir = System.getProperty("java.io.tmpdir")
        val filename = ("puffin_basic_test_sequential_access_file_"
                + Instant.now().epochSecond + ".data")
        env!!["TEST_TMP_DIR"] = tmpdir
        env!!["TEST_SEQ_FILENAME"] = filename
        runTest("sequentialaccessfile.bas", "sequentialaccessfile.bas.output")
        Files.delete(Path.of(tmpdir, filename))
    }

    @Test
    fun testStruct() {
        runTest("struct.bas", "struct.bas.output")
    }

    @Test
    fun testList() {
        runTest("list.bas", "list.bas.output")
    }

    @Test
    fun testSet() {
        runTest("set.bas", "set.bas.output")
    }

    @Test
    fun testDict() {
        runTest("dict.bas", "dict.bas.output")
    }

    @Test
    fun testStringFunctions() {
        runTest("string_functions.bas", "string_functions.bas.output")
    }

    @Test
    fun testValOfString() {
        runTest("val_of_string.bas", "val_of_string.bas.output")
    }

    @Test
    fun testJim01() {
        val e = assertFailsWith<RuntimeError> {
            runTest("jim_01.bas", "")
        }
        assertEquals(RuntimeError.ErrorCode.ARRAY_INDEX_OUT_OF_BOUNDS, e.errorCode)
    }

    @Test
    fun testJim02() {
        runTest("jim_02.bas", "jim_02.bas.output")
    }

    @Test
    fun testJim03() {
        runTest("jim_03.bas", "jim_03.bas.output")
    }

    private fun runTestString(source: String, output: String) {
        val bos = ByteArrayOutputStream()
        val out = PrintStream(bos)
        val stdio = SystemInputOutputFile(System.`in`, out)
        Interpreter.interpretAndRun(
            UserOptions.ofTest(),
            source,
            stdio,
            env!!,
            graphicsRuntime = MockGraphicsRunTime(stdio),
            soundState = soundState,
        )
        out.close()
        assertEquals(
            output.replace(Regex("\n"), BabaSystem.lineSeparator()),
            String(bos.toByteArray())
        )
    }

    private fun runTest(sourcePath: String, outputPath: String) {
        runTestString(
            loadSourceCodeFromResource(sourcePath),
            loadOutputFromResource(outputPath)
        )
    }

    private fun loadSourceCodeFromResource(filename: String): String {
        return loadResource(
            javaClass.classLoader.getResource(filename)
        )
    }

    private fun loadOutputFromResource(filename: String): String {
        return loadResource(
            javaClass.classLoader.getResource(filename)
        )
    }
}

private fun loadResource(resource: URL): String {
    try {
        BufferedInputStream(resource.openStream()).use { `in` -> return String(`in`.readAllBytes()) }
    } catch (e: IOException) {
        throw RuntimeError(
            RuntimeError.ErrorCode.IO_ERROR,
            "Failed to read file: " + resource + ", error: " + e.message
        )
    }
}
