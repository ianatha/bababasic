package io.atha.libbababasic.domain

interface Scope {
    val callerInstrId: Int
    fun createRuntimeScope(callerInstrId: Int): Scope
    fun createChild(funcId: Int, localScope: Boolean): Scope
    fun getChild(funcId: Int): Scope
    val searchScope: Scope?
    val parent: Scope?
    fun getIdForVariable(variableName: VariableName): Int
    fun putVariable(variableName: VariableName, id: Int)
    fun containsVariable(variableName: VariableName): Boolean
    fun putEntry(id: Int, entry: STEntry)
    fun getEntry(id: Int): STEntry?
    fun getNullableEntry(id: Int): STEntry?

    class ChildScope private constructor(
        override val parent: Scope,
        override val callerInstrId: Int,
        private val funcIdToScope: MutableMap<Int, Scope>,
        private val entryMap: MutableMap<Int, STEntry>,
        private val variableNameToEntry: MutableMap<VariableName, Int>
    ) : Scope {
        internal constructor(parent: Scope) : this(
            parent,
            SymbolTable.NULL_ID,
            mutableMapOf(),
            mutableMapOf(),
            mutableMapOf(),
        )

        override fun createRuntimeScope(callerInstrId: Int): Scope {
            return ChildScope(
                parent,
                callerInstrId,
                funcIdToScope.toMutableMap(),
                entryMap.toMutableMap(),
                variableNameToEntry.toMutableMap(),
            )
        }

        override fun createChild(funcId: Int, localScope: Boolean): Scope {
            var child = funcIdToScope[funcId]
            if (child == null) {
                child = ChildScope(this)
                funcIdToScope[funcId] = child
            }
            return child
        }

        override fun getChild(funcId: Int): Scope {
            return funcIdToScope[funcId]!!
        }

        override val searchScope: Scope
            get() = parent

        override fun getIdForVariable(variableName: VariableName): Int {
            return variableNameToEntry.getOrDefault(variableName, -1)
        }

        override fun putVariable(variableName: VariableName, id: Int) {
            variableNameToEntry[variableName] = id
        }

        override fun containsVariable(variableName: VariableName): Boolean {
            return variableNameToEntry.containsKey(variableName)
        }

        override fun putEntry(id: Int, entry: STEntry) {
            entryMap[id] = entry
        }

        override fun getEntry(id: Int): STEntry? {
            return entryMap[id]
        }

        override fun getNullableEntry(id: Int): STEntry? {
            return entryMap[id]
        }
    }

    class LocalScope private constructor(
        override val parent: Scope,
        override val callerInstrId: Int,
        private val funcIdToScope: MutableMap<Int, Scope>,
        private val entryMap: MutableMap<Int, STEntry>,
        private val variableNameToEntry: MutableMap<VariableName, Int>
    ) : Scope {
        internal constructor(parent: Scope) : this(
            parent,
            SymbolTable.NULL_ID,
            mutableMapOf(),
            mutableMapOf(),
            mutableMapOf(),
        )

        override fun createRuntimeScope(callerInstrId: Int): Scope {
            return LocalScope(
                parent,
                callerInstrId,
                funcIdToScope.toMutableMap(),
                entryMap.toMutableMap(),
                variableNameToEntry.toMutableMap(),
            )
        }

        override fun createChild(funcId: Int, localScope: Boolean): Scope {
            var child = funcIdToScope[funcId]
            if (child == null) {
                child = ChildScope(this)
                funcIdToScope[funcId] = child
            }
            return child
        }

        override fun getChild(funcId: Int): Scope {
            return funcIdToScope[funcId]!!
        }

        override val searchScope: Scope?
            get() = null

        override fun getIdForVariable(variableName: VariableName): Int {
            return variableNameToEntry.getOrDefault(variableName, -1)
        }

        override fun putVariable(variableName: VariableName, id: Int) {
            variableNameToEntry[variableName] = id
        }

        override fun containsVariable(variableName: VariableName): Boolean {
            return variableNameToEntry.containsKey(variableName)
        }

        override fun putEntry(id: Int, entry: STEntry) {
            entryMap[id] = entry
        }

        override fun getEntry(id: Int): STEntry? {
            return entryMap[id]
        }

        override fun getNullableEntry(id: Int): STEntry? {
            return entryMap[id]
        }
    }
}