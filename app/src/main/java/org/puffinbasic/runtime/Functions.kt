package org.puffinbasic.runtime

import com.google.common.base.Strings
import it.unimi.dsi.fastutil.doubles.Double2DoubleFunction
import org.puffinbasic.domain.PuffinBasicSymbolTable
import org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId
import org.puffinbasic.domain.STObjects.PuffinBasicTypeId
import org.puffinbasic.error.PuffinBasicInternalError
import org.puffinbasic.error.PuffinBasicRuntimeError
import org.puffinbasic.file.PuffinBasicFiles
import org.puffinbasic.parser.PuffinBasicIR
import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets
import java.time.Duration
import java.time.Instant
import java.time.ZonedDateTime
import java.util.Random
import java.util.concurrent.TimeUnit
import kotlin.math.abs
import kotlin.math.atan
import kotlin.math.ln
import kotlin.math.roundToLong
import kotlin.math.sqrt

object Functions {
    @JvmStatic
    fun abs(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val op1Entry = symbolTable[instruction.op1]
        val op1 = op1Entry!!.value
        val result = symbolTable[instruction.result]!!.value
        when (op1Entry.type!!.atomTypeId) {
            PuffinBasicAtomTypeId.INT32 -> result!!.int32 = abs(
                op1!!.int32
            )

            PuffinBasicAtomTypeId.INT64 -> result!!.int64 = abs(op1!!.int64)
            PuffinBasicAtomTypeId.FLOAT -> result!!.float32 = abs(op1!!.float32)
            PuffinBasicAtomTypeId.DOUBLE -> result!!.float64 = abs(op1!!.float64)
            else -> throwUnsupportedType(op1Entry.type!!.atomTypeId)
        }
    }

