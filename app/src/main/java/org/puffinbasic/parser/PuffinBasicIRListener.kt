package org.puffinbasic.parser

import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.misc.Interval
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.ParseTreeProperty
import org.antlr.v4.runtime.tree.TerminalNode
import org.puffinbasic.antlr4.PuffinBasicBaseListener
import org.puffinbasic.antlr4.PuffinBasicParser
import org.puffinbasic.antlr4.PuffinBasicParser.AccessContext
import org.puffinbasic.antlr4.PuffinBasicParser.Array1dcopystmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.Array1dsortstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.Array2dshifthorstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.Array2dshiftverstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.ArraycopystmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.ArrayfillstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.AutoletstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.BeepstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.CirclestmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.ClosestmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.ClsstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.ColorstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.CommentContext
import org.puffinbasic.antlr4.PuffinBasicParser.DatastmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.DefdblstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.DeffnstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.DefintstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.DeflngstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.DefsngstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.DefstrstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.DictstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.DimstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.DrawstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.DrawstrstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.ElsebeginstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.ElsestmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.EndifstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.EndstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.ExprBitwiseContext
import org.puffinbasic.antlr4.PuffinBasicParser.ExprContext
import org.puffinbasic.antlr4.PuffinBasicParser.ExprExpContext
import org.puffinbasic.antlr4.PuffinBasicParser.ExprFuncContext
import org.puffinbasic.antlr4.PuffinBasicParser.ExprLogNotContext
import org.puffinbasic.antlr4.PuffinBasicParser.ExprLogicalContext
import org.puffinbasic.antlr4.PuffinBasicParser.ExprModContext
import org.puffinbasic.antlr4.PuffinBasicParser.ExprMulDivContext
import org.puffinbasic.antlr4.PuffinBasicParser.ExprNumberContext
import org.puffinbasic.antlr4.PuffinBasicParser.ExprParenContext
import org.puffinbasic.antlr4.PuffinBasicParser.ExprPlusMinusContext
import org.puffinbasic.antlr4.PuffinBasicParser.ExprRelationalContext
import org.puffinbasic.antlr4.PuffinBasicParser.ExprStringContext
import org.puffinbasic.antlr4.PuffinBasicParser.ExprVariableContext
import org.puffinbasic.antlr4.PuffinBasicParser.FieldstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.Filemode1Context
import org.puffinbasic.antlr4.PuffinBasicParser.Filemode2Context
import org.puffinbasic.antlr4.PuffinBasicParser.FontstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.ForstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncACosContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncASinContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncAbsContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncAllocArrayContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncArray1DBinSearchContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncArray1DMaxContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncArray1DMeanContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncArray1DMedianContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncArray1DMinContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncArray1DPctContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncArray1DStdContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncArray1DSumContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncArray2DFindColumnContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncArray2DFindRowContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncAscContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncAtnContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncCdblContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncCeilContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncChrDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncCintContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncClngContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncCosContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncCoshContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncCsngContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncCvdContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncCviContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncCvlContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncCvsContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncEContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncEnvironDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncEofContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncExpContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncFixContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncFloorContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncHexDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncHsb2RgbContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncInkeyDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncInputDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncInstrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncIntContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncIsKeyPressedContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncLTrimDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncLeftDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncLenContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncLocContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncLofContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncLog10Context
import org.puffinbasic.antlr4.PuffinBasicParser.FuncLog2Context
import org.puffinbasic.antlr4.PuffinBasicParser.FuncLogContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncMaxContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncMemberMethodCallContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncMidDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncMinContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncMkdDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncMkiDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncMklDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncMksDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncMouseButtonClickedContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncMouseButtonPressedContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncMouseButtonReleasedContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncMouseDraggedXContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncMouseDraggedYContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncMouseMovedXContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncMouseMovedYContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncOctDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncPIContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncRTrimDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncRightDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncRndContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncRoundContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncSgnContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncSinContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncSinhContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncSpaceDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncSplitDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncSqrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncStrDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncStringDlrContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncTanContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncTanhContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncTimerContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncTimerMillisContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncToDegContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncToRadContext
import org.puffinbasic.antlr4.PuffinBasicParser.FuncValContext
import org.puffinbasic.antlr4.PuffinBasicParser.FunctionbeginstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.FunctionendstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.FunctionreturnstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.GetstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.GosublabelstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.GosubstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.GotolabelstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.GotostmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.GraphicsbuffercopyhorstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.GraphicsgetstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.GraphicsputstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.IfThenElseContext
import org.puffinbasic.antlr4.PuffinBasicParser.IfthenbeginstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.ImportstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.InputhashstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.InputstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.LabelstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.LeafvariableContext
import org.puffinbasic.antlr4.PuffinBasicParser.LetstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.LineContext
import org.puffinbasic.antlr4.PuffinBasicParser.LineinputhashstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.LineinputstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.LinestmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.ListstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.LoadimgstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.LoadwavstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.LocatestmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.LockContext
import org.puffinbasic.antlr4.PuffinBasicParser.LoopwavstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.LsetstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.MiddlrstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.NextstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.NumberContext
import org.puffinbasic.antlr4.PuffinBasicParser.Open1stmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.Open2stmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.PaintstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.PlaywavstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.PrinthashstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.PrinthashusingstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.PrintstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.PrintusingstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.PsetstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.PutstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.RandomizestmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.RandomizetimerstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.ReadstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.ReallocstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.RepaintstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.RestorestmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.ReturnstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.RsetstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.SaveimgstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.ScreenstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.SetstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.SleepstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.StopwavstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.StructinstancestmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.StructstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.StructvariableContext
import org.puffinbasic.antlr4.PuffinBasicParser.SwapstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.ThenContext
import org.puffinbasic.antlr4.PuffinBasicParser.VarnameContext
import org.puffinbasic.antlr4.PuffinBasicParser.VarsuffixContext
import org.puffinbasic.antlr4.PuffinBasicParser.WendstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.WhilestmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.WritehashstmtContext
import org.puffinbasic.antlr4.PuffinBasicParser.WritestmtContext
import org.puffinbasic.domain.PuffinBasicSymbolTable
import org.puffinbasic.domain.STObjects
import org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId
import org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.Companion.lookup
import org.puffinbasic.domain.STObjects.PuffinBasicType
import org.puffinbasic.domain.STObjects.PuffinBasicTypeId
import org.puffinbasic.domain.STObjects.STEntry
import org.puffinbasic.domain.STObjects.STLValue
import org.puffinbasic.domain.STObjects.STUDF
import org.puffinbasic.domain.STObjects.STVariable
import org.puffinbasic.domain.STObjects.ScalarType
import org.puffinbasic.domain.STObjects.StructType
import org.puffinbasic.domain.Variable
import org.puffinbasic.domain.Variable.Companion.of
import org.puffinbasic.domain.Variable.VariableKindHint
import org.puffinbasic.domain.Variable.VariableName
import org.puffinbasic.domain.variableConsumer
import org.puffinbasic.error.PuffinBasicInternalError
import org.puffinbasic.error.PuffinBasicSemanticError
import org.puffinbasic.file.PuffinBasicFile
import org.puffinbasic.file.PuffinBasicFile.FileAccessMode
import org.puffinbasic.file.PuffinBasicFile.FileOpenMode
import org.puffinbasic.parser.LinenumberListener.Companion.parseLinenum
import org.puffinbasic.parser.PuffinBasicIR.OpCode
import org.puffinbasic.runtime.BabaSystem
import org.puffinbasic.runtime.Numbers.parseFloat32
import org.puffinbasic.runtime.Numbers.parseFloat64
import org.puffinbasic.runtime.Numbers.parseInt32
import org.puffinbasic.runtime.Numbers.parseInt64
import org.puffinbasic.runtime.Types
import java.util.LinkedList
import java.util.concurrent.atomic.AtomicInteger
import java.util.function.Consumer
import java.util.function.Supplier
import java.util.stream.Collectors

