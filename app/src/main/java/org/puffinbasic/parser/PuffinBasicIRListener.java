package org.puffinbasic.parser;

import static org.puffinbasic.domain.PuffinBasicSymbolTable.NULL_ID;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.COMPOSITE;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.DOUBLE;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.FLOAT;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.INT32;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.INT64;
import static org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId.STRING;
import static org.puffinbasic.domain.STObjects.PuffinBasicTypeId.UDF;
import static org.puffinbasic.error.PuffinBasicSemanticError.ErrorCode.BAD_ARGUMENT;
import static org.puffinbasic.error.PuffinBasicSemanticError.ErrorCode.BAD_ASSIGNMENT;
import static org.puffinbasic.error.PuffinBasicSemanticError.ErrorCode.BAD_FUNCTION_DEF;
import static org.puffinbasic.error.PuffinBasicSemanticError.ErrorCode.DATA_TYPE_MISMATCH;
import static org.puffinbasic.error.PuffinBasicSemanticError.ErrorCode.FOR_WITHOUT_NEXT;
import static org.puffinbasic.error.PuffinBasicSemanticError.ErrorCode.INSUFFICIENT_UDF_ARGS;
import static org.puffinbasic.error.PuffinBasicSemanticError.ErrorCode.MISMATCHED_ELSE_BEGIN;
import static org.puffinbasic.error.PuffinBasicSemanticError.ErrorCode.MISMATCHED_ENDIF;
import static org.puffinbasic.error.PuffinBasicSemanticError.ErrorCode.NEXT_WITHOUT_FOR;
import static org.puffinbasic.error.PuffinBasicSemanticError.ErrorCode.WHILE_WITHOUT_WEND;
import static org.puffinbasic.file.PuffinBasicFile.DEFAULT_RECORD_LEN;
import static org.puffinbasic.parser.LinenumberListener.parseLinenum;
import static org.puffinbasic.runtime.Types.assertNumeric;
import static org.puffinbasic.runtime.Types.unquote;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.puffinbasic.antlr4.PuffinBasicBaseListener;
import org.puffinbasic.antlr4.PuffinBasicParser;
import org.puffinbasic.antlr4.PuffinBasicParser.VariableContext;
import org.puffinbasic.domain.STObjects;
import org.puffinbasic.domain.STObjects.ArrayType;
import org.puffinbasic.domain.STObjects.DictType;
import org.puffinbasic.domain.STObjects.ListType;
import org.puffinbasic.domain.STObjects.PuffinBasicAtomTypeId;
import org.puffinbasic.domain.STObjects.PuffinBasicType;
import org.puffinbasic.domain.STObjects.STEntry;
import org.puffinbasic.domain.STObjects.STUDF;
import org.puffinbasic.domain.STObjects.STVariable;
import org.puffinbasic.domain.STObjects.ScalarType;
import org.puffinbasic.domain.STObjects.SetType;
import org.puffinbasic.domain.Variable;
import org.puffinbasic.domain.Variable.VariableKindHint;
import org.puffinbasic.domain.Variable.VariableName;
import org.puffinbasic.error.PuffinBasicInternalError;
import org.puffinbasic.error.PuffinBasicSemanticError;
import org.puffinbasic.file.PuffinBasicFile.FileAccessMode;
import org.puffinbasic.file.PuffinBasicFile.FileOpenMode;
import org.puffinbasic.file.PuffinBasicFile.LockMode;
import org.puffinbasic.parser.PuffinBasicIR.Instruction;
import org.puffinbasic.parser.PuffinBasicIR.OpCode;
import org.puffinbasic.runtime.Numbers;
import org.puffinbasic.runtime.Types;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

public class PuffinBasicIRListener extends PuffinBasicBaseListener {

    private final AtomicInteger linenumGenerator;
    private final PuffinBasicSourceFile sourceFile;
    private final CharStream in;
    private final PuffinBasicIR ir;
    private final boolean graphics;
    private final ParseTreeProperty<Instruction> nodeToInstruction;
    private final Object2ObjectMap<Variable, UDFState> udfStateMap;
    private final LinkedList<WhileLoopState> whileLoopStateList;
    private final LinkedList<ForLoopState> forLoopStateList;
    private final LinkedList<IfState> ifStateList;
    private final ParseTreeProperty<IfState> nodeToIfState;
    private UDFState currentUdfState;
    private int currentLineNumber;

    public PuffinBasicIRListener(PuffinBasicSourceFile sourceFile, CharStream in, PuffinBasicIR ir, boolean graphics) {
        this.sourceFile = sourceFile;
        this.in = in;
        this.ir = ir;
        this.linenumGenerator = new AtomicInteger();
        this.graphics = graphics;
        this.nodeToInstruction = new ParseTreeProperty<>();
        this.udfStateMap = new Object2ObjectOpenHashMap<>();
        this.whileLoopStateList = new LinkedList<>();
        this.forLoopStateList = new LinkedList<>();
        this.ifStateList = new LinkedList<>();
        this.nodeToIfState = new ParseTreeProperty<>();
    }

    private static FileOpenMode getFileOpenMode(PuffinBasicParser.Filemode1Context filemode1) {
        var mode = filemode1 != null ? unquote(filemode1.getText()) : null;
        if (mode == null || mode.equalsIgnoreCase("r")) {
            return FileOpenMode.RANDOM;
        } else if (mode.equalsIgnoreCase("i")) {
            return FileOpenMode.INPUT;
        } else if (mode.equalsIgnoreCase("o")) {
            return FileOpenMode.OUTPUT;
        } else {
            return FileOpenMode.APPEND;
        }
    }

    private static FileOpenMode getFileOpenMode(PuffinBasicParser.Filemode2Context filemode2) {
        if (filemode2 == null || filemode2.RANDOM() != null) {
            return FileOpenMode.RANDOM;
        } else if (filemode2.INPUT() != null) {
            return FileOpenMode.INPUT;
        } else if (filemode2.OUTPUT() != null) {
            return FileOpenMode.OUTPUT;
        } else {
            return FileOpenMode.APPEND;
        }
    }

    private static FileAccessMode getFileAccessMode(PuffinBasicParser.AccessContext access) {
        if (access == null || (access.READ() != null && access.WRITE() != null)) {
            return FileAccessMode.READ_WRITE;
        } else if (access.READ() != null) {
            return FileAccessMode.READ_ONLY;
        } else {
            return FileAccessMode.WRITE_ONLY;
        }
    }

    private static LockMode getLockMode(PuffinBasicParser.LockContext lock) {
        if (lock == null) {
            return LockMode.DEFAULT;
        } else if (lock.SHARED() != null) {
            return LockMode.SHARED;
        } else if (lock.READ() != null && lock.WRITE() != null) {
            return LockMode.READ_WRITE;
        } else if (lock.READ() != null) {
            return LockMode.READ;
        } else {
            return LockMode.WRITE;
        }
    }

    public void semanticCheckAfterParsing() {
        if (!whileLoopStateList.isEmpty()) {
            throw new PuffinBasicSemanticError(
                    WHILE_WITHOUT_WEND,
                    "<UNKNOWN LINE>",
                    "WHILE without WEND"
            );
        }
        if (!forLoopStateList.isEmpty()) {
            throw new PuffinBasicSemanticError(
                    FOR_WITHOUT_NEXT,
                    "<UNKNOWN LINE>",
                    "FOR without NEXT"
            );
        }
    }

    //
    // Variable, Number, etc.
    //

    private String getCtxString(ParserRuleContext ctx) {
        return in.getText(new Interval(
                ctx.start.getStartIndex(), ctx.stop.getStopIndex()
        ));
    }

    private Instruction lookupInstruction(ParserRuleContext ctx) {
        var exprInstruction = nodeToInstruction.get(ctx);
        if (exprInstruction == null) {
            throw new PuffinBasicInternalError(
                    "Failed to find instruction for node: " + ctx.getText()
            );
        }
        return exprInstruction;
    }

    @Override
    public void enterLine(PuffinBasicParser.LineContext ctx) {
        this.currentLineNumber = ctx.linenum() != null
                ? parseLinenum(ctx.linenum().DECIMAL().getText())
                : linenumGenerator.incrementAndGet();
    }

