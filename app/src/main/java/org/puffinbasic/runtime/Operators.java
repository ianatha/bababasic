package org.puffinbasic.runtime;

import org.puffinbasic.domain.PuffinBasicSymbolTable;
import org.puffinbasic.error.PuffinBasicInternalError;
import org.puffinbasic.error.PuffinBasicRuntimeError;
import org.puffinbasic.parser.PuffinBasicIR.Instruction;

import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.INT32;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.DIVISION_BY_ZERO;

final class Operators {

    public static void unaryMinus(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var op1Entry = symbolTable.get(instruction.op1);
        var op1 = op1Entry.getValue();
        var result = symbolTable.get(instruction.result).getValue();
        switch (op1Entry.getType().getAtomTypeId()) {
            case INT32:
                result.setInt32(-op1.getInt32());
                break;
            case INT64:
                result.setInt64(-op1.getInt64());
                break;
            case FLOAT:
                result.setFloat32(-op1.getFloat32());
                break;
            case DOUBLE:
                result.setFloat64(-op1.getFloat64());
                break;
            default:
                throw new PuffinBasicInternalError(
                        "Unary minus is not supported for data type: " + op1Entry.getType().getAtomTypeId()
                );
        }
    }

    public static void concat(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1 = symbolTable.get(instruction.op1).getValue().getString();
        var v2 = symbolTable.get(instruction.op2).getValue().getString();
        var result = symbolTable.get(instruction.result).getValue();
        result.setString(v1 + v2);
    }

    public static void leftShift(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1Entry = symbolTable.get(instruction.op1);
        var v1 = v1Entry.getValue();
        var v2Entry = symbolTable.get(instruction.op2);
        var v2 = v2Entry.getValue();
        var result = symbolTable.get(instruction.result).getValue();
        if (v1Entry.getType().getAtomTypeId() == INT32 && v2Entry.getType().getAtomTypeId() == INT32) {
            result.setInt32(v1.getRoundedInt32() << v2.getRoundedInt32());
        } else {
            result.setInt64(v1.getRoundedInt64() << v2.getRoundedInt64());
        }
    }

    public static void rightShift(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1Entry = symbolTable.get(instruction.op1);
        var v1 = v1Entry.getValue();
        var v2Entry = symbolTable.get(instruction.op2);
        var v2 = v2Entry.getValue();
        var result = symbolTable.get(instruction.result).getValue();
        if (v1Entry.getType().getAtomTypeId() == INT32 && v2Entry.getType().getAtomTypeId() == INT32) {
            result.setInt32(v1.getRoundedInt32() >> v2.getRoundedInt32());
        } else {
            result.setInt64(v1.getRoundedInt64() >> v2.getRoundedInt64());
        }
    }

    public static void mod(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1Entry = symbolTable.get(instruction.op1);
        var v1 = v1Entry.getValue();
        var v2Entry = symbolTable.get(instruction.op2);
        var v2 = v2Entry.getValue();
        var result = symbolTable.get(instruction.result).getValue();
        if (v1Entry.getType().getAtomTypeId() == INT32 && v2Entry.getType().getAtomTypeId() == INT32) {
            result.setInt32(v1.getRoundedInt32() % v2.getRoundedInt32());
        } else {
            result.setInt64(v1.getRoundedInt64() % v2.getRoundedInt64());
        }
    }

    public static void idiv(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1Entry = symbolTable.get(instruction.op1);
        var v1 = v1Entry.getValue();
        var v2Entry = symbolTable.get(instruction.op2);
        var v2 = v2Entry.getValue();
        var result = symbolTable.get(instruction.result).getValue();
        if (v1Entry.getType().getAtomTypeId() == INT32 && v2Entry.getType().getAtomTypeId() == INT32) {
            if (v2.getRoundedInt32() == 0) {
                throw new PuffinBasicRuntimeError(
                        DIVISION_BY_ZERO,
                        "Division by zero"
                );
            }
            result.setInt32(v1.getRoundedInt32() / v2.getRoundedInt32());
        } else {
            if (v2.getRoundedInt64() == 0) {
                throw new PuffinBasicRuntimeError(
                        DIVISION_BY_ZERO,
                        "Division by zero"
                );
            }
            result.setInt64(v1.getRoundedInt64() / v2.getRoundedInt64());
        }
    }

