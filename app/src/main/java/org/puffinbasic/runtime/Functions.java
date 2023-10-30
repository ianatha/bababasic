package org.puffinbasic.runtime;

import static org.puffinbasic.domain.PuffinBasicSymbolTable.NULL_ID;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.FLOAT;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.INT32;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.INT64;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.STRING;
import static org.puffinbasic.domain.STObjects.PuffinBasicTypeId.ARRAY;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.DATA_OUT_OF_RANGE;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.INDEX_OUT_OF_BOUNDS;

import com.google.common.base.Strings;

import org.puffinbasic.domain.PuffinBasicSymbolTable;
import org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId;
import org.puffinbasic.error.PuffinBasicInternalError;
import org.puffinbasic.error.PuffinBasicRuntimeError;
import org.puffinbasic.file.PuffinBasicFiles;
import org.puffinbasic.parser.PuffinBasicIR.Instruction;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import it.unimi.dsi.fastutil.doubles.Double2DoubleFunction;

public class Functions {

    public static void abs(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var op1Entry = symbolTable.get(instruction.op1);
        var op1 = op1Entry.getValue();
        var result = symbolTable.get(instruction.result).getValue();
        switch (op1Entry.getType().getAtomTypeId()) {
            case INT32:
                result.setInt32(Math.abs(op1.getInt32()));
                break;
            case INT64:
                result.setInt64(Math.abs(op1.getInt64()));
                break;
            case FLOAT:
                result.setFloat32(Math.abs(op1.getFloat32()));
                break;
            case DOUBLE:
                result.setFloat64(Math.abs(op1.getFloat64()));
                break;
            default:
                throwUnsupportedType(op1Entry.getType().getAtomTypeId());
        }
    }

    public static void asc(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var value = symbolTable.get(instruction.op1).getValue().getString();
        if (value == null || value.isEmpty()) {
            throw new PuffinBasicRuntimeError(
                    ILLEGAL_FUNCTION_PARAM,
                    "IllegalFunctionCall: null/empty string: '" + value + "'"
            );
        }
        var ascii = (int) value.charAt(0);
        symbolTable.get(instruction.result).getValue().setInt32(ascii);
    }

