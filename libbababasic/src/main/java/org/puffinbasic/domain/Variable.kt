package org.puffinbasic.domain

import com.google.common.base.Preconditions
import org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId
import org.puffinbasic.domain.STObjects.PuffinBasicType
import org.puffinbasic.domain.STObjects.PuffinBasicTypeId
import org.puffinbasic.domain.STObjects.ScalarType
import org.puffinbasic.domain.STObjects.UDFType
import org.puffinbasic.error.PuffinBasicSemanticError
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

    class VariableName(
        varname: String,
        suffix: String?,
        dataType: PuffinBasicAtomTypeId
    ) {
        val varname: String
        private val suffix: String
        val dataType: PuffinBasicAtomTypeId

        init {
            this.varname = Preconditions.checkNotNull(varname)
            this.suffix = suffix ?: ""
            this.dataType = Preconditions.checkNotNull(dataType)
        }

        override fun toString(): String {
            return "$varname:$suffix:$dataType"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || javaClass != other.javaClass) return false
            val variable = other as VariableName
            return varname == variable.varname && suffix == variable.suffix
        }

        override fun hashCode(): Int {
            return Objects.hash(varname, suffix)
        }
    }

    companion object {
        private const val UDF_PREFIX = "FN"

        @JvmStatic
        fun of(
            variableName: VariableName,
            hint: VariableKindHint,
            lineSupplier: Supplier<String?>
        ): Variable {
            return if (hint == VariableKindHint.ARRAY) {
                if (!variableName.varname.startsWith(UDF_PREFIX)) {
                    Variable(
                        variableName, STObjects.ArrayType(
                            variableName.dataType
                        )
                    )
                } else {
                    throw PuffinBasicSemanticError(
                        PuffinBasicSemanticError.ErrorCode.ARRAY_VARIABLE_CANNOT_START_WITH_FN,
                        lineSupplier.get()!!,
                        "Array variable cannot start with " + UDF_PREFIX + ": " + variableName.varname
                    )
                }
            } else {
                if (hint == VariableKindHint.DERIVE_FROM_NAME && variableName.varname.startsWith(
                        UDF_PREFIX
                    )
                    || hint == VariableKindHint.UDF
                ) {
                    Variable(variableName, UDFType(variableName.dataType))
                } else {
                    Variable(variableName, ScalarType(variableName.dataType))
                }
            }
        }
    }
}