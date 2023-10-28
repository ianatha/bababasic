package org.puffinbasic.domain;

import static org.puffinbasic.domain.PuffinBasicSymbolTable.NULL_ID;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.COMPOSITE;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.DOUBLE;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.FLOAT;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.ARRAY_INDEX_OUT_OF_BOUNDS;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.BAD_FIELD;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.BAD_FUNCTION_CALL;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.DATA_TYPE_MISMATCH;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.NOT_INITIALIZED;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.common.collect.ImmutableList;

import org.puffinbasic.domain.Variable.VariableName;
import org.puffinbasic.error.PuffinBasicInternalError;
import org.puffinbasic.error.PuffinBasicRuntimeError;
import org.puffinbasic.runtime.Formatter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;

@RequiresApi(api = Build.VERSION_CODES.O)
public class STObjects {

    public enum PuffinBasicTypeId {
        SCALAR,
        ARRAY,
        UDF,
        STRUCT,
        LIST,
        SET,
        DICT,
    }

    public enum PuffinBasicAtomTypeId {

        INT32('%') {
            @Override
            public STVariable createVariableEntry(Variable variable) {
                if (variable.isArray()) {
                    return new STVariable(new STInt32ArrayValue(), variable);
                } else if (variable.isUDF()) {
                    return new STUDF(new STInt32ScalarValue(), variable);
                } else if (variable.isScalar()) {
                    return new STVariable(new STInt32ScalarValue(), variable);
                } else {
                    throw new PuffinBasicInternalError("Variable type not supported: " + variable);
                }
            }

            @Override
            public STTmp createTmpEntry() {
                return new STTmp(new STInt32ScalarValue(), ScalarType.INT32);
            }

            @Override
            public STTmp createArrayEntry() {
                return new STTmp(new STInt32ArrayValue(), ScalarType.INT32);
            }

            @Override
            public STValue createValue() {
                return new STInt32ScalarValue();
            }

            @Override
            public Object getValueFrom(STValue src) {
                return src.getInt32();
            }

            @Override
            public void setValueIn(Object value, STValue dst) {
                dst.setInt32((int) value);
            }

            @Override
            public void copyArray(Collection<?> src, STValue dst) {
                var dims = new IntArrayList(1);
                dims.add(src.size());
                dst.setArrayDimensions(dims);
                int[] array = ((STInt32ArrayValue) dst).getValue();
                int i = 0;
                for (Object o : src) {
                    array[i++] = (int) o;
                }
            }

            @Override
            public void copyArray(Object[] src, STValue dst) {
                Integer[] srcList = (Integer[]) src;
                var dims = new IntArrayList(1);
                dims.add(src.length);
                dst.setArrayDimensions(dims);
                int[] array = ((STInt32ArrayValue) dst).getValue();
                int i = 0;
                for (Integer o : srcList) {
                    array[i++] = o;
                }
            }

            @Override
            public boolean isCompatibleWith(PuffinBasicAtomTypeId other) {
                return other == INT32 || other == INT64 || other == FLOAT || other == DOUBLE;
            }
        },
        INT64('@') {
            @Override
            public STVariable createVariableEntry(Variable variable) {
                if (variable.isArray()) {
                    return new STVariable(new STInt64ArrayValue(), variable);
                } else if (variable.isUDF()) {
                    return new STUDF(new STInt64ScalarValue(), variable);
                } else if (variable.isScalar()) {
                    return new STVariable(new STInt64ScalarValue(), variable);
                } else {
                    throw new PuffinBasicInternalError("Variable type not supported: " + variable);
                }
            }

            @Override
            public STTmp createTmpEntry() {
                return new STTmp(new STInt64ScalarValue(), ScalarType.INT64);
            }

            @Override
            public STTmp createArrayEntry() {
                return new STTmp(new STInt64ArrayValue(), ScalarType.INT64);
            }

            @Override
            public STValue createValue() {
                return new STInt64ScalarValue();
            }

            @Override
            public Object getValueFrom(STValue src) {
                return src.getInt64();
            }

            @Override
            public void setValueIn(Object value, STValue dst) {
                dst.setInt64((long) value);
            }

            @Override
            public void copyArray(Collection<?> src, STValue dst) {
                var dims = new IntArrayList(1);
                dims.add(src.size());
                dst.setArrayDimensions(dims);
                long[] array = ((STInt64ArrayValue) dst).getValue();
                int i = 0;
                for (Object o : src) {
                    array[i++] = (long) o;
                }
            }

            @Override
            public void copyArray(Object[] src, STValue dst) {
                Long[] srcList = (Long[]) src;
                var dims = new IntArrayList(1);
                dims.add(src.length);
                dst.setArrayDimensions(dims);
                long[] array = ((STInt64ArrayValue) dst).getValue();
                int i = 0;
                for (long o : srcList) {
                    array[i++] = o;
                }
            }

            @Override
            public boolean isCompatibleWith(PuffinBasicAtomTypeId other) {
                return other == INT32 || other == INT64 || other == FLOAT || other == DOUBLE;
            }
        },
        FLOAT('!') {
            @Override
            public STVariable createVariableEntry(Variable variable) {
                if (variable.isArray()) {
                    return new STVariable(new STFloat32ArrayValue(), variable);
                } else if (variable.isUDF()) {
                    return new STUDF(new STFloat32ScalarValue(), variable);
                } else if (variable.isScalar()) {
                    return new STVariable(new STFloat32ScalarValue(), variable);
                } else {
                    throw new PuffinBasicInternalError("Variable type not supported: " + variable);
                }
            }

            @Override
            public STTmp createTmpEntry() {
                return new STTmp(new STFloat32ScalarValue(), ScalarType.FLOAT32);
            }

            @Override
            public STTmp createArrayEntry() {
                return new STTmp(new STFloat32ArrayValue(), ScalarType.FLOAT32);
            }

            @Override
            public STValue createValue() {
                return new STFloat32ScalarValue();
            }

            @Override
            public Object getValueFrom(STValue src) {
                return src.getFloat32();
            }

            @Override
            public void setValueIn(Object value, STValue dst) {
                dst.setFloat32((float) value);
            }

            @Override
            public void copyArray(Collection<?> src, STValue dst) {
                var dims = new IntArrayList(1);
                dims.add(src.size());
                dst.setArrayDimensions(dims);
                float[] array = ((STFloat32ArrayValue) dst).getValue();
                int i = 0;
                for (Object o : src) {
                    array[i++] = (float) o;
                }
            }

            @Override
            public void copyArray(Object[] src, STValue dst) {
                Float[] srcList = (Float[]) src;
                var dims = new IntArrayList(1);
                dims.add(src.length);
                dst.setArrayDimensions(dims);
                float[] array = ((STFloat32ArrayValue) dst).getValue();
                int i = 0;
                for (Float o : srcList) {
                    array[i++] = o;
                }
            }

            @Override
            public boolean isCompatibleWith(PuffinBasicAtomTypeId other) {
                return other == INT32 || other == INT64 || other == FLOAT || other == DOUBLE;
            }
        },
        DOUBLE('#') {
            @Override
            public STVariable createVariableEntry(Variable variable) {
                if (variable.isArray()) {
                    return new STVariable(new STFloat64ArrayValue(), variable);
                } else if (variable.isUDF()) {
                    return new STUDF(new STFloat64ScalarValue(), variable);
                } else if (variable.isScalar()) {
                    return new STVariable(new STFloat64ScalarValue(), variable);
                } else {
                    throw new PuffinBasicInternalError("Variable type not supported: " + variable);
                }
            }

            @Override
            public STTmp createTmpEntry() {
                return new STTmp(new STFloat64ScalarValue(), ScalarType.FLOAT64);
            }

            @Override
            public STTmp createArrayEntry() {
                return new STTmp(new STFloat64ArrayValue(), ScalarType.FLOAT64);
            }

            @Override
            public STValue createValue() {
                return new STFloat64ScalarValue();
            }

            @Override
            public Object getValueFrom(STValue src) {
                return src.getFloat64();
            }

            @Override
            public void setValueIn(Object value, STValue dst) {
                dst.setFloat64((double) value);
            }

            @Override
            public void copyArray(Collection<?> src, STValue dst) {
                var dims = new IntArrayList(1);
                dims.add(src.size());
                dst.setArrayDimensions(dims);
                double[] array = ((STFloat64ArrayValue) dst).getValue();
                int i = 0;
                for (Object o : src) {
                    array[i++] = (double) o;
                }
            }

            @Override
            public void copyArray(Object[] src, STValue dst) {
                Double[] srcList = (Double[]) src;
                var dims = new IntArrayList(1);
                dims.add(src.length);
                dst.setArrayDimensions(dims);
                double[] array = ((STFloat64ArrayValue) dst).getValue();
                int i = 0;
                for (Double o : srcList) {
                    array[i++] = o;
                }
            }

            @Override
            public boolean isCompatibleWith(PuffinBasicAtomTypeId other) {
                return other == INT32 || other == INT64 || other == FLOAT || other == DOUBLE;
            }
        },
        STRING('$') {
            @Override
            public STVariable createVariableEntry(Variable variable) {
                if (variable.isArray()) {
                    return new STVariable(new STStringArrayValue(), variable);
                } else if (variable.isUDF()) {
                    return new STUDF(new STStringScalarValue(), variable);
                } else if (variable.isScalar()) {
                    String varname = variable.getVariableName().getVarname();
                    if (varname.equalsIgnoreCase("date")) {
                        return new STVariable(new STStringScalarDateValue(), variable);
                    } else if (varname.equalsIgnoreCase("time")) {
                        return new STVariable(new STStringScalarTimeValue(), variable);
                    } else {
                        return new STVariable(new STStringScalarValue(), variable);
                    }
                } else {
                    throw new PuffinBasicInternalError("Variable type not supported: " + variable);
                }
            }

            @Override
            public STTmp createTmpEntry() {
                return new STTmp(new STStringScalarValue(), ScalarType.STRING);
            }

            @Override
            public STTmp createArrayEntry() {
                return new STTmp(new STStringArrayValue(), ScalarType.STRING);
            }

            @Override
            public STValue createValue() {
                return new STStringScalarValue();
            }

            @Override
            public Object getValueFrom(STValue src) {
                return src.getString();
            }

            @Override
            public void setValueIn(Object value, STValue dst) {
                dst.setString((String) value);
            }

            @Override
            public void copyArray(Collection<?> src, STValue dst) {
                var dims = new IntArrayList(1);
                dims.add(src.size());
                dst.setArrayDimensions(dims);
                String[] array = ((STStringArrayValue) dst).getValue();
                int i = 0;
                for (Object o : src) {
                    array[i++] = (String) o;
                }
            }

            @Override
            public void copyArray(Object[] src, STValue dst) {
                String[] srcList = (String[]) src;
                var dims = new IntArrayList(1);
                dims.add(src.length);
                dst.setArrayDimensions(dims);
                String[] array = ((STStringArrayValue) dst).getValue();
                int i = 0;
                for (String o : srcList) {
                    array[i++] = o;
                }
            }

            @Override
            public boolean isCompatibleWith(PuffinBasicAtomTypeId other) {
                return other == STRING;
            }
        },
        COMPOSITE(null) {
            @Override
            public STVariable createVariableEntry(Variable variable) {
                return new STVariable(null, variable);
            }

            @Override
            public STTmp createTmpEntry() {
                throw new PuffinBasicInternalError("Not implemented");
            }

            @Override
            public STTmp createArrayEntry() {
                throw new PuffinBasicInternalError("Not implemented");
            }

            @Override
            public STValue createValue() {
                throw new PuffinBasicInternalError("Not implemented");
            }

            @Override
            public Object getValueFrom(STValue src) {
                throw new PuffinBasicInternalError("Not implemented");
            }

            @Override
            public void setValueIn(Object value, STValue dst) {
                throw new PuffinBasicInternalError("Not implemented");
            }

            @Override
            public void copyArray(Collection<?> src, STValue dst) {
                throw new PuffinBasicInternalError("Not implemented");
            }

            @Override
            public void copyArray(Object[] src, STValue dst) {
                throw new PuffinBasicInternalError("Not implemented");
            }

            @Override
            public boolean isCompatibleWith(PuffinBasicAtomTypeId other) {
                return other == COMPOSITE;
            }
        };