class PuffinBasicIRListener(
    private val sourceFile: PuffinBasicSourceFile,
    private val `in`: CharStream,
    private val ir: PuffinBasicIR,
    private val graphics: Boolean
) : PuffinBasicBaseListener() {
    private val linenumGenerator: AtomicInteger = AtomicInteger()
    private val nodeToInstruction: ParseTreeProperty<PuffinBasicIR.Instruction> =
        ParseTreeProperty()
    private val udfStateMap: MutableMap<Variable, UDFState> = mutableMapOf()
    private val whileLoopStateList: LinkedList<WhileLoopState>
    private val forLoopStateList: LinkedList<ForLoopState>
    private val ifStateList: LinkedList<IfState>
    private val nodeToIfState: ParseTreeProperty<IfState>
    private var currentUdfState: UDFState? = null
    private var currentLineNumber = 0

    init {
        whileLoopStateList = LinkedList()
        forLoopStateList = LinkedList()
        ifStateList = LinkedList()
        nodeToIfState = ParseTreeProperty()
    }

    fun semanticCheckAfterParsing() {
        if (!whileLoopStateList.isEmpty()) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.WHILE_WITHOUT_WEND,
                "<UNKNOWN LINE>",
                "WHILE without WEND"
            )
        }
        if (!forLoopStateList.isEmpty()) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.FOR_WITHOUT_NEXT,
                "<UNKNOWN LINE>",
                "FOR without NEXT"
            )
        }
    }

    //
    // Variable, Number, etc.
    //
    private fun getCtxString(ctx: ParserRuleContext): String {
        return `in`.getText(
            Interval(
                ctx.start.startIndex, ctx.stop.stopIndex
            )
        )
    }

    private fun lookupInstruction(ctx: ParserRuleContext): PuffinBasicIR.Instruction {
        return nodeToInstruction[ctx]
            ?: throw PuffinBasicInternalError(
                "Failed to find instruction for node: " + ctx.text
            )
    }

    override fun enterLine(ctx: LineContext) {
        currentLineNumber = if (ctx.linenum() != null) parseLinenum(
            ctx.linenum().DECIMAL().text
        ) else linenumGenerator.incrementAndGet()
    }

    override fun exitNumber(ctx: NumberContext) {
        val id: Int
        if (ctx.integer() != null) {
            val isLong = ctx.integer().AT() != null
            val isDouble = ctx.integer().HASH() != null
            val isFloat = ctx.integer().EXCLAMATION() != null
            val strValue: String
            val base: Int
            if (ctx.integer().HEXADECIMAL() != null) {
                strValue = ctx.integer().HEXADECIMAL().text.substring(2)
                base = 16
            } else if (ctx.integer().OCTAL() != null) {
                val octalStr = ctx.integer().OCTAL().text
                strValue =
                    if (octalStr.startsWith("&O")) octalStr.substring(2) else octalStr.substring(1)
                base = 8
            } else {
                strValue = ctx.integer().DECIMAL().text
                base = 10
            }
            if (isLong || isDouble) {
                val parsed = parseInt64(strValue, base) { getCtxString(ctx) }
                id = ir.symbolTable.addTmp(
                    if (isLong) PuffinBasicAtomTypeId.INT64 else PuffinBasicAtomTypeId.DOUBLE
                ) { entry: STEntry? -> entry!!.value!!.int64 = parsed }
            } else {
                id = ir.symbolTable.addTmp(
                    if (isFloat) PuffinBasicAtomTypeId.FLOAT else PuffinBasicAtomTypeId.INT32
                ) { entry: STEntry? ->
                    entry!!.value!!.int32 = parseInt32(strValue, base) { getCtxString(ctx) }
                }
            }
        } else if (ctx.FLOAT() != null) {
            var floatStr = ctx.FLOAT().text
            if (floatStr.endsWith("!")) {
                floatStr = floatStr.substring(0, floatStr.length - 1)
            }
            val floatValue = parseFloat32(floatStr) { getCtxString(ctx) }
            id = ir.symbolTable.addTmp(
                PuffinBasicAtomTypeId.FLOAT
            ) { entry: STEntry? -> entry!!.value!!.float32 = floatValue }
        } else {
            var doubleStr = ctx.DOUBLE().text
            if (doubleStr.endsWith("#")) {
                doubleStr = doubleStr.substring(0, doubleStr.length - 1)
            }
            val doubleValue = parseFloat64(doubleStr) { getCtxString(ctx) }
            id = ir.symbolTable.addTmp(
                PuffinBasicAtomTypeId.DOUBLE
            ) { entry: STEntry? -> entry!!.value!!.float64 = doubleValue }
        }
        val instr = ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.VALUE, id, PuffinBasicSymbolTable.NULL_ID, id
        )
        nodeToInstruction.put(ctx, instr)
    }

    //
    // Expr
    //
    override fun exitVariable(ctx: PuffinBasicParser.VariableContext) {
        val instruction =
            if (ctx.leafvariable() != null) exitLeafVariable(ctx.leafvariable()) else exitStructVariable(
                ctx.structvariable()
            )
        nodeToInstruction.put(ctx, instruction)
    }

    private fun exitLeafVariable(ctx: LeafvariableContext): PuffinBasicIR.Instruction {
        ir.symbolTable.checkUnused(ctx.varname().VARNAME().text)
        val variableName = getVariableNameFromCtx(ctx.varname(), ctx.varsuffix())
        val idHolder = AtomicInteger()
        ir.symbolTable.addVariableOrUDF(
            variableName,
            { variableName1: VariableName? ->
                of(
                    variableName1!!, VariableKindHint.DERIVE_FROM_NAME
                ) { getCtxString(ctx) }
            },
            variableConsumer { varId: Int, varEntry: STVariable, variable: Variable ->
                idHolder.set(varId)
                if (variable.isScalar) {
                    // Scalar
                    if (ctx.expr().isNotEmpty()) {
                        throw PuffinBasicSemanticError(
                            PuffinBasicSemanticError.ErrorCode.SCALAR_VARIABLE_CANNOT_BE_INDEXED,
                            getCtxString(ctx),
                            "Scalar variable cannot be indexed: $variable"
                        )
                    }
                } else if (variable.isArray) {
                    if (ctx.expr().isNotEmpty()) {
                        // Array
                        ir.addInstruction(
                            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                            OpCode.RESET_ARRAY_IDX,
                            varId, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
                        )
                        for (exprCtx in ctx.expr()) {
                            val exprInstr = lookupInstruction(exprCtx)
                            ir.addInstruction(
                                sourceFile,
                                currentLineNumber,
                                ctx.start.startIndex,
                                ctx.stop.stopIndex,
                                OpCode.SET_ARRAY_IDX,
                                varId,
                                exprInstr.result,
                                PuffinBasicSymbolTable.NULL_ID
                            )
                        }
                        val refId = ir.symbolTable.addArrayReference(varEntry)
                        ir.addInstruction(
                            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                            OpCode.ARRAYREF,
                            varId, refId, refId
                        )
                        idHolder.set(refId)
                    }
                } else if (variable.isUDF) {
                    // UDF
                    val udfEntry = varEntry as STUDF
                    val udfState = udfStateMap[variable]!!

                    // Create & Push Runtime scope
                    val pushScopeInstr = ir.addInstruction(
                        sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                        OpCode.PUSH_RT_SCOPE,
                        varId, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
                    )
                    // Copy caller params to Runtime scope
                    if (ctx.expr().size != udfEntry.numDeclaredParams) {
                        throw PuffinBasicSemanticError(
                            PuffinBasicSemanticError.ErrorCode.INSUFFICIENT_UDF_ARGS,
                            getCtxString(ctx),
                            variable
                                .toString() + " expects "
                                    + udfEntry.numDeclaredParams
                                    + ", #args passed: "
                                    + ctx.expr().size
                        )
                    }
                    for ((i, exprCtx) in ctx.expr().withIndex()) {
                        val exprInstr = lookupInstruction(exprCtx)
                        val declParamId = udfEntry.getDeclaredParam(i)
                        ir.addInstruction(
                            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                            OpCode.PARAM_COPY,
                            exprInstr.result, declParamId, declParamId
                        )
                    }
                    // GOTO labelFuncStart
                    ir.addInstruction(
                        sourceFile,
                        currentLineNumber,
                        ctx.start.startIndex,
                        ctx.stop.stopIndex,
                        OpCode.GOTO_LABEL,
                        udfState.labelFuncStart!!.op1,
                        PuffinBasicSymbolTable.NULL_ID,
                        PuffinBasicSymbolTable.NULL_ID
                    )
                    // LABEL caller return address
                    val labelCallerReturn = ir.addInstruction(
                        sourceFile,
                        currentLineNumber,
                        ctx.start.startIndex,
                        ctx.stop.stopIndex,
                        OpCode.LABEL,
                        ir.symbolTable.addLabel(),
                        PuffinBasicSymbolTable.NULL_ID,
                        PuffinBasicSymbolTable.NULL_ID
                    )
                    // Patch address of the caller
                    pushScopeInstr.patchOp2(labelCallerReturn.op1)
                    // Pop Runtime scope
                    ir.addInstruction(
                        sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                        OpCode.POP_RT_SCOPE,
                        varId, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
                    )
                }
            })
        val refId = idHolder.get()
        return ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.VARIABLE, refId, PuffinBasicSymbolTable.NULL_ID, refId
        )
    }

    private fun exitStructVariable(ctx: StructvariableContext): PuffinBasicIR.Instruction {
        val root = ctx.varname(0).VARNAME().text
        val rootId = ir.symbolTable.getCompositeVariableIdForVariable(
            VariableName(root, null, PuffinBasicAtomTypeId.COMPOSITE)
        )
        val structType = ir.symbolTable[rootId]!!.type!!.asStruct()
        var parentTypeName: String? = structType!!.typeName
        for (i in 1 until ctx.varname().size) {
            val struct = ir.symbolTable.getStructType(parentTypeName!!)
            val childVarname = ctx.varname(i).VARNAME().text
            val childName = VariableName(childVarname, null, PuffinBasicAtomTypeId.COMPOSITE)
            val childRefId = struct.getMemberRefId(childName)
            val childTypeName = struct.getMemberType(childName)!!.asStruct()!!.typeName
            ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.PARAM1,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
                    e!!.value!!.int32 = childRefId
                },
                PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
            )
            parentTypeName = childTypeName
        }
        val struct = ir.symbolTable.getStructType(parentTypeName!!)
        val leafCtx = ctx.leafvariable()
        val leafVarname = leafCtx.varname().VARNAME().text
        val leafDataType = if (struct.containsMember(
                VariableName(
                    leafVarname,
                    null,
                    PuffinBasicAtomTypeId.COMPOSITE
                )
            )
        ) struct.getMemberType(
            VariableName(
                leafVarname,
                null,
                PuffinBasicAtomTypeId.COMPOSITE
            )
        )!!.atomTypeId else ir.symbolTable.getDataTypeFor(
            leafVarname,
            if (leafCtx.varsuffix() != null) leafCtx.varsuffix().text else null
        )
        val leafName = VariableName(leafVarname, leafDataType.getRepr(), leafDataType)
        val leafRefId = struct.getMemberRefId(leafName)
        val leafType = struct.getMemberType(leafName)
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM1,
            ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
                e!!.value!!.int32 = leafRefId
            },
            PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
        )
        var result = ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.STRUCT_LVALUE,
            rootId, PuffinBasicSymbolTable.NULL_ID,
            ir.symbolTable.addRef(leafType)
        )
        if (ctx.expr().isNotEmpty()) {
            ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.RESET_ARRAY_IDX,
                result.result, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
            )
            for (exprCtx in ctx.expr()) {
                val exprInstr = lookupInstruction(exprCtx)
                ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                    OpCode.SET_ARRAY_IDX,
                    result.result, exprInstr.result, PuffinBasicSymbolTable.NULL_ID
                )
            }
            val refId = ir.symbolTable.addArrayReference(
                (ir.symbolTable[result.result] as STLValue?)!!
            )
            result = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.ARRAYREF,
                result.result, refId, refId
            )
        }
        return result
    }

    private fun copyAndRegisterExprResult(
        ctx: ParserRuleContext,
        instruction: PuffinBasicIR.Instruction,
        shouldCopy: Boolean
    ) {
        var _instruction = instruction
        if (shouldCopy) {
            val copy = ir.symbolTable.addTmpCompatibleWith(instruction.result)
            _instruction = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.COPY, instruction.result, copy, copy
            )
        }
        nodeToInstruction.put(ctx, _instruction)
    }

    override fun exitExprVariable(ctx: ExprVariableContext) {
        var instruction = nodeToInstruction[ctx.variable()]
        val varEntry = ir.symbolTable[instruction.result]
        var copy = varEntry is STVariable && varEntry.variable.isUDF
        if (ctx.MINUS() != null) {
            if (ir.symbolTable[instruction.result]!!.type!!.atomTypeId === PuffinBasicAtomTypeId.STRING) {
                throw PuffinBasicSemanticError(
                    PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH,
                    getCtxString(ctx),
                    "Unary minus cannot be used with a String!"
                )
            }
            instruction = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.UNARY_MINUS, instruction.result, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmpCompatibleWith(instruction.result)
            )
            copy = true
        }
        copyAndRegisterExprResult(ctx, instruction, copy)
    }

    override fun exitExprParen(ctx: ExprParenContext) {
        nodeToInstruction.put(ctx, lookupInstruction(ctx.expr()))
    }

    override fun exitExprNumber(ctx: ExprNumberContext) {
        var instruction = nodeToInstruction[ctx.number()]
        if (ctx.MINUS() != null) {
            instruction = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.UNARY_MINUS, instruction.result, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmpCompatibleWith(instruction.result)
            )
        }
        copyAndRegisterExprResult(ctx, instruction, false)
    }

    override fun exitExprFunc(ctx: ExprFuncContext) {
        var instruction = nodeToInstruction[ctx.func()]
        if (ctx.MINUS() != null) {
            instruction = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.UNARY_MINUS, instruction.result, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmpCompatibleWith(instruction.result)
            )
        }
        copyAndRegisterExprResult(ctx, instruction, false)
    }

    override fun exitExprString(ctx: ExprStringContext) {
        val text = Types.unquote(ctx.string().STRING().text)
        val id = ir.symbolTable.addTmp(
            PuffinBasicAtomTypeId.STRING
        ) { entry: STEntry? -> entry!!.value!!.string = text }
        copyAndRegisterExprResult(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.VALUE, id, PuffinBasicSymbolTable.NULL_ID, id
            ), false
        )
    }

    override fun exitExprExp(ctx: ExprExpContext) {
        val expr1 = ctx.expr(0)
        val expr2 = ctx.expr(1)
        val instr1res = lookupInstruction(expr1).result
        val instr2res = lookupInstruction(expr2).result
        val dt1 = ir.symbolTable[instr1res]!!.type!!.atomTypeId
        val dt2 = ir.symbolTable[instr2res]!!.type!!.atomTypeId
        Types.assertNumeric(dt1, dt2) { getCtxString(ctx) }
        val upcast = Types.upcast(dt1, dt2) { getCtxString(ctx) }
        val result = ir.symbolTable.addTmp(upcast) { _: STEntry? -> }
        val opCode: OpCode = when (upcast) {
            PuffinBasicAtomTypeId.INT32 -> OpCode.EXPI32
            PuffinBasicAtomTypeId.INT64 -> OpCode.EXPI64
            PuffinBasicAtomTypeId.FLOAT -> OpCode.EXPF32
            PuffinBasicAtomTypeId.DOUBLE -> OpCode.EXPF64
            else -> throw PuffinBasicInternalError("Bad type: $upcast")
        }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                opCode, instr1res, instr2res, result
            )
        )
    }

    override fun exitExprMulDiv(ctx: ExprMulDivContext) {
        val expr1 = ctx.expr(0)
        val expr2 = ctx.expr(1)
        val instr1res = lookupInstruction(expr1).result
        val instr2res = lookupInstruction(expr2).result
        val dt1 = ir.symbolTable[instr1res]!!.type!!.atomTypeId
        val dt2 = ir.symbolTable[instr2res]!!.type!!.atomTypeId
        Types.assertNumeric(dt1, dt2) { getCtxString(ctx) }
        val upcast = Types.upcast(dt1, dt2) { getCtxString(ctx) }
        val result: Int
        val opCode: OpCode
        if (ctx.MUL() != null) {
            result = ir.symbolTable.addTmp(upcast) { e: STEntry? -> }
            opCode = when (upcast) {
                PuffinBasicAtomTypeId.INT32 -> OpCode.MULI32
                PuffinBasicAtomTypeId.INT64 -> OpCode.MULI64
                PuffinBasicAtomTypeId.FLOAT -> OpCode.MULF32
                PuffinBasicAtomTypeId.DOUBLE -> OpCode.MULF64
                else -> throw PuffinBasicInternalError("Bad type: $upcast")
            }
        } else if (ctx.INT_DIV() != null) {
            result = ir.symbolTable.addTmp(upcast) { e: STEntry? -> }
            opCode = OpCode.IDIV
        } else {
            result = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { e: STEntry? -> }
            opCode = OpCode.FDIV
        }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                opCode, instr1res, instr2res, result
            )
        )
    }

    override fun exitExprMod(ctx: ExprModContext) {
        addArithmeticOpExpr(ctx, OpCode.MOD, ctx.expr(0), ctx.expr(1))
    }

    override fun exitExprPlusMinus(ctx: ExprPlusMinusContext) {
        val expr1 = ctx.expr(0)
        val expr2 = ctx.expr(1)
        val instr1res = lookupInstruction(expr1).result
        val instr2res = lookupInstruction(expr2).result
        val dt1 = ir.symbolTable[instr1res]!!.type!!.atomTypeId
        val dt2 = ir.symbolTable[instr2res]!!.type!!.atomTypeId
        val plus = ctx.PLUS() != null
        if (dt1 === PuffinBasicAtomTypeId.STRING && dt2 === PuffinBasicAtomTypeId.STRING) {
            if (plus) {
                nodeToInstruction.put(ctx, ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                    OpCode.CONCAT, instr1res, instr2res,
                    ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { e: STEntry? -> }
                ))
            } else {
                throw PuffinBasicSemanticError(
                    PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH,
                    getCtxString(ctx),
                    "Minus ('-') doesn't work with String data type!"
                )
            }
        } else {
            Types.assertNumeric(dt1, dt2) { getCtxString(ctx) }
            val upcast = Types.upcast(dt1, dt2) { getCtxString(ctx) }
            val result = ir.symbolTable.addTmp(upcast) { e: STEntry? -> }
            val opCode: OpCode = when (upcast) {
                PuffinBasicAtomTypeId.INT32 -> if (plus) OpCode.ADDI32 else OpCode.SUBI32
                PuffinBasicAtomTypeId.INT64 -> if (plus) OpCode.ADDI64 else OpCode.SUBI64
                PuffinBasicAtomTypeId.FLOAT -> if (plus) OpCode.ADDF32 else OpCode.SUBF32
                PuffinBasicAtomTypeId.DOUBLE -> if (plus) OpCode.ADDF64 else OpCode.SUBF64
                else -> throw PuffinBasicInternalError("Bad type: $upcast")
            }
            nodeToInstruction.put(
                ctx, ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                    opCode, instr1res, instr2res, result
                )
            )
        }
    }

    private fun addArithmeticOpExpr(
        parent: ParserRuleContext, opCode: OpCode, exprLeft: ExprContext, exprRight: ExprContext
    ) {
        val exprL = lookupInstruction(exprLeft)
        val exprR = lookupInstruction(exprRight)
        val dt1 = ir.symbolTable[exprL.result]!!.type!!.atomTypeId
        val dt2 = ir.symbolTable[exprR.result]!!.type!!.atomTypeId
        Types.assertNumeric(dt1, dt2) { getCtxString(parent) }
        val result = ir.symbolTable.addTmp(
            Types.upcast(
                dt1,
                ir.symbolTable[exprR.result]!!.type!!.atomTypeId
            ) { getCtxString(parent) }
        ) { e: STEntry? -> }
        nodeToInstruction.put(
            parent, ir.addInstruction(
                sourceFile, currentLineNumber, parent.start.startIndex, parent.stop.stopIndex,
                opCode, exprL.result, exprR.result, result
            )
        )
    }

    override fun exitExprRelational(ctx: ExprRelationalContext) {
        val exprL = lookupInstruction(ctx.expr(0))
        val exprR = lookupInstruction(ctx.expr(1))
        val dt1 = ir.symbolTable[exprL.result]!!.type!!.atomTypeId
        val dt2 = ir.symbolTable[exprR.result]!!.type!!.atomTypeId
        checkDataTypeMatch(dt1, dt2) { getCtxString(ctx) }
        val opCode: OpCode? =
            if (dt1 === PuffinBasicAtomTypeId.STRING && dt2 === PuffinBasicAtomTypeId.STRING) {
                if (ctx.RELEQ() != null) OpCode.EQSTR else if (ctx.RELNEQ() != null) OpCode.NESTR else if (ctx.RELLT() != null) OpCode.LTSTR else if (ctx.RELGT() != null) OpCode.GTSTR else if (ctx.RELLE() != null) OpCode.LESTR else if (ctx.RELGE() != null) OpCode.GESTR else null
            } else {
                if (dt1 === PuffinBasicAtomTypeId.DOUBLE || dt2 === PuffinBasicAtomTypeId.DOUBLE) {
                    if (ctx.RELEQ() != null) OpCode.EQF64 else if (ctx.RELNEQ() != null) OpCode.NEF64 else if (ctx.RELLT() != null) OpCode.LTF64 else if (ctx.RELGT() != null) OpCode.GTF64 else if (ctx.RELLE() != null) OpCode.LEF64 else if (ctx.RELGE() != null) OpCode.GEF64 else null
                } else if (dt1 === PuffinBasicAtomTypeId.INT64 || dt2 === PuffinBasicAtomTypeId.INT64) {
                    if (ctx.RELEQ() != null) OpCode.EQI64 else if (ctx.RELNEQ() != null) OpCode.NEI64 else if (ctx.RELLT() != null) OpCode.LTI64 else if (ctx.RELGT() != null) OpCode.GTI64 else if (ctx.RELLE() != null) OpCode.LEI64 else if (ctx.RELGE() != null) OpCode.GEI64 else null
                } else if (dt1 === PuffinBasicAtomTypeId.FLOAT || dt2 === PuffinBasicAtomTypeId.FLOAT) {
                    if (ctx.RELEQ() != null) OpCode.EQF32 else if (ctx.RELNEQ() != null) OpCode.NEF32 else if (ctx.RELLT() != null) OpCode.LTF32 else if (ctx.RELGT() != null) OpCode.GTF32 else if (ctx.RELLE() != null) OpCode.LEF32 else if (ctx.RELGE() != null) OpCode.GEF32 else null
                } else {
                    if (ctx.RELEQ() != null) OpCode.EQI32 else if (ctx.RELNEQ() != null) OpCode.NEI32 else if (ctx.RELLT() != null) OpCode.LTI32 else if (ctx.RELGT() != null) OpCode.GTI32 else if (ctx.RELLE() != null) OpCode.LEI32 else if (ctx.RELGE() != null) OpCode.GEI32 else null
                }
            }
        if (opCode == null) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH,
                getCtxString(ctx),
                "Unsupported operator!"
            )
        }
        val result = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT64) { e: STEntry? -> }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                opCode, exprL.result, exprR.result, result
            )
        )
    }

    override fun exitExprLogNot(ctx: ExprLogNotContext) {
        val expr = lookupInstruction(ctx.expr())
        Types.assertNumeric(
            ir.symbolTable[expr.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        val result = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT64) { e: STEntry? -> }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.NOT, expr.result, PuffinBasicSymbolTable.NULL_ID, result
            )
        )
    }

    override fun exitExprLogical(ctx: ExprLogicalContext) {
        val opCode =
            (if (ctx.LOGAND() != null) OpCode.AND else if (ctx.LOGOR() != null) OpCode.OR else if (ctx.LOGXOR() != null) OpCode.XOR else if (ctx.LOGEQV() != null) OpCode.EQV else if (ctx.LOGIMP() != null) OpCode.IMP else null)
                ?: throw PuffinBasicSemanticError(
                    PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH,
                    getCtxString(ctx),
                    "Unsupported operator!"
                )
        addLogicalOpExpr(ctx, opCode, ctx.expr(0), ctx.expr(1))
    }

    //
    // Functions
    //
    override fun exitExprBitwise(ctx: ExprBitwiseContext) {
        val opCode =
            (if (ctx.BWLSFT() != null) OpCode.LEFTSHIFT else if (ctx.BWRSFT() != null) OpCode.RIGHTSHIFT else null)
                ?: throw PuffinBasicSemanticError(
                    PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH,
                    getCtxString(ctx),
                    "Unsupported operator!"
                )
        addBitwiseOpExpr(ctx, opCode, ctx.expr(0), ctx.expr(1))
    }

    private fun addLogicalOpExpr(
        parent: ParserRuleContext, opCode: OpCode, exprLeft: ExprContext, exprRight: ExprContext
    ) {
        val exprL = lookupInstruction(exprLeft)
        val exprR = lookupInstruction(exprRight)
        Types.assertNumeric(
            ir.symbolTable[exprL.result]!!.type!!.atomTypeId,
            ir.symbolTable[exprR.result]!!.type!!.atomTypeId
        ) { getCtxString(parent) }
        val result = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT64) { e: STEntry? -> }
        nodeToInstruction.put(
            parent, ir.addInstruction(
                sourceFile, currentLineNumber, parent.start.startIndex, parent.stop.stopIndex,
                opCode, exprL.result, exprR.result, result
            )
        )
    }

    private fun addBitwiseOpExpr(
        parent: ParserRuleContext, opCode: OpCode, exprLeft: ExprContext, exprRight: ExprContext
    ) {
        val exprL = lookupInstruction(exprLeft)
        val exprR = lookupInstruction(exprRight)
        Types.assertNumeric(
            ir.symbolTable[exprL.result]!!.type!!.atomTypeId,
            ir.symbolTable[exprR.result]!!.type!!.atomTypeId
        ) { getCtxString(parent) }
        val result = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT64) { e: STEntry? -> }
        nodeToInstruction.put(
            parent, ir.addInstruction(
                sourceFile, currentLineNumber, parent.start.startIndex, parent.stop.stopIndex,
                opCode, exprL.result, exprR.result, result
            )
        )
    }

    override fun exitFuncAbs(ctx: FuncAbsContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(
                OpCode.ABS, ctx, ctx.expr(),
                NumericOrString.NUMERIC
            )
        )
    }

    override fun exitFuncAsc(ctx: FuncAscContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.ASC, ctx, ctx.expr(),
                NumericOrString.STRING,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { c: STEntry? -> })
        )
    }

    override fun exitFuncSin(ctx: FuncSinContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.SIN, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncCos(ctx: FuncCosContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.COS, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncTan(ctx: FuncTanContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.TAN, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncASin(ctx: FuncASinContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.ASIN, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncACos(ctx: FuncACosContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.ACOS, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncAtn(ctx: FuncAtnContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.ATN, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncSinh(ctx: FuncSinhContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.SINH, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncCosh(ctx: FuncCoshContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.COSH, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncTanh(ctx: FuncTanhContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.TANH, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncExp(ctx: FuncExpContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.EEXP, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncLog10(ctx: FuncLog10Context) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.LOG10, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncLog2(ctx: FuncLog2Context) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.LOG2, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncToRad(ctx: FuncToRadContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.TORAD, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncToDeg(ctx: FuncToDegContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.TODEG, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncFloor(ctx: FuncFloorContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.FLOOR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncCeil(ctx: FuncCeilContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.CEIL, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncRound(ctx: FuncRoundContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.ROUND, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncSqr(ctx: FuncSqrContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.SQR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncCint(ctx: FuncCintContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.CINT, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { c: STEntry? -> })
        )
    }

    override fun exitFuncClng(ctx: FuncClngContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.CLNG, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT64) { c: STEntry? -> })
        )
    }

    override fun exitFuncCsng(ctx: FuncCsngContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.CSNG, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.FLOAT) { c: STEntry? -> })
        )
    }

    override fun exitFuncCdbl(ctx: FuncCdblContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.CDBL, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncCvi(ctx: FuncCviContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.CVI, ctx, ctx.expr(),
                NumericOrString.STRING,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { c: STEntry? -> })
        )
    }

    override fun exitFuncCvl(ctx: FuncCvlContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.CVL, ctx, ctx.expr(),
                NumericOrString.STRING,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT64) { c: STEntry? -> })
        )
    }

    override fun exitFuncCvs(ctx: FuncCvsContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.CVS, ctx, ctx.expr(),
                NumericOrString.STRING,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.FLOAT) { c: STEntry? -> })
        )
    }

    override fun exitFuncCvd(ctx: FuncCvdContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.CVD, ctx, ctx.expr(),
                NumericOrString.STRING,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncMkiDlr(ctx: FuncMkiDlrContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.MKIDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { c: STEntry? -> })
        )
    }

    override fun exitFuncMklDlr(ctx: FuncMklDlrContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.MKLDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { c: STEntry? -> })
        )
    }

    override fun exitFuncMksDlr(ctx: FuncMksDlrContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.MKSDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { c: STEntry? -> })
        )
    }

    override fun exitFuncMkdDlr(ctx: FuncMkdDlrContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.MKDDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { c: STEntry? -> })
        )
    }

    override fun exitFuncSpaceDlr(ctx: FuncSpaceDlrContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.SPACEDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { c: STEntry? -> })
        )
    }

    override fun exitFuncStrDlr(ctx: FuncStrDlrContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.STRDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { c: STEntry? -> })
        )
    }

    override fun exitFuncVal(ctx: FuncValContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.VAL, ctx, ctx.expr(),
                NumericOrString.STRING,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncInt(ctx: FuncIntContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(
                OpCode.INT, ctx, ctx.expr(),
                NumericOrString.NUMERIC
            )
        )
    }

    override fun exitFuncFix(ctx: FuncFixContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(
                OpCode.FIX, ctx, ctx.expr(),
                NumericOrString.NUMERIC
            )
        )
    }

    override fun exitFuncLog(ctx: FuncLogContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.LOG, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncLen(ctx: FuncLenContext) {
        val exprInstruction = lookupInstruction(ctx.expr(0))
        val axisId =
            if (ctx.axis != null) lookupInstruction(ctx.axis).result else PuffinBasicSymbolTable.NULL_ID
        nodeToInstruction.put(ctx, ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LEN,
            exprInstruction.result,
            axisId,
            ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { c: STEntry? -> }
        ))
    }

    override fun exitFuncChrDlr(ctx: FuncChrDlrContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.CHRDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { c: STEntry? -> })
        )
    }

    override fun exitFuncHexDlr(ctx: FuncHexDlrContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.HEXDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { c: STEntry? -> })
        )
    }

    override fun exitFuncOctDlr(ctx: FuncOctDlrContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.OCTDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { c: STEntry? -> })
        )
    }

    override fun exitFuncLeftDlr(ctx: FuncLeftDlrContext) {
        val xdlr = lookupInstruction(ctx.expr(0))
        val n = lookupInstruction(ctx.expr(1))
        Types.assertString(
            ir.symbolTable[xdlr.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[n.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.LEFTDLR, xdlr.result, n.result,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { c: STEntry? -> })
        )
    }

    override fun exitFuncRightDlr(ctx: FuncRightDlrContext) {
        val xdlr = lookupInstruction(ctx.expr(0))
        val n = lookupInstruction(ctx.expr(1))
        Types.assertString(
            ir.symbolTable[xdlr.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[n.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.RIGHTDLR, xdlr.result, n.result,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { c: STEntry? -> })
        )
    }

    override fun exitFuncInstr(ctx: FuncInstrContext) {
        val xdlr: Int
        val ydlr: Int
        val n: Int
        if (ctx.expr().size == 3) {
            // n, x$, y$
            n = lookupInstruction(ctx.expr(0)).result
            xdlr = lookupInstruction(ctx.expr(1)).result
            ydlr = lookupInstruction(ctx.expr(2)).result
            Types.assertNumeric(
                ir.symbolTable[n]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
        } else {
            // x$, y$
            n = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
                e!!.value!!.int32 = 1
            }
            xdlr = lookupInstruction(ctx.expr(0)).result
            ydlr = lookupInstruction(ctx.expr(1)).result
        }
        Types.assertString(
            ir.symbolTable[xdlr]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertString(
            ir.symbolTable[ydlr]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, xdlr, ydlr, PuffinBasicSymbolTable.NULL_ID
        )
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.INSTR, n, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { c: STEntry? -> })
        )
    }

    override fun exitFuncMidDlr(ctx: FuncMidDlrContext) {
        val xdlr: Int
        val n: Int
        val m: Int
        if (ctx.expr().size == 3) {
            // x$, n, m
            xdlr = lookupInstruction(ctx.expr(0)).result
            n = lookupInstruction(ctx.expr(1)).result
            m = lookupInstruction(ctx.expr(2)).result
            Types.assertNumeric(
                ir.symbolTable[m]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
        } else {
            // x$, n
            xdlr = lookupInstruction(ctx.expr(0)).result
            n = lookupInstruction(ctx.expr(1)).result
            m = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
                e!!.value!!.int32 = Int.MAX_VALUE
            }
        }
        Types.assertString(
            ir.symbolTable[xdlr]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[n]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, xdlr, n, PuffinBasicSymbolTable.NULL_ID
        )
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.MIDDLR, m, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { c: STEntry? -> })
        )
    }

    override fun exitFuncRnd(ctx: FuncRndContext) {
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.RND, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncSgn(ctx: FuncSgnContext) {
        nodeToInstruction.put(
            ctx, addFuncWithExprInstruction(OpCode.SGN, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { c: STEntry? -> })
        )
    }

    override fun exitFuncTimer(ctx: FuncTimerContext) {
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.TIMER, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncTimerMillis(ctx: FuncTimerMillisContext) {
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.TIMERMILLIS, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT64) { c: STEntry? -> })
        )
    }

    override fun exitFuncStringDlr(ctx: FuncStringDlrContext) {
        val n = lookupInstruction(ctx.expr(0)).result
        val jOrxdlr = lookupInstruction(ctx.expr(1)).result
        Types.assertNumeric(
            ir.symbolTable[n]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.STRINGDLR, n, jOrxdlr,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { c: STEntry? -> })
        )
    }

    override fun exitFuncLoc(ctx: FuncLocContext) {
        val fileNumber = lookupInstruction(ctx.expr())
        Types.assertNumeric(
            ir.symbolTable[fileNumber.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.LOC, fileNumber.result, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { c: STEntry? -> })
        )
    }

    override fun exitFuncLof(ctx: FuncLofContext) {
        val fileNumber = lookupInstruction(ctx.expr())
        Types.assertNumeric(
            ir.symbolTable[fileNumber.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.LOF, fileNumber.result, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT64) { c: STEntry? -> })
        )
    }

    override fun exitFuncEof(ctx: FuncEofContext) {
        val fileNumber = lookupInstruction(ctx.expr())
        Types.assertNumeric(
            ir.symbolTable[fileNumber.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.EOF, fileNumber.result, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { c: STEntry? -> })
        )
    }

    override fun exitFuncEnvironDlr(ctx: FuncEnvironDlrContext) {
        val expr = lookupInstruction(ctx.expr())
        Types.assertString(
            ir.symbolTable[expr.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.ENVIRONDLR, expr.result, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { c: STEntry? -> })
        )
    }

    override fun exitFuncInputDlr(ctx: FuncInputDlrContext) {
        val x = lookupInstruction(ctx.expr(0))
        Types.assertNumeric(
            ir.symbolTable[x.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        val fileNumberId: Int
        if (ctx.expr().size == 2) {
            val fileNumber = lookupInstruction(ctx.expr(1))
            Types.assertNumeric(
                ir.symbolTable[fileNumber.result]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
            fileNumberId = fileNumber.result
        } else {
            fileNumberId = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
                e!!.value!!.int32 = -1
            }
        }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.INPUTDLR, x.result, fileNumberId,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { c: STEntry? -> })
        )
    }

    override fun exitFuncInkeyDlr(ctx: FuncInkeyDlrContext) {
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.INKEYDLR, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { c: STEntry? -> })
        )
    }

    override fun exitFuncE(ctx: FuncEContext) {
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.E, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncPI(ctx: FuncPIContext) {
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.PI, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { c: STEntry? -> })
        )
    }

    override fun exitFuncMin(ctx: FuncMinContext) {
        val expr1 = lookupInstruction(ctx.expr(0))
        val expr2 = lookupInstruction(ctx.expr(1))
        val dt1 = ir.symbolTable[expr1.result]!!.type!!.atomTypeId
        val dt2 = ir.symbolTable[expr2.result]!!.type!!.atomTypeId
        Types.assertNumeric(dt1) { getCtxString(ctx) }
        Types.assertNumeric(dt2) { getCtxString(ctx) }
        val resdt = Types.upcast(dt1, dt2) { getCtxString(ctx) }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.MIN, expr1.result, expr2.result,
                ir.symbolTable.addTmp(resdt) { e: STEntry? -> })
        )
    }

    override fun exitFuncMax(ctx: FuncMaxContext) {
        val expr1 = lookupInstruction(ctx.expr(0))
        val expr2 = lookupInstruction(ctx.expr(1))
        val dt1 = ir.symbolTable[expr1.result]!!.type!!.atomTypeId
        val dt2 = ir.symbolTable[expr2.result]!!.type!!.atomTypeId
        Types.assertNumeric(dt1) { getCtxString(ctx) }
        Types.assertNumeric(dt2) { getCtxString(ctx) }
        val resdt = Types.upcast(dt1, dt2) { getCtxString(ctx) }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.MAX, expr1.result, expr2.result,
                ir.symbolTable.addTmp(resdt) { e: STEntry? -> })
        )
    }

    private fun getArray1dVariableInstruction(
        ctx: ParserRuleContext,
        varCtx: PuffinBasicParser.VariableContext,
        numeric: Boolean
    ): PuffinBasicIR.Instruction {
        val varInstr = lookupInstruction(varCtx)
        assertVariable(ir.symbolTable[varInstr.result]) { getCtxString(ctx) }
        val varEntry = ir.symbolTable[varInstr.result] as STVariable?
        assert1DArray(varEntry) { getCtxString(ctx) }
        if (numeric) {
            Types.assertNumeric(varEntry!!.type!!.atomTypeId) { getCtxString(ctx) }
        }
        return varInstr
    }

    private fun getArray2dVariableInstruction(
        ctx: ParserRuleContext,
        varCtx: PuffinBasicParser.VariableContext
    ): PuffinBasicIR.Instruction {
        val varInstr = lookupInstruction(varCtx)
        assertVariable(ir.symbolTable[varInstr.result]) { getCtxString(ctx) }
        val varEntry = ir.symbolTable[varInstr.result] as STVariable?
        assert2DArray(varEntry) { getCtxString(ctx) }
        return varInstr
    }

    private fun getArrayNdVariableInstruction(
        ctx: ParserRuleContext,
        varCtx: PuffinBasicParser.VariableContext
    ): PuffinBasicIR.Instruction {
        val varInstr = lookupInstruction(varCtx)
        assertVariable(ir.symbolTable[varInstr.result]) { getCtxString(ctx) }
        val varEntry = ir.symbolTable[varInstr.result] as STVariable?
        assertNDArray(varEntry) { getCtxString(ctx) }
        return varInstr
    }

    override fun exitFuncArray1DMin(ctx: FuncArray1DMinContext) {
        val var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), true)
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.ARRAY1DMIN, var1Instr.result, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmpCompatibleWith(var1Instr.result)
            )
        )
    }

    override fun exitFuncArray1DMax(ctx: FuncArray1DMaxContext) {
        val var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), true)
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.ARRAY1DMAX, var1Instr.result, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmpCompatibleWith(var1Instr.result)
            )
        )
    }

    override fun exitFuncArray1DMean(ctx: FuncArray1DMeanContext) {
        val var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), true)
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.ARRAY1DMEAN, var1Instr.result, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { e: STEntry? -> })
        )
    }

    override fun exitFuncArray1DSum(ctx: FuncArray1DSumContext) {
        val var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), true)
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.ARRAY1DSUM, var1Instr.result, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { e: STEntry? -> })
        )
    }

    override fun exitFuncArray1DStd(ctx: FuncArray1DStdContext) {
        val var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), true)
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.ARRAY1DSTD, var1Instr.result, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { e: STEntry? -> })
        )
    }

    override fun exitFuncArray1DMedian(ctx: FuncArray1DMedianContext) {
        val var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), true)
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.ARRAY1DMEDIAN, var1Instr.result, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { e: STEntry? -> })
        )
    }

    override fun exitFuncArray1DBinSearch(ctx: FuncArray1DBinSearchContext) {
        val var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), false)
        val expr = lookupInstruction(ctx.expr())
        Types.assertNumeric(
            ir.symbolTable[expr.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.ARRAY1DBINSEARCH, var1Instr.result, expr.result,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? -> })
        )
    }

    override fun exitFuncArray1DPct(ctx: FuncArray1DPctContext) {
        val var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), true)
        val expr = lookupInstruction(ctx.expr())
        Types.assertNumeric(ir.symbolTable[expr.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.ARRAY1DPCT, var1Instr.result, expr.result,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { e: STEntry? -> })
        )
    }

    override fun exitFuncArray2DFindRow(ctx: FuncArray2DFindRowContext) {
        val varInstr = getArray2dVariableInstruction(ctx, ctx.variable())
        val x1 = lookupInstruction(ctx.x1)
        val y1 = lookupInstruction(ctx.y1)
        val x2 = lookupInstruction(ctx.x2)
        val y2 = lookupInstruction(ctx.y2)
        val search = lookupInstruction(ctx.search)
        Types.assertIntType(ir.symbolTable[x1.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        Types.assertIntType(ir.symbolTable[y1.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        Types.assertIntType(ir.symbolTable[x2.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        Types.assertIntType(ir.symbolTable[y2.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        Types.assertIntType(ir.symbolTable[search.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, x1.result, y1.result, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, x2.result, y2.result, PuffinBasicSymbolTable.NULL_ID
        )
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.ARRAY2DFINDROW, varInstr.result, search.result,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { e: STEntry? -> })
        )
    }

    override fun exitFuncArray2DFindColumn(ctx: FuncArray2DFindColumnContext) {
        val varInstr = getArray2dVariableInstruction(ctx, ctx.variable())
        val x1 = lookupInstruction(ctx.x1)
        val y1 = lookupInstruction(ctx.y1)
        val x2 = lookupInstruction(ctx.x2)
        val y2 = lookupInstruction(ctx.y2)
        val search = lookupInstruction(ctx.search)
        Types.assertIntType(ir.symbolTable[x1.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        Types.assertIntType(ir.symbolTable[y1.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        Types.assertIntType(ir.symbolTable[x2.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        Types.assertIntType(ir.symbolTable[y2.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        Types.assertIntType(ir.symbolTable[search.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, x1.result, y1.result, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, x2.result, y2.result, PuffinBasicSymbolTable.NULL_ID
        )
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.ARRAY2DFINDCOLUMN, varInstr.result, search.result,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.DOUBLE) { e: STEntry? -> })
        )
    }

    override fun exitFuncHsb2Rgb(ctx: FuncHsb2RgbContext) {
        val h = lookupInstruction(ctx.expr(0))
        val s = lookupInstruction(ctx.expr(1))
        val b = lookupInstruction(ctx.expr(2))
        Types.assertNumeric(ir.symbolTable[h.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        Types.assertNumeric(ir.symbolTable[s.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        Types.assertNumeric(ir.symbolTable[b.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, h.result, s.result, PuffinBasicSymbolTable.NULL_ID
        )
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.HSB2RGB, b.result, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? -> })
        )
    }

    override fun exitFuncMouseMovedX(ctx: FuncMouseMovedXContext) {
        assertGraphics()
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.MOUSEMOVEDX, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? -> })
        )
    }

    override fun exitFuncMouseMovedY(ctx: FuncMouseMovedYContext) {
        assertGraphics()
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.MOUSEMOVEDY, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? -> })
        )
    }

    override fun exitFuncMouseDraggedX(ctx: FuncMouseDraggedXContext) {
        assertGraphics()
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.MOUSEDRAGGEDX,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? -> })
        )
    }

    override fun exitFuncMouseDraggedY(ctx: FuncMouseDraggedYContext) {
        assertGraphics()
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.MOUSEDRAGGEDY,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? -> })
        )
    }

    override fun exitFuncMouseButtonClicked(ctx: FuncMouseButtonClickedContext) {
        assertGraphics()
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.MOUSEBUTTONCLICKED,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? -> })
        )
    }

    override fun exitFuncMouseButtonPressed(ctx: FuncMouseButtonPressedContext) {
        assertGraphics()
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.MOUSEBUTTONPRESSED,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? -> })
        )
    }

    override fun exitFuncMouseButtonReleased(ctx: FuncMouseButtonReleasedContext) {
        assertGraphics()
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.MOUSEBUTTONRELEASED,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? -> })
        )
    }

    override fun exitFuncIsKeyPressed(ctx: FuncIsKeyPressedContext) {
        assertGraphics()
        val expr = lookupInstruction(ctx.expr())
        Types.assertString(ir.symbolTable[expr.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.ISKEYPRESSED, expr.result, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? -> })
        )
    }

    override fun exitFuncMemberMethodCall(ctx: FuncMemberMethodCallContext) {
        val varInstruction = lookupInstruction(ctx.variable())
        val objectType = ir.symbolTable[varInstruction.result]!!.type
        val funcName = ctx.funcname().text
        val returnType = objectType!!.getFuncCallReturnType(funcName)
        val paramTypes: MutableList<PuffinBasicType> = ArrayList(ctx.expr().size)
        for (exprCtx in ctx.expr()) {
            val exprInstruction = lookupInstruction(exprCtx)
            ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.PARAM1,
                exprInstruction.result,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID
            )
            paramTypes.add(ir.symbolTable[exprInstruction.result]?.type!!)
        }
        objectType.checkFuncCallArguments(funcName, paramTypes)
        nodeToInstruction.put(ctx, ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.MEMBER_FUNC_CALL, varInstruction.result,
            ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { e: STEntry? ->
                e!!.value!!.string = funcName
            },
            ir.symbolTable.addTmp(returnType) { e: STEntry? -> }
        ))
    }

    override fun exitFuncSplitDlr(ctx: FuncSplitDlrContext) {
        val str = lookupInstruction(ctx.expr(0))
        val regex = lookupInstruction(ctx.expr(1))
        Types.assertString(
            ir.symbolTable[str.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertString(
            ir.symbolTable[regex.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.SPLITDLR, str.result, regex.result,
                ir.symbolTable.addTmp(STObjects.ArrayType(PuffinBasicAtomTypeId.STRING)) { c: STEntry? -> })
        )
    }

    override fun exitFuncLTrimDlr(ctx: FuncLTrimDlrContext) {
        val str = lookupInstruction(ctx.expr())
        Types.assertString(
            ir.symbolTable[str.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.LTRIMDLR, str.result, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(STObjects.ArrayType(PuffinBasicAtomTypeId.STRING)) { c: STEntry? -> })
        )
    }

    override fun exitFuncRTrimDlr(ctx: FuncRTrimDlrContext) {
        val str = lookupInstruction(ctx.expr())
        Types.assertString(
            ir.symbolTable[str.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.RTRIMDLR, str.result, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(STObjects.ArrayType(PuffinBasicAtomTypeId.STRING)) { c: STEntry? -> })
        )
    }

    override fun exitFuncAllocArray(ctx: FuncAllocArrayContext) {
        val elementType = lookup(ctx.varsuffix().text)
        for (exprCtx in ctx.expr()) {
            val exprInstr = lookupInstruction(exprCtx)
            ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.PARAM1,
                exprInstr.result,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID
            )
        }
        nodeToInstruction.put(
            ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.ALLOCARRAY, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID,
                ir.symbolTable.addTmp(STObjects.ArrayType(elementType)) { c: STEntry? -> })
        )
    }

    //
    // Stmt
    //
    private fun addFuncWithExprInstruction(
        opCode: OpCode, parent: ParserRuleContext,
        expr: ExprContext, numericOrString: NumericOrString
    ): PuffinBasicIR.Instruction {
        val exprInstruction = lookupInstruction(expr)
        assertNumericOrString(exprInstruction.result, parent, numericOrString)
        return ir.addInstruction(
            sourceFile, currentLineNumber, parent.start.startIndex, parent.stop.stopIndex,
            opCode, exprInstruction.result, PuffinBasicSymbolTable.NULL_ID,
            ir.symbolTable.addTmpCompatibleWith(exprInstruction.result)
        )
    }

    private fun addFuncWithExprInstruction(
        opCode: OpCode,
        parent: ParserRuleContext,
        expr: ExprContext,
        numericOrString: NumericOrString,
        result: Int
    ): PuffinBasicIR.Instruction {
        val exprInstruction = lookupInstruction(expr)
        assertNumericOrString(exprInstruction.result, parent, numericOrString)
        return ir.addInstruction(
            sourceFile, currentLineNumber, parent.start.startIndex, parent.stop.stopIndex,
            opCode, exprInstruction.result, PuffinBasicSymbolTable.NULL_ID, result
        )
    }

    private fun assertNumericOrString(
        id: Int,
        parent: ParserRuleContext,
        numericOrString: NumericOrString
    ) {
        val dt = ir.symbolTable[id]!!.type!!.atomTypeId
        if (numericOrString == NumericOrString.NUMERIC) {
            Types.assertNumeric(dt) { getCtxString(parent) }
        } else {
            Types.assertString(dt) { getCtxString(parent) }
        }
    }

    override fun exitListstmt(ctx: ListstmtContext) {
        val itemType: PuffinBasicType = if (ctx.typename != null) {
            // struct
            val typeName = ctx.typename.VARNAME().text
            ir.symbolTable.getStructType(typeName)
        } else if (ctx.dimtypesuffix != null) {
            // array
            val atomType = lookup(ctx.dimtypesuffix.text)
            STObjects.ArrayType(atomType)
        } else {
            // scalar data type
            val atomType = lookup(ctx.typesuffix.text)
            ScalarType(atomType)
        }
        val instanceName = ctx.listname.VARNAME().text
        val variableName = VariableName(instanceName, null, PuffinBasicAtomTypeId.COMPOSITE)
        val listType = STObjects.ListType(itemType)
        val id = ir.symbolTable.addCompositeVariable(
            variableName, STVariable(null, Variable(variableName, listType))
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.CREATE_INSTANCE, id, PuffinBasicSymbolTable.NULL_ID, id
        )
    }

    override fun exitSetstmt(ctx: SetstmtContext) {
        val atomType = lookup(ctx.typesuffix.text)
        val itemType: PuffinBasicType = ScalarType(atomType)
        val instanceName = ctx.setname.VARNAME().text
        val variableName = VariableName(instanceName, null, PuffinBasicAtomTypeId.COMPOSITE)
        val setType = STObjects.SetType(itemType)
        val id = ir.symbolTable.addCompositeVariable(
            variableName, STVariable(null, Variable(variableName, setType))
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.CREATE_INSTANCE, id, PuffinBasicSymbolTable.NULL_ID, id
        )
    }

    override fun exitDictstmt(ctx: DictstmtContext) {
        val keyAtomType = lookup(ctx.dictk1.text)
        val keyType: PuffinBasicType = ScalarType(keyAtomType)
        val valueType: PuffinBasicType = if (ctx.dictv1 != null) {
            // struct
            val typeName = ctx.dictv1.VARNAME().text
            ir.symbolTable.getStructType(typeName)
        } else {
            // scalar data type
            val atomType = lookup(ctx.dictv2.text)
            ScalarType(atomType)
        }
        val instanceName = ctx.dictname.VARNAME().text
        val variableName = VariableName(instanceName, null, PuffinBasicAtomTypeId.COMPOSITE)
        val dictType = STObjects.DictType(keyType, valueType)
        val id = ir.symbolTable.addCompositeVariable(
            variableName, STVariable(null, Variable(variableName, dictType))
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.CREATE_INSTANCE, id, PuffinBasicSymbolTable.NULL_ID, id
        )
    }

    override fun exitStructinstancestmt(ctx: StructinstancestmtContext) {
        val typeName = ctx.varname(0).VARNAME().text
        val instanceName = ctx.varname(1).VARNAME().text
        val variableName = VariableName(instanceName, null, PuffinBasicAtomTypeId.COMPOSITE)
        val type = ir.symbolTable.getStructType(typeName)
        val id = ir.symbolTable.addCompositeVariable(
            variableName, STVariable(null, Variable(variableName, type))
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.CREATE_INSTANCE, id, PuffinBasicSymbolTable.NULL_ID, id
        )
    }

    override fun exitStructstmt(ctx: StructstmtContext) {
        val typeName = ctx.varname().VARNAME().text
        val struct = StructType(typeName)
        for (compCtx in ctx.compositetype()) {
            if (compCtx.var1 != null) {
                // scalar
                val scalarVarName = compCtx.var1.VARNAME().text
                val scalarAtomTypeId = ir.symbolTable.getDataTypeFor(
                    scalarVarName, if (compCtx.var2 != null) compCtx.var2.text else null
                )
                //PuffinBasicAtomTypeId.lookup(compCtx.var2.getText());
                val name = VariableName(
                    scalarVarName,
                    scalarAtomTypeId.getRepr(),
                    scalarAtomTypeId
                )
                struct.declareField(name, ScalarType(name.dataType))
            } else if (compCtx.DIM() != null) {
                // array
                val arrayName = compCtx.elem.VARNAME().text
                val arrayAtomType = ir.symbolTable.getDataTypeFor(
                    arrayName,
                    if (compCtx.elemsuffix != null) compCtx.elemsuffix.text else null
                )
                val dims = compCtx.DECIMAL().map { dimStrNode ->
                    parseInt32(dimStrNode.text) { getCtxString(ctx) }
                }
                struct.declareField(
                    VariableName(arrayName, arrayAtomType.getRepr(), arrayAtomType),
                    STObjects.ArrayType(arrayAtomType, dims.toMutableList(), true)
                )
            } else if (compCtx.LIST() != null) {
                // list
                val name =
                    VariableName(compCtx.elem.VARNAME().text, null, PuffinBasicAtomTypeId.COMPOSITE)
                val itemType: PuffinBasicType = if (compCtx.list1 != null) {
                    // struct
                    ir.symbolTable.getStructType(compCtx.list1.VARNAME().text)
                } else {
                    // scalar data type
                    ScalarType(lookup(compCtx.list2.text))
                }
                struct.declareField(name, STObjects.ListType(itemType))
            } else if (compCtx.SET() != null) {
                // set
                val name =
                    VariableName(compCtx.elem.VARNAME().text, null, PuffinBasicAtomTypeId.COMPOSITE)
                struct.declareField(name, STObjects.SetType(ScalarType(lookup(compCtx.set2.text))))
            } else if (compCtx.DICT() != null) {
                // dict
                val name =
                    VariableName(compCtx.elem.VARNAME().text, null, PuffinBasicAtomTypeId.COMPOSITE)
                val keyType = ScalarType(lookup(compCtx.dictk1.text))
                val valueType: PuffinBasicType = if (compCtx.dictv1 != null) {
                    // struct
                    ir.symbolTable.getStructType(compCtx.dictv1.VARNAME().text)
                } else {
                    // scalar data type
                    ScalarType(lookup(compCtx.dictv2.text))
                }
                struct.declareField(name, STObjects.DictType(keyType, valueType))
            } else if (compCtx.struct1 != null) {
                // struct
                val memberType = compCtx.struct1.VARNAME().text
                val name =
                    VariableName(compCtx.elem.VARNAME().text, null, PuffinBasicAtomTypeId.COMPOSITE)
                struct.declareField(name, ir.symbolTable.getStructType(memberType))
            } else {
                // throw
                throw PuffinBasicSemanticError(
                    PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH,
                    getCtxString(ctx),
                    "Bad struct field: " + compCtx.text
                )
            }
        }
        ir.symbolTable.addStructType(typeName, struct)
    }

    override fun exitComment(ctx: CommentContext) {
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.COMMENT,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitLetstmt(ctx: LetstmtContext) {
        val varInstruction = lookupInstruction(ctx.variable())
        val exprInstruction = lookupInstruction(ctx.expr())
        val varType = ir.symbolTable[varInstruction.result]!!.type
        if (varType!!.typeId === PuffinBasicTypeId.UDF) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.BAD_ASSIGNMENT,
                getCtxString(ctx),
                "Can't assign to UDF: $varType"
            )
        }
        if (!varType!!.isCompatibleWith(ir.symbolTable[exprInstruction.result]!!.type!!)) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH,
                getCtxString(ctx),
                "Data type " + varType
                        + " mismatches with " + ir.symbolTable[exprInstruction.result]!!.type
            )
        }
        val assignInstruction = ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.ASSIGN, exprInstruction.result, varInstruction.result, varInstruction.result
        )
        nodeToInstruction.put(ctx, assignInstruction)
    }

    override fun exitAutoletstmt(ctx: AutoletstmtContext) {
        val varname = ctx.varname().text
        val exprInstruction = lookupInstruction(ctx.expr())
        val resultType = ir.symbolTable[exprInstruction.result]!!.type
        val varId = ir.symbolTable.addVariableOrUDF(
            VariableName(varname, null, resultType!!.atomTypeId),
            { variableName1: VariableName? ->
                Variable(
                    variableName1!!, resultType
                )
            },
            variableConsumer { id: Int, entry: STVariable?, v1: Variable? -> })
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.VARREF, exprInstruction.result, varId, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitPrintstmt(ctx: PrintstmtContext) {
        handlePrintstmt(ctx, ctx.printlist()?.children ?: listOf(), null)
    }

    override fun exitPrinthashstmt(ctx: PrinthashstmtContext) {
        val fileNumber = lookupInstruction(ctx.filenum)
        handlePrintstmt(ctx, ctx.printlist().children, fileNumber)
    }

    private fun handlePrintstmt(
        ctx: ParserRuleContext,
        children: List<ParseTree>,
        fileNumber: PuffinBasicIR.Instruction?
    ) {
        var endsWithNewline = true
        for (child in children) {
            endsWithNewline = if (child is ExprContext) {
                val exprInstruction = lookupInstruction(child)
                ir.addInstruction(
                    sourceFile,
                    currentLineNumber,
                    ctx.start.startIndex,
                    ctx.stop.stopIndex,
                    OpCode.PRINT,
                    exprInstruction.result,
                    PuffinBasicSymbolTable.NULL_ID,
                    PuffinBasicSymbolTable.NULL_ID
                )
                true
            } else {
                false
            }
        }
        if (endsWithNewline || fileNumber != null) {
            val newlineId = ir.symbolTable.addTmp(
                PuffinBasicAtomTypeId.STRING
            ) { entry: STEntry? -> entry!!.value!!.string = BabaSystem.lineSeparator() }
            ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.PRINT,
                newlineId,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID
            )
        }
        val fileNumberId: Int = if (fileNumber != null) {
            Types.assertNumeric(
                ir.symbolTable[fileNumber.result]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
            fileNumber.result
        } else {
            PuffinBasicSymbolTable.NULL_ID
        }
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.FLUSH,
            fileNumberId,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitPrintusingstmt(ctx: PrintusingstmtContext) {
        handlePrintusing(ctx, ctx.format, ctx.printlist().children, null)
    }

    override fun exitPrinthashusingstmt(ctx: PrinthashusingstmtContext) {
        val fileNumber = lookupInstruction(ctx.filenum)
        handlePrintusing(ctx, ctx.format, ctx.printlist().children, fileNumber)
    }

    private fun handlePrintusing(
        ctx: ParserRuleContext,
        formatCtx: ExprContext,
        children: List<ParseTree>,
        fileNumber: PuffinBasicIR.Instruction?
    ) {
        val format = lookupInstruction(formatCtx)
        var endsWithNewline = true
        for (child in children) {
            endsWithNewline = if (child is ExprContext) {
                val exprInstruction = lookupInstruction(child)
                ir.addInstruction(
                    sourceFile,
                    currentLineNumber,
                    ctx.start.startIndex,
                    ctx.stop.stopIndex,
                    OpCode.PRINTUSING,
                    format.result,
                    exprInstruction.result,
                    PuffinBasicSymbolTable.NULL_ID
                )
                true
            } else {
                false
            }
        }
        if (endsWithNewline || fileNumber != null) {
            val newlineId = ir.symbolTable.addTmp(
                PuffinBasicAtomTypeId.STRING
            ) { entry: STEntry? -> entry!!.value!!.string = BabaSystem.lineSeparator() }
            ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.PRINT,
                newlineId,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID
            )
        }
        val fileNumberId: Int = if (fileNumber != null) {
            Types.assertNumeric(
                ir.symbolTable[fileNumber.result]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
            fileNumber.result
        } else {
            PuffinBasicSymbolTable.NULL_ID
        }
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.FLUSH,
            fileNumberId,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitDimstmt(ctx: DimstmtContext) {
        val dims = ctx.expr().indices.map { 0 }
        val variableName = getVariableNameFromCtx(ctx.varname(), ctx.varsuffix())
        val varId = ir.symbolTable.addVariableOrUDF(
            variableName,
            { variableName1: VariableName? ->
                Variable(
                    variableName1!!,
                    STObjects.ArrayType(variableName1.dataType, dims.toMutableList(), true)
                )
            },
            variableConsumer { id: Int, entry: STVariable, v1: Variable? ->
                entry.value!!.arrayDimensions = dims
            })
        for (expr in ctx.expr()) {
            val dimi = lookupInstruction(expr)
            Types.assertNumeric(
                ir.symbolTable[dimi.result]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
            ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.PARAM1,
                dimi.result,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID
            )
        }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.DIM, varId, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitReallocstmt(ctx: ReallocstmtContext) {
        val dims = ctx.expr().indices.map { 0 }
        val variableName = getVariableNameFromCtx(ctx.varname(), ctx.varsuffix())
        val varId = ir.symbolTable.addVariableOrUDF(
            variableName,
            { variableName1: VariableName? ->
                Variable(
                    variableName1!!,
                    STObjects.ArrayType(variableName1.dataType, dims.toMutableList(), true)
                )
            },
            variableConsumer { id: Int, entry: STVariable, v1: Variable? ->
                entry.value!!.arrayDimensions = dims
            })
        for (expr in ctx.expr()) {
            val dimi = lookupInstruction(expr)
            Types.assertNumeric(
                ir.symbolTable[dimi.result]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
            ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.PARAM1,
                dimi.result,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID
            )
        }
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.REALLOCARRAY,
            varId,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun enterDeffnstmt(ctx: DeffnstmtContext) {
        val variableName = getVariableNameFromCtx(ctx.varname(), ctx.varsuffix())
        ir.symbolTable.addVariableOrUDF(variableName,
            { variableName1: VariableName? ->
                of(
                    variableName1!!, VariableKindHint.DERIVE_FROM_NAME
                ) { getCtxString(ctx) }
            },
            variableConsumer { varId: Int, varEntry: STVariable, variable: Variable ->
                val udfState = UDFState(variableName, varEntry as STUDF)
                udfStateMap.set(variable, udfState)

                // GOTO postFuncDecl
                udfState.gotoPostFuncDecl = ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                    OpCode.GOTO_LABEL,
                    ir.symbolTable.addGotoTarget(),
                    PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
                )
                // LABEL FuncStart
                udfState.labelFuncStart = ir.addInstruction(
                    sourceFile,
                    currentLineNumber,
                    ctx.start.startIndex,
                    ctx.stop.stopIndex,
                    OpCode.LABEL,
                    ir.symbolTable.addLabel(),
                    PuffinBasicSymbolTable.NULL_ID,
                    PuffinBasicSymbolTable.NULL_ID
                )
                // Push child scope
                ir.symbolTable.pushDeclarationScope(varId, false)
            })
    }

    override fun exitDeffnstmt(ctx: DeffnstmtContext) {
        val variableName = getVariableNameFromCtx(ctx.varname(), ctx.varsuffix())
        ir.symbolTable.addVariableOrUDF(variableName,
            { variableName1: VariableName? ->
                of(
                    variableName1!!, VariableKindHint.DERIVE_FROM_NAME
                ) { getCtxString(ctx) }
            },
            variableConsumer { varId: Int, varEntry: STVariable, variable: Variable ->
                val udfEntry = varEntry as STUDF
                val udfState = udfStateMap[variable]!!
                for (fnParamCtx in ctx.variable()) {
                    val fnParamInstr = lookupInstruction(fnParamCtx)
                    udfEntry.declareParam(fnParamInstr.result)
                }
                val exprInstr = lookupInstruction(ctx.expr())
                checkDataTypeMatch(varId, exprInstr.result) { getCtxString(ctx) }

                // Copy expr to result
                ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                    OpCode.COPY, exprInstr.result, varId, varId
                )
                // Pop declaration scope
                ir.symbolTable.popScope()
                // GOTO Caller
                ir.addInstruction(
                    sourceFile,
                    currentLineNumber,
                    ctx.start.startIndex,
                    ctx.stop.stopIndex,
                    OpCode.GOTO_CALLER,
                    PuffinBasicSymbolTable.NULL_ID,
                    PuffinBasicSymbolTable.NULL_ID,
                    PuffinBasicSymbolTable.NULL_ID
                )
                // LABEL postFuncDecl
                val labelPostFuncDecl = ir.addInstruction(
                    sourceFile,
                    currentLineNumber,
                    ctx.start.startIndex,
                    ctx.stop.stopIndex,
                    OpCode.LABEL,
                    ir.symbolTable.addLabel(),
                    PuffinBasicSymbolTable.NULL_ID,
                    PuffinBasicSymbolTable.NULL_ID
                )
                // Patch GOTO postFuncDecl
                udfState.gotoPostFuncDecl!!.patchOp1(labelPostFuncDecl.op1)
            })
    }

    private fun getVariableNameFromCtx(
        varnameCtx: VarnameContext,
        varsuffixCtx: VarsuffixContext?
    ): VariableName {
        val varname = varnameCtx.text
        val varsuffix = varsuffixCtx?.text
        val dataType = ir.symbolTable.getDataTypeFor(varname, varsuffix)
        return VariableName(varname, dataType.getRepr(), dataType)
    }

    override fun enterFunctionbeginstmt(ctx: FunctionbeginstmtContext) {
        val variableName = getVariableNameFromCtx(ctx.varname(), ctx.varsuffix())
        val udfId = ir.symbolTable.addVariableOrUDF(variableName,
            { variableName1: VariableName? ->
                of(
                    variableName1!!, VariableKindHint.UDF
                ) { getCtxString(ctx) }
            },
            variableConsumer { varId: Int, varEntry: STVariable, variable: Variable ->
                if (currentUdfState != null) {
                    throw PuffinBasicSemanticError(
                        PuffinBasicSemanticError.ErrorCode.BAD_FUNCTION_DEF,
                        getCtxString(ctx),
                        "Function " + variableName + " defined in another function: "
                                + currentUdfState!!.variableName
                    )
                }
                currentUdfState = UDFState(variableName, varEntry as STUDF)
                udfStateMap[variable] = currentUdfState!!

                // GOTO postFuncDecl
                currentUdfState!!.gotoPostFuncDecl = ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                    OpCode.GOTO_LABEL,
                    ir.symbolTable.addGotoTarget(),
                    PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
                )
                // LABEL FuncStart
                currentUdfState!!.labelFuncStart = ir.addInstruction(
                    sourceFile,
                    currentLineNumber,
                    ctx.start.startIndex,
                    ctx.stop.stopIndex,
                    OpCode.LABEL,
                    ir.symbolTable.addLabel(),
                    PuffinBasicSymbolTable.NULL_ID,
                    PuffinBasicSymbolTable.NULL_ID
                )
                // Push child scope
                ir.symbolTable.pushDeclarationScope(varId, true)
            })
        currentUdfState!!.udfId = udfId
    }

    override fun exitFunctionbeginstmt(ctx: FunctionbeginstmtContext) {
        if (currentUdfState == null) {
            throw PuffinBasicInternalError("CurrentUDFState not set!")
        }
        for (compCtx in ctx.compositetype()) {
            var paramName: VariableName
            var paramType: PuffinBasicType
            if (compCtx.var1 != null) {
                // scalar
                val scalarVarName = compCtx.var1.VARNAME().text
                val scalarAtomTypeId = ir.symbolTable.getDataTypeFor(
                    scalarVarName, if (compCtx.var2 != null) compCtx.var2.text else null
                )
                //PuffinBasicAtomTypeId.lookup(compCtx.var2.getText());
                paramName = VariableName(
                    scalarVarName,
                    scalarAtomTypeId.getRepr(),
                    scalarAtomTypeId
                )
                paramType = ScalarType(paramName.dataType)
            } else if (compCtx.LIST() != null) {
                // list
                paramName =
                    VariableName(compCtx.elem.VARNAME().text, null, PuffinBasicAtomTypeId.COMPOSITE)
                val itemType: PuffinBasicType = if (compCtx.list1 != null) {
                    // struct
                    ir.symbolTable.getStructType(compCtx.list1.VARNAME().text)
                } else if (compCtx.list3 != null) {
                    // array
                    val atomType = lookup(compCtx.list3.text)
                    STObjects.ArrayType(atomType)
                } else {
                    // scalar data type
                    ScalarType(lookup(compCtx.list2.text))
                }
                paramType = STObjects.ListType(itemType)
            } else if (compCtx.SET() != null) {
                // set
                paramName =
                    VariableName(compCtx.elem.VARNAME().text, null, PuffinBasicAtomTypeId.COMPOSITE)
                paramType = STObjects.SetType(ScalarType(lookup(compCtx.set2.text)))
            } else if (compCtx.DICT() != null) {
                // dict
                paramName =
                    VariableName(compCtx.elem.VARNAME().text, null, PuffinBasicAtomTypeId.COMPOSITE)
                val keyType = ScalarType(lookup(compCtx.dictk1.text))
                val valueType: PuffinBasicType = if (compCtx.dictv1 != null) {
                    // struct
                    ir.symbolTable.getStructType(compCtx.dictv1.VARNAME().text)
                } else {
                    // scalar data type
                    ScalarType(lookup(compCtx.dictv2.text))
                }
                paramType = STObjects.DictType(keyType, valueType)
            } else if (compCtx.struct1 != null) {
                // struct
                val memberType = compCtx.struct1.VARNAME().text
                paramName =
                    VariableName(compCtx.elem.VARNAME().text, null, PuffinBasicAtomTypeId.COMPOSITE)
                paramType = ir.symbolTable.getStructType(memberType)
            } else if (compCtx.DIM() != null) {
                // array
                val arrayName = compCtx.elem.VARNAME().text
                val arrayAtomType = ir.symbolTable.getDataTypeFor(
                    arrayName,
                    if (compCtx.elemsuffix != null) compCtx.elemsuffix.text else null
                )
                val dims = compCtx.DECIMAL().map { dimStrNode ->
                    parseInt32(dimStrNode.text) { getCtxString(ctx) }
                }
                paramName = VariableName(arrayName, arrayAtomType.getRepr(), arrayAtomType)
                paramType = STObjects.ArrayType(arrayAtomType, dims.toMutableList(), true)
            } else {
                // throw
                throw PuffinBasicSemanticError(
                    PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH,
                    getCtxString(ctx),
                    "Bad struct field: " + compCtx.text
                )
            }
            val paramId = ir.symbolTable.addVariableOrUDF(
                paramName,
                { variableName1: VariableName? ->
                    Variable(
                        variableName1!!, paramType
                    )
                },
                variableConsumer { varId: Int, varEntry: STVariable?, variable: Variable? -> }
            )
            currentUdfState!!.udfEntry.declareParam(paramId)
        }
    }

    override fun exitFunctionreturnstmt(ctx: FunctionreturnstmtContext) {
        if (currentUdfState == null) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.BAD_FUNCTION_DEF,
                getCtxString(ctx),
                "Function return called without function begin!"
            )
        }
        val udfId = currentUdfState!!.udfId
        val returnInstr = lookupInstruction(ctx.expr())
        checkDataTypeMatch(udfId, returnInstr.result) { getCtxString(ctx) }

        // Copy expr to result
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.COPY, returnInstr.result, udfId, udfId
        )

        // GOTO LABEL gotoCaller
        currentUdfState!!.gotoLabelGotoCaller.add(
            ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.GOTO_LABEL,
                ir.symbolTable.addGotoTarget(),
                PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
            )
        )
    }

    override fun exitFunctionendstmt(ctx: FunctionendstmtContext) {
        if (currentUdfState == null) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.BAD_FUNCTION_DEF,
                getCtxString(ctx),
                "Function return called without function begin!"
            )
        }
        // Pop declaration scope
        ir.symbolTable.popScope()
        // LABEL gotoCaller
        val labelGotocaller = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LABEL,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        // GOTO Caller
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.GOTO_CALLER,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        // LABEL postFuncDecl
        val labelPostFuncDecl = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LABEL,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        // Patch GOTO LABEL gotoCaller
        currentUdfState!!.gotoLabelGotoCaller.forEach(Consumer { g: PuffinBasicIR.Instruction ->
            g.patchOp1(
                labelGotocaller.op1
            )
        })
        // Patch GOTO postFuncDecl
        currentUdfState!!.gotoPostFuncDecl!!.patchOp1(labelPostFuncDecl.op1)
        // Unset current UDF state
        currentUdfState = null
    }

    override fun exitImportstmt(ctx: ImportstmtContext) {}
    override fun exitEndstmt(ctx: EndstmtContext) {
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.END,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun enterWhilestmt(ctx: WhilestmtContext) {
        val whileLoopState = WhileLoopState()
        // LABEL beforeWhile
        whileLoopState.labelBeforeWhile = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LABEL,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        whileLoopStateList.add(whileLoopState)
    }

    override fun exitWhilestmt(ctx: WhilestmtContext) {
        val whileLoopState = whileLoopStateList.last

        // expr()
        val expr = lookupInstruction(ctx.expr())

        // NOT expr()
        val notExpr = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.NOT,
            expr.result,
            PuffinBasicSymbolTable.NULL_ID,
            ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT64) { e: STEntry? -> }
        )

        // If expr is false, GOTO afterWend
        whileLoopState.gotoAfterWend = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.GOTO_LABEL_IF,
            notExpr.result,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitWendstmt(ctx: WendstmtContext) {
        if (whileLoopStateList.isEmpty()) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.WEND_WITHOUT_WHILE,
                getCtxString(ctx),
                "Wend without while"
            )
        }
        val whileLoopState = whileLoopStateList.removeLast()
        // GOTO LABEL beforeWhile
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.GOTO_LABEL,
            whileLoopState.labelBeforeWhile!!.op1,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        // LABEL afterWend
        val labelAfterWend = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LABEL,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        // Patch GOTO afterWend
        whileLoopState.gotoAfterWend!!.patchOp2(labelAfterWend.op1)
    }

    private fun getLTOpCode(dt1: PuffinBasicAtomTypeId, dt2: PuffinBasicAtomTypeId): OpCode {
        val opCode: OpCode =
            if (dt1 === PuffinBasicAtomTypeId.STRING && dt2 === PuffinBasicAtomTypeId.STRING) {
                OpCode.LTSTR
            } else {
                if (dt1 === PuffinBasicAtomTypeId.DOUBLE || dt2 === PuffinBasicAtomTypeId.DOUBLE) {
                    OpCode.LTF64
                } else if (dt1 === PuffinBasicAtomTypeId.INT64 || dt2 === PuffinBasicAtomTypeId.INT64) {
                    OpCode.LTI64
                } else if (dt1 === PuffinBasicAtomTypeId.FLOAT || dt2 === PuffinBasicAtomTypeId.FLOAT) {
                    OpCode.LTF32
                } else {
                    OpCode.LTI32
                }
            }
        return opCode
    }

    private fun getGTOpCode(dt1: PuffinBasicAtomTypeId, dt2: PuffinBasicAtomTypeId): OpCode {
        val opCode: OpCode =
            if (dt1 === PuffinBasicAtomTypeId.STRING && dt2 === PuffinBasicAtomTypeId.STRING) {
                OpCode.GTSTR
            } else {
                if (dt1 === PuffinBasicAtomTypeId.DOUBLE || dt2 === PuffinBasicAtomTypeId.DOUBLE) {
                    OpCode.GTF64
                } else if (dt1 === PuffinBasicAtomTypeId.INT64 || dt2 === PuffinBasicAtomTypeId.INT64) {
                    OpCode.GTI64
                } else if (dt1 === PuffinBasicAtomTypeId.FLOAT || dt2 === PuffinBasicAtomTypeId.FLOAT) {
                    OpCode.GTF32
                } else {
                    OpCode.GTI32
                }
            }
        return opCode
    }

    private fun getGEOpCode(dt1: PuffinBasicAtomTypeId, dt2: PuffinBasicAtomTypeId): OpCode {
        val opCode: OpCode =
            if (dt1 === PuffinBasicAtomTypeId.STRING && dt2 === PuffinBasicAtomTypeId.STRING) {
                OpCode.GESTR
            } else {
                if (dt1 === PuffinBasicAtomTypeId.DOUBLE || dt2 === PuffinBasicAtomTypeId.DOUBLE) {
                    OpCode.GEF64
                } else if (dt1 === PuffinBasicAtomTypeId.INT64 || dt2 === PuffinBasicAtomTypeId.INT64) {
                    OpCode.GEI64
                } else if (dt1 === PuffinBasicAtomTypeId.FLOAT || dt2 === PuffinBasicAtomTypeId.FLOAT) {
                    OpCode.GEF32
                } else {
                    OpCode.GEI32
                }
            }
        return opCode
    }

    override fun exitForstmt(ctx: ForstmtContext) {
        val varInstr = lookupInstruction(ctx.variable())
        val init = lookupInstruction(ctx.expr(0))
        val end = lookupInstruction(ctx.expr(1))
        Types.assertNumeric(
            ir.symbolTable[init.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[end.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        val forLoopState = ForLoopState()
        val stVariable = ir.symbolTable[varInstr.result] as STVariable?
        forLoopState.variable = stVariable!!.variable

        // stepCopy = step or 1 (default)
        val stepCopy: PuffinBasicIR.Instruction
        if (ctx.expr(2) != null) {
            val step = lookupInstruction(ctx.expr(2))
            Types.assertNumeric(
                ir.symbolTable[step.result]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
            val tmpStep = ir.symbolTable.addTmpCompatibleWith(step.result)
            stepCopy = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.COPY, step.result, tmpStep, tmpStep
            )
        } else {
            val tmpStep = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
                e!!.value!!.int32 = 1
            }
            stepCopy = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.VALUE, tmpStep, PuffinBasicSymbolTable.NULL_ID, tmpStep
            )
        }
        // var=init
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.ASSIGN, init.result, varInstr.result, varInstr.result
        )
        // endCopy=end
        val tmpEnd = ir.symbolTable.addTmpCompatibleWith(end.result)
        val endCopy = ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.ASSIGN, end.result, tmpEnd, tmpEnd
        )

        // GOTO LABEL CHECK
        val gotoLabelCheck = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.GOTO_LABEL,
            ir.symbolTable.addGotoTarget(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )

        // APPLY STEP
        // JUMP here from NEXT
        forLoopState.labelApplyStep = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LABEL,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )

        // Add step
        val tmpAdd = ir.symbolTable.addTmpCompatibleWith(varInstr.result)
        val addOpCode: OpCode = when (stVariable.type!!.atomTypeId) {
            PuffinBasicAtomTypeId.INT32 -> OpCode.ADDI32
            PuffinBasicAtomTypeId.INT64 -> OpCode.ADDI64
            PuffinBasicAtomTypeId.FLOAT -> OpCode.ADDF32
            PuffinBasicAtomTypeId.DOUBLE -> OpCode.ADDF64
            else -> throw PuffinBasicInternalError("Bad type: " + stVariable.type!!.atomTypeId)
        }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            addOpCode, varInstr.result, stepCopy.result, tmpAdd
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.ASSIGN, tmpAdd, varInstr.result, varInstr.result
        )

        // CHECK
        // If (step >= 0 and var > end) or (step < 0 and var < end) GOTO after "next"
        // step >= 0
        val labelCheck = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LABEL,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        val zero = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
            e!!.value!!.int32 = 0
        }
        val t1 = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? -> }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            getGEOpCode(
                ir.symbolTable[stepCopy.result]!!.type!!.atomTypeId,
                PuffinBasicAtomTypeId.INT32
            ),
            stepCopy.result, zero, t1
        )
        // Patch GOTO LABEL Check
        gotoLabelCheck.patchOp1(labelCheck.op1)
        // var > end
        val t2 = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? -> }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            getGTOpCode(
                ir.symbolTable[varInstr.result]!!.type!!.atomTypeId,
                ir.symbolTable[endCopy.result]!!.type!!.atomTypeId
            ),
            varInstr.result, endCopy.result, t2
        )
        // (step >= 0 and var > end)
        val t3 = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? -> }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.AND, t1, t2, t3
        )
        // step < 0
        val t4 = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? -> }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            getLTOpCode(
                ir.symbolTable[stepCopy.result]!!.type!!.atomTypeId,
                PuffinBasicAtomTypeId.INT32
            ),
            stepCopy.result, zero, t4
        )
        // var < end
        val t5 = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? -> }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            getLTOpCode(
                ir.symbolTable[varInstr.result]!!.type!!.atomTypeId,
                ir.symbolTable[endCopy.result]!!.type!!.atomTypeId
            ),
            varInstr.result, endCopy.result, t5
        )
        // (step < 0 and var < end)
        val t6 = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? -> }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.AND, t4, t5, t6
        )
        val t7 = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? -> }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.OR, t3, t6, t7
        )
        // if (true) GOTO after NEXT
        // set linenumber on exitNext().
        forLoopState.gotoAfterNext = ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.GOTO_LABEL_IF, t7, ir.symbolTable.addLabel(), PuffinBasicSymbolTable.NULL_ID
        )
        forLoopStateList.add(forLoopState)
    }

    override fun exitNextstmt(ctx: NextstmtContext) {
        val states: MutableList<ForLoopState> = ArrayList(1)
        if (ctx.variable().isEmpty()) {
            if (!forLoopStateList.isEmpty()) {
                states.add(forLoopStateList.removeLast())
            } else {
                throw PuffinBasicSemanticError(
                    PuffinBasicSemanticError.ErrorCode.NEXT_WITHOUT_FOR,
                    getCtxString(ctx),
                    "NEXT without FOR"
                )
            }
        } else {
            for (varCtx in ctx.variable()) {
                if (varCtx.leafvariable() == null) {
                    throw PuffinBasicSemanticError(
                        PuffinBasicSemanticError.ErrorCode.BAD_ARGUMENT,
                        getCtxString(ctx),
                        "Bad variable!"
                    )
                }
                val varname = varCtx.leafvariable().varname().VARNAME().text
                val varsuffix = if (varCtx.leafvariable().varsuffix() != null) varCtx.leafvariable()
                    .varsuffix().text else null
                val dataType = ir.symbolTable.getDataTypeFor(varname, varsuffix)
                val variableName = VariableName(varname, dataType.getRepr(), dataType)
                val id = ir.symbolTable.addVariableOrUDF(
                    variableName,
                    { variableName1: VariableName? ->
                        of(
                            variableName1!!, VariableKindHint.DERIVE_FROM_NAME
                        ) { getCtxString(ctx) }
                    },
                    variableConsumer { id1: Int, e1: STVariable?, v1: Variable? -> })
                val variable = (ir.symbolTable[id] as STVariable?)!!.variable
                if (forLoopStateList.isEmpty()) {
                    throw PuffinBasicSemanticError(
                        PuffinBasicSemanticError.ErrorCode.NEXT_WITHOUT_FOR,
                        getCtxString(ctx),
                        "NEXT without FOR"
                    )
                }
                val state = forLoopStateList.removeLast()
                if (state.variable!!.equals(variable)) {
                    states.add(state)
                } else {
                    throw PuffinBasicSemanticError(
                        PuffinBasicSemanticError.ErrorCode.NEXT_WITHOUT_FOR,
                        getCtxString(ctx),
                        "Next $variable without FOR"
                    )
                }
            }
        }
        for (state in states) {
            // GOTO APPLY STEP
            ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.GOTO_LABEL,
                state.labelApplyStep!!.op1,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID
            )

            // LABEL afterNext
            val labelAfterNext = ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.LABEL,
                ir.symbolTable.addLabel(),
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID
            )
            state.gotoAfterNext!!.patchOp2(labelAfterNext.op1)
        }
    }

    /*
     * condition
     * GOTOIF condition labelBeforeThen
     * GOTO labelAfterThen|labelBeforeElse
     * labelBeforeThen
     * ThenStmts
     * GOTO labelAfterThen|labelAfterElse
     * labelAfterThen
     * ElseStmts
     * labelAfterElse
     */
    override fun enterIfThenElse(ctx: IfThenElseContext) {
        nodeToIfState.put(ctx, IfState())
    }

    override fun exitIfThenElse(ctx: IfThenElseContext) {
        val ifState = nodeToIfState[ctx]
        val noElseStmt = ifState.labelBeforeElse == null
        val condition = lookupInstruction(ctx.expr())
        // Patch IF true: condition
        ifState.gotoIfConditionTrue!!.patchOp1(condition.result)
        // Patch IF true: GOTO labelBeforeThen
        ifState.gotoIfConditionTrue!!.patchOp2(ifState.labelBeforeThen!!.op1)
        // Patch IF false: GOTO labelAfterThen|labelBeforeElse
        ifState.gotoIfConditionFalse!!.patchOp1(
            if (noElseStmt) ifState.labelAfterThen!!.op1 else ifState.labelBeforeElse!!.op1
        )
        // Patch THEN: GOTO labelAfterThen|labelAfterElse
        ifState.gotoFromThenAfterIf!!.patchOp1(
            if (noElseStmt) ifState.labelAfterThen!!.op1 else ifState.labelAfterElse!!.op1
        )
    }

    override fun enterThen(ctx: ThenContext) {
        val ifState = nodeToIfState[ctx.getParent()]
        // IF condition is true, GOTO labelBeforeThen
        ifState.gotoIfConditionTrue = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.GOTO_LABEL_IF,
            ir.symbolTable.addGotoTarget(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        // IF condition is false, GOTO labelAfterThen|labelBeforeElse
        ifState.gotoIfConditionFalse = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.GOTO_LABEL,
            ir.symbolTable.addGotoTarget(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        ifState.labelBeforeThen = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LABEL,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    //
    // IF expr THEN BEGIN
    // ...
    // ELSE BEGIN
    // ...
    // END IF
    //
    override fun exitThen(ctx: ThenContext) {
        // Add instruction for:
        // THEN GOTO linenum | THEN linenum
        if (ctx.linenum() != null) {
            val gotoLinenum = parseLinenum(ctx.linenum().text)
            ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.GOTO_LINENUM,
                getGotoLineNumberOp1(gotoLinenum),
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID
            )
        }
        val ifState = nodeToIfState[ctx.getParent()]
        // GOTO labelAfterThen|labelAfterElse
        ifState.gotoFromThenAfterIf = ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.GOTO_LABEL, ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
        )
        ifState.labelAfterThen = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LABEL,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    //
    // expr.result
    // GOTO labelBeforeThen IF expr.result is true
    // GOTO labelAfterThen|labelBeforeElse
    // labelBeforeThen (patch GOTOIF)
    // GOTO labelAfterThen|labelAfterElse (else begin)
    // labelAfterThen
    // labelBeforeElse
    //
    override fun enterElsestmt(ctx: ElsestmtContext) {
        val ifState = nodeToIfState[ctx.getParent()]
        ifState.labelBeforeElse = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LABEL,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitElsestmt(ctx: ElsestmtContext) {
        // Add instruction for:
        // ELSE linenum
        if (ctx.linenum() != null) {
            val gotoLinenum = parseLinenum(ctx.linenum().text)
            ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.GOTO_LINENUM,
                getGotoLineNumberOp1(gotoLinenum),
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID
            )
        }
        val ifState = nodeToIfState[ctx.getParent()]
        ifState.labelAfterElse = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LABEL,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun enterIfthenbeginstmt(ctx: IfthenbeginstmtContext) {
        val ifState = IfState()
        nodeToIfState.put(ctx, ifState)
        ifStateList.add(ifState)
    }

    override fun exitIfthenbeginstmt(ctx: IfthenbeginstmtContext) {
        val ifState = nodeToIfState[ctx]
        val condition = lookupInstruction(ctx.expr())

        // IF condition is true, GOTO labelBeforeThen
        ifState.gotoIfConditionTrue = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.GOTO_LABEL_IF,
            condition.result,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID
        )
        // IF condition is false, GOTO labelAfterThen|labelBeforeElse
        ifState.gotoIfConditionFalse = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.GOTO_LABEL,
            ir.symbolTable.addGotoTarget(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        // Add labelBeforeThen
        ifState.labelBeforeThen = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LABEL,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        // Patch IF true: GOTO labelBeforeThen
        ifState.gotoIfConditionTrue!!.patchOp2(ifState.labelBeforeThen!!.op1)
    }

    override fun enterElsebeginstmt(ctx: ElsebeginstmtContext) {
        if (ifStateList.isEmpty()) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.MISMATCHED_ELSE_BEGIN,
                getCtxString(ctx),
                "ELSE BEGIN without IF THEN BEGIN"
            )
        }
        val ifState = ifStateList.last
        // GOTO labelAfterThen|labelAfterElse
        ifState.gotoFromThenAfterIf = ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.GOTO_LABEL, ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
        )
        ifState.labelAfterThen = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LABEL,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        ifState.labelBeforeElse = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LABEL,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitEndifstmt(ctx: EndifstmtContext) {
        if (ifStateList.isEmpty()) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.MISMATCHED_ENDIF,
                getCtxString(ctx),
                "ENDIF without IF THEN BEGIN"
            )
        }
        val ifState = ifStateList.removeLast()
        val noElseStmt = ifState.labelBeforeElse == null
        if (noElseStmt) {
            // GOTO labelAfterThen|labelAfterElse
            ifState.gotoFromThenAfterIf = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.GOTO_LABEL, ir.symbolTable.addLabel(),
                PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
            )
            ifState.labelAfterThen = ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.LABEL,
                ir.symbolTable.addLabel(),
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID
            )
        }

        // Add labelAfterElse
        ifState.labelAfterElse = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LABEL,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        // Patch IF true: GOTO labelBeforeThen
        ifState.gotoIfConditionTrue!!.patchOp2(ifState.labelBeforeThen!!.op1)
        // Patch IF false: GOTO labelAfterThen|labelBeforeElse
        ifState.gotoIfConditionFalse!!.patchOp1(
            if (noElseStmt) ifState.labelAfterThen!!.op1 else ifState.labelBeforeElse!!.op1
        )
        // Patch THEN: GOTO labelAfterThen|labelAfterElse
        ifState.gotoFromThenAfterIf!!.patchOp1(
            if (noElseStmt) ifState.labelAfterThen!!.op1 else ifState.labelAfterElse!!.op1
        )
    }

    override fun exitGosubstmt(ctx: GosubstmtContext) {
        val gotoLinenum = parseLinenum(ctx.linenum().text)
        val pushReturnLabel = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.PUSH_RETLABEL,
            ir.symbolTable.addGotoTarget(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.GOTO_LINENUM,
            getGotoLineNumberOp1(gotoLinenum),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        val labelReturn = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LABEL,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        pushReturnLabel.patchOp1(labelReturn.op1)
    }

    override fun exitGosublabelstmt(ctx: GosublabelstmtContext) {
        val gotoLabel = ir.symbolTable.addLabel(ctx.string().STRING().text)
        val pushReturnLabel = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.PUSH_RETLABEL,
            ir.symbolTable.addGotoTarget(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.GOTO_LABEL,
            gotoLabel,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        val labelReturn = ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LABEL,
            ir.symbolTable.addLabel(),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        pushReturnLabel.patchOp1(labelReturn.op1)
    }

    override fun exitReturnstmt(ctx: ReturnstmtContext) {
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.RETURN,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitGotostmt(ctx: GotostmtContext) {
        val gotoLinenum = parseLinenum(ctx.linenum().text)
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.GOTO_LINENUM,
            getGotoLineNumberOp1(gotoLinenum),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitGotolabelstmt(ctx: GotolabelstmtContext) {
        val gotoLabel = ir.symbolTable.addLabel(ctx.string().STRING().text)
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.GOTO_LABEL,
            gotoLabel,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitSwapstmt(ctx: SwapstmtContext) {
        val var1 = lookupInstruction(ctx.variable(0))
        val var2 = lookupInstruction(ctx.variable(1))
        val dt1 = ir.symbolTable[var1.result]!!.type!!.atomTypeId
        val dt2 = ir.symbolTable[var2.result]!!.type!!.atomTypeId
        if (dt1 !== dt2) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH,
                getCtxString(ctx),
                "$dt1 doesn't match $dt2"
            )
        }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.SWAP, var1.result, var2.result, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitOpen1stmt(ctx: Open1stmtContext) {
        val filenameInstr = lookupInstruction(ctx.filename)
        val fileOpenMode = getFileOpenMode(ctx.filemode1())
        val accessMode = getFileAccessMode(null)
        val lockMode = getLockMode(null)
        val fileNumber = parseInt32(ctx.filenum.text) { getCtxString(ctx) }
        val recordLenInstrId =
            if (ctx.reclen != null) lookupInstruction(ctx.reclen).result else ir.symbolTable.addTmp(
                PuffinBasicAtomTypeId.INT32
            ) { e: STEntry? -> e!!.value!!.int32 = PuffinBasicFile.DEFAULT_RECORD_LEN }
        Types.assertString(
            ir.symbolTable[filenameInstr.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[recordLenInstrId]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }

        // fileName, fileNumber
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2,
            filenameInstr.result,
            ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
                e!!.value!!.int32 = fileNumber
            },
            PuffinBasicSymbolTable.NULL_ID
        )
        // openMode, accessMode
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2,
            ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { e: STEntry? ->
                e!!.value!!.string = fileOpenMode.name
            },
            ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { e: STEntry? ->
                e!!.value!!.string = accessMode.name
            },
            PuffinBasicSymbolTable.NULL_ID
        )
        // lockMode, recordLen
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.OPEN,
            ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { e: STEntry? ->
                e!!.value!!.string = lockMode.name
            },
            recordLenInstrId,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitOpen2stmt(ctx: Open2stmtContext) {
        val filenameInstr = lookupInstruction(ctx.filename)
        val fileOpenMode = getFileOpenMode(ctx.filemode2())
        val accessMode = getFileAccessMode(ctx.access())
        val lockMode = getLockMode(ctx.lock())
        val fileNumber = parseInt32(ctx.filenum.text) { getCtxString(ctx) }
        val recordLenInstrId =
            if (ctx.reclen != null) lookupInstruction(ctx.reclen).result else ir.symbolTable.addTmp(
                PuffinBasicAtomTypeId.INT32
            ) { e: STEntry? -> e!!.value!!.int32 = PuffinBasicFile.DEFAULT_RECORD_LEN }
        Types.assertString(
            ir.symbolTable[filenameInstr.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[recordLenInstrId]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }

        // fileName, fileNumber
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2,
            filenameInstr.result,
            ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
                e!!.value!!.int32 = fileNumber
            },
            PuffinBasicSymbolTable.NULL_ID
        )
        // openMode, accessMode
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2,
            ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { e: STEntry? ->
                e!!.value!!.string = fileOpenMode.name
            },
            ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { e: STEntry? ->
                e!!.value!!.string = accessMode.name
            },
            PuffinBasicSymbolTable.NULL_ID
        )
        // lockMode, recordLen
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.OPEN,
            ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { e: STEntry? ->
                e!!.value!!.string = lockMode.name
            },
            recordLenInstrId,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitClosestmt(ctx: ClosestmtContext) {
        val fileNumbers = ctx.DECIMAL().stream()
            .map { fileNumberCtx: TerminalNode -> parseInt32(fileNumberCtx.text) { getCtxString(ctx) } }
            .collect(Collectors.toList())
        if (fileNumbers.isEmpty()) {
            ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.CLOSE_ALL,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID
            )
        } else {
            fileNumbers.forEach(Consumer { fileNumber: Int? ->
                ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                    OpCode.CLOSE,
                    ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
                        e!!.value!!.int32 = fileNumber!!
                    },
                    PuffinBasicSymbolTable.NULL_ID,
                    PuffinBasicSymbolTable.NULL_ID
                )
            })
        }
    }

    override fun exitFieldstmt(ctx: FieldstmtContext) {
        val fileNumberInstr = lookupInstruction(ctx.filenum)
        Types.assertNumeric(
            ir.symbolTable[fileNumberInstr.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        val numEntries = ctx.variable().size
        for (i in 0 until numEntries) {
            val recordPartLen = parseInt32(ctx.DECIMAL(i).text) { getCtxString(ctx) }
            val varInstr = lookupInstruction(ctx.variable(i))
            assertVariable(ir.symbolTable[varInstr.result]) { getCtxString(ctx) }
            ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.PARAM2,
                varInstr.result,
                ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
                    e!!.value!!.int32 = recordPartLen
                },
                PuffinBasicSymbolTable.NULL_ID
            )
        }
        // FileNumber, #fields
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.FIELD,
            fileNumberInstr.result,
            ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
                e!!.value!!.int32 = numEntries
            },
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    private fun assertVariable(entry: STEntry?, line: Supplier<String>) {
        if (!entry!!.isLValue) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.BAD_ARGUMENT,
                line.get(),
                "Expected variable, but found: $entry"
            )
        }
    }

    private fun assert1DArray(variableEntry: STVariable?, line: Supplier<String>) {
        val variable = variableEntry!!.variable
        if (!variable.isArray || !(variable.type as STObjects.ArrayType).isNDArray(1)) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.BAD_ARGUMENT,
                line.get(),
                "Variable: " + variable.variableName + " is not array1d"
            )
        }
    }

    private fun assert2DArray(variableEntry: STVariable?, line: Supplier<String>) {
        val variable = variableEntry!!.variable
        if (!variable.isArray || !(variable.type as STObjects.ArrayType).isNDArray(2)) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.BAD_ARGUMENT,
                line.get(),
                "Variable: " + variable.variableName + " is not array2d"
            )
        }
    }

    private fun assertNDArray(variable: STVariable?, line: Supplier<String>) {
        if (!variable!!.variable.isArray) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.BAD_ARGUMENT,
                line.get(),
                "Variable: " + variable.variable.variableName + " is not array"
            )
        }
    }

    override fun exitPutstmt(ctx: PutstmtContext) {
        val fileNumberInstr = parseInt32(ctx.filenum.text) { getCtxString(ctx) }
        val exprId: Int
        if (ctx.expr() != null) {
            exprId = lookupInstruction(ctx.expr()).result
            Types.assertNumeric(
                ir.symbolTable[exprId]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
        } else {
            exprId = PuffinBasicSymbolTable.NULL_ID
        }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PUTF,
            ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
                e!!.value!!.int32 = fileNumberInstr
            },
            exprId,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitMiddlrstmt(ctx: MiddlrstmtContext) {
        val varInstr = lookupInstruction(ctx.variable())
        val nInstr = lookupInstruction(ctx.expr(0))
        val mInstrId =
            if (ctx.expr().size == 3) lookupInstruction(ctx.expr(1)).result else ir.symbolTable.addTmp(
                PuffinBasicAtomTypeId.INT32
            ) { e: STEntry? -> e!!.value!!.int32 = -1 }
        val replacement =
            if (ctx.expr().size == 3) lookupInstruction(ctx.expr(2)) else lookupInstruction(
                ctx.expr(1)
            )
        Types.assertString(
            ir.symbolTable[varInstr.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertString(
            ir.symbolTable[replacement.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        assertVariable(
            ir.symbolTable[varInstr.result]
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[nInstr.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[mInstrId]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, varInstr.result, nInstr.result, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.MIDDLR_STMT, mInstrId, replacement.result, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitGetstmt(ctx: GetstmtContext) {
        val fileNumberInstr = parseInt32(ctx.filenum.text) { getCtxString(ctx) }
        val exprId: Int
        if (ctx.expr() != null) {
            exprId = lookupInstruction(ctx.expr()).result
            Types.assertNumeric(
                ir.symbolTable[exprId]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
        } else {
            exprId = PuffinBasicSymbolTable.NULL_ID
        }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.GETF,
            ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
                e!!.value!!.int32 = fileNumberInstr
            },
            exprId,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitRandomizestmt(ctx: RandomizestmtContext) {
        val exprId = lookupInstruction(ctx.expr()).result
        Types.assertNumeric(
            ir.symbolTable[exprId]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.RANDOMIZE, exprId, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitRandomizetimerstmt(ctx: RandomizetimerstmtContext) {
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.RANDOMIZE_TIMER,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitDefintstmt(ctx: DefintstmtContext) {
        handleDefTypeStmt(ctx.LETTERRANGE(), PuffinBasicAtomTypeId.INT32)
    }

    override fun exitDeflngstmt(ctx: DeflngstmtContext) {
        handleDefTypeStmt(ctx.LETTERRANGE(), PuffinBasicAtomTypeId.INT64)
    }

    override fun exitDefsngstmt(ctx: DefsngstmtContext) {
        handleDefTypeStmt(ctx.LETTERRANGE(), PuffinBasicAtomTypeId.FLOAT)
    }

    override fun exitDefdblstmt(ctx: DefdblstmtContext) {
        handleDefTypeStmt(ctx.LETTERRANGE(), PuffinBasicAtomTypeId.DOUBLE)
    }

    override fun exitDefstrstmt(ctx: DefstrstmtContext) {
        handleDefTypeStmt(ctx.LETTERRANGE(), PuffinBasicAtomTypeId.STRING)
    }

    override fun exitLsetstmt(ctx: LsetstmtContext) {
        val varInstr = lookupInstruction(ctx.variable())
        val exprInstr = lookupInstruction(ctx.expr())
        val varEntry = ir.symbolTable[varInstr.result]
        assertVariable(varEntry) { getCtxString(ctx) }
        Types.assertString(
            varEntry!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertString(
            ir.symbolTable[exprInstr.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.LSET, varInstr.result, exprInstr.result, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitRsetstmt(ctx: RsetstmtContext) {
        val varInstr = lookupInstruction(ctx.variable())
        val exprInstr = lookupInstruction(ctx.expr())
        val varEntry = ir.symbolTable[varInstr.result]
        assertVariable(varEntry) { getCtxString(ctx) }
        Types.assertString(
            varEntry!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertString(
            ir.symbolTable[exprInstr.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.RSET, varInstr.result, exprInstr.result, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitInputstmt(ctx: InputstmtContext) {
        for (varCtx in ctx.variable()) {
            val varInstr = lookupInstruction(varCtx)
            assertVariable(
                ir.symbolTable[varInstr.result]
            ) { getCtxString(ctx) }
            ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.PARAM1,
                varInstr.result,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID
            )
        }
        var promptId: Int = PuffinBasicSymbolTable.NULL_ID
        if (ctx.expr() != null) {
            promptId = lookupInstruction(ctx.expr()).result
            Types.assertString(
                ir.symbolTable[promptId]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
        }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.INPUT, promptId, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitInputhashstmt(ctx: InputhashstmtContext) {
        for (varCtx in ctx.variable()) {
            val varInstr = lookupInstruction(varCtx)
            assertVariable(
                ir.symbolTable[varInstr.result]
            ) { getCtxString(ctx) }
            ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.PARAM1,
                varInstr.result,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID
            )
        }
        val fileNumInstr = lookupInstruction(ctx.filenum)
        Types.assertNumeric(
            ir.symbolTable[fileNumInstr.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.INPUT,
            PuffinBasicSymbolTable.NULL_ID,
            fileNumInstr.result,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitLineinputstmt(ctx: LineinputstmtContext) {
        val varInstr = lookupInstruction(ctx.variable())
        assertVariable(
            ir.symbolTable[varInstr.result]
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.PARAM1,
            varInstr.result,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        val promptId: Int
        if (ctx.expr() != null) {
            promptId = lookupInstruction(ctx.expr()).result
            Types.assertString(
                ir.symbolTable[promptId]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
        } else {
            promptId = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { e: STEntry? ->
                e!!.value!!.string = ""
            }
        }
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LINE_INPUT,
            promptId,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitLineinputhashstmt(ctx: LineinputhashstmtContext) {
        val varInstr = lookupInstruction(ctx.variable())
        assertVariable(
            ir.symbolTable[varInstr.result]
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.PARAM1,
            varInstr.result,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        val fileNumInstr = lookupInstruction(ctx.filenum)
        Types.assertNumeric(
            ir.symbolTable[fileNumInstr.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LINE_INPUT,
            PuffinBasicSymbolTable.NULL_ID,
            fileNumInstr.result,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitWritestmt(ctx: WritestmtContext) {
        handleWritestmt(ctx, ctx.expr(), null)
    }

    override fun exitWritehashstmt(ctx: WritehashstmtContext) {
        val fileNumInstr = lookupInstruction(ctx.filenum)
        handleWritestmt(ctx, ctx.expr(), fileNumInstr)
    }

    fun handleWritestmt(
        ctx: ParserRuleContext,
        exprs: List<ExprContext>,
        fileNumber: PuffinBasicIR.Instruction?
    ) {
        val rangeStart = if (fileNumber == null) 0 else 1
        for (i in rangeStart..(exprs.size - 1)) {
            val exprCtx = exprs[i]
            val exprInstr = lookupInstruction(exprCtx)
            ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.WRITE,
                exprInstr.result,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID
            )
            if (i + 1 < exprs.size) {
                val commaId = ir.symbolTable.addTmp(
                    PuffinBasicAtomTypeId.STRING
                ) { entry: STEntry? -> entry!!.value!!.string = "," }
                ir.addInstruction(
                    sourceFile,
                    currentLineNumber,
                    ctx.start.startIndex,
                    ctx.stop.stopIndex,
                    OpCode.PRINT,
                    commaId,
                    PuffinBasicSymbolTable.NULL_ID,
                    PuffinBasicSymbolTable.NULL_ID
                )
            }
        }
        val newlineId = ir.symbolTable.addTmp(
            PuffinBasicAtomTypeId.STRING
        ) { entry: STEntry? -> entry!!.value!!.string = BabaSystem.lineSeparator() }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PRINT, newlineId, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
        )
        val fileNumberId: Int = if (fileNumber != null) {
            Types.assertNumeric(
                ir.symbolTable[fileNumber.result]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
            fileNumber.result
        } else {
            PuffinBasicSymbolTable.NULL_ID
        }
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.FLUSH,
            fileNumberId,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitReadstmt(ctx: ReadstmtContext) {
        for (varCtx in ctx.variable()) {
            val varInstr = lookupInstruction(varCtx)
            assertVariable(
                ir.symbolTable[varInstr.result]
            ) { getCtxString(ctx) }
            ir.addInstruction(
                sourceFile,
                currentLineNumber,
                ctx.start.startIndex,
                ctx.stop.stopIndex,
                OpCode.READ,
                varInstr.result,
                PuffinBasicSymbolTable.NULL_ID,
                PuffinBasicSymbolTable.NULL_ID
            )
        }
    }

    // GraphicsRuntime
    override fun exitRestorestmt(ctx: RestorestmtContext) {
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.RESTORE,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitDatastmt(ctx: DatastmtContext) {
        val children = ctx.children
        var i = 1
        while (i < children.size) {
            val child = children[i]
            var valueId: Int
            if (child is NumberContext) {
                valueId = lookupInstruction(child).result
            } else {
                val text = Types.unquote(child.text)
                valueId = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.STRING) { e: STEntry? ->
                    e!!.value!!.string = text
                }
            }
            ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
                OpCode.DATA, valueId, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
            )
            i += 2
        }
    }

    override fun exitLabelstmt(ctx: LabelstmtContext) {
        val label = ctx.string().STRING().text
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LABEL,
            ir.symbolTable.addLabel(label),
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitScreenstmt(ctx: ScreenstmtContext) {
        assertGraphics()
        val title = lookupInstruction(ctx.expr(0))
        val w = lookupInstruction(ctx.expr(1))
        val h = lookupInstruction(ctx.expr(2))
        val iw = if (ctx.expr().size == 5) lookupInstruction(ctx.expr(3)) else w
        val ih = if (ctx.expr().size == 5) lookupInstruction(ctx.expr(4)) else h
        val manualRepaintFlag = ctx.mr != null
        val doubleBufferFlag = ctx.db != null
        Types.assertString(
            ir.symbolTable[title.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[w.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[h.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[iw.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[ih.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, w.result, h.result, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, iw.result, ih.result, PuffinBasicSymbolTable.NULL_ID
        )
        val repaint = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
            e!!.value!!.int32 = if (manualRepaintFlag) 0 else -1
        }
        val doubleBuffer = ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
            e!!.value!!.int32 = if (doubleBufferFlag) -1 else 0
        }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, repaint, doubleBuffer, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.SCREEN,
            title.result,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitRepaintstmt(ctx: RepaintstmtContext) {
        assertGraphics()
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.REPAINT,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitCirclestmt(ctx: CirclestmtContext) {
        assertGraphics()
        val x = lookupInstruction(ctx.x)
        val y = lookupInstruction(ctx.y)
        val r1 = lookupInstruction(ctx.r1)
        val r2 = lookupInstruction(ctx.r2)
        val s = if (ctx.s != null) lookupInstruction(ctx.s) else null
        val e = if (ctx.e != null) lookupInstruction(ctx.e) else null
        val fill = if (ctx.fill != null) lookupInstruction(ctx.fill) else null
        Types.assertNumeric(
            ir.symbolTable[x.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[y.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[r1.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[r2.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        if (s != null) {
            Types.assertNumeric(
                ir.symbolTable[s.result]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
        }
        if (e != null) {
            Types.assertNumeric(
                ir.symbolTable[e.result]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
        }
        if (fill != null) {
            Types.assertString(
                ir.symbolTable[fill.result]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
        }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, x.result, y.result, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2,
            s?.result ?: PuffinBasicSymbolTable.NULL_ID,
            e?.result ?: PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM1,
            fill?.result ?: PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.CIRCLE, r1.result, r2.result, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitLinestmt(ctx: LinestmtContext) {
        assertGraphics()
        val x1 = lookupInstruction(ctx.x1)
        val y1 = lookupInstruction(ctx.y1)
        val x2 = lookupInstruction(ctx.x2)
        val y2 = lookupInstruction(ctx.y2)
        Types.assertNumeric(
            ir.symbolTable[x1.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[y1.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[x2.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[y2.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        var bf: PuffinBasicIR.Instruction? = null
        if (ctx.bf != null) {
            bf = lookupInstruction(ctx.bf)
            Types.assertString(
                ir.symbolTable[bf.result]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
        }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, x1.result, y1.result, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, x2.result, y2.result, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LINE,
            bf?.result ?: PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitColorstmt(ctx: ColorstmtContext) {
        val r = lookupInstruction(ctx.r)
        val g = lookupInstruction(ctx.g)
        val b = lookupInstruction(ctx.b)
        Types.assertNumeric(
            ir.symbolTable[r.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[g.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[b.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, r.result, g.result, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.COLOR, b.result, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitPaintstmt(ctx: PaintstmtContext) {
        assertGraphics()
        val x = lookupInstruction(ctx.x)
        val y = lookupInstruction(ctx.y)
        val r = lookupInstruction(ctx.r)
        val g = lookupInstruction(ctx.g)
        val b = lookupInstruction(ctx.b)
        Types.assertNumeric(
            ir.symbolTable[x.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[y.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[r.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[g.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[b.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, r.result, g.result, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM1, b.result, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PAINT, x.result, y.result, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitPsetstmt(ctx: PsetstmtContext) {
        assertGraphics()
        val x = lookupInstruction(ctx.x)
        val y = lookupInstruction(ctx.y)
        var rId = PuffinBasicSymbolTable.NULL_ID
        var gId = PuffinBasicSymbolTable.NULL_ID
        var bId = PuffinBasicSymbolTable.NULL_ID
        if (ctx.r != null) {
            rId = lookupInstruction(ctx.r).result
            Types.assertNumeric(
                ir.symbolTable[rId]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
        }
        if (ctx.g != null) {
            gId = lookupInstruction(ctx.g).result
            Types.assertNumeric(
                ir.symbolTable[gId]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
        }
        if (ctx.b != null) {
            bId = lookupInstruction(ctx.b).result
            Types.assertNumeric(
                ir.symbolTable[bId]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
        }
        Types.assertNumeric(
            ir.symbolTable[x.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[y.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, rId, gId, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM1, bId, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PSET, x.result, y.result, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitGraphicsgetstmt(ctx: GraphicsgetstmtContext) {
        assertGraphics()
        val x1 = lookupInstruction(ctx.x1)
        val y1 = lookupInstruction(ctx.y1)
        val x2 = lookupInstruction(ctx.x2)
        val y2 = lookupInstruction(ctx.y2)
        val varInstr = lookupInstruction(ctx.variable())
        val bufferNumber = if (ctx.BACK1() != null) 0 //GraphicsUtil.BUFFER_NUM_BACK1
        else 1 //GraphicsUtil.BUFFER_NUM_FRONT;
        Types.assertNumeric(
            ir.symbolTable[x1.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[y1.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[x2.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[y2.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        assertVariable(
            ir.symbolTable[varInstr.result]
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, x1.result, y1.result, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, x2.result, y2.result, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.GGET, varInstr.result,
            ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
                e!!.value!!.int32 = bufferNumber
            },
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitGraphicsputstmt(ctx: GraphicsputstmtContext) {
        assertGraphics()
        val x = lookupInstruction(ctx.x)
        val y = lookupInstruction(ctx.y)
        val varInstr = lookupInstruction(ctx.variable())
        val action = if (ctx.action != null) lookupInstruction(ctx.action) else null
        val bufferNumber = if (ctx.FRONT() == null) 0 //GraphicsUtil.BUFFER_NUM_BACK1
        else 1 // GraphicsUtil.BUFFER_NUM_FRONT;
        Types.assertNumeric(
            ir.symbolTable[x.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[y.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        assertVariable(
            ir.symbolTable[varInstr.result]
        ) { getCtxString(ctx) }
        if (action != null) {
            Types.assertString(
                ir.symbolTable[action.result]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
        }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, x.result, y.result, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM1,
            ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
                e!!.value!!.int32 = bufferNumber
            },
            PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.GPUT,
            action?.result ?: PuffinBasicSymbolTable.NULL_ID,
            varInstr.result,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitGraphicsbuffercopyhorstmt(ctx: GraphicsbuffercopyhorstmtContext) {
        assertGraphics()
        val srcx = lookupInstruction(ctx.srcx)
        val dstx = lookupInstruction(ctx.dstx)
        val w = lookupInstruction(ctx.w)
        Types.assertNumeric(
            ir.symbolTable[srcx.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[dstx.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[w.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, srcx.result, dstx.result, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.BUFFERCOPYHOR,
            w.result,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitDrawstmt(ctx: DrawstmtContext) {
        assertGraphics()
        val str = lookupInstruction(ctx.expr())
        Types.assertString(
            ir.symbolTable[str.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.DRAW, str.result, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitFontstmt(ctx: FontstmtContext) {
        assertGraphics()
        val name = lookupInstruction(ctx.name)
        val style = lookupInstruction(ctx.style)
        val size = lookupInstruction(ctx.size)
        Types.assertString(
            ir.symbolTable[style.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[size.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertString(
            ir.symbolTable[name.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, style.result, size.result, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.FONT, name.result, PuffinBasicSymbolTable.NULL_ID, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitDrawstrstmt(ctx: DrawstrstmtContext) {
        val str = lookupInstruction(ctx.str)
        val x = lookupInstruction(ctx.x)
        val y = lookupInstruction(ctx.y)
        Types.assertNumeric(
            ir.symbolTable[x.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertNumeric(
            ir.symbolTable[y.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        Types.assertString(
            ir.symbolTable[str.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, x.result, y.result, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.DRAWSTR,
            str.result,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitLoadimgstmt(ctx: LoadimgstmtContext) {
        assertGraphics()
        val path = lookupInstruction(ctx.path)
        val varInstr = lookupInstruction(ctx.variable())
        Types.assertString(
            ir.symbolTable[path.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        assertVariable(
            ir.symbolTable[varInstr.result]
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.LOADIMG, path.result, varInstr.result, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitSaveimgstmt(ctx: SaveimgstmtContext) {
        assertGraphics()
        val path = lookupInstruction(ctx.path)
        val varInstr = lookupInstruction(ctx.variable())
        Types.assertString(
            ir.symbolTable[path.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        assertVariable(
            ir.symbolTable[varInstr.result]
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.SAVEIMG, path.result, varInstr.result, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitClsstmt(ctx: ClsstmtContext) {
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.CLS,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitLocatestmt(ctx: LocatestmtContext) {
        var row = lookupInstruction(ctx.row)
        var col = ctx.col?.let { col -> lookupInstruction(col) } ?: null
        Types.assertNumeric(
            ir.symbolTable[row.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        col?.let { col ->
            Types.assertNumeric(
                ir.symbolTable[col.result]!!.type!!.atomTypeId
            ) { getCtxString(ctx) }
        }

        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LOCATE,
            row.result,
            col?.result ?: PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitLoadwavstmt(ctx: LoadwavstmtContext) {
        assertGraphics()
        val path = lookupInstruction(ctx.path)
        val varInstr = lookupInstruction(ctx.variable())
        Types.assertString(
            ir.symbolTable[path.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        assertVariable(
            ir.symbolTable[varInstr.result]
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.LOADWAV, path.result, varInstr.result, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitPlaywavstmt(ctx: PlaywavstmtContext) {
        assertGraphics()
        val varInstr = lookupInstruction(ctx.variable())
        assertVariable(
            ir.symbolTable[varInstr.result]
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.PLAYWAV,
            varInstr.result,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitStopwavstmt(ctx: StopwavstmtContext) {
        assertGraphics()
        val varInstr = lookupInstruction(ctx.variable())
        assertVariable(
            ir.symbolTable[varInstr.result]
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.STOPWAV,
            varInstr.result,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitLoopwavstmt(ctx: LoopwavstmtContext) {
        assertGraphics()
        val varInstr = lookupInstruction(ctx.variable())
        assertVariable(
            ir.symbolTable[varInstr.result]
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.LOOPWAV,
            varInstr.result,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitSleepstmt(ctx: SleepstmtContext) {
        val millis = lookupInstruction(ctx.expr())
        Types.assertNumeric(
            ir.symbolTable[millis.result]!!.type!!.atomTypeId
        ) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.SLEEP,
            millis.result,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitBeepstmt(ctx: BeepstmtContext) {
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.BEEP,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitArray1dsortstmt(ctx: Array1dsortstmtContext) {
        val var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), false)
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.ARRAY1DSORT,
            var1Instr.result,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitArraycopystmt(ctx: ArraycopystmtContext) {
        val var1Instr = getArrayNdVariableInstruction(ctx, ctx.variable(0))
        val var2Instr = getArrayNdVariableInstruction(ctx, ctx.variable(1))
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.ARRAYCOPY, var1Instr.result, var2Instr.result, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitArray1dcopystmt(ctx: Array1dcopystmtContext) {
        val var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(0), false)
        val var2Instr = getArray1dVariableInstruction(ctx, ctx.variable(1), false)
        val src0 = lookupInstruction(ctx.src0)
        Types.assertNumeric(ir.symbolTable[src0.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        val dst0 = lookupInstruction(ctx.dst0)
        Types.assertNumeric(ir.symbolTable[dst0.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        val len = lookupInstruction(ctx.len)
        Types.assertNumeric(ir.symbolTable[len.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, var1Instr.result, src0.result, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.PARAM2, var2Instr.result, dst0.result, PuffinBasicSymbolTable.NULL_ID
        )
        ir.addInstruction(
            sourceFile,
            currentLineNumber,
            ctx.start.startIndex,
            ctx.stop.stopIndex,
            OpCode.ARRAY1DCOPY,
            len.result,
            PuffinBasicSymbolTable.NULL_ID,
            PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitArray2dshifthorstmt(ctx: Array2dshifthorstmtContext) {
        val varInstr = getArray2dVariableInstruction(ctx, ctx.variable())
        val expr = lookupInstruction(ctx.expr())
        Types.assertNumeric(ir.symbolTable[expr.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.ARRAY2DSHIFTHOR, varInstr.result, expr.result, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitArray2dshiftverstmt(ctx: Array2dshiftverstmtContext) {
        val varInstr = getArray2dVariableInstruction(ctx, ctx.variable())
        val expr = lookupInstruction(ctx.expr())
        Types.assertNumeric(ir.symbolTable[expr.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.ARRAY2DSHIFTVER, varInstr.result, expr.result, PuffinBasicSymbolTable.NULL_ID
        )
    }

    override fun exitArrayfillstmt(ctx: ArrayfillstmtContext) {
        val varInstr = getArrayNdVariableInstruction(ctx, ctx.variable())
        val expr = lookupInstruction(ctx.expr())
        Types.assertNumeric(ir.symbolTable[expr.result]!!.type!!.atomTypeId) { getCtxString(ctx) }
        ir.addInstruction(
            sourceFile, currentLineNumber, ctx.start.startIndex, ctx.stop.stopIndex,
            OpCode.ARRAYFILL, varInstr.result, expr.result, PuffinBasicSymbolTable.NULL_ID
        )
    }

    private fun assertGraphics() {
        if (!graphics) {
            throw PuffinBasicInternalError(
                "GraphicsRuntime is not enabled!"
            )
        }
    }

    private fun handleDefTypeStmt(
        letterRanges: List<TerminalNode>,
        dataType: PuffinBasicAtomTypeId
    ) {
        val defs: MutableList<Char> = ArrayList()
        letterRanges.stream().map<String> { obj: TerminalNode -> obj.text }
            .forEach { lr: String ->
                var i = lr[0]
                while (i <= lr[2]) {
                    defs.add(i)
                    i++
                }
            }
        defs.forEach(Consumer { def: Char? ->
            ir.symbolTable.setDefaultDataType(
                def!!, dataType
            )
        })
    }

    private fun getGotoLineNumberOp1(lineNumber: Int): Int {
        return ir.symbolTable.addTmp(PuffinBasicAtomTypeId.INT32) { e: STEntry? ->
            e!!.value!!.int32 = lineNumber
        }
    }

    private fun checkDataTypeMatch(id1: Int, id2: Int, lineSupplier: Supplier<String>) {
        checkDataTypeMatch(ir.symbolTable[id1], id2, lineSupplier)
    }

    private fun checkDataTypeMatch(entry1: STEntry?, id2: Int, lineSupplier: Supplier<String>) {
        val entry2 = ir.symbolTable[id2]
        if (entry1!!.type!!.atomTypeId === PuffinBasicAtomTypeId.STRING && entry2!!.type!!.atomTypeId !== PuffinBasicAtomTypeId.STRING || entry1!!.type!!.atomTypeId !== PuffinBasicAtomTypeId.STRING && entry2!!.type!!.atomTypeId === PuffinBasicAtomTypeId.STRING) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH,
                lineSupplier.get(),
                "Data type " + entry1!!.type!!.atomTypeId
                        + " mismatches with " + entry2!!.type!!.atomTypeId
            )
        }
    }

    private fun checkDataTypeMatch(
        dt1: PuffinBasicAtomTypeId,
        dt2: PuffinBasicAtomTypeId,
        lineSupplier: Supplier<String>
    ) {
        if (dt1 === PuffinBasicAtomTypeId.STRING && dt2 !== PuffinBasicAtomTypeId.STRING || dt1 !== PuffinBasicAtomTypeId.STRING && dt2 === PuffinBasicAtomTypeId.STRING) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH,
                lineSupplier.get(),
                "Data type $dt1 mismatches with $dt2"
            )
        }
    }

    private enum class NumericOrString {
        NUMERIC, STRING
    }

    private class UDFState(val variableName: VariableName, val udfEntry: STUDF) {
        val gotoLabelGotoCaller: MutableList<PuffinBasicIR.Instruction>
        var gotoPostFuncDecl: PuffinBasicIR.Instruction? = null
        var labelFuncStart: PuffinBasicIR.Instruction? = null
        var udfId = 0

        init {
            gotoLabelGotoCaller = ArrayList(2)
        }
    }

    private class WhileLoopState {
        var labelBeforeWhile: PuffinBasicIR.Instruction? = null
        var gotoAfterWend: PuffinBasicIR.Instruction? = null
    }

    private class ForLoopState {
        var variable: Variable? = null
        var labelApplyStep: PuffinBasicIR.Instruction? = null
        var gotoAfterNext: PuffinBasicIR.Instruction? = null
    }

    private class IfState {
        var gotoIfConditionTrue: PuffinBasicIR.Instruction? = null
        var gotoIfConditionFalse: PuffinBasicIR.Instruction? = null
        var gotoFromThenAfterIf: PuffinBasicIR.Instruction? = null
        var labelBeforeThen: PuffinBasicIR.Instruction? = null
        var labelAfterThen: PuffinBasicIR.Instruction? = null
        var labelBeforeElse: PuffinBasicIR.Instruction? = null
        var labelAfterElse: PuffinBasicIR.Instruction? = null
    }

    companion object {
        private fun getFileOpenMode(filemode1: Filemode1Context?): FileOpenMode {
            val mode = if (filemode1 != null) Types.unquote(filemode1.text) else null
            return if (mode == null || mode.equals("r", ignoreCase = true)) {
                FileOpenMode.RANDOM
            } else if (mode.equals("i", ignoreCase = true)) {
                FileOpenMode.INPUT
            } else if (mode.equals("o", ignoreCase = true)) {
                FileOpenMode.OUTPUT
            } else {
                FileOpenMode.APPEND
            }
        }

        private fun getFileOpenMode(filemode2: Filemode2Context?): FileOpenMode {
            return if (filemode2 == null || filemode2.RANDOM() != null) {
                FileOpenMode.RANDOM
            } else if (filemode2.INPUT() != null) {
                FileOpenMode.INPUT
            } else if (filemode2.OUTPUT() != null) {
                FileOpenMode.OUTPUT
            } else {
                FileOpenMode.APPEND
            }
        }

        private fun getFileAccessMode(access: AccessContext?): FileAccessMode {
            return if (access == null || access.READ() != null && access.WRITE() != null) {
                FileAccessMode.READ_WRITE
            } else if (access.READ() != null) {
                FileAccessMode.READ_ONLY
            } else {
                FileAccessMode.WRITE_ONLY
            }
        }

        private fun getLockMode(lock: LockContext?): PuffinBasicFile.LockMode {
            return if (lock == null) {
                PuffinBasicFile.LockMode.DEFAULT
            } else if (lock.SHARED() != null) {
                PuffinBasicFile.LockMode.SHARED
            } else if (lock.READ() != null && lock.WRITE() != null) {
                PuffinBasicFile.LockMode.READ_WRITE
            } else if (lock.READ() != null) {
                PuffinBasicFile.LockMode.READ
            } else {
                PuffinBasicFile.LockMode.WRITE
            }
        }
    }
}