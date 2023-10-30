package org.puffinbasic.runtime

import org.puffinbasic.domain.PuffinBasicSymbolTable
import org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId
import org.puffinbasic.domain.STObjects.PuffinBasicTypeId
import org.puffinbasic.domain.STObjects.STLValue
import org.puffinbasic.error.PuffinBasicRuntimeError
import org.puffinbasic.error.PuffinBasicSemanticError
import org.puffinbasic.parser.PuffinBasicIR
import java.util.function.Supplier

object Types {
    @JvmStatic
    fun copy(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val fromEntry = symbolTable[instruction.op1]
        val toEntry = symbolTable[instruction.op2]
        toEntry!!.value!!.assign(fromEntry!!.value!!)
    }

    @JvmStatic
    fun paramCopy(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val fromEntry = symbolTable[instruction.op1]
        val toEntry = symbolTable[instruction.op2]
        if (toEntry!!.type!!.typeId === PuffinBasicTypeId.SCALAR) {
            toEntry!!.value!!.assign(fromEntry!!.value!!)
        } else if (toEntry!!.isLValue) {
            (toEntry as STLValue?)!!.value = fromEntry!!.value
        } else {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.BAD_FIELD,
                "Expected LValue, but found: " + toEntry.type
            )
        }
    }

    @JvmStatic
    fun varref(symbolTable: PuffinBasicSymbolTable, instruction: PuffinBasicIR.Instruction) {
        val src = symbolTable[instruction.op1]
        val dst = symbolTable[instruction.op2]
        if (dst!!.isLValue) {
            (dst as STLValue?)!!.value = src!!.value
        } else {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.BAD_FIELD,
                "Expected LValue, but found: " + dst.type
            )
        }
    }

    fun unquote(txt: String?): String? {
        return if (txt == null || txt.isEmpty()) {
            txt
        } else {
            if (txt.length > 1 && txt[0] == '"' && txt[txt.length - 1] == '"') {
                txt.substring(1, txt.length - 1)
            } else {
                ""
            }
        }
    }

    fun assertString(
        dt: PuffinBasicAtomTypeId, line: Supplier<String?>
    ) {
        if (dt !== PuffinBasicAtomTypeId.STRING) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH,
                line.get()!!,
                "Expected String type but found: $dt"
            )
        }
    }

    fun assertNumeric(
        dt: PuffinBasicAtomTypeId, line: Supplier<String?>
    ) {
        if (dt === PuffinBasicAtomTypeId.STRING) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH,
                line.get()!!,
                "Expected numeric type but found String!"
            )
        }
    }

    fun assertIntType(
        dt: PuffinBasicAtomTypeId, line: Supplier<String?>
    ) {
        if (dt !== PuffinBasicAtomTypeId.INT32 && dt !== PuffinBasicAtomTypeId.INT64) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH,
                line.get()!!,
                "Expected int type but found: $dt"
            )
        }
    }

    fun assertNumeric(
        dt1: PuffinBasicAtomTypeId, dt2: PuffinBasicAtomTypeId, line: Supplier<String?>
    ) {
        if (dt1 === PuffinBasicAtomTypeId.STRING || dt2 === PuffinBasicAtomTypeId.STRING) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH,
                line.get()!!,
                "Expected numeric type but found String!"
            )
        }
    }

    @JvmStatic
    fun assertBothStringOrNumeric(
        dt1: PuffinBasicAtomTypeId, dt2: PuffinBasicAtomTypeId, line: Supplier<String?>
    ) {
        if ((dt1 !== PuffinBasicAtomTypeId.STRING || dt2 !== PuffinBasicAtomTypeId.STRING)
            && (dt1 === PuffinBasicAtomTypeId.STRING || dt2 === PuffinBasicAtomTypeId.STRING)
        ) {
            throw PuffinBasicSemanticError(
                PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH,
                line.get()!!,
                "Expected either both numeric or both string type but found: "
                        + dt1 + " and " + dt2
            )
        }
    }

    fun upcast(
        dt1: PuffinBasicAtomTypeId, dt2: PuffinBasicAtomTypeId, line: Supplier<String?>
    ): PuffinBasicAtomTypeId {
        assertNumeric(dt1, dt2, line)
        return if (dt1 === PuffinBasicAtomTypeId.DOUBLE || dt2 === PuffinBasicAtomTypeId.DOUBLE) {
            PuffinBasicAtomTypeId.DOUBLE
        } else if (dt1 === PuffinBasicAtomTypeId.INT64 || dt2 === PuffinBasicAtomTypeId.INT64) {
            PuffinBasicAtomTypeId.INT64
        } else if (dt1 === PuffinBasicAtomTypeId.FLOAT || dt2 === PuffinBasicAtomTypeId.FLOAT) {
            PuffinBasicAtomTypeId.FLOAT
        } else {
            PuffinBasicAtomTypeId.INT32
        }
    }
}