        private static final Int2ObjectMap<PuffinBasicAtomTypeId> mapping;

        static {
            mapping = new Int2ObjectOpenHashMap<>();
            for (PuffinBasicAtomTypeId value : PuffinBasicAtomTypeId.values()) {
                if (value.repr != null) {
                    mapping.put(value.repr, value);
                }
            }
        }

        public final Character repr;

        PuffinBasicAtomTypeId(Character repr) {
            this.repr = repr;
        }

        public static PuffinBasicAtomTypeId lookup(String repr) {
            if (repr == null || repr.length() != 1) {
                throw new PuffinBasicInternalError(
                        "Variable suffix: '" + repr + "' is null or length != 1"
                );
            }
            var dataType = mapping.get(repr.charAt(0));
            if (dataType == null) {
                throw new PuffinBasicInternalError(
                        "Variable suffix '" + repr + "' is invalid"
                );
            }
            return dataType;
        }

        public String getRepr() {
            return repr != null ? String.valueOf(repr) : null;
        }

        public abstract STVariable createVariableEntry(Variable variable);

        public abstract STTmp createTmpEntry();

        public abstract STTmp createArrayEntry();

        public abstract STValue createValue();

        public abstract boolean isCompatibleWith(PuffinBasicAtomTypeId other);

        public abstract Object getValueFrom(STValue src);

        public abstract void setValueIn(Object value, STValue dst);

        public abstract void copyArray(Collection<?> src, STValue dst);

        public abstract void copyArray(Object[] src, STValue dst);
    }

    public interface PuffinBasicType {
        PuffinBasicTypeId getTypeId();

        PuffinBasicAtomTypeId getAtomTypeId();

        STValue newInstance(PuffinBasicSymbolTable symbolTable);

        default boolean canBeLValue() {
            return false;
        }

        default PuffinBasicType getFuncCallReturnType(String funcName) {
            throw new PuffinBasicRuntimeError(
                    BAD_FIELD,
                    "Unsupported function: " + funcName + " in type: " + this
            );
        }

        default void checkFuncCallArguments(String funcName, List<PuffinBasicType> paramTypes) {
        }

        default boolean isCompatibleWith(PuffinBasicType other) {
            return this.equals(other);
        }

        default StructType asStruct() {
            if (getTypeId() != PuffinBasicTypeId.STRUCT) {
                throw new PuffinBasicRuntimeError(
                        BAD_FIELD,
                        "Type is not struct!"
                );
            }
            return (StructType) this;
        }
    }

    private interface MemberCallHandler {
        void call(Object o, STValue[] params, STValue result);
    }

    public interface STEntry {
        default boolean isLValue() {
            return false;
        }

        STValue getValue();

        PuffinBasicType getType();
    }

    public interface STValue {
        String printFormat();

        String writeFormat();

        void assign(STValue entry);

        default void replace(STValue entry) {
            assign(entry);
        }

        int getInt32();

        void setInt32(int value);

        long getInt64();

        void setInt64(long value);

        float getFloat32();

        void setFloat32(float value);

        double getFloat64();

        void setFloat64(double value);

        int getRoundedInt32();

        long getRoundedInt64();

        String getString();

        void setString(String value);

        default int getFieldLength() {
            return 0;
        }

        default void setFieldLength(int fieldLength) {
        }

        default IntList getArrayDimensions() {
            return new IntArrayList();
        }

        default void setArrayDimensions(IntList dims) {
        }

        default int getTotalLength() {
            return 0;
        }

        default int getNumArrayDimensions() {
            return 0;
        }

        default void setArrayIndex(int dim, int index) {
        }

        default void resetArrayIndex() {
        }

        default int getArrayIndex1D() {
            return 0;
        }

        default void setArrayReferenceIndex1D(int index1d) {
            throw new PuffinBasicInternalError("Unsupported");
        }

        default int[] getInt32Array1D() {
            throw new PuffinBasicInternalError("Unsupported");
        }

        default void fill(Number fill) {
            throw new PuffinBasicInternalError("Unsupported");
        }

        default void fillString(String fill) {
            throw new PuffinBasicInternalError("Unsupported");
        }

        default boolean isInitialized() {
            return true;
        }

        default void checkInitialized() {
            if (!isInitialized()) {
                throw new PuffinBasicRuntimeError(
                        NOT_INITIALIZED,
                        "Value cannot be read without initializing"
                );
            }
        }

        default void setInitialized() {
        }

        default void call(String funcName, STValue[] params, STValue result) {
            throw new PuffinBasicRuntimeError(
                    BAD_FIELD,
                    "Function call is not supported: " + funcName
            );
        }

        default boolean hasLen() {
            return false;
        }

        default int len() {
            throw new PuffinBasicInternalError("Not implemented");
        }
    }

    public static class ScalarType implements PuffinBasicType {
        static final ScalarType INT32 = new ScalarType(PuffinBasicAtomTypeId.INT32);
        static final ScalarType INT64 = new ScalarType(PuffinBasicAtomTypeId.INT64);
        static final ScalarType FLOAT32 = new ScalarType(FLOAT);
        static final ScalarType FLOAT64 = new ScalarType(DOUBLE);
        static final ScalarType STRING = new ScalarType(PuffinBasicAtomTypeId.STRING);

        private final PuffinBasicAtomTypeId atomType;

        public ScalarType(PuffinBasicAtomTypeId atomType) {
            this.atomType = atomType;
        }

        @Override
        public PuffinBasicTypeId getTypeId() {
            return PuffinBasicTypeId.SCALAR;
        }

        @Override
        public PuffinBasicAtomTypeId getAtomTypeId() {
            return atomType;
        }