    public static void sin(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::sin);
    }

    public static void cos(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::cos);
    }

    public static void tan(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::tan);
    }

    public static void asin(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::asin);
    }

    public static void acos(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::acos);
    }

    public static void atn(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::atan);
    }

    public static void sinh(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::sinh);
    }

    public static void cosh(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::cosh);
    }

    public static void tanh(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::tanh);
    }

    public static void sqr(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::sqrt);
    }

    public static void log(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::log);
    }

    public static void log10(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::log10);
    }

    public static void log2(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Functions::mathLog2);
    }

    private static double mathLog2(double x) {
        return Math.log(x) / Math.log(2);
    }

    public static void exp(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::exp);
    }

    public static void toRad(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::toRadians);
    }

    public static void toDeg(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::toDegrees);
    }

    public static void floor(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::floor);
    }

    public static void ceil(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::ceil);
    }

    public static void round(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        applyDoubleFunction(symbolTable, instruction, Math::round);
    }

    public static void e(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var result = symbolTable.get(instruction.result).getValue();
        result.setFloat64(Math.E);
    }

    public static void pi(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var result = symbolTable.get(instruction.result).getValue();
        result.setFloat64(Math.PI);
    }

    public static void min(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var resultEntry = symbolTable.get(instruction.result);
        var result = resultEntry.getValue();

        switch (resultEntry.getType().getAtomTypeId()) {
            case INT32:
                result.setInt32(Math.min(v1.getInt32(), v2.getInt32()));
                break;
            case INT64:
                result.setInt64(Math.min(v1.getInt64(), v2.getInt64()));
                break;
            case FLOAT:
                result.setFloat32(Math.min(v1.getFloat32(), v2.getFloat32()));
                break;
            case DOUBLE:
                result.setFloat64(Math.min(v1.getFloat64(), v2.getFloat64()));
                break;
            default:
                throwUnsupportedType(resultEntry.getType().getAtomTypeId());
        }
    }

    public static void max(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var v1 = symbolTable.get(instruction.op1).getValue();
        var v2 = symbolTable.get(instruction.op2).getValue();
        var resultEntry = symbolTable.get(instruction.result);
        var result = resultEntry.getValue();

        switch (resultEntry.getType().getAtomTypeId()) {
            case INT32:
                result.setInt32(Math.max(v1.getInt32(), v2.getInt32()));
                break;
            case INT64:
                result.setInt64(Math.max(v1.getInt64(), v2.getInt64()));
                break;
            case FLOAT:
                result.setFloat32(Math.max(v1.getFloat32(), v2.getFloat32()));
                break;
            case DOUBLE:
                result.setFloat64(Math.max(v1.getFloat64(), v2.getFloat64()));
                break;
            default:
                throwUnsupportedType(resultEntry.getType().getAtomTypeId());
        }
    }

    private static void applyDoubleFunction(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction,
            Double2DoubleFunction function) {
        var value = symbolTable.get(instruction.op1).getValue().getFloat64();
        var result = symbolTable.get(instruction.result).getValue();
        result.setFloat64(function.applyAsDouble(value));
    }

    public static void cint(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var entry = symbolTable.get(instruction.op1).getValue();
        double value = entry.getFloat64();
        if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
            throw new PuffinBasicRuntimeError(
                    DATA_OUT_OF_RANGE,
                    "CINT: value: " + value + " overflows an int32"
            );
        }
        symbolTable.get(instruction.result).getValue().setInt32(entry.getRoundedInt32());
    }

    public static void clng(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var entry = symbolTable.get(instruction.op1).getValue();
        double value = entry.getFloat64();
        if (value < Long.MIN_VALUE || value > Long.MAX_VALUE) {
            throw new PuffinBasicRuntimeError(
                    DATA_OUT_OF_RANGE,
                    "CLONG: value: " + value + " overflows an int64"
            );
        }
        symbolTable.get(instruction.result).getValue().setInt64(entry.getRoundedInt64());
    }

    public static void csng(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        symbolTable.get(instruction.result).getValue().setFloat32(
                symbolTable.get(instruction.op1).getValue().getFloat32());
    }

    public static void cdbl(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        symbolTable.get(instruction.result).getValue().setFloat64(
                symbolTable.get(instruction.op1).getValue().getFloat64());
    }

    public static void chrdlr(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        int intValue = symbolTable.get(instruction.op1).getValue().getInt32();
        char charValue = (char) intValue;
        symbolTable.get(instruction.result).getValue().setString(
                String.valueOf(charValue));
    }

    public static void mkidlr(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        int value = symbolTable.get(instruction.op1).getValue().getInt32();
        String str = new String(ByteBuffer.allocate(4).putInt(value).array(), StandardCharsets.ISO_8859_1);
        symbolTable.get(instruction.result).getValue().setString(str);
    }

    public static void mkldlr(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        long value = symbolTable.get(instruction.op1).getValue().getInt64();
        String str = new String(ByteBuffer.allocate(8).putLong(value).array(), StandardCharsets.ISO_8859_1);
        symbolTable.get(instruction.result).getValue().setString(str);
    }

    public static void mksdlr(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        float value = symbolTable.get(instruction.op1).getValue().getFloat32();
        String str = new String(ByteBuffer.allocate(4).putFloat(value).array(), StandardCharsets.ISO_8859_1);
        symbolTable.get(instruction.result).getValue().setString(str);
    }

    public static void mkddlr(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        double value = symbolTable.get(instruction.op1).getValue().getFloat64();
        String str = new String(ByteBuffer.allocate(8).putDouble(value).array(), StandardCharsets.ISO_8859_1);
        symbolTable.get(instruction.result).getValue().setString(str);
    }

    public static void cvi(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        String value = symbolTable.get(instruction.op1).getValue().getString();
        if (value.length() != 4) {
            throw new PuffinBasicRuntimeError(
                    DATA_OUT_OF_RANGE,
                    "CVI$: value: " + value + " length must be 4, found: " + value.length()
            );
        }
        int intValue = ByteBuffer.wrap(value.getBytes(StandardCharsets.ISO_8859_1), 0, 4).getInt();
        symbolTable.get(instruction.result).getValue().setInt32(intValue);
    }

    public static void cvl(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        String value = symbolTable.get(instruction.op1).getValue().getString();
        if (value.length() != 8) {
            throw new PuffinBasicRuntimeError(
                    DATA_OUT_OF_RANGE,
                    "CVL$: value: " + value + " length must be 8, found: " + value.length()
            );
        }
        long longValue = ByteBuffer.wrap(value.getBytes(StandardCharsets.ISO_8859_1), 0, 8).getLong();
        symbolTable.get(instruction.result).getValue().setInt64(longValue);
    }

    public static void cvs(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        String value = symbolTable.get(instruction.op1).getValue().getString();
        if (value.length() != 4) {
            throw new PuffinBasicRuntimeError(
                    DATA_OUT_OF_RANGE,
                    "CVS$: value: " + value + " length must be 4, found: " + value.length()
            );
        }
        float floatValue = ByteBuffer.wrap(value.getBytes(StandardCharsets.ISO_8859_1), 0, 4).getFloat();
        symbolTable.get(instruction.result).getValue().setFloat32(floatValue);
    }

    public static void cvd(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        String value = symbolTable.get(instruction.op1).getValue().getString();
        if (value.length() != 8) {
            throw new PuffinBasicRuntimeError(
                    DATA_OUT_OF_RANGE,
                    "CVD$: value: " + value + " length must be 8, found: " + value.length()
            );
        }
        double doubleValue = ByteBuffer.wrap(value.getBytes(StandardCharsets.ISO_8859_1), 0, 8).getDouble();
        symbolTable.get(instruction.result).getValue().setFloat64(doubleValue);
    }

    public static void spacedlr(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        int len = symbolTable.get(instruction.op1).getValue().getInt32();
        byte[] bytes = new byte[len];
        for (int i = 0; i < len; i++) {
            bytes[i] = ' ';
        }
        String str = new String(bytes);
        symbolTable.get(instruction.result).getValue().setString(str);
    }

    public static void val(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var str = symbolTable.get(instruction.op1).getValue().getString();
        var result = symbolTable.get(instruction.result).getValue();
        try {
            result.setFloat64(Double.parseDouble(str));
        } catch (NumberFormatException e) {
            throw new PuffinBasicRuntimeError(
                    DATA_OUT_OF_RANGE,
                    "Failed to parse string: " + str + " as numeric"
            );
        }
    }

    public static void fnint(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var vEntry = symbolTable.get(instruction.op1);
        var v = vEntry.getValue();
        var result = symbolTable.get(instruction.result).getValue();
        switch (vEntry.getType().getAtomTypeId()) {
            case INT32:
                result.setInt32(v.getInt32());
                break;
            case INT64:
                result.setInt64(v.getInt64());
                break;
            case FLOAT:
                result.setFloat32((float) Math.floor(v.getFloat32()));
                break;
            case DOUBLE:
                result.setFloat64(Math.floor(v.getFloat64()));
                break;
            default:
                throwUnsupportedType(vEntry.getType().getAtomTypeId());
        }
    }

    public static void fix(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var vEntry = symbolTable.get(instruction.op1);
        var v = vEntry.getValue();
        var result = symbolTable.get(instruction.result).getValue();
        switch (vEntry.getType().getAtomTypeId()) {
            case INT32:
                result.setInt32(v.getInt32());
                break;
            case INT64:
                result.setInt64(v.getInt64());
                break;
            case FLOAT:
                result.setFloat32((float) (v.getFloat32() < 0 ? Math.ceil(v.getFloat32()) : Math.floor(v.getFloat32())));
                break;
            case DOUBLE:
                result.setFloat64(v.getFloat64() < 0 ? Math.ceil(v.getFloat64()) : Math.floor(v.getFloat64()));
                break;
            default:
                throwUnsupportedType(vEntry.getType().getAtomTypeId());
        }
    }

    public static void len(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var stEntry = symbolTable.get(instruction.op1);
        var value = stEntry.getValue();
        final int len;
        if (stEntry.getType().getTypeId() == ARRAY) {
            int axis = instruction.op2 != NULL_ID ? symbolTable.get(instruction.op2).getValue().getInt32() : 0;
            if (axis < 0 || axis >= value.getNumArrayDimensions()) {
                throw new PuffinBasicRuntimeError(
                        ILLEGAL_FUNCTION_PARAM,
                        "Bad axis=" + axis + ", #dims=" + value.getNumArrayDimensions()
                );
            }
            len = value.getArrayDimensions().getInt(axis);
        } else if (stEntry.getValue().hasLen()) {
            len = value.len();
        } else {
            throw new PuffinBasicRuntimeError(ILLEGAL_FUNCTION_PARAM,
                    "Bad LEN() call!");
        }
        symbolTable.get(instruction.result).getValue().setInt32(len);
    }

    public static void strdlr(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var numericEntry = symbolTable.get(instruction.op1);
        var numeric = numericEntry.getValue();
        var dt = numericEntry.getType().getAtomTypeId();
        final String str;
        if (dt == INT32) {
            str = Integer.toString(numeric.getInt32());
        } else if (dt == INT64) {
            str = Long.toString(numeric.getInt64());
        } else if (dt == FLOAT) {
            str = Float.toString(numeric.getFloat32());
        } else {
            str = Double.toString(numeric.getFloat64());
        }
        symbolTable.get(instruction.result).getValue().setString(str);
    }

    public static void hexdlr(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var numericEntry = symbolTable.get(instruction.op1);
        var numeric = numericEntry.getValue();
        var dt = numericEntry.getType().getAtomTypeId();
        final String str;
        if (dt == INT32) {
            str = Integer.toHexString(numeric.getInt32());
        } else if (dt == INT64) {
            str = Long.toHexString(numeric.getInt64());
        } else if (dt == FLOAT) {
            str = Float.toHexString(numeric.getFloat32());
        } else {
            str = Double.toHexString(numeric.getFloat64());
        }
        symbolTable.get(instruction.result).getValue().setString(str);
    }

    public static void octdlr(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var numericEntry = symbolTable.get(instruction.op1);
        var numeric = numericEntry.getValue();
        var dt = numericEntry.getType().getAtomTypeId();
        final String str;
        if (dt == INT32 || dt == FLOAT) {
            str = Integer.toOctalString(numeric.getInt32());
        } else {
            str = Long.toOctalString(numeric.getInt64());
        }
        symbolTable.get(instruction.result).getValue().setString(str);
    }

    public static void leftdlr(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var x = symbolTable.get(instruction.op1).getValue().getString();
        var n = symbolTable.get(instruction.op2).getValue().getInt32();
        String result;
        if (n < 0) {
            throw new PuffinBasicRuntimeError(
                    INDEX_OUT_OF_BOUNDS,
                    "LEFT$: expected n >= 0, actual=" + n
            );
        } else if (n == 0) {
            result = "";
        } else if (n >= x.length()) {
            result = x;
        } else {
            result = x.substring(0, n);
        }
        symbolTable.get(instruction.result).getValue().setString(result);
    }

    public static void rightdlr(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var x = symbolTable.get(instruction.op1).getValue().getString();
        var n = symbolTable.get(instruction.op2).getValue().getInt32();
        var xlen = x.length();
        String result;
        if (n < 0) {
            throw new PuffinBasicRuntimeError(
                    INDEX_OUT_OF_BOUNDS,
                    "RIGHT$: expected n >= 0, actual=" + n
            );
        } else if (n == 0) {
            result = "";
        } else if (n >= xlen) {
            result = x;
        } else {
            result = x.substring(xlen - n, xlen);
        }
        symbolTable.get(instruction.result).getValue().setString(result);
    }

    public static void instr(
            PuffinBasicSymbolTable symbolTable,
            Instruction instr0,
            Instruction instr) {
        var x = symbolTable.get(instr0.op1).getValue().getString();
        var y = symbolTable.get(instr0.op2).getValue().getString();
        var n = symbolTable.get(instr.op1).getValue().getInt32();
        var xlen = x.length();
        var ylen = y.length();
        int result;
        if (n <= 0) {
            throw new PuffinBasicRuntimeError(
                    INDEX_OUT_OF_BOUNDS,
                    "INSTR: expected n > 0, actual=" + n
            );
        } else if (n > xlen) {
            result = 0;
        } else if (ylen == 0) {
            result = n;
        } else {
            result = x.indexOf(y, n - 1) + 1;
        }
        symbolTable.get(instr.result).getValue().setInt32(result);
    }

    public static void middlr(
            PuffinBasicSymbolTable symbolTable,
            Instruction instr0,
            Instruction instr) {
        var x = symbolTable.get(instr0.op1).getValue().getString();
        var n = symbolTable.get(instr0.op2).getValue().getInt32();
        var m = symbolTable.get(instr.op1).getValue().getInt32();
        var xlen = x.length();
        String result;
        if (n <= 0) {
            throw new PuffinBasicRuntimeError(
                    INDEX_OUT_OF_BOUNDS,
                    "INSTR: expected n > 0, actual=" + n
            );
        } else if (n > xlen || m == 0) {
            result = "";
        } else {
            result = x.substring(n - 1, Math.min(xlen, n + m - 1));
        }
        symbolTable.get(instr.result).getValue().setString(result);
    }

    public static void rnd(Random random, PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        symbolTable.get(instruction.result).getValue().setFloat64(random.nextDouble());
    }

    public static void sgn(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var entry = symbolTable.get(instruction.op1);
        var numeric = entry.getValue();
        var dt = entry.getType().getAtomTypeId();
        int result;
        if (dt == INT32) {
            result = Integer.compare(numeric.getInt32(), 0);
        } else if (dt == INT64) {
            result = Long.compare(numeric.getInt64(), 0);
        } else if (dt == FLOAT) {
            result = Float.compare(numeric.getFloat32(), 0);
        } else {
            result = Double.compare(numeric.getFloat64(), 0);
        }
        if (result < 0) {
            result = -1;
        } else if (result > 0) {
            result = 1;
        }
        symbolTable.get(instruction.result).getValue().setInt32(result);
    }

    public static void timer(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var nowZoned = ZonedDateTime.now();
        var midnight = nowZoned.toLocalDate().atStartOfDay(nowZoned.getZone()).toInstant();
        var duration = Duration.between(midnight, Instant.now());
        var seconds = duration.getSeconds() + duration.getNano() / 1000_000_000.0;
        symbolTable.get(instruction.result).getValue().setFloat64(seconds);
    }

    public static void timerMillis(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var nowZoned = ZonedDateTime.now();
        var midnight = nowZoned.toLocalDate().atStartOfDay(nowZoned.getZone()).toInstant();
        var duration = Duration.between(midnight, Instant.now());
        var millis = TimeUnit.SECONDS.toMillis(duration.getSeconds()) + TimeUnit.NANOSECONDS.toMillis(duration.getNano());
        symbolTable.get(instruction.result).getValue().setInt64(millis);
    }

    public static void stringdlr(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var n = symbolTable.get(instruction.op1).getValue().getInt32();
        var jOrxdlrEntry = symbolTable.get(instruction.op2);
        var jOrxdlr = jOrxdlrEntry.getValue();
        String c;
        if (jOrxdlrEntry.getType().getAtomTypeId() == STRING) {
            if (jOrxdlr.getString().isEmpty()) {
                throw new PuffinBasicRuntimeError(
                        ILLEGAL_FUNCTION_PARAM,
                        "STRING$: expected len(x%) > 0, actual=0"
                );
            }
            c = jOrxdlr.getString().substring(0, 1);
        } else {
            int j = jOrxdlr.getInt32();
            if (j < 0 || j > 255) {
                throw new PuffinBasicRuntimeError(
                        ILLEGAL_FUNCTION_PARAM,
                        "STRING$: expected 0 <= j <= 255, actual=" + j
                );
            }
            c = String.valueOf((char) jOrxdlr.getInt32());
        }
        String result;
        if (n < 0) {
            throw new PuffinBasicRuntimeError(
                    INDEX_OUT_OF_BOUNDS,
                    "STRING$: expected n >= 0, actual=" + n
            );
        } else if (n == 0) {
            result = "";
        } else {
            result = Strings.repeat(c, n);
        }
        symbolTable.get(instruction.result).getValue().setString(result);
    }

    public static void loc(
            PuffinBasicFiles files,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
        var fileNumber = symbolTable.get(instruction.op1).getValue().getInt32();
        var loc = files.get(fileNumber).getCurrentRecordNumber();
        symbolTable.get(instruction.result).getValue().setInt32(loc);
    }

    public static void lof(
            PuffinBasicFiles files,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
        var fileNumber = symbolTable.get(instruction.op1).getValue().getInt32();
        var lof = files.get(fileNumber).getFileSizeInBytes();
        symbolTable.get(instruction.result).getValue().setInt64(lof);
    }

    public static void eof(
            PuffinBasicFiles files,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
        var fileNumber = symbolTable.get(instruction.op1).getValue().getInt32();
        var eof = files.get(fileNumber).eof();
        symbolTable.get(instruction.result).getValue().setInt32(eof ? -1 : 0);
    }

    public static void inputdlr(
            PuffinBasicFiles files,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
        var x = symbolTable.get(instruction.op1).getValue().getInt32();
        var fileNumber = symbolTable.get(instruction.op2).getValue().getInt32();

        byte[] read;
        if (fileNumber < 0) {
            read = files.sys.readBytes(x);
        } else {
            throw new UnsupportedOperationException();
        }
        symbolTable.get(instruction.result).getValue().setString(new String(read));
    }

    public static void environdlr(
            Environment env,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
        var envvar = symbolTable.get(instruction.op1).getValue().getString();
        var result = env.get(envvar);
        symbolTable.get(instruction.result).getValue().setString(result);
    }

    static void splitdlr(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var str = symbolTable.get(instruction.op1).getValue().getString();
        var regex = symbolTable.get(instruction.op2).getValue().getString();
        String[] tokens = str.split(regex);
        STRING.copyArray(tokens, symbolTable.get(instruction.result).getValue());
    }

    static void ltrimdlr(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var s = symbolTable.get(instruction.op1).getValue().getString();
        int i = 0;
        while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        String ltrim = s.substring(i);
        symbolTable.get(instruction.result).getValue().setString(ltrim);
    }

    static void rtrimdlr(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var s = symbolTable.get(instruction.op1).getValue().getString();
        int i = s.length()-1;
        while (i >= 0 && Character.isWhitespace(s.charAt(i))) {
            i--;
        }
        String rtrim = s.substring(0,i+1);
        symbolTable.get(instruction.result).getValue().setString(rtrim);
    }

    static void throwUnsupportedType(PuffinBasicAtomTypeId type) {
        throw new PuffinBasicInternalError(
                "Data type " + type + " is not supported"
        );
    }
}
