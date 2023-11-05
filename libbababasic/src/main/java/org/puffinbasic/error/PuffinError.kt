package org.puffinbasic.error

abstract class PuffinError(
    message: String?,
    cause: Throwable? = null,
    enableSuppression: Boolean = false,
    writableStackTrace: Boolean = true,
) : RuntimeException(message, cause, enableSuppression, writableStackTrace)