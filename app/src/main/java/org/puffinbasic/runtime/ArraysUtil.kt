package org.puffinbasic.runtime

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics
import org.apache.commons.math3.stat.descriptive.SummaryStatistics
import org.puffinbasic.domain.PuffinBasicSymbolTable
import org.puffinbasic.domain.STObjects
import org.puffinbasic.domain.STObjects.AbstractSTEntry
import org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId
import org.puffinbasic.domain.STObjects.STEntry
import org.puffinbasic.domain.STObjects.STFloat32ArrayValue
import org.puffinbasic.domain.STObjects.STFloat64ArrayValue
import org.puffinbasic.domain.STObjects.STInt32ArrayValue
import org.puffinbasic.domain.STObjects.STInt64ArrayValue
import org.puffinbasic.domain.STObjects.STStringArrayValue
import org.puffinbasic.error.PuffinBasicRuntimeError
import org.puffinbasic.parser.PuffinBasicIR
import java.util.Arrays
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

internal class ArraysUtil {
    private fun findRowWithValue(
        array: DoubleArray,
        w: Int,
        x1: Int,
        y1: Int,
        x2: Int,
        y2: Int,
        search: Int
    ): Int {
        if (y1 <= y2) {
            for (r in y1..y2) {
                for (c in x1..x2) {
                    val v = array[r * w + c]
                    if (v == search.toDouble()) {
                        return r
                    }
                }
            }
        } else {
            for (r in y1 downTo y2) {
                for (c in x1..x2) {
                    val v = array[r * w + c]
                    if (v == search.toDouble()) {
                        return r
                    }
                }
            }
        }
        return -1
    }

    internal class ArrayState {
        private var dimIndex = 0
        val andIncrement: Int
            get() = dimIndex++

        fun reset() {
            dimIndex = 0
        }
    }

