package org.puffinbasic.parser

import org.antlr.v4.runtime.misc.Interval
import org.puffinbasic.domain.PuffinBasicSymbolTable
import java.util.Objects

class PuffinBasicIR(@JvmField val symbolTable: PuffinBasicSymbolTable) {
    private val instructions: MutableList<Instruction>

    init {
        instructions = ArrayList()
    }

    fun getCodeStreamFor(instruction: Instruction): String {
        return try {
            instruction.inputRef.sourceFile.sourceCodeStream.getText(
                Interval(instruction.inputRef.inputStartIndex, instruction.inputRef.inputStopIndex)
            )
        } catch (e: Exception) {
            "Internal error: " + e.message
        }
    }

    fun getInstructions(): List<Instruction> {
        return ArrayList(instructions)
    }

    fun addInstruction(
        sourceFile: PuffinBasicSourceFile, linenum: Int, startIndex: Int, stopIndex: Int,
        opCode: OpCode, op1: Int, op2: Int, result: Int
    ): Instruction {
        val instruction = Instruction(
            InputRef(sourceFile, linenum, startIndex, stopIndex), opCode, op1, op2, result
        )
        instructions.add(instruction)
        return instruction
    }

    enum class OpCode(val repr: String) {
        COMMENT("comment"), VARIABLE("var"), VALUE("val"), VARREF("varref"), STRUCT_LVALUE("structLValue"), MEMBER_FUNC_CALL(
            "memberFuncCall"
        ),
        DIM("dim"), ALLOCARRAY("allocArray"), REALLOCARRAY("reAllocArray"), CREATE_INSTANCE("createAndSetInstance"), STRUCT_MEMBER_REF(
            "structMemberRef"
        ),
        ASSIGN("a="), COPY("c="), PARAM_COPY("p="), UNARY_MINUS("u-"), LEFTSHIFT("<<"), RIGHTSHIFT(">>"), PRINT(
            "?"
        ),
        PRINTUSING("?f"), FLUSH("flush"), RESET_ARRAY_IDX("resetArrIdx"), SET_ARRAY_IDX("setArrIdx"), GOTO_LINENUM(
            "goto"
        ),
        GOTO_LABEL("gotoLabel"), GOTO_LABEL_IF("gotoLabelIf"), GOTO_CALLER("gotoCaller"), LABEL("label"), PUSH_RT_SCOPE(
            "pushRtScope"
        ),
        POP_RT_SCOPE("popRtScope"), END("end"), RETURN("ret"), PUSH_RETLABEL("pushRetLabel"), SWAP("swap"), EXPI32(
            "i32^"
        ),
        EXPI64("i64^"), EXPF32("f32^"), EXPF64("f64^"), MULI32("i32*"), MULI64("i64*"), MULF32("f32*"), MULF64(
            "f64*"
        ),
        IDIV("\\"), FDIV("/"), ADDI32("i32+"), ADDI64("i64+"), ADDF32("f32+"), ADDF64("f64+"), CONCAT(
            "concat"
        ),
        SUBI32("i32-"), SUBI64("i64-"), SUBF32("f32-"), SUBF64("f64-"), MOD("mod"), EQI32("i32="), EQI64(
            "i64="
        ),
        EQF32("f32="), EQF64("f64="), EQSTR("str="), NEI32("i32<>"), NEI64("i64<>"), NEF32("f32<>"), NEF64(
            "f64<>"
        ),
        NESTR("str<>"), LTI32("i32<"), LTI64("i64<"), LTF32("f32<"), LTF64("f64<"), LTSTR("str<"), LEI32(
            "i32<="
        ),
        LEI64("i64<="), LEF32("f32<="), LEF64("f64<="), LESTR("str<="), GTI32("i32>"), GTI64("i64>"), GTF32(
            "f32>"
        ),
        GTF64("f64>"), GTSTR("str>"), GEI32("i32>="), GEI64("i64>="), GEF32("f32>="), GEF64("f64>="), GESTR(
            "str>="
        ),
        NOT("not"), AND("and"), OR("or"), XOR("xor"), EQV("eqv"), IMP("imp"), ABS("abs"), ASC("asc"), SIN(
            "sin"
        ),
        COS("cos"), TAN("tan"), ASIN("asin"), ACOS("acos"), ATN("atn"), SINH("sinh"), COSH("cosh"), TANH(
            "tanh"
        ),
        SQR("sqr"), EEXP("exp"), CINT("cint"), CLNG("clng"), CSNG("csng"), CDBL("cdbl"), CHRDLR("chr$"), CVI(
            "cvi"
        ),
        CVL("cvl"), CVS("cvs"), CVD("cvd"), MKIDLR("mki$"), MKLDLR("mkl$"), MKSDLR("mks$"), MKDDLR("mkd$"), SPACEDLR(
            "space$"
        ),
        STRDLR("str$"), VAL("val"), INT("int"), FIX("fix"), LOG("log"), LOG10("log10"), LOG2("log2"), TORAD(
            "torad"
        ),
        TODEG("todeg"), FLOOR("floor"), CEIL("ceil"), ROUND("round"), E("e"), PI("pi"), MIN("min"), MAX(
            "max"
        ),
        ARRAYFILL("arrayfill"), ARRAY1DMIN("array1dmin"), ARRAY1DMAX("array1dmax"), ARRAY1DMEAN("array1dmean"), ARRAY1DSUM(
            "array1dsum"
        ),
        ARRAY1DSTD("array1dstd"), ARRAY1DMEDIAN("array1dmedian"), ARRAY1DPCT("array1dpct"), ARRAY1DSORT(
            "array1dsort"
        ),
        ARRAY1DBINSEARCH("array1dbinsearch"), ARRAY1DCOPY("array1dcopy"), ARRAYCOPY("arraycopy"), ARRAY2DSHIFTHOR(
            "array2dshifthor"
        ),
        ARRAY2DSHIFTVER("array2dshiftver"), ARRAY2DFINDROW("array2dFindRow"), ARRAY2DFINDCOLUMN("array2sFindColumn"), LEN(
            "len"
        ),
        HEXDLR("hex$"), OCTDLR("oct$"), LEFTDLR("left$"), RIGHTDLR("right$"), INSTR("instr"), MIDDLR(
            "mid$"
        ),
        MIDDLR_STMT("mid\$_stmt"), SPLITDLR("split$"), RND("rnd"), SGN("sgn"), TIMER("timer"), TIMERMILLIS(
            "timerMillis"
        ),
        STRINGDLR("string$"), OPEN("open"), CLOSE_ALL("close_all"), CLOSE("close"), FIELD("field"), PUTF(
            "putf"
        ),
        GETF("getf"), LOC("loc"), LOF("lof"), EOF("eof"), RANDOMIZE("randomize"), RANDOMIZE_TIMER("randomizeTimer"), LSET(
            "lset"
        ),
        RSET("rset"), INPUTDLR("input$"), INPUT("input"), LINE_INPUT("lineInput"), WRITE("write"), RESTORE(
            "restore"
        ),
        DATA("data"), READ("read"), ENVIRONDLR("environ$"), SCREEN("screen"), REPAINT("repaint"), CIRCLE(
            "circle"
        ),
        SLEEP("sleep"), LINE("line"), COLOR("color"), INKEYDLR("inkey$"), PAINT("paint"), PSET("pset"), GPUT(
            "gput"
        ),
        GGET("gget"), BUFFERCOPYHOR("buffercopyhor"), LOADIMG("loadimg"), SAVEIMG("saveimg"), DRAWSTR(
            "drawstr"
        ),
        DRAW("draw"), FONT("font"), CLS("cls"), BEEP("beep"), ARRAYREF("arrayref"), HSB2RGB("hsb2rgb"), LOADWAV(
            "loadwav"
        ),
        PLAYWAV("playwav"), STOPWAV("stopwav"), LOOPWAV("loopwav"), PARAM2("param2"), PARAM1("param1"), MOUSEMOVEDX(
            "mousemovedx"
        ),
        MOUSEMOVEDY("mousemovedy"), MOUSEDRAGGEDX("mousedraggedx"), MOUSEDRAGGEDY("mousedraggedy"), MOUSEBUTTONCLICKED(
            "mousebuttonclicked"
        ),
        MOUSEBUTTONPRESSED("mousebuttonpressed"), MOUSEBUTTONRELEASED("mousebuttonreleased"), ISKEYPRESSED(
            "iskeypressed"
        ),
        LTRIMDLR("ltrim$"), RTRIMDLR("rtrim$")
    }