    @JvmStatic
    fun asc(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val value = symbolTable[instruction.op1]!!.value!!.string
        if (value.isNullOrEmpty()) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM,
                "IllegalFunctionCall: null/empty string: '$value'"
            )
        }
        val ascii = value[0].code
        symbolTable[instruction.result]!!.value!!.int32 = ascii
    }

    @JvmStatic
    fun sin(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { a: Double -> kotlin.math.sin(a) }
    }

    @JvmStatic
    fun cos(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { a: Double -> kotlin.math.cos(a) }
    }

    @JvmStatic
    fun tan(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { a: Double -> kotlin.math.tan(a) }
    }

    @JvmStatic
    fun asin(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { a: Double -> kotlin.math.asin(a) }
    }

    @JvmStatic
    fun acos(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { a: Double -> kotlin.math.acos(a) }
    }

    @JvmStatic
    fun atn(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { a: Double -> atan(a) }
    }

    @JvmStatic
    fun sinh(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { x: Double -> kotlin.math.sinh(x) }
    }

    @JvmStatic
    fun cosh(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { x: Double -> kotlin.math.cosh(x) }
    }

    @JvmStatic
    fun tanh(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { x: Double -> kotlin.math.tanh(x) }
    }

    @JvmStatic
    fun sqr(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { a: Double -> sqrt(a) }
    }

    @JvmStatic
    fun log(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { a: Double -> ln(a) }
    }

    @JvmStatic
    fun log10(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { a: Double -> kotlin.math.log10(a) }
    }

    @JvmStatic
    fun log2(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { x: Double -> mathLog2(x) }
    }

    private fun mathLog2(x: Double): Double {
        return ln(x) / ln(2.0)
    }

    @JvmStatic
    fun exp(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { a: Double -> kotlin.math.exp(a) }
    }

    @JvmStatic
    fun toRad(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { angdeg: Double -> Math.toRadians(angdeg) }
    }

    @JvmStatic
    fun toDeg(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { angrad: Double -> Math.toDegrees(angrad) }
    }

    @JvmStatic
    fun floor(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { a: Double -> kotlin.math.floor(a) }
    }

    @JvmStatic
    fun ceil(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { a: Double -> kotlin.math.ceil(a) }
    }

    @JvmStatic
    fun round(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        applyDoubleFunction(symbolTable, instruction) { a: Double ->
            a.roundToLong()
                .toDouble()
        }
    }

    @JvmStatic
    fun e(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val result = symbolTable[instruction.result]!!.value
        result!!.float64 = Math.E
    }

    @JvmStatic
    fun pi(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val result = symbolTable[instruction.result]!!.value
        result!!.float64 = Math.PI
    }

    @JvmStatic
    fun min(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val resultEntry = symbolTable[instruction.result]
        val result = resultEntry!!.value
        when (resultEntry.type!!.atomTypeId) {
            PuffinBasicAtomTypeId.INT32 -> result!!.int32 = kotlin.math.min(
                v1!!.int32, v2!!.int32
            )

            PuffinBasicAtomTypeId.INT64 -> result!!.int64 = kotlin.math.min(v1!!.int64, v2!!.int64)
            PuffinBasicAtomTypeId.FLOAT -> result!!.float32 =
                kotlin.math.min(v1!!.float32, v2!!.float32)

            PuffinBasicAtomTypeId.DOUBLE -> result!!.float64 =
                kotlin.math.min(v1!!.float64, v2!!.float64)

            else -> throwUnsupportedType(resultEntry.type!!.atomTypeId)
        }
    }

    @JvmStatic
    fun max(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val resultEntry = symbolTable[instruction.result]
        val result = resultEntry!!.value
        when (resultEntry.type!!.atomTypeId) {
            PuffinBasicAtomTypeId.INT32 -> result!!.int32 = kotlin.math.max(
                v1!!.int32, v2!!.int32
            )

            PuffinBasicAtomTypeId.INT64 -> result!!.int64 = kotlin.math.max(v1!!.int64, v2!!.int64)
            PuffinBasicAtomTypeId.FLOAT -> result!!.float32 =
                kotlin.math.max(v1!!.float32, v2!!.float32)

            PuffinBasicAtomTypeId.DOUBLE -> result!!.float64 =
                kotlin.math.max(v1!!.float64, v2!!.float64)

            else -> throwUnsupportedType(resultEntry.type!!.atomTypeId)
        }
    }

    private fun applyDoubleFunction(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction,
        function: Double2DoubleFunction
    ) {
        val value = symbolTable[instruction.op1]!!.value!!.float64
        val result = symbolTable[instruction.result]!!.value
        result!!.float64 = function.applyAsDouble(value)
    }

    @JvmStatic
    fun cint(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val entry = symbolTable[instruction.op1]!!.value
        val value = entry!!.float64
        if (value < Int.MIN_VALUE || value > Int.MAX_VALUE) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.DATA_OUT_OF_RANGE,
                "CINT: value: $value overflows an int32"
            )
        }
        symbolTable[instruction.result]!!.value!!.int32 = entry.roundedInt32
    }

    @JvmStatic
    fun clng(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val entry = symbolTable[instruction.op1]!!.value
        val value = entry!!.float64
        if (value < Long.MIN_VALUE || value > Long.MAX_VALUE) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.DATA_OUT_OF_RANGE,
                "CLONG: value: $value overflows an int64"
            )
        }
        symbolTable[instruction.result]!!.value!!.int64 = entry.roundedInt64
    }

    @JvmStatic
    fun csng(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        symbolTable[instruction.result]!!.value!!.float32 =
            symbolTable[instruction.op1]!!.value!!.float32
    }

    @JvmStatic
    fun cdbl(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        symbolTable[instruction.result]!!.value!!.float64 =
            symbolTable[instruction.op1]!!.value!!.float64
    }

    @JvmStatic
    fun chrdlr(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val intValue = symbolTable[instruction.op1]!!.value!!.int32
        val charValue = intValue.toChar()
        symbolTable[instruction.result]!!.value!!.string = charValue.toString()
    }

    @JvmStatic
    fun mkidlr(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val value = symbolTable[instruction.op1]!!.value!!.int32
        val str =
            String(ByteBuffer.allocate(4).putInt(value).array(), StandardCharsets.ISO_8859_1)
        symbolTable[instruction.result]!!.value!!.string = str
    }

    @JvmStatic
    fun mkldlr(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val value = symbolTable[instruction.op1]!!.value!!.int64
        val str = String(
            ByteBuffer.allocate(8).putLong(value).array(),
            StandardCharsets.ISO_8859_1
        )
        symbolTable[instruction.result]!!.value!!.string = str
    }

    @JvmStatic
    fun mksdlr(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val value = symbolTable[instruction.op1]!!.value!!.float32
        val str = String(
            ByteBuffer.allocate(4).putFloat(value).array(),
            StandardCharsets.ISO_8859_1
        )
        symbolTable[instruction.result]!!.value!!.string = str
    }

    @JvmStatic
    fun mkddlr(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val value = symbolTable[instruction.op1]!!.value!!.float64
        val str = String(
            ByteBuffer.allocate(8).putDouble(value).array(),
            StandardCharsets.ISO_8859_1
        )
        symbolTable[instruction.result]!!.value!!.string = str
    }

    @JvmStatic
    fun cvi(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val value = symbolTable[instruction.op1]!!.value!!.string
        if (value!!.length != 4) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.DATA_OUT_OF_RANGE,
                "CVI$: value: " + value + " length must be 4, found: " + value.length
            )
        }
        val intValue = ByteBuffer.wrap(value.toByteArray(StandardCharsets.ISO_8859_1), 0, 4).int
        symbolTable[instruction.result]!!.value!!.int32 = intValue
    }

    @JvmStatic
    fun cvl(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val value = symbolTable[instruction.op1]!!.value!!.string
        if (value!!.length != 8) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.DATA_OUT_OF_RANGE,
                "CVL$: value: " + value + " length must be 8, found: " + value.length
            )
        }
        val longValue = ByteBuffer.wrap(value.toByteArray(StandardCharsets.ISO_8859_1), 0, 8).long
        symbolTable[instruction.result]!!.value!!.int64 = longValue
    }

    @JvmStatic
    fun cvs(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val value = symbolTable[instruction.op1]!!.value!!.string
        if (value!!.length != 4) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.DATA_OUT_OF_RANGE,
                "CVS$: value: " + value + " length must be 4, found: " + value.length
            )
        }
        val floatValue = ByteBuffer.wrap(value.toByteArray(StandardCharsets.ISO_8859_1), 0, 4).float
        symbolTable[instruction.result]!!.value!!.float32 = floatValue
    }

    @JvmStatic
    fun cvd(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val value = symbolTable[instruction.op1]!!.value!!.string
        if (value!!.length != 8) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.DATA_OUT_OF_RANGE,
                "CVD$: value: " + value + " length must be 8, found: " + value.length
            )
        }
        val doubleValue =
            ByteBuffer.wrap(value.toByteArray(StandardCharsets.ISO_8859_1), 0, 8).double
        symbolTable[instruction.result]!!.value!!.float64 = doubleValue
    }

    @JvmStatic
    fun spacedlr(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val len = symbolTable[instruction.op1]!!.value!!.int32
        val bytes = ByteArray(len)
        for (i in 0 until len) {
            bytes[i] = ' '.code.toByte()
        }
        val str = String(bytes)
        symbolTable[instruction.result]!!.value!!.string = str
    }

    @JvmStatic
    fun ltrimdlr(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val s = symbolTable[instruction.op1]!!.value!!.string
        var i = 0
        while (i < s!!.length && Character.isWhitespace(s[i])) {
            i++
        }
        val ltrim = s.substring(i)
        symbolTable[instruction.result]!!.value!!.string = ltrim
    }

    @JvmStatic
    fun rtrimdlr(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val s = symbolTable[instruction.op1]!!.value!!.string
        var i = s!!.length - 1
        while (i >= 0 && Character.isWhitespace(s[i])) {
            i--
        }
        val rtrim = s.substring(0, i + 1)
        symbolTable[instruction.result]!!.value!!.string = rtrim
    }

    @JvmStatic
    fun `val`(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val str = symbolTable[instruction.op1]!!.value!!.string
        val result = symbolTable[instruction.result]!!.value
        try {
            result!!.float64 = str!!.toDouble()
        } catch (e: NumberFormatException) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.DATA_OUT_OF_RANGE,
                "Failed to parse string: $str as numeric"
            )
        }
    }

    @JvmStatic
    fun fnint(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val vEntry = symbolTable[instruction.op1]
        val v = vEntry!!.value
        val result = symbolTable[instruction.result]!!.value
        when (vEntry.type!!.atomTypeId) {
            PuffinBasicAtomTypeId.INT32 -> result!!.int32 = v!!.int32
            PuffinBasicAtomTypeId.INT64 -> result!!.int64 = v!!.int64
            PuffinBasicAtomTypeId.FLOAT -> result!!.float32 =
                kotlin.math.floor(v!!.float32.toDouble()).toFloat()

            PuffinBasicAtomTypeId.DOUBLE -> result!!.float64 = kotlin.math.floor(v!!.float64)
            else -> throwUnsupportedType(vEntry.type!!.atomTypeId)
        }
    }

    @JvmStatic
    fun fix(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val vEntry = symbolTable[instruction.op1]
        val v = vEntry!!.value
        val result = symbolTable[instruction.result]!!.value
        when (vEntry.type!!.atomTypeId) {
            PuffinBasicAtomTypeId.INT32 -> result!!.int32 = v!!.int32
            PuffinBasicAtomTypeId.INT64 -> result!!.int64 = v!!.int64
            PuffinBasicAtomTypeId.FLOAT -> result!!.float32 =
                (if (v!!.float32 < 0) kotlin.math.ceil(
                    v.float32.toDouble()
                ) else kotlin.math.floor(v.float32.toDouble())).toFloat()

            PuffinBasicAtomTypeId.DOUBLE -> result!!.float64 =
                if (v!!.float64 < 0) kotlin.math.ceil(
                    v.float64
                ) else kotlin.math.floor(v.float64)

            else -> throwUnsupportedType(vEntry.type!!.atomTypeId)
        }
    }

    @JvmStatic
    fun len(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val stEntry = symbolTable[instruction.op1]
        val value = stEntry!!.value
        val len: Int = if (stEntry.type!!.typeId === PuffinBasicTypeId.ARRAY) {
            val axis =
                if (instruction.op2 != PuffinBasicSymbolTable.NULL_ID) symbolTable[instruction.op2]!!.value!!.int32 else 0
            if (axis < 0 || axis >= value!!.numArrayDimensions) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM,
                    "Bad axis=" + axis + ", #dims=" + value!!.numArrayDimensions
                )
            }
            value.arrayDimensions!![axis]
        } else if (stEntry.value!!.hasLen()) {
            value!!.len()
        } else {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM,
                "Bad LEN() call!"
            )
        }
        symbolTable[instruction.result]!!.value!!.int32 = len
    }

    @JvmStatic
    fun strdlr(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val numericEntry = symbolTable[instruction.op1]
        val numeric = numericEntry!!.value
        val dt = numericEntry.type!!.atomTypeId
        val str: String = if (dt === PuffinBasicAtomTypeId.INT32) {
            numeric!!.int32.toString()
        } else if (dt === PuffinBasicAtomTypeId.INT64) {
            numeric!!.int64.toString()
        } else if (dt === PuffinBasicAtomTypeId.FLOAT) {
            numeric!!.float32.toString()
        } else {
            numeric!!.float64.toString()
        }
        symbolTable[instruction.result]!!.value!!.string = str
    }

    @JvmStatic
    fun hexdlr(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val numericEntry = symbolTable[instruction.op1]
        val numeric = numericEntry!!.value
        val dt = numericEntry.type!!.atomTypeId
        val str: String = if (dt === PuffinBasicAtomTypeId.INT32) {
            Integer.toHexString(numeric!!.int32)
        } else if (dt === PuffinBasicAtomTypeId.INT64) {
            java.lang.Long.toHexString(numeric!!.int64)
        } else if (dt === PuffinBasicAtomTypeId.FLOAT) {
            java.lang.Float.toHexString(numeric!!.float32)
        } else {
            java.lang.Double.toHexString(numeric!!.float64)
        }
        symbolTable[instruction.result]!!.value!!.string = str
    }

    @JvmStatic
    fun octdlr(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val numericEntry = symbolTable[instruction.op1]
        val numeric = numericEntry!!.value
        val dt = numericEntry.type!!.atomTypeId
        val str: String =
            if (dt === PuffinBasicAtomTypeId.INT32 || dt === PuffinBasicAtomTypeId.FLOAT) {
                Integer.toOctalString(numeric!!.int32)
            } else {
                java.lang.Long.toOctalString(numeric!!.int64)
            }
        symbolTable[instruction.result]!!.value!!.string = str
    }

    @JvmStatic
    fun leftdlr(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val x = symbolTable[instruction.op1]!!.value!!.string
        val n = symbolTable[instruction.op2]!!.value!!.int32
        val result: String = if (n < 0) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.INDEX_OUT_OF_BOUNDS,
                "LEFT$: expected n >= 0, actual=$n"
            )
        } else if (n == 0) {
            ""
        } else if (n >= x!!.length) {
            x
        } else {
            x.substring(0, n)
        }
        symbolTable[instruction.result]!!.value!!.string = result
    }

    @JvmStatic
    fun rightdlr(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val x = symbolTable[instruction.op1]!!.value!!.string
        val n = symbolTable[instruction.op2]!!.value!!.int32
        val xlen = x!!.length
        val result: String = if (n < 0) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.INDEX_OUT_OF_BOUNDS,
                "RIGHT$: expected n >= 0, actual=$n"
            )
        } else if (n == 0) {
            ""
        } else if (n >= xlen) {
            x
        } else {
            x.substring(xlen - n, xlen)
        }
        symbolTable[instruction.result]!!.value!!.string = result
    }

    @JvmStatic
    fun instr(
        symbolTable: PuffinBasicSymbolTable,
        instr0: PuffinBasicIR.Instruction,
        instr: PuffinBasicIR.Instruction
    ) {
        val x = symbolTable[instr0.op1]!!.value!!.string
        val y = symbolTable[instr0.op2]!!.value!!.string
        val n = symbolTable[instr.op1]!!.value!!.int32
        val xlen = x!!.length
        val ylen = y!!.length
        val result: Int = if (n <= 0) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.INDEX_OUT_OF_BOUNDS,
                "INSTR: expected n > 0, actual=$n"
            )
        } else if (n > xlen) {
            0
        } else if (ylen == 0) {
            n
        } else {
            x.indexOf(y, n - 1) + 1
        }
        symbolTable[instr.result]!!.value!!.int32 = result
    }

    @JvmStatic
    fun middlr(
        symbolTable: PuffinBasicSymbolTable,
        instr0: PuffinBasicIR.Instruction,
        instr: PuffinBasicIR.Instruction
    ) {
        val x = symbolTable[instr0.op1]!!.value!!.string
        val n = symbolTable[instr0.op2]!!.value!!.int32
        val m = symbolTable[instr.op1]!!.value!!.int32
        val xlen = x!!.length
        val result: String = if (n <= 0) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.INDEX_OUT_OF_BOUNDS,
                "INSTR: expected n > 0, actual=$n"
            )
        } else if (n > xlen || m == 0) {
            ""
        } else {
            x.substring(n - 1, kotlin.math.min(xlen, n + m - 1))
        }
        symbolTable[instr.result]!!.value!!.string = result
    }

    @JvmStatic
    fun rnd(
        random: Random,
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        symbolTable[instruction.result]!!.value!!.float64 = random.nextDouble()
    }

    @JvmStatic
    fun sgn(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val entry = symbolTable[instruction.op1]
        val numeric = entry!!.value
        val dt = entry.type!!.atomTypeId
        var result: Int
        result = if (dt === PuffinBasicAtomTypeId.INT32) {
            numeric!!.int32.compareTo(0)
        } else if (dt === PuffinBasicAtomTypeId.INT64) {
            numeric!!.int64.compareTo(0)
        } else if (dt === PuffinBasicAtomTypeId.FLOAT) {
            numeric!!.float32.compareTo(0f)
        } else {
            numeric!!.float64.compareTo(0.0)
        }
        if (result < 0) {
            result = -1
        } else if (result > 0) {
            result = 1
        }
        symbolTable[instruction.result]!!.value!!.int32 = result
    }

    @JvmStatic
    fun timer(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val nowZoned = ZonedDateTime.now()
        val midnight = nowZoned.toLocalDate().atStartOfDay(nowZoned.zone).toInstant()
        val duration = Duration.between(midnight, Instant.now())
        val seconds = duration.seconds + duration.nano / 1000000000.0
        symbolTable[instruction.result]!!.value!!.float64 = seconds
    }

    @JvmStatic
    fun timerMillis(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val nowZoned = ZonedDateTime.now()
        val midnight = nowZoned.toLocalDate().atStartOfDay(nowZoned.zone).toInstant()
        val duration = Duration.between(midnight, Instant.now())
        val millis =
            TimeUnit.SECONDS.toMillis(duration.seconds) + TimeUnit.NANOSECONDS.toMillis(duration.nano.toLong())
        symbolTable[instruction.result]!!.value!!.int64 = millis
    }

    @JvmStatic
    fun stringdlr(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val n = symbolTable[instruction.op1]!!.value!!.int32
        val jOrxdlrEntry = symbolTable[instruction.op2]
        val jOrxdlr = jOrxdlrEntry!!.value
        val c: String = if (jOrxdlrEntry.type!!.atomTypeId === PuffinBasicAtomTypeId.STRING) {
            if (jOrxdlr!!.string!!.isEmpty()) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM,
                    "STRING$: expected len(x%) > 0, actual=0"
                )
            }
            jOrxdlr.string!!.substring(0, 1)
        } else {
            val j = jOrxdlr!!.int32
            if (j < 0 || j > 255) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM,
                    "STRING$: expected 0 <= j <= 255, actual=$j"
                )
            }
            jOrxdlr.int32.toChar().toString()
        }
        val result: String = if (n < 0) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.INDEX_OUT_OF_BOUNDS,
                "STRING$: expected n >= 0, actual=$n"
            )
        } else if (n == 0) {
            ""
        } else {
            Strings.repeat(c, n)
        }
        symbolTable[instruction.result]!!.value!!.string = result
    }

    @JvmStatic
    fun loc(
        files: PuffinBasicFiles,
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val fileNumber = symbolTable[instruction.op1]!!.value!!.int32
        val loc = files[fileNumber].currentRecordNumber
        symbolTable[instruction.result]!!.value!!.int32 = loc
    }

    @JvmStatic
    fun lof(
        files: PuffinBasicFiles,
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val fileNumber = symbolTable[instruction.op1]!!.value!!.int32
        val lof = files[fileNumber].fileSizeInBytes
        symbolTable[instruction.result]!!.value!!.int64 = lof
    }

    @JvmStatic
    fun eof(
        files: PuffinBasicFiles,
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val fileNumber = symbolTable[instruction.op1]!!.value!!.int32
        val eof = files[fileNumber].eof()
        symbolTable[instruction.result]!!.value!!.int32 = if (eof) -1 else 0
    }

    @JvmStatic
    fun inputdlr(
        files: PuffinBasicFiles,
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val x = symbolTable[instruction.op1]!!.value!!.int32
        val fileNumber = symbolTable[instruction.op2]!!.value!!.int32
        val read: ByteArray = if (fileNumber < 0) {
            files.sys.readBytes(x)!!
        } else {
            throw UnsupportedOperationException()
        }
        symbolTable[instruction.result]!!.value!!.string = String(read)
    }

    @JvmStatic
    fun environdlr(
        env: Environment,
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val envvar = symbolTable[instruction.op1]!!.value!!.string
        val result = env[envvar!!]
        symbolTable[instruction.result]!!.value!!.string = result
    }

    @JvmStatic
    fun splitdlr(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val str = symbolTable[instruction.op1]!!.value!!.string
        val regex = symbolTable[instruction.op2]!!.value!!.string
        val tokens = str!!.split(regex!!.toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray() as Array<Any>
        PuffinBasicAtomTypeId.STRING.copyArray(tokens, symbolTable[instruction.result]!!.value!!)
    }

    fun throwUnsupportedType(type: PuffinBasicAtomTypeId) {
        throw PuffinBasicInternalError(
            "Data type $type is not supported"
        )
    }
}