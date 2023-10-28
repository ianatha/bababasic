package org.puffinbasic.domain;

import static org.puffinbasic.domain.PuffinBasicSymbolTable.NULL_ID;

import org.puffinbasic.domain.STObjects.STEntry;
import org.puffinbasic.domain.Variable.VariableName;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

public interface Scope {

    int getCallerInstrId();

    Scope createRuntimeScope(int callerInstrId);

    Scope createChild(int funcId, boolean localScope);

    Scope getChild(int funcId);

    Scope getSearchScope();

    Scope getParent();

    int getIdForVariable(VariableName variableName);

    void putVariable(VariableName variableName, int id);

    boolean containsVariable(VariableName variableName);

    void putEntry(int id, STEntry entry);

    STEntry getEntry(int id);

    STEntry getNullableEntry(int id);

    final class GlobalScope implements Scope {
        private static final int INITIAL_ENTRY_TABLE_SIZE = 1024;
        private final int callerInstrId;
        private final Int2ObjectMap<Scope> funcIdToScope;
        private final Object2IntMap<VariableName> variableNameToEntry;
        // This is an optimization to make entry access fast at runtime.
        //private final ObjectList<STEntry> entryMap;
        private STEntry[] entryMap;

        GlobalScope() {
            this(
                    NULL_ID,
                    new Int2ObjectOpenHashMap<>(),
                    new STEntry[INITIAL_ENTRY_TABLE_SIZE],
                    new Object2IntOpenHashMap<>());
        }

        private GlobalScope(
                int callerInstrId,
                Int2ObjectMap<Scope> funcIdToScope,
                STEntry[] entryMap,
                Object2IntMap<VariableName> variableNameToEntry) {
            this.callerInstrId = callerInstrId;
            this.funcIdToScope = funcIdToScope;
            this.entryMap = entryMap;
            this.variableNameToEntry = variableNameToEntry;
        }

        @Override
        public Scope createRuntimeScope(int callerInstrId) {
            return new GlobalScope(
                    callerInstrId,
                    funcIdToScope,
                    entryMap,
                    variableNameToEntry);
        }

        @Override
        public int getCallerInstrId() {
            return callerInstrId;
        }

        @Override
        public Scope createChild(int funcId, boolean localScope) {
            var child = funcIdToScope.get(funcId);
            if (child == null) {
                child = localScope ? new LocalScope(this) : new ChildScope(this);
                funcIdToScope.put(funcId, child);
            }
            return child;
        }

        @Override
        public Scope getChild(int funcId) {
            return funcIdToScope.get(funcId);
        }

        @Override
        public Scope getParent() {
            return null;
        }

        @Override
        public Scope getSearchScope() {
            return null;
        }

        @Override
        public int getIdForVariable(VariableName variableName) {
            return variableNameToEntry.getOrDefault(variableName, NULL_ID);
        }

        @Override
        public void putVariable(VariableName variableName, int id) {
            variableNameToEntry.put(variableName, id);
        }

        @Override
        public boolean containsVariable(VariableName variableName) {
            return variableNameToEntry.containsKey(variableName);
        }

        private void resize(int index) {
            int newLen = entryMap.length << 1;
            if (newLen < index) {
                do {
                    newLen = newLen << 1;
                } while (newLen < index);
            }
            var newEntryMap = new STEntry[newLen];
            System.arraycopy(entryMap, 0, newEntryMap, 0, entryMap.length);
            entryMap = newEntryMap;
        }

        @Override
        public void putEntry(int id, STEntry entry) {
            int sz = entryMap.length;
            if (id >= sz) {
                resize(id);
            }
            entryMap[id] = entry;
        }

        @Override
        public STEntry getEntry(int id) {
            return entryMap[id];
        }

        @Override
        public STEntry getNullableEntry(int id) {
            if (id >= 0 && id < entryMap.length) {
                return entryMap[id];
            }
            return null;
        }
    }

    final class ChildScope implements Scope {
        private final Scope parent;
        private final int callerInstrId;
        private final Int2ObjectMap<Scope> funcIdToScope;
        private final Int2ObjectMap<STEntry> entryMap;
        private final Object2IntMap<VariableName> variableNameToEntry;

        ChildScope(Scope parent) {
            this(parent,
                    NULL_ID,
                    new Int2ObjectOpenHashMap<>(),
                    new Int2ObjectOpenHashMap<>(),
                    new Object2IntOpenHashMap<>());
        }