    class InputRef(
        val sourceFile: PuffinBasicSourceFile,
        @JvmField val lineNumber: Int,
        val inputStartIndex: Int,
        val inputStopIndex: Int
    ) {
        override fun equals(o: Any?): Boolean {
            if (this === o) return true
            if (o == null || javaClass != o.javaClass) return false
            val other = o as InputRef
            return sourceFile == other.sourceFile && lineNumber == other.lineNumber && inputStartIndex == other.inputStartIndex && inputStopIndex == other.inputStopIndex
        }

        override fun hashCode(): Int {
            return Objects.hash(sourceFile, lineNumber, inputStartIndex, inputStopIndex)
        }

        override fun toString(): String {
            return "[" + sourceFile.relativePath + ":" + lineNumber + "(" + inputStartIndex + "-" + inputStopIndex + ")]"
        }
    }

    class Instruction(
        @JvmField val inputRef: InputRef,
        @JvmField val opCode: OpCode,
        @JvmField var op1: Int,
        @JvmField var op2: Int,
        @JvmField val result: Int
    ) {
        fun patchOp1(op1: Int) {
            this.op1 = op1
        }

        fun patchOp2(op2: Int) {
            this.op2 = op2
        }

        override fun toString(): String {
            return String.format(
                "[%s:%4d]\t%4s\t%4s %4s %4s",
                inputRef.sourceFile.relativePath, inputRef.lineNumber, opCode.repr, op1, op2, result
            )
        }
    }
}