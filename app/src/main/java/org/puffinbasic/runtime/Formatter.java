package org.puffinbasic.runtime;

import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM;

import org.puffinbasic.error.PuffinBasicInternalError;
import org.puffinbasic.error.PuffinBasicRuntimeError;

import java.text.DecimalFormat;
import java.util.Arrays;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

public class Formatter {

    public static IFormatter getFormatter(String format) {
        if (format.equals("!")) {
            return new FirstCharFormatter();
        } else if (format.equals("&")) {
            return new VarLenStringFormatter();
        } else if (format.startsWith("\\") && format.endsWith("\\")) {
            return new NSpacesFormatter(format);
        } else {
            return new NumberFormatter(format);
        }
    }

    public static String printFormatInt32(int value) {
        return value < 0 ? value + " " : " " + value + " ";
    }

    public static String printFormatInt64(long value) {
        return value < 0 ? value + " " : " " + value + " ";
    }

    public static String printFormatFloat32(float value) {
        return value < 0 ? value + " " : " " + value + " ";
    }

    public static String printFormatFloat64(double value) {
        return value < 0 ? value + " " : " " + value + " ";
    }

    public static String printFormatString(String value) {
        return value;
    }

    public static String writeFormatInt32(int value) {
        return String.valueOf(value);
    }

    public static String writeFormatInt64(long value) {
        return String.valueOf(value);
    }

    public static String writeFormatFloat32(float value) {
        return String.valueOf(value);
    }

    public static String writeFormatFloat64(double value) {
        return String.valueOf(value);
    }

    public static String writeFormatString(String value) {
        if (value.contains("\"")) {
            // Expects unescaped quotes
            value = value.replaceAll("\"", "\\\"");
        }
        return "\"" + value + "\"";
    }

    public interface IFormatter {
        String format(Object o);

        boolean supportsNumeric();

        boolean supportsString();
    }

    public static final class FormatterCache {
        private final Object2ObjectMap<String, IFormatter> cache;

        public FormatterCache() {
            cache = new Object2ObjectOpenHashMap<>();
        }

        public IFormatter get(String format) {
            return cache.computeIfAbsent(format, Formatter::getFormatter);
        }
    }

    /**
     * Examples:
     * <pre>
     *     **$##.## formats -21.2 to -$**21.20
     * </pre>
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
     *       specifies 2 more digit positions.
     * '$$' add dollar prefix and specifies 1 more difit position.
     *
     * First optional suffix:
     * '+' suffix will add a sign suffix.
     * '-' suffix will add a minus suffix for negative number.
     *
     * Next optional suffix:
     * '^^^^' suffix indicates scientific notation.
     *
     * </pre>
     */
    public static final class NumberFormatter implements IFormatter {
        private final DecimalFormat decimalFormat;
        private final boolean scientific;
        private final boolean signPrefix;
        private final boolean signSuffix;
        private final boolean minusSuffix;
        private final boolean shouldFill;
        private final boolean dollar;

        public NumberFormatter(String format) {
            // Handle prefix '+' or '-'
            if (format.startsWith("+")) {
                signPrefix = true;
                format = format.substring(1);
            } else if (format.startsWith("-")) {
                signPrefix = false;
                format = format.substring(1);
            } else {
                signPrefix = false;
            }

            // Handle suffix '+' or '-'
            if (format.endsWith("+")) {
                signSuffix = true;
                minusSuffix = false;
                format = format.substring(0, format.length() - 1);
            } else if (format.endsWith("-")) {
                signSuffix = false;
                minusSuffix = true;
                format = format.substring(0, format.length() - 1);
            } else {
                signSuffix = false;
                minusSuffix = false;
            }

            // Handle scientific notation
            if (format.endsWith("^^^^")) {
                format = format.replace("^^^^", "E00");
                scientific = true;
            } else {
                scientific = false;
            }

            // Replace # with 0 so that result is filled with 0 prefixes
            format = format.replace("#", "0");

            // Handle **, **$, and $$ prefix
            boolean dollar = false;
            int numToFill = 0;
            int removeFromFormat = 0;
            if (format.startsWith("**$")) {
                numToFill = 2;
                removeFromFormat = 3;
                dollar = true;
            } else if (format.startsWith("**")) {
                numToFill = 2;
                removeFromFormat = 2;
            } else if (format.startsWith("$$")) {
                numToFill = 1;
                removeFromFormat = 2;
                dollar = true;
            }
            if (removeFromFormat > 0) {
                format = format.substring(removeFromFormat);
            }
            this.dollar = dollar;
            this.shouldFill = numToFill > 0;

            if (numToFill > 0) {
                var b = new byte[numToFill];
                Arrays.fill(b, 0, numToFill, (byte) '0');
                format = new String(b) + format;
            }

            this.decimalFormat = new DecimalFormat(format);
        }