        private ChildScope(
                Scope parent,
                int callerInstrId,
                Int2ObjectMap<Scope> funcIdToScope,
                Int2ObjectMap<STEntry> entryMap,
                Object2IntMap<VariableName> variableNameToEntry) {
            this.parent = parent;
            this.callerInstrId = callerInstrId;
            this.funcIdToScope = funcIdToScope;
            this.entryMap = entryMap;
            this.variableNameToEntry = variableNameToEntry;
        }

        @Override
        public Scope createRuntimeScope(int callerInstrId) {
            return new ChildScope(
                    parent,
                    callerInstrId,
                    new Int2ObjectOpenHashMap<>(funcIdToScope),
                    new Int2ObjectOpenHashMap<>(entryMap),
                    new Object2IntOpenHashMap<>(variableNameToEntry)
            );
        }

        @Override
        public int getCallerInstrId() {
            return callerInstrId;
        }

        @Override
        public Scope createChild(int funcId, boolean localScope) {
            var child = funcIdToScope.get(funcId);
            if (child == null) {
                child = new ChildScope(this);
                funcIdToScope.put(funcId, child);
            }
            return child;
        }

        @Override
        public Scope getChild(int funcId) {
            return funcIdToScope.get(funcId);
        }

        @Override
        public Scope getParent() {
            return parent;
        }

        @Override
        public Scope getSearchScope() {
            return parent;
        }

        @Override
        public int getIdForVariable(VariableName variableName) {
            return variableNameToEntry.getOrDefault(variableName, -1);
        }

        @Override
        public void putVariable(VariableName variableName, int id) {
            variableNameToEntry.put(variableName, id);
        }

        @Override
        public boolean containsVariable(VariableName variableName) {
            return variableNameToEntry.containsKey(variableName);
        }

        @Override
        public void putEntry(int id, STEntry entry) {
            entryMap.put(id, entry);
        }

        @Override
        public STEntry getEntry(int id) {
            return entryMap.get(id);
        }

        @Override
        public STEntry getNullableEntry(int id) {
            return entryMap.get(id);
        }
    }

    final class LocalScope implements Scope {
        private final Scope parent;
        private final int callerInstrId;
        private final Int2ObjectMap<Scope> funcIdToScope;
        private final Int2ObjectMap<STEntry> entryMap;
        private final Object2IntMap<VariableName> variableNameToEntry;

        LocalScope(Scope parent) {
            this(parent,
                    NULL_ID,
                    new Int2ObjectOpenHashMap<>(),
                    new Int2ObjectOpenHashMap<>(),
                    new Object2IntOpenHashMap<>());
        }

        private LocalScope(
                Scope parent,
                int callerInstrId,
                Int2ObjectMap<Scope> funcIdToScope,
                Int2ObjectMap<STEntry> entryMap,
                Object2IntMap<VariableName> variableNameToEntry) {
            this.parent = parent;
            this.callerInstrId = callerInstrId;
            this.funcIdToScope = funcIdToScope;
            this.entryMap = entryMap;
            this.variableNameToEntry = variableNameToEntry;
        }

        @Override
        public Scope createRuntimeScope(int callerInstrId) {
            return new LocalScope(
                    parent,
                    callerInstrId,
                    new Int2ObjectOpenHashMap<>(funcIdToScope),
                    new Int2ObjectOpenHashMap<>(entryMap),
                    new Object2IntOpenHashMap<>(variableNameToEntry)
            );
        }

        @Override
        public int getCallerInstrId() {
            return callerInstrId;
        }

        @Override
        public Scope createChild(int funcId, boolean localScope) {
            var child = funcIdToScope.get(funcId);
            if (child == null) {
                child = new ChildScope(this);
                funcIdToScope.put(funcId, child);
            }
            return child;
        }

        @Override
        public Scope getChild(int funcId) {
            return funcIdToScope.get(funcId);
        }

        @Override
        public Scope getParent() {
            return parent;
        }

        @Override
        public Scope getSearchScope() {
            return null;
        }

        @Override
        public int getIdForVariable(VariableName variableName) {
            return variableNameToEntry.getOrDefault(variableName, -1);
        }

        @Override
        public void putVariable(VariableName variableName, int id) {
            variableNameToEntry.put(variableName, id);
        }

        @Override
        public boolean containsVariable(VariableName variableName) {
            return variableNameToEntry.containsKey(variableName);
        }

        @Override
        public void putEntry(int id, STEntry entry) {
            entryMap.put(id, entry);
        }

        @Override
        public STEntry getEntry(int id) {
            return entryMap.get(id);
        }

        @Override
        public STEntry getNullableEntry(int id) {
            return entryMap.get(id);
        }
    }
}
