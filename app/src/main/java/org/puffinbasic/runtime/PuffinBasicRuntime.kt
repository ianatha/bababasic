package org.puffinbasic.runtime

import org.puffinbasic.domain.PuffinBasicSymbolTable
import org.puffinbasic.error.PuffinBasicInternalError
import org.puffinbasic.error.PuffinBasicRuntimeError
import org.puffinbasic.error.PuffinBasicSyntaxError
import org.puffinbasic.file.PuffinBasicFiles
import org.puffinbasic.file.PuffinUserInterfaceFile
import org.puffinbasic.parser.PuffinBasicIR
import org.puffinbasic.parser.PuffinBasicIR.OpCode
import org.puffinbasic.runtime.ArraysUtil.ArrayState
import org.puffinbasic.runtime.ArraysUtil.Companion.allocArray
import org.puffinbasic.runtime.ArraysUtil.Companion.array1DCopy
import org.puffinbasic.runtime.ArraysUtil.Companion.array1dBinSearch
import org.puffinbasic.runtime.ArraysUtil.Companion.array1dMax
import org.puffinbasic.runtime.ArraysUtil.Companion.array1dMean
import org.puffinbasic.runtime.ArraysUtil.Companion.array1dMedian
import org.puffinbasic.runtime.ArraysUtil.Companion.array1dMin
import org.puffinbasic.runtime.ArraysUtil.Companion.array1dPercentile
import org.puffinbasic.runtime.ArraysUtil.Companion.array1dSort
import org.puffinbasic.runtime.ArraysUtil.Companion.array1dStddev
import org.puffinbasic.runtime.ArraysUtil.Companion.array1dSum
import org.puffinbasic.runtime.ArraysUtil.Companion.array2dFindColumn
import org.puffinbasic.runtime.ArraysUtil.Companion.array2dFindRow
import org.puffinbasic.runtime.ArraysUtil.Companion.array2dShiftHorizontal
import org.puffinbasic.runtime.ArraysUtil.Companion.array2dShiftVertical
import org.puffinbasic.runtime.ArraysUtil.Companion.arrayCopy
import org.puffinbasic.runtime.ArraysUtil.Companion.arrayfill
import org.puffinbasic.runtime.ArraysUtil.Companion.arrayref
import org.puffinbasic.runtime.ArraysUtil.Companion.dim
import org.puffinbasic.runtime.ArraysUtil.Companion.reallocArray
import org.puffinbasic.runtime.ArraysUtil.Companion.resetIndex
import org.puffinbasic.runtime.ArraysUtil.Companion.setIndex
import org.puffinbasic.runtime.Formatter.FormatterCache
import org.puffinbasic.runtime.Functions.abs
import org.puffinbasic.runtime.Functions.acos
import org.puffinbasic.runtime.Functions.asc
import org.puffinbasic.runtime.Functions.asin
import org.puffinbasic.runtime.Functions.atn
import org.puffinbasic.runtime.Functions.cdbl
import org.puffinbasic.runtime.Functions.ceil
import org.puffinbasic.runtime.Functions.chrdlr
import org.puffinbasic.runtime.Functions.cint
import org.puffinbasic.runtime.Functions.clng
import org.puffinbasic.runtime.Functions.cos
import org.puffinbasic.runtime.Functions.cosh
import org.puffinbasic.runtime.Functions.csng
import org.puffinbasic.runtime.Functions.cvd
import org.puffinbasic.runtime.Functions.cvi
import org.puffinbasic.runtime.Functions.cvl
import org.puffinbasic.runtime.Functions.cvs
import org.puffinbasic.runtime.Functions.e
import org.puffinbasic.runtime.Functions.environdlr
import org.puffinbasic.runtime.Functions.eof
import org.puffinbasic.runtime.Functions.exp
import org.puffinbasic.runtime.Functions.fix
import org.puffinbasic.runtime.Functions.floor
import org.puffinbasic.runtime.Functions.fnint
import org.puffinbasic.runtime.Functions.hexdlr
import org.puffinbasic.runtime.Functions.inputdlr
import org.puffinbasic.runtime.Functions.instr
import org.puffinbasic.runtime.Functions.leftdlr
import org.puffinbasic.runtime.Functions.len
import org.puffinbasic.runtime.Functions.loc
import org.puffinbasic.runtime.Functions.lof
import org.puffinbasic.runtime.Functions.log
import org.puffinbasic.runtime.Functions.log10
import org.puffinbasic.runtime.Functions.log2
import org.puffinbasic.runtime.Functions.ltrimdlr
import org.puffinbasic.runtime.Functions.max
import org.puffinbasic.runtime.Functions.min
import org.puffinbasic.runtime.Functions.mkddlr
import org.puffinbasic.runtime.Functions.mkidlr
import org.puffinbasic.runtime.Functions.mkldlr
import org.puffinbasic.runtime.Functions.mksdlr
import org.puffinbasic.runtime.Functions.octdlr
import org.puffinbasic.runtime.Functions.pi
import org.puffinbasic.runtime.Functions.rightdlr
import org.puffinbasic.runtime.Functions.rnd
import org.puffinbasic.runtime.Functions.round
import org.puffinbasic.runtime.Functions.rtrimdlr
import org.puffinbasic.runtime.Functions.sgn
import org.puffinbasic.runtime.Functions.sin
import org.puffinbasic.runtime.Functions.sinh
import org.puffinbasic.runtime.Functions.spacedlr
import org.puffinbasic.runtime.Functions.splitdlr
import org.puffinbasic.runtime.Functions.sqr
import org.puffinbasic.runtime.Functions.strdlr
import org.puffinbasic.runtime.Functions.stringdlr
import org.puffinbasic.runtime.Functions.tan
import org.puffinbasic.runtime.Functions.tanh
import org.puffinbasic.runtime.Functions.timer
import org.puffinbasic.runtime.Functions.timerMillis
import org.puffinbasic.runtime.Functions.toDeg
import org.puffinbasic.runtime.Functions.toRad
import org.puffinbasic.runtime.Functions.`val`
import org.puffinbasic.runtime.Operators.addFloat32
import org.puffinbasic.runtime.Operators.addFloat64
import org.puffinbasic.runtime.Operators.addInt32
import org.puffinbasic.runtime.Operators.addInt64
import org.puffinbasic.runtime.Operators.and
import org.puffinbasic.runtime.Operators.concat
import org.puffinbasic.runtime.Operators.eqFloat32
import org.puffinbasic.runtime.Operators.eqFloat64
import org.puffinbasic.runtime.Operators.eqInt32
import org.puffinbasic.runtime.Operators.eqInt64
import org.puffinbasic.runtime.Operators.eqStr
import org.puffinbasic.runtime.Operators.eqv
import org.puffinbasic.runtime.Operators.expFloat32
import org.puffinbasic.runtime.Operators.expFloat64
import org.puffinbasic.runtime.Operators.expInt32
import org.puffinbasic.runtime.Operators.expInt64
import org.puffinbasic.runtime.Operators.fdiv
import org.puffinbasic.runtime.Operators.geFloat32
import org.puffinbasic.runtime.Operators.geFloat64
import org.puffinbasic.runtime.Operators.geInt32
import org.puffinbasic.runtime.Operators.geInt64
import org.puffinbasic.runtime.Operators.geStr
import org.puffinbasic.runtime.Operators.gtFloat32
import org.puffinbasic.runtime.Operators.gtFloat64
import org.puffinbasic.runtime.Operators.gtInt32
import org.puffinbasic.runtime.Operators.gtInt64
import org.puffinbasic.runtime.Operators.gtStr
import org.puffinbasic.runtime.Operators.idiv
import org.puffinbasic.runtime.Operators.imp
import org.puffinbasic.runtime.Operators.leFloat32
import org.puffinbasic.runtime.Operators.leFloat64
import org.puffinbasic.runtime.Operators.leInt32
import org.puffinbasic.runtime.Operators.leInt64
import org.puffinbasic.runtime.Operators.leStr
import org.puffinbasic.runtime.Operators.leftShift
import org.puffinbasic.runtime.Operators.ltFloat32
import org.puffinbasic.runtime.Operators.ltFloat64
import org.puffinbasic.runtime.Operators.ltInt32
import org.puffinbasic.runtime.Operators.ltInt64
import org.puffinbasic.runtime.Operators.ltStr
import org.puffinbasic.runtime.Operators.mod
import org.puffinbasic.runtime.Operators.mulFloat32
import org.puffinbasic.runtime.Operators.mulFloat64
import org.puffinbasic.runtime.Operators.mulInt32
import org.puffinbasic.runtime.Operators.mulInt64
import org.puffinbasic.runtime.Operators.neFloat32
import org.puffinbasic.runtime.Operators.neFloat64
import org.puffinbasic.runtime.Operators.neInt32
import org.puffinbasic.runtime.Operators.neInt64
import org.puffinbasic.runtime.Operators.neStr
import org.puffinbasic.runtime.Operators.or
import org.puffinbasic.runtime.Operators.rightShift
import org.puffinbasic.runtime.Operators.subFloat32
import org.puffinbasic.runtime.Operators.subFloat64
import org.puffinbasic.runtime.Operators.subInt32
import org.puffinbasic.runtime.Operators.subInt64
import org.puffinbasic.runtime.Operators.unaryMinus
import org.puffinbasic.runtime.Operators.unaryNot
import org.puffinbasic.runtime.Operators.xor
import org.puffinbasic.runtime.Statements.ReadData
import org.puffinbasic.runtime.Statements.close
import org.puffinbasic.runtime.Statements.closeAll
import org.puffinbasic.runtime.Statements.createInstance
import org.puffinbasic.runtime.Statements.field
import org.puffinbasic.runtime.Statements.flush
import org.puffinbasic.runtime.Statements.getf
import org.puffinbasic.runtime.Statements.input
import org.puffinbasic.runtime.Statements.lineinput
import org.puffinbasic.runtime.Statements.lset
import org.puffinbasic.runtime.Statements.memberFuncCall
import org.puffinbasic.runtime.Statements.open
import org.puffinbasic.runtime.Statements.print
import org.puffinbasic.runtime.Statements.printusing
import org.puffinbasic.runtime.Statements.putf
import org.puffinbasic.runtime.Statements.randomize
import org.puffinbasic.runtime.Statements.randomizeTimer
import org.puffinbasic.runtime.Statements.read
import org.puffinbasic.runtime.Statements.rset
import org.puffinbasic.runtime.Statements.sleep
import org.puffinbasic.runtime.Statements.structLValue
import org.puffinbasic.runtime.Statements.structMemberRef
import org.puffinbasic.runtime.Statements.swap
import org.puffinbasic.runtime.Statements.write
import org.puffinbasic.runtime.Types.copy
import org.puffinbasic.runtime.Types.paramCopy
import org.puffinbasic.runtime.Types.varref
import java.util.Random
import java.util.Stack
import java.util.stream.Collectors