        @Override
        public String format(Object o) {
            if (o instanceof Long) {
                return format((long) o);
            } else if (o instanceof Double) {
                return format((double) o);
            } else {
                throw new PuffinBasicInternalError(
                        NumberFormatter.class.getSimpleName()
                                + ": data type mismatch: " + o.getClass()
                );
            }
        }

        @Override
        public boolean supportsNumeric() {
            return true;
        }

        @Override
        public boolean supportsString() {
            return false;
        }

        public String format(long value) {
            boolean isNegative = value < 0;
            if (isNegative) {
                value = -value;
            }
            return format(decimalFormat.format(value), isNegative);
        }

        public String format(double value) {
            boolean isNegative = value < 0;
            if (isNegative) {
                value = -value;
            }
            return format(decimalFormat.format(value), isNegative);
        }

        private String format(String result, boolean isNegative) {
            // Handle scientific
            if (scientific) {
                if (!result.contains("E-")) {
                    result = result.replace("E", "E+");
                }
            }

            // If ** or **$ is set, replace leading 0s with *s.
            // If ** or **$ is not set, remove leading 0s.
            var dest = new byte[result.length()];
            boolean checkForLeadingZero = true;
            int fillToLoc = -1;
            for (int i = 0; i < result.length(); i++) {
                var c = result.charAt(i);
                if ((c >= '1' && c <= '9')) {
                    checkForLeadingZero = false;
                }
                if (checkForLeadingZero) {
                    if (c == '0') {
                        c = '*';
                        fillToLoc = i;
                    }
                }
                // Copy char to dest
                dest[i] = (byte) c;
            }
            if (fillToLoc >= 0) {
                result = shouldFill ? new String(dest) : new String(dest).substring(fillToLoc + 1);
                if (result.startsWith(",")) {
                    result = result.substring(1);
                }
            }

            // Add $ prefix
            if (dollar) {
                result = '$' + result;
            }
            // Add sign prefix
            if (signPrefix) {
                result = (isNegative ? '-' : '+') + result;
            }
            // Add minus prefix
            if (isNegative && !minusSuffix && !result.startsWith("-")) {
                result = '-' + result;
            }
            // Add sign suffix
            if (signSuffix) {
                result = result + (isNegative ? '-' : '+');
            }
            // Add minus suffix
            if (isNegative && minusSuffix) {
                result = result + '-';
            }

            return result;
        }
    }

    public static final class FirstCharFormatter implements IFormatter {
        @Override
        public String format(Object o) {
            if (o instanceof String) {
                var str = (String) o;
                return str.isEmpty() ? "" : str.substring(0, 1);
            } else {
                throw new PuffinBasicInternalError(
                        FirstCharFormatter.class.getSimpleName()
                                + ": data type mismatch: " + o.getClass()
                );
            }
        }

        @Override
        public boolean supportsNumeric() {
            return false;
        }

        @Override
        public boolean supportsString() {
            return true;
        }
    }

    public static final class NSpacesFormatter implements IFormatter {
        private final int length;

        public NSpacesFormatter(String format) {
            if (format.length() >= 2) {
                length = format.length();
                var spaces = format.substring(1, format.length() - 1);
                for (int i = 0; i < spaces.length(); i++) {
                    if (spaces.charAt(i) != ' ') {
                        throw new PuffinBasicRuntimeError(
                                ILLEGAL_FUNCTION_PARAM,
                                "Expected spaces in n+2 spaces formatter, but found: " + spaces.charAt(i)
                        );
                    }
                }
            } else {
                throw new PuffinBasicRuntimeError(
                        ILLEGAL_FUNCTION_PARAM,
                        "Bad n+2 formatter string: " + format
                );
            }
        }

        @Override
        public String format(Object o) {
            if (o instanceof String) {
                var str = (String) o;
                var strlen = str.length();
                if (strlen > this.length) {
                    return str.substring(0, this.length);
                } else {
                    byte[] bytes = new byte[this.length];
                    System.arraycopy(str.getBytes(), 0, bytes, 0, str.length());
                    java.util.Arrays.fill(bytes, str.length(), length, (byte) ' ');
                    return new String(bytes);
                }
            } else {
                throw new PuffinBasicInternalError(
                        FirstCharFormatter.class.getSimpleName()
                                + ": data type mismatch: " + o.getClass()
                );
            }
        }

        @Override
        public boolean supportsNumeric() {
            return false;
        }

        @Override
        public boolean supportsString() {
            return true;
        }
    }

    public static final class VarLenStringFormatter implements IFormatter {
        @Override
        public String format(Object o) {
            if (o instanceof String) {
                return (String) o;
            } else {
                throw new PuffinBasicInternalError(
                        FirstCharFormatter.class.getSimpleName()
                                + ": data type mismatch: " + o.getClass()
                );
            }
        }

        @Override
        public boolean supportsNumeric() {
            return false;
        }

        @Override
        public boolean supportsString() {
            return true;
        }
    }
}