    @Override
    public void exitNumber(PuffinBasicParser.NumberContext ctx) {
        final int id;
        if (ctx.integer() != null) {
            final boolean isLong = ctx.integer().AT() != null;
            final boolean isDouble = ctx.integer().HASH() != null;
            final boolean isFloat = ctx.integer().EXCLAMATION() != null;
            final String strValue;
            final int base;
            if (ctx.integer().HEXADECIMAL() != null) {
                strValue = ctx.integer().HEXADECIMAL().getText().substring(2);
                base = 16;
            } else if (ctx.integer().OCTAL() != null) {
                var octalStr = ctx.integer().OCTAL().getText();
                strValue = (octalStr.startsWith("&O") ? octalStr.substring(2) : octalStr.substring(1));
                base = 8;
            } else {
                strValue = ctx.integer().DECIMAL().getText();
                base = 10;
            }
            if (isLong || isDouble) {
                long parsed = Numbers.parseInt64(strValue, base, () -> getCtxString(ctx));
                id = ir.getSymbolTable().addTmp(isLong ? INT64 : DOUBLE,
                        entry -> entry.getValue().setInt64(parsed));
            } else {
                id = ir.getSymbolTable().addTmp(isFloat ? FLOAT : INT32,
                        entry -> entry.getValue().setInt32(Numbers.parseInt32(strValue, base, () -> getCtxString(ctx))));
            }
        } else if (ctx.FLOAT() != null) {
            var floatStr = ctx.FLOAT().getText();
            if (floatStr.endsWith("!")) {
                floatStr = floatStr.substring(0, floatStr.length() - 1);
            }
            var floatValue = Numbers.parseFloat32(floatStr, () -> getCtxString(ctx));
            id = ir.getSymbolTable().addTmp(FLOAT,
                    entry -> entry.getValue().setFloat32(floatValue));
        } else {
            var doubleStr = ctx.DOUBLE().getText();
            if (doubleStr.endsWith("#")) {
                doubleStr = doubleStr.substring(0, doubleStr.length() - 1);
            }
            var doubleValue = Numbers.parseFloat64(doubleStr, () -> getCtxString(ctx));
            id = ir.getSymbolTable().addTmp(DOUBLE,
                    entry -> entry.getValue().setFloat64(doubleValue));
        }

        var instr = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.VALUE, id, NULL_ID, id
        );
        nodeToInstruction.put(ctx, instr);
    }

    //
    // Expr
    //

    @Override
    public void exitVariable(VariableContext ctx) {
        final Instruction instruction = ctx.leafvariable() != null
                ? exitLeafVariable(ctx.leafvariable())
                : exitStructVariable(ctx.structvariable());
        nodeToInstruction.put(ctx, instruction);
    }

    private Instruction exitLeafVariable(PuffinBasicParser.LeafvariableContext ctx) {

        ir.getSymbolTable().checkUnused(ctx.varname().VARNAME().getText());
        var variableName = getVariableNameFromCtx(ctx.varname(), ctx.varsuffix());
        var idHolder = new AtomicInteger();

        ir.getSymbolTable().addVariableOrUDF(
                variableName,
                variableName1 -> Variable.of(variableName1, VariableKindHint.DERIVE_FROM_NAME, () -> getCtxString(ctx)),
                (varId, varEntry, variable) -> {
                    idHolder.set(varId);
                    if (variable.isScalar()) {
                        // Scalar
                        if (!ctx.expr().isEmpty()) {
                            throw new PuffinBasicSemanticError(
                                    PuffinBasicSemanticError.ErrorCode.SCALAR_VARIABLE_CANNOT_BE_INDEXED,
                                    getCtxString(ctx),
                                    "Scalar variable cannot be indexed: " + variable);
                        }
                    } else if (variable.isArray()) {
                        if (!ctx.expr().isEmpty()) {
                            // Array
                            ir.addInstruction(
                                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                                    OpCode.RESET_ARRAY_IDX,
                                    varId, NULL_ID, NULL_ID);

                            for (var exprCtx : ctx.expr()) {
                                var exprInstr = lookupInstruction(exprCtx);
                                ir.addInstruction(
                                        sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                                        OpCode.SET_ARRAY_IDX,
                                        varId, exprInstr.result, NULL_ID);
                            }
                            var refId = ir.getSymbolTable().addArrayReference(varEntry);
                            ir.addInstruction(
                                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                                    OpCode.ARRAYREF,
                                    varId, refId, refId);
                            idHolder.set(refId);
                        }
                    } else if (variable.isUDF()) {
                        // UDF
                        var udfEntry = (STUDF) varEntry;
                        var udfState = udfStateMap.get(variable);

                        // Create & Push Runtime scope
                        var pushScopeInstr =
                                ir.addInstruction(
                                        sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                                        OpCode.PUSH_RT_SCOPE,
                                        varId, NULL_ID, NULL_ID);
                        // Copy caller params to Runtime scope
                        if (ctx.expr().size() != udfEntry.getNumDeclaredParams()) {
                            throw new PuffinBasicSemanticError(
                                    INSUFFICIENT_UDF_ARGS,
                                    getCtxString(ctx),
                                    variable
                                            + " expects "
                                            + udfEntry.getNumDeclaredParams()
                                            + ", #args passed: "
                                            + ctx.expr().size());
                        }
                        int i = 0;
                        for (var exprCtx : ctx.expr()) {
                            var exprInstr = lookupInstruction(exprCtx);
                            var declParamId = udfEntry.getDeclaredParam(i++);
                            ir.addInstruction(
                                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                                    OpCode.PARAM_COPY,
                                    exprInstr.result, declParamId, declParamId);
                        }
                        // GOTO labelFuncStart
                        ir.addInstruction(
                                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                                OpCode.GOTO_LABEL,
                                udfState.labelFuncStart.op1, NULL_ID, NULL_ID);
                        // LABEL caller return address
                        var labelCallerReturn =
                                ir.addInstruction(
                                        sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                                        OpCode.LABEL,
                                        ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID);
                        // Patch address of the caller
                        pushScopeInstr.patchOp2(labelCallerReturn.op1);
                        // Pop Runtime scope
                        ir.addInstruction(
                                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                                OpCode.POP_RT_SCOPE,
                                varId, NULL_ID, NULL_ID);
                    }
                });

        var refId = idHolder.get();
        return ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.VARIABLE, refId, NULL_ID, refId
        );
    }

    private Instruction exitStructVariable(PuffinBasicParser.StructvariableContext ctx) {
        var root = ctx.varname(0).VARNAME().getText();
        var rootId = ir.getSymbolTable().getCompositeVariableIdForVariable(
                new VariableName(root, null, COMPOSITE));
        var structType = ir.getSymbolTable().get(rootId).getType().asStruct();

        var parentTypeName = structType.getTypeName();
        for (int i = 1; i < ctx.varname().size(); i++) {
            var struct = ir.getSymbolTable().getStructType(parentTypeName);
            var childVarname = ctx.varname(i).VARNAME().getText();
            var childName = new VariableName(childVarname, null, COMPOSITE);
            var childRefId = struct.getMemberRefId(childName);
            var childTypeName = struct.getMemberType(childName).asStruct().getTypeName();
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.PARAM1,
                    ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(childRefId)),
                    NULL_ID, NULL_ID);
            parentTypeName = childTypeName;
        }

        var struct = ir.getSymbolTable().getStructType(parentTypeName);
        var leafCtx = ctx.leafvariable();
        var leafVarname = leafCtx.varname().VARNAME().getText();
        var leafDataType = struct.containsMember(new VariableName(leafVarname, null, COMPOSITE))
                ? struct.getMemberType(new VariableName(leafVarname, null, COMPOSITE)).getAtomTypeId()
                : ir.getSymbolTable().getDataTypeFor(leafVarname,
                leafCtx.varsuffix() != null ? leafCtx.varsuffix().getText() : null);
        var leafName = new VariableName(leafVarname, leafDataType.getRepr(), leafDataType);
        var leafRefId = struct.getMemberRefId(leafName);
        var leafType = struct.getMemberType(leafName);

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM1,
                ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(leafRefId)),
                NULL_ID, NULL_ID);

        var result = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.STRUCT_LVALUE,
                rootId, NULL_ID,
                ir.getSymbolTable().addRef(leafType));

        if (!ctx.expr().isEmpty()) {
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.RESET_ARRAY_IDX,
                    result.result, NULL_ID, NULL_ID);

            for (var exprCtx : ctx.expr()) {
                var exprInstr = lookupInstruction(exprCtx);
                ir.addInstruction(
                        sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                        OpCode.SET_ARRAY_IDX,
                        result.result, exprInstr.result, NULL_ID);
            }
            var refId = ir.getSymbolTable().addArrayReference(
                    (STObjects.STLValue) ir.getSymbolTable().get(result.result));
            result = ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.ARRAYREF,
                    result.result, refId, refId);
        }

        return result;
    }

    private void copyAndRegisterExprResult(ParserRuleContext ctx, Instruction instruction, boolean shouldCopy) {
        if (shouldCopy) {
            var copy = ir.getSymbolTable().addTmpCompatibleWith(instruction.result);
            instruction = ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.COPY, instruction.result, copy, copy
            );
        }
        nodeToInstruction.put(ctx, instruction);
    }

    @Override
    public void exitExprVariable(PuffinBasicParser.ExprVariableContext ctx) {
        var instruction = nodeToInstruction.get(ctx.variable());
        var varEntry = ir.getSymbolTable().get(instruction.result);
        boolean copy = (varEntry instanceof STVariable) && ((STVariable) varEntry).getVariable().isUDF();
        if (ctx.MINUS() != null) {
            if (ir.getSymbolTable().get(instruction.result).getType().getAtomTypeId() == STRING) {
                throw new PuffinBasicSemanticError(
                        DATA_TYPE_MISMATCH,
                        getCtxString(ctx),
                        "Unary minus cannot be used with a String!"
                );
            }
            instruction = ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.UNARY_MINUS, instruction.result, NULL_ID,
                    ir.getSymbolTable().addTmpCompatibleWith(instruction.result)
            );
            copy = true;
        }
        copyAndRegisterExprResult(ctx, instruction, copy);
    }

    @Override
    public void exitExprParen(PuffinBasicParser.ExprParenContext ctx) {
        nodeToInstruction.put(ctx, lookupInstruction(ctx.expr()));
    }

    @Override
    public void exitExprNumber(PuffinBasicParser.ExprNumberContext ctx) {
        var instruction = nodeToInstruction.get(ctx.number());
        if (ctx.MINUS() != null) {
            instruction = ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.UNARY_MINUS, instruction.result, NULL_ID,
                    ir.getSymbolTable().addTmpCompatibleWith(instruction.result)
            );
        }
        copyAndRegisterExprResult(ctx, instruction, false);
    }

    @Override
    public void exitExprFunc(PuffinBasicParser.ExprFuncContext ctx) {
        var instruction = nodeToInstruction.get(ctx.func());
        if (ctx.MINUS() != null) {
            instruction = ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.UNARY_MINUS, instruction.result, NULL_ID,
                    ir.getSymbolTable().addTmpCompatibleWith(instruction.result)
            );
        }
        copyAndRegisterExprResult(ctx, instruction, false);
    }

    @Override
    public void exitExprString(PuffinBasicParser.ExprStringContext ctx) {
        var text = unquote(ctx.string().STRING().getText());
        var id = ir.getSymbolTable().addTmp(STRING,
                entry -> entry.getValue().setString(text));
        copyAndRegisterExprResult(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.VALUE, id, NULL_ID, id
        ), false);
    }

    @Override
    public void exitExprExp(PuffinBasicParser.ExprExpContext ctx) {
        var expr1 = ctx.expr(0);
        var expr2 = ctx.expr(1);
        int instr1res = lookupInstruction(expr1).result;
        int instr2res = lookupInstruction(expr2).result;
        var dt1 = ir.getSymbolTable().get(instr1res).getType().getAtomTypeId();
        var dt2 = ir.getSymbolTable().get(instr2res).getType().getAtomTypeId();
        Types.assertNumeric(dt1, dt2, () -> getCtxString(ctx));
        var upcast = Types.upcast(dt1, dt2, () -> getCtxString(ctx));
        var result = ir.getSymbolTable().addTmp(upcast, e -> {
        });
        final OpCode opCode;
        switch (upcast) {
            case INT32:
                opCode = OpCode.EXPI32;
                break;
            case INT64:
                opCode = OpCode.EXPI64;
                break;
            case FLOAT:
                opCode = OpCode.EXPF32;
                break;
            case DOUBLE:
                opCode = OpCode.EXPF64;
                break;
            default:
                throw new PuffinBasicInternalError("Bad type: " + upcast);
        }
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                opCode, instr1res, instr2res, result
        ));
    }

    @Override
    public void exitExprMulDiv(PuffinBasicParser.ExprMulDivContext ctx) {
        var expr1 = ctx.expr(0);
        var expr2 = ctx.expr(1);
        int instr1res = lookupInstruction(expr1).result;
        int instr2res = lookupInstruction(expr2).result;
        var dt1 = ir.getSymbolTable().get(instr1res).getType().getAtomTypeId();
        var dt2 = ir.getSymbolTable().get(instr2res).getType().getAtomTypeId();
        Types.assertNumeric(dt1, dt2, () -> getCtxString(ctx));
        var upcast = Types.upcast(dt1, dt2, () -> getCtxString(ctx));
        final int result;
        final OpCode opCode;
        if (ctx.MUL() != null) {
            result = ir.getSymbolTable().addTmp(upcast, e -> {
            });
            switch (upcast) {
                case INT32:
                    opCode = OpCode.MULI32;
                    break;
                case INT64:
                    opCode = OpCode.MULI64;
                    break;
                case FLOAT:
                    opCode = OpCode.MULF32;
                    break;
                case DOUBLE:
                    opCode = OpCode.MULF64;
                    break;
                default:
                    throw new PuffinBasicInternalError("Bad type: " + upcast);
            }
        } else if (ctx.INT_DIV() != null) {
            result = ir.getSymbolTable().addTmp(upcast, e -> {
            });
            opCode = OpCode.IDIV;
        } else {
            result = ir.getSymbolTable().addTmp(DOUBLE, e -> {
            });
            opCode = OpCode.FDIV;
        }
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                opCode, instr1res, instr2res, result
        ));
    }

    @Override
    public void exitExprMod(PuffinBasicParser.ExprModContext ctx) {
        addArithmeticOpExpr(ctx, OpCode.MOD, ctx.expr(0), ctx.expr(1));
    }

    @Override
    public void exitExprPlusMinus(PuffinBasicParser.ExprPlusMinusContext ctx) {
        var expr1 = ctx.expr(0);
        var expr2 = ctx.expr(1);
        int instr1res = lookupInstruction(expr1).result;
        int instr2res = lookupInstruction(expr2).result;
        var dt1 = ir.getSymbolTable().get(instr1res).getType().getAtomTypeId();
        var dt2 = ir.getSymbolTable().get(instr2res).getType().getAtomTypeId();
        boolean plus = ctx.PLUS() != null;
        if (dt1 == STRING && dt2 == STRING) {
            if (plus) {
                nodeToInstruction.put(ctx, ir.addInstruction(
                        sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                        OpCode.CONCAT, instr1res, instr2res,
                        ir.getSymbolTable().addTmp(STRING, e -> {
                        })
                ));
            } else {
                throw new PuffinBasicSemanticError(
                        DATA_TYPE_MISMATCH,
                        getCtxString(ctx),
                        "Minus ('-') doesn't work with String data type!"
                );
            }
        } else {
            Types.assertNumeric(dt1, dt2, () -> getCtxString(ctx));
            var upcast = Types.upcast(dt1, dt2, () -> getCtxString(ctx));
            var result = ir.getSymbolTable().addTmp(upcast, e -> {
            });
            final OpCode opCode;
            switch (upcast) {
                case INT32:
                    opCode = plus ? OpCode.ADDI32 : OpCode.SUBI32;
                    break;
                case INT64:
                    opCode = plus ? OpCode.ADDI64 : OpCode.SUBI64;
                    break;
                case FLOAT:
                    opCode = plus ? OpCode.ADDF32 : OpCode.SUBF32;
                    break;
                case DOUBLE:
                    opCode = plus ? OpCode.ADDF64 : OpCode.SUBF64;
                    break;
                default:
                    throw new PuffinBasicInternalError("Bad type: " + upcast);
            }
            nodeToInstruction.put(ctx, ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    opCode, instr1res, instr2res, result
            ));
        }
    }

    private void addArithmeticOpExpr(
            ParserRuleContext parent, OpCode opCode, PuffinBasicParser.ExprContext exprLeft, PuffinBasicParser.ExprContext exprRight) {
        var exprL = lookupInstruction(exprLeft);
        var exprR = lookupInstruction(exprRight);
        var dt1 = ir.getSymbolTable().get(exprL.result).getType().getAtomTypeId();
        var dt2 = ir.getSymbolTable().get(exprR.result).getType().getAtomTypeId();
        Types.assertNumeric(dt1, dt2, () -> getCtxString(parent));
        var result = ir.getSymbolTable().addTmp(
                Types.upcast(dt1,
                        ir.getSymbolTable().get(exprR.result).getType().getAtomTypeId(),
                        () -> getCtxString(parent)),
                e -> {
                });
        nodeToInstruction.put(parent, ir.addInstruction(
                sourceFile, currentLineNumber, parent.start.getStartIndex(), parent.stop.getStopIndex(),
                opCode, exprL.result, exprR.result, result
        ));
    }

    @Override
    public void exitExprRelational(PuffinBasicParser.ExprRelationalContext ctx) {
        var exprL = lookupInstruction(ctx.expr(0));
        var exprR = lookupInstruction(ctx.expr(1));
        var dt1 = ir.getSymbolTable().get(exprL.result).getType().getAtomTypeId();
        var dt2 = ir.getSymbolTable().get(exprR.result).getType().getAtomTypeId();
        checkDataTypeMatch(dt1, dt2, () -> getCtxString(ctx));

        final OpCode opCode;
        if (dt1 == STRING && dt2 == STRING) {
            opCode = ctx.RELEQ() != null ? OpCode.EQSTR
                    : ctx.RELNEQ() != null ? OpCode.NESTR
                    : ctx.RELLT() != null ? OpCode.LTSTR
                    : ctx.RELGT() != null ? OpCode.GTSTR
                    : ctx.RELLE() != null ? OpCode.LESTR
                    : ctx.RELGE() != null ? OpCode.GESTR
                    : null;
        } else {
            if (dt1 == DOUBLE || dt2 == DOUBLE) {
                opCode = ctx.RELEQ() != null ? OpCode.EQF64
                        : ctx.RELNEQ() != null ? OpCode.NEF64
                        : ctx.RELLT() != null ? OpCode.LTF64
                        : ctx.RELGT() != null ? OpCode.GTF64
                        : ctx.RELLE() != null ? OpCode.LEF64
                        : ctx.RELGE() != null ? OpCode.GEF64
                        : null;
            } else if (dt1 == INT64 || dt2 == INT64) {
                opCode = ctx.RELEQ() != null ? OpCode.EQI64
                        : ctx.RELNEQ() != null ? OpCode.NEI64
                        : ctx.RELLT() != null ? OpCode.LTI64
                        : ctx.RELGT() != null ? OpCode.GTI64
                        : ctx.RELLE() != null ? OpCode.LEI64
                        : ctx.RELGE() != null ? OpCode.GEI64
                        : null;
            } else if (dt1 == FLOAT || dt2 == FLOAT) {
                opCode = ctx.RELEQ() != null ? OpCode.EQF32
                        : ctx.RELNEQ() != null ? OpCode.NEF32
                        : ctx.RELLT() != null ? OpCode.LTF32
                        : ctx.RELGT() != null ? OpCode.GTF32
                        : ctx.RELLE() != null ? OpCode.LEF32
                        : ctx.RELGE() != null ? OpCode.GEF32
                        : null;
            } else {
                opCode = ctx.RELEQ() != null ? OpCode.EQI32
                        : ctx.RELNEQ() != null ? OpCode.NEI32
                        : ctx.RELLT() != null ? OpCode.LTI32
                        : ctx.RELGT() != null ? OpCode.GTI32
                        : ctx.RELLE() != null ? OpCode.LEI32
                        : ctx.RELGE() != null ? OpCode.GEI32
                        : null;
            }
        }
        if (opCode == null) {
            throw new PuffinBasicSemanticError(
                    DATA_TYPE_MISMATCH,
                    getCtxString(ctx),
                    "Unsupported operator!"
            );
        }

        var result = ir.getSymbolTable().addTmp(INT64, e -> {
        });
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                opCode, exprL.result, exprR.result, result
        ));
    }

    @Override
    public void exitExprLogNot(PuffinBasicParser.ExprLogNotContext ctx) {
        var expr = lookupInstruction(ctx.expr());
        Types.assertNumeric(
                ir.getSymbolTable().get(expr.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx)
        );
        var result = ir.getSymbolTable().addTmp(INT64, e -> {
        });
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.NOT, expr.result, NULL_ID, result
        ));
    }

    @Override
    public void exitExprLogical(PuffinBasicParser.ExprLogicalContext ctx) {
        final OpCode opCode = ctx.LOGAND() != null ? OpCode.AND
                : ctx.LOGOR() != null ? OpCode.OR
                : ctx.LOGXOR() != null ? OpCode.XOR
                : ctx.LOGEQV() != null ? OpCode.EQV
                : ctx.LOGIMP() != null ? OpCode.IMP
                : null;

        if (opCode == null) {
            throw new PuffinBasicSemanticError(
                    DATA_TYPE_MISMATCH,
                    getCtxString(ctx),
                    "Unsupported operator!"
            );
        }

        addLogicalOpExpr(ctx, opCode, ctx.expr(0), ctx.expr(1));
    }

    //
    // Functions
    //

    @Override
    public void exitExprBitwise(PuffinBasicParser.ExprBitwiseContext ctx) {
        final OpCode opCode = ctx.BWLSFT() != null ? OpCode.LEFTSHIFT
                : ctx.BWRSFT() != null ? OpCode.RIGHTSHIFT
                : null;

        if (opCode == null) {
            throw new PuffinBasicSemanticError(
                    DATA_TYPE_MISMATCH,
                    getCtxString(ctx),
                    "Unsupported operator!"
            );
        }
        addBitwiseOpExpr(ctx, opCode, ctx.expr(0), ctx.expr(1));
    }

    private void addLogicalOpExpr(
            ParserRuleContext parent, OpCode opCode, PuffinBasicParser.ExprContext exprLeft, PuffinBasicParser.ExprContext exprRight) {
        var exprL = lookupInstruction(exprLeft);
        var exprR = lookupInstruction(exprRight);
        Types.assertNumeric(
                ir.getSymbolTable().get(exprL.result).getType().getAtomTypeId(),
                ir.getSymbolTable().get(exprR.result).getType().getAtomTypeId(),
                () -> getCtxString(parent)
        );
        var result = ir.getSymbolTable().addTmp(INT64, e -> {
        });
        nodeToInstruction.put(parent, ir.addInstruction(
                sourceFile, currentLineNumber, parent.start.getStartIndex(), parent.stop.getStopIndex(),
                opCode, exprL.result, exprR.result, result
        ));
    }

    private void addBitwiseOpExpr(
            ParserRuleContext parent, OpCode opCode, PuffinBasicParser.ExprContext exprLeft, PuffinBasicParser.ExprContext exprRight) {
        var exprL = lookupInstruction(exprLeft);
        var exprR = lookupInstruction(exprRight);
        Types.assertNumeric(
                ir.getSymbolTable().get(exprL.result).getType().getAtomTypeId(),
                ir.getSymbolTable().get(exprR.result).getType().getAtomTypeId(),
                () -> getCtxString(parent)
        );
        var result = ir.getSymbolTable().addTmp(INT64, e -> {
        });
        nodeToInstruction.put(parent, ir.addInstruction(
                sourceFile, currentLineNumber, parent.start.getStartIndex(), parent.stop.getStopIndex(),
                opCode, exprL.result, exprR.result, result
        ));
    }

    @Override
    public void exitFuncAbs(PuffinBasicParser.FuncAbsContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.ABS, ctx, ctx.expr(),
                NumericOrString.NUMERIC));
    }

    @Override
    public void exitFuncAsc(PuffinBasicParser.FuncAscContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.ASC, ctx, ctx.expr(),
                NumericOrString.STRING,
                ir.getSymbolTable().addTmp(INT32, c -> {
                })));
    }

    @Override
    public void exitFuncSin(PuffinBasicParser.FuncSinContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.SIN, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncCos(PuffinBasicParser.FuncCosContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.COS, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncTan(PuffinBasicParser.FuncTanContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.TAN, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncASin(PuffinBasicParser.FuncASinContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.ASIN, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncACos(PuffinBasicParser.FuncACosContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.ACOS, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncAtn(PuffinBasicParser.FuncAtnContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.ATN, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncSinh(PuffinBasicParser.FuncSinhContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.SINH, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncCosh(PuffinBasicParser.FuncCoshContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.COSH, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncTanh(PuffinBasicParser.FuncTanhContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.TANH, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncExp(PuffinBasicParser.FuncExpContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.EEXP, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncLog10(PuffinBasicParser.FuncLog10Context ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.LOG10, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncLog2(PuffinBasicParser.FuncLog2Context ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.LOG2, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncToRad(PuffinBasicParser.FuncToRadContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.TORAD, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncToDeg(PuffinBasicParser.FuncToDegContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.TODEG, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncFloor(PuffinBasicParser.FuncFloorContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.FLOOR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncCeil(PuffinBasicParser.FuncCeilContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.CEIL, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncRound(PuffinBasicParser.FuncRoundContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.ROUND, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncSqr(PuffinBasicParser.FuncSqrContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.SQR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncCint(PuffinBasicParser.FuncCintContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.CINT, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(INT32, c -> {
                })));
    }

    @Override
    public void exitFuncClng(PuffinBasicParser.FuncClngContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.CLNG, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(INT64, c -> {
                })));
    }

    @Override
    public void exitFuncCsng(PuffinBasicParser.FuncCsngContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.CSNG, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(FLOAT, c -> {
                })));
    }

    @Override
    public void exitFuncCdbl(PuffinBasicParser.FuncCdblContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.CDBL, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncCvi(PuffinBasicParser.FuncCviContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.CVI, ctx, ctx.expr(),
                NumericOrString.STRING,
                ir.getSymbolTable().addTmp(INT32, c -> {
                })));
    }

    @Override
    public void exitFuncCvl(PuffinBasicParser.FuncCvlContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.CVL, ctx, ctx.expr(),
                NumericOrString.STRING,
                ir.getSymbolTable().addTmp(INT64, c -> {
                })));
    }

    @Override
    public void exitFuncCvs(PuffinBasicParser.FuncCvsContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.CVS, ctx, ctx.expr(),
                NumericOrString.STRING,
                ir.getSymbolTable().addTmp(FLOAT, c -> {
                })));
    }

    @Override
    public void exitFuncCvd(PuffinBasicParser.FuncCvdContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.CVD, ctx, ctx.expr(),
                NumericOrString.STRING,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncMkiDlr(PuffinBasicParser.FuncMkiDlrContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.MKIDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(STRING, c -> {
                })));
    }

    @Override
    public void exitFuncMklDlr(PuffinBasicParser.FuncMklDlrContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.MKLDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(STRING, c -> {
                })));
    }

    @Override
    public void exitFuncMksDlr(PuffinBasicParser.FuncMksDlrContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.MKSDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(STRING, c -> {
                })));
    }

    @Override
    public void exitFuncMkdDlr(PuffinBasicParser.FuncMkdDlrContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.MKDDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(STRING, c -> {
                })));
    }

    @Override
    public void exitFuncSpaceDlr(PuffinBasicParser.FuncSpaceDlrContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.SPACEDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(STRING, c -> {
                })));
    }

    @Override
    public void exitFuncStrDlr(PuffinBasicParser.FuncStrDlrContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.STRDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(STRING, c -> {
                })));
    }

    @Override
    public void exitFuncVal(PuffinBasicParser.FuncValContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.VAL
                , ctx, ctx.expr(),
                NumericOrString.STRING,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncInt(PuffinBasicParser.FuncIntContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.INT, ctx, ctx.expr(),
                NumericOrString.NUMERIC));
    }

    @Override
    public void exitFuncFix(PuffinBasicParser.FuncFixContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.FIX, ctx, ctx.expr(),
                NumericOrString.NUMERIC));
    }

    @Override
    public void exitFuncLog(PuffinBasicParser.FuncLogContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.LOG, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncLen(PuffinBasicParser.FuncLenContext ctx) {
        var exprInstruction = lookupInstruction(ctx.expr(0));
        var axisId = ctx.axis != null ? lookupInstruction(ctx.axis).result : NULL_ID;
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LEN, exprInstruction.result, axisId, ir.getSymbolTable().addTmp(INT32, c -> {
                })
        ));
    }

    @Override
    public void exitFuncChrDlr(PuffinBasicParser.FuncChrDlrContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.CHRDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(STRING, c -> {
                })));
    }

    @Override
    public void exitFuncHexDlr(PuffinBasicParser.FuncHexDlrContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.HEXDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(STRING, c -> {
                })));
    }

    @Override
    public void exitFuncOctDlr(PuffinBasicParser.FuncOctDlrContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.OCTDLR, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(STRING, c -> {
                })));
    }

    @Override
    public void exitFuncLeftDlr(PuffinBasicParser.FuncLeftDlrContext ctx) {
        var xdlr = lookupInstruction(ctx.expr(0));
        var n = lookupInstruction(ctx.expr(1));
        Types.assertString(ir.getSymbolTable().get(xdlr.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(n.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LEFTDLR, xdlr.result, n.result,
                ir.getSymbolTable().addTmp(STRING, c -> {
                })));
    }

    @Override
    public void exitFuncRightDlr(PuffinBasicParser.FuncRightDlrContext ctx) {
        var xdlr = lookupInstruction(ctx.expr(0));
        var n = lookupInstruction(ctx.expr(1));
        Types.assertString(ir.getSymbolTable().get(xdlr.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(n.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.RIGHTDLR, xdlr.result, n.result,
                ir.getSymbolTable().addTmp(STRING, c -> {
                })));
    }

    @Override
    public void exitFuncInstr(PuffinBasicParser.FuncInstrContext ctx) {
        int xdlr, ydlr, n;
        if (ctx.expr().size() == 3) {
            // n, x$, y$
            n = lookupInstruction(ctx.expr(0)).result;
            xdlr = lookupInstruction(ctx.expr(1)).result;
            ydlr = lookupInstruction(ctx.expr(2)).result;
            Types.assertNumeric(ir.getSymbolTable().get(n).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
        } else {
            // x$, y$
            n = ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(1));
            xdlr = lookupInstruction(ctx.expr(0)).result;
            ydlr = lookupInstruction(ctx.expr(1)).result;
        }
        Types.assertString(ir.getSymbolTable().get(xdlr).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertString(ir.getSymbolTable().get(ydlr).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, xdlr, ydlr, NULL_ID);
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.INSTR, n, NULL_ID,
                ir.getSymbolTable().addTmp(INT32, c -> {
                })));
    }

    @Override
    public void exitFuncMidDlr(PuffinBasicParser.FuncMidDlrContext ctx) {
        int xdlr, n, m;
        if (ctx.expr().size() == 3) {
            // x$, n, m
            xdlr = lookupInstruction(ctx.expr(0)).result;
            n = lookupInstruction(ctx.expr(1)).result;
            m = lookupInstruction(ctx.expr(2)).result;
            Types.assertNumeric(ir.getSymbolTable().get(m).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
        } else {
            // x$, n
            xdlr = lookupInstruction(ctx.expr(0)).result;
            n = lookupInstruction(ctx.expr(1)).result;
            m = ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(Integer.MAX_VALUE));
        }
        Types.assertString(ir.getSymbolTable().get(xdlr).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(n).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, xdlr, n, NULL_ID);
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.MIDDLR, m, NULL_ID,
                ir.getSymbolTable().addTmp(STRING, c -> {
                })));
    }

    @Override
    public void exitFuncRnd(PuffinBasicParser.FuncRndContext ctx) {
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.RND, NULL_ID, NULL_ID,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncSgn(PuffinBasicParser.FuncSgnContext ctx) {
        nodeToInstruction.put(ctx, addFuncWithExprInstruction(OpCode.SGN, ctx, ctx.expr(),
                NumericOrString.NUMERIC,
                ir.getSymbolTable().addTmp(INT32, c -> {
                })));
    }

    @Override
    public void exitFuncTimer(PuffinBasicParser.FuncTimerContext ctx) {
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.TIMER, NULL_ID, NULL_ID,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncTimerMillis(PuffinBasicParser.FuncTimerMillisContext ctx) {
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.TIMERMILLIS, NULL_ID, NULL_ID,
                ir.getSymbolTable().addTmp(INT64, c -> {
                })));
    }

    @Override
    public void exitFuncStringDlr(PuffinBasicParser.FuncStringDlrContext ctx) {
        int n = lookupInstruction(ctx.expr(0)).result;
        int jOrxdlr = lookupInstruction(ctx.expr(1)).result;
        Types.assertNumeric(ir.getSymbolTable().get(n).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.STRINGDLR, n, jOrxdlr,
                ir.getSymbolTable().addTmp(STRING, c -> {
                })));
    }

    @Override
    public void exitFuncLoc(PuffinBasicParser.FuncLocContext ctx) {
        var fileNumber = lookupInstruction(ctx.expr());
        Types.assertNumeric(ir.getSymbolTable().get(fileNumber.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LOC, fileNumber.result, NULL_ID,
                ir.getSymbolTable().addTmp(INT32, c -> {
                })));
    }

    @Override
    public void exitFuncLof(PuffinBasicParser.FuncLofContext ctx) {
        var fileNumber = lookupInstruction(ctx.expr());
        Types.assertNumeric(ir.getSymbolTable().get(fileNumber.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LOF, fileNumber.result, NULL_ID,
                ir.getSymbolTable().addTmp(INT64, c -> {
                })));
    }

    @Override
    public void exitFuncEof(PuffinBasicParser.FuncEofContext ctx) {
        var fileNumber = lookupInstruction(ctx.expr());
        Types.assertNumeric(ir.getSymbolTable().get(fileNumber.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.EOF, fileNumber.result, NULL_ID,
                ir.getSymbolTable().addTmp(INT32, c -> {
                })));
    }

    @Override
    public void exitFuncEnvironDlr(PuffinBasicParser.FuncEnvironDlrContext ctx) {
        var expr = lookupInstruction(ctx.expr());
        Types.assertString(ir.getSymbolTable().get(expr.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ENVIRONDLR, expr.result, NULL_ID,
                ir.getSymbolTable().addTmp(STRING, c -> {
                })));
    }

    @Override
    public void exitFuncInputDlr(PuffinBasicParser.FuncInputDlrContext ctx) {
        var x = lookupInstruction(ctx.expr(0));
        Types.assertNumeric(ir.getSymbolTable().get(x.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));

        int fileNumberId;
        if (ctx.expr().size() == 2) {
            var fileNumber = lookupInstruction(ctx.expr(1));
            Types.assertNumeric(ir.getSymbolTable().get(fileNumber.result).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
            fileNumberId = fileNumber.result;
        } else {
            fileNumberId = ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(-1));
        }
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.INPUTDLR, x.result, fileNumberId,
                ir.getSymbolTable().addTmp(STRING, c -> {
                })));
    }

    @Override
    public void exitFuncInkeyDlr(PuffinBasicParser.FuncInkeyDlrContext ctx) {
        assertGraphics();
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.INKEYDLR, NULL_ID, NULL_ID,
                ir.getSymbolTable().addTmp(STRING, c -> {
                })));
    }

    @Override
    public void exitFuncE(PuffinBasicParser.FuncEContext ctx) {
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.E, NULL_ID, NULL_ID,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncPI(PuffinBasicParser.FuncPIContext ctx) {
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PI, NULL_ID, NULL_ID,
                ir.getSymbolTable().addTmp(DOUBLE, c -> {
                })));
    }

    @Override
    public void exitFuncMin(PuffinBasicParser.FuncMinContext ctx) {
        var expr1 = lookupInstruction(ctx.expr(0));
        var expr2 = lookupInstruction(ctx.expr(1));
        var dt1 = ir.getSymbolTable().get(expr1.result).getType().getAtomTypeId();
        var dt2 = ir.getSymbolTable().get(expr2.result).getType().getAtomTypeId();
        Types.assertNumeric(dt1, () -> getCtxString(ctx));
        Types.assertNumeric(dt2, () -> getCtxString(ctx));
        var resdt = Types.upcast(dt1, dt2, () -> getCtxString(ctx));
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.MIN, expr1.result, expr2.result,
                ir.getSymbolTable().addTmp(resdt, e -> {
                })));
    }

    @Override
    public void exitFuncMax(PuffinBasicParser.FuncMaxContext ctx) {
        var expr1 = lookupInstruction(ctx.expr(0));
        var expr2 = lookupInstruction(ctx.expr(1));
        var dt1 = ir.getSymbolTable().get(expr1.result).getType().getAtomTypeId();
        var dt2 = ir.getSymbolTable().get(expr2.result).getType().getAtomTypeId();
        Types.assertNumeric(dt1, () -> getCtxString(ctx));
        Types.assertNumeric(dt2, () -> getCtxString(ctx));
        var resdt = Types.upcast(dt1, dt2, () -> getCtxString(ctx));
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.MAX, expr1.result, expr2.result,
                ir.getSymbolTable().addTmp(resdt, e -> {
                })));
    }

    private Instruction getArray1dVariableInstruction(ParserRuleContext ctx, VariableContext varCtx, boolean numeric) {
        var varInstr = lookupInstruction(varCtx);
        assertVariable(ir.getSymbolTable().get(varInstr.result), () -> getCtxString(ctx));
        var varEntry = (STVariable) ir.getSymbolTable().get(varInstr.result);
        assert1DArray(varEntry, () -> getCtxString(ctx));
        if (numeric) {
            assertNumeric(varEntry.getType().getAtomTypeId(), () -> getCtxString(ctx));
        }
        return varInstr;
    }

    private Instruction getArray2dVariableInstruction(ParserRuleContext ctx, VariableContext varCtx) {
        var varInstr = lookupInstruction(varCtx);
        assertVariable(ir.getSymbolTable().get(varInstr.result), () -> getCtxString(ctx));
        var varEntry = (STVariable) ir.getSymbolTable().get(varInstr.result);
        assert2DArray(varEntry, () -> getCtxString(ctx));
        return varInstr;
    }

    private Instruction getArrayNdVariableInstruction(ParserRuleContext ctx, VariableContext varCtx) {
        var varInstr = lookupInstruction(varCtx);
        assertVariable(ir.getSymbolTable().get(varInstr.result), () -> getCtxString(ctx));
        var varEntry = (STVariable) ir.getSymbolTable().get(varInstr.result);
        assertNDArray(varEntry, () -> getCtxString(ctx));
        return varInstr;
    }

    @Override
    public void exitFuncArray1DMin(PuffinBasicParser.FuncArray1DMinContext ctx) {
        var var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), true);
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ARRAY1DMIN, var1Instr.result, NULL_ID,
                ir.getSymbolTable().addTmpCompatibleWith(var1Instr.result)));
    }

    @Override
    public void exitFuncArray1DMax(PuffinBasicParser.FuncArray1DMaxContext ctx) {
        var var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), true);
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ARRAY1DMAX, var1Instr.result, NULL_ID,
                ir.getSymbolTable().addTmpCompatibleWith(var1Instr.result)));
    }

    @Override
    public void exitFuncArray1DMean(PuffinBasicParser.FuncArray1DMeanContext ctx) {
        var var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), true);
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ARRAY1DMEAN, var1Instr.result, NULL_ID,
                ir.getSymbolTable().addTmp(DOUBLE, e -> {
                })));
    }

    @Override
    public void exitFuncArray1DSum(PuffinBasicParser.FuncArray1DSumContext ctx) {
        var var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), true);
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ARRAY1DSUM, var1Instr.result, NULL_ID,
                ir.getSymbolTable().addTmp(DOUBLE, e -> {
                })));
    }

    @Override
    public void exitFuncArray1DStd(PuffinBasicParser.FuncArray1DStdContext ctx) {
        var var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), true);
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ARRAY1DSTD, var1Instr.result, NULL_ID,
                ir.getSymbolTable().addTmp(DOUBLE, e -> {
                })));
    }

    @Override
    public void exitFuncArray1DMedian(PuffinBasicParser.FuncArray1DMedianContext ctx) {
        var var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), true);
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ARRAY1DMEDIAN, var1Instr.result, NULL_ID,
                ir.getSymbolTable().addTmp(DOUBLE, e -> {
                })));
    }

    @Override
    public void exitFuncArray1DBinSearch(PuffinBasicParser.FuncArray1DBinSearchContext ctx) {
        var var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), false);
        var expr = lookupInstruction(ctx.expr());
        Types.assertNumeric(ir.getSymbolTable().get(expr.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ARRAY1DBINSEARCH, var1Instr.result, expr.result,
                ir.getSymbolTable().addTmp(INT32, e -> {
                })));
    }

    @Override
    public void exitFuncArray1DPct(PuffinBasicParser.FuncArray1DPctContext ctx) {
        var var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), true);
        var expr = lookupInstruction(ctx.expr());
        Types.assertNumeric(ir.getSymbolTable().get(expr.result).getType().getAtomTypeId(), () -> getCtxString(ctx));

        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ARRAY1DPCT, var1Instr.result, expr.result,
                ir.getSymbolTable().addTmp(DOUBLE, e -> {
                })));
    }

    @Override
    public void exitFuncArray2DFindRow(PuffinBasicParser.FuncArray2DFindRowContext ctx) {
        var varInstr = getArray2dVariableInstruction(ctx, ctx.variable());
        var x1 = lookupInstruction(ctx.x1);
        var y1 = lookupInstruction(ctx.y1);
        var x2 = lookupInstruction(ctx.x2);
        var y2 = lookupInstruction(ctx.y2);
        var search = lookupInstruction(ctx.search);
        Types.assertIntType(ir.getSymbolTable().get(x1.result).getType().getAtomTypeId(), () -> getCtxString(ctx));
        Types.assertIntType(ir.getSymbolTable().get(y1.result).getType().getAtomTypeId(), () -> getCtxString(ctx));
        Types.assertIntType(ir.getSymbolTable().get(x2.result).getType().getAtomTypeId(), () -> getCtxString(ctx));
        Types.assertIntType(ir.getSymbolTable().get(y2.result).getType().getAtomTypeId(), () -> getCtxString(ctx));
        Types.assertIntType(ir.getSymbolTable().get(search.result).getType().getAtomTypeId(), () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, x1.result, y1.result, NULL_ID);
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, x2.result, y2.result, NULL_ID);
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ARRAY2DFINDROW, varInstr.result, search.result,
                ir.getSymbolTable().addTmp(DOUBLE, e -> {
                })));
    }

    @Override
    public void exitFuncArray2DFindColumn(PuffinBasicParser.FuncArray2DFindColumnContext ctx) {
        var varInstr = getArray2dVariableInstruction(ctx, ctx.variable());
        var x1 = lookupInstruction(ctx.x1);
        var y1 = lookupInstruction(ctx.y1);
        var x2 = lookupInstruction(ctx.x2);
        var y2 = lookupInstruction(ctx.y2);
        var search = lookupInstruction(ctx.search);
        Types.assertIntType(ir.getSymbolTable().get(x1.result).getType().getAtomTypeId(), () -> getCtxString(ctx));
        Types.assertIntType(ir.getSymbolTable().get(y1.result).getType().getAtomTypeId(), () -> getCtxString(ctx));
        Types.assertIntType(ir.getSymbolTable().get(x2.result).getType().getAtomTypeId(), () -> getCtxString(ctx));
        Types.assertIntType(ir.getSymbolTable().get(y2.result).getType().getAtomTypeId(), () -> getCtxString(ctx));
        Types.assertIntType(ir.getSymbolTable().get(search.result).getType().getAtomTypeId(), () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, x1.result, y1.result, NULL_ID);
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, x2.result, y2.result, NULL_ID);
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ARRAY2DFINDCOLUMN, varInstr.result, search.result,
                ir.getSymbolTable().addTmp(DOUBLE, e -> {
                })));
    }

    @Override
    public void exitFuncHsb2Rgb(PuffinBasicParser.FuncHsb2RgbContext ctx) {
        var h = lookupInstruction(ctx.expr(0));
        var s = lookupInstruction(ctx.expr(1));
        var b = lookupInstruction(ctx.expr(2));
        Types.assertNumeric(ir.getSymbolTable().get(h.result).getType().getAtomTypeId(), () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(s.result).getType().getAtomTypeId(), () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(b.result).getType().getAtomTypeId(), () -> getCtxString(ctx));
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, h.result, s.result, NULL_ID);
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.HSB2RGB, b.result, NULL_ID,
                ir.getSymbolTable().addTmp(INT32, e -> {
                })));
    }

    @Override
    public void exitFuncMouseMovedX(PuffinBasicParser.FuncMouseMovedXContext ctx) {
        assertGraphics();
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.MOUSEMOVEDX, NULL_ID, NULL_ID,
                ir.getSymbolTable().addTmp(INT32, e -> {
                })));
    }

    @Override
    public void exitFuncMouseMovedY(PuffinBasicParser.FuncMouseMovedYContext ctx) {
        assertGraphics();
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.MOUSEMOVEDY, NULL_ID, NULL_ID,
                ir.getSymbolTable().addTmp(INT32, e -> {
                })));
    }

    @Override
    public void exitFuncMouseDraggedX(PuffinBasicParser.FuncMouseDraggedXContext ctx) {
        assertGraphics();
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.MOUSEDRAGGEDX, NULL_ID, NULL_ID,
                ir.getSymbolTable().addTmp(INT32, e -> {
                })));
    }

    @Override
    public void exitFuncMouseDraggedY(PuffinBasicParser.FuncMouseDraggedYContext ctx) {
        assertGraphics();
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.MOUSEDRAGGEDY, NULL_ID, NULL_ID,
                ir.getSymbolTable().addTmp(INT32, e -> {
                })));
    }

    @Override
    public void exitFuncMouseButtonClicked(PuffinBasicParser.FuncMouseButtonClickedContext ctx) {
        assertGraphics();
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.MOUSEBUTTONCLICKED, NULL_ID, NULL_ID,
                ir.getSymbolTable().addTmp(INT32, e -> {
                })));
    }

    @Override
    public void exitFuncMouseButtonPressed(PuffinBasicParser.FuncMouseButtonPressedContext ctx) {
        assertGraphics();
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.MOUSEBUTTONPRESSED, NULL_ID, NULL_ID,
                ir.getSymbolTable().addTmp(INT32, e -> {
                })));
    }

    @Override
    public void exitFuncMouseButtonReleased(PuffinBasicParser.FuncMouseButtonReleasedContext ctx) {
        assertGraphics();
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.MOUSEBUTTONRELEASED, NULL_ID, NULL_ID,
                ir.getSymbolTable().addTmp(INT32, e -> {
                })));
    }

    @Override
    public void exitFuncIsKeyPressed(PuffinBasicParser.FuncIsKeyPressedContext ctx) {
        assertGraphics();
        var expr = lookupInstruction(ctx.expr());
        Types.assertString(ir.getSymbolTable().get(expr.result).getType().getAtomTypeId(), () -> getCtxString(ctx));
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ISKEYPRESSED, expr.result, NULL_ID,
                ir.getSymbolTable().addTmp(INT32, e -> {
                })));
    }

    @Override
    public void exitFuncMemberMethodCall(PuffinBasicParser.FuncMemberMethodCallContext ctx) {
        var varInstruction = lookupInstruction(ctx.variable());
        var objectType = ir.getSymbolTable().get(varInstruction.result).getType();
        var funcName = ctx.funcname().getText();
        var returnType = objectType.getFuncCallReturnType(funcName);

        List<PuffinBasicType> paramTypes = new ArrayList<>(ctx.expr().size());
        for (var exprCtx : ctx.expr()) {
            var exprInstruction = lookupInstruction(exprCtx);
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.PARAM1, exprInstruction.result, NULL_ID, NULL_ID
            );
            paramTypes.add(ir.getSymbolTable().get(exprInstruction.result).getType());
        }

        objectType.checkFuncCallArguments(funcName, paramTypes);

        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.MEMBER_FUNC_CALL, varInstruction.result,
                ir.getSymbolTable().addTmp(STRING, e -> e.getValue().setString(funcName)),
                ir.getSymbolTable().addTmp(returnType, e -> {
                })
        ));
    }

    @Override
    public void exitFuncSplitDlr(PuffinBasicParser.FuncSplitDlrContext ctx) {
        var str = lookupInstruction(ctx.expr(0));
        var regex = lookupInstruction(ctx.expr(1));
        Types.assertString(ir.getSymbolTable().get(str.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertString(ir.getSymbolTable().get(regex.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.SPLITDLR, str.result, regex.result,
                ir.getSymbolTable().addTmp(new ArrayType(STRING), c -> {
                })));
    }

    @Override
    public void exitFuncLTrimDlr(PuffinBasicParser.FuncLTrimDlrContext ctx) {
        var str = lookupInstruction(ctx.expr());
        Types.assertString(ir.getSymbolTable().get(str.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LTRIMDLR, str.result, NULL_ID,
                ir.getSymbolTable().addTmp(new ArrayType(STRING), c -> {
                })));
    }

    @Override
    public void exitFuncRTrimDlr(PuffinBasicParser.FuncRTrimDlrContext ctx) {
        var str = lookupInstruction(ctx.expr());
        Types.assertString(ir.getSymbolTable().get(str.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.RTRIMDLR, str.result, NULL_ID,
                ir.getSymbolTable().addTmp(new ArrayType(STRING), c -> {
                })));
    }

    @Override
    public void exitFuncAllocArray(PuffinBasicParser.FuncAllocArrayContext ctx) {
        var elementType = PuffinBasicAtomTypeId.lookup(ctx.varsuffix().getText());

        for (var exprCtx : ctx.expr()) {
            var exprInstr = lookupInstruction(exprCtx);
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.PARAM1, exprInstr.result, NULL_ID, NULL_ID
            );
        }

        nodeToInstruction.put(ctx, ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ALLOCARRAY, NULL_ID, NULL_ID,
                ir.getSymbolTable().addTmp(new ArrayType(elementType), c -> {
                })));
    }

    //
    // Stmt
    //

    private Instruction addFuncWithExprInstruction(
            OpCode opCode, ParserRuleContext parent,
            PuffinBasicParser.ExprContext expr, NumericOrString numericOrString) {
        var exprInstruction = lookupInstruction(expr);
        assertNumericOrString(exprInstruction.result, parent, numericOrString);
        return ir.addInstruction(
                sourceFile, currentLineNumber, parent.start.getStartIndex(), parent.stop.getStopIndex(),
                opCode, exprInstruction.result, NULL_ID,
                ir.getSymbolTable().addTmpCompatibleWith(exprInstruction.result)
        );
    }

    private Instruction addFuncWithExprInstruction(
            OpCode opCode,
            ParserRuleContext parent,
            PuffinBasicParser.ExprContext expr,
            NumericOrString numericOrString,
            int result) {
        var exprInstruction = lookupInstruction(expr);
        assertNumericOrString(exprInstruction.result, parent, numericOrString);
        return ir.addInstruction(
                sourceFile, currentLineNumber, parent.start.getStartIndex(), parent.stop.getStopIndex(),
                opCode, exprInstruction.result, NULL_ID, result
        );
    }

    private void assertNumericOrString(int id, ParserRuleContext parent, NumericOrString numericOrString) {
        var dt = ir.getSymbolTable().get(id).getType().getAtomTypeId();
        if (numericOrString == NumericOrString.NUMERIC) {
            Types.assertNumeric(dt, () -> getCtxString(parent));
        } else {
            Types.assertString(dt, () -> getCtxString(parent));
        }
    }

    @Override
    public void exitListstmt(PuffinBasicParser.ListstmtContext ctx) {
        final PuffinBasicType itemType;
        if (ctx.typename != null) {
            // struct
            var typeName = ctx.typename.VARNAME().getText();
            itemType = ir.getSymbolTable().getStructType(typeName);
        } else if (ctx.dimtypesuffix != null) {
            // array
            var atomType = PuffinBasicAtomTypeId.lookup(ctx.dimtypesuffix.getText());
            itemType = new ArrayType(atomType);
        } else {
            // scalar data type
            var atomType = PuffinBasicAtomTypeId.lookup(ctx.typesuffix.getText());
            itemType = new ScalarType(atomType);
        }
        var instanceName = ctx.listname.VARNAME().getText();

        var variableName = new VariableName(instanceName, null, COMPOSITE);
        var listType = new ListType(itemType);
        var id = ir.getSymbolTable().addCompositeVariable(
                variableName, new STVariable(null, new Variable(variableName, listType)));
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.CREATE_INSTANCE, id, NULL_ID, id
        );
    }

    @Override
    public void exitSetstmt(PuffinBasicParser.SetstmtContext ctx) {
        var atomType = PuffinBasicAtomTypeId.lookup(ctx.typesuffix.getText());
        PuffinBasicType itemType = new ScalarType(atomType);
        var instanceName = ctx.setname.VARNAME().getText();

        var variableName = new VariableName(instanceName, null, COMPOSITE);
        var setType = new SetType(itemType);
        var id = ir.getSymbolTable().addCompositeVariable(
                variableName, new STVariable(null, new Variable(variableName, setType)));
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.CREATE_INSTANCE, id, NULL_ID, id
        );
    }

    @Override
    public void exitDictstmt(PuffinBasicParser.DictstmtContext ctx) {
        var keyAtomType = PuffinBasicAtomTypeId.lookup(ctx.dictk1.getText());
        PuffinBasicType keyType = new ScalarType(keyAtomType);

        final PuffinBasicType valueType;
        if (ctx.dictv1 != null) {
            // struct
            var typeName = ctx.dictv1.VARNAME().getText();
            valueType = ir.getSymbolTable().getStructType(typeName);
        } else {
            // scalar data type
            var atomType = PuffinBasicAtomTypeId.lookup(ctx.dictv2.getText());
            valueType = new ScalarType(atomType);
        }

        var instanceName = ctx.dictname.VARNAME().getText();

        var variableName = new VariableName(instanceName, null, COMPOSITE);
        var dictType = new DictType(keyType, valueType);
        var id = ir.getSymbolTable().addCompositeVariable(
                variableName, new STVariable(null, new Variable(variableName, dictType)));
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.CREATE_INSTANCE, id, NULL_ID, id
        );
    }

    @Override
    public void exitStructinstancestmt(PuffinBasicParser.StructinstancestmtContext ctx) {
        var typeName = ctx.varname(0).VARNAME().getText();
        var instanceName = ctx.varname(1).VARNAME().getText();
        var variableName = new VariableName(instanceName, null, COMPOSITE);
        var type = ir.getSymbolTable().getStructType(typeName);
        var id = ir.getSymbolTable().addCompositeVariable(
                variableName, new STVariable(null, new Variable(variableName, type)));
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.CREATE_INSTANCE, id, NULL_ID, id
        );
    }

    @Override
    public void exitStructstmt(PuffinBasicParser.StructstmtContext ctx) {
        final var typeName = ctx.varname().VARNAME().getText();
        final var struct = new STObjects.StructType(typeName);
        for (var compCtx : ctx.compositetype()) {
            if (compCtx.var1 != null) {
                // scalar
                var scalarVarName = compCtx.var1.VARNAME().getText();
                var scalarAtomTypeId = ir.getSymbolTable().getDataTypeFor(
                        scalarVarName, compCtx.var2 != null ? compCtx.var2.getText() : null);
                //PuffinBasicAtomTypeId.lookup(compCtx.var2.getText());
                var name = new VariableName(scalarVarName,
                        scalarAtomTypeId.getRepr(),
                        scalarAtomTypeId);
                struct.declareField(name, new ScalarType(name.getDataType()));
            } else if (compCtx.DIM() != null) {
                // array
                var arrayName = compCtx.elem.VARNAME().getText();
                var arrayAtomType = ir.getSymbolTable().getDataTypeFor(arrayName,
                        compCtx.elemsuffix != null ? compCtx.elemsuffix.getText() : null);
                IntList dims = new IntArrayList(compCtx.DECIMAL().size());
                for (var dimStrNode : compCtx.DECIMAL()) {
                    dims.add(Numbers.parseInt32(dimStrNode.getText(), () -> getCtxString(ctx)));
                }
                struct.declareField(new VariableName(arrayName, arrayAtomType.getRepr(), arrayAtomType),
                        new ArrayType(arrayAtomType, dims, true));
            } else if (compCtx.LIST() != null) {
                // list
                var name = new VariableName(compCtx.elem.VARNAME().getText(), null, COMPOSITE);
                final PuffinBasicType itemType;
                if (compCtx.list1 != null) {
                    // struct
                    itemType = ir.getSymbolTable().getStructType(compCtx.list1.VARNAME().getText());
                } else {
                    // scalar data type
                    itemType = new ScalarType(PuffinBasicAtomTypeId.lookup(compCtx.list2.getText()));
                }
                struct.declareField(name, new ListType(itemType));
            } else if (compCtx.SET() != null) {
                // set
                var name = new VariableName(compCtx.elem.VARNAME().getText(), null, COMPOSITE);
                struct.declareField(name, new SetType(new ScalarType(PuffinBasicAtomTypeId.lookup(compCtx.set2.getText()))));
            } else if (compCtx.DICT() != null) {
                // dict
                var name = new VariableName(compCtx.elem.VARNAME().getText(), null, COMPOSITE);
                var keyType = new ScalarType(PuffinBasicAtomTypeId.lookup(compCtx.dictk1.getText()));
                final PuffinBasicType valueType;
                if (compCtx.dictv1 != null) {
                    // struct
                    valueType = ir.getSymbolTable().getStructType(compCtx.dictv1.VARNAME().getText());
                } else {
                    // scalar data type
                    valueType = new ScalarType(PuffinBasicAtomTypeId.lookup(compCtx.dictv2.getText()));
                }
                struct.declareField(name, new DictType(keyType, valueType));
            } else if (compCtx.struct1 != null) {
                // struct
                var memberType = compCtx.struct1.VARNAME().getText();
                var name = new VariableName(compCtx.elem.VARNAME().getText(), null, COMPOSITE);
                struct.declareField(name, ir.getSymbolTable().getStructType(memberType));
            } else {
                // throw
                throw new PuffinBasicSemanticError(
                        DATA_TYPE_MISMATCH,
                        getCtxString(ctx),
                        "Bad struct field: " + compCtx.getText()
                );
            }
        }
        ir.getSymbolTable().addStructType(typeName, struct);
    }

    @Override
    public void exitComment(PuffinBasicParser.CommentContext ctx) {
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.COMMENT, NULL_ID, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitLetstmt(PuffinBasicParser.LetstmtContext ctx) {
        var varInstruction = lookupInstruction(ctx.variable());
        var exprInstruction = lookupInstruction(ctx.expr());

        var varType = ir.getSymbolTable().get(varInstruction.result).getType();
        if (varType.getTypeId() == UDF) {
            throw new PuffinBasicSemanticError(
                    BAD_ASSIGNMENT,
                    getCtxString(ctx),
                    "Can't assign to UDF: " + varType
            );
        }
        if (!varType.isCompatibleWith(ir.getSymbolTable().get(exprInstruction.result).getType())) {
            throw new PuffinBasicSemanticError(
                    DATA_TYPE_MISMATCH,
                    getCtxString(ctx),
                    "Data type " + varType
                            + " mismatches with " + ir.getSymbolTable().get(exprInstruction.result).getType()
            );
        }

        var assignInstruction = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ASSIGN, exprInstruction.result, varInstruction.result, varInstruction.result
        );
        nodeToInstruction.put(ctx, assignInstruction);
    }

    @Override
    public void exitAutoletstmt(PuffinBasicParser.AutoletstmtContext ctx) {
        var varname = ctx.varname().getText();
        var exprInstruction = lookupInstruction(ctx.expr());
        var resultType = ir.getSymbolTable().get(exprInstruction.result).getType();
        int varId = ir.getSymbolTable().addVariableOrUDF(
                new VariableName(varname, null, resultType.getAtomTypeId()),
                variableName1 -> new Variable(variableName1, resultType),
                (id, entry, v1) -> {
                });
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.VARREF, exprInstruction.result, varId, NULL_ID
        );
    }

    @Override
    public void exitPrintstmt(PuffinBasicParser.PrintstmtContext ctx) {
        handlePrintstmt(ctx, ctx.printlist().children, null);
    }

    @Override
    public void exitPrinthashstmt(PuffinBasicParser.PrinthashstmtContext ctx) {
        var fileNumber = lookupInstruction(ctx.filenum);
        handlePrintstmt(ctx, ctx.printlist().children, fileNumber);
    }

    private void handlePrintstmt(
            ParserRuleContext ctx,
            List<ParseTree> children,
            @Nullable Instruction fileNumber) {
        boolean endsWithNewline = true;
        for (ParseTree child : children) {
            if (child instanceof PuffinBasicParser.ExprContext) {
                var exprInstruction = lookupInstruction((PuffinBasicParser.ExprContext) child);
                ir.addInstruction(
                        sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                        OpCode.PRINT, exprInstruction.result, NULL_ID, NULL_ID
                );
                endsWithNewline = true;
            } else {
                endsWithNewline = false;
            }
        }

        if (endsWithNewline || fileNumber != null) {
            var newlineId = ir.getSymbolTable().addTmp(STRING,
                    entry -> entry.getValue().setString(System.lineSeparator()));
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.PRINT, newlineId, NULL_ID, NULL_ID
            );
        }

        final int fileNumberId;
        if (fileNumber != null) {
            Types.assertNumeric(ir.getSymbolTable().get(fileNumber.result).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
            fileNumberId = fileNumber.result;
        } else {
            fileNumberId = NULL_ID;
        }
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.FLUSH, fileNumberId, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitPrintusingstmt(PuffinBasicParser.PrintusingstmtContext ctx) {
        handlePrintusing(ctx, ctx.format, ctx.printlist().children, null);
    }

    @Override
    public void exitPrinthashusingstmt(PuffinBasicParser.PrinthashusingstmtContext ctx) {
        var fileNumber = lookupInstruction(ctx.filenum);
        handlePrintusing(ctx, ctx.format, ctx.printlist().children, fileNumber);
    }

    private void handlePrintusing(
            ParserRuleContext ctx,
            PuffinBasicParser.ExprContext formatCtx,
            List<ParseTree> children,
            Instruction fileNumber) {
        var format = lookupInstruction(formatCtx);
        boolean endsWithNewline = true;
        for (ParseTree child : children) {
            if (child instanceof PuffinBasicParser.ExprContext) {
                var exprInstruction = lookupInstruction((PuffinBasicParser.ExprContext) child);
                ir.addInstruction(
                        sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                        OpCode.PRINTUSING, format.result, exprInstruction.result, NULL_ID
                );
                endsWithNewline = true;
            } else {
                endsWithNewline = false;
            }
        }
        if (endsWithNewline || fileNumber != null) {
            var newlineId = ir.getSymbolTable().addTmp(STRING,
                    entry -> entry.getValue().setString(System.lineSeparator()));
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.PRINT, newlineId, NULL_ID, NULL_ID
            );
        }

        final int fileNumberId;
        if (fileNumber != null) {
            Types.assertNumeric(ir.getSymbolTable().get(fileNumber.result).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
            fileNumberId = fileNumber.result;
        } else {
            fileNumberId = NULL_ID;
        }

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.FLUSH, fileNumberId, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitDimstmt(PuffinBasicParser.DimstmtContext ctx) {
        IntList dims = new IntArrayList(ctx.expr().size());
        for (int i = 0; i < ctx.expr().size(); i++) {
            dims.add(0);
        }

        var variableName = getVariableNameFromCtx(ctx.varname(), ctx.varsuffix());
        var varId = ir.getSymbolTable().addVariableOrUDF(
                variableName,
                variableName1 -> new Variable(variableName1, new ArrayType(variableName1.getDataType(), dims, true)),
                (id, entry, v1) -> entry.getValue().setArrayDimensions(dims));

        for (var expr : ctx.expr()) {
            var dimi = lookupInstruction(expr);
            Types.assertNumeric(ir.getSymbolTable().get(dimi.result).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.PARAM1, dimi.result, NULL_ID, NULL_ID
            );
        }
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.DIM, varId, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitReallocstmt(PuffinBasicParser.ReallocstmtContext ctx) {
        IntList dims = new IntArrayList(ctx.expr().size());
        for (int i = 0; i < ctx.expr().size(); i++) {
            dims.add(0);
        }

        var variableName = getVariableNameFromCtx(ctx.varname(), ctx.varsuffix());
        var varId = ir.getSymbolTable().addVariableOrUDF(
                variableName,
                variableName1 -> new Variable(variableName1, new ArrayType(variableName1.getDataType(), dims, true)),
                (id, entry, v1) -> entry.getValue().setArrayDimensions(dims));

        for (var expr : ctx.expr()) {
            var dimi = lookupInstruction(expr);
            Types.assertNumeric(ir.getSymbolTable().get(dimi.result).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.PARAM1, dimi.result, NULL_ID, NULL_ID
            );
        }
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.REALLOCARRAY, varId, NULL_ID, NULL_ID
        );
    }

    @Override
    public void enterDeffnstmt(PuffinBasicParser.DeffnstmtContext ctx) {
        var variableName = getVariableNameFromCtx(ctx.varname(), ctx.varsuffix());

        ir.getSymbolTable().addVariableOrUDF(variableName,
                variableName1 -> Variable.of(variableName1, VariableKindHint.DERIVE_FROM_NAME, () -> getCtxString(ctx)),
                (varId, varEntry, variable) -> {
                    var udfState = new UDFState(variableName, (STUDF) varEntry);
                    udfStateMap.put(variable, udfState);

                    // GOTO postFuncDecl
                    udfState.gotoPostFuncDecl = ir.addInstruction(
                            sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                            OpCode.GOTO_LABEL,
                            ir.getSymbolTable().addGotoTarget(),
                            NULL_ID, NULL_ID
                    );
                    // LABEL FuncStart
                    udfState.labelFuncStart = ir.addInstruction(
                            sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                            OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
                    );
                    // Push child scope
                    ir.getSymbolTable().pushDeclarationScope(varId, false);
                });
    }

    @Override
    public void exitDeffnstmt(PuffinBasicParser.DeffnstmtContext ctx) {
        var variableName = getVariableNameFromCtx(ctx.varname(), ctx.varsuffix());

        ir.getSymbolTable().addVariableOrUDF(variableName,
                variableName1 -> Variable.of(variableName1, VariableKindHint.DERIVE_FROM_NAME, () -> getCtxString(ctx)),
                (varId, varEntry, variable) -> {
                    var udfEntry = (STUDF) varEntry;
                    var udfState = udfStateMap.get(variable);
                    for (VariableContext fnParamCtx : ctx.variable()) {
                        var fnParamInstr = lookupInstruction(fnParamCtx);
                        udfEntry.declareParam(fnParamInstr.result);
                    }

                    var exprInstr = lookupInstruction(ctx.expr());
                    checkDataTypeMatch(varId, exprInstr.result, () -> getCtxString(ctx));

                    // Copy expr to result
                    ir.addInstruction(
                            sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                            OpCode.COPY, exprInstr.result, varId, varId
                    );
                    // Pop declaration scope
                    ir.getSymbolTable().popScope();
                    // GOTO Caller
                    ir.addInstruction(
                            sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                            OpCode.GOTO_CALLER, NULL_ID, NULL_ID, NULL_ID
                    );
                    // LABEL postFuncDecl
                    var labelPostFuncDecl = ir.addInstruction(
                            sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                            OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
                    );
                    // Patch GOTO postFuncDecl
                    udfState.gotoPostFuncDecl.patchOp1(labelPostFuncDecl.op1);
                });
    }

    private VariableName getVariableNameFromCtx(
            PuffinBasicParser.VarnameContext varnameCtx,
            PuffinBasicParser.VarsuffixContext varsuffixCtx) {
        var varname = varnameCtx.getText();
        var varsuffix = varsuffixCtx != null ? varsuffixCtx.getText() : null;
        var dataType = ir.getSymbolTable().getDataTypeFor(varname, varsuffix);
        return new VariableName(varname, dataType.getRepr(), dataType);
    }

    @Override
    public void enterFunctionbeginstmt(PuffinBasicParser.FunctionbeginstmtContext ctx) {
        var variableName = getVariableNameFromCtx(ctx.varname(), ctx.varsuffix());

        var udfId = ir.getSymbolTable().addVariableOrUDF(variableName,
                variableName1 -> Variable.of(variableName1, VariableKindHint.UDF, () -> getCtxString(ctx)),
                (varId, varEntry, variable) -> {
                    if (currentUdfState != null) {
                        throw new PuffinBasicSemanticError(
                                BAD_FUNCTION_DEF,
                                getCtxString(ctx),
                                "Function " + variableName + " defined in another function: "
                                        + currentUdfState.variableName
                        );
                    }
                    currentUdfState = new UDFState(variableName, (STUDF) varEntry);
                    udfStateMap.put(variable, currentUdfState);

                    // GOTO postFuncDecl
                    currentUdfState.gotoPostFuncDecl = ir.addInstruction(
                            sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                            OpCode.GOTO_LABEL,
                            ir.getSymbolTable().addGotoTarget(),
                            NULL_ID, NULL_ID
                    );
                    // LABEL FuncStart
                    currentUdfState.labelFuncStart = ir.addInstruction(
                            sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                            OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
                    );
                    // Push child scope
                    ir.getSymbolTable().pushDeclarationScope(varId, true);
                });
        currentUdfState.udfId = udfId;
    }

    @Override
    public void exitFunctionbeginstmt(PuffinBasicParser.FunctionbeginstmtContext ctx) {
        if (currentUdfState == null) {
            throw new PuffinBasicInternalError("CurrentUDFState not set!");
        }
        for (var compCtx : ctx.compositetype()) {
            VariableName paramName;
            PuffinBasicType paramType;
            if (compCtx.var1 != null) {
                // scalar
                var scalarVarName = compCtx.var1.VARNAME().getText();
                var scalarAtomTypeId = ir.getSymbolTable().getDataTypeFor(
                        scalarVarName, compCtx.var2 != null ? compCtx.var2.getText() : null);
                //PuffinBasicAtomTypeId.lookup(compCtx.var2.getText());
                paramName = new VariableName(scalarVarName,
                        scalarAtomTypeId.getRepr(),
                        scalarAtomTypeId);
                paramType = new ScalarType(paramName.getDataType());
            } else if (compCtx.LIST() != null) {
                // list
                paramName = new VariableName(compCtx.elem.VARNAME().getText(), null, COMPOSITE);
                final PuffinBasicType itemType;
                if (compCtx.list1 != null) {
                    // struct
                    itemType = ir.getSymbolTable().getStructType(compCtx.list1.VARNAME().getText());
                } else if (compCtx.list3 != null) {
                    // array
                    var atomType = PuffinBasicAtomTypeId.lookup(compCtx.list3.getText());
                    itemType = new ArrayType(atomType);
                } else {
                    // scalar data type
                    itemType = new ScalarType(PuffinBasicAtomTypeId.lookup(compCtx.list2.getText()));
                }
                paramType = new ListType(itemType);
            } else if (compCtx.SET() != null) {
                // set
                paramName = new VariableName(compCtx.elem.VARNAME().getText(), null, COMPOSITE);
                paramType = new SetType(new ScalarType(PuffinBasicAtomTypeId.lookup(compCtx.set2.getText())));
            } else if (compCtx.DICT() != null) {
                // dict
                paramName = new VariableName(compCtx.elem.VARNAME().getText(), null, COMPOSITE);
                var keyType = new ScalarType(PuffinBasicAtomTypeId.lookup(compCtx.dictk1.getText()));
                final PuffinBasicType valueType;
                if (compCtx.dictv1 != null) {
                    // struct
                    valueType = ir.getSymbolTable().getStructType(compCtx.dictv1.VARNAME().getText());
                } else {
                    // scalar data type
                    valueType = new ScalarType(PuffinBasicAtomTypeId.lookup(compCtx.dictv2.getText()));
                }
                paramType = new DictType(keyType, valueType);
            } else if (compCtx.struct1 != null) {
                // struct
                var memberType = compCtx.struct1.VARNAME().getText();
                paramName = new VariableName(compCtx.elem.VARNAME().getText(), null, COMPOSITE);
                paramType = ir.getSymbolTable().getStructType(memberType);
            } else if (compCtx.DIM() != null) {
                // array
                var arrayName = compCtx.elem.VARNAME().getText();
                var arrayAtomType = ir.getSymbolTable().getDataTypeFor(arrayName,
                        compCtx.elemsuffix != null ? compCtx.elemsuffix.getText() : null);
                IntList dims = new IntArrayList(compCtx.DECIMAL().size());
                for (var dimStrNode : compCtx.DECIMAL()) {
                    dims.add(Numbers.parseInt32(dimStrNode.getText(), () -> getCtxString(ctx)));
                }
                paramName = new VariableName(arrayName, arrayAtomType.getRepr(), arrayAtomType);
                paramType = new ArrayType(arrayAtomType, dims, true);
            } else {
                // throw
                throw new PuffinBasicSemanticError(
                        DATA_TYPE_MISMATCH,
                        getCtxString(ctx),
                        "Bad struct field: " + compCtx.getText()
                );
            }

            var paramId = ir.getSymbolTable().addVariableOrUDF(
                    paramName,
                    variableName1 -> new Variable(variableName1, paramType),
                    (varId, varEntry, variable) -> {
                    }
            );
            currentUdfState.udfEntry.declareParam(paramId);
        }
    }

    @Override
    public void exitFunctionreturnstmt(PuffinBasicParser.FunctionreturnstmtContext ctx) {
        if (currentUdfState == null) {
            throw new PuffinBasicSemanticError(
                    BAD_FUNCTION_DEF,
                    getCtxString(ctx),
                    "Function return called without function begin!"
            );
        }
        var udfId = currentUdfState.udfId;

        var returnInstr = lookupInstruction(ctx.expr());
        checkDataTypeMatch(udfId, returnInstr.result, () -> getCtxString(ctx));

        // Copy expr to result
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.COPY, returnInstr.result, udfId, udfId
        );

        // GOTO LABEL gotoCaller
        currentUdfState.gotoLabelGotoCaller.add(ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GOTO_LABEL,
                ir.getSymbolTable().addGotoTarget(),
                NULL_ID, NULL_ID
        ));
    }

    @Override
    public void exitFunctionendstmt(PuffinBasicParser.FunctionendstmtContext ctx) {
        if (currentUdfState == null) {
            throw new PuffinBasicSemanticError(
                    BAD_FUNCTION_DEF,
                    getCtxString(ctx),
                    "Function return called without function begin!"
            );
        }
        // Pop declaration scope
        ir.getSymbolTable().popScope();
        // LABEL gotoCaller
        var labelGotocaller = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
        );
        // GOTO Caller
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GOTO_CALLER, NULL_ID, NULL_ID, NULL_ID
        );
        // LABEL postFuncDecl
        var labelPostFuncDecl = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
        );
        // Patch GOTO LABEL gotoCaller
        currentUdfState.gotoLabelGotoCaller.forEach(g -> g.patchOp1(labelGotocaller.op1));
        // Patch GOTO postFuncDecl
        currentUdfState.gotoPostFuncDecl.patchOp1(labelPostFuncDecl.op1);
        // Unset current UDF state
        currentUdfState = null;
    }

    @Override
    public void exitImportstmt(PuffinBasicParser.ImportstmtContext ctx) {

    }

    @Override
    public void exitEndstmt(PuffinBasicParser.EndstmtContext ctx) {
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.END, NULL_ID, NULL_ID, NULL_ID
        );
    }

    @Override
    public void enterWhilestmt(PuffinBasicParser.WhilestmtContext ctx) {
        var whileLoopState = new WhileLoopState();
        // LABEL beforeWhile
        whileLoopState.labelBeforeWhile = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
        );
        whileLoopStateList.add(whileLoopState);
    }

    @Override
    public void exitWhilestmt(PuffinBasicParser.WhilestmtContext ctx) {
        var whileLoopState = whileLoopStateList.getLast();

        // expr()
        var expr = lookupInstruction(ctx.expr());

        // NOT expr()
        var notExpr = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.NOT, expr.result, NULL_ID, ir.getSymbolTable().addTmp(INT64, e -> {
                })
        );

        // If expr is false, GOTO afterWend
        whileLoopState.gotoAfterWend = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GOTO_LABEL_IF, notExpr.result, ir.getSymbolTable().addLabel(), NULL_ID
        );
    }

    @Override
    public void exitWendstmt(PuffinBasicParser.WendstmtContext ctx) {
        if (whileLoopStateList.isEmpty()) {
            throw new PuffinBasicSemanticError(
                    PuffinBasicSemanticError.ErrorCode.WEND_WITHOUT_WHILE,
                    getCtxString(ctx),
                    "Wend without while");
        }
        var whileLoopState = whileLoopStateList.removeLast();
        // GOTO LABEL beforeWhile
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GOTO_LABEL, whileLoopState.labelBeforeWhile.op1, NULL_ID, NULL_ID);
        // LABEL afterWend
        var labelAfterWend = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
        );
        // Patch GOTO afterWend
        whileLoopState.gotoAfterWend.patchOp2(labelAfterWend.op1);
    }

    @NotNull
    private PuffinBasicIR.OpCode getLTOpCode(PuffinBasicAtomTypeId dt1, PuffinBasicAtomTypeId dt2) {
        final OpCode opCode;
        if (dt1 == STRING && dt2 == STRING) {
            opCode = OpCode.LTSTR;
        } else {
            if (dt1 == DOUBLE || dt2 == DOUBLE) {
                opCode = OpCode.LTF64;
            } else if (dt1 == INT64 || dt2 == INT64) {
                opCode = OpCode.LTI64;
            } else if (dt1 == FLOAT || dt2 == FLOAT) {
                opCode = OpCode.LTF32;
            } else {
                opCode = OpCode.LTI32;
            }
        }
        return opCode;
    }

    @NotNull
    private PuffinBasicIR.OpCode getGTOpCode(PuffinBasicAtomTypeId dt1, PuffinBasicAtomTypeId dt2) {
        final OpCode opCode;
        if (dt1 == STRING && dt2 == STRING) {
            opCode = OpCode.GTSTR;
        } else {
            if (dt1 == DOUBLE || dt2 == DOUBLE) {
                opCode = OpCode.GTF64;
            } else if (dt1 == INT64 || dt2 == INT64) {
                opCode = OpCode.GTI64;
            } else if (dt1 == FLOAT || dt2 == FLOAT) {
                opCode = OpCode.GTF32;
            } else {
                opCode = OpCode.GTI32;
            }
        }
        return opCode;
    }

    @NotNull
    private PuffinBasicIR.OpCode getGEOpCode(PuffinBasicAtomTypeId dt1, PuffinBasicAtomTypeId dt2) {
        final OpCode opCode;
        if (dt1 == STRING && dt2 == STRING) {
            opCode = OpCode.GESTR;
        } else {
            if (dt1 == DOUBLE || dt2 == DOUBLE) {
                opCode = OpCode.GEF64;
            } else if (dt1 == INT64 || dt2 == INT64) {
                opCode = OpCode.GEI64;
            } else if (dt1 == FLOAT || dt2 == FLOAT) {
                opCode = OpCode.GEF32;
            } else {
                opCode = OpCode.GEI32;
            }
        }
        return opCode;
    }

    @Override
    public void exitForstmt(PuffinBasicParser.ForstmtContext ctx) {
        var varInstr = lookupInstruction(ctx.variable());
        var init = lookupInstruction(ctx.expr(0));
        var end = lookupInstruction(ctx.expr(1));
        Types.assertNumeric(ir.getSymbolTable().get(init.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(end.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));

        var forLoopState = new ForLoopState();
        var stVariable = (STVariable) ir.getSymbolTable().get(varInstr.result);
        forLoopState.variable = stVariable.getVariable();

        // stepCopy = step or 1 (default)
        Instruction stepCopy;
        if (ctx.expr(2) != null) {
            var step = lookupInstruction(ctx.expr(2));
            Types.assertNumeric(ir.getSymbolTable().get(step.result).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
            var tmpStep = ir.getSymbolTable().addTmpCompatibleWith(step.result);
            stepCopy = ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.COPY, step.result, tmpStep, tmpStep
            );
        } else {
            var tmpStep = ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(1));
            stepCopy = ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.VALUE, tmpStep, NULL_ID, tmpStep
            );
        }
        // var=init
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ASSIGN, init.result, varInstr.result, varInstr.result
        );
        // endCopy=end
        var tmpEnd = ir.getSymbolTable().addTmpCompatibleWith(end.result);
        var endCopy = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ASSIGN, end.result, tmpEnd, tmpEnd
        );

        // GOTO LABEL CHECK
        var gotoLabelCheck = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GOTO_LABEL, ir.getSymbolTable().addGotoTarget(), NULL_ID, NULL_ID
        );

        // APPLY STEP
        // JUMP here from NEXT
        forLoopState.labelApplyStep = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
        );

        // Add step
        var tmpAdd = ir.getSymbolTable().addTmpCompatibleWith(varInstr.result);
        final OpCode addOpCode;
        switch (stVariable.getType().getAtomTypeId()) {
            case INT32:
                addOpCode = OpCode.ADDI32;
                break;
            case INT64:
                addOpCode = OpCode.ADDI64;
                break;
            case FLOAT:
                addOpCode = OpCode.ADDF32;
                break;
            case DOUBLE:
                addOpCode = OpCode.ADDF64;
                break;
            default:
                throw new PuffinBasicInternalError("Bad type: " + stVariable.getType().getAtomTypeId());
        }
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                addOpCode, varInstr.result, stepCopy.result, tmpAdd
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ASSIGN, tmpAdd, varInstr.result, varInstr.result
        );

        // CHECK
        // If (step >= 0 and var > end) or (step < 0 and var < end) GOTO after "next"
        // step >= 0
        var labelCheck = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
        );
        var zero = ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(0));
        var t1 = ir.getSymbolTable().addTmp(INT32, e -> {
        });
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                getGEOpCode(ir.getSymbolTable().get(stepCopy.result).getType().getAtomTypeId(), INT32),
                stepCopy.result, zero, t1
        );
        // Patch GOTO LABEL Check
        gotoLabelCheck.patchOp1(labelCheck.op1);
        // var > end
        var t2 = ir.getSymbolTable().addTmp(INT32, e -> {
        });
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                getGTOpCode(ir.getSymbolTable().get(varInstr.result).getType().getAtomTypeId(),
                        ir.getSymbolTable().get(endCopy.result).getType().getAtomTypeId()),
                varInstr.result, endCopy.result, t2
        );
        // (step >= 0 and var > end)
        var t3 = ir.getSymbolTable().addTmp(INT32, e -> {
        });
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.AND, t1, t2, t3
        );
        // step < 0
        var t4 = ir.getSymbolTable().addTmp(INT32, e -> {
        });
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                getLTOpCode(ir.getSymbolTable().get(stepCopy.result).getType().getAtomTypeId(), INT32),
                stepCopy.result, zero, t4
        );
        // var < end
        var t5 = ir.getSymbolTable().addTmp(INT32, e -> {
        });
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                getLTOpCode(ir.getSymbolTable().get(varInstr.result).getType().getAtomTypeId(),
                        ir.getSymbolTable().get(endCopy.result).getType().getAtomTypeId()),
                varInstr.result, endCopy.result, t5
        );
        // (step < 0 and var < end)
        var t6 = ir.getSymbolTable().addTmp(INT32, e -> {
        });
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.AND, t4, t5, t6
        );
        var t7 = ir.getSymbolTable().addTmp(INT32, e -> {
        });
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.OR, t3, t6, t7
        );
        // if (true) GOTO after NEXT
        // set linenumber on exitNext().
        forLoopState.gotoAfterNext = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GOTO_LABEL_IF, t7, ir.getSymbolTable().addLabel(), NULL_ID
        );

        forLoopStateList.add(forLoopState);
    }

    @Override
    public void exitNextstmt(PuffinBasicParser.NextstmtContext ctx) {
        List<ForLoopState> states = new ArrayList<>(1);
        if (ctx.variable().isEmpty()) {
            if (!forLoopStateList.isEmpty()) {
                states.add(forLoopStateList.removeLast());
            } else {
                throw new PuffinBasicSemanticError(
                        NEXT_WITHOUT_FOR,
                        getCtxString(ctx),
                        "NEXT without FOR"
                );
            }
        } else {
            for (var varCtx : ctx.variable()) {
                if (varCtx.leafvariable() == null) {
                    throw new PuffinBasicSemanticError(
                            BAD_ARGUMENT,
                            getCtxString(ctx),
                            "Bad variable!"
                    );
                }
                var varname = varCtx.leafvariable().varname().VARNAME().getText();
                var varsuffix = varCtx.leafvariable().varsuffix() != null
                        ? varCtx.leafvariable().varsuffix().getText() : null;
                var dataType = ir.getSymbolTable().getDataTypeFor(varname, varsuffix);
                var variableName = new VariableName(varname, dataType.getRepr(), dataType);

                int id = ir.getSymbolTable().addVariableOrUDF(
                        variableName,
                        variableName1 -> Variable.of(variableName1, VariableKindHint.DERIVE_FROM_NAME, () -> getCtxString(ctx)),
                        (id1, e1, v1) -> {
                        });
                var variable = ((STVariable) ir.getSymbolTable().get(id)).getVariable();

                if (forLoopStateList.isEmpty()) {
                    throw new PuffinBasicSemanticError(
                            NEXT_WITHOUT_FOR,
                            getCtxString(ctx),
                            "NEXT without FOR"
                    );
                }

                var state = forLoopStateList.removeLast();
                if (state.variable.equals(variable)) {
                    states.add(state);
                } else {
                    throw new PuffinBasicSemanticError(
                            NEXT_WITHOUT_FOR,
                            getCtxString(ctx),
                            "Next " + variable + " without FOR"
                    );
                }
            }
        }

        for (ForLoopState state : states) {
            // GOTO APPLY STEP
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.GOTO_LABEL, state.labelApplyStep.op1, NULL_ID, NULL_ID
            );

            // LABEL afterNext
            var labelAfterNext = ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
            );
            state.gotoAfterNext.patchOp2(labelAfterNext.op1);
        }
    }

    /*
     * condition
     * GOTOIF condition labelBeforeThen
     * GOTO labelAfterThen|labelBeforeElse
     * labelBeforeThen
     * ThenStmts
     * GOTO labelAfterThen|labelAfterElse
     * labelAfterThen
     * ElseStmts
     * labelAfterElse
     */
    @Override
    public void enterIfThenElse(PuffinBasicParser.IfThenElseContext ctx) {
        nodeToIfState.put(ctx, new IfState());
    }

    @Override
    public void exitIfThenElse(PuffinBasicParser.IfThenElseContext ctx) {
        var ifState = nodeToIfState.get(ctx);
        boolean noElseStmt = ifState.labelBeforeElse == null;

        var condition = lookupInstruction(ctx.expr());
        // Patch IF true: condition
        ifState.gotoIfConditionTrue.patchOp1(condition.result);
        // Patch IF true: GOTO labelBeforeThen
        ifState.gotoIfConditionTrue.patchOp2(ifState.labelBeforeThen.op1);
        // Patch IF false: GOTO labelAfterThen|labelBeforeElse
        ifState.gotoIfConditionFalse.patchOp1(
                noElseStmt ? ifState.labelAfterThen.op1 : ifState.labelBeforeElse.op1
        );
        // Patch THEN: GOTO labelAfterThen|labelAfterElse
        ifState.gotoFromThenAfterIf.patchOp1(
                noElseStmt ? ifState.labelAfterThen.op1 : ifState.labelAfterElse.op1
        );
    }

    @Override
    public void enterThen(PuffinBasicParser.ThenContext ctx) {
        var ifState = nodeToIfState.get(ctx.getParent());
        // IF condition is true, GOTO labelBeforeThen
        ifState.gotoIfConditionTrue = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GOTO_LABEL_IF, ir.getSymbolTable().addGotoTarget(), NULL_ID, NULL_ID
        );
        // IF condition is false, GOTO labelAfterThen|labelBeforeElse
        ifState.gotoIfConditionFalse = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GOTO_LABEL, ir.getSymbolTable().addGotoTarget(), NULL_ID, NULL_ID
        );
        ifState.labelBeforeThen = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
        );
    }

    //
    // IF expr THEN BEGIN
    // ...
    // ELSE BEGIN
    // ...
    // END IF
    //

    @Override
    public void exitThen(PuffinBasicParser.ThenContext ctx) {
        // Add instruction for:
        // THEN GOTO linenum | THEN linenum
        if (ctx.linenum() != null) {
            var gotoLinenum = parseLinenum(ctx.linenum().getText());
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.GOTO_LINENUM, getGotoLineNumberOp1(gotoLinenum), NULL_ID, NULL_ID
            );
        }

        var ifState = nodeToIfState.get(ctx.getParent());
        // GOTO labelAfterThen|labelAfterElse
        ifState.gotoFromThenAfterIf = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GOTO_LABEL, ir.getSymbolTable().addLabel(),
                NULL_ID, NULL_ID
        );
        ifState.labelAfterThen = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
        );
    }

    //
    // expr.result
    // GOTO labelBeforeThen IF expr.result is true
    // GOTO labelAfterThen|labelBeforeElse
    // labelBeforeThen (patch GOTOIF)
    // GOTO labelAfterThen|labelAfterElse (else begin)
    // labelAfterThen
    // labelBeforeElse
    //

    @Override
    public void enterElsestmt(PuffinBasicParser.ElsestmtContext ctx) {
        var ifState = nodeToIfState.get(ctx.getParent());
        ifState.labelBeforeElse = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitElsestmt(PuffinBasicParser.ElsestmtContext ctx) {
        // Add instruction for:
        // ELSE linenum
        if (ctx.linenum() != null) {
            var gotoLinenum = parseLinenum(ctx.linenum().getText());
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.GOTO_LINENUM, getGotoLineNumberOp1(gotoLinenum), NULL_ID, NULL_ID
            );
        }
        var ifState = nodeToIfState.get(ctx.getParent());
        ifState.labelAfterElse = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
        );
    }

    @Override
    public void enterIfthenbeginstmt(PuffinBasicParser.IfthenbeginstmtContext ctx) {
        var ifState = new IfState();
        nodeToIfState.put(ctx, ifState);
        ifStateList.add(ifState);
    }

    @Override
    public void exitIfthenbeginstmt(PuffinBasicParser.IfthenbeginstmtContext ctx) {
        var ifState = nodeToIfState.get(ctx);
        var condition = lookupInstruction(ctx.expr());

        // IF condition is true, GOTO labelBeforeThen
        ifState.gotoIfConditionTrue = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GOTO_LABEL_IF, condition.result, ir.getSymbolTable().addLabel(), NULL_ID
        );
        // IF condition is false, GOTO labelAfterThen|labelBeforeElse
        ifState.gotoIfConditionFalse = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GOTO_LABEL, ir.getSymbolTable().addGotoTarget(), NULL_ID, NULL_ID
        );
        // Add labelBeforeThen
        ifState.labelBeforeThen = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
        );
        // Patch IF true: GOTO labelBeforeThen
        ifState.gotoIfConditionTrue.patchOp2(ifState.labelBeforeThen.op1);
    }

    @Override
    public void enterElsebeginstmt(PuffinBasicParser.ElsebeginstmtContext ctx) {
        if (ifStateList.isEmpty()) {
            throw new PuffinBasicSemanticError(
                    MISMATCHED_ELSE_BEGIN,
                    getCtxString(ctx),
                    "ELSE BEGIN without IF THEN BEGIN"
            );
        }
        var ifState = ifStateList.getLast();
        // GOTO labelAfterThen|labelAfterElse
        ifState.gotoFromThenAfterIf = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GOTO_LABEL, ir.getSymbolTable().addLabel(),
                NULL_ID, NULL_ID
        );
        ifState.labelAfterThen = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
        );
        ifState.labelBeforeElse = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitEndifstmt(PuffinBasicParser.EndifstmtContext ctx) {
        if (ifStateList.isEmpty()) {
            throw new PuffinBasicSemanticError(
                    MISMATCHED_ENDIF,
                    getCtxString(ctx),
                    "ENDIF without IF THEN BEGIN"
            );
        }
        var ifState = ifStateList.removeLast();
        boolean noElseStmt = ifState.labelBeforeElse == null;

        if (noElseStmt) {
            // GOTO labelAfterThen|labelAfterElse
            ifState.gotoFromThenAfterIf = ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.GOTO_LABEL, ir.getSymbolTable().addLabel(),
                    NULL_ID, NULL_ID
            );
            ifState.labelAfterThen = ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
            );
        }

        // Add labelAfterElse
        ifState.labelAfterElse = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
        );
        // Patch IF true: GOTO labelBeforeThen
        ifState.gotoIfConditionTrue.patchOp2(ifState.labelBeforeThen.op1);
        // Patch IF false: GOTO labelAfterThen|labelBeforeElse
        ifState.gotoIfConditionFalse.patchOp1(
                noElseStmt ? ifState.labelAfterThen.op1 : ifState.labelBeforeElse.op1
        );
        // Patch THEN: GOTO labelAfterThen|labelAfterElse
        ifState.gotoFromThenAfterIf.patchOp1(
                noElseStmt ? ifState.labelAfterThen.op1 : ifState.labelAfterElse.op1
        );
    }

    @Override
    public void exitGosubstmt(PuffinBasicParser.GosubstmtContext ctx) {
        var gotoLinenum = parseLinenum(ctx.linenum().getText());
        var pushReturnLabel = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PUSH_RETLABEL, ir.getSymbolTable().addGotoTarget(), NULL_ID, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GOTO_LINENUM, getGotoLineNumberOp1(gotoLinenum), NULL_ID, NULL_ID
        );
        var labelReturn = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
        );
        pushReturnLabel.patchOp1(labelReturn.op1);
    }

    @Override
    public void exitGosublabelstmt(PuffinBasicParser.GosublabelstmtContext ctx) {
        var gotoLabel = ir.getSymbolTable().addLabel(ctx.string().STRING().getText());
        var pushReturnLabel = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PUSH_RETLABEL, ir.getSymbolTable().addGotoTarget(), NULL_ID, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GOTO_LABEL, gotoLabel, NULL_ID, NULL_ID
        );
        var labelReturn = ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LABEL, ir.getSymbolTable().addLabel(), NULL_ID, NULL_ID
        );
        pushReturnLabel.patchOp1(labelReturn.op1);
    }

    @Override
    public void exitReturnstmt(PuffinBasicParser.ReturnstmtContext ctx) {
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.RETURN, NULL_ID, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitGotostmt(PuffinBasicParser.GotostmtContext ctx) {
        var gotoLinenum = parseLinenum(ctx.linenum().getText());
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GOTO_LINENUM, getGotoLineNumberOp1(gotoLinenum), NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitGotolabelstmt(PuffinBasicParser.GotolabelstmtContext ctx) {
        var gotoLabel = ir.getSymbolTable().addLabel(ctx.string().STRING().getText());
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GOTO_LABEL, gotoLabel, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitSwapstmt(PuffinBasicParser.SwapstmtContext ctx) {
        var var1 = lookupInstruction(ctx.variable(0));
        var var2 = lookupInstruction(ctx.variable(1));
        var dt1 = ir.getSymbolTable().get(var1.result).getType().getAtomTypeId();
        var dt2 = ir.getSymbolTable().get(var2.result).getType().getAtomTypeId();
        if (dt1 != dt2) {
            throw new PuffinBasicSemanticError(
                    DATA_TYPE_MISMATCH,
                    getCtxString(ctx),
                    dt1 + " doesn't match " + dt2
            );
        }
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.SWAP, var1.result, var2.result, NULL_ID
        );
    }

    @Override
    public void exitOpen1stmt(PuffinBasicParser.Open1stmtContext ctx) {
        var filenameInstr = lookupInstruction(ctx.filename);
        var fileOpenMode = getFileOpenMode(ctx.filemode1());
        var accessMode = getFileAccessMode(null);
        var lockMode = getLockMode(null);
        var fileNumber = Numbers.parseInt32(ctx.filenum.getText(), () -> getCtxString(ctx));
        var recordLenInstrId = ctx.reclen != null
                ? lookupInstruction(ctx.reclen).result
                : ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(DEFAULT_RECORD_LEN));

        Types.assertString(ir.getSymbolTable().get(filenameInstr.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(recordLenInstrId).getType().getAtomTypeId(),
                () -> getCtxString(ctx));

        // fileName, fileNumber
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2,
                filenameInstr.result,
                ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(fileNumber)),
                NULL_ID
        );
        // openMode, accessMode
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2,
                ir.getSymbolTable().addTmp(STRING, e -> e.getValue().setString(fileOpenMode.name())),
                ir.getSymbolTable().addTmp(STRING, e -> e.getValue().setString(accessMode.name())),
                NULL_ID
        );
        // lockMode, recordLen
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.OPEN,
                ir.getSymbolTable().addTmp(STRING, e -> e.getValue().setString(lockMode.name())),
                recordLenInstrId,
                NULL_ID
        );
    }

    @Override
    public void exitOpen2stmt(PuffinBasicParser.Open2stmtContext ctx) {
        var filenameInstr = lookupInstruction(ctx.filename);
        var fileOpenMode = getFileOpenMode(ctx.filemode2());
        var accessMode = getFileAccessMode(ctx.access());
        var lockMode = getLockMode(ctx.lock());
        var fileNumber = Numbers.parseInt32(ctx.filenum.getText(), () -> getCtxString(ctx));
        var recordLenInstrId = ctx.reclen != null
                ? lookupInstruction(ctx.reclen).result
                : ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(DEFAULT_RECORD_LEN));

        Types.assertString(ir.getSymbolTable().get(filenameInstr.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(recordLenInstrId).getType().getAtomTypeId(),
                () -> getCtxString(ctx));

        // fileName, fileNumber
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2,
                filenameInstr.result,
                ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(fileNumber)),
                NULL_ID
        );
        // openMode, accessMode
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2,
                ir.getSymbolTable().addTmp(STRING, e -> e.getValue().setString(fileOpenMode.name())),
                ir.getSymbolTable().addTmp(STRING, e -> e.getValue().setString(accessMode.name())),
                NULL_ID
        );
        // lockMode, recordLen
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.OPEN,
                ir.getSymbolTable().addTmp(STRING, e -> e.getValue().setString(lockMode.name())),
                recordLenInstrId,
                NULL_ID
        );
    }

    @Override
    public void exitClosestmt(PuffinBasicParser.ClosestmtContext ctx) {
        var fileNumbers = ctx.DECIMAL().stream().map(
                fileNumberCtx -> Numbers.parseInt32(fileNumberCtx.getText(), () -> getCtxString(ctx))
        ).collect(Collectors.toList());
        if (fileNumbers.isEmpty()) {
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.CLOSE_ALL,
                    NULL_ID,
                    NULL_ID,
                    NULL_ID
            );
        } else {
            fileNumbers.forEach(fileNumber ->
                    ir.addInstruction(
                            sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                            OpCode.CLOSE,
                            ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(fileNumber)),
                            NULL_ID,
                            NULL_ID
                    ));
        }
    }

    @Override
    public void exitFieldstmt(PuffinBasicParser.FieldstmtContext ctx) {
        var fileNumberInstr = lookupInstruction(ctx.filenum);
        Types.assertNumeric(ir.getSymbolTable().get(fileNumberInstr.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));

        var numEntries = ctx.variable().size();
        for (int i = 0; i < numEntries; i++) {
            var recordPartLen = Numbers.parseInt32(ctx.DECIMAL(i).getText(), () -> getCtxString(ctx));
            var varInstr = lookupInstruction(ctx.variable(i));
            assertVariable(ir.getSymbolTable().get(varInstr.result), () -> getCtxString(ctx));
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.PARAM2,
                    varInstr.result,
                    ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(recordPartLen)),
                    NULL_ID
            );
        }
        // FileNumber, #fields
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.FIELD,
                fileNumberInstr.result,
                ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(numEntries)),
                NULL_ID
        );
    }

    private void assertVariable(STEntry entry, Supplier<String> line) {
        if (!entry.isLValue()) {
            throw new PuffinBasicSemanticError(
                    BAD_ARGUMENT,
                    line.get(),
                    "Expected variable, but found: " + entry
            );
        }
    }

    private void assert1DArray(STVariable variableEntry, Supplier<String> line) {
        var variable = variableEntry.getVariable();
        if (!variable.isArray() || !((ArrayType) variable.getType()).isNDArray(1)) {
            throw new PuffinBasicSemanticError(
                    BAD_ARGUMENT,
                    line.get(),
                    "Variable: " + variable.getVariableName() + " is not array1d"
            );
        }
    }

    private void assert2DArray(STVariable variableEntry, Supplier<String> line) {
        var variable = variableEntry.getVariable();
        if (!variable.isArray() || !((ArrayType) variable.getType()).isNDArray(2)) {
            throw new PuffinBasicSemanticError(
                    BAD_ARGUMENT,
                    line.get(),
                    "Variable: " + variable.getVariableName() + " is not array2d"
            );
        }
    }

    private void assertNDArray(STVariable variable, Supplier<String> line) {
        if (!variable.getVariable().isArray()) {
            throw new PuffinBasicSemanticError(
                    BAD_ARGUMENT,
                    line.get(),
                    "Variable: " + variable.getVariable().getVariableName() + " is not array"
            );
        }
    }

    @Override
    public void exitPutstmt(PuffinBasicParser.PutstmtContext ctx) {
        var fileNumberInstr = Numbers.parseInt32(ctx.filenum.getText(), () -> getCtxString(ctx));
        final int exprId;
        if (ctx.expr() != null) {
            exprId = lookupInstruction(ctx.expr()).result;
            Types.assertNumeric(ir.getSymbolTable().get(exprId).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
        } else {
            exprId = NULL_ID;
        }
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PUTF,
                ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(fileNumberInstr)),
                exprId,
                NULL_ID
        );
    }

    @Override
    public void exitMiddlrstmt(PuffinBasicParser.MiddlrstmtContext ctx) {
        var varInstr = lookupInstruction(ctx.variable());
        var nInstr = lookupInstruction(ctx.expr(0));
        var mInstrId = ctx.expr().size() == 3
                ? lookupInstruction(ctx.expr(1)).result
                : ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(-1));
        var replacement = ctx.expr().size() == 3
                ? lookupInstruction(ctx.expr(2))
                : lookupInstruction(ctx.expr(1));

        Types.assertString(ir.getSymbolTable().get(varInstr.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertString(ir.getSymbolTable().get(replacement.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        assertVariable(ir.getSymbolTable().get(varInstr.result),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(nInstr.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(mInstrId).getType().getAtomTypeId(),
                () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, varInstr.result, nInstr.result, NULL_ID);
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.MIDDLR_STMT, mInstrId, replacement.result, NULL_ID);
    }

    @Override
    public void exitGetstmt(PuffinBasicParser.GetstmtContext ctx) {
        var fileNumberInstr = Numbers.parseInt32(ctx.filenum.getText(), () -> getCtxString(ctx));
        final int exprId;
        if (ctx.expr() != null) {
            exprId = lookupInstruction(ctx.expr()).result;
            Types.assertNumeric(ir.getSymbolTable().get(exprId).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
        } else {
            exprId = NULL_ID;
        }
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GETF,
                ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(fileNumberInstr)),
                exprId,
                NULL_ID
        );
    }

    @Override
    public void exitRandomizestmt(PuffinBasicParser.RandomizestmtContext ctx) {
        var exprId = lookupInstruction(ctx.expr()).result;
        Types.assertNumeric(ir.getSymbolTable().get(exprId).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.RANDOMIZE, exprId, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitRandomizetimerstmt(PuffinBasicParser.RandomizetimerstmtContext ctx) {
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.RANDOMIZE_TIMER, NULL_ID, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitDefintstmt(PuffinBasicParser.DefintstmtContext ctx) {
        handleDefTypeStmt(ctx.LETTERRANGE(), INT32);
    }

    @Override
    public void exitDeflngstmt(PuffinBasicParser.DeflngstmtContext ctx) {
        handleDefTypeStmt(ctx.LETTERRANGE(), INT64);
    }

    @Override
    public void exitDefsngstmt(PuffinBasicParser.DefsngstmtContext ctx) {
        handleDefTypeStmt(ctx.LETTERRANGE(), FLOAT);
    }

    @Override
    public void exitDefdblstmt(PuffinBasicParser.DefdblstmtContext ctx) {
        handleDefTypeStmt(ctx.LETTERRANGE(), DOUBLE);
    }

    @Override
    public void exitDefstrstmt(PuffinBasicParser.DefstrstmtContext ctx) {
        handleDefTypeStmt(ctx.LETTERRANGE(), STRING);
    }

    @Override
    public void exitLsetstmt(PuffinBasicParser.LsetstmtContext ctx) {
        var varInstr = lookupInstruction(ctx.variable());
        var exprInstr = lookupInstruction(ctx.expr());

        var varEntry = ir.getSymbolTable().get(varInstr.result);
        assertVariable(varEntry, () -> getCtxString(ctx));
        Types.assertString(varEntry.getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertString(ir.getSymbolTable().get(exprInstr.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LSET, varInstr.result, exprInstr.result, NULL_ID
        );
    }

    @Override
    public void exitRsetstmt(PuffinBasicParser.RsetstmtContext ctx) {
        var varInstr = lookupInstruction(ctx.variable());
        var exprInstr = lookupInstruction(ctx.expr());

        var varEntry = ir.getSymbolTable().get(varInstr.result);
        assertVariable(varEntry, () -> getCtxString(ctx));
        Types.assertString(varEntry.getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertString(ir.getSymbolTable().get(exprInstr.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.RSET, varInstr.result, exprInstr.result, NULL_ID
        );
    }

    @Override
    public void exitInputstmt(PuffinBasicParser.InputstmtContext ctx) {
        for (var varCtx : ctx.variable()) {
            var varInstr = lookupInstruction(varCtx);
            assertVariable(ir.getSymbolTable().get(varInstr.result),
                    () -> getCtxString(ctx));
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.PARAM1, varInstr.result, NULL_ID, NULL_ID
            );
        }

        int promptId;
        if (ctx.expr() != null) {
            promptId = lookupInstruction(ctx.expr()).result;
            Types.assertString(ir.getSymbolTable().get(promptId).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
        } else {
            promptId = ir.getSymbolTable().addTmp(STRING, e -> e.getValue().setString("?"));
        }
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.INPUT, promptId, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitInputhashstmt(PuffinBasicParser.InputhashstmtContext ctx) {
        for (var varCtx : ctx.variable()) {
            var varInstr = lookupInstruction(varCtx);
            assertVariable(ir.getSymbolTable().get(varInstr.result),
                    () -> getCtxString(ctx));
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.PARAM1, varInstr.result, NULL_ID, NULL_ID
            );
        }

        var fileNumInstr = lookupInstruction(ctx.filenum);
        Types.assertNumeric(ir.getSymbolTable().get(fileNumInstr.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.INPUT, NULL_ID, fileNumInstr.result, NULL_ID
        );
    }

    @Override
    public void exitLineinputstmt(PuffinBasicParser.LineinputstmtContext ctx) {
        var varInstr = lookupInstruction(ctx.variable());
        assertVariable(ir.getSymbolTable().get(varInstr.result),
                () -> getCtxString(ctx));
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM1, varInstr.result, NULL_ID, NULL_ID
        );

        int promptId;
        if (ctx.expr() != null) {
            promptId = lookupInstruction(ctx.expr()).result;
            Types.assertString(ir.getSymbolTable().get(promptId).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
        } else {
            promptId = ir.getSymbolTable().addTmp(STRING, e -> e.getValue().setString(""));
        }

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LINE_INPUT, promptId, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitLineinputhashstmt(PuffinBasicParser.LineinputhashstmtContext ctx) {
        var varInstr = lookupInstruction(ctx.variable());
        assertVariable(ir.getSymbolTable().get(varInstr.result),
                () -> getCtxString(ctx));
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM1, varInstr.result, NULL_ID, NULL_ID
        );

        var fileNumInstr = lookupInstruction(ctx.filenum);
        Types.assertNumeric(ir.getSymbolTable().get(fileNumInstr.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LINE_INPUT, NULL_ID, fileNumInstr.result, NULL_ID
        );
    }

    @Override
    public void exitWritestmt(PuffinBasicParser.WritestmtContext ctx) {
        handleWritestmt(ctx, ctx.expr(), null);
    }

    @Override
    public void exitWritehashstmt(PuffinBasicParser.WritehashstmtContext ctx) {
        var fileNumInstr = lookupInstruction(ctx.filenum);
        handleWritestmt(ctx, ctx.expr(), fileNumInstr);
    }

    public void handleWritestmt(
            ParserRuleContext ctx,
            List<PuffinBasicParser.ExprContext> exprs,
            @Nullable Instruction fileNumber) {
        // if fileNumber != null, skip first instruction
        for (int i = fileNumber == null ? 0 : 1; i < exprs.size(); i++) {
            var exprCtx = exprs.get(i);
            var exprInstr = lookupInstruction(exprCtx);
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.WRITE, exprInstr.result, NULL_ID, NULL_ID
            );
            if (i + 1 < exprs.size()) {
                var commaId = ir.getSymbolTable().addTmp(STRING,
                        entry -> entry.getValue().setString(","));
                ir.addInstruction(
                        sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                        OpCode.PRINT, commaId, NULL_ID, NULL_ID
                );
            }
        }

        var newlineId = ir.getSymbolTable().addTmp(STRING,
                entry -> entry.getValue().setString(System.lineSeparator()));
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PRINT, newlineId, NULL_ID, NULL_ID
        );

        final int fileNumberId;
        if (fileNumber != null) {
            Types.assertNumeric(ir.getSymbolTable().get(fileNumber.result).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
            fileNumberId = fileNumber.result;
        } else {
            fileNumberId = NULL_ID;
        }
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.FLUSH, fileNumberId, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitReadstmt(PuffinBasicParser.ReadstmtContext ctx) {
        for (var varCtx : ctx.variable()) {
            var varInstr = lookupInstruction(varCtx);
            assertVariable(ir.getSymbolTable().get(varInstr.result),
                    () -> getCtxString(ctx));
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.READ, varInstr.result, NULL_ID, NULL_ID
            );
        }
    }

    // GraphicsRuntime

    @Override
    public void exitRestorestmt(PuffinBasicParser.RestorestmtContext ctx) {
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.RESTORE, NULL_ID, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitDatastmt(PuffinBasicParser.DatastmtContext ctx) {
        var children = ctx.children;
        for (int i = 1; i < children.size(); i += 2) {
            var child = children.get(i);
            int valueId;
            if (child instanceof PuffinBasicParser.NumberContext) {
                valueId = lookupInstruction((PuffinBasicParser.NumberContext) child).result;
            } else {
                var text = unquote(child.getText());
                valueId = ir.getSymbolTable().addTmp(STRING, e -> e.getValue().setString(text));
            }
            ir.addInstruction(
                    sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                    OpCode.DATA, valueId, NULL_ID, NULL_ID
            );
        }
    }

    @Override
    public void exitLabelstmt(PuffinBasicParser.LabelstmtContext ctx) {
        var label = ctx.string().STRING().getText();
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LABEL, ir.getSymbolTable().addLabel(label), NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitScreenstmt(PuffinBasicParser.ScreenstmtContext ctx) {
        assertGraphics();

        var title = lookupInstruction(ctx.expr(0));
        var w = lookupInstruction(ctx.expr(1));
        var h = lookupInstruction(ctx.expr(2));
        var iw = ctx.expr().size() == 5 ? lookupInstruction(ctx.expr(3)) : w;
        var ih = ctx.expr().size() == 5 ? lookupInstruction(ctx.expr(4)) : h;
        var manualRepaintFlag = ctx.mr != null;
        var doubleBufferFlag = ctx.db != null;

        Types.assertString(ir.getSymbolTable().get(title.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(w.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(h.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(iw.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(ih.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, w.result, h.result, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, iw.result, ih.result, NULL_ID
        );
        var repaint = ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(
                manualRepaintFlag ? 0 : -1));
        var doubleBuffer = ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(
                doubleBufferFlag ? -1 : 0));
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, repaint, doubleBuffer, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.SCREEN, title.result, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitRepaintstmt(PuffinBasicParser.RepaintstmtContext ctx) {
        assertGraphics();
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.REPAINT, NULL_ID, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitCirclestmt(PuffinBasicParser.CirclestmtContext ctx) {
        assertGraphics();

        var x = lookupInstruction(ctx.x);
        var y = lookupInstruction(ctx.y);
        var r1 = lookupInstruction(ctx.r1);
        var r2 = lookupInstruction(ctx.r2);
        var s = ctx.s != null ? lookupInstruction(ctx.s) : null;
        var e = ctx.e != null ? lookupInstruction(ctx.e) : null;
        var fill = ctx.fill != null ? lookupInstruction(ctx.fill) : null;
        Types.assertNumeric(ir.getSymbolTable().get(x.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(y.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(r1.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(r2.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        if (s != null) {
            Types.assertNumeric(ir.getSymbolTable().get(s.result).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
        }
        if (e != null) {
            Types.assertNumeric(ir.getSymbolTable().get(e.result).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
        }
        if (fill != null) {
            Types.assertString(ir.getSymbolTable().get(fill.result).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
        }
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, x.result, y.result, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2,
                s != null ? s.result : NULL_ID,
                e != null ? e.result : NULL_ID,
                NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM1,
                fill != null ? fill.result : NULL_ID,
                NULL_ID,
                NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.CIRCLE, r1.result, r2.result, NULL_ID
        );
    }

    @Override
    public void exitLinestmt(PuffinBasicParser.LinestmtContext ctx) {
        assertGraphics();

        var x1 = lookupInstruction(ctx.x1);
        var y1 = lookupInstruction(ctx.y1);
        var x2 = lookupInstruction(ctx.x2);
        var y2 = lookupInstruction(ctx.y2);

        Types.assertNumeric(ir.getSymbolTable().get(x1.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(y1.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(x2.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(y2.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));

        Instruction bf = null;
        if (ctx.bf != null) {
            bf = lookupInstruction(ctx.bf);
            Types.assertString(ir.getSymbolTable().get(bf.result).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
        }
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, x1.result, y1.result, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, x2.result, y2.result, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LINE, bf != null ? bf.result : NULL_ID, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitColorstmt(PuffinBasicParser.ColorstmtContext ctx) {
        var r = lookupInstruction(ctx.r);
        var g = lookupInstruction(ctx.g);
        var b = lookupInstruction(ctx.b);
        Types.assertNumeric(ir.getSymbolTable().get(r.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(g.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(b.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, r.result, g.result, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.COLOR, b.result, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitPaintstmt(PuffinBasicParser.PaintstmtContext ctx) {
        assertGraphics();

        var x = lookupInstruction(ctx.x);
        var y = lookupInstruction(ctx.y);
        var r = lookupInstruction(ctx.r);
        var g = lookupInstruction(ctx.g);
        var b = lookupInstruction(ctx.b);

        Types.assertNumeric(ir.getSymbolTable().get(x.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(y.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(r.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(g.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(b.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, r.result, g.result, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM1, b.result, NULL_ID, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PAINT, x.result, y.result, NULL_ID
        );
    }

    @Override
    public void exitPsetstmt(PuffinBasicParser.PsetstmtContext ctx) {
        assertGraphics();

        var x = lookupInstruction(ctx.x);
        var y = lookupInstruction(ctx.y);

        int rId = NULL_ID, gId = NULL_ID, bId = NULL_ID;
        if (ctx.r != null) {
            rId = lookupInstruction(ctx.r).result;
            Types.assertNumeric(ir.getSymbolTable().get(rId).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
        }
        if (ctx.g != null) {
            gId = lookupInstruction(ctx.g).result;
            Types.assertNumeric(ir.getSymbolTable().get(gId).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
        }
        if (ctx.b != null) {
            bId = lookupInstruction(ctx.b).result;
            Types.assertNumeric(ir.getSymbolTable().get(bId).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
        }

        Types.assertNumeric(ir.getSymbolTable().get(x.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(y.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, rId, gId, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM1, bId, NULL_ID, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PSET, x.result, y.result, NULL_ID
        );
    }

    @Override
    public void exitGraphicsgetstmt(PuffinBasicParser.GraphicsgetstmtContext ctx) {
        assertGraphics();

        var x1 = lookupInstruction(ctx.x1);
        var y1 = lookupInstruction(ctx.y1);
        var x2 = lookupInstruction(ctx.x2);
        var y2 = lookupInstruction(ctx.y2);
        var varInstr = lookupInstruction(ctx.variable());
        final int bufferNumber = ctx.BACK1() != null
                ? 0 //GraphicsUtil.BUFFER_NUM_BACK1
                : 1; //GraphicsUtil.BUFFER_NUM_FRONT;

        Types.assertNumeric(ir.getSymbolTable().get(x1.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(y1.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(x2.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(y2.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        assertVariable(ir.getSymbolTable().get(varInstr.result),
                () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, x1.result, y1.result, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, x2.result, y2.result, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GGET, varInstr.result,
                ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(bufferNumber)),
                NULL_ID
        );
    }

    @Override
    public void exitGraphicsputstmt(PuffinBasicParser.GraphicsputstmtContext ctx) {
        assertGraphics();

        var x = lookupInstruction(ctx.x);
        var y = lookupInstruction(ctx.y);
        var varInstr = lookupInstruction(ctx.variable());
        var action = ctx.action != null ? lookupInstruction(ctx.action) : null;
        final int bufferNumber = ctx.FRONT() == null
                ? 0 //GraphicsUtil.BUFFER_NUM_BACK1
                : 1; // GraphicsUtil.BUFFER_NUM_FRONT;

        Types.assertNumeric(ir.getSymbolTable().get(x.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(y.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        assertVariable(ir.getSymbolTable().get(varInstr.result),
                () -> getCtxString(ctx));
        if (action != null) {
            Types.assertString(ir.getSymbolTable().get(action.result).getType().getAtomTypeId(),
                    () -> getCtxString(ctx));
        }

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, x.result, y.result, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM1,
                ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(bufferNumber)),
                NULL_ID, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.GPUT,
                action != null ? action.result : NULL_ID,
                varInstr.result,
                NULL_ID
        );
    }

    @Override
    public void exitGraphicsbuffercopyhorstmt(PuffinBasicParser.GraphicsbuffercopyhorstmtContext ctx) {
        assertGraphics();

        var srcx = lookupInstruction(ctx.srcx);
        var dstx = lookupInstruction(ctx.dstx);
        var w = lookupInstruction(ctx.w);

        Types.assertNumeric(ir.getSymbolTable().get(srcx.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(dstx.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(w.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, srcx.result, dstx.result, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.BUFFERCOPYHOR, w.result, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitDrawstmt(PuffinBasicParser.DrawstmtContext ctx) {
        assertGraphics();

        var str = lookupInstruction(ctx.expr());
        Types.assertString(ir.getSymbolTable().get(str.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.DRAW, str.result, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitFontstmt(PuffinBasicParser.FontstmtContext ctx) {
        assertGraphics();

        var name = lookupInstruction(ctx.name);
        var style = lookupInstruction(ctx.style);
        var size = lookupInstruction(ctx.size);

        Types.assertString(ir.getSymbolTable().get(style.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(size.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertString(ir.getSymbolTable().get(name.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, style.result, size.result, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.FONT, name.result, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitDrawstrstmt(PuffinBasicParser.DrawstrstmtContext ctx) {
        var str = lookupInstruction(ctx.str);
        var x = lookupInstruction(ctx.x);
        var y = lookupInstruction(ctx.y);

        Types.assertNumeric(ir.getSymbolTable().get(x.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertNumeric(ir.getSymbolTable().get(y.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        Types.assertString(ir.getSymbolTable().get(str.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, x.result, y.result, NULL_ID
        );
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.DRAWSTR, str.result, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitLoadimgstmt(PuffinBasicParser.LoadimgstmtContext ctx) {
        assertGraphics();

        var path = lookupInstruction(ctx.path);
        var varInstr = lookupInstruction(ctx.variable());

        Types.assertString(ir.getSymbolTable().get(path.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        assertVariable(ir.getSymbolTable().get(varInstr.result),
                () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LOADIMG, path.result, varInstr.result, NULL_ID
        );
    }

    @Override
    public void exitSaveimgstmt(PuffinBasicParser.SaveimgstmtContext ctx) {
        assertGraphics();

        var path = lookupInstruction(ctx.path);
        var varInstr = lookupInstruction(ctx.variable());

        Types.assertString(ir.getSymbolTable().get(path.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        assertVariable(ir.getSymbolTable().get(varInstr.result),
                () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.SAVEIMG, path.result, varInstr.result, NULL_ID
        );
    }

    @Override
    public void exitClsstmt(PuffinBasicParser.ClsstmtContext ctx) {
        assertGraphics();
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.CLS, NULL_ID, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitLoadwavstmt(PuffinBasicParser.LoadwavstmtContext ctx) {
        assertGraphics();

        var path = lookupInstruction(ctx.path);
        var varInstr = lookupInstruction(ctx.variable());

        Types.assertString(ir.getSymbolTable().get(path.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        assertVariable(ir.getSymbolTable().get(varInstr.result),
                () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LOADWAV, path.result, varInstr.result, NULL_ID
        );
    }

    @Override
    public void exitPlaywavstmt(PuffinBasicParser.PlaywavstmtContext ctx) {
        assertGraphics();

        var varInstr = lookupInstruction(ctx.variable());

        assertVariable(ir.getSymbolTable().get(varInstr.result),
                () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PLAYWAV, varInstr.result, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitStopwavstmt(PuffinBasicParser.StopwavstmtContext ctx) {
        assertGraphics();

        var varInstr = lookupInstruction(ctx.variable());

        assertVariable(ir.getSymbolTable().get(varInstr.result),
                () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.STOPWAV, varInstr.result, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitLoopwavstmt(PuffinBasicParser.LoopwavstmtContext ctx) {
        assertGraphics();

        var varInstr = lookupInstruction(ctx.variable());

        assertVariable(ir.getSymbolTable().get(varInstr.result),
                () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.LOOPWAV, varInstr.result, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitSleepstmt(PuffinBasicParser.SleepstmtContext ctx) {
        var millis = lookupInstruction(ctx.expr());
        Types.assertNumeric(ir.getSymbolTable().get(millis.result).getType().getAtomTypeId(),
                () -> getCtxString(ctx));
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.SLEEP, millis.result, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitBeepstmt(PuffinBasicParser.BeepstmtContext ctx) {
        assertGraphics();
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.BEEP, NULL_ID, NULL_ID, NULL_ID
        );
    }

    @Override
    public void exitArray1dsortstmt(PuffinBasicParser.Array1dsortstmtContext ctx) {
        var var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(), false);
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ARRAY1DSORT, var1Instr.result, NULL_ID, NULL_ID);
    }

    @Override
    public void exitArraycopystmt(PuffinBasicParser.ArraycopystmtContext ctx) {
        var var1Instr = getArrayNdVariableInstruction(ctx, ctx.variable(0));
        var var2Instr = getArrayNdVariableInstruction(ctx, ctx.variable(1));
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ARRAYCOPY, var1Instr.result, var2Instr.result, NULL_ID);
    }

    @Override
    public void exitArray1dcopystmt(PuffinBasicParser.Array1dcopystmtContext ctx) {
        var var1Instr = getArray1dVariableInstruction(ctx, ctx.variable(0), false);
        var var2Instr = getArray1dVariableInstruction(ctx, ctx.variable(1), false);

        var src0 = lookupInstruction(ctx.src0);
        Types.assertNumeric(ir.getSymbolTable().get(src0.result).getType().getAtomTypeId(), () -> getCtxString(ctx));
        var dst0 = lookupInstruction(ctx.dst0);
        Types.assertNumeric(ir.getSymbolTable().get(dst0.result).getType().getAtomTypeId(), () -> getCtxString(ctx));
        var len = lookupInstruction(ctx.len);
        Types.assertNumeric(ir.getSymbolTable().get(len.result).getType().getAtomTypeId(), () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, var1Instr.result, src0.result, NULL_ID);
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.PARAM2, var2Instr.result, dst0.result, NULL_ID);
        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ARRAY1DCOPY, len.result, NULL_ID, NULL_ID);
    }

    @Override
    public void exitArray2dshifthorstmt(PuffinBasicParser.Array2dshifthorstmtContext ctx) {
        var varInstr = getArray2dVariableInstruction(ctx, ctx.variable());
        var expr = lookupInstruction(ctx.expr());
        Types.assertNumeric(ir.getSymbolTable().get(expr.result).getType().getAtomTypeId(), () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ARRAY2DSHIFTHOR, varInstr.result, expr.result, NULL_ID);
    }

    @Override
    public void exitArray2dshiftverstmt(PuffinBasicParser.Array2dshiftverstmtContext ctx) {
        var varInstr = getArray2dVariableInstruction(ctx, ctx.variable());
        var expr = lookupInstruction(ctx.expr());
        Types.assertNumeric(ir.getSymbolTable().get(expr.result).getType().getAtomTypeId(), () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ARRAY2DSHIFTVER, varInstr.result, expr.result, NULL_ID);
    }

    @Override
    public void exitArrayfillstmt(PuffinBasicParser.ArrayfillstmtContext ctx) {
        var varInstr = getArrayNdVariableInstruction(ctx, ctx.variable());

        var expr = lookupInstruction(ctx.expr());
        Types.assertNumeric(ir.getSymbolTable().get(expr.result).getType().getAtomTypeId(), () -> getCtxString(ctx));

        ir.addInstruction(
                sourceFile, currentLineNumber, ctx.start.getStartIndex(), ctx.stop.getStopIndex(),
                OpCode.ARRAYFILL, varInstr.result, expr.result, NULL_ID);
    }

    private void assertGraphics() {
        if (!graphics) {
            throw new PuffinBasicInternalError(
                    "GraphicsRuntime is not enabled!"
            );
        }
    }

    private void handleDefTypeStmt(
            List<TerminalNode> letterRanges,
            PuffinBasicAtomTypeId dataType) {
        List<Character> defs = new ArrayList<>();
        letterRanges.stream().map(ParseTree::getText).forEach(lr -> {
            for (char i = lr.charAt(0); i <= lr.charAt(2); i++) {
                defs.add(i);
            }
        });
        defs.forEach(def -> ir.getSymbolTable().setDefaultDataType(def, dataType));
    }

    private int getGotoLineNumberOp1(int lineNumber) {
        return ir.getSymbolTable().addTmp(INT32, e -> e.getValue().setInt32(lineNumber));
    }

    private void checkDataTypeMatch(int id1, int id2, Supplier<String> lineSupplier) {
        checkDataTypeMatch(ir.getSymbolTable().get(id1), id2, lineSupplier);
    }

    private void checkDataTypeMatch(STEntry entry1, int id2, Supplier<String> lineSupplier) {
        var entry2 = ir.getSymbolTable().get(id2);
        if ((entry1.getType().getAtomTypeId() == STRING && entry2.getType().getAtomTypeId() != STRING) ||
                (entry1.getType().getAtomTypeId() != STRING && entry2.getType().getAtomTypeId() == STRING)) {
            throw new PuffinBasicSemanticError(
                    DATA_TYPE_MISMATCH,
                    lineSupplier.get(),
                    "Data type " + entry1.getType().getAtomTypeId()
                            + " mismatches with " + entry2.getType().getAtomTypeId()
            );
        }
    }

    private void checkDataTypeMatch(PuffinBasicAtomTypeId dt1, PuffinBasicAtomTypeId dt2, Supplier<String> lineSupplier) {
        if ((dt1 == STRING && dt2 != STRING) ||
                (dt1 != STRING && dt2 == STRING)) {
            throw new PuffinBasicSemanticError(
                    DATA_TYPE_MISMATCH,
                    lineSupplier.get(),
                    "Data type " + dt1 + " mismatches with " + dt2
            );
        }
    }

    private enum NumericOrString {
        NUMERIC,
        STRING
    }

    private static final class UDFState {
        public final List<Instruction> gotoLabelGotoCaller;
        private final VariableName variableName;
        private final STUDF udfEntry;
        public Instruction gotoPostFuncDecl;
        public Instruction labelFuncStart;
        public int udfId;

        public UDFState(VariableName variableName, STUDF udfEntry) {
            this.variableName = variableName;
            this.udfEntry = udfEntry;
            this.gotoLabelGotoCaller = new ArrayList<>(2);
        }
    }

    private static final class WhileLoopState {
        public Instruction labelBeforeWhile;
        public Instruction gotoAfterWend;
    }

    private static final class ForLoopState {
        public Variable variable;
        public Instruction labelApplyStep;
        public Instruction gotoAfterNext;
    }

    private static final class IfState {
        public Instruction gotoIfConditionTrue;
        public Instruction gotoIfConditionFalse;
        public Instruction gotoFromThenAfterIf;
        public Instruction labelBeforeThen;
        public Instruction labelAfterThen;
        public Instruction labelBeforeElse;
        public Instruction labelAfterElse;
    }
}
