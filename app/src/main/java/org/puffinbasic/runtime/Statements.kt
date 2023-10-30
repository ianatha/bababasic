package org.puffinbasic.runtime

import it.unimi.dsi.fastutil.ints.IntArrayList
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVRecord
import org.puffinbasic.domain.PuffinBasicSymbolTable
import org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId
import org.puffinbasic.domain.STObjects.STEntry
import org.puffinbasic.domain.STObjects.STRef
import org.puffinbasic.domain.STObjects.STStruct
import org.puffinbasic.domain.STObjects.STValue
import org.puffinbasic.domain.STObjects.STVariable
import org.puffinbasic.error.PuffinBasicInternalError
import org.puffinbasic.error.PuffinBasicRuntimeError
import org.puffinbasic.file.PuffinBasicExtendedFile
import org.puffinbasic.file.PuffinBasicFile
import org.puffinbasic.file.PuffinBasicFile.FileAccessMode
import org.puffinbasic.file.PuffinBasicFile.FileOpenMode
import org.puffinbasic.file.PuffinBasicFiles
import org.puffinbasic.parser.PuffinBasicIR
import org.puffinbasic.runtime.Formatter.FormatterCache
import org.puffinbasic.runtime.Types.assertBothStringOrNumeric
import java.io.IOException
import java.time.Instant
import java.util.Arrays
import java.util.Random
import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.LockSupport

