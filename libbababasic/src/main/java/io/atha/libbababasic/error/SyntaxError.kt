package io.atha.libbababasic.error

class SyntaxError(
    message: String?,
    val row: Int? = null,
    val col: Int? = null,
) : BBError(message)