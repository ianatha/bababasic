package org.puffinbasic.error;

public class PuffinBasicSemanticError extends RuntimeException {

    public PuffinBasicSemanticError(
            ErrorCode errorCode, String line, String message) {
        super(
                "[" + errorCode + "] " + message + System.lineSeparator() +
                        "LINE:" + System.lineSeparator() +
                        line
        );
    }

    public enum ErrorCode {
        ARRAY_VARIABLE_CANNOT_STARTWITH_FN,
        SCALAR_VARIABLE_CANNOT_BE_INDEXED,
        BAD_NUMBER,
        BAD_ASSIGNMENT,
        DATA_TYPE_MISMATCH,
        INSUFFICIENT_UDF_ARGS,
        WEND_WITHOUT_WHILE,
        WHILE_WITHOUT_WEND,
        NEXT_WITHOUT_FOR,
        FOR_WITHOUT_NEXT,
        BAD_ARGUMENT,
        NOT_DEFINED,
        MISMATCHED_ENDIF,
        MISMATCHED_ELSEBEGIN,
        BAD_FUNCTION_DEF,
    }
}
