package org.puffinbasic.runtime

import org.puffinbasic.domain.PuffinBasicSymbolTable
import org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId
import org.puffinbasic.error.PuffinBasicInternalError
import org.puffinbasic.error.PuffinBasicRuntimeError
import org.puffinbasic.parser.PuffinBasicIR
import kotlin.math.pow

internal object Operators {
    @JvmStatic
    fun unaryMinus(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val op1Entry = symbolTable[instruction.op1]
        val op1 = op1Entry!!.value
        val result = symbolTable[instruction.result]!!.value
        when (op1Entry.type!!.atomTypeId) {
            PuffinBasicAtomTypeId.INT32 -> result!!.int32 = -op1!!.int32
            PuffinBasicAtomTypeId.INT64 -> result!!.int64 = -op1!!.int64
            PuffinBasicAtomTypeId.FLOAT -> result!!.float32 = -op1!!.float32
            PuffinBasicAtomTypeId.DOUBLE -> result!!.float64 = -op1!!.float64
            else -> throw PuffinBasicInternalError(
                "Unary minus is not supported for data type: " + op1Entry.type!!.atomTypeId
            )
        }
    }

    @JvmStatic
    fun concat(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value!!.string
        val v2 = symbolTable[instruction.op2]!!.value!!.string
        val result = symbolTable[instruction.result]!!.value
        result!!.string = v1 + v2
    }

    @JvmStatic
    fun leftShift(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1Entry = symbolTable[instruction.op1]
        val v1 = v1Entry!!.value
        val v2Entry = symbolTable[instruction.op2]
        val v2 = v2Entry!!.value
        val result = symbolTable[instruction.result]!!.value
        if (v1Entry.type!!.atomTypeId === PuffinBasicAtomTypeId.INT32 && v2Entry.type!!.atomTypeId === PuffinBasicAtomTypeId.INT32) {
            result!!.int32 = v1!!.roundedInt32 shl v2!!.roundedInt32
        } else {
            result!!.int64 = v1!!.roundedInt64 shl v2!!.roundedInt64.toInt()
        }
    }

    @JvmStatic
    fun rightShift(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1Entry = symbolTable[instruction.op1]
        val v1 = v1Entry!!.value
        val v2Entry = symbolTable[instruction.op2]
        val v2 = v2Entry!!.value
        val result = symbolTable[instruction.result]!!.value
        if (v1Entry.type!!.atomTypeId === PuffinBasicAtomTypeId.INT32 && v2Entry.type!!.atomTypeId === PuffinBasicAtomTypeId.INT32) {
            result!!.int32 = v1!!.roundedInt32 shr v2!!.roundedInt32
        } else {
            result!!.int64 = v1!!.roundedInt64 shr v2!!.roundedInt64.toInt()
        }
    }

    @JvmStatic
    fun mod(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1Entry = symbolTable[instruction.op1]
        val v1 = v1Entry!!.value
        val v2Entry = symbolTable[instruction.op2]
        val v2 = v2Entry!!.value
        val result = symbolTable[instruction.result]!!.value
        if (v1Entry.type!!.atomTypeId === PuffinBasicAtomTypeId.INT32 && v2Entry.type!!.atomTypeId === PuffinBasicAtomTypeId.INT32) {
            result!!.int32 = v1!!.roundedInt32 % v2!!.roundedInt32
        } else {
            result!!.int64 = v1!!.roundedInt64 % v2!!.roundedInt64
        }
    }

