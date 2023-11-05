package io.atha.libbababasic.domain

import com.google.common.base.Preconditions
import java.util.Objects

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