package org.puffinbasic.error

import org.puffinbasic.runtime.BabaSystem

class PuffinBasicSemanticError(
    errorCode: ErrorCode, line: String, message: String
) : PuffinError(
    "[" + errorCode + "] " + message + BabaSystem.lineSeparator() +
            "LINE:" + BabaSystem.lineSeparator() +
            line
) {
    enum class ErrorCode {
        ARRAY_VARIABLE_CANNOT_START_WITH_FN, SCALAR_VARIABLE_CANNOT_BE_INDEXED, BAD_NUMBER, BAD_ASSIGNMENT, DATA_TYPE_MISMATCH, INSUFFICIENT_UDF_ARGS, WEND_WITHOUT_WHILE, WHILE_WITHOUT_WEND, NEXT_WITHOUT_FOR, FOR_WITHOUT_NEXT, BAD_ARGUMENT, NOT_DEFINED, MISMATCHED_ENDIF, MISMATCHED_ELSE_BEGIN, BAD_FUNCTION_DEF
    }
}