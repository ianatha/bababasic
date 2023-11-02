package org.puffinbasic

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.puffinbasic.PuffinBasicInterpreterMain.UserOptions
import org.puffinbasic.error.PuffinBasicRuntimeError
import org.puffinbasic.file.SystemInputOutputFile
import org.puffinbasic.runtime.BabaSystem
import org.puffinbasic.runtime.Environment
import org.puffinbasic.runtime.SystemEnv
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.PrintStream
import java.net.URL
import java.nio.file.Files
import java.nio.file.Path
import java.time.Instant

class IntegrationTest {
    private var env: Environment? = null
    @Before
    fun setup() {
        env = SystemEnv()
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
        env!!["TEST_TMP_DIR"] = tmpdir
        env!!["TEST_FILENAME"] = filename
        runTest("randomaccessfile.bas", "randomaccessfile.bas.output")
        Files.delete(Path.of(tmpdir, filename))
    }

    @Test
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
    @Ignore("TODO: reinstate support for LIST")
    fun testList() {
        runTest("list.bas", "list.bas.output")
    }

    @Test
    fun testSet() {
        runTest("set.bas", "set.bas.output")
    }

    @Test
    @Ignore("TODO: reinstate support for DICT")
    fun testDict() {
        runTest("dict.bas", "dict.bas.output")
    }

    @Test
    fun testStringFunctions() {
        runTest("string_functions.bas", "string_functions.bas.output")
    }

    @Test
    fun testJim01() {
        val e = assertThrows(PuffinBasicRuntimeError::class.java) {
            runTest("jim_01.bas", "")
        }
        assertEquals(PuffinBasicRuntimeError.ErrorCode.ARRAY_INDEX_OUT_OF_BOUNDS, e.errorCode)
    }

    @Test
    fun testJim02() {
        runTest("jim_02.bas", "jim_02.bas.output")
    }

    @Test
    fun testJim03() {
        runTest("jim_03.bas", "jim_03.bas.output")
    }

    @Test
    @Ignore("TODO: STDDEV broken")
    fun testSTDDEV() {
        runTestString("DIM A(4): FOR I = 0 TO 3: A(I) = I: NEXT I: PRINT STDDEV(A)\n", " 1.2910 \n")
    }

    private fun runTestString(source: String, output: String) {
        val bos = ByteArrayOutputStream()
        val out = PrintStream(bos)
        PuffinBasicInterpreterMain.interpretAndRun(
            UserOptions.ofTest(),
            source,
            SystemInputOutputFile(System.`in`, out),
            env
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

    companion object {
        private fun loadResource(resource: URL): String {
            try {
                BufferedInputStream(resource.openStream()).use { `in` -> return String(`in`.readAllBytes()) }
            } catch (e: IOException) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
                    "Failed to read file: " + resource + ", error: " + e.message
                )
            }
        }
    }
}