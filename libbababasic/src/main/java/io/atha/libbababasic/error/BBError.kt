package io.atha.libbababasic.error

abstract class BBError(
    message: String?,
    cause: Throwable? = null,
    enableSuppression: Boolean = false,
    writableStackTrace: Boolean = true,
) : RuntimeException(message, cause, enableSuppression, writableStackTrace)