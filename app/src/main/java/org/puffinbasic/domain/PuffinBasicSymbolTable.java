package org.puffinbasic.domain;

import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.COMPOSITE;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.DOUBLE;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.BAD_FIELD;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.MISSING_STRUCT;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.puffinbasic.domain.STObjects.ArrayReferenceValue;
import org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId;
import org.puffinbasic.domain.STObjects.PuffinBasicType;
import org.puffinbasic.domain.STObjects.STEntry;
import org.puffinbasic.domain.STObjects.STLValue;
import org.puffinbasic.domain.STObjects.STRef;
import org.puffinbasic.domain.STObjects.STTmp;
import org.puffinbasic.domain.STObjects.STVariable;
import org.puffinbasic.domain.STObjects.StructType;
import org.puffinbasic.domain.Scope.GlobalScope;
import org.puffinbasic.domain.Variable.VariableName;
import org.puffinbasic.error.PuffinBasicInternalError;
import org.puffinbasic.error.PuffinBasicRuntimeError;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import it.unimi.dsi.fastutil.chars.Char2ObjectMap;
import it.unimi.dsi.fastutil.chars.Char2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

@RequiresApi(api = Build.VERSION_CODES.O)
public class PuffinBasicSymbolTable {

    public static final int NULL_ID = -1;
    private final Char2ObjectMap<PuffinBasicAtomTypeId> defaultDataTypes;
    private final Object2ObjectMap<String, StructType> userDefinedTypes;
    private final Object2IntMap<String> labelNameToId;
    private final AtomicInteger idmaker;
    private Scope currentScope;
    private int lastId;
    private int lastLastId;
    private STEntry lastEntry;
    private STEntry lastLastEntry;
    public PuffinBasicSymbolTable() {
        this.defaultDataTypes = new Char2ObjectOpenHashMap<>();
        this.userDefinedTypes = new Object2ObjectOpenHashMap<>();
        this.labelNameToId = new Object2IntOpenHashMap<>();
        this.idmaker = new AtomicInteger();
        this.currentScope = new GlobalScope();
        this.lastId = this.lastLastId = -1;
    }

    private int generateNextId() {
        return idmaker.incrementAndGet();
    }

    public Scope getCurrentScope() {
        return currentScope;
    }

    private Optional<Scope> findScope(Predicate<Scope> predicate) {
        var scope = getCurrentScope();
        while (scope != null) {
            if (predicate.test(scope)) {
                return Optional.of(scope);
            } else {
                scope = scope.getSearchScope();
            }
        }
        return Optional.empty();
    }

    private STEntry getEntry(int id) {
        var scope = getCurrentScope();
        var entry = scope.getNullableEntry(id);
        if (entry != null) {
            return entry;
        } else {
            scope = scope.getParent();
            while (scope != null) {
                entry = scope.getNullableEntry(id);
                if (entry != null) {
                    return entry;
                }
                scope = scope.getParent();
            }
        }
        throw new PuffinBasicInternalError("Failed to find entry for id: " + id);
    }

    public STEntry get(int id) {
        // Cache for better performance
        if (id == lastId) {
            return lastEntry;
        }
        if (id == lastLastId) {
            return lastLastEntry;
        }
        lastLastId = lastId;
        lastLastEntry = lastEntry;
        lastId = id;
        lastEntry = getEntry(id);
        return lastEntry;
    }

    public int getCompositeVariableIdForVariable(VariableName variableName) {
        var scope = findScope(s -> s.containsVariable(variableName)).orElse(getCurrentScope());
        int id = scope.getIdForVariable(variableName);
        if (id == -1) {
            throw new PuffinBasicInternalError("Failed to find variable: " + variableName);
        }
        return id;
    }


    public STEntry getVariable(int id) {
        var entry = get(id);
        if (!entry.isLValue()) {
            throw new PuffinBasicRuntimeError(
                    ILLEGAL_FUNCTION_PARAM,
                    "Entry for id: " + id + " is not a variable"
            );
        }
        return entry;
    }

    public int addVariableOrUDF(
            VariableName variableName,
            Function<VariableName, Variable> variableCreator,
            VariableConsumer consumer) {
        var scope = findScope(s -> s.containsVariable(variableName)).orElse(getCurrentScope());
        int id = scope.getIdForVariable(variableName);
        final STVariable entry;
        if (id == -1) {
            id = generateNextId();
            scope.putVariable(variableName, id);
            var variable = variableCreator.apply(variableName);
            entry = variableName.getDataType().createVariableEntry(variable);
            scope.putEntry(id, entry);
        } else {
            entry = (STVariable) get(id);
        }
        consumer.consume(id, entry, entry.getVariable());
        return id;
    }