class PuffinBasicRuntime(
    private val ir: PuffinBasicIR,
    private val stdio: PuffinUserInterfaceFile,
    private val env: Environment
) {
    private var printBuffer: PrintBuffer? = null
    private var arrayState: ArrayState? = null
    private var gosubReturnLabelStack: Stack<Int>? = null
    private var programCounter = 0
    private var random: Random? = null
    private var labelToInstrNum: Map<Int, Int>? = null
    private var lineNumToInstrNum: Map<Int, Int>? = null
    private var params: MutableList<PuffinBasicIR.Instruction>? = null
    private var formatterCache: FormatterCache? = null
    private var files: PuffinBasicFiles? = null
    private var readData: ReadData? = null
    private var graphicsState: GraphicsRuntime.GraphicsState? = null
    private var soundState: SoundState? = null
    private fun computeLabelToInstructionNumber(instructions: List<PuffinBasicIR.Instruction>): MutableMap<Int, Int> {
        val labelToInstrNum: MutableMap<Int, Int> = mutableMapOf()
        for (i in instructions.indices) {
            val instr = instructions[i]
            if (instr.opCode === OpCode.LABEL) {
                labelToInstrNum[instr.op1] = i
            }
        }
        return labelToInstrNum
    }

    private fun getInstrNumForLabel(id: Int): Int {
        val instrNum = labelToInstrNum!!.getOrDefault(id, -1)
        if (instrNum == -1) {
            throw PuffinBasicInternalError("Failed to find instruction# for label: $id")
        }
        return instrNum
    }

    private fun computeLineNumberToInstructionNumber(instructions: List<PuffinBasicIR.Instruction>): MutableMap<Int, Int> {
        val linenumToInstrNum: MutableMap<Int, Int> = mutableMapOf()
        for ((instrNum, instruction) in instructions.withIndex()) {
            val lineNumber = instruction.inputRef.lineNumber
            if (lineNumber >= 0) {
                linenumToInstrNum.putIfAbsent(lineNumber, instrNum)
            }
        }
        return linenumToInstrNum
    }

    private fun getInstrNumForLineNumber(lineNumber: Int): Int {
        val instrNum = lineNumToInstrNum!!.getOrDefault(lineNumber, -1)
        if (instrNum == -1) {
            throw PuffinBasicInternalError("Failed to find instruction# for line#: $lineNumber")
        }
        return instrNum
    }

    @Throws(PuffinBasicRuntimeError::class)
    fun run() {
        val instructions = ir.getInstructions()
        labelToInstrNum = computeLabelToInstructionNumber(instructions)
        lineNumToInstrNum = computeLineNumberToInstructionNumber(instructions)
        printBuffer = PrintBuffer()
        arrayState = ArrayState()
        gosubReturnLabelStack = Stack<Int>()
        random = Random()
        formatterCache = FormatterCache()
        params = ArrayList(4)
        files = PuffinBasicFiles(stdio)
        readData = processDataInstructions(instructions)
        graphicsState = GraphicsRuntime.GraphicsState(stdio)
        soundState = SoundState()
        try {
            val numInstructions = instructions.size
            var end = false
            while (!end && programCounter < numInstructions) {
                val instruction = instructions[programCounter]
                end = try {
                    runInstruction(instruction)
                } catch (e: PuffinBasicInternalError) {
                    throw PuffinBasicRuntimeError(e, instruction, ir.getCodeStreamFor(instruction))
                } catch (e: PuffinBasicSyntaxError) {
                    throw e
                } catch (e: PuffinBasicRuntimeError) {
                    throw e
                } catch (e: Exception) {
                    throw PuffinBasicRuntimeError(e, instruction, ir.getCodeStreamFor(instruction))
                }
            }
        } finally {
            GraphicsRuntime.end(graphicsState)
            soundState!!.close()
        }
    }

    private fun processDataInstructions(instructions: List<PuffinBasicIR.Instruction>): ReadData {
        return ReadData(
            instructions.stream()
                .filter { i: PuffinBasicIR.Instruction -> i.opCode === OpCode.DATA }
                .map { instruction: PuffinBasicIR.Instruction -> ir.symbolTable[instruction.op1]!! }
                .collect(Collectors.toList()))
    }

    private fun runInstruction(instruction: PuffinBasicIR.Instruction): Boolean {
        var nextProgramCounter = programCounter + 1
        when (instruction.opCode) {
            OpCode.VARREF -> varref(ir.symbolTable, instruction)
            OpCode.DIM -> {
                if (params!!.isEmpty()) {
                    throw PuffinBasicInternalError("Expected >0 params, but found none!")
                }
                dim(ir.symbolTable, params!!, instruction)
                params!!.clear()
            }

            OpCode.ALLOCARRAY -> {
                if (params!!.isEmpty()) {
                    throw PuffinBasicInternalError("Expected >0 params, but found none!")
                }
                allocArray(ir.symbolTable, params!!, instruction)
                params!!.clear()
            }

            OpCode.REALLOCARRAY -> {
                if (params!!.isEmpty()) {
                    throw PuffinBasicInternalError("Expected >0 params, but found none!")
                }
                reallocArray(ir.symbolTable, params!!, instruction)
                params!!.clear()
            }

            OpCode.CREATE_INSTANCE -> createInstance(ir.symbolTable, instruction)
            OpCode.STRUCT_LVALUE -> {
                if (params!!.isEmpty()) {
                    throw PuffinBasicInternalError("Expected >0 params, but found none!")
                }
                structLValue(ir.symbolTable, params!!, instruction)
                params!!.clear()
            }

            OpCode.MEMBER_FUNC_CALL -> {
                memberFuncCall(ir.symbolTable, params!!, instruction)
                params!!.clear()
            }

            OpCode.STRUCT_MEMBER_REF -> {
                if (params!!.isEmpty()) {
                    throw PuffinBasicInternalError("Expected >0 params, but found none!")
                }
                structMemberRef(ir.symbolTable, params!!, instruction)
                params!!.clear()
            }

            OpCode.ASSIGN, OpCode.COPY -> copy(ir.symbolTable, instruction)
            OpCode.PARAM_COPY -> paramCopy(ir.symbolTable, instruction)
            OpCode.UNARY_MINUS -> unaryMinus(ir.symbolTable, instruction)
            OpCode.PRINT -> print(printBuffer!!, ir.symbolTable, instruction)
            OpCode.PRINTUSING -> printusing(
                formatterCache!!,
                printBuffer!!,
                ir.symbolTable,
                instruction
            )

            OpCode.FLUSH -> flush(files!!, printBuffer!!, ir.symbolTable, instruction)
            OpCode.RESET_ARRAY_IDX -> resetIndex(arrayState!!, ir.symbolTable, instruction)
            OpCode.SET_ARRAY_IDX -> setIndex(arrayState!!, ir.symbolTable, instruction)
            OpCode.ARRAYREF -> arrayref(ir.symbolTable, instruction)
            OpCode.LABEL -> {}
            OpCode.GOTO_LINENUM -> {
                val lineNumber = ir.symbolTable[instruction.op1]!!.value!!.int32
                nextProgramCounter = getInstrNumForLineNumber(lineNumber)
            }

            OpCode.GOTO_LABEL_IF -> {
                if (ir.symbolTable[instruction.op1]!!.value!!.int64 != 0L) {
                    nextProgramCounter = getInstrNumForLabel(instruction.op2)
                }
            }

            OpCode.GOTO_LABEL -> nextProgramCounter = getInstrNumForLabel(instruction.op1)
            OpCode.GOTO_CALLER -> nextProgramCounter = ir.symbolTable.currentScope!!.callerInstrId
            OpCode.PUSH_RT_SCOPE -> ir.symbolTable.pushRuntimeScope(
                instruction.op1,
                getInstrNumForLabel(instruction.op2)
            )

            OpCode.POP_RT_SCOPE -> ir.symbolTable.popScope()
            OpCode.PUSH_RETLABEL -> gosubReturnLabelStack!!.push(instruction.op1)
            OpCode.RETURN -> {
                nextProgramCounter = if (instruction.op1 == PuffinBasicSymbolTable.NULL_ID) {
                    getInstrNumForLabel(gosubReturnLabelStack!!.pop())
                } else {
                    // Ignore label because we need to return to the lineNumber
                    gosubReturnLabelStack!!.pop()
                    val lineNumber = ir.symbolTable[instruction.op1]!!.value!!.int32
                    getInstrNumForLineNumber(lineNumber)
                }
            }

            OpCode.EXPI32 -> expInt32(ir.symbolTable, instruction)
            OpCode.EXPI64 -> expInt64(ir.symbolTable, instruction)
            OpCode.EXPF32 -> expFloat32(ir.symbolTable, instruction)
            OpCode.EXPF64 -> expFloat64(ir.symbolTable, instruction)
            OpCode.MULI32 -> mulInt32(ir.symbolTable, instruction)
            OpCode.MULI64 -> mulInt64(ir.symbolTable, instruction)
            OpCode.MULF32 -> mulFloat32(ir.symbolTable, instruction)
            OpCode.MULF64 -> mulFloat64(ir.symbolTable, instruction)
            OpCode.IDIV -> idiv(ir.symbolTable, instruction)
            OpCode.FDIV -> fdiv(ir.symbolTable, instruction)
            OpCode.ADDI32 -> addInt32(ir.symbolTable, instruction)
            OpCode.ADDI64 -> addInt64(ir.symbolTable, instruction)
            OpCode.ADDF32 -> addFloat32(ir.symbolTable, instruction)
            OpCode.ADDF64 -> addFloat64(ir.symbolTable, instruction)
            OpCode.SUBI32 -> subInt32(ir.symbolTable, instruction)
            OpCode.SUBI64 -> subInt64(ir.symbolTable, instruction)
            OpCode.SUBF32 -> subFloat32(ir.symbolTable, instruction)
            OpCode.SUBF64 -> subFloat64(ir.symbolTable, instruction)
            OpCode.MOD -> mod(ir.symbolTable, instruction)
            OpCode.EQI32 -> eqInt32(ir.symbolTable, instruction)
            OpCode.EQI64 -> eqInt64(ir.symbolTable, instruction)
            OpCode.EQF32 -> eqFloat32(ir.symbolTable, instruction)
            OpCode.EQF64 -> eqFloat64(ir.symbolTable, instruction)
            OpCode.EQSTR -> eqStr(ir.symbolTable, instruction)
            OpCode.NEI32 -> neInt32(ir.symbolTable, instruction)
            OpCode.NEI64 -> neInt64(ir.symbolTable, instruction)
            OpCode.NEF32 -> neFloat32(ir.symbolTable, instruction)
            OpCode.NEF64 -> neFloat64(ir.symbolTable, instruction)
            OpCode.NESTR -> neStr(ir.symbolTable, instruction)
            OpCode.LTI32 -> ltInt32(ir.symbolTable, instruction)
            OpCode.LTI64 -> ltInt64(ir.symbolTable, instruction)
            OpCode.LTF32 -> ltFloat32(ir.symbolTable, instruction)
            OpCode.LTF64 -> ltFloat64(ir.symbolTable, instruction)
            OpCode.LTSTR -> ltStr(ir.symbolTable, instruction)
            OpCode.LEI32 -> leInt32(ir.symbolTable, instruction)
            OpCode.LEI64 -> leInt64(ir.symbolTable, instruction)
            OpCode.LEF32 -> leFloat32(ir.symbolTable, instruction)
            OpCode.LEF64 -> leFloat64(ir.symbolTable, instruction)
            OpCode.LESTR -> leStr(ir.symbolTable, instruction)
            OpCode.GTI32 -> gtInt32(ir.symbolTable, instruction)
            OpCode.GTI64 -> gtInt64(ir.symbolTable, instruction)
            OpCode.GTF32 -> gtFloat32(ir.symbolTable, instruction)
            OpCode.GTF64 -> gtFloat64(ir.symbolTable, instruction)
            OpCode.GTSTR -> gtStr(ir.symbolTable, instruction)
            OpCode.GEI32 -> geInt32(ir.symbolTable, instruction)
            OpCode.GEI64 -> geInt64(ir.symbolTable, instruction)
            OpCode.GEF32 -> geFloat32(ir.symbolTable, instruction)
            OpCode.GEF64 -> geFloat64(ir.symbolTable, instruction)
            OpCode.GESTR -> geStr(ir.symbolTable, instruction)
            OpCode.NOT -> unaryNot(ir.symbolTable, instruction)
            OpCode.AND -> and(ir.symbolTable, instruction)
            OpCode.OR -> or(ir.symbolTable, instruction)
            OpCode.XOR -> xor(ir.symbolTable, instruction)
            OpCode.EQV -> eqv(ir.symbolTable, instruction)
            OpCode.IMP -> imp(ir.symbolTable, instruction)
            OpCode.LEFTSHIFT -> leftShift(ir.symbolTable, instruction)
            OpCode.RIGHTSHIFT -> rightShift(ir.symbolTable, instruction)
            OpCode.END -> return true
            OpCode.ABS -> abs(ir.symbolTable, instruction)
            OpCode.ASC -> asc(ir.symbolTable, instruction)
            OpCode.SIN -> sin(ir.symbolTable, instruction)
            OpCode.COS -> cos(ir.symbolTable, instruction)
            OpCode.TAN -> tan(ir.symbolTable, instruction)
            OpCode.ASIN -> asin(ir.symbolTable, instruction)
            OpCode.ACOS -> acos(ir.symbolTable, instruction)
            OpCode.ATN -> atn(ir.symbolTable, instruction)
            OpCode.SINH -> sinh(ir.symbolTable, instruction)
            OpCode.COSH -> cosh(ir.symbolTable, instruction)
            OpCode.TANH -> tanh(ir.symbolTable, instruction)
            OpCode.SQR -> sqr(ir.symbolTable, instruction)
            OpCode.LOG -> log(ir.symbolTable, instruction)
            OpCode.LOG10 -> log10(ir.symbolTable, instruction)
            OpCode.LOG2 -> log2(ir.symbolTable, instruction)
            OpCode.EEXP -> exp(ir.symbolTable, instruction)
            OpCode.TORAD -> toRad(ir.symbolTable, instruction)
            OpCode.TODEG -> toDeg(ir.symbolTable, instruction)
            OpCode.FLOOR -> floor(ir.symbolTable, instruction)
            OpCode.CEIL -> ceil(ir.symbolTable, instruction)
            OpCode.ROUND -> round(ir.symbolTable, instruction)
            OpCode.E -> e(ir.symbolTable, instruction)
            OpCode.PI -> pi(ir.symbolTable, instruction)
            OpCode.MIN -> min(ir.symbolTable, instruction)
            OpCode.MAX -> max(ir.symbolTable, instruction)
            OpCode.ARRAYFILL -> arrayfill(ir.symbolTable, instruction)
            OpCode.ARRAYCOPY -> arrayCopy(ir.symbolTable, instruction)
            OpCode.ARRAY1DMIN -> array1dMin(ir.symbolTable, instruction)
            OpCode.ARRAY1DMAX -> array1dMax(ir.symbolTable, instruction)
            OpCode.ARRAY1DMEAN -> array1dMean(ir.symbolTable, instruction)
            OpCode.ARRAY1DSUM -> array1dSum(ir.symbolTable, instruction)
            OpCode.ARRAY1DSTD -> array1dStddev(ir.symbolTable, instruction)
            OpCode.ARRAY1DMEDIAN -> array1dMedian(ir.symbolTable, instruction)
            OpCode.ARRAY1DPCT -> array1dPercentile(ir.symbolTable, instruction)
            OpCode.ARRAY1DSORT -> array1dSort(ir.symbolTable, instruction)
            OpCode.ARRAY1DBINSEARCH -> array1dBinSearch(ir.symbolTable, instruction)
            OpCode.ARRAY2DSHIFTVER -> array2dShiftVertical(ir.symbolTable, instruction)
            OpCode.ARRAY2DSHIFTHOR -> array2dShiftHorizontal(ir.symbolTable, instruction)
            OpCode.ARRAY1DCOPY -> {
                if (params!!.size != 2) {
                    throw PuffinBasicInternalError("Expected 2 params, but found: $params")
                }
                array1DCopy(ir.symbolTable, params!![0], params!![1], instruction)
                params!!.clear()
            }

            OpCode.ARRAY2DFINDROW -> {
                if (params!!.size != 2) {
                    throw PuffinBasicInternalError("Expected 2 params, but found: $params")
                }
                array2dFindRow(ir.symbolTable, params!!, instruction)
                params!!.clear()
            }

            OpCode.ARRAY2DFINDCOLUMN -> {
                if (params!!.size != 2) {
                    throw PuffinBasicInternalError("Expected 2 params, but found: $params")
                }
                array2dFindColumn(ir.symbolTable, params!!, instruction)
                params!!.clear()
            }

            OpCode.CINT -> cint(ir.symbolTable, instruction)
            OpCode.CLNG -> clng(ir.symbolTable, instruction)
            OpCode.CSNG -> csng(ir.symbolTable, instruction)
            OpCode.CDBL -> cdbl(ir.symbolTable, instruction)
            OpCode.CHRDLR -> chrdlr(ir.symbolTable, instruction)
            OpCode.CVI -> cvi(ir.symbolTable, instruction)
            OpCode.CVL -> cvl(ir.symbolTable, instruction)
            OpCode.CVS -> cvs(ir.symbolTable, instruction)
            OpCode.CVD -> cvd(ir.symbolTable, instruction)
            OpCode.MKIDLR -> mkidlr(ir.symbolTable, instruction)
            OpCode.MKLDLR -> mkldlr(ir.symbolTable, instruction)
            OpCode.MKSDLR -> mksdlr(ir.symbolTable, instruction)
            OpCode.MKDDLR -> mkddlr(ir.symbolTable, instruction)
            OpCode.SPACEDLR -> spacedlr(ir.symbolTable, instruction)
            OpCode.STRDLR -> strdlr(ir.symbolTable, instruction)
            OpCode.VAL -> `val`(ir.symbolTable, instruction)
            OpCode.INT -> fnint(ir.symbolTable, instruction)
            OpCode.FIX -> fix(ir.symbolTable, instruction)
            OpCode.LEN -> len(ir.symbolTable, instruction)
            OpCode.HEXDLR -> hexdlr(ir.symbolTable, instruction)
            OpCode.OCTDLR -> octdlr(ir.symbolTable, instruction)
            OpCode.LEFTDLR -> leftdlr(ir.symbolTable, instruction)
            OpCode.RIGHTDLR -> rightdlr(ir.symbolTable, instruction)
            OpCode.SPLITDLR -> splitdlr(ir.symbolTable, instruction)
            OpCode.PARAM1, OpCode.PARAM2 -> params!!.add(instruction)
            OpCode.INSTR -> {
                if (params!!.size != 1) {
                    throw PuffinBasicInternalError("Expected 1 param, but found: $params")
                }
                instr(ir.symbolTable, params!![0], instruction)
                params!!.clear()
            }

            OpCode.MIDDLR -> {
                if (params!!.size != 1) {
                    throw PuffinBasicInternalError("Expected 1 param, but found: $params")
                }
                Functions.middlr(ir.symbolTable, params!![0], instruction)
                params!!.clear()
            }

            OpCode.MIDDLR_STMT -> {
                if (params!!.size != 1) {
                    throw PuffinBasicInternalError("Expected 1 param, but found: $params")
                }
                Statements.middlr(ir.symbolTable, params!![0], instruction)
                params!!.clear()
            }

            OpCode.OPEN -> {
                if (params!!.size != 2) {
                    throw PuffinBasicInternalError("Expected 2 params, but found: $params")
                }
                open(files!!, ir.symbolTable, params!![0], params!![1], instruction)
                params!!.clear()
            }

            OpCode.CLOSE_ALL -> closeAll(files!!)
            OpCode.CLOSE -> close(files!!, ir.symbolTable, instruction)
            OpCode.FIELD -> {
                field(files!!, ir.symbolTable, params!!, instruction)
                params!!.clear()
            }

            OpCode.HSB2RGB -> {
                if (params!!.size != 1) {
                    throw PuffinBasicInternalError("Expected 1 param, but found: $params")
                }
                GraphicsRuntime.hsb2rgb(ir.symbolTable, params!![0], instruction)
                params!!.clear()
            }

            OpCode.PUTF -> putf(files!!, ir.symbolTable, instruction)
            OpCode.GETF -> getf(files!!, ir.symbolTable, instruction)
            OpCode.LOC -> loc(files!!, ir.symbolTable, instruction)
            OpCode.LOF -> lof(files!!, ir.symbolTable, instruction)
            OpCode.EOF -> eof(files!!, ir.symbolTable, instruction)
            OpCode.RND -> rnd(random!!, ir.symbolTable, instruction)
            OpCode.RANDOMIZE -> randomize(random!!, ir.symbolTable, instruction)
            OpCode.RANDOMIZE_TIMER -> randomizeTimer(random!!)
            OpCode.SGN -> sgn(ir.symbolTable, instruction)
            OpCode.LSET -> lset(ir.symbolTable, instruction)
            OpCode.RSET -> rset(ir.symbolTable, instruction)
            OpCode.TIMER -> timer(ir.symbolTable, instruction)
            OpCode.TIMERMILLIS -> timerMillis(ir.symbolTable, instruction)
            OpCode.STRINGDLR -> stringdlr(ir.symbolTable, instruction)
            OpCode.SWAP -> swap(ir.symbolTable, instruction)
            OpCode.CONCAT -> concat(ir.symbolTable, instruction)
            OpCode.INPUTDLR -> inputdlr(files!!, ir.symbolTable, instruction)
            OpCode.INPUT -> {
                input(files!!, ir.symbolTable, params!!, instruction)
                params!!.clear()
            }

            OpCode.LINE_INPUT -> {
                if (params!!.size != 1) {
                    throw PuffinBasicInternalError("Expected 1 param, but found: $params")
                }
                lineinput(files!!, ir.symbolTable, params!![0], instruction)
                params!!.clear()
            }

            OpCode.WRITE -> write(printBuffer!!, ir.symbolTable, instruction)
            OpCode.DATA -> {}
            OpCode.RESTORE -> readData!!.restore()
            OpCode.READ -> read(readData!!, ir.symbolTable, instruction)
            OpCode.ENVIRONDLR -> environdlr(env, ir.symbolTable, instruction)
            OpCode.SLEEP -> sleep(ir.symbolTable, instruction)
            OpCode.SCREEN -> {
                if (params!!.size != 3) {
                    throw PuffinBasicInternalError("Expected 1 param, but found: $params")
                }
                GraphicsRuntime.screen(graphicsState, ir.symbolTable, params, instruction)
                params!!.clear()
            }

            OpCode.REPAINT -> GraphicsRuntime.repaint(graphicsState)
            OpCode.CIRCLE -> {
                if (params!!.size != 3) {
                    throw PuffinBasicInternalError("Expected 3 params, but found: $params")
                }
                GraphicsRuntime.circle(graphicsState, ir.symbolTable, params, instruction)
                params!!.clear()
            }

            OpCode.LINE -> {
                if (params!!.size != 2) {
                    throw PuffinBasicInternalError("Expected 2 params, but found: $params")
                }
                GraphicsRuntime.line(graphicsState, ir.symbolTable, params, instruction)
                params!!.clear()
            }

            OpCode.COLOR -> {
                if (params!!.size != 1) {
                    throw PuffinBasicInternalError("Expected 1 params, but found: $params")
                }
                GraphicsRuntime.color(graphicsState, ir.symbolTable, params!![0], instruction)
                params!!.clear()
            }

            OpCode.PAINT -> {
                if (params!!.size != 2) {
                    throw PuffinBasicInternalError("Expected 2 params, but found: $params")
                }
                GraphicsRuntime.paint(graphicsState, ir.symbolTable, params, instruction)
                params!!.clear()
            }

            OpCode.PSET -> {
                if (params!!.size != 2) {
                    throw PuffinBasicInternalError("Expected 2 params, but found: $params")
                }
                GraphicsRuntime.pset(graphicsState, ir.symbolTable, params, instruction)
                params!!.clear()
            }

            OpCode.GGET -> {
                if (params!!.size != 2) {
                    throw PuffinBasicInternalError("Expected 2 params, but found: $params")
                }
                GraphicsRuntime.get(graphicsState, ir.symbolTable, params, instruction)
                params!!.clear()
            }

            OpCode.GPUT -> {
                if (params!!.size != 2) {
                    throw PuffinBasicInternalError("Expected 2 params, but found: $params")
                }
                GraphicsRuntime.put(
                    graphicsState,
                    ir.symbolTable,
                    params!![0],
                    params!![1],
                    instruction
                )
                params!!.clear()
            }

            OpCode.BUFFERCOPYHOR -> {
                if (params!!.size != 1) {
                    throw PuffinBasicInternalError("Expected 1 param, but found: $params")
                }
                GraphicsRuntime.bufferCopyHor(
                    graphicsState,
                    ir.symbolTable,
                    params!![0],
                    instruction
                )
                params!!.clear()
            }

            OpCode.FONT -> {
                if (params!!.size != 1) {
                    throw PuffinBasicInternalError("Expected 1 param, but found: $params")
                }
                GraphicsRuntime.font(graphicsState, ir.symbolTable, params!![0], instruction)
                params!!.clear()
            }

            OpCode.DRAWSTR -> {
                if (params!!.size != 1) {
                    throw PuffinBasicInternalError("Expected 1 param, but found: $params")
                }
                GraphicsRuntime.drawstr(graphicsState, ir.symbolTable, params!![0], instruction)
                params!!.clear()
            }

            OpCode.LOADIMG -> GraphicsRuntime.loadimg(ir.symbolTable, instruction)
            OpCode.SAVEIMG -> GraphicsRuntime.saveimg(ir.symbolTable, instruction)
            OpCode.DRAW -> GraphicsRuntime.draw(graphicsState, ir.symbolTable, instruction)
            OpCode.INKEYDLR -> GraphicsRuntime.inkeydlr(graphicsState, ir.symbolTable, instruction)
            OpCode.CLS -> GraphicsRuntime.cls(graphicsState)
            OpCode.BEEP -> GraphicsRuntime.beep(graphicsState)
            OpCode.LOCATE -> {
                var row = ir.symbolTable[instruction.op1]!!.value!!.int32
                var col = if (instruction.op2 != PuffinBasicSymbolTable.NULL_ID) {
                    ir.symbolTable[instruction.op2]!!.value!!.int32
                } else null
                GraphicsRuntime.locate(graphicsState, row, col)
            }

            OpCode.LOADWAV -> GraphicsRuntime.loadwav(soundState, ir.symbolTable, instruction)
            OpCode.PLAYWAV -> GraphicsRuntime.playwav(soundState, ir.symbolTable, instruction)
            OpCode.STOPWAV -> GraphicsRuntime.stopwav(soundState, ir.symbolTable, instruction)
            OpCode.LOOPWAV -> GraphicsRuntime.loopwav(soundState, ir.symbolTable, instruction)
            OpCode.MOUSEMOVEDX -> GraphicsRuntime.mouseMovedX(
                graphicsState,
                ir.symbolTable,
                instruction
            )

            OpCode.MOUSEMOVEDY -> GraphicsRuntime.mouseMovedY(
                graphicsState,
                ir.symbolTable,
                instruction
            )

            OpCode.MOUSEDRAGGEDX -> GraphicsRuntime.mouseDraggedX(
                graphicsState,
                ir.symbolTable,
                instruction
            )

            OpCode.MOUSEDRAGGEDY -> GraphicsRuntime.mouseDraggedY(
                graphicsState,
                ir.symbolTable,
                instruction
            )

            OpCode.MOUSEBUTTONCLICKED -> GraphicsRuntime.mouseButtonClicked(
                graphicsState,
                ir.symbolTable,
                instruction
            )

            OpCode.MOUSEBUTTONPRESSED -> GraphicsRuntime.mouseButtonPressed(
                graphicsState,
                ir.symbolTable,
                instruction
            )

            OpCode.MOUSEBUTTONRELEASED -> GraphicsRuntime.mouseButtonReleased(
                graphicsState,
                ir.symbolTable,
                instruction
            )

            OpCode.ISKEYPRESSED -> GraphicsRuntime.isKeyPressed(
                graphicsState,
                ir.symbolTable,
                instruction
            )

            OpCode.LTRIMDLR -> ltrimdlr(ir.symbolTable, instruction)
            OpCode.RTRIMDLR -> rtrimdlr(ir.symbolTable, instruction)
            OpCode.COMMENT -> {}
            OpCode.VARIABLE -> {}
            OpCode.VALUE -> {}
        }
        programCounter = nextProgramCounter
        return false
    }
}