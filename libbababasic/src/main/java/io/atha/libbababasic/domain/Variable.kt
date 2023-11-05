package io.atha.libbababasic.domain

import com.google.common.base.Preconditions
import io.atha.libbababasic.error.SemanticError
import java.util.Objects
import java.util.function.Supplier

class Variable(
    variableName: VariableName,
    type: PuffinBasicType
) {
    val variableName: VariableName
    val type: PuffinBasicType

    init {
        this.variableName = Preconditions.checkNotNull(variableName)
        this.type = Preconditions.checkNotNull(type)
    }

    val isScalar: Boolean
        get() = type.typeId == PuffinBasicTypeId.SCALAR
    val isArray: Boolean
        get() = type.typeId == PuffinBasicTypeId.ARRAY
    val isUDF: Boolean
        get() = type.typeId == PuffinBasicTypeId.UDF

    override fun toString(): String {
        return variableName.toString() + ":" + type.typeId
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val variable = other as Variable
        return variableName == variable.variableName && type == variable.type
    }

    override fun hashCode(): Int {
        return Objects.hash(variableName, type)
    }

    enum class VariableKindHint {
        ARRAY, DERIVE_FROM_NAME, UDF
    }

    companion object {
        private const val UDF_PREFIX = "FN"

        @JvmStatic
        fun of(
            variableName: VariableName,
            hint: VariableKindHint,
            lineSupplier: Supplier<String?>
        ): Variable {
            return Variable(
                variableName, if (hint == VariableKindHint.ARRAY) {
                    if (!variableName.varname.startsWith(UDF_PREFIX)) {
                        ArrayType(variableName.dataType)
                    } else {
                        throw SemanticError(
                            SemanticError.ErrorCode.ARRAY_VARIABLE_CANNOT_START_WITH_FN,
                            lineSupplier.get()!!,
                            "Array variable cannot start with " + UDF_PREFIX + ": " + variableName.varname
                        )
                    }
                } else {
                    if (hint == VariableKindHint.DERIVE_FROM_NAME &&
                        variableName.varname.startsWith(UDF_PREFIX) ||
                        hint == VariableKindHint.UDF
                    ) {
                        UDFType(variableName.dataType)
                    } else {
                        ScalarType(variableName.dataType)
                    }
                }
            )
        }
    }
}