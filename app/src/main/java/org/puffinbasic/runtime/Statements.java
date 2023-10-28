package org.puffinbasic.runtime;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.puffinbasic.domain.PuffinBasicSymbolTable;
import org.puffinbasic.domain.STObjects;
import org.puffinbasic.domain.STObjects.STEntry;
import org.puffinbasic.domain.STObjects.STRef;
import org.puffinbasic.domain.STObjects.STValue;
import org.puffinbasic.domain.STObjects.STVariable;
import org.puffinbasic.error.PuffinBasicInternalError;
import org.puffinbasic.error.PuffinBasicRuntimeError;
import org.puffinbasic.file.PuffinBasicFile;
import org.puffinbasic.file.PuffinBasicFile.FileAccessMode;
import org.puffinbasic.file.PuffinBasicFile.FileOpenMode;
import org.puffinbasic.file.PuffinBasicFile.LockMode;
import org.puffinbasic.file.PuffinBasicFiles;
import org.puffinbasic.parser.PuffinBasicIR.Instruction;
import org.puffinbasic.runtime.Formatter.FormatterCache;

import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import static org.puffinbasic.domain.PuffinBasicSymbolTable.NULL_ID;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.DOUBLE;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.FLOAT;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.INT64;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.STRING;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.DATA_OUT_OF_RANGE;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.DATA_TYPE_MISMATCH;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.INDEX_OUT_OF_BOUNDS;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.IO_ERROR;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.OUT_OF_DATA;

public class Statements {

