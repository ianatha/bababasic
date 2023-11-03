package org.puffinbasic.error

import org.puffinbasic.parser.PuffinBasicIR
import org.puffinbasic.runtime.BabaSystem

class PuffinBasicRuntimeError : PuffinError {
    val errorCode: ErrorCode

    constructor(errorCode: ErrorCode, message: String) : super(
        "[$errorCode] $message"
    ) {
        this.errorCode = errorCode
    }

    constructor(
        cause: PuffinBasicRuntimeError,
        instruction: PuffinBasicIR.Instruction,
        line: String
    ) : super(
        cause.message + BabaSystem.lineSeparator()
                + "Line: " + instruction.inputRef + BabaSystem.lineSeparator()
                + line, cause
    ) {
        errorCode = cause.errorCode
    }

    constructor(
        cause: Exception,
        instruction: PuffinBasicIR.Instruction,
        line: String
    ) : super(
        cause.message + BabaSystem.lineSeparator()
                + "Line: " + instruction.inputRef + BabaSystem.lineSeparator()
                + line, cause
    ) {
        errorCode = ErrorCode.UNKNOWN
    }

    enum class ErrorCode {
        UNKNOWN, ARRAY_INDEX_OUT_OF_BOUNDS, INDEX_OUT_OF_BOUNDS, DIVISION_BY_ZERO, ILLEGAL_FUNCTION_PARAM, DATA_OUT_OF_RANGE, IO_ERROR, DATA_TYPE_MISMATCH, ILLEGAL_FILE_ACCESS, OUT_OF_DATA, GRAPHICS_ERROR, INTERRUPTED_ERROR, NOT_INITIALIZED, DUPLICATE_LABEL, BAD_FIELD, MISSING_STRUCT, BAD_FUNCTION_CALL, IMPORT_ERROR
    }
}