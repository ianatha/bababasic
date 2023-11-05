package org.puffinbasic.domain

import com.google.common.collect.ImmutableList
import org.puffinbasic.domain.Variable.VariableName
import org.puffinbasic.error.PuffinBasicInternalError
import org.puffinbasic.error.PuffinBasicRuntimeError
import org.puffinbasic.runtime.Formatter
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Arrays
import java.util.Objects
import java.util.function.Consumer
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class STObjects {
    enum class PuffinBasicTypeId {
        SCALAR, ARRAY, UDF, STRUCT, LIST, SET, DICT
    }

    enum class PuffinBasicAtomTypeId(protected val _repr: Char?) {
        INT32('%') {
            override fun createVariableEntry(variable: Variable): STVariable {
                return if (variable.isArray) {
                    STVariable(STInt32ArrayValue(), variable)
                } else if (variable.isUDF) {
                    STUDF(STInt32ScalarValue(), variable)
                } else if (variable.isScalar) {
                    STVariable(STInt32ScalarValue(), variable)
                } else {
                    throw PuffinBasicInternalError("Variable type not supported: $variable")
                }
            }

            override fun createTmpEntry(): STTmp {
                return STTmp(STInt32ScalarValue(), ScalarType.INT32)
            }

            override fun createArrayEntry(): STTmp {
                return STTmp(STInt32ArrayValue(), ScalarType.INT32)
            }

            override fun createValue(): STValue {
                return STInt32ScalarValue()
            }

            override fun getValueFrom(src: STValue): Any {
                return src.int32
            }

            override fun setValueIn(value: Any, dst: STValue) {
                dst.int32 = value as Int
            }

            override fun copyArray(src: Collection<*>, dst: STValue) {
                dst.arrayDimensions = mutableListOf(src.size)
                val array = (dst as STInt32ArrayValue).int32Array1D
                var i = 0
                for (o in src) {
                    array[i++] = o as Int
                }
            }

            override fun copyArray(src: Array<*>, dst: STValue) {
                val srcList = src as Array<Int>
                dst.arrayDimensions = mutableListOf(src.size)
                val array = (dst as STInt32ArrayValue).int32Array1D
                var i = 0
                for (o in srcList) {
                    array[i++] = o
                }
            }

            override fun isCompatibleWith(other: PuffinBasicAtomTypeId): Boolean {
                return other === INT32 || other === INT64 || other === FLOAT || other === DOUBLE
            }
        },
        INT64('@') {
            override fun createVariableEntry(variable: Variable): STVariable {
                return if (variable.isArray) {
                    STVariable(STInt64ArrayValue(), variable)
                } else if (variable.isUDF) {
                    STUDF(STInt64ScalarValue(), variable)
                } else if (variable.isScalar) {
                    STVariable(STInt64ScalarValue(), variable)
                } else {
                    throw PuffinBasicInternalError("Variable type not supported: $variable")
                }
            }

            override fun createTmpEntry(): STTmp {
                return STTmp(STInt64ScalarValue(), ScalarType.INT64)
            }

            override fun createArrayEntry(): STTmp {
                return STTmp(STInt64ArrayValue(), ScalarType.INT64)
            }

            override fun createValue(): STValue {
                return STInt64ScalarValue()
            }

            override fun getValueFrom(src: STValue): Any {
                return src.int64
            }

            override fun setValueIn(value: Any, dst: STValue) {
                dst.int64 = value as Long
            }

            override fun copyArray(src: Collection<*>, dst: STValue) {
                dst.arrayDimensions = mutableListOf(src.size)
                val array = (dst as STInt64ArrayValue).value
                var i = 0
                for (o in src) {
                    array[i++] = o as Long
                }
            }

            override fun copyArray(src: Array<*>, dst: STValue) {
                val srcList = src as Array<Long>
                dst.arrayDimensions = mutableListOf(src.size)
                val array = (dst as STInt64ArrayValue).value
                var i = 0
                for (o in srcList) {
                    array[i++] = o
                }
            }

            override fun isCompatibleWith(other: PuffinBasicAtomTypeId): Boolean {
                return other === INT32 || other === INT64 || other === FLOAT || other === DOUBLE
            }
        },
        FLOAT('!') {
            override fun createVariableEntry(variable: Variable): STVariable {
                return if (variable.isArray) {
                    STVariable(STFloat32ArrayValue(), variable)
                } else if (variable.isUDF) {
                    STUDF(STFloat32ScalarValue(), variable)
                } else if (variable.isScalar) {
                    STVariable(STFloat32ScalarValue(), variable)
                } else {
                    throw PuffinBasicInternalError("Variable type not supported: $variable")
                }
            }

            override fun createTmpEntry(): STTmp {
                return STTmp(STFloat32ScalarValue(), ScalarType.FLOAT32)
            }

            override fun createArrayEntry(): STTmp {
                return STTmp(STFloat32ArrayValue(), ScalarType.FLOAT32)
            }

            override fun createValue(): STValue {
                return STFloat32ScalarValue()
            }

            override fun getValueFrom(src: STValue): Any {
                return src.float32
            }

            override fun setValueIn(value: Any, dst: STValue) {
                dst.float32 = value as Float
            }

            override fun copyArray(src: Collection<*>, dst: STValue) {
                dst.arrayDimensions = mutableListOf(src.size)
                val array = (dst as STFloat32ArrayValue).value
                var i = 0
                for (o in src) {
                    array[i++] = o as Float
                }
            }

            override fun copyArray(src: Array<*>, dst: STValue) {
                val srcList = src as Array<Float>
                dst.arrayDimensions = mutableListOf(src.size)
                val array = (dst as STFloat32ArrayValue).value
                var i = 0
                for (o in srcList) {
                    array[i++] = o
                }
            }

            override fun isCompatibleWith(other: PuffinBasicAtomTypeId): Boolean {
                return other === INT32 || other === INT64 || other === FLOAT || other === DOUBLE
            }
        },
        DOUBLE('#') {
            override fun createVariableEntry(variable: Variable): STVariable {
                return if (variable.isArray) {
                    STVariable(STFloat64ArrayValue(), variable)
                } else if (variable.isUDF) {
                    STUDF(STFloat64ScalarValue(), variable)
                } else if (variable.isScalar) {
                    STVariable(STFloat64ScalarValue(), variable)
                } else {
                    throw PuffinBasicInternalError("Variable type not supported: $variable")
                }
            }

            override fun createTmpEntry(): STTmp {
                return STTmp(STFloat64ScalarValue(), ScalarType.FLOAT64)
            }

            override fun createArrayEntry(): STTmp {
                return STTmp(STFloat64ArrayValue(), ScalarType.FLOAT64)
            }

            override fun createValue(): STValue {
                return STFloat64ScalarValue()
            }

            override fun getValueFrom(src: STValue): Any {
                return src.float64
            }

            override fun setValueIn(value: Any, dst: STValue) {
                dst.float64 = value as Double
            }

            override fun copyArray(src: Collection<*>, dst: STValue) {
                dst.arrayDimensions = mutableListOf(src.size)
                val array = (dst as STFloat64ArrayValue).value
                var i = 0
                for (o in src) {
                    array[i++] = o as Double
                }
            }

            override fun copyArray(src: Array<*>, dst: STValue) {
                val srcList = src as Array<Double>
                dst.arrayDimensions = mutableListOf(src.size)
                val array = (dst as STFloat64ArrayValue).value
                var i = 0
                for (o in srcList) {
                    array[i++] = o
                }
            }

            override fun isCompatibleWith(other: PuffinBasicAtomTypeId): Boolean {
                return other === INT32 || other === INT64 || other === FLOAT || other === DOUBLE
            }
        },
        STRING('$') {
            override fun createVariableEntry(variable: Variable): STVariable {
                return if (variable.isArray) {
                    STVariable(STStringArrayValue(), variable)
                } else if (variable.isUDF) {
                    STUDF(STStringScalarValue(), variable)
                } else if (variable.isScalar) {
                    val varname = variable.variableName.varname
                    if (varname.equals("date", ignoreCase = true)) {
                        STVariable(STStringScalarDateValue(), variable)
                    } else if (varname.equals("time", ignoreCase = true)) {
                        STVariable(STStringScalarTimeValue(), variable)
                    } else {
                        STVariable(STStringScalarValue(), variable)
                    }
                } else {
                    throw PuffinBasicInternalError("Variable type not supported: $variable")
                }
            }

            override fun createTmpEntry(): STTmp {
                return STTmp(STStringScalarValue(), ScalarType.STRING)
            }

            override fun createArrayEntry(): STTmp {
                return STTmp(STStringArrayValue(), ScalarType.STRING)
            }

            override fun createValue(): STValue {
                return STStringScalarValue()
            }

            override fun getValueFrom(src: STValue): Any? {
                return src.string
            }

            override fun setValueIn(value: Any, dst: STValue) {
                dst.string = value as String
            }

            override fun copyArray(src: Collection<*>, dst: STValue) {
                dst.arrayDimensions = mutableListOf(src.size)
                val array = (dst as STStringArrayValue).value
                var i = 0
                for (o in src) {
                    array[i++] = o as String?
                }
            }

            override fun copyArray(src: Array<*>, dst: STValue) {
                val srcList = src as Array<String>
                dst.arrayDimensions = mutableListOf(src.size)
                val array = (dst as STStringArrayValue).value
                var i = 0
                for (o in srcList) {
                    array[i++] = o
                }
            }

            override fun isCompatibleWith(other: PuffinBasicAtomTypeId): Boolean {
                return other === STRING
            }
        },
        COMPOSITE(null) {
            override fun createVariableEntry(variable: Variable): STVariable {
                return STVariable(null, variable)
            }

            override fun createTmpEntry(): STTmp {
                throw PuffinBasicInternalError("Not implemented")
            }

            override fun createArrayEntry(): STTmp {
                throw PuffinBasicInternalError("Not implemented")
            }

            override fun createValue(): STValue {
                throw PuffinBasicInternalError("Not implemented")
            }

            override fun getValueFrom(src: STValue): Any? {
                throw PuffinBasicInternalError("Not implemented")
            }

            override fun setValueIn(value: Any, dst: STValue) {
                throw PuffinBasicInternalError("Not implemented")
            }

            override fun copyArray(src: Collection<*>, dst: STValue) {
                throw PuffinBasicInternalError("Not implemented")
            }

            override fun copyArray(src: Array<*>, dst: STValue) {
                throw PuffinBasicInternalError("Not implemented")
            }

            override fun isCompatibleWith(other: PuffinBasicAtomTypeId): Boolean {
                return other === COMPOSITE
            }
        };

        abstract fun createVariableEntry(variable: Variable): STVariable
        abstract fun createTmpEntry(): STTmp
        abstract fun createArrayEntry(): STTmp
        abstract fun createValue(): STValue
        abstract fun isCompatibleWith(other: PuffinBasicAtomTypeId): Boolean
        abstract fun getValueFrom(src: STValue): Any?
        abstract fun setValueIn(value: Any, dst: STValue)
        abstract fun copyArray(src: Collection<*>, dst: STValue)
        abstract fun copyArray(src: Array<*>, dst: STValue)
        fun getRepr(): String? {
            return _repr?.toString()
        }

        companion object {
            private val mapping: MutableMap<Int, PuffinBasicAtomTypeId> = mutableMapOf()

            init {
                for (value in values()) {
                    if (value._repr != null) {
                        mapping[value._repr.code] = value
                    }
                }
            }

            @JvmStatic
            fun lookup(repr: String?): PuffinBasicAtomTypeId {
                if (repr == null || repr.length != 1) {
                    throw PuffinBasicInternalError(
                        "Variable suffix: '$repr' is null or length != 1"
                    )
                }
                return mapping[repr[0].code]
                    ?: throw PuffinBasicInternalError(
                        "Variable suffix '$repr' is invalid"
                    )
            }
        }
    }

    interface PuffinBasicType {
        val typeId: PuffinBasicTypeId
        val atomTypeId: PuffinBasicAtomTypeId
        fun newInstance(symbolTable: PuffinBasicSymbolTable): STValue
        fun canBeLValue(): Boolean {
            return false
        }

        fun getFuncCallReturnType(funcName: String): PuffinBasicType {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.BAD_FIELD,
                "Unsupported function: $funcName in type: $this"
            )
        }

        fun checkFuncCallArguments(funcName: String, paramTypes: List<PuffinBasicType>) {}
        fun isCompatibleWith(other: PuffinBasicType): Boolean {
            return this == other
        }

        fun asStruct(): StructType? {
            if (typeId != PuffinBasicTypeId.STRUCT) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.BAD_FIELD,
                    "Type is not struct!"
                )
            }
            return this as StructType
        }
    }

    interface STEntry {
        val isLValue: Boolean
            get() = false
        val value: STValue?
        val type: PuffinBasicType?
    }

    interface STValue {
        fun printFormat(): String?
        fun writeFormat(): String?
        fun assign(entry: STValue)
        fun replace(entry: STValue) {
            assign(entry)
        }

        var int32: Int
        var int64: Long
        var float32: Float
        var float64: Double
        val roundedInt32: Int
        val roundedInt64: Long
        var string: String?
        var fieldLength: Int
            get() = 0
            set(fieldLength) {}
        var arrayDimensions: List<Int>?
            get() = listOf()
            set(dims) {}
        val totalLength: Int
            get() = 0
        val numArrayDimensions: Int
            get() = 0

        fun setArrayIndex(dim: Int, index: Int) {}
        fun resetArrayIndex() {}
        val arrayIndex1D: Int
            get() = 0

        fun setArrayReferenceIndex1D(index1d: Int) {
            throw PuffinBasicInternalError("Unsupported")
        }

        val int32Array1D: IntArray
            get() {
                throw PuffinBasicInternalError("Unsupported")
            }

        fun fill(fill: Number) {
            throw PuffinBasicInternalError("Unsupported")
        }

        fun fillString(fill: String?) {
            throw PuffinBasicInternalError("Unsupported")
        }

        val isInitialized: Boolean
            get() = true

        fun checkInitialized() {
            if (!this.isInitialized) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.NOT_INITIALIZED,
                    "Value cannot be read without initializing"
                )
            }
        }

        fun setInitialized() {}
        fun call(funcName: String, params: Array<STValue>, result: STValue) {
            throw PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.BAD_FIELD,
                "Function call is not supported: $funcName"
            )
        }

        fun hasLen(): Boolean {
            return false
        }

        fun len(): Int {
            throw PuffinBasicInternalError("Not implemented")
        }
    }

    class ScalarType(override val atomTypeId: PuffinBasicAtomTypeId) : PuffinBasicType {

        override val typeId: PuffinBasicTypeId
            get() = PuffinBasicTypeId.SCALAR

        override fun newInstance(symbolTable: PuffinBasicSymbolTable): STValue {
            return atomTypeId.createValue()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }
            if (other == null || other.javaClass != ScalarType::class.java) {
                return false
            }
            val o = other as ScalarType
            return (typeId == o.typeId
                    && atomTypeId === o.atomTypeId)
        }

        override fun hashCode(): Int {
            return Objects.hash(typeId, atomTypeId)
        }

        override fun isCompatibleWith(other: PuffinBasicType): Boolean {
            return atomTypeId.isCompatibleWith(other.atomTypeId)
        }

        companion object {
            val INT32 = ScalarType(PuffinBasicAtomTypeId.INT32)
            val INT64 = ScalarType(PuffinBasicAtomTypeId.INT64)
            val FLOAT32 = ScalarType(PuffinBasicAtomTypeId.FLOAT)
            val FLOAT64 = ScalarType(PuffinBasicAtomTypeId.DOUBLE)
            val STRING = ScalarType(PuffinBasicAtomTypeId.STRING)
        }
    }

    class ArrayType : PuffinBasicType {
        override val atomTypeId: PuffinBasicAtomTypeId
        private val dims: MutableList<Int>
        private val canBeLValue: Boolean

        constructor(atomType: PuffinBasicAtomTypeId) {
            atomTypeId = atomType
            canBeLValue = false
            dims = mutableListOf<Int>()
        }

        constructor(atomType: PuffinBasicAtomTypeId, dims: MutableList<Int>, canBeLValue: Boolean) {
            atomTypeId = atomType
            this.dims = dims
            this.canBeLValue = canBeLValue
        }

        fun setArrayDimensions(dims: List<Int>) {
            this.dims.clear()
            this.dims.addAll(dims)
        }

        fun isNDArray(n: Int): Boolean {
            return dims != null && dims.size == n
        }

        override fun canBeLValue(): Boolean {
            return canBeLValue
        }

        override val typeId: PuffinBasicTypeId
            get() = PuffinBasicTypeId.ARRAY

        override fun newInstance(symbolTable: PuffinBasicSymbolTable): STValue {
            val entry = atomTypeId.createArrayEntry()
            val value = entry.value!!
            if (dims != null) {
                value.arrayDimensions = dims
            }
            return value
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }
            if (other == null || other.javaClass != ArrayType::class.java) {
                return false
            }
            val o = other as ArrayType
            return (typeId == o.typeId
                    && atomTypeId === o.atomTypeId)
        }

        override fun hashCode(): Int {
            return Objects.hash(typeId, atomTypeId)
        }

        override fun isCompatibleWith(other: PuffinBasicType): Boolean {
            return atomTypeId.isCompatibleWith(other.atomTypeId)
        }
    }

    class UDFType internal constructor(override val atomTypeId: PuffinBasicAtomTypeId) :
        PuffinBasicType {

        override val typeId: PuffinBasicTypeId
            get() = PuffinBasicTypeId.UDF

        override fun newInstance(symbolTable: PuffinBasicSymbolTable): STValue {
            throw PuffinBasicInternalError("Not implemented!")
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }
            if (other == null || other.javaClass != ArrayType::class.java) {
                return false
            }
            val o = other as ArrayType
            return (typeId == o.typeId
                    && atomTypeId === o.atomTypeId)
        }

        override fun hashCode(): Int {
            return Objects.hash(typeId, atomTypeId)
        }

        override fun isCompatibleWith(other: PuffinBasicType): Boolean {
            return (typeId == other.typeId
                    && atomTypeId.isCompatibleWith(other.atomTypeId))
        }
    }

    class StructType(val typeName: String) : PuffinBasicType {
        val refIdToTypeMap: MutableMap<Int, PuffinBasicType>
        val nameToRefIdMap: MutableMap<VariableName, Int>
        private var counter = 0

        init {
            refIdToTypeMap = mutableMapOf()
            nameToRefIdMap = mutableMapOf()
        }

        fun getMemberType(memberName: VariableName): PuffinBasicType? {
            return refIdToTypeMap[getMemberRefId(memberName)]
        }

        fun containsMember(memberName: VariableName): Boolean {
            return nameToRefIdMap.containsKey(memberName)
        }

        fun getMemberRefId(memberName: VariableName): Int {
            val memberRefId: Int = nameToRefIdMap.getOrDefault(memberName, -1)
            if (memberRefId == -1) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.BAD_FIELD,
                    "Missing field $typeName.$memberName"
                )
            }
            return memberRefId
        }

        fun declareField(memberName: VariableName, type: PuffinBasicType) {
            val refId = counter++
            refIdToTypeMap[refId] = type
            nameToRefIdMap[memberName] = refId
        }

        override val typeId: PuffinBasicTypeId
            get() = PuffinBasicTypeId.STRUCT
        override val atomTypeId: PuffinBasicAtomTypeId
            get() = PuffinBasicAtomTypeId.COMPOSITE

        override fun newInstance(symbolTable: PuffinBasicSymbolTable): STValue {
            return STStruct(symbolTable, this)
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }
            if (other == null || other.javaClass != StructType::class.java) {
                return false
            }
            val o = other as StructType
            return typeId == o.typeId && atomTypeId === o.atomTypeId && typeName == o.typeName
        }

        override fun hashCode(): Int {
            return Objects.hash(typeId, atomTypeId)
        }
    }

    internal class MemberFunction internal constructor(
        val functionName: String,
        val paramTypes: Array<PuffinBasicType>,
        val returnType: PuffinBasicType,
        val callHandler: (o: Any, params: Array<STValue>, result: STValue) -> Unit,
    )

    internal class MemberFunctions internal constructor(memberFunctions: List<MemberFunction>) {
        private val memberFunctions: MutableMap<String, MemberFunction>

        init {
            this.memberFunctions = HashMap()
            memberFunctions.forEach(Consumer { mf: MemberFunction ->
                this.memberFunctions[mf.functionName] = mf
            })
        }

        operator fun get(funcName: String): MemberFunction {
            return memberFunctions[funcName]
                ?: throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.BAD_FIELD,
                    "Unknown member function: $funcName"
                )
        }

        fun checkFuncCallArguments(funcName: String, paramTypes: List<PuffinBasicType>) {
            val expectedParamTypes = get(funcName).paramTypes
            if (expectedParamTypes.size != paramTypes.size) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.BAD_FUNCTION_CALL,
                    "Function " + funcName + " expects " + expectedParamTypes.size
                            + " params, but called with " + paramTypes.size + " params"
                )
            }
            for (i in expectedParamTypes.indices) {
                if (!expectedParamTypes[i].isCompatibleWith(paramTypes[i])) {
                    throw PuffinBasicRuntimeError(
                        PuffinBasicRuntimeError.ErrorCode.BAD_FUNCTION_CALL,
                        "Function " + funcName + " called with wrong param type for param#" + (i + 1)
                                + ", expected type " + expectedParamTypes[i] + ", actual " + paramTypes[i]
                    )
                }
            }
        }
    }

    class ListType(private val type: PuffinBasicType) : PuffinBasicType {
        private val memberFunctions: MemberFunctions

        init {
            val valuesType = ArrayType(
                type.atomTypeId
            )
            memberFunctions = MemberFunctions(
                ImmutableList.builder<MemberFunction>()
                    .add(
                        MemberFunction(
                            "append", arrayOf(type), ScalarType.INT32
                        ) { obj: Any, params: Array<STValue>, result: STValue ->
                            val list = obj as MutableList<Any?>
                            if (type.typeId == PuffinBasicTypeId.SCALAR) {
                                list.add(type.atomTypeId.getValueFrom(params[0]))
                            } else {
                                list.add(params[0])
                            }
                            result.int32 = 0
                        }
                    )
                    .add(
                        MemberFunction(
                            "insert",
                            arrayOf(ScalarType.INT32, type),
                            ScalarType.INT32
                        ) { obj: Any, params: Array<STValue>, result: STValue ->
                            val list = obj as MutableList<Any?>
                            val index = params[0].int32
                            if (type.typeId == PuffinBasicTypeId.SCALAR) {
                                val value = type.atomTypeId.getValueFrom(params[1])
                                list.add(index, value)
                            } else {
                                list.add(index, params[1])
                            }
                            result.int32 = 0
                        }
                    )
                    .add(
                        MemberFunction(
                            "get", arrayOf(ScalarType.INT32), type
                        ) { obj: Any, params: Array<STValue>, result: STValue ->
                            val list = obj as MutableList<Any>
                            val index = params[0].int32
                            if (index < 0 || index >= list.size) {
                                throw PuffinBasicRuntimeError(
                                    PuffinBasicRuntimeError.ErrorCode.ARRAY_INDEX_OUT_OF_BOUNDS,
                                    "List index: " + index
                                            + " is out of bounds, list size: " + list.size
                                )
                            }
                            if (type.typeId == PuffinBasicTypeId.SCALAR) {
                                type.atomTypeId.setValueIn(list[index], result)
                            } else {
                                val item = list[index] as STValue
                                result.replace(item)
                            }
                        }
                    )
                    .add(
                        MemberFunction(
                            "values", arrayOf(), valuesType
                        ) { obj: Any?, params: Array<STValue>, result: STValue ->
                            val list = obj as Array<Any>
                            if (type.typeId == PuffinBasicTypeId.SCALAR) {
                                type.atomTypeId.copyArray(list, result)
                            } else {
                                throw PuffinBasicRuntimeError(
                                    PuffinBasicRuntimeError.ErrorCode.BAD_FUNCTION_CALL,
                                    "values() not supported for non-scalar type!"
                                )
                            }
                        }
                    )
                    .add(
                        MemberFunction(
                            "clear", arrayOf(), ScalarType.INT32
                        ) { obj: Any, params: Array<STValue>, result: STValue ->
                            val list = obj as MutableList<Any>
                            list.clear()
                            result.int32 = 0
                        }
                    )
                    .build()
            )
        }

        override val typeId: PuffinBasicTypeId
            get() = PuffinBasicTypeId.LIST
        override val atomTypeId: PuffinBasicAtomTypeId
            get() = PuffinBasicAtomTypeId.COMPOSITE

        override fun newInstance(symbolTable: PuffinBasicSymbolTable): STValue {
            return STList(type, memberFunctions)
        }

        override fun getFuncCallReturnType(funcName: String): PuffinBasicType {
            return memberFunctions[funcName].returnType
        }

        override fun checkFuncCallArguments(funcName: String, paramTypes: List<PuffinBasicType>) {
            memberFunctions.checkFuncCallArguments(funcName, paramTypes)
        }

        override fun equals(obj: Any?): Boolean {
            if (this === obj) {
                return true
            }
            if (obj == null || obj.javaClass != ListType::class.java) {
                return false
            }
            val o = obj as ListType
            return (typeId == o.typeId
                    && atomTypeId === o.atomTypeId)
        }

        override fun hashCode(): Int {
            return Objects.hash(typeId, atomTypeId)
        }
    }

    class SetType(private val type: PuffinBasicType) : PuffinBasicType {
        private val memberFunctions: MemberFunctions

        init {
            val valuesType = ArrayType(
                type.atomTypeId
            )
            memberFunctions = MemberFunctions(
                ImmutableList.builder<MemberFunction>()
                    .add(
                        MemberFunction(
                            "add", arrayOf(type), ScalarType.INT32
                        ) { obj: Any, params: Array<STValue>, result: STValue ->
                            val set = obj as MutableSet<Any?>
                            val value = type.atomTypeId.getValueFrom(params[0])
                            set.add(value)
                            result.int32 = 0
                        }
                    )
                    .add(
                        MemberFunction(
                            "remove", arrayOf(type), ScalarType.INT32
                        ) { obj: Any, params: Array<STValue>, result: STValue ->
                            val set = obj as MutableSet<Any?>
                            val value = type.atomTypeId.getValueFrom(params[0])
                            val removeRes = set.remove(value)
                            result.int32 = if (removeRes) -1 else 0
                        }
                    )
                    .add(
                        MemberFunction(
                            "contains", arrayOf(type), ScalarType.INT32
                        ) { obj: Any, params: Array<STValue>, result: STValue ->
                            val set = obj as Set<Any?>
                            val value = type.atomTypeId.getValueFrom(params[0])
                            result.int32 = if (set.contains(value)) -1 else 0
                        }
                    )
                    .add(
                        MemberFunction(
                            "values", arrayOf(), valuesType
                        ) { obj: Any?, params: Array<STValue>, result: STValue ->
                            val set = obj as Collection<*>
                            type.atomTypeId.copyArray(set, result)
                        }
                    )
                    .add(
                        MemberFunction(
                            "clear", arrayOf(), ScalarType.INT32
                        ) { obj: Any, params: Array<STValue>, result: STValue ->
                            val set = obj as MutableSet<Any>
                            set.clear()
                            result.int32 = 0
                        }
                    )
                    .build()
            )
        }

        override val typeId: PuffinBasicTypeId
            get() = PuffinBasicTypeId.SET
        override val atomTypeId: PuffinBasicAtomTypeId
            get() = PuffinBasicAtomTypeId.COMPOSITE

        override fun newInstance(symbolTable: PuffinBasicSymbolTable): STValue {
            return STSet(type, memberFunctions)
        }

        override fun getFuncCallReturnType(funcName: String): PuffinBasicType {
            return memberFunctions[funcName].returnType
        }

        override fun checkFuncCallArguments(funcName: String, paramTypes: List<PuffinBasicType>) {
            memberFunctions.checkFuncCallArguments(funcName, paramTypes)
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }
            if (other == null || other.javaClass != SetType::class.java) {
                return false
            }
            val o = other as SetType
            return (typeId == o.typeId
                    && atomTypeId === o.atomTypeId)
        }

        override fun hashCode(): Int {
            return Objects.hash(typeId, atomTypeId)
        }
    }

    class DictType(private val keyType: PuffinBasicType, private val valueType: PuffinBasicType) :
        PuffinBasicType {
        private val memberFunctions: MemberFunctions

        init {
            val valuesType = ArrayType(
                keyType.atomTypeId
            )
            memberFunctions = MemberFunctions(
                ImmutableList.builder<MemberFunction>()
                    .add(
                        MemberFunction(
                            "put", arrayOf(keyType, valueType), ScalarType.INT32
                        ) { obj: Any, params: Array<STValue>, result: STValue ->
                            val dict = obj as MutableMap<Any?, Any?>
                            val key = keyType.atomTypeId.getValueFrom(params[0])
                            val value = valueType.atomTypeId.getValueFrom(params[1])
                            dict[key] = value
                            result.int32 = 0
                        }
                    )
                    .add(
                        MemberFunction(
                            "removeKey", arrayOf(keyType), ScalarType.INT32
                        ) { obj: Any, params: Array<STValue>, result: STValue ->
                            val dict = obj as MutableMap<Any?, Any>
                            val key = keyType.atomTypeId.getValueFrom(params[0])
                            val removeRes = dict.remove(key)
                            result.int32 = if (removeRes != null) -1 else 0
                        }
                    )
                    .add(
                        MemberFunction(
                            "getOrDefault", arrayOf(keyType, valueType), valueType
                        ) { obj: Any, params: Array<STValue>, result: STValue ->
                            val dict = obj as Map<Any?, Any?>
                            val key = keyType.atomTypeId.getValueFrom(params[0])
                            val value = valueType.atomTypeId.getValueFrom(params[1])
                            val getRes = dict.getOrDefault(key, value)!!
                            valueType.atomTypeId.setValueIn(getRes, result)
                        }
                    )
                    .add(
                        MemberFunction(
                            "containsKey", arrayOf(keyType), ScalarType.INT32
                        ) { obj: Any, params: Array<STValue>, result: STValue ->
                            val dict = obj as Map<Any?, Any>
                            val key = keyType.atomTypeId.getValueFrom(params[0])
                            result.int32 = if (dict.containsKey(key)) -1 else 0
                        }
                    )
                    .add(
                        MemberFunction(
                            "keys", arrayOf(), valuesType
                        ) { obj: Any, params: Array<STValue>, result: STValue ->
                            val dict = obj as Map<Any, Any>
                            keyType.atomTypeId.copyArray(dict.keys, result)
                        }
                    )
                    .add(
                        MemberFunction(
                            "clear", arrayOf(), ScalarType.INT32
                        ) { obj: Any, params: Array<STValue>, result: STValue ->
                            val dict = obj as MutableMap<Any, Any>
                            dict.clear()
                            result.int32 = 0
                        }
                    )
                    .build()
            )
        }

        override val typeId: PuffinBasicTypeId
            get() = PuffinBasicTypeId.DICT
        override val atomTypeId: PuffinBasicAtomTypeId
            get() = PuffinBasicAtomTypeId.COMPOSITE

        override fun newInstance(symbolTable: PuffinBasicSymbolTable): STValue {
            return STDict(valueType, memberFunctions)
        }

        override fun getFuncCallReturnType(funcName: String): PuffinBasicType {
            return memberFunctions[funcName].returnType
        }

        override fun checkFuncCallArguments(funcName: String, paramTypes: List<PuffinBasicType>) {
            memberFunctions.checkFuncCallArguments(funcName, paramTypes)
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }
            if (other == null || other.javaClass != DictType::class.java) {
                return false
            }
            val o = other as DictType
            return typeId == o.typeId && keyType === o.keyType && valueType === o.valueType
        }

        override fun hashCode(): Int {
            return Objects.hash(typeId, keyType, valueType)
        }
    }

    abstract class AbstractSTEntry internal constructor(
        override var value: STValue?,
        override val type: PuffinBasicType?
    ) : STEntry {
        fun createAndSetInstance(symbolTable: PuffinBasicSymbolTable) {
            value = type!!.newInstance(symbolTable)
        }
    }

    open class STLValue internal constructor(value: STValue?, type: PuffinBasicType?) :
        AbstractSTEntry(value, type) {
        override val isLValue: Boolean
            get() = true
    }

    open class STVariable(value: STValue?, val variable: Variable) : STLValue(value, variable.type)
    class STRef internal constructor(type: PuffinBasicType?) : STLValue(null, type) {
        var ref: STEntry? = null
            get() {
                if (field == null) {
                    throw PuffinBasicInternalError("Ref is null")
                }
                return field
            }
            set(ref) {
                if (ref!!.type != type) {
                    throw PuffinBasicRuntimeError(
                        PuffinBasicRuntimeError.ErrorCode.DATA_TYPE_MISMATCH,
                        "Expected " + type + " got " + ref.type
                    )
                }
                field = ref
            }

        override var value: STValue?
            get() = ref!!.value!!
            set(value) {}
    }

    class STTmp(value: STValue?, type: PuffinBasicType?) : AbstractSTEntry(value, type)
    class STUDF internal constructor(value: STValue?, variable: Variable) :
        STVariable(value, variable) {
        private val paramIds = mutableListOf<Int>()

        fun declareParam(paramId: Int) {
            paramIds.add(paramId)
        }

        val numDeclaredParams: Int
            get() = paramIds.size

        fun getDeclaredParam(i: Int): Int {
            return paramIds.get(i)
        }
    }

    internal class STLabel : AbstractSTEntry(STInt32ScalarValue(), null) {
        override val type: PuffinBasicType?
            get() {
                throw PuffinBasicInternalError("Labels don't have a type!")
            }
    }

    private class STInt32ScalarValue : STValue {
        override var isInitialized = false
            private set
        private var value = 0
        override fun setInitialized() {
            this.isInitialized = true
        }

        override fun printFormat(): String {
            checkInitialized()
            return Formatter.printFormatInt32(value)
        }

        override fun writeFormat(): String {
            checkInitialized()
            return Formatter.writeFormatInt32(value)
        }

        override fun assign(entry: STValue) {
            setInitialized()
            value = entry.int32
        }

        override var int32: Int
            get() {
                checkInitialized()
                return value
            }
            set(value) {
                setInitialized()
                this.value = value
            }
        override var int64: Long
            get() {
                checkInitialized()
                return value.toLong()
            }
            set(value) {
                this.isInitialized = true
                this.value = value.toInt()
            }
        override var float32: Float
            get() {
                checkInitialized()
                return value.toFloat()
            }
            set(value) {
                this.isInitialized = true
                this.value = value.toInt()
            }
        override var float64: Double
            get() {
                checkInitialized()
                return value.toDouble()
            }
            set(value) {
                this.isInitialized = true
                this.value = value.toInt()
            }
        override val roundedInt32: Int
            get() {
                checkInitialized()
                return value
            }
        override val roundedInt64: Long
            get() {
                checkInitialized()
                return value.toLong()
            }
        override var string: String?
            get() {
                throw PuffinBasicInternalError("Can't cast int32 to String")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast String to int32: '$value'")
            }
    }

    private class STInt64ScalarValue : STValue {
        override var isInitialized = false
            private set
        private var value: Long = 0
        override fun setInitialized() {
            this.isInitialized = true
        }

        override fun printFormat(): String {
            checkInitialized()
            return Formatter.printFormatInt64(value)
        }

        override fun writeFormat(): String {
            checkInitialized()
            return Formatter.writeFormatInt64(value)
        }

        override fun assign(entry: STValue) {
            this.isInitialized = true
            value = entry.int64
        }

        override var int32: Int
            get() {
                checkInitialized()
                return value.toInt()
            }
            set(value) {
                this.isInitialized = true
                this.value = value.toLong()
            }
        override var int64: Long
            get() {
                checkInitialized()
                return value
            }
            set(value) {
                this.isInitialized = true
                this.value = value
            }
        override var float32: Float
            get() {
                checkInitialized()
                return value.toFloat()
            }
            set(value) {
                this.isInitialized = true
                this.value = value.toLong()
            }
        override var float64: Double
            get() {
                checkInitialized()
                return value.toDouble()
            }
            set(value) {
                this.isInitialized = true
                this.value = value.toLong()
            }
        override val roundedInt32: Int
            get() {
                checkInitialized()
                return value.toInt()
            }
        override val roundedInt64: Long
            get() {
                checkInitialized()
                return value
            }
        override var string: String?
            get() {
                throw PuffinBasicInternalError("Can't cast int64 to String")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast String to int64: '$value'")
            }
    }

    private class STFloat32ScalarValue : STValue {
        override var isInitialized = false
            private set
        private var value = 0f
        override fun setInitialized() {
            this.isInitialized = true
        }

        override fun printFormat(): String {
            checkInitialized()
            return Formatter.printFormatFloat32(value)
        }

        override fun writeFormat(): String {
            checkInitialized()
            return Formatter.writeFormatFloat32(value)
        }

        override fun assign(entry: STValue) {
            this.isInitialized = true
            value = entry.float32
        }

        override var int32: Int
            get() {
                checkInitialized()
                return value.toInt()
            }
            set(value) {
                this.isInitialized = true
                this.value = value.toFloat()
            }
        override var int64: Long
            get() {
                checkInitialized()
                return value.toLong()
            }
            set(value) {
                this.isInitialized = true
                this.value = value.toFloat()
            }
        override var float32: Float
            get() {
                checkInitialized()
                return value
            }
            set(value) {
                this.isInitialized = true
                this.value = value
            }
        override var float64: Double
            get() {
                checkInitialized()
                return value.toDouble()
            }
            set(value) {
                this.isInitialized = true
                this.value = value.toFloat()
            }
        override val roundedInt32: Int
            get() {
                checkInitialized()
                return value.roundToInt()
            }
        override val roundedInt64: Long
            get() {
                checkInitialized()
                return value.roundToLong().toLong()
            }
        override var string: String?
            get() {
                throw PuffinBasicInternalError("Can't cast float32 to String")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast String to float32: '$value'")
            }
    }

    private class STFloat64ScalarValue : STValue {
        override var isInitialized = false
            private set
        private var value = 0.0
        override fun setInitialized() {
            this.isInitialized = true
        }

        override fun printFormat(): String {
            checkInitialized()
            return Formatter.printFormatFloat64(value)
        }

        override fun writeFormat(): String {
            checkInitialized()
            return Formatter.writeFormatFloat64(value)
        }

        override fun assign(entry: STValue) {
            this.isInitialized = true
            value = entry.float64
        }

        override var int32: Int
            get() {
                checkInitialized()
                return value.toInt()
            }
            set(value) {
                this.isInitialized = true
                this.value = value.toDouble()
            }
        override var int64: Long
            get() {
                checkInitialized()
                return value.toLong()
            }
            set(value) {
                this.isInitialized = true
                this.value = value.toDouble()
            }
        override var float32: Float
            get() {
                checkInitialized()
                return value.toFloat()
            }
            set(value) {
                this.isInitialized = true
                this.value = value.toDouble()
            }
        override var float64: Double
            get() {
                checkInitialized()
                return value
            }
            set(value) {
                this.isInitialized = true
                this.value = value
            }
        override val roundedInt32: Int
            get() {
                checkInitialized()
                return value.roundToInt()
            }
        override val roundedInt64: Long
            get() {
                checkInitialized()
                return value.roundToLong()
            }
        override var string: String?
            get() {
                throw PuffinBasicInternalError("Can't cast float64 to String")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast String to float64: '$value'")
            }
    }

    private class STStringScalarValue : STValue {
        override var isInitialized = false
            private set
        override var fieldLength = 0
        private var value: String = ""
        override fun setInitialized() {
            this.isInitialized = true
        }

        override fun printFormat(): String {
            checkInitialized()
            return Formatter.printFormatString(value)
        }

        override fun writeFormat(): String {
            checkInitialized()
            return Formatter.writeFormatString(value)
        }

        override fun assign(entry: STValue) {
            this.isInitialized = true
            value = entry.string!!
        }

        override var int32: Int
            get() {
                throw PuffinBasicInternalError("Can't cast String to int32")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast int32 to String")
            }
        override var int64: Long
            get() {
                throw PuffinBasicInternalError("Can't cast String to int64")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast int64 to String")
            }
        override var float32: Float
            get() {
                throw PuffinBasicInternalError("Can't cast String to float32")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast float32 to String")
            }
        override var float64: Double
            get() {
                throw PuffinBasicInternalError("Can't cast String to float64")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast float64 to String")
            }
        override val roundedInt32: Int
            get() {
                throw PuffinBasicInternalError("Can't cast String to int32")
            }
        override val roundedInt64: Long
            get() {
                throw PuffinBasicInternalError("Can't cast String to int64")
            }
        override var string: String?
            get() {
                checkInitialized()
                return value
            }
            set(value) {
                this.isInitialized = true
                this.value = value!!
            }

        override fun hasLen(): Boolean {
            return true
        }

        override fun len(): Int {
            return string!!.length
        }
    }

    private class STStringScalarTimeValue : STValue {
        private var time: LocalTime? = null
        override fun printFormat(): String? {
            return string
        }

        override fun writeFormat(): String? {
            return string
        }

        override fun assign(entry: STValue) {
            string = entry.string
        }

        override var int32: Int
            get() {
                throw PuffinBasicInternalError("Can't cast String to int32")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast int32 to String")
            }
        override var int64: Long
            get() {
                throw PuffinBasicInternalError("Can't cast String to int64")
            }
            set(_) {
                throw PuffinBasicInternalError("Can't cast int64 to String")
            }
        override var float32: Float
            get() {
                throw PuffinBasicInternalError("Can't cast String to float32")
            }
            set(_) {
                throw PuffinBasicInternalError("Can't cast float32 to String")
            }
        override var float64: Double
            get() {
                throw PuffinBasicInternalError("Can't cast String to float64")
            }
            set(_) {
                throw PuffinBasicInternalError("Can't cast float64 to String")
            }
        override val roundedInt32: Int
            get() {
                throw PuffinBasicInternalError("Can't cast String to int32")
            }
        override val roundedInt64: Long
            get() {
                throw PuffinBasicInternalError("Can't cast String to int64")
            }
        override var string: String?
            get() = formatLocalTime((if (time != null) time else LocalTime.now())!!)
            set(value) {
                time = LocalTime.parse(value, FORMATTER)
            }

        private fun formatLocalTime(time: LocalTime): String {
            return time.format(FORMATTER)
        }

        override var fieldLength: Int
            get() = 0
            set(fieldLength) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM,
                    "TIME$ cannot be used for setting field length!"
                )
            }

        companion object {
            private val FORMATTER = DateTimeFormatter.ISO_LOCAL_TIME
        }
    }

    private class STStringScalarDateValue : STValue {
        private var date: LocalDate? = null
        override fun printFormat(): String? {
            return string
        }

        override fun writeFormat(): String? {
            return string
        }

        override fun assign(entry: STValue) {
            string = entry.string
        }

        override var int32: Int
            get() {
                throw PuffinBasicInternalError("Can't cast String to int32")
            }
            set(_) {
                throw PuffinBasicInternalError("Can't cast int32 to String")
            }
        override var int64: Long
            get() {
                throw PuffinBasicInternalError("Can't cast String to int64")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast int64 to String")
            }
        override var float32: Float
            get() {
                throw PuffinBasicInternalError("Can't cast String to float32")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast float32 to String")
            }
        override var float64: Double
            get() {
                throw PuffinBasicInternalError("Can't cast String to float64")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast float64 to String")
            }
        override val roundedInt32: Int
            get() {
                throw PuffinBasicInternalError("Can't cast String to int32")
            }
        override val roundedInt64: Long
            get() {
                throw PuffinBasicInternalError("Can't cast String to int64")
            }
        override var string: String?
            get() = formatLocalDate((if (date != null) date else LocalDate.now())!!)
            set(value) {
                date = LocalDate.parse(value, FORMATTER)
            }

        private fun formatLocalDate(date: LocalDate): String {
            return date.format(FORMATTER)
        }

        override var fieldLength: Int
            get() = 0
            set(fieldLength) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.ILLEGAL_FUNCTION_PARAM,
                    "DATE$ cannot be used for setting field length!"
                )
            }

        companion object {
            private val FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE
        }
    }

    internal class ArrayReferenceValue(private val variable: STLValue) : STValue {
        private var index1d = 0
        private val value: AbstractSTArrayValue
            private get() = variable.value as AbstractSTArrayValue

        override fun setArrayReferenceIndex1D(index1d: Int) {
            this.index1d = index1d
        }

        override fun printFormat(): String? {
            val array = value
            array.setArrayIndexID(index1d)
            return array.printFormat()
        }

        override fun writeFormat(): String? {
            val array = value
            array.setArrayIndexID(index1d)
            return array.writeFormat()
        }

        override fun assign(entry: STValue) {
            val array = value
            array.setArrayIndexID(index1d)
            array.assign(entry)
        }

        override var int32: Int
            get() {
                val array = value
                array.setArrayIndexID(index1d)
                return array.int32
            }
            set(value) {
                val array = this.value
                array.setArrayIndexID(index1d)
                array.int32 = value
            }
        override var int64: Long
            get() {
                val array = value
                array.setArrayIndexID(index1d)
                return array.int64
            }
            set(value) {
                val array = this.value
                array.setArrayIndexID(index1d)
                array.int64 = value
            }
        override var float32: Float
            get() {
                val array = value
                array.setArrayIndexID(index1d)
                return array.float32
            }
            set(value) {
                val array = this.value
                array.setArrayIndexID(index1d)
                array.float32 = value
            }
        override var float64: Double
            get() {
                val array = value
                array.setArrayIndexID(index1d)
                return array.float64
            }
            set(value) {
                val array = this.value
                array.setArrayIndexID(index1d)
                array.float64 = value
            }
        override val roundedInt32: Int
            get() {
                val array = value
                array.setArrayIndexID(index1d)
                return array.roundedInt32
            }
        override val roundedInt64: Long
            get() {
                val array = value
                array.setArrayIndexID(index1d)
                return array.roundedInt64
            }
        override var string: String?
            get() {
                val array = value
                array.setArrayIndexID(index1d)
                return array.string
            }
            set(value) {
                val array = this.value
                array.setArrayIndexID(index1d)
                array.string = value
            }
    }

    abstract class AbstractSTArrayValue : STValue {
        private var dimensions: MutableList<Int> = mutableListOf()
        final override var totalLength = 0
            private set

        final override var arrayIndex1D = 0
            private set

        final override var numArrayDimensions = 0
            private set

        override fun replace(entry: STValue) {
            val from = entry as AbstractSTArrayValue
            dimensions = from.dimensions
            totalLength = from.totalLength
            numArrayDimensions = from.numArrayDimensions
        }

        override var arrayDimensions: List<Int>?
            get() = dimensions.toList()
            set(dims) {
                dimensions = dims!!.toMutableList()
                numArrayDimensions = dimensions.size
                var totalLen = 1
                for (i in 0 until numArrayDimensions) {
                    totalLen *= dimensions[i]
                }
                totalLength = totalLen
            }

        override fun resetArrayIndex() {
            arrayIndex1D = 0
        }

        override fun setArrayIndex(dim: Int, index: Int) {
            if (dim < 0 || dim >= dimensions.size) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.ARRAY_INDEX_OUT_OF_BOUNDS,
                    "Dimension index " + dim + " is out of range, #dims=" + dimensions.size
                )
            }
            if (index < 0 || index >= dimensions[dim]) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.ARRAY_INDEX_OUT_OF_BOUNDS,
                    "Index " + index + " is out of range for dimension["
                            + dim + "]=" + dimensions[dim]
                )
            }
            val dIplus1 = if (dim + 1 < numArrayDimensions) dimensions[dim + 1] else 1
            arrayIndex1D = (arrayIndex1D + index) * dIplus1
        }

        fun setArrayIndexID(index1d: Int) {
            arrayIndex1D = index1d
        }
    }

    class STInt32ArrayValue : AbstractSTArrayValue() {
        var value: IntArray = intArrayOf()

        override fun replace(entry: STValue) {
            super.replace(entry)
            val from = entry as STInt32ArrayValue
            value = from.value
        }

        override fun fill(fill: Number) {
            Arrays.fill(value, fill.toInt())
        }

        override var arrayDimensions: List<Int>?
            get() = super.arrayDimensions
            set(dims) {
                super.arrayDimensions = dims
                value = IntArray(totalLength)
            }

        override fun printFormat(): String {
            return Formatter.printFormatInt32(value[arrayIndex1D])
        }

        override fun writeFormat(): String {
            return Formatter.writeFormatInt32(value[arrayIndex1D])
        }

        override fun assign(entry: STValue) {
            value[arrayIndex1D] = entry.int32
        }

        override var int32: Int
            get() = value[arrayIndex1D]
            set(newValue) {
                value[arrayIndex1D] = newValue
            }
        override var int64: Long
            get() = value[arrayIndex1D].toLong()
            set(newValue) {
                value[arrayIndex1D] = newValue.toInt()
            }
        override var float32: Float
            get() = value[arrayIndex1D].toFloat()
            set(newValue) {
                value[arrayIndex1D] = newValue.toInt()
            }
        override var float64: Double
            get() = value[arrayIndex1D].toDouble()
            set(newValue) {
                value[arrayIndex1D] = newValue.toInt()
            }
        override val roundedInt32: Int
            get() = value[arrayIndex1D]
        override val roundedInt64: Long
            get() = value[arrayIndex1D].toLong()
        override var string: String?
            get() {
                throw PuffinBasicInternalError("Can't cast int32 to String")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast String to int32: '$value'")
            }
    }

    class STInt64ArrayValue : AbstractSTArrayValue() {
        var value: LongArray = longArrayOf()

        override fun fill(fill: Number) {
            Arrays.fill(value, fill.toLong())
        }

        override var arrayDimensions: List<Int>?
            get() = super.arrayDimensions
            set(dims) {
                super.arrayDimensions = dims
                value = LongArray(totalLength)
            }

        override fun printFormat(): String {
            return Formatter.printFormatInt64(value[arrayIndex1D])
        }

        override fun writeFormat(): String {
            return Formatter.writeFormatInt64(value[arrayIndex1D])
        }

        override fun assign(entry: STValue) {
            value[arrayIndex1D] = entry.int64
        }

        override var int32: Int
            get() = value[arrayIndex1D].toInt()
            set(value) {
                this.value[arrayIndex1D] = value.toLong()
            }
        override var int64: Long
            get() = value[arrayIndex1D]
            set(value) {
                this.value[arrayIndex1D] = value.toInt().toLong()
            }
        override var float32: Float
            get() = value[arrayIndex1D].toFloat()
            set(value) {
                this.value[arrayIndex1D] = value.toInt().toLong()
            }
        override var float64: Double
            get() = value[arrayIndex1D].toDouble()
            set(value) {
                this.value[arrayIndex1D] = value.toInt().toLong()
            }
        override val roundedInt32: Int
            get() = value[arrayIndex1D].toInt()
        override val roundedInt64: Long
            get() = value[arrayIndex1D]
        override var string: String?
            get() {
                throw PuffinBasicInternalError("Can't cast int32 to String")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast String to int32: '$value'")
            }
    }

    class STFloat32ArrayValue : AbstractSTArrayValue() {
        var value: FloatArray = floatArrayOf()

        override fun fill(fill: Number) {
            Arrays.fill(value, fill.toFloat())
        }

        override var arrayDimensions: List<Int>?
            get() = super.arrayDimensions
            set(dims) {
                super.arrayDimensions = dims
                value = FloatArray(totalLength)
            }

        override fun printFormat(): String {
            return Formatter.printFormatFloat32(value[arrayIndex1D])
        }

        override fun writeFormat(): String {
            return Formatter.writeFormatFloat32(value[arrayIndex1D])
        }

        override fun assign(entry: STValue) {
            value[arrayIndex1D] = entry.float32
        }

        override var int32: Int
            get() = value[arrayIndex1D].toInt()
            set(value) {
                this.value[arrayIndex1D] = value.toFloat()
            }
        override var int64: Long
            get() = value[arrayIndex1D].toLong()
            set(value) {
                this.value[arrayIndex1D] = value.toInt().toFloat()
            }
        override var float32: Float
            get() = value[arrayIndex1D]
            set(value) {
                this.value[arrayIndex1D] = value.toInt().toFloat()
            }
        override var float64: Double
            get() = value[arrayIndex1D].toDouble()
            set(value) {
                this.value[arrayIndex1D] = value.toInt().toFloat()
            }
        override val roundedInt32: Int
            get() = value[arrayIndex1D].roundToInt()
        override val roundedInt64: Long
            get() = value[arrayIndex1D].roundToLong().toLong()
        override var string: String?
            get() {
                throw PuffinBasicInternalError("Can't cast int32 to String")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast String to int32: '$value'")
            }
    }

    class STFloat64ArrayValue : AbstractSTArrayValue() {
        var value: DoubleArray = doubleArrayOf()

        override fun fill(fill: Number) {
            Arrays.fill(value, fill.toDouble())
        }

        override var arrayDimensions: List<Int>?
            get() = super.arrayDimensions
            set(dims) {
                super.arrayDimensions = dims
                value = DoubleArray(totalLength)
            }

        override fun printFormat(): String {
            return Formatter.printFormatFloat64(value[arrayIndex1D])
        }

        override fun writeFormat(): String {
            return Formatter.writeFormatFloat64(value[arrayIndex1D])
        }

        override fun assign(entry: STValue) {
            value[arrayIndex1D] = entry.float64
        }

        override var int32: Int
            get() = value[arrayIndex1D].toInt()
            set(value) {
                this.value[arrayIndex1D] = value.toDouble()
            }
        override var int64: Long
            get() = value[arrayIndex1D].toLong()
            set(value) {
                this.value[arrayIndex1D] = value.toInt().toDouble()
            }
        override var float32: Float
            get() = value[arrayIndex1D].toFloat()
            set(value) {
                this.value[arrayIndex1D] = value.toInt().toDouble()
            }
        override var float64: Double
            get() = value[arrayIndex1D]
            set(value) {
                this.value[arrayIndex1D] = value.toInt().toDouble()
            }
        override val roundedInt32: Int
            get() = value[arrayIndex1D].roundToInt()
        override val roundedInt64: Long
            get() = value[arrayIndex1D].roundToLong()
        override var string: String?
            get() {
                throw PuffinBasicInternalError("Can't cast int32 to String")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast String to int32: '$value'")
            }
    }

    class STStringArrayValue : AbstractSTArrayValue() {
        var value: Array<String?> = arrayOf()

        override fun fillString(fill: String?) {
            Arrays.fill(value, fill)
        }

        override var arrayDimensions: List<Int>?
            get() = super.arrayDimensions
            set(dims) {
                super.arrayDimensions = dims
                value = arrayOfNulls(totalLength)
                Arrays.fill(value, 0, value.size, "")
            }

        override fun printFormat(): String {
            return Formatter.printFormatString(value[arrayIndex1D]!!)
        }

        override fun writeFormat(): String {
            return Formatter.writeFormatString(value[arrayIndex1D]!!)
        }

        override fun assign(entry: STValue) {
            value[arrayIndex1D] = entry.string
        }

        override var int32: Int
            get() {
                throw PuffinBasicInternalError("Can't cast String to int32")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast int32 to String")
            }
        override var int64: Long
            get() {
                throw PuffinBasicInternalError("Can't cast String to int64")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast int64 to String")
            }
        override var float32: Float
            get() {
                throw PuffinBasicInternalError("Can't cast String to float32")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast float32 to String")
            }
        override var float64: Double
            get() {
                throw PuffinBasicInternalError("Can't cast String to float64")
            }
            set(value) {
                throw PuffinBasicInternalError("Can't cast float64 to String")
            }
        override val roundedInt32: Int
            get() {
                throw PuffinBasicInternalError("Can't cast String to int32")
            }
        override val roundedInt64: Long
            get() {
                throw PuffinBasicInternalError("Can't cast String to int64")
            }
        override var string: String?
            get() = value[arrayIndex1D]
            set(value) {
                this.value[arrayIndex1D] = value
            }
    }

    abstract class STCompositeValue(
        private val type: PuffinBasicTypeId,
        private val atomType: PuffinBasicAtomTypeId
    ) : STValue {
        override fun printFormat(): String? {
            throw PuffinBasicInternalError("Not implemented")
        }

        override fun writeFormat(): String? {
            throw PuffinBasicInternalError("Not implemented")
        }

        override fun assign(entry: STValue) {
            throw PuffinBasicInternalError("Not implemented")
        }

        override var int32: Int
            get() {
                throw PuffinBasicInternalError("Not implemented")
            }
            set(value) {
                throw PuffinBasicInternalError("Not implemented")
            }
        override var int64: Long
            get() {
                throw PuffinBasicInternalError("Not implemented")
            }
            set(value) {
                throw PuffinBasicInternalError("Not implemented")
            }
        override var float32: Float
            get() {
                throw PuffinBasicInternalError("Not implemented")
            }
            set(_) {
                throw PuffinBasicInternalError("Not implemented")
            }
        override var float64: Double
            get() {
                throw PuffinBasicInternalError("Not implemented")
            }
            set(value) {
                throw PuffinBasicInternalError("Not implemented")
            }
        override val roundedInt32: Int
            get() {
                throw PuffinBasicInternalError("Not implemented")
            }
        override val roundedInt64: Long
            get() {
                throw PuffinBasicInternalError("Not implemented")
            }
        override var string: String?
            get() {
                throw PuffinBasicInternalError("Not implemented")
            }
            set(_) {
                throw PuffinBasicInternalError("Not implemented")
            }
    }

    internal class STList(type: PuffinBasicType, private val memberFunctions: MemberFunctions) :
        STCompositeValue(PuffinBasicTypeId.LIST, type.atomTypeId) {
        private val list: List<Any>

        init {
            list = ArrayList()
        }

        override fun call(funcName: String, params: Array<STValue>, result: STValue) {
            memberFunctions[funcName].callHandler(list, params, result)
        }

        override fun hasLen(): Boolean {
            return true
        }

        override fun len(): Int {
            return list.size
        }
    }

    internal class STSet(type: PuffinBasicType, private val memberFunctions: MemberFunctions) :
        STCompositeValue(PuffinBasicTypeId.SET, type.atomTypeId) {
        private val set = mutableSetOf<Any>()

        override fun call(funcName: String, params: Array<STValue>, result: STValue) {
            memberFunctions[funcName].callHandler(set, params, result)
        }

        override fun hasLen(): Boolean {
            return true
        }

        override fun len(): Int {
            return set.size
        }
    }

    internal class STDict(
        valueType: PuffinBasicType,
        private val memberFunctions: MemberFunctions
    ) : STCompositeValue(PuffinBasicTypeId.DICT, valueType.atomTypeId) {
        private val dict: MutableMap<Any, Any>

        init {
            dict = mutableMapOf()
        }

        override fun call(funcName: String, params: Array<STValue>, result: STValue) {
            memberFunctions[funcName].callHandler(dict, params, result)
        }

        override fun hasLen(): Boolean {
            return true
        }

        override fun len(): Int {
            return dict.size
        }
    }

    class STStruct internal constructor(
        symbolTable: PuffinBasicSymbolTable,
        private val structType: StructType
    ) : STCompositeValue(PuffinBasicTypeId.STRUCT, PuffinBasicAtomTypeId.COMPOSITE) {
        private val memberRefIdToValueId: MutableMap<Int, Int> = mutableMapOf()

        init {
            for (entry in structType.nameToRefIdMap.entries) {
                val memberRefId = entry.value
                val valueType = structType.refIdToTypeMap[memberRefId]!!
                val valueId =
                    symbolTable.addTmp(valueType) { e: STEntry -> e.value!!.setInitialized() }
                memberRefIdToValueId[memberRefId] = valueId
            }
        }

        fun getMember(memberRefId: Int): Int {
            return memberRefIdToValueId.getOrDefault(
                memberRefId,
                PuffinBasicSymbolTable.Companion.NULL_ID
            )
        }

        override fun assign(entry: STValue) {
            if (entry !is STStruct) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.DATA_TYPE_MISMATCH,
                    "Expected STStruct but found: " + entry.javaClass
                )
            }
            if (structType != entry.structType) {
                throw PuffinBasicRuntimeError(
                    PuffinBasicRuntimeError.ErrorCode.DATA_TYPE_MISMATCH,
                    "Expected struct " + structType + ", but found " + entry.structType
                )
            }
            memberRefIdToValueId.clear()
            memberRefIdToValueId.putAll(entry.memberRefIdToValueId)
        }
    }
}