    public static void addInt32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt32(v1.getInt32() + v2.getInt32());
    }

    public static void addInt64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(v1.getInt64() + v2.getInt64());
    }

    public static void addFloat32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setFloat32(v1.getFloat32() + v2.getFloat32());
    }

    public static void addFloat64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setFloat64(v1.getFloat64() + v2.getFloat64());
    }

    public static void subInt32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt32(v1.getInt32() - v2.getInt32());
    }

    public static void subInt64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(v1.getInt64() - v2.getInt64());
    }

    public static void subFloat32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setFloat32(v1.getFloat32() - v2.getFloat32());
    }

    public static void subFloat64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setFloat64(v1.getFloat64() - v2.getFloat64());
    }

    public static void mulInt32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt32(v1.getInt32() * v2.getInt32());
    }

    public static void mulInt64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(v1.getInt64() * v2.getInt64());
    }

    public static void mulFloat32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setFloat32(v1.getFloat32() * v2.getFloat32());
    }

    public static void mulFloat64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setFloat64(v1.getFloat64() * v2.getFloat64());
    }

    public static void fdiv(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        if (v2.getFloat64() == 0) {
            throw new PuffinBasicRuntimeError(
                    DIVISION_BY_ZERO,
                    "Division by zero"
            );
        }
        result.setFloat64(v1.getFloat64() / v2.getFloat64());
    }

    public static void expInt32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt32((int) Math.pow(v1.getInt32(), v2.getInt32()));
    }

    public static void expInt64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64((long) Math.pow(v1.getInt64(), v2.getInt64()));
    }

    public static void expFloat32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setFloat32((float) Math.pow(v1.getFloat32(), v2.getFloat32()));
    }

    public static void expFloat64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setFloat64(Math.pow(v1.getFloat64(), v2.getFloat64()));
    }

    public static void and(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var v1 = symbolTable.get(instruction.op1).getValue().getInt64();
        var v2 = symbolTable.get(instruction.op2).getValue().getInt64();
        var result = symbolTable.get(instruction.result).getValue();

        if ((v1 == -1 || v1 == 0) && (v2 == -1 || v2 == 0)) {
            var b1 = v1 == -1;
            var b2 = v2 == -1;
            result.setInt64(b1 && b2 ? -1 : 0);
        } else {
            result.setInt64(v1 & v2);
        }
    }

    public static void or(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var v1 = symbolTable.get(instruction.op1).getValue().getInt64();
        var v2 = symbolTable.get(instruction.op2).getValue().getInt64();
        var result = symbolTable.get(instruction.result).getValue();

        if ((v1 == -1 || v1 == 0) && (v2 == -1 || v2 == 0)) {
            var b1 = v1 == -1;
            var b2 = v2 == -1;
            result.setInt64(b1 || b2 ? -1 : 0);
        } else {
            result.setInt64(v1 | v2);
        }
    }

    public static void xor(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var v1 = symbolTable.get(instruction.op1).getValue().getInt64();
        var v2 = symbolTable.get(instruction.op2).getValue().getInt64();
        var result = symbolTable.get(instruction.result).getValue();

        if ((v1 == -1 || v1 == 0) && (v2 == -1 || v2 == 0)) {
            var b1 = v1 == -1;
            var b2 = v2 == -1;
            result.setInt64(b1 ^ b2 ? -1 : 0);
        } else {
            result.setInt64(v1 ^ v2);
        }
    }

    public static void eqv(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var v1 = symbolTable.get(instruction.op1).getValue().getInt64();
        var v2 = symbolTable.get(instruction.op2).getValue().getInt64();
        var result = symbolTable.get(instruction.result).getValue();

        if ((v1 == -1 || v1 == 0) && (v2 == -1 || v2 == 0)) {
            var b1 = v1 == -1;
            var b2 = v2 == -1;
            result.setInt64(b1 == b2 ? -1 : 0);
        } else {
            result.setInt64(~(v1 ^ v2));
        }
    }

    public static void imp(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var v1 = symbolTable.get(instruction.op1).getValue().getInt64();
        var v2 = symbolTable.get(instruction.op2).getValue().getInt64();
        var result = symbolTable.get(instruction.result).getValue();

        if ((v1 == -1 || v1 == 0) && (v2 == -1 || v2 == 0)) {
            var b1 = v1 == -1;
            var b2 = v2 == -1;
            result.setInt64((!b1) || b2 ? -1 : 0);
        } else {
            result.setInt64((~v1) | v2);
        }
    }

    public static void ltInt32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(e1.getInt32() < e2.getInt32() ? -1 : 0);
    }

    public static void ltInt64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(e1.getInt64() < e2.getInt64() ? -1 : 0);
    }

    public static void ltFloat32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(Float.compare(e1.getFloat32(), e2.getFloat32()) < 0 ? -1 : 0);
    }

    public static void ltFloat64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(Double.compare(e1.getFloat64(), e2.getFloat64()) < 0 ? -1 : 0);
    }

    public static void ltStr(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(e1.getString().compareTo(e2.getString()) < 0 ? -1 : 0);
    }

    public static void leInt32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(e1.getInt32() <= e2.getInt32() ? -1 : 0);
    }

    public static void leInt64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(e1.getInt64() <= e2.getInt64() ? -1 : 0);
    }

    public static void leFloat32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(Float.compare(e1.getFloat32(), e2.getFloat32()) <= 0 ? -1 : 0);
    }

    public static void leFloat64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(Double.compare(e1.getFloat64(), e2.getFloat64()) <= 0 ? -1 : 0);
    }

    public static void leStr(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(e1.getString().compareTo(e2.getString()) <= 0 ? -1 : 0);
    }

    public static void gtInt32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(e1.getInt32() > e2.getInt32() ? -1 : 0);
    }

    public static void gtInt64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        final long longResult;
                longResult = e1.getInt64() > e2.getInt64() ? -1 : 0;
        result.setInt64(longResult);
    }

    public static void gtFloat32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(Float.compare(e1.getFloat32(), e2.getFloat32()) > 0 ? -1 : 0);
    }

    public static void gtFloat64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(Double.compare(e1.getFloat64(), e2.getFloat64()) > 0 ? -1 : 0);
    }

    public static void gtStr(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(e1.getString().compareTo(e2.getString()) > 0 ? -1 : 0);
    }

    public static void geInt32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(e1.getInt32() >= e2.getInt32() ? -1 : 0);
    }

    public static void geInt64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(e1.getInt64() >= e2.getInt64() ? -1 : 0);
    }

    public static void geFloat32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(Float.compare(e1.getFloat32(), e2.getFloat32()) >= 0 ? -1 : 0);
    }

    public static void geFloat64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(Double.compare(e1.getFloat64(), e2.getFloat64()) >= 0 ? -1 : 0);
    }

    public static void geStr(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(e1.getString().compareTo(e2.getString()) >= 0 ? -1 : 0);
    }

    public static void eqInt32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(e1.getInt32() == e2.getInt32() ? -1 : 0);
    }

    public static void eqInt64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(e1.getInt64() == e2.getInt64() ? -1 : 0);
    }

    public static void eqFloat32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(Float.compare(e1.getFloat32(), e2.getFloat32()) == 0 ? -1 : 0);
    }

    public static void eqFloat64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(Double.compare(e1.getFloat64(), e2.getFloat64()) == 0 ? -1 : 0);
    }

    public static void eqStr(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(e1.getString().equals(e2.getString()) ? -1 : 0);
    }

    public static void neInt32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(e1.getInt32() != e2.getInt32() ? -1 : 0);
    }

    public static void neInt64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(e1.getInt64() != e2.getInt64() ? -1 : 0);
    }

    public static void neFloat32(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(Float.compare(e1.getFloat32(), e2.getFloat32()) != 0 ? -1 : 0);
    }

    public static void neFloat64(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(Double.compare(e1.getFloat64(), e2.getFloat64()) != 0 ? -1 : 0);
    }

    public static void neStr(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var e1 = symbolTable.get(instruction.op1).getValue();
        var e2 = symbolTable.get(instruction.op2).getValue();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt64(!e1.getString().equals(e2.getString()) ? -1 : 0);
    }

    public static void unaryNot(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var v = symbolTable.get(instruction.op1).getValue().getInt64();
        var result = symbolTable.get(instruction.result).getValue();
        if (v == -1) {
            result.setInt64(0);
        } else if (v == 0) {
            result.setInt64(-1);
        } else {
            result.setInt64(~v);
        }
    }
}