    @JvmStatic
    fun idiv(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1Entry = symbolTable[instruction.op1]
        val v1 = v1Entry!!.value
        val v2Entry = symbolTable[instruction.op2]
        val v2 = v2Entry!!.value
        val result = symbolTable[instruction.result]!!.value
        if (v1Entry.type!!.atomTypeId === PuffinBasicAtomTypeId.INT32 && v2Entry.type!!.atomTypeId === PuffinBasicAtomTypeId.INT32) {
            if (v2!!.roundedInt32 == 0) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.DIVISION_BY_ZERO,
                    "Division by zero"
                )
            }
            result!!.int32 = v1!!.roundedInt32 / v2.roundedInt32
        } else {
            if (v2!!.roundedInt64 == 0L) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.DIVISION_BY_ZERO,
                    "Division by zero"
                )
            }
            result!!.int64 = v1!!.roundedInt64 / v2.roundedInt64
        }
    }

    @JvmStatic
    fun addInt32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int32 = v1!!.int32 + v2!!.int32
    }

    @JvmStatic
    fun addInt64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = v1!!.int64 + v2!!.int64
    }

    @JvmStatic
    fun addFloat32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.float32 = v1!!.float32 + v2!!.float32
    }

    @JvmStatic
    fun addFloat64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.float64 = v1!!.float64 + v2!!.float64
    }

    @JvmStatic
    fun subInt32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int32 = v1!!.int32 - v2!!.int32
    }

    @JvmStatic
    fun subInt64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = v1!!.int64 - v2!!.int64
    }

    @JvmStatic
    fun subFloat32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.float32 = v1!!.float32 - v2!!.float32
    }

    @JvmStatic
    fun subFloat64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.float64 = v1!!.float64 - v2!!.float64
    }

    @JvmStatic
    fun mulInt32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int32 = v1!!.int32 * v2!!.int32
    }

    @JvmStatic
    fun mulInt64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = v1!!.int64 * v2!!.int64
    }

    @JvmStatic
    fun mulFloat32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.float32 = v1!!.float32 * v2!!.float32
    }

    @JvmStatic
    fun mulFloat64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.float64 = v1!!.float64 * v2!!.float64
    }

    @JvmStatic
    fun fdiv(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        if (v2!!.float64 == 0.0) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.DIVISION_BY_ZERO,
                "Division by zero"
            )
        }
        result!!.float64 = v1!!.float64 / v2.float64
    }

    @JvmStatic
    fun expInt32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int32 = v1!!.int32.toDouble().pow(v2!!.int32.toDouble()).toInt()
    }

    @JvmStatic
    fun expInt64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = v1!!.int64.toDouble().pow(v2!!.int64.toDouble()).toLong()
    }

    @JvmStatic
    fun expFloat32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.float32 = v1!!.float32.toDouble().pow(v2!!.float32.toDouble()).toFloat()
    }

    @JvmStatic
    fun expFloat64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v1 = symbolTable[instruction.op1]!!.value
        val v2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.float64 = v1!!.float64.pow(v2!!.float64)
    }

    @JvmStatic
    fun and(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val v1 = symbolTable[instruction.op1]!!.value!!.int64
        val v2 = symbolTable[instruction.op2]!!.value!!.int64
        val result = symbolTable[instruction.result]!!.value
        if ((v1 == -1L || v1 == 0L) && (v2 == -1L || v2 == 0L)) {
            val b1 = v1 == -1L
            val b2 = v2 == -1L
            result!!.int64 = if (b1 && b2) -1 else 0
        } else {
            result!!.int64 = v1 and v2
        }
    }

    @JvmStatic
    fun or(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val v1 = symbolTable[instruction.op1]!!.value!!.int64
        val v2 = symbolTable[instruction.op2]!!.value!!.int64
        val result = symbolTable[instruction.result]!!.value
        if ((v1 == -1L || v1 == 0L) && (v2 == -1L || v2 == 0L)) {
            val b1 = v1 == -1L
            val b2 = v2 == -1L
            result!!.int64 = if (b1 || b2) -1 else 0
        } else {
            result!!.int64 = v1 or v2
        }
    }

    @JvmStatic
    fun xor(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val v1 = symbolTable[instruction.op1]!!.value!!.int64
        val v2 = symbolTable[instruction.op2]!!.value!!.int64
        val result = symbolTable[instruction.result]!!.value
        if ((v1 == -1L || v1 == 0L) && (v2 == -1L || v2 == 0L)) {
            val b1 = v1 == -1L
            val b2 = v2 == -1L
            result!!.int64 = if (b1 xor b2) -1 else 0
        } else {
            result!!.int64 = v1 xor v2
        }
    }

    @JvmStatic
    fun eqv(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val v1 = symbolTable[instruction.op1]!!.value!!.int64
        val v2 = symbolTable[instruction.op2]!!.value!!.int64
        val result = symbolTable[instruction.result]!!.value
        if ((v1 == -1L || v1 == 0L) && (v2 == -1L || v2 == 0L)) {
            val b1 = v1 == -1L
            val b2 = v2 == -1L
            result!!.int64 = if (b1 == b2) -1 else 0
        } else {
            result!!.int64 = (v1 xor v2).inv()
        }
    }

    @JvmStatic
    fun imp(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val v1 = symbolTable[instruction.op1]!!.value!!.int64
        val v2 = symbolTable[instruction.op2]!!.value!!.int64
        val result = symbolTable[instruction.result]!!.value
        if ((v1 == -1L || v1 == 0L) && (v2 == -1L || v2 == 0L)) {
            val b1 = v1 == -1L
            val b2 = v2 == -1L
            result!!.int64 = if (!b1 || b2) -1 else 0
        } else {
            result!!.int64 = v1.inv() or v2
        }
    }

    @JvmStatic
    fun ltInt32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.int32 < e2!!.int32) -1 else 0
    }

    @JvmStatic
    fun ltInt64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.int64 < e2!!.int64) -1 else 0
    }

    @JvmStatic
    fun ltFloat32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.float32.compareTo(e2!!.float32) < 0) -1 else 0
    }

    @JvmStatic
    fun ltFloat64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.float64.compareTo(e2!!.float64) < 0) -1 else 0
    }

    @JvmStatic
    fun ltStr(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.string!! < e2!!.string!!) -1 else 0
    }

    @JvmStatic
    fun leInt32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.int32 <= e2!!.int32) -1 else 0
    }

    @JvmStatic
    fun leInt64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.int64 <= e2!!.int64) -1 else 0
    }

    @JvmStatic
    fun leFloat32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.float32.compareTo(e2!!.float32) <= 0) -1 else 0
    }

    @JvmStatic
    fun leFloat64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.float64.compareTo(e2!!.float64) <= 0) -1 else 0
    }

    @JvmStatic
    fun leStr(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.string!! <= e2!!.string!!) -1 else 0
    }

    @JvmStatic
    fun gtInt32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.int32 > e2!!.int32) -1 else 0
    }

    @JvmStatic
    fun gtInt64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        val longResult: Long = (if (e1!!.int64 > e2!!.int64) -1 else 0).toLong()
        result!!.int64 = longResult
    }

    @JvmStatic
    fun gtFloat32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.float32.compareTo(e2!!.float32) > 0) -1 else 0
    }

    @JvmStatic
    fun gtFloat64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.float64.compareTo(e2!!.float64) > 0) -1 else 0
    }

    @JvmStatic
    fun gtStr(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.string!! > e2!!.string!!) -1 else 0
    }

    @JvmStatic
    fun geInt32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.int32 >= e2!!.int32) -1 else 0
    }

    @JvmStatic
    fun geInt64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.int64 >= e2!!.int64) -1 else 0
    }

    @JvmStatic
    fun geFloat32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.float32.compareTo(e2!!.float32) >= 0) -1 else 0
    }

    @JvmStatic
    fun geFloat64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.float64.compareTo(e2!!.float64) >= 0) -1 else 0
    }

    @JvmStatic
    fun geStr(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.string!! >= e2!!.string!!) -1 else 0
    }

    @JvmStatic
    fun eqInt32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.int32 == e2!!.int32) -1 else 0
    }

    @JvmStatic
    fun eqInt64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.int64 == e2!!.int64) -1 else 0
    }

    @JvmStatic
    fun eqFloat32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.float32.compareTo(e2!!.float32) == 0) -1 else 0
    }

    @JvmStatic
    fun eqFloat64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.float64.compareTo(e2!!.float64) == 0) -1 else 0
    }

    @JvmStatic
    fun eqStr(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.string == e2!!.string) -1 else 0
    }

    @JvmStatic
    fun neInt32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.int32 != e2!!.int32) -1 else 0
    }

    @JvmStatic
    fun neInt64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.int64 != e2!!.int64) -1 else 0
    }

    @JvmStatic
    fun neFloat32(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.float32.compareTo(e2!!.float32) != 0) -1 else 0
    }

    @JvmStatic
    fun neFloat64(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.float64.compareTo(e2!!.float64) != 0) -1 else 0
    }

    @JvmStatic
    fun neStr(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val e1 = symbolTable[instruction.op1]!!.value
        val e2 = symbolTable[instruction.op2]!!.value
        val result = symbolTable[instruction.result]!!.value
        result!!.int64 = if (e1!!.string != e2!!.string) -1 else 0
    }

    @JvmStatic
    fun unaryNot(
        symbolTable: PuffinBasicSymbolTable,
        instruction: PuffinBasicIR.Instruction
    ) {
        val v = symbolTable[instruction.op1]!!.value!!.int64
        val result = symbolTable[instruction.result]!!.value
        when (v) {
            -1L -> {
                result!!.int64 = 0
            }

            0L -> {
                result!!.int64 = -1
            }

            else -> {
                result!!.int64 = v.inv()
            }
        }
    }
}