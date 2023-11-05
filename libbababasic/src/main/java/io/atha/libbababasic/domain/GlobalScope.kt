package io.atha.libbababasic.domain

class GlobalScope private constructor(
    override val callerInstrId: Int,
    private val funcIdToScope: MutableMap<Int, Scope>,
    private var entryMap: Array<STEntry?>,
    private val variableNameToEntry: MutableMap<VariableName, Int>
) : Scope {
    internal constructor() : this(
        SymbolTable.NULL_ID,
        mutableMapOf(),
        arrayOfNulls<STEntry>(INITIAL_ENTRY_TABLE_SIZE),
        mutableMapOf(),
    )

    override fun createRuntimeScope(callerInstrId: Int): Scope {
        return GlobalScope(
            callerInstrId,
            funcIdToScope,
            entryMap,
            variableNameToEntry
        )
    }

    override fun createChild(funcId: Int, localScope: Boolean): Scope {
        var child = funcIdToScope[funcId]
        if (child == null) {
            child = if (localScope) Scope.LocalScope(this) else Scope.ChildScope(this)
            funcIdToScope[funcId] = child
        }
        return child
    }

    override fun getChild(funcId: Int): Scope {
        return funcIdToScope[funcId]!!
    }

    override val searchScope: Scope?
        get() = null
    override val parent: Scope?
        get() = null

    override fun getIdForVariable(variableName: VariableName): Int {
        return variableNameToEntry.getOrDefault(
            variableName,
            SymbolTable.NULL_ID
        )
    }

    override fun putVariable(variableName: VariableName, id: Int) {
        variableNameToEntry[variableName] = id
    }

    override fun containsVariable(variableName: VariableName): Boolean {
        return variableNameToEntry.containsKey(variableName)
    }

    private fun resize(index: Int) {
        var newLen = entryMap.size shl 1
        if (newLen < index) {
            do {
                newLen = newLen shl 1
            } while (newLen < index)
        }
        val newEntryMap = arrayOfNulls<STEntry>(newLen)
        System.arraycopy(entryMap, 0, newEntryMap, 0, entryMap.size)
        entryMap = newEntryMap
    }

    override fun putEntry(id: Int, entry: STEntry) {
        val sz = entryMap.size
        if (id >= sz) {
            resize(id)
        }
        entryMap[id] = entry
    }

    override fun getEntry(id: Int): STEntry? {
        return entryMap[id]
    }

    override fun getNullableEntry(id: Int): STEntry? {
        return if (id >= 0 && id < entryMap.size) {
            entryMap[id]
        } else null
    }

    companion object {
        private const val INITIAL_ENTRY_TABLE_SIZE = 1024
    }
}