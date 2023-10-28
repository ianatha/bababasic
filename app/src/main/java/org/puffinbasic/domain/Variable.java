package org.puffinbasic.domain;

import static org.puffinbasic.domain.STObjects.PuffinBasicTypeId.ARRAY;
import static org.puffinbasic.domain.STObjects.PuffinBasicTypeId.SCALAR;
import static org.puffinbasic.domain.STObjects.PuffinBasicTypeId.UDF;

import com.google.common.base.Preconditions;

import org.jetbrains.annotations.NotNull;
import org.puffinbasic.domain.STObjects.ArrayType;
import org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId;
import org.puffinbasic.domain.STObjects.PuffinBasicType;
import org.puffinbasic.domain.STObjects.ScalarType;
import org.puffinbasic.domain.STObjects.UDFType;
import org.puffinbasic.error.PuffinBasicSemanticError;

import java.util.Objects;
import java.util.function.Supplier;

public class Variable {

    private static final String UDF_PREFIX = "FN";
    private final VariableName variableName;
    private final PuffinBasicType type;

    public Variable(
            @NotNull VariableName variableName,
            @NotNull STObjects.PuffinBasicType type) {
        this.variableName = Preconditions.checkNotNull(variableName);
        this.type = Preconditions.checkNotNull(type);
    }

    public static Variable of(
            @NotNull VariableName variableName,
            VariableKindHint hint,
            Supplier<String> lineSupplier) {
        if (hint == VariableKindHint.ARRAY) {
            if (!variableName.varname.startsWith(UDF_PREFIX)) {
                return new Variable(variableName, new ArrayType(variableName.getDataType()));
            } else {
                throw new PuffinBasicSemanticError(
                        PuffinBasicSemanticError.ErrorCode.ARRAY_VARIABLE_CANNOT_STARTWITH_FN,
                        lineSupplier.get(),
                        "Array variable cannot start with " + UDF_PREFIX + ": " + variableName.varname);
            }
        } else {
            if ((hint == VariableKindHint.DERIVE_FROM_NAME && variableName.varname.startsWith(UDF_PREFIX))
                    || hint == VariableKindHint.UDF) {
                return new Variable(variableName, new UDFType(variableName.getDataType()));
            } else {
                return new Variable(variableName, new ScalarType(variableName.getDataType()));
            }
        }
    }

    public VariableName getVariableName() {
        return variableName;
    }

    public PuffinBasicType getType() {
        return type;
    }

    public boolean isScalar() {
        return type.getTypeId() == SCALAR;
    }

    public boolean isArray() {
        return type.getTypeId() == ARRAY;
    }

    public boolean isUDF() {
        return type.getTypeId() == UDF;
    }

    @Override
    public String toString() {
        return variableName + ":" + type.getTypeId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable variable = (Variable) o;
        return variableName.equals(variable.variableName) &&
                type.equals(variable.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variableName, type);
    }

    public enum VariableKindHint {
        ARRAY,
        DERIVE_FROM_NAME,
        UDF
    }

    public static final class VariableName {
        private final String varname;
        private final String suffix;
        private final PuffinBasicAtomTypeId dataType;

        public VariableName(
                @NotNull String varname,
                String suffix,
                @NotNull STObjects.PuffinBasicAtomTypeId dataType) {
            this.varname = Preconditions.checkNotNull(varname);
            this.suffix = suffix == null ? "" : suffix;
            this.dataType = Preconditions.checkNotNull(dataType);
        }

        public String getVarname() {
            return varname;
        }

        public PuffinBasicAtomTypeId getDataType() {
            return dataType;
        }

        @Override
        public String toString() {
            return varname + ":" + suffix + ":" + dataType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            VariableName variable = (VariableName) o;
            return varname.equals(variable.varname) &&
                    Objects.equals(suffix, variable.suffix);
        }

        @Override
        public int hashCode() {
            return Objects.hash(varname, suffix);
        }
    }
}