    public int addCompositeVariable(
            VariableName variableName,
            STVariable variable) {
        var scope = findScope(s -> s.containsVariable(variableName)).orElse(getCurrentScope());
        int id = generateNextId();
        scope.putVariable(variableName, id);
        scope.putEntry(id, variable);
        return id;
    }

    public int addLabel(String label) {
        var id = labelNameToId.getOrDefault(label, -1);
        if (id == -1) {
            id = addLabel();
            labelNameToId.put(label, id);
        }
        return id;
    }

    public int addLabel() {
        var scope = getCurrentScope();
        var id = generateNextId();
        var entry = new STObjects.STLabel();
        scope.putEntry(id, entry);
        return id;
    }

    public int addGotoTarget() {
        var scope = getCurrentScope();
        int id = generateNextId();
        var entry = PuffinBasicAtomTypeId.INT32.createTmpEntry();
        scope.putEntry(id, entry);
        return id;
    }

    public int addArrayReference(STLValue lvalue) {
        var ref = new ArrayReferenceValue(lvalue);
        int id = generateNextId();
        var entry = new STLValue(ref, lvalue.getType());
        getCurrentScope().putEntry(id, entry);
        return id;
    }

    public int addTmp(PuffinBasicType type, Consumer<STEntry> consumer) {
        var scope = getCurrentScope();
        int id = generateNextId();
        var entry = type.canBeLValue() ? new STLValue(null, type) : new STTmp(null, type);
        entry.createAndSetInstance(this);
        scope.putEntry(id, entry);
        consumer.accept(entry);
        return id;
    }

    public int addTmp(PuffinBasicAtomTypeId dataType, Consumer<STEntry> consumer) {
        var scope = getCurrentScope();
        int id = generateNextId();
        var entry = dataType.createTmpEntry();
        scope.putEntry(id, entry);
        consumer.accept(entry);
        return id;
    }

    public int addRef(PuffinBasicType type) {
        var scope = getCurrentScope();
        int id = generateNextId();
        var entry = new STRef(type);
        scope.putEntry(id, entry);
        return id;
    }

    public int addTmpCompatibleWith(int srcId) {
        var scope = getCurrentScope();
        var dataType = scope.getEntry(srcId).getType().getAtomTypeId();
        int id = generateNextId();
        scope.putEntry(id, dataType.createTmpEntry());
        return id;
    }

    public PuffinBasicAtomTypeId getDataTypeFor(String varname, String suffix) {
        var scope = getCurrentScope();
        if (scope.containsVariable(new VariableName(varname, null, COMPOSITE))) {
            return COMPOSITE;
        }
        if (varname.length() == 0) {
            throw new PuffinBasicInternalError("Empty variable name: " + varname);
        }
        if (suffix == null) {
            var firstChar = varname.charAt(0);
            return defaultDataTypes.getOrDefault(firstChar, DOUBLE);
        } else {
            return PuffinBasicAtomTypeId.lookup(suffix);
        }
    }

    public void setDefaultDataType(char c, PuffinBasicAtomTypeId dataType) {
        defaultDataTypes.put(c, dataType);
    }

    public void addStructType(String name, StructType type) {
        userDefinedTypes.put(name, type);
    }

    public void checkUnused(String name) {
        if (userDefinedTypes.containsKey(name)) {
            throw new PuffinBasicRuntimeError(
                    BAD_FIELD,
                    "Name: " + name + " is already used!"
            );
        }
    }

    public StructType getStructType(String name) {
        var type = userDefinedTypes.get(name);
        if (type == null) {
            throw new PuffinBasicRuntimeError(
                    MISSING_STRUCT,
                    "Missing struct: " + name
            );
        }
        return type;
    }

    public void pushDeclarationScope(int funcId, boolean localScope) {
        currentScope = getCurrentScope().createChild(funcId, localScope);
    }

    public void pushRuntimeScope(int funcId, int callerInstrId) {
        var funcDeclScope = getCurrentScope().getChild(funcId);
        if (funcDeclScope == null) {
            throw new PuffinBasicInternalError("Failed to find scope for id: " + funcId);
        }
        currentScope = funcDeclScope.createRuntimeScope(callerInstrId);
    }

    public void popScope() {
        var parent = getCurrentScope().getParent();
        if (parent == null) {
            throw new PuffinBasicInternalError("Scope underflow!");
        }
        currentScope = parent;
    }

    public interface VariableConsumer {
        void consume(int id, STVariable entry, Variable variable);
    }
}