    companion object {
        @JvmStatic
        fun dim(
            symbolTable: PuffinBasicSymbolTable,
            params: List<PuffinBasicIR.Instruction>,
            instruction: PuffinBasicIR.Instruction
        ) {
            val dims = params.map { param ->
                symbolTable[param.op1]!!.value!!.int32
            }
            symbolTable[instruction.op1]!!.value!!.arrayDimensions = dims
        }

        @JvmStatic
        fun resetIndex(
            state: ArrayState,
            symbolTable: PuffinBasicSymbolTable,
            instruction: PuffinBasicIR.Instruction
        ) {
            state.reset()
            symbolTable[instruction.op1]!!.value!!.resetArrayIndex()
        }

        @JvmStatic
        fun allocArray(
            symbolTable: PuffinBasicSymbolTable,
            params: List<PuffinBasicIR.Instruction>,
            instruction: PuffinBasicIR.Instruction
        ) {
            val dims = params.map { param ->
                symbolTable[param.op1]!!.value!!.int32
            }
            val arrayEntry = symbolTable[instruction.result]
            val arrayType = arrayEntry!!.type as STObjects.ArrayType?
            arrayType!!.setArrayDimensions(dims)
            arrayEntry.value!!.arrayDimensions = dims
        }

        @JvmStatic
        fun reallocArray(
            symbolTable: PuffinBasicSymbolTable,
            params: List<PuffinBasicIR.Instruction>,
            instruction: PuffinBasicIR.Instruction
        ) {
            val dims = params.map { param ->
                symbolTable[param.op1]!!.value!!.int32
            }
            val arrayEntry = symbolTable[instruction.op1]
            val arrayType = arrayEntry!!.type as STObjects.ArrayType?
            arrayType!!.setArrayDimensions(dims)
            // Create new value
            (arrayEntry as AbstractSTEntry?)!!.createAndSetInstance(symbolTable)
        }

        @JvmStatic
        fun setIndex(
            state: ArrayState,
            symbolTable: PuffinBasicSymbolTable,
            instruction: PuffinBasicIR.Instruction
        ) {
            val index = symbolTable[instruction.op2]!!.value!!.int32
            symbolTable[instruction.op1]!!.value!!.setArrayIndex(state.andIncrement, index)
        }

        @JvmStatic
        fun arrayref(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
            val index = symbolTable[instruction.op1]!!.value!!.arrayIndex1D
            symbolTable[instruction.result]!!.value!!.setArrayReferenceIndex1D(index)
        }

        @JvmStatic
        fun arrayfill(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
            val array = symbolTable[instruction.op1]!!.value
            val fillEntry = symbolTable[instruction.op2]
            val fill = fillEntry!!.value
            when (fillEntry.type!!.atomTypeId) {
                PuffinBasicAtomTypeId.INT32 -> array!!.fill(fill!!.int32)
                PuffinBasicAtomTypeId.INT64 -> array!!.fill(fill!!.int64)
                PuffinBasicAtomTypeId.FLOAT -> array!!.fill(fill!!.float32)
                PuffinBasicAtomTypeId.DOUBLE -> array!!.fill(fill!!.float64)
                PuffinBasicAtomTypeId.STRING -> array!!.fillString(fill!!.string)
                else -> Functions.throwUnsupportedType(fillEntry.type!!.atomTypeId)
            }
        }

        @JvmStatic
        fun arrayCopy(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
            val array1Entry = symbolTable[instruction.op1]
            val array1 = array1Entry!!.value
            val array2Entry = symbolTable[instruction.op2]
            val array2 = array2Entry!!.value
            if (array1Entry.type!!.atomTypeId !== array2Entry.type!!.atomTypeId) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.DATA_TYPE_MISMATCH,
                    "Array data type mismatch: " + array1Entry.type!!.atomTypeId
                            + " is not compatible with " + array2Entry.type!!.atomTypeId
                )
            }
            if (array1!!.totalLength != array2!!.totalLength) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM,
                    "Array length mismatch: " + array1.totalLength
                            + " is not compatible with " + array2.totalLength
                )
            }
            when (array1Entry.type!!.atomTypeId) {
                PuffinBasicAtomTypeId.INT32 -> {
                    val value: IntArray = (array1 as STInt32ArrayValue?)!!.value
                    System.arraycopy(
                        value,
                        0,
                        (array2 as STInt32ArrayValue?)!!.value,
                        0,
                        value.size
                    )
                }

                PuffinBasicAtomTypeId.INT64 -> {
                    val value: LongArray = (array1 as STInt64ArrayValue?)!!.value
                    System.arraycopy(
                        value, 0, (array2 as STInt64ArrayValue?)!!.value, 0, value.size
                    )
                }

                PuffinBasicAtomTypeId.FLOAT -> {
                    val value: FloatArray = (array1 as STFloat32ArrayValue?)!!.value
                    System.arraycopy(
                        value, 0, (array2 as STFloat32ArrayValue?)!!.value, 0, value.size
                    )
                }

                PuffinBasicAtomTypeId.DOUBLE -> {
                    val value: DoubleArray = (array1 as STFloat64ArrayValue?)!!.value
                    System.arraycopy(
                        value, 0, (array2 as STFloat64ArrayValue?)!!.value, 0, value.size
                    )
                }

                PuffinBasicAtomTypeId.STRING -> {
                    val value = (array1 as STStringArrayValue?)!!.value
                    System.arraycopy(
                        value, 0, (array2 as STStringArrayValue?)!!.value, 0, value.size
                    )
                }

                else -> Functions.throwUnsupportedType(array1Entry.type!!.atomTypeId)
            }
        }

        @JvmStatic
        fun array2dShiftVertical(
            symbolTable: PuffinBasicSymbolTable,
            instruction: PuffinBasicIR.Instruction
        ) {
            val arrayEntry = symbolTable[instruction.op1]
            val array = arrayEntry!!.value
            val shift = symbolTable[instruction.op2]!!.value!!.int32
            val dims = array!!.arrayDimensions!!
            // Arrays are row-major.
            val dim1 = dims[0]
            val dim2 = dims[1]
            val n = array.totalLength
            val delta: Int = abs(shift) % dim1 * dim2
            val src0: Int
            val dst0: Int
            val len = n - delta
            val fillSrc0: Int
            if (shift > 0) {
                src0 = 0
                dst0 = delta
                fillSrc0 = 0
            } else {
                src0 = delta
                dst0 = 0
                fillSrc0 = n - delta
            }
            when (arrayEntry.type!!.atomTypeId) {
                PuffinBasicAtomTypeId.INT32 -> {
                    val value: IntArray = (array as STInt32ArrayValue?)!!.value
                    System.arraycopy(value, src0, value, dst0, len)
                    Arrays.fill(value, fillSrc0, fillSrc0 + delta, 0)
                }

                PuffinBasicAtomTypeId.INT64 -> {
                    val value: LongArray = (array as STInt64ArrayValue?)!!.value
                    System.arraycopy(value, src0, value, dst0, len)
                    Arrays.fill(value, fillSrc0, fillSrc0 + delta, 0)
                }

                PuffinBasicAtomTypeId.FLOAT -> {
                    val value: FloatArray = (array as STFloat32ArrayValue?)!!.value
                    System.arraycopy(value, src0, value, dst0, len)
                    Arrays.fill(value, fillSrc0, fillSrc0 + delta, 0f)
                }

                PuffinBasicAtomTypeId.DOUBLE -> {
                    val value: DoubleArray = (array as STFloat64ArrayValue?)!!.value
                    System.arraycopy(value, src0, value, dst0, len)
                    Arrays.fill(value, fillSrc0, fillSrc0 + delta, 0.0)
                }

                PuffinBasicAtomTypeId.STRING -> {
                    val value = (array as STStringArrayValue?)!!.value
                    System.arraycopy(value, src0, value, dst0, len)
                    Arrays.fill(value, fillSrc0, fillSrc0 + delta, "")
                }

                else -> Functions.throwUnsupportedType(arrayEntry.type!!.atomTypeId)
            }
        }

        @JvmStatic
        fun array2dShiftHorizontal(
            symbolTable: PuffinBasicSymbolTable,
            instruction: PuffinBasicIR.Instruction
        ) {
            val arrayEntry = symbolTable[instruction.op1]
            val array = arrayEntry!!.value
            val shift = symbolTable[instruction.op2]!!.value!!.int32
            val dims = array!!.arrayDimensions!!
            // Arrays are row-major.
            val dim1 = dims[0]
            val dim2 = dims[1]
            val n = array.totalLength
            val delta = abs(shift) % dim2
            val src0: Int
            val dst0: Int
            val len: Int = dim2 - delta
            val fillSrc0: Int
            if (shift > 0) {
                src0 = 0
                dst0 = delta
                fillSrc0 = 0
            } else {
                src0 = delta
                dst0 = 0
                fillSrc0 = dim2 - delta
            }
            when (arrayEntry.type!!.atomTypeId) {
                PuffinBasicAtomTypeId.INT32 -> {
                    val value: IntArray = (array as STInt32ArrayValue?)!!.value
                    if (shift >= 0) {
                        var dc = dst0 + len - 1
                        var sc = src0 + len - 1
                        while (dc >= dst0) {
                            var r = 0
                            while (r < dim1) {
                                val dr: Int = r * dim2
                                value[dr + dc] = value[dr + sc]
                                r++
                            }
                            dc--
                            sc--
                        }
                    } else {
                        var dc = dst0
                        var sc = src0
                        while (dc < dst0 + len) {
                            var r = 0
                            while (r < dim1) {
                                val dr: Int = r * dim2
                                value[dr + dc] = value[dr + sc]
                                r++
                            }
                            dc++
                            sc++
                        }
                    }
                    var c = fillSrc0
                    while (c < fillSrc0 + delta) {
                        var r = 0
                        while (r < dim1) {
                            value[r * dim2 + c] = 0
                            r++
                        }
                        c++
                    }
                }

                PuffinBasicAtomTypeId.INT64 -> {
                    val value: LongArray = (array as STInt64ArrayValue?)!!.value
                    if (shift >= 0) {
                        var dc = dst0 + len - 1
                        var sc = src0 + len - 1
                        while (dc >= dst0) {
                            var r = 0
                            while (r < dim1) {
                                val dr: Int = r * dim2
                                value[dr + dc] = value[dr + sc]
                                r++
                            }
                            dc--
                            sc--
                        }
                    } else {
                        var dc = dst0
                        var sc = src0
                        while (dc < dst0 + len) {
                            var r = 0
                            while (r < dim1) {
                                val dr: Int = r * dim2
                                value[dr + dc] = value[dr + sc]
                                r++
                            }
                            dc++
                            sc++
                        }
                    }
                    var c = fillSrc0
                    while (c < fillSrc0 + delta) {
                        var r = 0
                        while (r < dim1) {
                            value[r * dim2 + c] = 0
                            r++
                        }
                        c++
                    }
                }

                PuffinBasicAtomTypeId.FLOAT -> {
                    val value: FloatArray = (array as STFloat32ArrayValue?)!!.value
                    if (shift >= 0) {
                        var dc = dst0 + len - 1
                        var sc = src0 + len - 1
                        while (dc >= dst0) {
                            var r = 0
                            while (r < dim1) {
                                val dr: Int = r * dim2
                                value[dr + dc] = value[dr + sc]
                                r++
                            }
                            dc--
                            sc--
                        }
                    } else {
                        var dc = dst0
                        var sc = src0
                        while (dc < dst0 + len) {
                            var r = 0
                            while (r < dim1) {
                                val dr: Int = r * dim2
                                value[dr + dc] = value[dr + sc]
                                r++
                            }
                            dc++
                            sc++
                        }
                    }
                    var c = fillSrc0
                    while (c < fillSrc0 + delta) {
                        var r = 0
                        while (r < dim1) {
                            value[r * dim2 + c] = 0f
                            r++
                        }
                        c++
                    }
                }

                PuffinBasicAtomTypeId.DOUBLE -> {
                    val value: DoubleArray = (array as STFloat64ArrayValue?)!!.value
                    if (shift >= 0) {
                        var dc = dst0 + len - 1
                        var sc = src0 + len - 1
                        while (dc >= dst0) {
                            var r = 0
                            while (r < dim1) {
                                val dr: Int = r * dim2
                                value[dr + dc] = value[dr + sc]
                                r++
                            }
                            dc--
                            sc--
                        }
                    } else {
                        var dc = dst0
                        var sc = src0
                        while (dc < dst0 + len) {
                            var r = 0
                            while (r < dim1) {
                                val dr: Int = r * dim2
                                value[dr + dc] = value[dr + sc]
                                r++
                            }
                            dc++
                            sc++
                        }
                    }
                    var c = fillSrc0
                    while (c < fillSrc0 + delta) {
                        var r = 0
                        while (r < dim1) {
                            value[r * dim2 + c] = 0.0
                            r++
                        }
                        c++
                    }
                }

                PuffinBasicAtomTypeId.STRING -> {
                    val value = (array as STStringArrayValue?)!!.value
                    if (shift >= 0) {
                        var dc = dst0 + len - 1
                        var sc = src0 + len - 1
                        while (dc >= dst0) {
                            var r = 0
                            while (r < dim1) {
                                val dr: Int = r * dim2
                                value[dr + dc] = value[dr + sc]
                                r++
                            }
                            dc--
                            sc--
                        }
                    } else {
                        var dc = dst0
                        var sc = src0
                        while (dc < dst0 + len) {
                            var r = 0
                            while (r < dim1) {
                                val dr: Int = r * dim2
                                value[dr + dc] = value[dr + sc]
                                r++
                            }
                            dc++
                            sc++
                        }
                    }
                    var c = fillSrc0
                    while (c < fillSrc0 + delta) {
                        var r = 0
                        while (r < dim1) {
                            value[r * dim2 + c] = ""
                            r++
                        }
                        c++
                    }
                }

                else -> Functions.throwUnsupportedType(arrayEntry.type!!.atomTypeId)
            }
        }

        @JvmStatic
        fun array1DCopy(
            symbolTable: PuffinBasicSymbolTable,
            i0: PuffinBasicIR.Instruction,
            i1: PuffinBasicIR.Instruction,
            instruction: PuffinBasicIR.Instruction
        ) {
            val srcEntry = symbolTable[i0.op1]
            val src = srcEntry!!.value
            val src0 = symbolTable[i0.op2]!!.value!!.int32
            val dstEntry = symbolTable[i1.op1]
            val dst = dstEntry!!.value
            val dst0 = symbolTable[i1.op2]!!.value!!.int32
            val len = symbolTable[instruction.op1]!!.value!!.int32
            if (srcEntry.type!!.atomTypeId !== dstEntry.type!!.atomTypeId) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.DATA_TYPE_MISMATCH,
                    "Array data type mismatch: " + srcEntry.type!!.atomTypeId
                            + " is not compatible with " + dstEntry.type!!.atomTypeId
                )
            }
            if (src!!.numArrayDimensions != 1 && dst!!.numArrayDimensions != 1) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM,
                    "Array #dim!=1 : src=" + src.numArrayDimensions
                            + " and dst=" + dst.numArrayDimensions
                )
            }
            if (src0 < 0 || src0 >= src.totalLength || dst0 < 0 || len < 0 || dst0 + len > dst!!.totalLength) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM,
                    "Bad params: srcOrigin=" + src0
                            + " dstOrigin=" + dst0
                            + " len=" + len
                            + " srcArraySize=" + src.totalLength
                            + " dstArraySize=" + dst!!.totalLength
                )
            }
            when (srcEntry.type!!.atomTypeId) {
                PuffinBasicAtomTypeId.INT32 -> {
                    val value: IntArray = (src as STInt32ArrayValue?)!!.value
                    System.arraycopy(value, src0, (dst as STInt32ArrayValue?)!!.value, dst0, len)
                }

                PuffinBasicAtomTypeId.INT64 -> {
                    val value: LongArray = (src as STInt64ArrayValue?)!!.value
                    System.arraycopy(
                        value, src0, (dst as STInt64ArrayValue?)!!.value, dst0, len
                    )
                }

                PuffinBasicAtomTypeId.FLOAT -> {
                    val value: FloatArray = (src as STFloat32ArrayValue?)!!.value
                    System.arraycopy(
                        value, src0, (dst as STFloat32ArrayValue?)!!.value, dst0, len
                    )
                }

                PuffinBasicAtomTypeId.DOUBLE -> {
                    val value: DoubleArray = (src as STFloat64ArrayValue?)!!.value
                    System.arraycopy(
                        value, src0, (dst as STFloat64ArrayValue?)!!.value, dst0, len
                    )
                }

                PuffinBasicAtomTypeId.STRING -> {
                    val value = (src as STStringArrayValue?)!!.value
                    System.arraycopy(
                        value, src0, (dst as STStringArrayValue?)!!.value, dst0, len
                    )
                }

                else -> Functions.throwUnsupportedType(srcEntry.type!!.atomTypeId)
            }
        }

        @JvmStatic
        fun array1dSort(
            symbolTable: PuffinBasicSymbolTable,
            instruction: PuffinBasicIR.Instruction
        ) {
            val entry = symbolTable[instruction.op1]
            val array = entry!!.value
            when (entry.type!!.atomTypeId) {
                PuffinBasicAtomTypeId.INT32 -> Arrays.sort((array as STInt32ArrayValue?)!!.value)
                PuffinBasicAtomTypeId.INT64 -> Arrays.sort((array as STInt64ArrayValue?)!!.value)
                PuffinBasicAtomTypeId.FLOAT -> Arrays.sort((array as STFloat32ArrayValue?)!!.value)
                PuffinBasicAtomTypeId.DOUBLE -> Arrays.sort((array as STFloat64ArrayValue?)!!.value)
                PuffinBasicAtomTypeId.STRING -> Arrays.sort((array as STStringArrayValue?)!!.value)
                else -> Functions.throwUnsupportedType(entry.type!!.atomTypeId)
            }
        }

        @JvmStatic
        fun array1dBinSearch(
            symbolTable: PuffinBasicSymbolTable,
            instruction: PuffinBasicIR.Instruction
        ) {
            val arrayEntry = symbolTable[instruction.op1]
            val array = arrayEntry!!.value
            val search = symbolTable[instruction.op2]!!.value
            val result = symbolTable[instruction.result]!!.value
            var index = -1
            when (arrayEntry.type!!.atomTypeId) {
                PuffinBasicAtomTypeId.INT32 -> index =
                    Arrays.binarySearch((array as STInt32ArrayValue?)!!.value, search!!.int32)

                PuffinBasicAtomTypeId.INT64 -> index =
                    Arrays.binarySearch((array as STInt64ArrayValue?)!!.value, search!!.int64)

                PuffinBasicAtomTypeId.FLOAT -> index =
                    Arrays.binarySearch((array as STFloat32ArrayValue?)!!.value, search!!.float32)

                PuffinBasicAtomTypeId.DOUBLE -> index =
                    Arrays.binarySearch((array as STFloat64ArrayValue?)!!.value, search!!.float64)

                PuffinBasicAtomTypeId.STRING -> index =
                    Arrays.binarySearch((array as STStringArrayValue?)!!.value, search!!.string)

                else -> Functions.throwUnsupportedType(arrayEntry.type!!.atomTypeId)
            }
            result!!.int32 = index
        }

        @JvmStatic
        fun array1dMin(
            symbolTable: PuffinBasicSymbolTable,
            instruction: PuffinBasicIR.Instruction
        ) {
            val arrayEntry = symbolTable[instruction.op1]
            val array = arrayEntry!!.value
            val result = symbolTable[instruction.result]!!.value
            when (arrayEntry.type!!.atomTypeId) {
                PuffinBasicAtomTypeId.INT32 -> {
                    val value: IntArray = (array as STInt32ArrayValue?)!!.value
                    var min = Int.MAX_VALUE
                    for (v in value) {
                        if (v < min) {
                            min = v
                        }
                    }
                    result!!.int32 = min
                }

                PuffinBasicAtomTypeId.INT64 -> {
                    val value: LongArray = (array as STInt64ArrayValue?)!!.value
                    var min = Long.MAX_VALUE
                    for (v in value) {
                        if (v < min) {
                            min = v
                        }
                    }
                    result!!.int64 = min
                }

                PuffinBasicAtomTypeId.FLOAT -> {
                    val value: FloatArray = (array as STFloat32ArrayValue?)!!.value
                    var min = Float.MAX_VALUE
                    for (v in value) {
                        if (v < min) {
                            min = v
                        }
                    }
                    result!!.float32 = min
                }

                PuffinBasicAtomTypeId.DOUBLE -> {
                    val value: DoubleArray = (array as STFloat64ArrayValue?)!!.value
                    var min = Double.MAX_VALUE
                    for (v in value) {
                        if (v < min) {
                            min = v
                        }
                    }
                    result!!.float64 = min
                }

                else -> Functions.throwUnsupportedType(arrayEntry.type!!.atomTypeId)
            }
        }

        @JvmStatic
        fun array1dMax(
            symbolTable: PuffinBasicSymbolTable,
            instruction: PuffinBasicIR.Instruction
        ) {
            val arrayEntry = symbolTable[instruction.op1]
            val array = arrayEntry!!.value
            val result = symbolTable[instruction.result]!!.value
            when (arrayEntry.type!!.atomTypeId) {
                PuffinBasicAtomTypeId.INT32 -> {
                    val value: IntArray = (array as STInt32ArrayValue?)!!.value
                    var max = Int.MIN_VALUE
                    for (v in value) {
                        if (v > max) {
                            max = v
                        }
                    }
                    result!!.int32 = max
                }

                PuffinBasicAtomTypeId.INT64 -> {
                    val value: LongArray = (array as STInt64ArrayValue?)!!.value
                    var max = Long.MIN_VALUE
                    for (v in value) {
                        if (v > max) {
                            max = v
                        }
                    }
                    result!!.int64 = max
                }

                PuffinBasicAtomTypeId.FLOAT -> {
                    val value: FloatArray = (array as STFloat32ArrayValue?)!!.value
                    var max = Float.MIN_VALUE
                    for (v in value) {
                        if (v > max) {
                            max = v
                        }
                    }
                    result!!.float32 = max
                }

                PuffinBasicAtomTypeId.DOUBLE -> {
                    val value: DoubleArray = (array as STFloat64ArrayValue?)!!.value
                    var max = Double.MIN_VALUE
                    for (v in value) {
                        if (v > max) {
                            max = v
                        }
                    }
                    result!!.float64 = max
                }

                else -> Functions.throwUnsupportedType(arrayEntry.type!!.atomTypeId)
            }
        }

        @JvmStatic
        fun array1dMean(
            symbolTable: PuffinBasicSymbolTable,
            instruction: PuffinBasicIR.Instruction
        ) {
            val arrayEntry = symbolTable[instruction.op1]
            val result = symbolTable[instruction.result]!!.value
            val stats = array1dSummaryStats(arrayEntry)
            result!!.float64 = stats.mean
        }

        @JvmStatic
        fun array1dStddev(
            symbolTable: PuffinBasicSymbolTable,
            instruction: PuffinBasicIR.Instruction
        ) {
            val arrayEntry = symbolTable[instruction.op1]
            val result = symbolTable[instruction.result]!!.value
            val stats = array1dSummaryStats(arrayEntry)
            result!!.float64 = sqrt(stats.variance)
        }

        @JvmStatic
        fun array1dSum(
            symbolTable: PuffinBasicSymbolTable,
            instruction: PuffinBasicIR.Instruction
        ) {
            val arrayEntry = symbolTable[instruction.op1]
            val result = symbolTable[instruction.result]!!.value
            val stats = array1dSummaryStats(arrayEntry)
            result!!.float64 = stats.sum
        }

        @JvmStatic
        fun array1dMedian(
            symbolTable: PuffinBasicSymbolTable,
            instruction: PuffinBasicIR.Instruction
        ) {
            val arrayEntry = symbolTable[instruction.op1]
            val result = symbolTable[instruction.result]!!.value
            val stats = array1dDescriptiveStats(arrayEntry)
            result!!.float64 = stats.getPercentile(50.0)
        }

        @JvmStatic
        fun array1dPercentile(
            symbolTable: PuffinBasicSymbolTable,
            instruction: PuffinBasicIR.Instruction
        ) {
            val arrayEntry = symbolTable[instruction.op1]
            val pct = symbolTable[instruction.op2]!!.value!!.float64
            if (pct < 0 || pct > 100) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.DATA_OUT_OF_RANGE,
                    "Percentile value out of range: $pct"
                )
            }
            val result = symbolTable[instruction.result]!!.value
            val stats = array1dDescriptiveStats(arrayEntry)
            result!!.float64 = stats.getPercentile(pct)
        }

        @JvmStatic
        private fun array1dSummaryStats(array: STEntry?): SummaryStatistics {
            val stats = SummaryStatistics()
            when (array!!.type!!.atomTypeId) {
                PuffinBasicAtomTypeId.INT32 -> (array.value as STInt32ArrayValue?)!!.value
                    .map { it.toDouble() }
                    .forEach { stats.addValue(it) }

                PuffinBasicAtomTypeId.INT64 -> {
                    val value: LongArray = (array.value as STInt64ArrayValue?)!!.value
                    for (v in value) {
                        stats.addValue(v.toDouble())
                    }
                }

                PuffinBasicAtomTypeId.FLOAT -> {
                    val value: FloatArray = (array.value as STFloat32ArrayValue?)!!.value
                    for (v in value) {
                        stats.addValue(v.toDouble())
                    }
                }

                PuffinBasicAtomTypeId.DOUBLE -> {
                    val value: DoubleArray = (array.value as STFloat64ArrayValue?)!!.value
                    for (v in value) {
                        stats.addValue(v)
                    }
                }

                else -> Functions.throwUnsupportedType(array.type!!.atomTypeId)
            }
            return stats
        }

        private fun array1dDescriptiveStats(array: STEntry?): DescriptiveStatistics {
            val stats = DescriptiveStatistics()
            when (array!!.type!!.atomTypeId) {
                PuffinBasicAtomTypeId.INT32 -> {
                    val value: IntArray = (array.value as STInt32ArrayValue?)!!.value
                    for (v in value) {
                        stats.addValue(v.toDouble())
                    }
                }

                PuffinBasicAtomTypeId.INT64 -> {
                    val value: LongArray = (array.value as STInt64ArrayValue?)!!.value
                    for (v in value) {
                        stats.addValue(v.toDouble())
                    }
                }

                PuffinBasicAtomTypeId.FLOAT -> {
                    val value: FloatArray = (array.value as STFloat32ArrayValue?)!!.value
                    for (v in value) {
                        stats.addValue(v.toDouble())
                    }
                }

                PuffinBasicAtomTypeId.DOUBLE -> {
                    val value: DoubleArray = (array.value as STFloat64ArrayValue?)!!.value
                    for (v in value) {
                        stats.addValue(v)
                    }
                }

                else -> Functions.throwUnsupportedType(array.type!!.atomTypeId)
            }
            return stats
        }

        @JvmStatic
        fun array2dFindRow(
            symbolTable: PuffinBasicSymbolTable,
            params: List<PuffinBasicIR.Instruction>,
            instruction: PuffinBasicIR.Instruction
        ) {
            val i1 = params[0]
            val i2 = params[1]
            val arrayEntry = symbolTable[instruction.op1]
            val array = arrayEntry!!.value
            val search = symbolTable[instruction.op2]!!.value
            val result = symbolTable[instruction.result]!!.value
            val dims = array!!.arrayDimensions!!
            // Arrays are row-major.
            val numRows = dims[0]
            val numCols = dims[1]
            val n = array.totalLength
            val x1 = min(max(0, symbolTable[i1.op1]!!.value!!.int32), numCols - 1)
            val y1 = min(max(0, symbolTable[i1.op2]!!.value!!.int32), numRows - 1)
            val x2 = min(max(0, symbolTable[i2.op1]!!.value!!.int32), numCols - 1)
            val y2 = min(max(0, symbolTable[i2.op2]!!.value!!.int32), numRows - 1)
            if (y1 * numCols + x1 >= n || y2 * numCols + x2 >= n) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.INDEX_OUT_OF_BOUNDS,
                    "x1=" + x1 + "/y1=" + y1 + "/x2=" + x2 + "/y2=" + y2
                            + " is out of bounds, array length=" + n
                )
            }
            when (arrayEntry.type!!.atomTypeId) {
                PuffinBasicAtomTypeId.INT32 -> {
                    val int32Array: IntArray = (array as STInt32ArrayValue?)!!.value
                    result!!.int32 =
                        findRowWithValue(int32Array, numCols, x1, y1, x2, y2, search!!.int32)
                }

                PuffinBasicAtomTypeId.INT64 -> {
                    val int64Array: LongArray = (array as STInt64ArrayValue?)!!.value
                    result!!.int32 =
                        findRowWithValue(int64Array, numCols, x1, y1, x2, y2, search!!.int64)
                }

                else -> Functions.throwUnsupportedType(arrayEntry.type!!.atomTypeId)
            }
        }

        @JvmStatic
        fun array2dFindColumn(
            symbolTable: PuffinBasicSymbolTable,
            params: List<PuffinBasicIR.Instruction>,
            instruction: PuffinBasicIR.Instruction
        ) {
            val i1 = params[0]
            val i2 = params[1]
            val arrayEntry = symbolTable[instruction.op1]
            val array = arrayEntry!!.value
            val search = symbolTable[instruction.op2]!!.value
            val result = symbolTable[instruction.result]!!.value
            val dims = array!!.arrayDimensions!!
            // Arrays are row-major.
            val numRows = dims[0]
            val numCols = dims[1]
            val n = array.totalLength
            val x1 = min(max(0, symbolTable[i1.op1]!!.value!!.int32), numCols - 1)
            val y1 = min(max(0, symbolTable[i1.op2]!!.value!!.int32), numRows - 1)
            val x2 = min(max(0, symbolTable[i2.op1]!!.value!!.int32), numCols - 1)
            val y2 = min(max(0, symbolTable[i2.op2]!!.value!!.int32), numRows - 1)
            if (y1 * numCols + x1 >= n || y2 * numCols + x2 >= n) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.INDEX_OUT_OF_BOUNDS,
                    "x1=" + x1 + "/y1=" + y1 + "/x2=" + x2 + "/y2=" + y2
                            + " is out of bounds, array length=" + n
                )
            }
            when (arrayEntry.type!!.atomTypeId) {
                PuffinBasicAtomTypeId.INT32 -> {
                    val int32Array: IntArray = (array as STInt32ArrayValue?)!!.value
                    result!!.int32 =
                        findColumnWithValue(int32Array, numCols, x1, y1, x2, y2, search!!.int32)
                }

                PuffinBasicAtomTypeId.INT64 -> {
                    val int64Array: LongArray = (array as STInt64ArrayValue?)!!.value
                    result!!.int32 =
                        findColumnWithValue(int64Array, numCols, x1, y1, x2, y2, search!!.int64)
                }

                else -> Functions.throwUnsupportedType(arrayEntry.type!!.atomTypeId)
            }
        }

        private fun findRowWithValue(
            array: IntArray,
            w: Int,
            x1: Int,
            y1: Int,
            x2: Int,
            y2: Int,
            search: Int
        ): Int {
            if (y1 <= y2) {
                for (r in y1..y2) {
                    for (c in x1..x2) {
                        val v = array[r * w + c]
                        if (v == search) {
                            return r
                        }
                    }
                }
            } else {
                for (r in y1 downTo y2) {
                    for (c in x1..x2) {
                        val v = array[r * w + c]
                        if (v == search) {
                            return r
                        }
                    }
                }
            }
            return -1
        }

        private fun findColumnWithValue(
            array: IntArray,
            w: Int,
            x1: Int,
            y1: Int,
            x2: Int,
            y2: Int,
            search: Int
        ): Int {
            if (x1 <= x2) {
                for (c in x1..x2) {
                    for (r in y1..y2) {
                        val v = array[r * w + c]
                        if (v == search) {
                            return c
                        }
                    }
                }
            } else {
                for (c in x1 downTo x2) {
                    for (r in y1..y2) {
                        val v = array[r * w + c]
                        if (v == search) {
                            return c
                        }
                    }
                }
            }
            return -1
        }

        private fun findRowWithValue(
            array: LongArray,
            w: Int,
            x1: Int,
            y1: Int,
            x2: Int,
            y2: Int,
            search: Long
        ): Int {
            if (y1 <= y2) {
                for (r in y1..y2) {
                    for (c in x1..x2) {
                        val v = array[r * w + c]
                        if (v == search) {
                            return r
                        }
                    }
                }
            } else {
                for (r in y1 downTo y2) {
                    for (c in x1..x2) {
                        val v = array[r * w + c]
                        if (v == search) {
                            return r
                        }
                    }
                }
            }
            return -1
        }

        private fun findColumnWithValue(
            array: LongArray,
            w: Int,
            x1: Int,
            y1: Int,
            x2: Int,
            y2: Int,
            search: Long
        ): Int {
            if (x1 <= x2) {
                for (c in x1..x2) {
                    for (r in y1..y2) {
                        val v = array[r * w + c]
                        if (v == search) {
                            return c
                        }
                    }
                }
            } else {
                for (c in x1 downTo x2) {
                    for (r in y1..y2) {
                        val v = array[r * w + c]
                        if (v == search) {
                            return c
                        }
                    }
                }
            }
            return -1
        }
    }
}