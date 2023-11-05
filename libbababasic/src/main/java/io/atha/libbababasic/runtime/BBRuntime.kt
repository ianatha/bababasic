package io.atha.libbababasic.runtime

import io.atha.libbababasic.domain.SymbolTable
import io.atha.libbababasic.error.InternalError
import io.atha.libbababasic.error.RuntimeError
import io.atha.libbababasic.error.SyntaxError
import io.atha.libbababasic.file.BBFiles
import io.atha.libbababasic.file.BBUIFile
import io.atha.libbababasic.parser.IR
import io.atha.libbababasic.parser.IR.OpCode
import io.atha.libbababasic.runtime.ArraysUtil.ArrayState
import io.atha.libbababasic.runtime.ArraysUtil.Companion.allocArray
import io.atha.libbababasic.runtime.ArraysUtil.Companion.array1DCopy
import io.atha.libbababasic.runtime.ArraysUtil.Companion.array1dBinSearch
import io.atha.libbababasic.runtime.ArraysUtil.Companion.array1dMax
import io.atha.libbababasic.runtime.ArraysUtil.Companion.array1dMean
import io.atha.libbababasic.runtime.ArraysUtil.Companion.array1dMedian
import io.atha.libbababasic.runtime.ArraysUtil.Companion.array1dMin
import io.atha.libbababasic.runtime.ArraysUtil.Companion.array1dPercentile
import io.atha.libbababasic.runtime.ArraysUtil.Companion.array1dSort
import io.atha.libbababasic.runtime.ArraysUtil.Companion.array1dStddev
import io.atha.libbababasic.runtime.ArraysUtil.Companion.array1dSum
import io.atha.libbababasic.runtime.ArraysUtil.Companion.array2dFindColumn
import io.atha.libbababasic.runtime.ArraysUtil.Companion.array2dFindRow
import io.atha.libbababasic.runtime.ArraysUtil.Companion.array2dShiftHorizontal
import io.atha.libbababasic.runtime.ArraysUtil.Companion.array2dShiftVertical
import io.atha.libbababasic.runtime.ArraysUtil.Companion.arrayCopy
import io.atha.libbababasic.runtime.ArraysUtil.Companion.arrayfill
import io.atha.libbababasic.runtime.ArraysUtil.Companion.arrayref
import io.atha.libbababasic.runtime.ArraysUtil.Companion.dim
import io.atha.libbababasic.runtime.ArraysUtil.Companion.reallocArray
import io.atha.libbababasic.runtime.ArraysUtil.Companion.resetIndex
import io.atha.libbababasic.runtime.ArraysUtil.Companion.setIndex
import io.atha.libbababasic.runtime.Formatter.FormatterCache
import io.atha.libbababasic.runtime.Functions.abs
import io.atha.libbababasic.runtime.Functions.acos
import io.atha.libbababasic.runtime.Functions.asc
import io.atha.libbababasic.runtime.Functions.asin
import io.atha.libbababasic.runtime.Functions.atn
import io.atha.libbababasic.runtime.Functions.cdbl
import io.atha.libbababasic.runtime.Functions.ceil
import io.atha.libbababasic.runtime.Functions.chrdlr
import io.atha.libbababasic.runtime.Functions.cint
import io.atha.libbababasic.runtime.Functions.clng
import io.atha.libbababasic.runtime.Functions.cos
import io.atha.libbababasic.runtime.Functions.cosh
import io.atha.libbababasic.runtime.Functions.csng
import io.atha.libbababasic.runtime.Functions.cvd
import io.atha.libbababasic.runtime.Functions.cvi
import io.atha.libbababasic.runtime.Functions.cvl
import io.atha.libbababasic.runtime.Functions.cvs
import io.atha.libbababasic.runtime.Functions.e
import io.atha.libbababasic.runtime.Functions.environdlr
import io.atha.libbababasic.runtime.Functions.eof
import io.atha.libbababasic.runtime.Functions.exp
import io.atha.libbababasic.runtime.Functions.fix
import io.atha.libbababasic.runtime.Functions.floor
import io.atha.libbababasic.runtime.Functions.fnint
import io.atha.libbababasic.runtime.Functions.hexdlr
import io.atha.libbababasic.runtime.Functions.inputdlr
import io.atha.libbababasic.runtime.Functions.instr
import io.atha.libbababasic.runtime.Functions.leftdlr
import io.atha.libbababasic.runtime.Functions.len
import io.atha.libbababasic.runtime.Functions.loc
import io.atha.libbababasic.runtime.Functions.lof
import io.atha.libbababasic.runtime.Functions.log
import io.atha.libbababasic.runtime.Functions.log10
import io.atha.libbababasic.runtime.Functions.log2
import io.atha.libbababasic.runtime.Functions.ltrimdlr
import io.atha.libbababasic.runtime.Functions.max
import io.atha.libbababasic.runtime.Functions.min
import io.atha.libbababasic.runtime.Functions.mkddlr
import io.atha.libbababasic.runtime.Functions.mkidlr
import io.atha.libbababasic.runtime.Functions.mkldlr
import io.atha.libbababasic.runtime.Functions.mksdlr
import io.atha.libbababasic.runtime.Functions.octdlr
import io.atha.libbababasic.runtime.Functions.pi
import io.atha.libbababasic.runtime.Functions.rightdlr
import io.atha.libbababasic.runtime.Functions.rnd
import io.atha.libbababasic.runtime.Functions.round
import io.atha.libbababasic.runtime.Functions.rtrimdlr
import io.atha.libbababasic.runtime.Functions.sgn
import io.atha.libbababasic.runtime.Functions.sin
import io.atha.libbababasic.runtime.Functions.sinh
import io.atha.libbababasic.runtime.Functions.spacedlr
import io.atha.libbababasic.runtime.Functions.splitdlr
import io.atha.libbababasic.runtime.Functions.sqr
import io.atha.libbababasic.runtime.Functions.strdlr
import io.atha.libbababasic.runtime.Functions.stringdlr
import io.atha.libbababasic.runtime.Functions.tan
import io.atha.libbababasic.runtime.Functions.tanh
import io.atha.libbababasic.runtime.Functions.timer
import io.atha.libbababasic.runtime.Functions.timerMillis
import io.atha.libbababasic.runtime.Functions.toDeg
import io.atha.libbababasic.runtime.Functions.toRad
import io.atha.libbababasic.runtime.Functions.`val`
import io.atha.libbababasic.runtime.Operators.addFloat32
import io.atha.libbababasic.runtime.Operators.addFloat64
import io.atha.libbababasic.runtime.Operators.addInt32
import io.atha.libbababasic.runtime.Operators.addInt64
import io.atha.libbababasic.runtime.Operators.and
import io.atha.libbababasic.runtime.Operators.concat
import io.atha.libbababasic.runtime.Operators.eqFloat32
import io.atha.libbababasic.runtime.Operators.eqFloat64
import io.atha.libbababasic.runtime.Operators.eqInt32
import io.atha.libbababasic.runtime.Operators.eqInt64
import io.atha.libbababasic.runtime.Operators.eqStr
import io.atha.libbababasic.runtime.Operators.eqv
import io.atha.libbababasic.runtime.Operators.expFloat32
import io.atha.libbababasic.runtime.Operators.expFloat64
import io.atha.libbababasic.runtime.Operators.expInt32
import io.atha.libbababasic.runtime.Operators.expInt64
import io.atha.libbababasic.runtime.Operators.fdiv
import io.atha.libbababasic.runtime.Operators.geFloat32
import io.atha.libbababasic.runtime.Operators.geFloat64
import io.atha.libbababasic.runtime.Operators.geInt32
import io.atha.libbababasic.runtime.Operators.geInt64
import io.atha.libbababasic.runtime.Operators.geStr
import io.atha.libbababasic.runtime.Operators.gtFloat32
import io.atha.libbababasic.runtime.Operators.gtFloat64
import io.atha.libbababasic.runtime.Operators.gtInt32
import io.atha.libbababasic.runtime.Operators.gtInt64
import io.atha.libbababasic.runtime.Operators.gtStr
import io.atha.libbababasic.runtime.Operators.idiv
import io.atha.libbababasic.runtime.Operators.imp
import io.atha.libbababasic.runtime.Operators.leFloat32
import io.atha.libbababasic.runtime.Operators.leFloat64
import io.atha.libbababasic.runtime.Operators.leInt32
import io.atha.libbababasic.runtime.Operators.leInt64
import io.atha.libbababasic.runtime.Operators.leStr
import io.atha.libbababasic.runtime.Operators.leftShift
import io.atha.libbababasic.runtime.Operators.ltFloat32
import io.atha.libbababasic.runtime.Operators.ltFloat64
import io.atha.libbababasic.runtime.Operators.ltInt32
import io.atha.libbababasic.runtime.Operators.ltInt64
import io.atha.libbababasic.runtime.Operators.ltStr
import io.atha.libbababasic.runtime.Operators.mod
import io.atha.libbababasic.runtime.Operators.mulFloat32
import io.atha.libbababasic.runtime.Operators.mulFloat64
import io.atha.libbababasic.runtime.Operators.mulInt32
import io.atha.libbababasic.runtime.Operators.mulInt64
import io.atha.libbababasic.runtime.Operators.neFloat32
import io.atha.libbababasic.runtime.Operators.neFloat64
import io.atha.libbababasic.runtime.Operators.neInt32
import io.atha.libbababasic.runtime.Operators.neInt64
import io.atha.libbababasic.runtime.Operators.neStr
import io.atha.libbababasic.runtime.Operators.or
import io.atha.libbababasic.runtime.Operators.rightShift
import io.atha.libbababasic.runtime.Operators.subFloat32
import io.atha.libbababasic.runtime.Operators.subFloat64
import io.atha.libbababasic.runtime.Operators.subInt32
import io.atha.libbababasic.runtime.Operators.subInt64
import io.atha.libbababasic.runtime.Operators.unaryMinus
import io.atha.libbababasic.runtime.Operators.unaryNot
import io.atha.libbababasic.runtime.Operators.xor
import io.atha.libbababasic.runtime.Statements.ReadData
import io.atha.libbababasic.runtime.Statements.close
import io.atha.libbababasic.runtime.Statements.closeAll
import io.atha.libbababasic.runtime.Statements.createInstance
import io.atha.libbababasic.runtime.Statements.field
import io.atha.libbababasic.runtime.Statements.flush
import io.atha.libbababasic.runtime.Statements.getf
import io.atha.libbababasic.runtime.Statements.input
import io.atha.libbababasic.runtime.Statements.lineinput
import io.atha.libbababasic.runtime.Statements.lset
import io.atha.libbababasic.runtime.Statements.memberFuncCall
import io.atha.libbababasic.runtime.Statements.open
import io.atha.libbababasic.runtime.Statements.print
import io.atha.libbababasic.runtime.Statements.printusing
import io.atha.libbababasic.runtime.Statements.putf
import io.atha.libbababasic.runtime.Statements.randomize
import io.atha.libbababasic.runtime.Statements.randomizeTimer
import io.atha.libbababasic.runtime.Statements.read
import io.atha.libbababasic.runtime.Statements.rset
import io.atha.libbababasic.runtime.Statements.sleep
import io.atha.libbababasic.runtime.Statements.structLValue
import io.atha.libbababasic.runtime.Statements.structMemberRef
import io.atha.libbababasic.runtime.Statements.swap
import io.atha.libbababasic.runtime.Statements.write
import io.atha.libbababasic.runtime.Types.copy
import io.atha.libbababasic.runtime.Types.paramCopy
import io.atha.libbababasic.runtime.Types.varref
import java.util.Random
import java.util.Stack
import java.util.stream.Collectors

