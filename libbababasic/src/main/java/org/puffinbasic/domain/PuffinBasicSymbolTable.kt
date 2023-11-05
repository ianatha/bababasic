package org.puffinbasic.domain

import org.puffinbasic.domain.STObjects.ArrayReferenceValue
import org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId
import org.puffinbasic.domain.STObjects.PuffinBasicType
import org.puffinbasic.domain.STObjects.STEntry
import org.puffinbasic.domain.STObjects.STLValue
import org.puffinbasic.domain.STObjects.STLabel
import org.puffinbasic.domain.STObjects.STRef
import org.puffinbasic.domain.STObjects.STTmp
import org.puffinbasic.domain.STObjects.STVariable
import org.puffinbasic.domain.STObjects.StructType
import org.puffinbasic.domain.Variable.VariableName
import org.puffinbasic.error.PuffinBasicInternalError
import org.puffinbasic.error.PuffinBasicRuntimeError
import java.util.Optional
import java.util.concurrent.atomic.AtomicInteger
import java.util.function.Consumer
import java.util.function.Function
import java.util.function.Predicate

class PuffinBasicSymbolTable {
    private val defaultDataTypes: MutableMap<Char, PuffinBasicAtomTypeId> = mutableMapOf()
    private val userDefinedTypes: MutableMap<String, StructType> = mutableMapOf()
    private val labelNameToId: MutableMap<String, Int> = mutableMapOf()
    private val idMaker: AtomicInteger = AtomicInteger()
    var currentScope: Scope?
        private set
    private var lastId: Int
    private var penultimateId: Int
    private var lastEntry: STEntry? = null
    private var penultimateEntry: STEntry? = null

    init {
        currentScope = GlobalScope()
        penultimateId = -1
        lastId = penultimateId
    }

    private fun generateNextId() = idMaker.incrementAndGet()

    private fun findScope(predicate: Predicate<Scope>): Optional<Scope> {
        var scope = currentScope
        while (scope != null) {
            scope = if (predicate.test(scope)) {
                return Optional.of(scope)
            } else {
                scope.searchScope
            }
        }
        return Optional.empty()
    }

    private fun getEntry(id: Int): STEntry {
        var scope = currentScope
        var entry = scope!!.getNullableEntry(id)
        if (entry != null) {
            return entry
        } else {
            scope = scope.parent
            while (scope != null) {
                entry = scope.getNullableEntry(id)
                if (entry != null) {
                    return entry
                }
                scope = scope.parent
            }
        }
        throw PuffinBasicInternalError("Failed to find entry for id: $id")
    }

    operator fun get(id: Int): STEntry? {
        // Cache for better performance
        if (id == lastId) {
            return lastEntry
        }
        if (id == penultimateId) {
            return penultimateEntry
        }
        penultimateId = lastId
        penultimateEntry = lastEntry
        lastId = id
        lastEntry = getEntry(id)
        return lastEntry
    }

    fun getCompositeVariableIdForVariable(variableName: VariableName): Int {
        val scope = findScope { s: Scope -> s.containsVariable(variableName) }.orElse(
            currentScope
        )
        val id = scope!!.getIdForVariable(variableName)
        if (id == -1) {
            throw PuffinBasicInternalError("Failed to find variable: $variableName")
        }
        return id
    }

