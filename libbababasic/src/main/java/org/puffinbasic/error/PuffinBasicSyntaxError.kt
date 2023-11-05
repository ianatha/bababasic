package org.puffinbasic.error

class PuffinBasicSyntaxError(
    message: String?,
    val row: Int? = null,
    val col: Int? = null,
) : PuffinError(message)