class BBRuntime(
    private val ir: IR,
    private val stdio: BBUIFile,
    private val env: Environment,
    private val graphicsRuntime: GraphicsRuntime,
    private val soundState: SoundState
) {
    private var printBuffer: PrintBuffer? = null
    private var arrayState: ArrayState? = null
    private var gosubReturnLabelStack: Stack<Int>? = null
    private var programCounter = 0
    private var random: Random? = null
    private var labelToInstrNum: Map<Int, Int>? = null
    private var lineNumToInstrNum: Map<Int, Int>? = null
    private var params: MutableList<IR.Instruction>? = null
    private var formatterCache: FormatterCache? = null
    private var files: BBFiles? = null
    private var readData: ReadData? = null
    private fun computeLabelToInstructionNumber(instructions: List<IR.Instruction>): MutableMap<Int, Int> {
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
            throw InternalError("Failed to find instruction# for label: $id")
        }
        return instrNum
    }

    private fun computeLineNumberToInstructionNumber(instructions: List<IR.Instruction>): MutableMap<Int, Int> {
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
            throw InternalError("Failed to find instruction# for line#: $lineNumber")
        }
        return instrNum
    }

    @Throws(RuntimeError::class)
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
        files = BBFiles(stdio)
        readData = processDataInstructions(instructions)
        try {
            val numInstructions = instructions.size
            var end = false
            while (!end && programCounter < numInstructions) {
                val instruction = instructions[programCounter]
                end = try {
                    runInstruction(instruction)
                } catch (e: InternalError) {
                    throw RuntimeError(e, instruction, ir.getCodeStreamFor(instruction))
                } catch (e: SyntaxError) {
                    throw e
                } catch (e: RuntimeError) {
                    throw e
                } catch (e: Exception) {
                    throw RuntimeError(e, instruction, ir.getCodeStreamFor(instruction))
                }
            }
        } finally {
            graphicsRuntime.end()
            soundState.close()
        }
    }

    private fun processDataInstructions(instructions: List<IR.Instruction>): ReadData {
        return ReadData(
            instructions.stream()
                .filter { i: IR.Instruction -> i.opCode === OpCode.DATA }
                .map { instruction: IR.Instruction -> ir.symbolTable[instruction.op1]!! }
                .collect(Collectors.toList()))
    }

    private fun runInstruction(instruction: IR.Instruction): Boolean {
        var nextProgramCounter = programCounter + 1
        when (instruction.opCode) {
            OpCode.VARREF -> varref(ir.symbolTable, instruction)
            OpCode.DIM -> {
                if (params!!.isEmpty()) {
                    throw InternalError("Expected >0 params, but found none!")
                }
                dim(ir.symbolTable, params!!, instruction)
                params!!.clear()
            }

            OpCode.ALLOCARRAY -> {
                if (params!!.isEmpty()) {
                    throw InternalError("Expected >0 params, but found none!")
                }
                allocArray(ir.symbolTable, params!!, instruction)
                params!!.clear()
            }

            OpCode.REALLOCARRAY -> {
                if (params!!.isEmpty()) {
                    throw InternalError("Expected >0 params, but found none!")
                }
                reallocArray(ir.symbolTable, params!!, instruction)
                params!!.clear()
            }

            OpCode.CREATE_INSTANCE -> createInstance(ir.symbolTable, instruction)
            OpCode.STRUCT_LVALUE -> {
                if (params!!.isEmpty()) {
                    throw InternalError("Expected >0 params, but found none!")
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
                    throw InternalError("Expected >0 params, but found none!")
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
                nextProgramCounter = if (instruction.op1 == SymbolTable.NULL_ID) {
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
                    throw InternalError("Expected 2 params, but found: $params")
                }
                array1DCopy(ir.symbolTable, params!![0], params!![1], instruction)
                params!!.clear()
            }

            OpCode.ARRAY2DFINDROW -> {
                if (params!!.size != 2) {
                    throw InternalError("Expected 2 params, but found: $params")
                }
                array2dFindRow(ir.symbolTable, params!!, instruction)
                params!!.clear()
            }

            OpCode.ARRAY2DFINDCOLUMN -> {
                if (params!!.size != 2) {
                    throw InternalError("Expected 2 params, but found: $params")
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
                    throw InternalError("Expected 1 param, but found: $params")
                }
                instr(ir.symbolTable, params!![0], instruction)
                params!!.clear()
            }

            OpCode.MIDDLR -> {
                if (params!!.size != 1) {
                    throw InternalError("Expected 1 param, but found: $params")
                }
                Functions.middlr(ir.symbolTable, params!![0], instruction)
                params!!.clear()
            }

            OpCode.MIDDLR_STMT -> {
                if (params!!.size != 1) {
                    throw InternalError("Expected 1 param, but found: $params")
                }
                Statements.middlr(ir.symbolTable, params!![0], instruction)
                params!!.clear()
            }

            OpCode.OPEN -> {
                if (params!!.size != 2) {
                    throw InternalError("Expected 2 params, but found: $params")
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
                    throw InternalError("Expected 1 param, but found: $params")
                }
                graphicsRuntime.hsb2rgb(ir.symbolTable, params!![0], instruction)
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
                    throw InternalError("Expected 1 param, but found: $params")
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
                    throw InternalError("Expected 1 param, but found: $params")
                }
                graphicsRuntime.screen(ir.symbolTable, params, instruction)
                params!!.clear()
            }

            OpCode.REPAINT -> graphicsRuntime.repaint()
            OpCode.CIRCLE -> {
                if (params!!.size != 3) {
                    throw InternalError("Expected 3 params, but found: $params")
                }
                graphicsRuntime.circle(ir.symbolTable, params, instruction)
                params!!.clear()
            }

            OpCode.LINE -> {
                if (params!!.size != 2) {
                    throw InternalError("Expected 2 params, but found: $params")
                }
                graphicsRuntime.line(ir.symbolTable, params, instruction)
                params!!.clear()
            }

            OpCode.COLOR -> {
                if (params!!.size != 1) {
                    throw InternalError("Expected 1 params, but found: $params")
                }
                graphicsRuntime.color(ir.symbolTable, params!![0], instruction)
                params!!.clear()
            }

            OpCode.PAINT -> {
                if (params!!.size != 2) {
                    throw InternalError("Expected 2 params, but found: $params")
                }
                graphicsRuntime.paint(ir.symbolTable, params, instruction)
                params!!.clear()
            }

            OpCode.PSET -> {
                if (params!!.size != 2) {
                    throw InternalError("Expected 2 params, but found: $params")
                }
                graphicsRuntime.pset(ir.symbolTable, params, instruction)
                params!!.clear()
            }

            OpCode.GGET -> {
                if (params!!.size != 2) {
                    throw InternalError("Expected 2 params, but found: $params")
                }
                graphicsRuntime.get(ir.symbolTable, params, instruction)
                params!!.clear()
            }

            OpCode.GPUT -> {
                if (params!!.size != 2) {
                    throw InternalError("Expected 2 params, but found: $params")
                }
                graphicsRuntime.put(
                    ir.symbolTable,
                    params!![0],
                    params!![1],
                    instruction
                )
                params!!.clear()
            }

            OpCode.BUFFERCOPYHOR -> {
                if (params!!.size != 1) {
                    throw InternalError("Expected 1 param, but found: $params")
                }
                graphicsRuntime.bufferCopyHor(
                    ir.symbolTable,
                    params!![0],
                    instruction
                )
                params!!.clear()
            }

            OpCode.FONT -> {
                if (params!!.size != 1) {
                    throw InternalError("Expected 1 param, but found: $params")
                }
                graphicsRuntime.font(ir.symbolTable, params!![0], instruction)
                params!!.clear()
            }

            OpCode.DRAWSTR -> {
                if (params!!.size != 1) {
                    throw InternalError("Expected 1 param, but found: $params")
                }
                graphicsRuntime.drawstr(ir.symbolTable, params!![0], instruction)
                params!!.clear()
            }

            OpCode.LOADIMG -> graphicsRuntime.loadimg(ir.symbolTable, instruction)
            OpCode.SAVEIMG -> graphicsRuntime.saveimg(ir.symbolTable, instruction)
            OpCode.DRAW -> graphicsRuntime.draw(ir.symbolTable, instruction)
            OpCode.INKEYDLR -> graphicsRuntime.inkeydlr(ir.symbolTable, instruction)
            OpCode.CLS -> graphicsRuntime.cls()
            OpCode.BEEP -> graphicsRuntime.beep()
            OpCode.LOCATE -> {
                var row = ir.symbolTable[instruction.op1]!!.value!!.int32
                var col = if (instruction.op2 != SymbolTable.NULL_ID) {
                    ir.symbolTable[instruction.op2]!!.value!!.int32
                } else null
                graphicsRuntime.locate(row, col)
            }

            OpCode.LOADWAV -> graphicsRuntime.loadwav(soundState, ir.symbolTable, instruction)
            OpCode.PLAYWAV -> graphicsRuntime.playwav(soundState, ir.symbolTable, instruction)
            OpCode.STOPWAV -> graphicsRuntime.stopwav(soundState, ir.symbolTable, instruction)
            OpCode.LOOPWAV -> graphicsRuntime.loopwav(soundState, ir.symbolTable, instruction)
            OpCode.MOUSEMOVEDX -> graphicsRuntime.mouseMovedX(
                ir.symbolTable,
                instruction
            )

            OpCode.MOUSEMOVEDY -> graphicsRuntime.mouseMovedY(
                ir.symbolTable,
                instruction
            )

            OpCode.MOUSEDRAGGEDX -> graphicsRuntime.mouseDraggedX(
                ir.symbolTable,
                instruction
            )

            OpCode.MOUSEDRAGGEDY -> graphicsRuntime.mouseDraggedY(
                ir.symbolTable,
                instruction
            )

            OpCode.MOUSEBUTTONCLICKED -> graphicsRuntime.mouseButtonClicked(
                ir.symbolTable,
                instruction
            )

            OpCode.MOUSEBUTTONPRESSED -> graphicsRuntime.mouseButtonPressed(
                ir.symbolTable,
                instruction
            )

            OpCode.MOUSEBUTTONRELEASED -> graphicsRuntime.mouseButtonReleased(
                ir.symbolTable,
                instruction
            )

            OpCode.ISKEYPRESSED -> graphicsRuntime.isKeyPressed(
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