        @Override
        public STValue newInstance(PuffinBasicSymbolTable symbolTable) {
            return atomType.createValue();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != ScalarType.class) {
                return false;
            }
            ScalarType o = (ScalarType) obj;
            return getTypeId() == o.getTypeId()
                    && getAtomTypeId() == o.getAtomTypeId();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getTypeId(), getAtomTypeId());
        }

        @Override
        public boolean isCompatibleWith(PuffinBasicType other) {
            return getAtomTypeId().isCompatibleWith(other.getAtomTypeId());
        }
    }

    public static class ArrayType implements PuffinBasicType {
        private final PuffinBasicAtomTypeId atomType;
        private final IntList dims;
        private final boolean canBeLValue;

        public ArrayType(PuffinBasicAtomTypeId atomType) {
            this.atomType = atomType;
            this.dims = new IntArrayList();
            this.canBeLValue = false;
        }

        public ArrayType(PuffinBasicAtomTypeId atomType, IntList dims, boolean canBeLValue) {
            this.atomType = atomType;
            this.dims = dims;
            this.canBeLValue = canBeLValue;
        }

        public void setArrayDimensions(IntList dims) {
            this.dims.clear();
            this.dims.addAll(dims);
        }

        public boolean isNDArray(int n) {
            return dims != null && dims.size() == n;
        }

        @Override
        public boolean canBeLValue() {
            return canBeLValue;
        }

        @Override
        public PuffinBasicTypeId getTypeId() {
            return PuffinBasicTypeId.ARRAY;
        }

        @Override
        public PuffinBasicAtomTypeId getAtomTypeId() {
            return atomType;
        }

        @Override
        public STValue newInstance(PuffinBasicSymbolTable symbolTable) {
            var entry = atomType.createArrayEntry();
            var value = entry.getValue();
            if (dims != null) {
                value.setArrayDimensions(dims);
            }
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != ArrayType.class) {
                return false;
            }
            ArrayType o = (ArrayType) obj;
            return getTypeId() == o.getTypeId()
                    && getAtomTypeId() == o.getAtomTypeId();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getTypeId(), getAtomTypeId());
        }

        @Override
        public boolean isCompatibleWith(PuffinBasicType other) {
            return atomType.isCompatibleWith(other.getAtomTypeId());
        }
    }

    public static class UDFType implements PuffinBasicType {
        private final PuffinBasicAtomTypeId atomType;

        UDFType(PuffinBasicAtomTypeId atomType) {
            this.atomType = atomType;
        }

        @Override
        public PuffinBasicTypeId getTypeId() {
            return PuffinBasicTypeId.UDF;
        }

        @Override
        public PuffinBasicAtomTypeId getAtomTypeId() {
            return atomType;
        }

        @Override
        public STValue newInstance(PuffinBasicSymbolTable symbolTable) {
            throw new PuffinBasicInternalError("Not implemented!");
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != ArrayType.class) {
                return false;
            }
            ArrayType o = (ArrayType) obj;
            return getTypeId() == o.getTypeId()
                    && getAtomTypeId() == o.getAtomTypeId();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getTypeId(), getAtomTypeId());
        }

        @Override
        public boolean isCompatibleWith(PuffinBasicType other) {
            return getTypeId() == other.getTypeId()
                    && getAtomTypeId().isCompatibleWith(other.getAtomTypeId());
        }
    }

    public static final class StructType implements PuffinBasicType {
        private final String typeName;
        private final Int2ObjectMap<PuffinBasicType> refIdToTypeMap;
        private final Object2IntMap<VariableName> nameToRefIdMap;
        private int counter;

        public StructType(String typeName) {
            this.typeName = typeName;
            this.refIdToTypeMap = new Int2ObjectOpenHashMap<>();
            this.nameToRefIdMap = new Object2IntOpenHashMap<>();
        }

        public String getTypeName() {
            return typeName;
        }

        public PuffinBasicType getMemberType(VariableName memberName) {
            return refIdToTypeMap.get(getMemberRefId(memberName));
        }

        public boolean containsMember(VariableName memberName) {
            return nameToRefIdMap.containsKey(memberName);
        }

        public int getMemberRefId(VariableName memberName) {
            var memberRefId = nameToRefIdMap.getOrDefault(memberName, -1);
            if (memberRefId == -1) {
                throw new PuffinBasicRuntimeError(
                        BAD_FIELD,
                        "Missing field " + typeName + "." + memberName
                );
            }
            return memberRefId;
        }

        public void declareField(VariableName memberName, PuffinBasicType type) {
            final int refId = counter++;
            refIdToTypeMap.put(refId, type);
            nameToRefIdMap.put(memberName, refId);
        }

        @Override
        public PuffinBasicTypeId getTypeId() {
            return PuffinBasicTypeId.STRUCT;
        }

        @Override
        public PuffinBasicAtomTypeId getAtomTypeId() {
            return PuffinBasicAtomTypeId.COMPOSITE;
        }

        @Override
        public STValue newInstance(PuffinBasicSymbolTable symbolTable) {
            return new STStruct(symbolTable, this);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != StructType.class) {
                return false;
            }
            StructType o = (StructType) obj;
            return getTypeId() == o.getTypeId()
                    && getAtomTypeId() == o.getAtomTypeId()
                    && getTypeName().equals(o.getTypeName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getTypeId(), getAtomTypeId());
        }
    }

    private static final class MemberFunction {
        private final String functionName;
        private final PuffinBasicType[] paramTypes;
        private final PuffinBasicType returnType;
        private final MemberCallHandler callHandler;

        MemberFunction(
                String functionName,
                PuffinBasicType[] paramTypes,
                PuffinBasicType returnType,
                MemberCallHandler callHandler) {
            this.functionName = functionName;
            this.paramTypes = paramTypes;
            this.returnType = returnType;
            this.callHandler = callHandler;
        }
    }

    private static final class MemberFunctions {
        private final Map<String, MemberFunction> memberFunctions;

        MemberFunctions(List<MemberFunction> memberFunctions) {
            this.memberFunctions = new HashMap<>();
            memberFunctions.forEach(mf -> this.memberFunctions.put(mf.functionName, mf));
        }

        public MemberFunction get(String funcName) {
            var mf = memberFunctions.get(funcName);
            if (mf == null) {
                throw new PuffinBasicRuntimeError(
                        BAD_FIELD,
                        "Unknown member function: " + funcName
                );
            }
            return mf;
        }

        void checkFuncCallArguments(String funcName, List<PuffinBasicType> paramTypes) {
            PuffinBasicType[] expectedParamTypes = get(funcName).paramTypes;
            if (expectedParamTypes.length != paramTypes.size()) {
                throw new PuffinBasicRuntimeError(
                        BAD_FUNCTION_CALL,
                        "Function " + funcName + " expects " + expectedParamTypes.length
                                + " params, but called with " + paramTypes.size() + " params"
                );
            }
            for (int i = 0; i < expectedParamTypes.length; i++) {
                if (!expectedParamTypes[i].isCompatibleWith(paramTypes.get(i))) {
                    throw new PuffinBasicRuntimeError(
                            BAD_FUNCTION_CALL,
                            "Function " + funcName + " called with wrong param type for param#" + (i + 1)
                                    + ", expected type " + expectedParamTypes[i] + ", actual " + paramTypes.get(i)
                    );
                }
            }
        }
    }

    public static final class ListType implements PuffinBasicType {

        private final PuffinBasicType type;
        private final MemberFunctions memberFunctions;

        public ListType(PuffinBasicType type) {
            this.type = type;
            ArrayType valuesType = new ArrayType(type.getAtomTypeId());
            this.memberFunctions = new MemberFunctions(
                    ImmutableList.<MemberFunction>builder()
                            .add(new MemberFunction(
                                    "append", new PuffinBasicType[]{type}, ScalarType.INT32,
                                    (obj, params, result) -> {
                                        @SuppressWarnings("unchecked")
                                        var list = (List<Object>) obj;
                                        if (type.getTypeId() == PuffinBasicTypeId.SCALAR) {
                                            list.add(type.getAtomTypeId().getValueFrom(params[0]));
                                        } else {
                                            list.add(params[0]);
                                        }
                                        result.setInt32(0);
                                    }))
                            .add(new MemberFunction(
                                    "insert", new PuffinBasicType[]{ScalarType.INT32, type}, ScalarType.INT32,
                                    (obj, params, result) -> {
                                        @SuppressWarnings("unchecked")
                                        var list = (List<Object>) obj;
                                        int index = params[0].getInt32();
                                        if (type.getTypeId() == PuffinBasicTypeId.SCALAR) {
                                            var value = type.getAtomTypeId().getValueFrom(params[1]);
                                            list.add(index, value);
                                        } else {
                                            list.add(index, params[1]);
                                        }
                                        result.setInt32(0);
                                    }))
                            .add(new MemberFunction(
                                    "get", new PuffinBasicType[]{ScalarType.INT32}, type,
                                    (obj, params, result) -> {
                                        @SuppressWarnings("unchecked")
                                        var list = (List<Object>) obj;
                                        int index = params[0].getInt32();
                                        if (index < 0 || index >= list.size()) {
                                            throw new PuffinBasicRuntimeError(
                                                    ARRAY_INDEX_OUT_OF_BOUNDS,
                                                    "List index: " + index
                                                            + " is out of bounds, list size: " + list.size()
                                            );
                                        }
                                        if (type.getTypeId() == PuffinBasicTypeId.SCALAR) {
                                            type.getAtomTypeId().setValueIn(list.get(index), result);
                                        } else {
                                            STValue item = (STValue) list.get(index);
                                            if (item == null) {
                                                throw new PuffinBasicRuntimeError(
                                                        NOT_INITIALIZED,
                                                        "Value at list index: " + index
                                                                + " is not set!"
                                                );
                                            }
                                            result.replace(item);
                                        }
                                    }))
                            .add(new MemberFunction(
                                    "values", new PuffinBasicType[]{}, valuesType,
                                    (obj, params, result) -> {
                                        @SuppressWarnings("unchecked")
                                        var list = (List<Object>) obj;
                                        if (type.getTypeId() == PuffinBasicTypeId.SCALAR) {
                                            type.getAtomTypeId().copyArray(list, result);
                                        } else {
                                            throw new PuffinBasicRuntimeError(
                                                    BAD_FUNCTION_CALL,
                                                    "values() not supported for non-scalar type!"
                                            );
                                        }
                                    }))
                            .add(new MemberFunction(
                                    "clear", new PuffinBasicType[]{}, ScalarType.INT32,
                                    (obj, params, result) -> {
                                        @SuppressWarnings("unchecked")
                                        var list = (List<Object>) obj;
                                        list.clear();
                                        result.setInt32(0);
                                    }))
                            .build()
            );
        }

        @Override
        public PuffinBasicTypeId getTypeId() {
            return PuffinBasicTypeId.LIST;
        }

        @Override
        public PuffinBasicAtomTypeId getAtomTypeId() {
            return COMPOSITE;
        }

        @Override
        public STValue newInstance(PuffinBasicSymbolTable symbolTable) {
            return new STList(type, memberFunctions);
        }

        @Override
        public PuffinBasicType getFuncCallReturnType(String funcName) {
            return memberFunctions.get(funcName).returnType;
        }

        @Override
        public void checkFuncCallArguments(String funcName, List<PuffinBasicType> paramTypes) {
            memberFunctions.checkFuncCallArguments(funcName, paramTypes);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != ListType.class) {
                return false;
            }
            ListType o = (ListType) obj;
            return getTypeId() == o.getTypeId()
                    && getAtomTypeId() == o.getAtomTypeId();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getTypeId(), getAtomTypeId());
        }
    }

    public static final class SetType implements PuffinBasicType {

        private final PuffinBasicType type;
        private final MemberFunctions memberFunctions;

        public SetType(PuffinBasicType type) {
            this.type = type;
            ArrayType valuesType = new ArrayType(type.getAtomTypeId());
            this.memberFunctions = new MemberFunctions(
                    ImmutableList.<MemberFunction>builder()
                            .add(new MemberFunction(
                                    "add", new PuffinBasicType[]{type}, ScalarType.INT32,
                                    (obj, params, result) -> {
                                        @SuppressWarnings("unchecked")
                                        var set = (Set<Object>) obj;
                                        var value = type.getAtomTypeId().getValueFrom(params[0]);
                                        set.add(value);
                                        result.setInt32(0);
                                    }))
                            .add(new MemberFunction(
                                    "remove", new PuffinBasicType[]{type}, ScalarType.INT32,
                                    (obj, params, result) -> {
                                        @SuppressWarnings("unchecked")
                                        var set = (Set<Object>) obj;
                                        var value = type.getAtomTypeId().getValueFrom(params[0]);
                                        var removeRes = set.remove(value);
                                        result.setInt32(removeRes ? -1 : 0);
                                    }))
                            .add(new MemberFunction(
                                    "contains", new PuffinBasicType[]{type}, ScalarType.INT32,
                                    (obj, params, result) -> {
                                        @SuppressWarnings("unchecked")
                                        var set = (Set<Object>) obj;
                                        var value = type.getAtomTypeId().getValueFrom(params[0]);
                                        result.setInt32(set.contains(value) ? -1 : 0);
                                    }))
                            .add(new MemberFunction(
                                    "values", new PuffinBasicType[]{}, valuesType,
                                    (obj, params, result) -> {
                                        @SuppressWarnings("unchecked")
                                        var set = (Set<Object>) obj;
                                        type.getAtomTypeId().copyArray(set, result);
                                    }))
                            .add(new MemberFunction(
                                    "clear", new PuffinBasicType[]{}, ScalarType.INT32,
                                    (obj, params, result) -> {
                                        @SuppressWarnings("unchecked")
                                        var set = (Set<Object>) obj;
                                        set.clear();
                                        result.setInt32(0);
                                    }))
                            .build()
            );
        }

        @Override
        public PuffinBasicTypeId getTypeId() {
            return PuffinBasicTypeId.SET;
        }

        @Override
        public PuffinBasicAtomTypeId getAtomTypeId() {
            return COMPOSITE;
        }

        @Override
        public STValue newInstance(PuffinBasicSymbolTable symbolTable) {
            return new STSet(type, memberFunctions);
        }

        @Override
        public PuffinBasicType getFuncCallReturnType(String funcName) {
            return memberFunctions.get(funcName).returnType;
        }

        @Override
        public void checkFuncCallArguments(String funcName, List<PuffinBasicType> paramTypes) {
            memberFunctions.checkFuncCallArguments(funcName, paramTypes);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != SetType.class) {
                return false;
            }
            SetType o = (SetType) obj;
            return getTypeId() == o.getTypeId()
                    && getAtomTypeId() == o.getAtomTypeId();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getTypeId(), getAtomTypeId());
        }
    }

    public static final class DictType implements PuffinBasicType {

        private final PuffinBasicType keyType;
        private final PuffinBasicType valueType;
        private final MemberFunctions memberFunctions;

        public DictType(PuffinBasicType keyType, PuffinBasicType valueType) {
            this.keyType = keyType;
            this.valueType = valueType;
            ArrayType valuesType = new ArrayType(keyType.getAtomTypeId());
            this.memberFunctions = new MemberFunctions(
                    ImmutableList.<MemberFunction>builder()
                            .add(new MemberFunction(
                                    "put", new PuffinBasicType[]{keyType, valueType}, ScalarType.INT32,
                                    (obj, params, result) -> {
                                        @SuppressWarnings("unchecked")
                                        var dict = (Map<Object, Object>) obj;
                                        var key = keyType.getAtomTypeId().getValueFrom(params[0]);
                                        var value = valueType.getAtomTypeId().getValueFrom(params[1]);
                                        dict.put(key, value);
                                        result.setInt32(0);
                                    }))
                            .add(new MemberFunction(
                                    "removeKey", new PuffinBasicType[]{keyType}, ScalarType.INT32,
                                    (obj, params, result) -> {
                                        @SuppressWarnings("unchecked")
                                        var dict = (Map<Object, Object>) obj;
                                        var key = keyType.getAtomTypeId().getValueFrom(params[0]);
                                        var removeRes = dict.remove(key);
                                        result.setInt32(removeRes != null ? -1 : 0);
                                    }))
                            .add(new MemberFunction(
                                    "getOrDefault", new PuffinBasicType[]{keyType, valueType}, valueType,
                                    (obj, params, result) -> {
                                        @SuppressWarnings("unchecked")
                                        var dict = (Map<Object, Object>) obj;
                                        var key = keyType.getAtomTypeId().getValueFrom(params[0]);
                                        var value = valueType.getAtomTypeId().getValueFrom(params[1]);
                                        var getRes = dict.getOrDefault(key, value);
                                        valueType.getAtomTypeId().setValueIn(getRes, result);
                                    }))
                            .add(new MemberFunction(
                                    "containsKey", new PuffinBasicType[]{keyType}, ScalarType.INT32,
                                    (obj, params, result) -> {
                                        @SuppressWarnings("unchecked")
                                        var dict = (Map<Object, Object>) obj;
                                        var key = keyType.getAtomTypeId().getValueFrom(params[0]);
                                        result.setInt32(dict.containsKey(key) ? -1 : 0);
                                    }))
                            .add(new MemberFunction(
                                    "keys", new PuffinBasicType[]{}, valuesType,
                                    (obj, params, result) -> {
                                        @SuppressWarnings("unchecked")
                                        var dict = (Map<Object, Object>) obj;
                                        keyType.getAtomTypeId().copyArray(dict.keySet(), result);
                                    }))
                            .add(new MemberFunction(
                                    "clear", new PuffinBasicType[]{}, ScalarType.INT32,
                                    (obj, params, result) -> {
                                        @SuppressWarnings("unchecked")
                                        var dict = (Map<Object, Object>) obj;
                                        dict.clear();
                                        result.setInt32(0);
                                    }))
                            .build()
            );
        }

        @Override
        public PuffinBasicTypeId getTypeId() {
            return PuffinBasicTypeId.DICT;
        }

        @Override
        public PuffinBasicAtomTypeId getAtomTypeId() {
            return COMPOSITE;
        }

        @Override
        public STValue newInstance(PuffinBasicSymbolTable symbolTable) {
            return new STDict(valueType, memberFunctions);
        }

        @Override
        public PuffinBasicType getFuncCallReturnType(String funcName) {
            return memberFunctions.get(funcName).returnType;
        }

        @Override
        public void checkFuncCallArguments(String funcName, List<PuffinBasicType> paramTypes) {
            memberFunctions.checkFuncCallArguments(funcName, paramTypes);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != DictType.class) {
                return false;
            }
            DictType o = (DictType) obj;
            return getTypeId() == o.getTypeId()
                    && keyType == o.keyType
                    && valueType == o.valueType;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getTypeId(), keyType, valueType);
        }
    }

    public static abstract class AbstractSTEntry implements STEntry {
        private final PuffinBasicType type;
        private STValue value;

        AbstractSTEntry(STValue value, PuffinBasicType type) {
            this.value = value;
            this.type = type;
        }

        @Override
        public PuffinBasicType getType() {
            return type;
        }

        @Override
        public STValue getValue() {
            if (value == null) {
                throw new PuffinBasicInternalError("Value is not set for type: " + getType());
            }
            return value;
        }

        public void setValue(STValue value) {
            this.value = value;
        }

        public void createAndSetInstance(PuffinBasicSymbolTable symbolTable) {
            setValue(getType().newInstance(symbolTable));
        }
    }

    public static class STLValue extends AbstractSTEntry {
        STLValue(STValue value, PuffinBasicType type) {
            super(value, type);
        }

        @Override
        public boolean isLValue() {
            return true;
        }
    }

    public static class STVariable extends STLValue {
        private final Variable variable;

        public STVariable(STValue value, Variable variable) {
            super(value, variable.getType());
            this.variable = variable;
        }

        public Variable getVariable() {
            return variable;
        }
    }

    public static class STRef extends STLValue {
        private STEntry ref;

        STRef(PuffinBasicType type) {
            super(null, type);
        }

        private STEntry getRef() {
            if (ref == null) {
                throw new PuffinBasicInternalError("Ref is null");
            }
            return ref;
        }

        public void setRef(STEntry ref) {
            if (!ref.getType().equals(getType())) {
                throw new PuffinBasicRuntimeError(
                        DATA_TYPE_MISMATCH,
                        "Expected " + getType() + " got " + ref.getType()
                );
            }
            this.ref = ref;
        }

        @Override
        public STValue getValue() {
            return getRef().getValue();
        }
    }

    static final class STTmp extends AbstractSTEntry {
        STTmp(STValue value, PuffinBasicType type) {
            super(value, type);
        }
    }

    public static final class STUDF extends STVariable {

        private final IntList paramIds;

        STUDF(STValue value, Variable variable) {
            super(value, variable);
            this.paramIds = new IntArrayList();
        }

        public void declareParam(int paramId) {
            paramIds.add(paramId);
        }

        public int getNumDeclaredParams() {
            return paramIds.size();
        }

        public int getDeclaredParam(int i) {
            return paramIds.getInt(i);
        }
    }

    static final class STLabel extends AbstractSTEntry {
        STLabel() {
            super(new STInt32ScalarValue(), null);
        }

        @Override
        public PuffinBasicType getType() {
            throw new PuffinBasicInternalError("Labels don't have a type!");
        }
    }

    private static final class STInt32ScalarValue implements STValue {

        private boolean isSet;
        private int value;

        @Override
        public boolean isInitialized() {
            return isSet;
        }

        @Override
        public void setInitialized() {
            isSet = true;
        }

        @Override
        public String printFormat() {
            checkInitialized();
            return Formatter.printFormatInt32(value);
        }

        @Override
        public String writeFormat() {
            checkInitialized();
            return Formatter.writeFormatInt32(value);
        }

        @Override
        public void assign(STValue entry) {
            setInitialized();
            this.value = entry.getInt32();
        }

        @Override
        public int getInt32() {
            checkInitialized();
            return value;
        }

        @Override
        public void setInt32(int value) {
            setInitialized();
            this.value = value;
        }

        @Override
        public long getInt64() {
            checkInitialized();
            return value;
        }

        @Override
        public void setInt64(long value) {
            this.isSet = true;
            this.value = (int) value;
        }

        @Override
        public float getFloat32() {
            checkInitialized();
            return value;
        }

        @Override
        public void setFloat32(float value) {
            this.isSet = true;
            this.value = (int) value;
        }

        @Override
        public double getFloat64() {
            checkInitialized();
            return value;
        }

        @Override
        public void setFloat64(double value) {
            this.isSet = true;
            this.value = (int) value;
        }

        @Override
        public int getRoundedInt32() {
            checkInitialized();
            return value;
        }

        @Override
        public long getRoundedInt64() {
            checkInitialized();
            return value;
        }

        @Override
        public String getString() {
            throw new PuffinBasicInternalError("Can't cast int32 to String");
        }

        @Override
        public void setString(String value) {
            throw new PuffinBasicInternalError("Can't cast String to int32: '" + value + "'");
        }
    }

    private static final class STInt64ScalarValue implements STValue {

        private boolean isSet;
        private long value;

        @Override
        public boolean isInitialized() {
            return isSet;
        }

        @Override
        public void setInitialized() {
            isSet = true;
        }

        @Override
        public String printFormat() {
            checkInitialized();
            return Formatter.printFormatInt64(value);
        }

        @Override
        public String writeFormat() {
            checkInitialized();
            return Formatter.writeFormatInt64(value);
        }

        @Override
        public void assign(STValue entry) {
            this.isSet = true;
            this.value = entry.getInt64();
        }

        @Override
        public int getInt32() {
            checkInitialized();
            return (int) value;
        }

        @Override
        public void setInt32(int value) {
            this.isSet = true;
            this.value = value;
        }

        @Override
        public long getInt64() {
            checkInitialized();
            return value;
        }

        @Override
        public void setInt64(long value) {
            this.isSet = true;
            this.value = value;
        }

        @Override
        public float getFloat32() {
            checkInitialized();
            return value;
        }

        @Override
        public void setFloat32(float value) {
            this.isSet = true;
            this.value = (long) value;
        }

        @Override
        public double getFloat64() {
            checkInitialized();
            return value;
        }

        @Override
        public void setFloat64(double value) {
            this.isSet = true;
            this.value = (long) value;
        }

        @Override
        public int getRoundedInt32() {
            checkInitialized();
            return (int) value;
        }

        @Override
        public long getRoundedInt64() {
            checkInitialized();
            return value;
        }

        @Override
        public String getString() {
            throw new PuffinBasicInternalError("Can't cast int64 to String");
        }

        @Override
        public void setString(String value) {
            throw new PuffinBasicInternalError("Can't cast String to int64: '" + value + "'");
        }
    }

    private static final class STFloat32ScalarValue implements STValue {

        private boolean isSet;
        private float value;

        @Override
        public boolean isInitialized() {
            return isSet;
        }

        @Override
        public void setInitialized() {
            isSet = true;
        }

        @Override
        public String printFormat() {
            checkInitialized();
            return Formatter.printFormatFloat32(value);
        }

        @Override
        public String writeFormat() {
            checkInitialized();
            return Formatter.writeFormatFloat32(value);
        }

        @Override
        public void assign(STValue entry) {
            this.isSet = true;
            this.value = entry.getFloat32();
        }

        @Override
        public int getInt32() {
            checkInitialized();
            return (int) value;
        }

        @Override
        public void setInt32(int value) {
            this.isSet = true;
            this.value = value;
        }

        @Override
        public long getInt64() {
            checkInitialized();
            return (long) value;
        }

        @Override
        public void setInt64(long value) {
            this.isSet = true;
            this.value = value;
        }

        @Override
        public float getFloat32() {
            checkInitialized();
            return value;
        }

        @Override
        public void setFloat32(float value) {
            this.isSet = true;
            this.value = value;
        }

        @Override
        public double getFloat64() {
            checkInitialized();
            return value;
        }

        @Override
        public void setFloat64(double value) {
            this.isSet = true;
            this.value = (float) value;
        }

        @Override
        public int getRoundedInt32() {
            checkInitialized();
            return Math.round(value);
        }

        @Override
        public long getRoundedInt64() {
            checkInitialized();
            return Math.round(value);
        }

        @Override
        public String getString() {
            throw new PuffinBasicInternalError("Can't cast float32 to String");
        }

        @Override
        public void setString(String value) {
            throw new PuffinBasicInternalError("Can't cast String to float32: '" + value + "'");
        }
    }

    private static final class STFloat64ScalarValue implements STValue {

        private boolean isSet;
        private double value;

        @Override
        public boolean isInitialized() {
            return isSet;
        }

        @Override
        public void setInitialized() {
            isSet = true;
        }

        @Override
        public String printFormat() {
            checkInitialized();
            return Formatter.printFormatFloat64(value);
        }

        @Override
        public String writeFormat() {
            checkInitialized();
            return Formatter.writeFormatFloat64(value);
        }

        @Override
        public void assign(STValue entry) {
            this.isSet = true;
            this.value = entry.getFloat64();
        }

        @Override
        public int getInt32() {
            checkInitialized();
            return (int) value;
        }

        @Override
        public void setInt32(int value) {
            this.isSet = true;
            this.value = value;
        }

        @Override
        public long getInt64() {
            checkInitialized();
            return (long) value;
        }

        @Override
        public void setInt64(long value) {
            this.isSet = true;
            this.value = value;
        }

        @Override
        public float getFloat32() {
            checkInitialized();
            return (float) value;
        }

        @Override
        public void setFloat32(float value) {
            this.isSet = true;
            this.value = value;
        }

        @Override
        public double getFloat64() {
            checkInitialized();
            return value;
        }

        @Override
        public void setFloat64(double value) {
            this.isSet = true;
            this.value = value;
        }

        @Override
        public int getRoundedInt32() {
            checkInitialized();
            return (int) Math.round(value);
        }

        @Override
        public long getRoundedInt64() {
            checkInitialized();
            return Math.round(value);
        }

        @Override
        public String getString() {
            throw new PuffinBasicInternalError("Can't cast float64 to String");
        }

        @Override
        public void setString(String value) {
            throw new PuffinBasicInternalError("Can't cast String to float64: '" + value + "'");
        }
    }

    private static final class STStringScalarValue implements STValue {

        private boolean isSet;
        private int fieldLength;
        private String value = "";

        @Override
        public boolean isInitialized() {
            return isSet;
        }

        @Override
        public void setInitialized() {
            isSet = true;
        }

        @Override
        public String printFormat() {
            checkInitialized();
            return Formatter.printFormatString(value);
        }

        @Override
        public String writeFormat() {
            checkInitialized();
            return Formatter.writeFormatString(value);
        }

        @Override
        public void assign(STValue entry) {
            this.isSet = true;
            this.value = entry.getString();
        }

        @Override
        public int getInt32() {
            throw new PuffinBasicInternalError("Can't cast String to int32");
        }

        @Override
        public void setInt32(int value) {
            throw new PuffinBasicInternalError("Can't cast int32 to String");
        }

        @Override
        public long getInt64() {
            throw new PuffinBasicInternalError("Can't cast String to int64");
        }

        @Override
        public void setInt64(long value) {
            throw new PuffinBasicInternalError("Can't cast int64 to String");
        }

        @Override
        public float getFloat32() {
            throw new PuffinBasicInternalError("Can't cast String to float32");
        }

        @Override
        public void setFloat32(float value) {
            throw new PuffinBasicInternalError("Can't cast float32 to String");
        }

        @Override
        public double getFloat64() {
            throw new PuffinBasicInternalError("Can't cast String to float64");
        }

        @Override
        public void setFloat64(double value) {
            throw new PuffinBasicInternalError("Can't cast float64 to String");
        }

        @Override
        public int getRoundedInt32() {
            throw new PuffinBasicInternalError("Can't cast String to int32");
        }

        @Override
        public long getRoundedInt64() {
            throw new PuffinBasicInternalError("Can't cast String to int64");
        }

        @Override
        public String getString() {
            checkInitialized();
            return value;
        }

        @Override
        public void setString(String value) {
            this.isSet = true;
            this.value = value;
        }

        @Override
        public int getFieldLength() {
            return fieldLength;
        }

        @Override
        public void setFieldLength(int fieldLength) {
            this.fieldLength = fieldLength;
        }

        @Override
        public boolean hasLen() {
            return true;
        }

        @Override
        public int len() {
            return getString().length();
        }
    }

    private static final class STStringScalarTimeValue implements STValue {

        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_TIME;
        private LocalTime time;

        @Override
        public String printFormat() {
            return getString();
        }

        @Override
        public String writeFormat() {
            return getString();
        }

        @Override
        public void assign(STValue entry) {
            setString(entry.getString());
        }

        @Override
        public int getInt32() {
            throw new PuffinBasicInternalError("Can't cast String to int32");
        }

        @Override
        public void setInt32(int value) {
            throw new PuffinBasicInternalError("Can't cast int32 to String");
        }

        @Override
        public long getInt64() {
            throw new PuffinBasicInternalError("Can't cast String to int64");
        }

        @Override
        public void setInt64(long value) {
            throw new PuffinBasicInternalError("Can't cast int64 to String");
        }

        @Override
        public float getFloat32() {
            throw new PuffinBasicInternalError("Can't cast String to float32");
        }

        @Override
        public void setFloat32(float value) {
            throw new PuffinBasicInternalError("Can't cast float32 to String");
        }

        @Override
        public double getFloat64() {
            throw new PuffinBasicInternalError("Can't cast String to float64");
        }

        @Override
        public void setFloat64(double value) {
            throw new PuffinBasicInternalError("Can't cast float64 to String");
        }

        @Override
        public int getRoundedInt32() {
            throw new PuffinBasicInternalError("Can't cast String to int32");
        }

        @Override
        public long getRoundedInt64() {
            throw new PuffinBasicInternalError("Can't cast String to int64");
        }


        @Override
        public String getString() {
            return formatLocalTime(time != null ? time : LocalTime.now());
        }

        @Override
        public void setString(String value) {
            this.time = LocalTime.parse(value, FORMATTER);
        }

        private String formatLocalTime(LocalTime time) {
            return time.format(FORMATTER);
        }

        @Override
        public int getFieldLength() {
            return 0;
        }

        @Override
        public void setFieldLength(int fieldLength) {
            throw new PuffinBasicRuntimeError(
                    ILLEGAL_FUNCTION_PARAM,
                    "TIME$ cannot be used for setting field length!"
            );
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static final class STStringScalarDateValue implements STValue {

        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;
        private LocalDate date;

        @Override
        public String printFormat() {
            return getString();
        }

        @Override
        public String writeFormat() {
            return getString();
        }

        @Override
        public void assign(STValue entry) {
            setString(entry.getString());
        }

        @Override
        public int getInt32() {
            throw new PuffinBasicInternalError("Can't cast String to int32");
        }

        @Override
        public void setInt32(int value) {
            throw new PuffinBasicInternalError("Can't cast int32 to String");
        }

        @Override
        public long getInt64() {
            throw new PuffinBasicInternalError("Can't cast String to int64");
        }

        @Override
        public void setInt64(long value) {
            throw new PuffinBasicInternalError("Can't cast int64 to String");
        }

        @Override
        public float getFloat32() {
            throw new PuffinBasicInternalError("Can't cast String to float32");
        }

        @Override
        public void setFloat32(float value) {
            throw new PuffinBasicInternalError("Can't cast float32 to String");
        }

        @Override
        public double getFloat64() {
            throw new PuffinBasicInternalError("Can't cast String to float64");
        }

        @Override
        public void setFloat64(double value) {
            throw new PuffinBasicInternalError("Can't cast float64 to String");
        }

        @Override
        public int getRoundedInt32() {
            throw new PuffinBasicInternalError("Can't cast String to int32");
        }

        @Override
        public long getRoundedInt64() {
            throw new PuffinBasicInternalError("Can't cast String to int64");
        }

        @Override
        public String getString() {
            return formatLocalDate(date != null ? date : LocalDate.now());
        }

        @Override
        public void setString(String value) {
            this.date = LocalDate.parse(value, FORMATTER);
        }

        private String formatLocalDate(LocalDate date) {
            return date.format(FORMATTER);
        }

        @Override
        public int getFieldLength() {
            return 0;
        }

        @Override
        public void setFieldLength(int fieldLength) {
            throw new PuffinBasicRuntimeError(
                    ILLEGAL_FUNCTION_PARAM,
                    "DATE$ cannot be used for setting field length!"
            );
        }
    }

    static class ArrayReferenceValue implements STValue {

        private final STLValue variable;
        private int index1d;

        ArrayReferenceValue(STLValue variable) {
            this.variable = variable;
        }

        private AbstractSTArrayValue getValue() {
            return (AbstractSTArrayValue) variable.getValue();
        }

        @Override
        public void setArrayReferenceIndex1D(int index1d) {
            this.index1d = index1d;
        }

        @Override
        public String printFormat() {
            var array = getValue();
            array.setArrayIndexID(index1d);
            return array.printFormat();
        }

        @Override
        public String writeFormat() {
            var array = getValue();
            array.setArrayIndexID(index1d);
            return array.writeFormat();
        }

        @Override
        public void assign(STValue entry) {
            var array = getValue();
            array.setArrayIndexID(index1d);
            array.assign(entry);
        }

        @Override
        public int getInt32() {
            var array = getValue();
            array.setArrayIndexID(index1d);
            return array.getInt32();
        }

        @Override
        public void setInt32(int value) {
            var array = getValue();
            array.setArrayIndexID(index1d);
            array.setInt32(value);
        }

        @Override
        public long getInt64() {
            var array = getValue();
            array.setArrayIndexID(index1d);
            return array.getInt64();
        }

        @Override
        public void setInt64(long value) {
            var array = getValue();
            array.setArrayIndexID(index1d);
            array.setInt64(value);
        }

        @Override
        public float getFloat32() {
            var array = getValue();
            array.setArrayIndexID(index1d);
            return array.getFloat32();
        }

        @Override
        public void setFloat32(float value) {
            var array = getValue();
            array.setArrayIndexID(index1d);
            array.setFloat32(value);
        }

        @Override
        public double getFloat64() {
            var array = getValue();
            array.setArrayIndexID(index1d);
            return array.getFloat64();
        }

        @Override
        public void setFloat64(double value) {
            var array = getValue();
            array.setArrayIndexID(index1d);
            array.setFloat64(value);
        }

        @Override
        public int getRoundedInt32() {
            var array = getValue();
            array.setArrayIndexID(index1d);
            return array.getRoundedInt32();
        }

        @Override
        public long getRoundedInt64() {
            var array = getValue();
            array.setArrayIndexID(index1d);
            return array.getRoundedInt64();
        }

        @Override
        public String getString() {
            var array = getValue();
            array.setArrayIndexID(index1d);
            return array.getString();
        }

        @Override
        public void setString(String value) {
            var array = getValue();
            array.setArrayIndexID(index1d);
            array.setString(value);
        }
    }

    static abstract class AbstractSTArrayValue implements STValue {

        private IntList dimensions;
        private int totalLength;
        private int index1d;
        private int ndim;

        @Override
        public void replace(STValue entry) {
            var from = (AbstractSTArrayValue) entry;
            dimensions = from.dimensions;
            totalLength = from.totalLength;
            ndim = from.ndim;
        }

        @Override
        public int getTotalLength() {
            return totalLength;
        }

        @Override
        public int getNumArrayDimensions() {
            return ndim;
        }

        @Override
        public IntList getArrayDimensions() {
            return dimensions;
        }

        @Override
        public void setArrayDimensions(IntList dims) {
            this.dimensions = new IntArrayList(dims);
            this.ndim = dimensions.size();
            int totalLen = 1;
            for (int i = 0; i < ndim; i++) {
                totalLen *= dimensions.getInt(i);
            }
            totalLength = totalLen;
        }

        @Override
        public void resetArrayIndex() {
            this.index1d = 0;
        }

        @Override
        public void setArrayIndex(int dim, int index) {
            if (dim < 0 || dim >= dimensions.size()) {
                throw new PuffinBasicRuntimeError(
                        ARRAY_INDEX_OUT_OF_BOUNDS,
                        "Dimension index " + dim + " is out of range, #dims=" + dimensions.size()
                );
            }
            if (index < 0 || index >= dimensions.getInt(dim)) {
                throw new PuffinBasicRuntimeError(
                        ARRAY_INDEX_OUT_OF_BOUNDS,
                        "Index " + index + " is out of range for dimension["
                                + dim + "]=" + dimensions.getInt(dim)
                );
            }
            int dIplus1 = dim + 1 < ndim ? dimensions.getInt(dim + 1) : 1;
            this.index1d = (this.index1d + index) * dIplus1;
        }

        @Override
        public int getArrayIndex1D() {
            return index1d;
        }

        public void setArrayIndexID(int index1d) {
            this.index1d = index1d;
        }
    }

    public static final class STInt32ArrayValue extends AbstractSTArrayValue {

        private int[] value;

        @Override
        public void replace(STValue entry) {
            super.replace(entry);
            var from = (STInt32ArrayValue) entry;
            value = from.value;
        }

        @Override
        public void fill(Number fill) {
            Arrays.fill(value, fill.intValue());
        }

        public int[] getValue() {
            return value;
        }

        @Override
        public int[] getInt32Array1D() {
            return value;
        }

        @Override
        public void setArrayDimensions(IntList dims) {
            super.setArrayDimensions(dims);
            this.value = new int[getTotalLength()];
        }

        @Override
        public String printFormat() {
            return Formatter.printFormatInt32(value[getArrayIndex1D()]);
        }

        @Override
        public String writeFormat() {
            return Formatter.writeFormatInt32(value[getArrayIndex1D()]);
        }

        @Override
        public void assign(STValue entry) {
            value[getArrayIndex1D()] = entry.getInt32();
        }

        @Override
        public int getInt32() {
            return value[getArrayIndex1D()];
        }

        @Override
        public void setInt32(int value) {
            this.value[getArrayIndex1D()] = value;
        }

        @Override
        public long getInt64() {
            return value[getArrayIndex1D()];
        }

        @Override
        public void setInt64(long value) {
            this.value[getArrayIndex1D()] = (int) value;
        }

        @Override
        public float getFloat32() {
            return value[getArrayIndex1D()];
        }

        @Override
        public void setFloat32(float value) {
            this.value[getArrayIndex1D()] = (int) value;
        }

        @Override
        public double getFloat64() {
            return value[getArrayIndex1D()];
        }

        @Override
        public void setFloat64(double value) {
            this.value[getArrayIndex1D()] = (int) value;
        }

        @Override
        public int getRoundedInt32() {
            return value[getArrayIndex1D()];
        }

        @Override
        public long getRoundedInt64() {
            return value[getArrayIndex1D()];
        }

        @Override
        public String getString() {
            throw new PuffinBasicInternalError("Can't cast int32 to String");
        }

        @Override
        public void setString(String value) {
            throw new PuffinBasicInternalError("Can't cast String to int32: '" + value + "'");
        }
    }

    public static final class STInt64ArrayValue extends AbstractSTArrayValue {

        private long[] value;

        @Override
        public void fill(Number fill) {
            Arrays.fill(value, fill.longValue());
        }

        public long[] getValue() {
            return value;
        }

        @Override
        public void setArrayDimensions(IntList dims) {
            super.setArrayDimensions(dims);
            this.value = new long[getTotalLength()];
        }

        @Override
        public String printFormat() {
            return Formatter.printFormatInt64(value[getArrayIndex1D()]);
        }

        @Override
        public String writeFormat() {
            return Formatter.writeFormatInt64(value[getArrayIndex1D()]);
        }

        @Override
        public void assign(STValue entry) {
            value[getArrayIndex1D()] = entry.getInt64();
        }

        @Override
        public int getInt32() {
            return (int) value[getArrayIndex1D()];
        }

        @Override
        public void setInt32(int value) {
            this.value[getArrayIndex1D()] = value;
        }

        @Override
        public long getInt64() {
            return value[getArrayIndex1D()];
        }

        @Override
        public void setInt64(long value) {
            this.value[getArrayIndex1D()] = (int) value;
        }

        @Override
        public float getFloat32() {
            return value[getArrayIndex1D()];
        }

        @Override
        public void setFloat32(float value) {
            this.value[getArrayIndex1D()] = (int) value;
        }

        @Override
        public double getFloat64() {
            return value[getArrayIndex1D()];
        }

        @Override
        public void setFloat64(double value) {
            this.value[getArrayIndex1D()] = (int) value;
        }

        @Override
        public int getRoundedInt32() {
            return (int) value[getArrayIndex1D()];
        }

        @Override
        public long getRoundedInt64() {
            return value[getArrayIndex1D()];
        }

        @Override
        public String getString() {
            throw new PuffinBasicInternalError("Can't cast int32 to String");
        }

        @Override
        public void setString(String value) {
            throw new PuffinBasicInternalError("Can't cast String to int32: '" + value + "'");
        }
    }

    public static final class STFloat32ArrayValue extends AbstractSTArrayValue {

        private float[] value;

        @Override
        public void fill(Number fill) {
            Arrays.fill(value, fill.floatValue());
        }

        public float[] getValue() {
            return value;
        }

        @Override
        public void setArrayDimensions(IntList dims) {
            super.setArrayDimensions(dims);
            this.value = new float[getTotalLength()];
        }

        @Override
        public String printFormat() {
            return Formatter.printFormatFloat32(value[getArrayIndex1D()]);
        }

        @Override
        public String writeFormat() {
            return Formatter.writeFormatFloat32(value[getArrayIndex1D()]);
        }

        @Override
        public void assign(STValue entry) {
            value[getArrayIndex1D()] = entry.getFloat32();
        }

        @Override
        public int getInt32() {
            return (int) value[getArrayIndex1D()];
        }

        @Override
        public void setInt32(int value) {
            this.value[getArrayIndex1D()] = value;
        }

        @Override
        public long getInt64() {
            return (long) value[getArrayIndex1D()];
        }

        @Override
        public void setInt64(long value) {
            this.value[getArrayIndex1D()] = (int) value;
        }

        @Override
        public float getFloat32() {
            return value[getArrayIndex1D()];
        }

        @Override
        public void setFloat32(float value) {
            this.value[getArrayIndex1D()] = (int) value;
        }

        @Override
        public double getFloat64() {
            return value[getArrayIndex1D()];
        }

        @Override
        public void setFloat64(double value) {
            this.value[getArrayIndex1D()] = (int) value;
        }

        @Override
        public int getRoundedInt32() {
            return Math.round(value[getArrayIndex1D()]);
        }

        @Override
        public long getRoundedInt64() {
            return Math.round(value[getArrayIndex1D()]);
        }

        @Override
        public String getString() {
            throw new PuffinBasicInternalError("Can't cast int32 to String");
        }

        @Override
        public void setString(String value) {
            throw new PuffinBasicInternalError("Can't cast String to int32: '" + value + "'");
        }
    }

    public static final class STFloat64ArrayValue extends AbstractSTArrayValue {

        private double[] value;

        @Override
        public void fill(Number fill) {
            Arrays.fill(value, fill.doubleValue());
        }

        public double[] getValue() {
            return value;
        }

        @Override
        public void setArrayDimensions(IntList dims) {
            super.setArrayDimensions(dims);
            this.value = new double[getTotalLength()];
        }

        @Override
        public String printFormat() {
            return Formatter.printFormatFloat64(value[getArrayIndex1D()]);
        }

        @Override
        public String writeFormat() {
            return Formatter.writeFormatFloat64(value[getArrayIndex1D()]);
        }

        @Override
        public void assign(STValue entry) {
            value[getArrayIndex1D()] = entry.getFloat64();
        }

        @Override
        public int getInt32() {
            return (int) value[getArrayIndex1D()];
        }

        @Override
        public void setInt32(int value) {
            this.value[getArrayIndex1D()] = value;
        }

        @Override
        public long getInt64() {
            return (long) value[getArrayIndex1D()];
        }

        @Override
        public void setInt64(long value) {
            this.value[getArrayIndex1D()] = (int) value;
        }

        @Override
        public float getFloat32() {
            return (float) value[getArrayIndex1D()];
        }

        @Override
        public void setFloat32(float value) {
            this.value[getArrayIndex1D()] = (int) value;
        }

        @Override
        public double getFloat64() {
            return value[getArrayIndex1D()];
        }

        @Override
        public void setFloat64(double value) {
            this.value[getArrayIndex1D()] = (int) value;
        }

        @Override
        public int getRoundedInt32() {
            return (int) Math.round(value[getArrayIndex1D()]);
        }

        @Override
        public long getRoundedInt64() {
            return Math.round(value[getArrayIndex1D()]);
        }

        @Override
        public String getString() {
            throw new PuffinBasicInternalError("Can't cast int32 to String");
        }

        @Override
        public void setString(String value) {
            throw new PuffinBasicInternalError("Can't cast String to int32: '" + value + "'");
        }
    }

    public static final class STStringArrayValue extends AbstractSTArrayValue {

        private String[] value;

        @Override
        public void fillString(String fill) {
            Arrays.fill(value, fill);
        }

        public String[] getValue() {
            return value;
        }

        @Override
        public void setArrayDimensions(IntList dims) {
            super.setArrayDimensions(dims);
            this.value = new String[getTotalLength()];
            Arrays.fill(value, 0, value.length, "");
        }

        @Override
        public String printFormat() {
            return Formatter.printFormatString(value[getArrayIndex1D()]);
        }

        @Override
        public String writeFormat() {
            return Formatter.writeFormatString(value[getArrayIndex1D()]);
        }

        @Override
        public void assign(STValue entry) {
            value[getArrayIndex1D()] = entry.getString();
        }

        @Override
        public int getInt32() {
            throw new PuffinBasicInternalError("Can't cast String to int32");
        }

        @Override
        public void setInt32(int value) {
            throw new PuffinBasicInternalError("Can't cast int32 to String");
        }

        @Override
        public long getInt64() {
            throw new PuffinBasicInternalError("Can't cast String to int64");
        }

        @Override
        public void setInt64(long value) {
            throw new PuffinBasicInternalError("Can't cast int64 to String");
        }

        @Override
        public float getFloat32() {
            throw new PuffinBasicInternalError("Can't cast String to float32");
        }

        @Override
        public void setFloat32(float value) {
            throw new PuffinBasicInternalError("Can't cast float32 to String");
        }

        @Override
        public double getFloat64() {
            throw new PuffinBasicInternalError("Can't cast String to float64");
        }

        @Override
        public void setFloat64(double value) {
            throw new PuffinBasicInternalError("Can't cast float64 to String");
        }

        @Override
        public int getRoundedInt32() {
            throw new PuffinBasicInternalError("Can't cast String to int32");
        }

        @Override
        public long getRoundedInt64() {
            throw new PuffinBasicInternalError("Can't cast String to int64");
        }

        @Override
        public String getString() {
            return value[getArrayIndex1D()];
        }

        @Override
        public void setString(String value) {
            this.value[getArrayIndex1D()] = value;
        }
    }

    static abstract class STCompositeValue implements STValue {
        private final PuffinBasicTypeId type;
        private final PuffinBasicAtomTypeId atomType;

        STCompositeValue(
                PuffinBasicTypeId type,
                PuffinBasicAtomTypeId atomType) {
            this.type = type;
            this.atomType = atomType;
        }

        @Override
        public String printFormat() {
            throw new PuffinBasicInternalError("Not implemented");
        }

        @Override
        public String writeFormat() {
            throw new PuffinBasicInternalError("Not implemented");
        }

        @Override
        public void assign(STValue entry) {
            throw new PuffinBasicInternalError("Not implemented");
        }

        @Override
        public int getInt32() {
            throw new PuffinBasicInternalError("Not implemented");
        }

        @Override
        public void setInt32(int value) {
            throw new PuffinBasicInternalError("Not implemented");
        }

        @Override
        public long getInt64() {
            throw new PuffinBasicInternalError("Not implemented");
        }

        @Override
        public void setInt64(long value) {
            throw new PuffinBasicInternalError("Not implemented");
        }

        @Override
        public float getFloat32() {
            throw new PuffinBasicInternalError("Not implemented");
        }

        @Override
        public void setFloat32(float value) {
            throw new PuffinBasicInternalError("Not implemented");
        }

        @Override
        public double getFloat64() {
            throw new PuffinBasicInternalError("Not implemented");
        }

        @Override
        public void setFloat64(double value) {
            throw new PuffinBasicInternalError("Not implemented");
        }

        @Override
        public int getRoundedInt32() {
            throw new PuffinBasicInternalError("Not implemented");
        }

        @Override
        public long getRoundedInt64() {
            throw new PuffinBasicInternalError("Not implemented");
        }

        @Override
        public String getString() {
            throw new PuffinBasicInternalError("Not implemented");
        }

        @Override
        public void setString(String value) {
            throw new PuffinBasicInternalError("Not implemented");
        }
    }

    static final class STList extends STCompositeValue {
        private final List<Object> list;
        private final MemberFunctions memberFunctions;

        STList(PuffinBasicType type, MemberFunctions memberFunctions) {
            super(PuffinBasicTypeId.LIST, type.getAtomTypeId());
            this.memberFunctions = memberFunctions;
            this.list = new ArrayList<>();
        }

        public void call(String funcName, STValue[] params, STValue result) {
            memberFunctions.get(funcName).callHandler.call(list, params, result);
        }

        @Override
        public boolean hasLen() {
            return true;
        }

        @Override
        public int len() {
            return list.size();
        }
    }

    static final class STSet extends STCompositeValue {
        private final ObjectSet<Object> set;
        private final MemberFunctions memberFunctions;

        STSet(PuffinBasicType type, MemberFunctions memberFunctions) {
            super(PuffinBasicTypeId.SET, type.getAtomTypeId());
            this.memberFunctions = memberFunctions;
            this.set = new ObjectOpenHashSet<>();
        }

        public void call(String funcName, STValue[] params, STValue result) {
            memberFunctions.get(funcName).callHandler.call(set, params, result);
        }

        @Override
        public boolean hasLen() {
            return true;
        }

        @Override
        public int len() {
            return set.size();
        }
    }

    static final class STDict extends STCompositeValue {
        private final Object2ObjectMap<Object, Object> dict;
        private final MemberFunctions memberFunctions;

        STDict(PuffinBasicType valueType, MemberFunctions memberFunctions) {
            super(PuffinBasicTypeId.DICT, valueType.getAtomTypeId());
            this.memberFunctions = memberFunctions;
            this.dict = new Object2ObjectOpenHashMap<>();
        }

        public void call(String funcName, STValue[] params, STValue result) {
            memberFunctions.get(funcName).callHandler.call(dict, params, result);
        }

        @Override
        public boolean hasLen() {
            return true;
        }

        @Override
        public int len() {
            return dict.size();
        }
    }

    public static final class STStruct extends STCompositeValue {
        private final StructType structType;
        private final Int2IntMap memberRefIdToValueId;

        STStruct(PuffinBasicSymbolTable symbolTable, StructType type) {
            super(PuffinBasicTypeId.STRUCT, PuffinBasicAtomTypeId.COMPOSITE);
            this.structType = type;
            this.memberRefIdToValueId = new Int2IntOpenHashMap();
            for (var entry : structType.nameToRefIdMap.object2IntEntrySet()) {
                var memberRefId = entry.getIntValue();
                var valueType = structType.refIdToTypeMap.get(memberRefId);
                var valueId = symbolTable.addTmp(valueType, e -> e.getValue().setInitialized());
                this.memberRefIdToValueId.put(memberRefId, valueId);
            }
        }

        public int getMember(int memberRefId) {
            return memberRefIdToValueId.getOrDefault(memberRefId, NULL_ID);
        }

        @Override
        public void assign(STValue entry) {
            if (!(entry instanceof STStruct)) {
                throw new PuffinBasicRuntimeError(
                        DATA_TYPE_MISMATCH,
                        "Expected STStruct but found: " + entry.getClass()
                );
            }
            STStruct other = (STStruct) entry;
            if (!structType.equals(other.structType)) {
                throw new PuffinBasicRuntimeError(
                        DATA_TYPE_MISMATCH,
                        "Expected struct " + structType + ", but found " + other.structType
                );
            }
            this.memberRefIdToValueId.clear();
            this.memberRefIdToValueId.putAll(((STStruct) entry).memberRefIdToValueId);
        }
    }
}