    fun getVariable(id: Int): STEntry {
        val entry = get(id)
        if (!entry!!.isLValue) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM,
                "Entry for id: $id is not a variable"
            )
        }
        return entry
    }

    fun addVariableOrUDF(
        variableName: VariableName,
        variableCreator: Function<VariableName?, Variable>,
        consumer: VariableConsumer
    ): Int {
        val scope = findScope { s: Scope -> s.containsVariable(variableName) }.orElse(
            currentScope
        )
        var id = scope!!.getIdForVariable(variableName)
        val entry: STVariable?
        if (id == -1) {
            id = generateNextId()
            scope.putVariable(variableName, id)
            val variable = variableCreator.apply(variableName)
            entry = variableName.dataType.createVariableEntry(variable)
            scope.putEntry(id, entry)
        } else {
            entry = get(id) as STVariable
        }
        consumer.consume(id, entry, entry.variable)
        return id
    }

    fun addCompositeVariable(
        variableName: VariableName,
        variable: STVariable
    ): Int {
        val scope = findScope { s: Scope -> s.containsVariable(variableName) }.orElse(
            currentScope
        )
        val id = generateNextId()
        scope!!.putVariable(variableName, id)
        scope.putEntry(id, variable)
        return id
    }

    fun addLabel(label: String): Int {
        var id: Int = labelNameToId.getOrDefault(label, -1)
        if (id == -1) {
            id = addLabel()
            labelNameToId[label] = id
        }
        return id
    }

    fun addLabel(): Int {
        val scope = currentScope
        val id = generateNextId()
        val entry = STLabel()
        scope!!.putEntry(id, entry)
        return id
    }

    fun addGotoTarget(): Int {
        val scope = currentScope
        val id = generateNextId()
        val entry = PuffinBasicAtomTypeId.INT32.createTmpEntry()
        scope!!.putEntry(id, entry)
        return id
    }

    fun addArrayReference(lvalue: STLValue): Int {
        val ref = ArrayReferenceValue(lvalue)
        val id = generateNextId()
        val entry = STLValue(ref, lvalue.type)
        currentScope!!.putEntry(id, entry)
        return id
    }

    fun addTmp(type: PuffinBasicType, consumer: Consumer<STEntry>): Int {
        val scope = currentScope
        val id = generateNextId()
        val entry = if (type.canBeLValue()) STLValue(null, type) else STTmp(null, type)
        entry.createAndSetInstance(this)
        scope!!.putEntry(id, entry)
        consumer.accept(entry)
        return id
    }

    fun addTmp(dataType: PuffinBasicAtomTypeId, consumer: Consumer<STEntry?>): Int {
        val scope = currentScope
        val id = generateNextId()
        val entry = dataType.createTmpEntry()
        scope!!.putEntry(id, entry)
        consumer.accept(entry)
        return id
    }

    fun addRef(type: PuffinBasicType?): Int {
        val scope = currentScope
        val id = generateNextId()
        val entry = STRef(type)
        scope!!.putEntry(id, entry)
        return id
    }

    fun addTmpCompatibleWith(srcId: Int): Int {
        val scope = currentScope
        val dataType = scope!!.getEntry(srcId)!!.type!!.atomTypeId
        val id = generateNextId()
        scope.putEntry(id, dataType.createTmpEntry())
        return id
    }

    fun getDataTypeFor(varname: String, suffix: String?): PuffinBasicAtomTypeId {
        val scope = currentScope
        if (scope!!.containsVariable(
                VariableName(
                    varname,
                    null,
                    PuffinBasicAtomTypeId.COMPOSITE
                )
            )
        ) {
            return PuffinBasicAtomTypeId.COMPOSITE
        }
        if (varname.isEmpty()) {
            throw PuffinBasicInternalError("Empty variable name: $varname")
        }
        return if (suffix == null) {
            val firstChar = varname[0]
            defaultDataTypes.getOrDefault(firstChar, PuffinBasicAtomTypeId.DOUBLE)
        } else {
            PuffinBasicAtomTypeId.lookup(suffix)
        }
    }

    fun setDefaultDataType(c: Char, dataType: PuffinBasicAtomTypeId) {
        defaultDataTypes[c] = dataType
    }

    fun addStructType(name: String, type: StructType) {
        userDefinedTypes[name] = type
    }

    fun checkUnused(name: String) {
        if (userDefinedTypes.containsKey(name)) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.BAD_FIELD,
                "Name: $name is already used!"
            )
        }
    }

    fun getStructType(name: String): StructType {
        return userDefinedTypes[name]
            ?: throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.MISSING_STRUCT,
                "Missing struct: $name"
            )
    }

    fun pushDeclarationScope(funcId: Int, localScope: Boolean) {
        currentScope = currentScope!!.createChild(funcId, localScope)
    }

    fun pushRuntimeScope(funcId: Int, callerInstrId: Int) {
        val funcDeclScope = currentScope!!.getChild(funcId)
        currentScope = funcDeclScope.createRuntimeScope(callerInstrId)
    }

    fun popScope() {
        val parent = currentScope!!.parent ?: throw PuffinBasicInternalError("Scope underflow!")
        currentScope = parent
    }

    interface VariableConsumer {
        fun consume(id: Int, entry: STVariable, variable: Variable)
    }

    companion object {
        const val NULL_ID = -1
    }
}

fun variableConsumer(consumer: (id: Int, entry: STVariable, variable: Variable) -> Unit): PuffinBasicSymbolTable.VariableConsumer {
    return object : PuffinBasicSymbolTable.VariableConsumer {
        override fun consume(id: Int, entry: STVariable, variable: Variable) {
            consumer(id, entry, variable)
        }
    }
}