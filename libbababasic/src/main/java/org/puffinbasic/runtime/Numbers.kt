package org.puffinbasic.runtime

import org.puffinbasic.error.PuffinBasicSemanticError
import java.util.function.Supplier

object Numbers {
    @JvmStatic
    fun parseInt32(value: String, lineSupplier: Supplier<String?>): Int {
        return try {
            value.toInt()
        } catch (e: NumberFormatException) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.BAD_NUMBER,
                lineSupplier.get()!!,
                "Failed to parse number as int32: $value"
            )
        }
    }

    @JvmStatic
    fun parseInt32(value: String, base: Int, lineSupplier: Supplier<String?>): Int {
        return try {
            value.toInt(base)
        } catch (e: NumberFormatException) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.BAD_NUMBER,
                lineSupplier.get()!!,
                "Failed to parse number as int32: $value"
            )
        }
    }

    @JvmStatic
    fun parseInt64(value: String, lineSupplier: Supplier<String?>): Long {
        return try {
            value.toLong()
        } catch (e: NumberFormatException) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.BAD_NUMBER,
                lineSupplier.get()!!,
                "Failed to parse number as int64: $value"
            )
        }
    }

    @JvmStatic
    fun parseInt64(value: String, base: Int, lineSupplier: Supplier<String?>): Long {
        return try {
            value.toLong(base)
        } catch (e: NumberFormatException) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.BAD_NUMBER,
                lineSupplier.get()!!,
                "Failed to parse number as int64: $value"
            )
        }
    }

    @JvmStatic
    fun parseFloat32(value: String, lineSupplier: Supplier<String?>): Float {
        return try {
            value.toFloat()
        } catch (e: NumberFormatException) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.BAD_NUMBER,
                lineSupplier.get()!!,
                "Failed to parse number as float32: $value"
            )
        }
    }

    @JvmStatic
    fun parseFloat64(value: String, lineSupplier: Supplier<String?>): Double {
        return try {
            value.toDouble()
        } catch (e: NumberFormatException) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.BAD_NUMBER,
                lineSupplier.get()!!,
                "Failed to parse number as float64: $value"
            )
        }
    }
}