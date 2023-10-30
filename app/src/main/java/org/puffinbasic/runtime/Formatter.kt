package org.puffinbasic.runtime

import org.puffinbasic.error.PuffinBasicInternalError
import org.puffinbasic.error.PuffinBasicRuntimeError
import java.text.DecimalFormat
import java.util.Arrays

object Formatter {
    fun getFormatter(format: String): IFormatter {
        return if (format == "!") {
            FirstCharFormatter()
        } else if (format == "&") {
            VarLenStringFormatter()
        } else if (format.startsWith("\\") && format.endsWith("\\")) {
            NSpacesFormatter(format)
        } else {
            NumberFormatter(format)
        }
    }

    @JvmStatic
    fun printFormatInt32(value: Int): String {
        return if (value < 0) "$value " else " $value "
    }

    @JvmStatic
    fun printFormatInt64(value: Long): String {
        return if (value < 0) "$value " else " $value "
    }

    @JvmStatic
    fun printFormatFloat32(value: Float): String {
        return if (value < 0) "$value " else " $value "
    }

    @JvmStatic
    fun printFormatFloat64(value: Double): String {
        return if (value < 0) "$value " else " $value "
    }

    @JvmStatic
    fun printFormatString(value: String): String {
        return value
    }

    @JvmStatic
    fun writeFormatInt32(value: Int): String {
        return value.toString()
    }

    @JvmStatic
    fun writeFormatInt64(value: Long): String {
        return value.toString()
    }

    @JvmStatic
    fun writeFormatFloat32(value: Float): String {
        return value.toString()
    }

    @JvmStatic
    fun writeFormatFloat64(value: Double): String {
        return value.toString()
    }

    @JvmStatic
    fun writeFormatString(value: String): String {
        var value = value
        if (value.contains("\"")) {
            // Expects unescaped quotes
            value = value.replace("\"".toRegex(), "\\\"")
        }
        return "\"" + value + "\""
    }

    interface IFormatter {
        fun format(o: Any): String
        fun supportsNumeric(): Boolean
        fun supportsString(): Boolean
    }

    class FormatterCache {
        private val cache: MutableMap<String, IFormatter> = mutableMapOf()

        operator fun get(format: String): IFormatter {
            return cache.computeIfAbsent(format) { obj: String -> getFormatter(obj) }
        }
    }

    /**
     * Examples:
     * <pre>
     * **$##.## formats -21.2 to -$**21.20
    </pre> *
     * <pre>
     * '#' specifies 1 digit position.
     *
     * '.' specifies decimal point.
     *
     * ',' adds comma in formatted number.
     *
     * First optional prefix:
     * '+' prefix will add a sign prefix.
     * '-' prefix will add a minus prefix for negative number.
     *
     * Next optional prefix:
     * '**' causes leading spaces to be filled with '*' and specifies 2 more digit positions.
     * '**$' adds dollar prefix, causes leading spaces to be filled with '*' and
     * specifies 2 more digit positions.
     * '$$' add dollar prefix and specifies 1 more difit position.
     *
     * First optional suffix:
     * '+' suffix will add a sign suffix.
     * '-' suffix will add a minus suffix for negative number.
     *
     * Next optional suffix:
     * '^^^^' suffix indicates scientific notation.
     *
    </pre> *
     */
    class NumberFormatter(format: String) : IFormatter {
        private val decimalFormat: DecimalFormat
        private var scientific = false
        private var signPrefix = false
        private var signSuffix = false
        private var minusSuffix = false
        private val shouldFill: Boolean
        private val dollar: Boolean

        init {
            // Handle prefix '+' or '-'
            var format = format
            if (format.startsWith("+")) {
                signPrefix = true
                format = format.substring(1)
            } else if (format.startsWith("-")) {
                signPrefix = false
                format = format.substring(1)
            } else {
                signPrefix = false
            }

            // Handle suffix '+' or '-'
            if (format.endsWith("+")) {
                signSuffix = true
                minusSuffix = false
                format = format.substring(0, format.length - 1)
            } else if (format.endsWith("-")) {
                signSuffix = false
                minusSuffix = true
                format = format.substring(0, format.length - 1)
            } else {
                signSuffix = false
                minusSuffix = false
            }

            // Handle scientific notation
            if (format.endsWith("^^^^")) {
                format = format.replace("^^^^", "E00")
                scientific = true
            } else {
                scientific = false
            }

            // Replace # with 0 so that result is filled with 0 prefixes
            format = format.replace("#", "0")

            // Handle **, **$, and $$ prefix
            var dollar = false
            var numToFill = 0
            var removeFromFormat = 0
            if (format.startsWith("**$")) {
                numToFill = 2
                removeFromFormat = 3
                dollar = true
            } else if (format.startsWith("**")) {
                numToFill = 2
                removeFromFormat = 2
            } else if (format.startsWith("$$")) {
                numToFill = 1
                removeFromFormat = 2
                dollar = true
            }
            if (removeFromFormat > 0) {
                format = format.substring(removeFromFormat)
            }
            this.dollar = dollar
            shouldFill = numToFill > 0
            if (numToFill > 0) {
                val b = ByteArray(numToFill)
                Arrays.fill(b, 0, numToFill, '0'.code.toByte())
                format = String(b) + format
            }
            decimalFormat = DecimalFormat(format)
        }

