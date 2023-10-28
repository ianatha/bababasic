package org.puffinbasic.runtime;

import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.INT32;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.INT64;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.STRING;
import static org.puffinbasic.domain.STObjects.PuffinBasicTypeId.SCALAR;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.BAD_FIELD;
import static org.puffinbasic.error.PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH;

import org.puffinbasic.domain.PuffinBasicSymbolTable;
import org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId;
import org.puffinbasic.domain.STObjects.STLValue;
import org.puffinbasic.error.PuffinBasicRuntimeError;
import org.puffinbasic.error.PuffinBasicSemanticError;
import org.puffinbasic.parser.PuffinBasicIR.Instruction;

import java.util.function.Supplier;

public class Types {

    public static void copy(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var fromEntry = symbolTable.get(instruction.op1);
        var toEntry = symbolTable.get(instruction.op2);
        toEntry.getValue().assign(fromEntry.getValue());
    }

    public static void paramCopy(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var fromEntry = symbolTable.get(instruction.op1);
        var toEntry = symbolTable.get(instruction.op2);
        if (toEntry.getType().getTypeId() == SCALAR) {
            toEntry.getValue().assign(fromEntry.getValue());
        } else if (toEntry.isLValue()) {
            ((STLValue) toEntry).setValue(fromEntry.getValue());
        } else {
            throw new PuffinBasicRuntimeError(
                    BAD_FIELD,
                    "Expected LValue, but found: " + toEntry.getType()
            );
        }
    }

    public static void varref(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var src = symbolTable.get(instruction.op1);
        var dst = symbolTable.get(instruction.op2);
        if (dst.isLValue()) {
            ((STLValue) dst).setValue(src.getValue());
        } else {
            throw new PuffinBasicRuntimeError(
                    BAD_FIELD,
                    "Expected LValue, but found: " + dst.getType()
            );
        }
    }

    public static String unquote(String txt) {
        if (txt == null || txt.isEmpty()) {
            return txt;
        } else {
            if (txt.length() > 1 && txt.charAt(0) == '"' && txt.charAt(txt.length() - 1) == '"') {
                return txt.substring(1, txt.length() - 1);
            } else {
                return "";
            }
        }
    }

    public static void assertString(
            PuffinBasicAtomTypeId dt, Supplier<String> line
    ) {
        if (dt != STRING) {
            throw new PuffinBasicSemanticError(
                    DATA_TYPE_MISMATCH,
                    line.get(),
                    "Expected String type but found: " + dt
            );
        }
    }

    public static void assertNumeric(
            PuffinBasicAtomTypeId dt, Supplier<String> line
    ) {
        if (dt == STRING) {
            throw new PuffinBasicSemanticError(
                    DATA_TYPE_MISMATCH,
                    line.get(),
                    "Expected numeric type but found String!"
            );
        }
    }

    public static void assertIntType(
            PuffinBasicAtomTypeId dt, Supplier<String> line
    ) {
        if (dt != INT32 && dt != INT64) {
            throw new PuffinBasicSemanticError(
                    DATA_TYPE_MISMATCH,
                    line.get(),
                    "Expected int type but found: " + dt
            );
        }
    }

    public static void assertNumeric(
            PuffinBasicAtomTypeId dt1, PuffinBasicAtomTypeId dt2, Supplier<String> line
    ) {
        if (dt1 == STRING || dt2 == STRING) {
            throw new PuffinBasicSemanticError(
                    DATA_TYPE_MISMATCH,
                    line.get(),
                    "Expected numeric type but found String!"
            );
        }
    }

    public static void assertBothStringOrNumeric(
            PuffinBasicAtomTypeId dt1, PuffinBasicAtomTypeId dt2, Supplier<String> line
    ) {
        if ((dt1 != STRING || dt2 != STRING)
                && (dt1 == STRING || dt2 == STRING)) {
            throw new PuffinBasicSemanticError(
                    DATA_TYPE_MISMATCH,
                    line.get(),
                    "Expected either both numeric or both string type but found: "
                            + dt1 + " and " + dt2
            );
        }
    }

    public static PuffinBasicAtomTypeId upcast(
            PuffinBasicAtomTypeId dt1, PuffinBasicAtomTypeId dt2, Supplier<String> line
    ) {
        assertNumeric(dt1, dt2, line);
        if (dt1 == PuffinBasicAtomTypeId.DOUBLE || dt2 == PuffinBasicAtomTypeId.DOUBLE) {
            return PuffinBasicAtomTypeId.DOUBLE;
        } else if (dt1 == PuffinBasicAtomTypeId.INT64 || dt2 == PuffinBasicAtomTypeId.INT64) {
            return PuffinBasicAtomTypeId.INT64;
        } else if (dt1 == PuffinBasicAtomTypeId.FLOAT || dt2 == PuffinBasicAtomTypeId.FLOAT) {
            return PuffinBasicAtomTypeId.FLOAT;
        } else {
            return PuffinBasicAtomTypeId.INT32;
        }
    }
}