object Statements {
    @JvmStatic
    fun sleep(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val millis = symbolTable[instruction.op1]!!.value!!.int32
        if (millis < 0) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.DATA_OUT_OF_RANGE,
                "Sleep time millis cannot be less than 0."
            )
        }
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(millis.toLong()))
    }

    @JvmStatic
    fun print(
        printBuffer: PrintBuffer,
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        printBuffer.appendAtCursor(symbolTable[instruction.op1]!!.value!!.printFormat()!!)
    }

    @JvmStatic
    fun write(
        printBuffer: PrintBuffer,
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        printBuffer.appendAtCursor(symbolTable[instruction.op1]!!.value!!.writeFormat()!!)
    }

    @JvmStatic
    fun printusing(
        cache: FormatterCache,
        printBuffer: PrintBuffer,
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val format = symbolTable[instruction.op1]!!.value!!.string
        val formatter = cache[format!!]
        val entry = symbolTable[instruction.op2]
        val value = entry!!.value
        val result: String
        result = when (entry.type!!.atomTypeId) {
            PuffinBasicAtomTypeId.INT32, PuffinBasicAtomTypeId.INT64 -> {
                if (!formatter.supportsNumeric()) {
                    throw PuffinBasicRuntimeError(
                        PuffinBasicRuntimeError.ErrorCode.DATA_TYPE_MISMATCH,
                        "String formatter doesn't work with numeric type: $format"
                    )
                }
                formatter.format(value!!.int64) + " "
            }

            PuffinBasicAtomTypeId.FLOAT, PuffinBasicAtomTypeId.DOUBLE -> {
                if (!formatter.supportsNumeric()) {
                    throw PuffinBasicRuntimeError(
                        PuffinBasicRuntimeError.ErrorCode.DATA_TYPE_MISMATCH,
                        "String formatter doesn't work with numeric type: $format"
                    )
                }
                formatter.format(value!!.float64) + " "
            }

            PuffinBasicAtomTypeId.STRING -> {
                if (!formatter.supportsString()) {
                    throw PuffinBasicRuntimeError(
                        PuffinBasicRuntimeError.ErrorCode.DATA_TYPE_MISMATCH,
                        "Numeric formatter doesn't work with string type: $format"
                    )
                }
                formatter.format(value!!.string!!)
            }

            else -> throw PuffinBasicInternalError(
                "Unsupported data type: " + entry.type!!.atomTypeId
            )
        }
        printBuffer.appendAtCursor(result)
    }

    @JvmStatic
    fun flush(
        files: PuffinBasicFiles,
        printBuffer: PrintBuffer,
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        if (instruction.op1 == PuffinBasicSymbolTable.NULL_ID) {
            printBuffer.flush(files.sys)
        } else {
            val fileNumber = symbolTable[instruction.op1]!!.value!!.int32
            printBuffer.flush(files[fileNumber])
        }
    }

    @JvmStatic
    fun swap(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val op1Entry = symbolTable[instruction.op1]
        val op1 = op1Entry!!.value
        val op2Entry = symbolTable[instruction.op2]
        val op2 = op2Entry!!.value
        val dt1 = op1Entry.type!!.atomTypeId
        val dt2 = op2Entry.type!!.atomTypeId
        if (dt1 === PuffinBasicAtomTypeId.STRING && dt2 === PuffinBasicAtomTypeId.STRING) {
            val tmp = op1!!.string
            op1.string = op2!!.string
            op2.string = tmp
        } else {
            if (dt1 === PuffinBasicAtomTypeId.DOUBLE || dt2 === PuffinBasicAtomTypeId.DOUBLE) {
                val tmp = op1!!.float64
                op1.float64 = op2!!.float64
                op2.float64 = tmp
            } else if (dt1 === PuffinBasicAtomTypeId.INT64 || dt2 === PuffinBasicAtomTypeId.INT64) {
                val tmp = op1!!.int64
                op1.int64 = op2!!.int64
                op2.int64 = tmp
            } else if (dt1 === PuffinBasicAtomTypeId.FLOAT || dt2 === PuffinBasicAtomTypeId.FLOAT) {
                val tmp = op1!!.float32
                op1.float32 = op2!!.float32
                op2.float32 = tmp
            } else {
                val tmp = op1!!.int32
                op1.int32 = op2!!.int32
                op2.int32 = tmp
            }
        }
    }

    @JvmStatic
    fun lset(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val destEntry = symbolTable[instruction.op1]!!.value
        val value = symbolTable[instruction.op2]!!.value!!.string
        val valLen = value!!.length
        var destLen = destEntry!!.fieldLength
        if (destLen == 0) {
            destLen = destEntry.string!!.length
            destEntry.fieldLength = destLen
        }
        val result: String?
        result = if (valLen > destLen) {
            value.substring(0, destLen)
        } else if (valLen == destLen) {
            value
        } else {
            val bytes = ByteArray(destLen)
            System.arraycopy(value.toByteArray(), 0, bytes, 0, valLen)
            Arrays.fill(bytes, valLen, destLen, ' '.code.toByte())
            String(bytes)
        }
        destEntry.string = result
    }

    @JvmStatic
    fun rset(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val destEntry = symbolTable[instruction.op1]!!.value
        val value = symbolTable[instruction.op2]!!.value!!.string
        val valLen = value!!.length
        var destLen = destEntry!!.fieldLength
        if (destLen == 0) {
            destLen = destEntry.string!!.length
            destEntry.fieldLength = destLen
        }
        val result: String?
        result = if (valLen > destLen) {
            value.substring(0, destLen)
        } else if (valLen == destLen) {
            value
        } else {
            val bytes = ByteArray(destLen)
            val offset = destLen - valLen
            Arrays.fill(bytes, 0, offset, ' '.code.toByte())
            System.arraycopy(value.toByteArray(), 0, bytes, offset, valLen)
            String(bytes)
        }
        destEntry.string = result
    }

    @JvmStatic
    fun open(
        files: PuffinBasicFiles,
        symbolTable: PuffinBasicSymbolTable,
        instr_fn_fn_0: PuffinBasicIR.Instruction,
        instr_om_am_1: PuffinBasicIR.Instruction,
        instr_lm_rl_2: PuffinBasicIR.Instruction
    ) {
        val fileName = symbolTable[instr_fn_fn_0.op1]!!.value!!.string
        val fileNumber = symbolTable[instr_fn_fn_0.op2]!!.value!!.int32
        val fileOpenMode = FileOpenMode.valueOf(
            symbolTable[instr_om_am_1.op1]!!.value!!.string!!
        )
        val fileAccessMode = FileAccessMode.valueOf(
            symbolTable[instr_om_am_1.op2]!!.value!!.string!!
        )
        val fileLockMode = PuffinBasicFile.LockMode.valueOf(
            symbolTable[instr_lm_rl_2.op1]!!.value!!.string!!
        )
        val recordLen = symbolTable[instr_lm_rl_2.op2]!!.value!!.int32
        files.open(
            fileNumber,
            fileName!!,
            fileOpenMode,
            fileAccessMode,
            recordLen
        )
    }

    @JvmStatic
    fun closeAll(files: PuffinBasicFiles) {
        files.closeAll()
    }

    @JvmStatic
    fun close(
        files: PuffinBasicFiles,
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val fileNumber = symbolTable[instruction.op1]!!.value!!.int32
        files[fileNumber].close()
    }

    @JvmStatic
    fun field(
        files: PuffinBasicFiles,
        symbolTable: PuffinBasicSymbolTable,
        fields: List<PuffinBasicIR.Instruction>,
        instruction: PuffinBasicIR.Instruction
    ) {
        val varList = IntArrayList(fields.size)
        for (instrI in fields) {
            val recordPartLen = symbolTable[instrI.op2]!!.value!!.int32
            symbolTable[instrI.op1]!!.value!!.fieldLength = recordPartLen
            varList.add(instrI.op1)
        }
        val fileNumber = symbolTable[instruction.op1]!!.value!!.int32
        files[fileNumber].setFieldParams(
            symbolTable,
            varList
        )
    }

    @JvmStatic
    fun putf(
        files: PuffinBasicFiles,
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val fileNumber = symbolTable[instruction.op1]!!.value!!.int32
        val recordNumber =
            if (instruction.op2 == PuffinBasicSymbolTable.NULL_ID) null else symbolTable[instruction.op2]!!.value!!.int32
        files[fileNumber].put(recordNumber!!, symbolTable)
    }

    @JvmStatic
    fun getf(
        files: PuffinBasicFiles,
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val fileNumber = symbolTable[instruction.op1]!!.value!!.int32
        val recordNumber =
            if (instruction.op2 == PuffinBasicSymbolTable.NULL_ID) null else symbolTable[instruction.op2]!!.value!!.int32
        files[fileNumber][recordNumber!!, symbolTable]
    }

    @JvmStatic
    fun randomize(
        random: Random,
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val seed = symbolTable[instruction.op1]!!.value!!.int64
        random.setSeed(seed)
    }

    @JvmStatic
    fun randomizeTimer(random: Random) {
        val seed = Instant.now().epochSecond
        random.setSeed(seed)
    }

    @JvmStatic
    fun input(
        files: PuffinBasicFiles,
        symbolTable: PuffinBasicSymbolTable,
        instructions: List<PuffinBasicIR.Instruction>,
        instruction: PuffinBasicIR.Instruction
    ) {
        var printPrompt = false
        var prompt: String? = null
        if (instruction.op1 != PuffinBasicSymbolTable.NULL_ID) {
            prompt = symbolTable[instruction.op1]!!.value!!.string
            printPrompt = true
            // TODO: do not print prompt when reading from file
            files.sys.print(prompt!!)
        }
        val file: PuffinBasicFile
        file = if (instruction.op2 != PuffinBasicSymbolTable.NULL_ID) {
            val fileNumber = symbolTable[instruction.op2]!!.value!!.int32
            files[fileNumber]
        } else {
            files.sys
        }
        var record: CSVRecord? = null
        var retry = false
        do {
            if (retry) {
                if (printPrompt) {
                    System.err.println("?Redo from start")
                } else {
                    throw PuffinBasicRuntimeError(
                        PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
                        "Record mismatch: expected=" + instructions.size
                                + ", found in file=" + record!!.size()
                                + ", record: " + record
                    )
                }
            }
            var parser: CSVParser
            parser = try {
                if (file is PuffinBasicExtendedFile) {
                    CSVParser.parse(file.inputDialog(prompt!!), CSVFormat.DEFAULT)
                } else {
                    CSVParser.parse(file.readLine(), CSVFormat.DEFAULT)
                }
            } catch (e: IOException) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.IO_ERROR,
                    "Failed to read inputs, error: " + e.message
                )
            }
            record = parser.iterator().next()
            retry = true
        } while (record!!.size() != instructions.size)
        for ((i, instr0) in instructions.withIndex()) {
            val entry = symbolTable[instr0.op1]
            val value = entry!!.value
            when (entry.type!!.atomTypeId) {
                PuffinBasicAtomTypeId.INT32 -> value!!.int32 = record[i].trim { it <= ' ' }
                    .toInt()

                PuffinBasicAtomTypeId.INT64 -> value!!.int64 = record[i].trim { it <= ' ' }.toLong()
                PuffinBasicAtomTypeId.FLOAT -> value!!.float32 =
                    record[i].trim { it <= ' ' }.toFloat()

                PuffinBasicAtomTypeId.DOUBLE -> value!!.float64 =
                    record[i].trim { it <= ' ' }.toDouble()

                PuffinBasicAtomTypeId.STRING -> value!!.string = record[i].trim { it <= ' ' }

                else -> {}
            }
        }
    }

    @JvmStatic
    fun lineinput(
        files: PuffinBasicFiles,
        symbolTable: PuffinBasicSymbolTable,
        instr0: PuffinBasicIR.Instruction,
        instruction: PuffinBasicIR.Instruction
    ) {
        if (instruction.op1 != PuffinBasicSymbolTable.NULL_ID) {
            val prompt = symbolTable[instruction.op1]!!.value!!.string
            if (!prompt!!.isEmpty()) {
                files.sys.print(prompt)
            }
        }
        val file: PuffinBasicFile
        file = if (instruction.op2 != PuffinBasicSymbolTable.NULL_ID) {
            val fileNumber = symbolTable[instruction.op2]!!.value!!.int32
            files[fileNumber]
        } else {
            files.sys
        }
        symbolTable[instr0.op1]!!.value!!.string = file.readLine()
    }

    @JvmStatic
    fun middlr(
        symbolTable: PuffinBasicSymbolTable,
        instr0: PuffinBasicIR.Instruction,
        instr: PuffinBasicIR.Instruction
    ) {
        val dest = symbolTable[instr0.op1]!!.value
        val n = symbolTable[instr0.op2]!!.value!!.int32
        var m = symbolTable[instr.op1]!!.value!!.int32
        val replacement = symbolTable[instr.op2]!!.value!!.string
        val varValue = dest!!.string
        val varlen = varValue!!.length
        val result: String?
        if (n <= 0) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.INDEX_OUT_OF_BOUNDS,
                "INSTR: expected n > 0, actual=$n"
            )
        } else if (n > varlen) {
            result = varValue
        } else {
            if (m == -1 || m > replacement!!.length) {
                m = replacement!!.length
            }
            result = (varValue.substring(0, n - 1)
                    + replacement.substring(0, Math.min(m, varlen - n + 1))
                    + varValue.substring(Math.min(n + m - 1, varlen - 1)))
        }
        dest.string = result
    }

    @JvmStatic
    fun read(
        readData: ReadData,
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val variable = symbolTable.getVariable(instruction.op1)
        val data = readData.next()
        assertBothStringOrNumeric(
            variable.type!!.atomTypeId,
            data.type!!.atomTypeId
        ) {
            ("Read Data mismatch for variable: "
                    + variable
                    + " and data: "
                    + data.value!!.printFormat())
        }
        variable.value!!.assign(data.value!!)
    }

    @JvmStatic
    fun createInstance(
        symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction
    ) {
        val entry = symbolTable[instruction.op1] as STVariable?
        entry!!.createAndSetInstance(symbolTable)
    }

    @JvmStatic
    fun structLValue(
        symbolTable: PuffinBasicSymbolTable,
        params: List<PuffinBasicIR.Instruction>,
        instruction: PuffinBasicIR.Instruction
    ) {
        var root = symbolTable[instruction.op1]!!.value as STStruct?
        for (i in 0 until params.size - 1) {
            val childId = symbolTable[params[i].op1]!!.value!!.int32
            val valueId = root!!.getMember(childId)
            root = symbolTable[valueId]!!.value as STStruct?
        }
        val childId = symbolTable[params[params.size - 1].op1]!!.value!!.int32
        val valueId = root!!.getMember(childId)
        (symbolTable[instruction.result] as STRef?)!!.ref = symbolTable[valueId]
    }

    @JvmStatic
    fun memberFuncCall(
        symbolTable: PuffinBasicSymbolTable,
        params: List<PuffinBasicIR.Instruction>,
        instruction: PuffinBasicIR.Instruction
    ) {
        val funcParams = arrayOfNulls<STValue>(params.size)
        val `object` = symbolTable[instruction.op1]!!.value
        val funcName = symbolTable[instruction.op2]!!.value!!.string
        val result = symbolTable[instruction.result]!!.value
        for (i in params.indices) {
            funcParams[i] = symbolTable[params[i].op1]!!.value
        }
        `object`!!.call(funcName!!, funcParams.map { it!! }.toTypedArray(), result!!)
    }

    @JvmStatic
    fun structMemberRef(
        symbolTable: PuffinBasicSymbolTable,
        params: List<PuffinBasicIR.Instruction>,
        instruction: PuffinBasicIR.Instruction
    ) {
        var root = symbolTable[instruction.op1]!!.value as STStruct?
        for (i in 0 until params.size - 1) {
            val childId = symbolTable[params[i].op1]!!.value!!.int32
            val valueId = root!!.getMember(childId)
            root = symbolTable[valueId]!!.value as STStruct?
        }
        val childId = symbolTable[params[params.size - 1].op1]!!.value!!.int32
        val valueId = root!!.getMember(childId)
        symbolTable[instruction.result]!!.value!!.assign(symbolTable[valueId]!!.value!!)
    }

    class ReadData internal constructor(private val data: List<STEntry>) {
        private var cursor = 0
        operator fun next(): STEntry {
            return if (cursor < data.size) {
                data[cursor++]
            } else {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.OUT_OF_DATA,
                    "Out of data!"
                )
            }
        }

        fun restore() {
            cursor = 0
        }
    }
}