    public static void sleep(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        int millis = symbolTable.get(instruction.op1).getValue().getInt32();
        if (millis < 0) {
            throw new PuffinBasicRuntimeError(
                    DATA_OUT_OF_RANGE,
                    "Sleep time millis cannot be less than 0."
            );
        }

        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(millis));
    }

    public static final class ReadData {
        private final List<STEntry> data;
        private int cursor;

        ReadData(List<STEntry> data) {
            this.data = data;
        }

        public STEntry next() {
            if (cursor < data.size()) {
                return data.get(cursor++);
            } else {
                throw new PuffinBasicRuntimeError(
                        OUT_OF_DATA,
                        "Out of data!"
                );
            }
        }

        public void restore() {
            cursor = 0;
        }
    }

    public static void print(
            PrintBuffer printBuffer,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        printBuffer.appendAtCursor(symbolTable.get(instruction.op1).getValue().printFormat());
    }

    public static void write(
            PrintBuffer printBuffer,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        printBuffer.appendAtCursor(symbolTable.get(instruction.op1).getValue().writeFormat());
    }

    public static void printusing(
            FormatterCache cache,
            PrintBuffer printBuffer,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var format = symbolTable.get(instruction.op1).getValue().getString();
        var formatter = cache.get(format);
        var entry = symbolTable.get(instruction.op2);
        var value = entry.getValue();
        final String result;
        switch (entry.getType().getAtomTypeId()) {
            case INT32:
            case INT64:
                if (!formatter.supportsNumeric()) {
                    throw new PuffinBasicRuntimeError(
                            DATA_TYPE_MISMATCH,
                            "String formatter doesn't work with numeric type: " + format
                    );
                }
                result = formatter.format(value.getInt64()) + " ";
                break;
            case FLOAT:
            case DOUBLE:
                if (!formatter.supportsNumeric()) {
                    throw new PuffinBasicRuntimeError(
                            DATA_TYPE_MISMATCH,
                            "String formatter doesn't work with numeric type: " + format
                    );
                }
                result = formatter.format(value.getFloat64()) + " ";
                break;
            case STRING:
                if (!formatter.supportsString()) {
                    throw new PuffinBasicRuntimeError(
                            DATA_TYPE_MISMATCH,
                            "Numeric formatter doesn't work with string type: " + format
                    );
                }
                result = formatter.format(value.getString());
                break;
            default:
                throw new PuffinBasicInternalError(
                        "Unsupported data type: " + entry.getType().getAtomTypeId()
                );
        }
        printBuffer.appendAtCursor(result);
    }

    public static void flush(
            PuffinBasicFiles files,
            PrintBuffer printBuffer,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        if (instruction.op1 == NULL_ID) {
            printBuffer.flush(files.sys);
        } else {
            var fileNumber = symbolTable.get(instruction.op1).getValue().getInt32();
            printBuffer.flush(files.get(fileNumber));
        }
    }

    public static void swap(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var op1Entry = symbolTable.get(instruction.op1);
        var op1 = op1Entry.getValue();
        var op2Entry = symbolTable.get(instruction.op2);
        var op2 = op2Entry.getValue();
        var dt1 = op1Entry.getType().getAtomTypeId();
        var dt2 = op2Entry.getType().getAtomTypeId();

        if (dt1 == STRING && dt2 == STRING) {
            var tmp = op1.getString();
            op1.setString(op2.getString());
            op2.setString(tmp);
        } else {
            if (dt1 == DOUBLE || dt2 == DOUBLE) {
                var tmp = op1.getFloat64();
                op1.setFloat64(op2.getFloat64());
                op2.setFloat64(tmp);
            } else if (dt1 == INT64 || dt2 == INT64) {
                var tmp = op1.getInt64();
                op1.setInt64(op2.getInt64());
                op2.setInt64(tmp);
            } else if (dt1 == FLOAT || dt2 == FLOAT) {
                var tmp = op1.getFloat32();
                op1.setFloat32(op2.getFloat32());
                op2.setFloat32(tmp);
            } else {
                var tmp = op1.getInt32();
                op1.setInt32(op2.getInt32());
                op2.setInt32(tmp);
            }
        }
    }

    public static void lset(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var destEntry = symbolTable.get(instruction.op1).getValue();

        var value = symbolTable.get(instruction.op2).getValue().getString();
        var valLen = value.length();

        var destLen = destEntry.getFieldLength();
        if (destLen == 0) {
            destLen = destEntry.getString().length();
            destEntry.setFieldLength(destLen);
        }

        final String result;
        if (valLen > destLen) {
            result = value.substring(0, destLen);
        } else if (valLen == destLen) {
            result = value;
        } else {
            byte[] bytes = new byte[destLen];
            System.arraycopy(value.getBytes(), 0, bytes, 0, valLen);
            java.util.Arrays.fill(bytes, valLen, destLen, (byte) ' ');
            result = new String(bytes);
        }
        destEntry.setString(result);
    }

    public static void rset(PuffinBasicSymbolTable symbolTable, Instruction instruction) {
        var destEntry = symbolTable.get(instruction.op1).getValue();

        var value = symbolTable.get(instruction.op2).getValue().getString();
        var valLen = value.length();

        var destLen = destEntry.getFieldLength();
        if (destLen == 0) {
            destLen = destEntry.getString().length();
            destEntry.setFieldLength(destLen);
        }

        final String result;
        if (valLen > destLen) {
            result = value.substring(0, destLen);
        } else if (valLen == destLen) {
            result = value;
        } else {
            byte[] bytes = new byte[destLen];
            int offset = destLen - valLen;
            Arrays.fill(bytes, 0, offset, (byte) ' ');
            System.arraycopy(value.getBytes(), 0, bytes, offset, valLen);
            result = new String(bytes);
        }
        destEntry.setString(result);
    }

    public static void open(
            PuffinBasicFiles files,
            PuffinBasicSymbolTable symbolTable,
            Instruction instr_fn_fn_0,
            Instruction instr_om_am_1,
            Instruction instr_lm_rl_2)
    {
        var fileName = symbolTable.get(instr_fn_fn_0.op1).getValue().getString();
        var fileNumber = symbolTable.get(instr_fn_fn_0.op2).getValue().getInt32();
        var fileOpenMode = FileOpenMode.valueOf(
                symbolTable.get(instr_om_am_1.op1).getValue().getString()
        );
        var fileAccessMode = FileAccessMode.valueOf(
                symbolTable.get(instr_om_am_1.op2).getValue().getString()
        );
        var fileLockMode = LockMode.valueOf(
                symbolTable.get(instr_lm_rl_2.op1).getValue().getString()
        );
        var recordLen = symbolTable.get(instr_lm_rl_2.op2).getValue().getInt32();

        files.open(
                fileNumber,
                fileName,
                fileOpenMode,
                fileAccessMode,
                recordLen
        );
    }

    public static void closeAll(PuffinBasicFiles files) {
        files.closeAll();
    }

    public static void close(
            PuffinBasicFiles files,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var fileNumber = symbolTable.get(instruction.op1).getValue().getInt32();
        files.get(fileNumber).close();
    }

    public static void field(
            PuffinBasicFiles files,
            PuffinBasicSymbolTable symbolTable,
            List<Instruction> fields,
            Instruction instruction)
    {
        var varList = new IntArrayList(fields.size());
        for (var instrI : fields) {
            var recordPartLen = symbolTable.get(instrI.op2).getValue().getInt32();
            symbolTable.get(instrI.op1).getValue().setFieldLength(recordPartLen);
            varList.add(instrI.op1);
        }
        var fileNumber = symbolTable.get(instruction.op1).getValue().getInt32();
        files.get(fileNumber).setFieldParams(
                symbolTable,
                varList
        );
    }

    public static void putf(
            PuffinBasicFiles files,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var fileNumber = symbolTable.get(instruction.op1).getValue().getInt32();
        Integer recordNumber = instruction.op2 == NULL_ID
                ? null
                : symbolTable.get(instruction.op2).getValue().getInt32();
        files.get(fileNumber).put(recordNumber, symbolTable);
    }

    public static void getf(
            PuffinBasicFiles files,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var fileNumber = symbolTable.get(instruction.op1).getValue().getInt32();
        Integer recordNumber = instruction.op2 == NULL_ID
                ? null
                : symbolTable.get(instruction.op2).getValue().getInt32();
        files.get(fileNumber).get(recordNumber, symbolTable);
    }

    public static void randomize(
            Random random,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var seed = symbolTable.get(instruction.op1).getValue().getInt64();
        random.setSeed(seed);
    }

    public static void randomizeTimer(Random random) {
        var seed = Instant.now().getEpochSecond();
        random.setSeed(seed);
    }

    public static void input(
            PuffinBasicFiles files,
            PuffinBasicSymbolTable symbolTable,
            List<Instruction> instructions,
            Instruction instruction)
    {
        boolean printPrompt = false;
        if (instruction.op1 != NULL_ID) {
            var prompt = symbolTable.get(instruction.op1).getValue().getString();
            files.sys.print(prompt);
            printPrompt = true;
        }
        final PuffinBasicFile file;
        if (instruction.op2 != NULL_ID) {
            var fileNumber = symbolTable.get(instruction.op2).getValue().getInt32();
            file = files.get(fileNumber);
        } else {
            file = files.sys;
        }

        CSVRecord record = null;
        boolean retry = false;
        do {
            if (retry) {
                if (printPrompt) {
                    System.err.println("?Redo from start");
                } else {
                    throw new PuffinBasicRuntimeError(
                            IO_ERROR,
                            "Record mismatch: expected=" + instructions.size()
                                    + ", found in file=" + record.size()
                                    +", record: " + record
                    );
                }
            }
            CSVParser parser;
            try {
                parser = CSVParser.parse(file.readLine(), CSVFormat.DEFAULT);
            } catch (IOException e) {
                throw new PuffinBasicRuntimeError(
                        IO_ERROR,
                        "Failed to read inputs, error: " + e.getMessage()
                );
            }
            record = parser.iterator().next();
            retry = true;
        } while (record.size() != instructions.size());

        int i = 0;
        for (var instr0 : instructions) {
            var entry = symbolTable.get(instr0.op1);
            var value = entry.getValue();
            switch (entry.getType().getAtomTypeId()) {
                case INT32:
                    value.setInt32(Integer.parseInt(record.get(i).trim()));
                    break;
                case INT64:
                    value.setInt64(Long.parseLong(record.get(i).trim()));
                    break;
                case FLOAT:
                    value.setFloat32(Float.parseFloat(record.get(i).trim()));
                    break;
                case DOUBLE:
                    value.setFloat64(Double.parseDouble(record.get(i).trim()));
                    break;
                case STRING:
                    value.setString(record.get(i).trim());
                    break;
            }
            ++i;
        }
    }

    public static void lineinput(
            PuffinBasicFiles files,
            PuffinBasicSymbolTable symbolTable,
            Instruction instr0,
            Instruction instruction)
    {
        if (instruction.op1 != NULL_ID) {
            var prompt = symbolTable.get(instruction.op1).getValue().getString();
            if (!prompt.isEmpty()) {
                files.sys.print(prompt);
            }
        }
        final PuffinBasicFile file;
        if (instruction.op2 != NULL_ID) {
            var fileNumber = symbolTable.get(instruction.op2).getValue().getInt32();
            file = files.get(fileNumber);
        } else {
            file = files.sys;
        }
        symbolTable.get(instr0.op1).getValue().setString(file.readLine());
    }

    public static void middlr(
            PuffinBasicSymbolTable symbolTable,
            Instruction instr0,
            Instruction instr) {
        var dest = symbolTable.get(instr0.op1).getValue();
        var n = symbolTable.get(instr0.op2).getValue().getInt32();
        var m = symbolTable.get(instr.op1).getValue().getInt32();
        var replacement = symbolTable.get(instr.op2).getValue().getString();
        String varValue = dest.getString();
        var varlen = varValue.length();
        String result;
        if (n <= 0) {
            throw new PuffinBasicRuntimeError(
                    INDEX_OUT_OF_BOUNDS,
                    "INSTR: expected n > 0, actual=" + n
            );
        } else if (n > varlen) {
            result = varValue;
        } else {
            if (m == -1 || m > replacement.length()) {
                m = replacement.length();
            }
            result = varValue.substring(0, n - 1)
                    + replacement.substring(0, Math.min(m, varlen - n + 1))
                    + varValue.substring(Math.min(n + m - 1, varlen - 1));
        }
        dest.setString(result);
    }

    public static void read(
            ReadData readData,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction)
    {
        var variable = symbolTable.getVariable(instruction.op1);
        var data = readData.next();
        Types.assertBothStringOrNumeric(variable.getType().getAtomTypeId(),
                data.getType().getAtomTypeId(),
                () -> "Read Data mismatch for variable: "
                        + variable
                        + " and data: "
                        + data.getValue().printFormat()
        );
        variable.getValue().assign(data.getValue());
    }

    static void createInstance(
            PuffinBasicSymbolTable symbolTable, Instruction instruction)
    {
        var entry = (STVariable) symbolTable.get(instruction.op1);
        entry.createAndSetInstance(symbolTable);
    }

    static void structLValue(
            PuffinBasicSymbolTable symbolTable,
            List<Instruction> params,
            Instruction instruction)
    {
        var root = (STObjects.STStruct) symbolTable.get(instruction.op1).getValue();
        for (int i = 0; i < params.size() - 1; i++) {
            var childId = symbolTable.get(params.get(i).op1).getValue().getInt32();
            var valueId = root.getMember(childId);
            root = (STObjects.STStruct) symbolTable.get(valueId).getValue();
        }
        var childId = symbolTable.get(params.get(params.size() - 1).op1).getValue().getInt32();
        var valueId = root.getMember(childId);
        ((STRef) symbolTable.get(instruction.result)).setRef(symbolTable.get(valueId));
    }

    static void memberFuncCall(
            PuffinBasicSymbolTable symbolTable,
            List<Instruction> params,
            Instruction instruction)
    {
        STValue[] funcParams = new STValue[params.size()];
        var object = symbolTable.get(instruction.op1).getValue();
        var funcName = symbolTable.get(instruction.op2).getValue().getString();
        STValue result = symbolTable.get(instruction.result).getValue();

        for (int i = 0; i < params.size(); i++) {
            funcParams[i] = symbolTable.get(params.get(i).op1).getValue();
        }

        object.call(funcName, funcParams, result);
    }

    static void structMemberRef(
            PuffinBasicSymbolTable symbolTable,
            List<Instruction> params,
            Instruction instruction)
    {
        var root = (STObjects.STStruct) symbolTable.get(instruction.op1).getValue();
        for (int i = 0; i < params.size() -1; i++) {
            var childId = symbolTable.get(params.get(i).op1).getValue().getInt32();
            var valueId = root.getMember(childId);
            root = (STObjects.STStruct) symbolTable.get(valueId).getValue();
        }
        var childId = symbolTable.get(params.get(params.size() - 1).op1).getValue().getInt32();
        var valueId = root.getMember(childId);
        symbolTable.get(instruction.result).getValue().assign(symbolTable.get(valueId).getValue());
    }
}