        override fun format(o: Any): String {
            return when (o) {
                is Long -> format(o)
                is Double -> format(o)
                else -> throw PuffinBasicInternalError(
                    NumberFormatter::class.java.simpleName
                            + ": data type mismatch: " + o.javaClass
                )
            }
        }

        override fun supportsNumeric(): Boolean {
            return true
        }

        override fun supportsString(): Boolean {
            return false
        }

        fun format(value: Long): String {
            var value = value
            val isNegative = value < 0
            if (isNegative) {
                value = -value
            }
            return format(decimalFormat.format(value), isNegative)
        }

        fun format(value: Double): String {
            var value = value
            val isNegative = value < 0
            if (isNegative) {
                value = -value
            }
            return format(decimalFormat.format(value), isNegative)
        }

        private fun format(result: String, isNegative: Boolean): String {
            // Handle scientific
            var result = result
            if (scientific) {
                if (!result.contains("E-")) {
                    result = result.replace("E", "E+")
                }
            }

            // If ** or **$ is set, replace leading 0s with *s.
            // If ** or **$ is not set, remove leading 0s.
            val dest = ByteArray(result.length)
            var checkForLeadingZero = true
            var fillToLoc = -1
            for (i in result.indices) {
                var c = result[i]
                if (c in '1'..'9') {
                    checkForLeadingZero = false
                }
                if (checkForLeadingZero) {
                    if (c == '0') {
                        c = '*'
                        fillToLoc = i
                    }
                }
                // Copy char to dest
                dest[i] = c.code.toByte()
            }
            if (fillToLoc >= 0) {
                result = if (shouldFill) String(dest) else String(dest).substring(fillToLoc + 1)
                if (result.startsWith(",")) {
                    result = result.substring(1)
                }
            }

            // Add $ prefix
            if (dollar) {
                result = "$$result"
            }
            // Add sign prefix
            if (signPrefix) {
                result = (if (isNegative) '-' else '+').toString() + result
            }
            // Add minus prefix
            if (isNegative && !minusSuffix && !result.startsWith("-")) {
                result = "-$result"
            }
            // Add sign suffix
            if (signSuffix) {
                result += if (isNegative) '-' else '+'
            }
            // Add minus suffix
            if (isNegative && minusSuffix) {
                result = "$result-"
            }
            return result
        }
    }

    class FirstCharFormatter : IFormatter {
        override fun format(o: Any): String {
            return if (o is String) {
                if (o.isEmpty()) "" else o.substring(0, 1)
            } else {
                throw PuffinBasicInternalError(
                    FirstCharFormatter::class.java.simpleName
                            + ": data type mismatch: " + o.javaClass
                )
            }
        }

        override fun supportsNumeric(): Boolean {
            return false
        }

        override fun supportsString(): Boolean {
            return true
        }
    }

    class NSpacesFormatter(format: String) : IFormatter {
        private var length = 0

        init {
            if (format.length >= 2) {
                length = format.length
                val spaces = format.substring(1, format.length - 1)
                for (i in spaces.indices) {
                    if (spaces[i] != ' ') {
                        throw PuffinBasicRuntimeError(
                            PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM,
                            "Expected spaces in n+2 spaces formatter, but found: " + spaces[i]
                        )
                    }
                }
            } else {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM,
                    "Bad n+2 formatter string: $format"
                )
            }
        }

        override fun format(o: Any): String {
            return if (o is String) {
                val strlen = o.length
                if (strlen > length) {
                    o.substring(0, length)
                } else {
                    val bytes = ByteArray(length)
                    System.arraycopy(o.toByteArray(), 0, bytes, 0, o.length)
                    Arrays.fill(bytes, o.length, length, ' '.code.toByte())
                    String(bytes)
                }
            } else {
                throw PuffinBasicInternalError(
                    FirstCharFormatter::class.java.simpleName
                            + ": data type mismatch: " + o.javaClass
                )
            }
        }

        override fun supportsNumeric(): Boolean {
            return false
        }

        override fun supportsString(): Boolean {
            return true
        }
    }

    class VarLenStringFormatter : IFormatter {
        override fun format(o: Any): String {
            return if (o is String) {
                o
            } else {
                throw PuffinBasicInternalError(
                    FirstCharFormatter::class.java.simpleName
                            + ": data type mismatch: " + o.javaClass
                )
            }
        }

        override fun supportsNumeric(): Boolean {
            return false
        }

        override fun supportsString(): Boolean {
            return true
        }
    }
}