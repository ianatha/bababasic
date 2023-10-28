// Generated from PuffinBasic.g4 by ANTLR 4.13.1
package org.puffinbasic.antlr4;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PuffinBasicParser}.
 */
public interface PuffinBasicListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#prog}.
     *
     * @param ctx the parse tree
     */
    void enterProg(PuffinBasicParser.ProgContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#prog}.
     *
     * @param ctx the parse tree
     */
    void exitProg(PuffinBasicParser.ProgContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#line}.
     *
     * @param ctx the parse tree
     */
    void enterLine(PuffinBasicParser.LineContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#line}.
     *
     * @param ctx the parse tree
     */
    void exitLine(PuffinBasicParser.LineContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#linenum}.
     *
     * @param ctx the parse tree
     */
    void enterLinenum(PuffinBasicParser.LinenumContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#linenum}.
     *
     * @param ctx the parse tree
     */
    void exitLinenum(PuffinBasicParser.LinenumContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#comment}.
     *
     * @param ctx the parse tree
     */
    void enterComment(PuffinBasicParser.CommentContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#comment}.
     *
     * @param ctx the parse tree
     */
    void exitComment(PuffinBasicParser.CommentContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#stmt}.
     *
     * @param ctx the parse tree
     */
    void enterStmt(PuffinBasicParser.StmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#stmt}.
     *
     * @param ctx the parse tree
     */
    void exitStmt(PuffinBasicParser.StmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#variable}.
     *
     * @param ctx the parse tree
     */
    void enterVariable(PuffinBasicParser.VariableContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#variable}.
     *
     * @param ctx the parse tree
     */
    void exitVariable(PuffinBasicParser.VariableContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#leafvariable}.
     *
     * @param ctx the parse tree
     */
    void enterLeafvariable(PuffinBasicParser.LeafvariableContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#leafvariable}.
     *
     * @param ctx the parse tree
     */
    void exitLeafvariable(PuffinBasicParser.LeafvariableContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#structvariable}.
     *
     * @param ctx the parse tree
     */
    void enterStructvariable(PuffinBasicParser.StructvariableContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#structvariable}.
     *
     * @param ctx the parse tree
     */
    void exitStructvariable(PuffinBasicParser.StructvariableContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#varname}.
     *
     * @param ctx the parse tree
     */
    void enterVarname(PuffinBasicParser.VarnameContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#varname}.
     *
     * @param ctx the parse tree
     */
    void exitVarname(PuffinBasicParser.VarnameContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#varsuffix}.
     *
     * @param ctx the parse tree
     */
    void enterVarsuffix(PuffinBasicParser.VarsuffixContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#varsuffix}.
     *
     * @param ctx the parse tree
     */
    void exitVarsuffix(PuffinBasicParser.VarsuffixContext ctx);

    /**
     * Enter a parse tree produced by the {@code ExprLogNot}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterExprLogNot(PuffinBasicParser.ExprLogNotContext ctx);

    /**
     * Exit a parse tree produced by the {@code ExprLogNot}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitExprLogNot(PuffinBasicParser.ExprLogNotContext ctx);

    /**
     * Enter a parse tree produced by the {@code ExprParen}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterExprParen(PuffinBasicParser.ExprParenContext ctx);

    /**
     * Exit a parse tree produced by the {@code ExprParen}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitExprParen(PuffinBasicParser.ExprParenContext ctx);

    /**
     * Enter a parse tree produced by the {@code ExprString}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterExprString(PuffinBasicParser.ExprStringContext ctx);

    /**
     * Exit a parse tree produced by the {@code ExprString}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitExprString(PuffinBasicParser.ExprStringContext ctx);

    /**
     * Enter a parse tree produced by the {@code ExprRelational}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterExprRelational(PuffinBasicParser.ExprRelationalContext ctx);

    /**
     * Exit a parse tree produced by the {@code ExprRelational}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitExprRelational(PuffinBasicParser.ExprRelationalContext ctx);

    /**
     * Enter a parse tree produced by the {@code ExprMulDiv}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterExprMulDiv(PuffinBasicParser.ExprMulDivContext ctx);

    /**
     * Exit a parse tree produced by the {@code ExprMulDiv}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitExprMulDiv(PuffinBasicParser.ExprMulDivContext ctx);

    /**
     * Enter a parse tree produced by the {@code ExprLogical}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterExprLogical(PuffinBasicParser.ExprLogicalContext ctx);

    /**
     * Exit a parse tree produced by the {@code ExprLogical}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitExprLogical(PuffinBasicParser.ExprLogicalContext ctx);

    /**
     * Enter a parse tree produced by the {@code ExprBitwise}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterExprBitwise(PuffinBasicParser.ExprBitwiseContext ctx);

    /**
     * Exit a parse tree produced by the {@code ExprBitwise}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitExprBitwise(PuffinBasicParser.ExprBitwiseContext ctx);

    /**
     * Enter a parse tree produced by the {@code ExprNumber}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterExprNumber(PuffinBasicParser.ExprNumberContext ctx);

    /**
     * Exit a parse tree produced by the {@code ExprNumber}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitExprNumber(PuffinBasicParser.ExprNumberContext ctx);

    /**
     * Enter a parse tree produced by the {@code ExprFunc}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterExprFunc(PuffinBasicParser.ExprFuncContext ctx);

    /**
     * Exit a parse tree produced by the {@code ExprFunc}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitExprFunc(PuffinBasicParser.ExprFuncContext ctx);

    /**
     * Enter a parse tree produced by the {@code ExprExp}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterExprExp(PuffinBasicParser.ExprExpContext ctx);

    /**
     * Exit a parse tree produced by the {@code ExprExp}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitExprExp(PuffinBasicParser.ExprExpContext ctx);

    /**
     * Enter a parse tree produced by the {@code ExprVariable}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterExprVariable(PuffinBasicParser.ExprVariableContext ctx);

    /**
     * Exit a parse tree produced by the {@code ExprVariable}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitExprVariable(PuffinBasicParser.ExprVariableContext ctx);

    /**
     * Enter a parse tree produced by the {@code ExprPlusMinus}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterExprPlusMinus(PuffinBasicParser.ExprPlusMinusContext ctx);

    /**
     * Exit a parse tree produced by the {@code ExprPlusMinus}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitExprPlusMinus(PuffinBasicParser.ExprPlusMinusContext ctx);

    /**
     * Enter a parse tree produced by the {@code ExprMod}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterExprMod(PuffinBasicParser.ExprModContext ctx);

    /**
     * Exit a parse tree produced by the {@code ExprMod}
     * labeled alternative in {@link PuffinBasicParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitExprMod(PuffinBasicParser.ExprModContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncMemberMethodCall}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncMemberMethodCall(PuffinBasicParser.FuncMemberMethodCallContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncMemberMethodCall}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncMemberMethodCall(PuffinBasicParser.FuncMemberMethodCallContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncAbs}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncAbs(PuffinBasicParser.FuncAbsContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncAbs}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncAbs(PuffinBasicParser.FuncAbsContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncAsc}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncAsc(PuffinBasicParser.FuncAscContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncAsc}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncAsc(PuffinBasicParser.FuncAscContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncSin}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncSin(PuffinBasicParser.FuncSinContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncSin}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncSin(PuffinBasicParser.FuncSinContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncCos}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncCos(PuffinBasicParser.FuncCosContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncCos}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncCos(PuffinBasicParser.FuncCosContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncTan}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncTan(PuffinBasicParser.FuncTanContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncTan}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncTan(PuffinBasicParser.FuncTanContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncASin}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncASin(PuffinBasicParser.FuncASinContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncASin}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncASin(PuffinBasicParser.FuncASinContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncACos}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncACos(PuffinBasicParser.FuncACosContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncACos}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncACos(PuffinBasicParser.FuncACosContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncAtn}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncAtn(PuffinBasicParser.FuncAtnContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncAtn}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncAtn(PuffinBasicParser.FuncAtnContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncSinh}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncSinh(PuffinBasicParser.FuncSinhContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncSinh}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncSinh(PuffinBasicParser.FuncSinhContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncCosh}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncCosh(PuffinBasicParser.FuncCoshContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncCosh}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncCosh(PuffinBasicParser.FuncCoshContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncTanh}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncTanh(PuffinBasicParser.FuncTanhContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncTanh}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncTanh(PuffinBasicParser.FuncTanhContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncSqr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncSqr(PuffinBasicParser.FuncSqrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncSqr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncSqr(PuffinBasicParser.FuncSqrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncCint}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncCint(PuffinBasicParser.FuncCintContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncCint}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncCint(PuffinBasicParser.FuncCintContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncClng}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncClng(PuffinBasicParser.FuncClngContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncClng}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncClng(PuffinBasicParser.FuncClngContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncCsng}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncCsng(PuffinBasicParser.FuncCsngContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncCsng}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncCsng(PuffinBasicParser.FuncCsngContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncCdbl}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncCdbl(PuffinBasicParser.FuncCdblContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncCdbl}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncCdbl(PuffinBasicParser.FuncCdblContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncChrDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncChrDlr(PuffinBasicParser.FuncChrDlrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncChrDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncChrDlr(PuffinBasicParser.FuncChrDlrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncMkiDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncMkiDlr(PuffinBasicParser.FuncMkiDlrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncMkiDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncMkiDlr(PuffinBasicParser.FuncMkiDlrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncMklDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncMklDlr(PuffinBasicParser.FuncMklDlrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncMklDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncMklDlr(PuffinBasicParser.FuncMklDlrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncMksDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncMksDlr(PuffinBasicParser.FuncMksDlrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncMksDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncMksDlr(PuffinBasicParser.FuncMksDlrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncMkdDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncMkdDlr(PuffinBasicParser.FuncMkdDlrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncMkdDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncMkdDlr(PuffinBasicParser.FuncMkdDlrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncCvi}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncCvi(PuffinBasicParser.FuncCviContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncCvi}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncCvi(PuffinBasicParser.FuncCviContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncCvl}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncCvl(PuffinBasicParser.FuncCvlContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncCvl}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncCvl(PuffinBasicParser.FuncCvlContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncCvs}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncCvs(PuffinBasicParser.FuncCvsContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncCvs}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncCvs(PuffinBasicParser.FuncCvsContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncCvd}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncCvd(PuffinBasicParser.FuncCvdContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncCvd}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncCvd(PuffinBasicParser.FuncCvdContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncSpaceDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncSpaceDlr(PuffinBasicParser.FuncSpaceDlrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncSpaceDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncSpaceDlr(PuffinBasicParser.FuncSpaceDlrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncStrDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncStrDlr(PuffinBasicParser.FuncStrDlrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncStrDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncStrDlr(PuffinBasicParser.FuncStrDlrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncVal}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncVal(PuffinBasicParser.FuncValContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncVal}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncVal(PuffinBasicParser.FuncValContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncInt}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncInt(PuffinBasicParser.FuncIntContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncInt}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncInt(PuffinBasicParser.FuncIntContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncFix}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncFix(PuffinBasicParser.FuncFixContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncFix}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncFix(PuffinBasicParser.FuncFixContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncLog}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncLog(PuffinBasicParser.FuncLogContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncLog}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncLog(PuffinBasicParser.FuncLogContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncLog10}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncLog10(PuffinBasicParser.FuncLog10Context ctx);

    /**
     * Exit a parse tree produced by the {@code FuncLog10}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncLog10(PuffinBasicParser.FuncLog10Context ctx);

    /**
     * Enter a parse tree produced by the {@code FuncLog2}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncLog2(PuffinBasicParser.FuncLog2Context ctx);

    /**
     * Exit a parse tree produced by the {@code FuncLog2}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncLog2(PuffinBasicParser.FuncLog2Context ctx);

    /**
     * Enter a parse tree produced by the {@code FuncExp}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncExp(PuffinBasicParser.FuncExpContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncExp}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncExp(PuffinBasicParser.FuncExpContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncToRad}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncToRad(PuffinBasicParser.FuncToRadContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncToRad}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncToRad(PuffinBasicParser.FuncToRadContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncToDeg}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncToDeg(PuffinBasicParser.FuncToDegContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncToDeg}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncToDeg(PuffinBasicParser.FuncToDegContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncCeil}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncCeil(PuffinBasicParser.FuncCeilContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncCeil}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncCeil(PuffinBasicParser.FuncCeilContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncFloor}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncFloor(PuffinBasicParser.FuncFloorContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncFloor}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncFloor(PuffinBasicParser.FuncFloorContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncRound}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncRound(PuffinBasicParser.FuncRoundContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncRound}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncRound(PuffinBasicParser.FuncRoundContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncMin}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncMin(PuffinBasicParser.FuncMinContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncMin}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncMin(PuffinBasicParser.FuncMinContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncMax}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncMax(PuffinBasicParser.FuncMaxContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncMax}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncMax(PuffinBasicParser.FuncMaxContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncPI}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncPI(PuffinBasicParser.FuncPIContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncPI}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncPI(PuffinBasicParser.FuncPIContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncE}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncE(PuffinBasicParser.FuncEContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncE}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncE(PuffinBasicParser.FuncEContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncLen}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncLen(PuffinBasicParser.FuncLenContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncLen}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncLen(PuffinBasicParser.FuncLenContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncHexDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncHexDlr(PuffinBasicParser.FuncHexDlrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncHexDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncHexDlr(PuffinBasicParser.FuncHexDlrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncOctDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncOctDlr(PuffinBasicParser.FuncOctDlrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncOctDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncOctDlr(PuffinBasicParser.FuncOctDlrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncRightDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncRightDlr(PuffinBasicParser.FuncRightDlrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncRightDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncRightDlr(PuffinBasicParser.FuncRightDlrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncLeftDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncLeftDlr(PuffinBasicParser.FuncLeftDlrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncLeftDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncLeftDlr(PuffinBasicParser.FuncLeftDlrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncMidDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncMidDlr(PuffinBasicParser.FuncMidDlrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncMidDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncMidDlr(PuffinBasicParser.FuncMidDlrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncInstr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncInstr(PuffinBasicParser.FuncInstrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncInstr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncInstr(PuffinBasicParser.FuncInstrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncRnd}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncRnd(PuffinBasicParser.FuncRndContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncRnd}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncRnd(PuffinBasicParser.FuncRndContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncSgn}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncSgn(PuffinBasicParser.FuncSgnContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncSgn}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncSgn(PuffinBasicParser.FuncSgnContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncEnvironDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncEnvironDlr(PuffinBasicParser.FuncEnvironDlrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncEnvironDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncEnvironDlr(PuffinBasicParser.FuncEnvironDlrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncTimer}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncTimer(PuffinBasicParser.FuncTimerContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncTimer}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncTimer(PuffinBasicParser.FuncTimerContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncTimerMillis}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncTimerMillis(PuffinBasicParser.FuncTimerMillisContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncTimerMillis}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncTimerMillis(PuffinBasicParser.FuncTimerMillisContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncStringDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncStringDlr(PuffinBasicParser.FuncStringDlrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncStringDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncStringDlr(PuffinBasicParser.FuncStringDlrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncEof}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncEof(PuffinBasicParser.FuncEofContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncEof}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncEof(PuffinBasicParser.FuncEofContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncLoc}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncLoc(PuffinBasicParser.FuncLocContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncLoc}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncLoc(PuffinBasicParser.FuncLocContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncLof}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncLof(PuffinBasicParser.FuncLofContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncLof}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncLof(PuffinBasicParser.FuncLofContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncInputDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncInputDlr(PuffinBasicParser.FuncInputDlrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncInputDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncInputDlr(PuffinBasicParser.FuncInputDlrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncInkeyDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncInkeyDlr(PuffinBasicParser.FuncInkeyDlrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncInkeyDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncInkeyDlr(PuffinBasicParser.FuncInkeyDlrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncArray1DMin}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncArray1DMin(PuffinBasicParser.FuncArray1DMinContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncArray1DMin}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncArray1DMin(PuffinBasicParser.FuncArray1DMinContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncArray1DMax}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncArray1DMax(PuffinBasicParser.FuncArray1DMaxContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncArray1DMax}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncArray1DMax(PuffinBasicParser.FuncArray1DMaxContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncArray1DMean}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncArray1DMean(PuffinBasicParser.FuncArray1DMeanContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncArray1DMean}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncArray1DMean(PuffinBasicParser.FuncArray1DMeanContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncArray1DSum}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncArray1DSum(PuffinBasicParser.FuncArray1DSumContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncArray1DSum}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncArray1DSum(PuffinBasicParser.FuncArray1DSumContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncArray1DStd}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncArray1DStd(PuffinBasicParser.FuncArray1DStdContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncArray1DStd}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncArray1DStd(PuffinBasicParser.FuncArray1DStdContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncArray1DMedian}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncArray1DMedian(PuffinBasicParser.FuncArray1DMedianContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncArray1DMedian}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncArray1DMedian(PuffinBasicParser.FuncArray1DMedianContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncArray1DPct}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncArray1DPct(PuffinBasicParser.FuncArray1DPctContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncArray1DPct}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncArray1DPct(PuffinBasicParser.FuncArray1DPctContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncArray1DBinSearch}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncArray1DBinSearch(PuffinBasicParser.FuncArray1DBinSearchContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncArray1DBinSearch}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncArray1DBinSearch(PuffinBasicParser.FuncArray1DBinSearchContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncArray2DFindRow}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncArray2DFindRow(PuffinBasicParser.FuncArray2DFindRowContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncArray2DFindRow}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncArray2DFindRow(PuffinBasicParser.FuncArray2DFindRowContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncArray2DFindColumn}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncArray2DFindColumn(PuffinBasicParser.FuncArray2DFindColumnContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncArray2DFindColumn}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncArray2DFindColumn(PuffinBasicParser.FuncArray2DFindColumnContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncHsb2Rgb}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncHsb2Rgb(PuffinBasicParser.FuncHsb2RgbContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncHsb2Rgb}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncHsb2Rgb(PuffinBasicParser.FuncHsb2RgbContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncMouseMovedX}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncMouseMovedX(PuffinBasicParser.FuncMouseMovedXContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncMouseMovedX}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncMouseMovedX(PuffinBasicParser.FuncMouseMovedXContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncMouseMovedY}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncMouseMovedY(PuffinBasicParser.FuncMouseMovedYContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncMouseMovedY}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncMouseMovedY(PuffinBasicParser.FuncMouseMovedYContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncMouseDraggedX}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncMouseDraggedX(PuffinBasicParser.FuncMouseDraggedXContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncMouseDraggedX}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncMouseDraggedX(PuffinBasicParser.FuncMouseDraggedXContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncMouseDraggedY}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncMouseDraggedY(PuffinBasicParser.FuncMouseDraggedYContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncMouseDraggedY}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncMouseDraggedY(PuffinBasicParser.FuncMouseDraggedYContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncMouseButtonClicked}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncMouseButtonClicked(PuffinBasicParser.FuncMouseButtonClickedContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncMouseButtonClicked}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncMouseButtonClicked(PuffinBasicParser.FuncMouseButtonClickedContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncMouseButtonPressed}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncMouseButtonPressed(PuffinBasicParser.FuncMouseButtonPressedContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncMouseButtonPressed}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncMouseButtonPressed(PuffinBasicParser.FuncMouseButtonPressedContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncMouseButtonReleased}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncMouseButtonReleased(PuffinBasicParser.FuncMouseButtonReleasedContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncMouseButtonReleased}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncMouseButtonReleased(PuffinBasicParser.FuncMouseButtonReleasedContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncIsKeyPressed}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncIsKeyPressed(PuffinBasicParser.FuncIsKeyPressedContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncIsKeyPressed}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncIsKeyPressed(PuffinBasicParser.FuncIsKeyPressedContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncSplitDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncSplitDlr(PuffinBasicParser.FuncSplitDlrContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncSplitDlr}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncSplitDlr(PuffinBasicParser.FuncSplitDlrContext ctx);

    /**
     * Enter a parse tree produced by the {@code FuncAllocArray}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void enterFuncAllocArray(PuffinBasicParser.FuncAllocArrayContext ctx);

    /**
     * Exit a parse tree produced by the {@code FuncAllocArray}
     * labeled alternative in {@link PuffinBasicParser#func}.
     *
     * @param ctx the parse tree
     */
    void exitFuncAllocArray(PuffinBasicParser.FuncAllocArrayContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#funcname}.
     *
     * @param ctx the parse tree
     */
    void enterFuncname(PuffinBasicParser.FuncnameContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#funcname}.
     *
     * @param ctx the parse tree
     */
    void exitFuncname(PuffinBasicParser.FuncnameContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#gosubstmt}.
     *
     * @param ctx the parse tree
     */
    void enterGosubstmt(PuffinBasicParser.GosubstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#gosubstmt}.
     *
     * @param ctx the parse tree
     */
    void exitGosubstmt(PuffinBasicParser.GosubstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#gosublabelstmt}.
     *
     * @param ctx the parse tree
     */
    void enterGosublabelstmt(PuffinBasicParser.GosublabelstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#gosublabelstmt}.
     *
     * @param ctx the parse tree
     */
    void exitGosublabelstmt(PuffinBasicParser.GosublabelstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#returnstmt}.
     *
     * @param ctx the parse tree
     */
    void enterReturnstmt(PuffinBasicParser.ReturnstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#returnstmt}.
     *
     * @param ctx the parse tree
     */
    void exitReturnstmt(PuffinBasicParser.ReturnstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#printhashusingstmt}.
     *
     * @param ctx the parse tree
     */
    void enterPrinthashusingstmt(PuffinBasicParser.PrinthashusingstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#printhashusingstmt}.
     *
     * @param ctx the parse tree
     */
    void exitPrinthashusingstmt(PuffinBasicParser.PrinthashusingstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#printusingstmt}.
     *
     * @param ctx the parse tree
     */
    void enterPrintusingstmt(PuffinBasicParser.PrintusingstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#printusingstmt}.
     *
     * @param ctx the parse tree
     */
    void exitPrintusingstmt(PuffinBasicParser.PrintusingstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#printhashstmt}.
     *
     * @param ctx the parse tree
     */
    void enterPrinthashstmt(PuffinBasicParser.PrinthashstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#printhashstmt}.
     *
     * @param ctx the parse tree
     */
    void exitPrinthashstmt(PuffinBasicParser.PrinthashstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#printstmt}.
     *
     * @param ctx the parse tree
     */
    void enterPrintstmt(PuffinBasicParser.PrintstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#printstmt}.
     *
     * @param ctx the parse tree
     */
    void exitPrintstmt(PuffinBasicParser.PrintstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#printlist}.
     *
     * @param ctx the parse tree
     */
    void enterPrintlist(PuffinBasicParser.PrintlistContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#printlist}.
     *
     * @param ctx the parse tree
     */
    void exitPrintlist(PuffinBasicParser.PrintlistContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#writestmt}.
     *
     * @param ctx the parse tree
     */
    void enterWritestmt(PuffinBasicParser.WritestmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#writestmt}.
     *
     * @param ctx the parse tree
     */
    void exitWritestmt(PuffinBasicParser.WritestmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#writehashstmt}.
     *
     * @param ctx the parse tree
     */
    void enterWritehashstmt(PuffinBasicParser.WritehashstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#writehashstmt}.
     *
     * @param ctx the parse tree
     */
    void exitWritehashstmt(PuffinBasicParser.WritehashstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#letstmt}.
     *
     * @param ctx the parse tree
     */
    void enterLetstmt(PuffinBasicParser.LetstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#letstmt}.
     *
     * @param ctx the parse tree
     */
    void exitLetstmt(PuffinBasicParser.LetstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#autoletstmt}.
     *
     * @param ctx the parse tree
     */
    void enterAutoletstmt(PuffinBasicParser.AutoletstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#autoletstmt}.
     *
     * @param ctx the parse tree
     */
    void exitAutoletstmt(PuffinBasicParser.AutoletstmtContext ctx);

    /**
     * Enter a parse tree produced by the {@code IfThenElse}
     * labeled alternative in {@link PuffinBasicParser#ifstmt}.
     *
     * @param ctx the parse tree
     */
    void enterIfThenElse(PuffinBasicParser.IfThenElseContext ctx);

    /**
     * Exit a parse tree produced by the {@code IfThenElse}
     * labeled alternative in {@link PuffinBasicParser#ifstmt}.
     *
     * @param ctx the parse tree
     */
    void exitIfThenElse(PuffinBasicParser.IfThenElseContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#then}.
     *
     * @param ctx the parse tree
     */
    void enterThen(PuffinBasicParser.ThenContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#then}.
     *
     * @param ctx the parse tree
     */
    void exitThen(PuffinBasicParser.ThenContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#elsestmt}.
     *
     * @param ctx the parse tree
     */
    void enterElsestmt(PuffinBasicParser.ElsestmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#elsestmt}.
     *
     * @param ctx the parse tree
     */
    void exitElsestmt(PuffinBasicParser.ElsestmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#ifthenbeginstmt}.
     *
     * @param ctx the parse tree
     */
    void enterIfthenbeginstmt(PuffinBasicParser.IfthenbeginstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#ifthenbeginstmt}.
     *
     * @param ctx the parse tree
     */
    void exitIfthenbeginstmt(PuffinBasicParser.IfthenbeginstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#elsebeginstmt}.
     *
     * @param ctx the parse tree
     */
    void enterElsebeginstmt(PuffinBasicParser.ElsebeginstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#elsebeginstmt}.
     *
     * @param ctx the parse tree
     */
    void exitElsebeginstmt(PuffinBasicParser.ElsebeginstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#endifstmt}.
     *
     * @param ctx the parse tree
     */
    void enterEndifstmt(PuffinBasicParser.EndifstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#endifstmt}.
     *
     * @param ctx the parse tree
     */
    void exitEndifstmt(PuffinBasicParser.EndifstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#stmtlist}.
     *
     * @param ctx the parse tree
     */
    void enterStmtlist(PuffinBasicParser.StmtlistContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#stmtlist}.
     *
     * @param ctx the parse tree
     */
    void exitStmtlist(PuffinBasicParser.StmtlistContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#forstmt}.
     *
     * @param ctx the parse tree
     */
    void enterForstmt(PuffinBasicParser.ForstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#forstmt}.
     *
     * @param ctx the parse tree
     */
    void exitForstmt(PuffinBasicParser.ForstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#nextstmt}.
     *
     * @param ctx the parse tree
     */
    void enterNextstmt(PuffinBasicParser.NextstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#nextstmt}.
     *
     * @param ctx the parse tree
     */
    void exitNextstmt(PuffinBasicParser.NextstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#gotostmt}.
     *
     * @param ctx the parse tree
     */
    void enterGotostmt(PuffinBasicParser.GotostmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#gotostmt}.
     *
     * @param ctx the parse tree
     */
    void exitGotostmt(PuffinBasicParser.GotostmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#gotolabelstmt}.
     *
     * @param ctx the parse tree
     */
    void enterGotolabelstmt(PuffinBasicParser.GotolabelstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#gotolabelstmt}.
     *
     * @param ctx the parse tree
     */
    void exitGotolabelstmt(PuffinBasicParser.GotolabelstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#endstmt}.
     *
     * @param ctx the parse tree
     */
    void enterEndstmt(PuffinBasicParser.EndstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#endstmt}.
     *
     * @param ctx the parse tree
     */
    void exitEndstmt(PuffinBasicParser.EndstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#deffnstmt}.
     *
     * @param ctx the parse tree
     */
    void enterDeffnstmt(PuffinBasicParser.DeffnstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#deffnstmt}.
     *
     * @param ctx the parse tree
     */
    void exitDeffnstmt(PuffinBasicParser.DeffnstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#functionbeginstmt}.
     *
     * @param ctx the parse tree
     */
    void enterFunctionbeginstmt(PuffinBasicParser.FunctionbeginstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#functionbeginstmt}.
     *
     * @param ctx the parse tree
     */
    void exitFunctionbeginstmt(PuffinBasicParser.FunctionbeginstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#functionreturnstmt}.
     *
     * @param ctx the parse tree
     */
    void enterFunctionreturnstmt(PuffinBasicParser.FunctionreturnstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#functionreturnstmt}.
     *
     * @param ctx the parse tree
     */
    void exitFunctionreturnstmt(PuffinBasicParser.FunctionreturnstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#functionendstmt}.
     *
     * @param ctx the parse tree
     */
    void enterFunctionendstmt(PuffinBasicParser.FunctionendstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#functionendstmt}.
     *
     * @param ctx the parse tree
     */
    void exitFunctionendstmt(PuffinBasicParser.FunctionendstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#importstmt}.
     *
     * @param ctx the parse tree
     */
    void enterImportstmt(PuffinBasicParser.ImportstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#importstmt}.
     *
     * @param ctx the parse tree
     */
    void exitImportstmt(PuffinBasicParser.ImportstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#libtagstmt}.
     *
     * @param ctx the parse tree
     */
    void enterLibtagstmt(PuffinBasicParser.LibtagstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#libtagstmt}.
     *
     * @param ctx the parse tree
     */
    void exitLibtagstmt(PuffinBasicParser.LibtagstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#dimstmt}.
     *
     * @param ctx the parse tree
     */
    void enterDimstmt(PuffinBasicParser.DimstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#dimstmt}.
     *
     * @param ctx the parse tree
     */
    void exitDimstmt(PuffinBasicParser.DimstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#reallocstmt}.
     *
     * @param ctx the parse tree
     */
    void enterReallocstmt(PuffinBasicParser.ReallocstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#reallocstmt}.
     *
     * @param ctx the parse tree
     */
    void exitReallocstmt(PuffinBasicParser.ReallocstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#whilestmt}.
     *
     * @param ctx the parse tree
     */
    void enterWhilestmt(PuffinBasicParser.WhilestmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#whilestmt}.
     *
     * @param ctx the parse tree
     */
    void exitWhilestmt(PuffinBasicParser.WhilestmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#wendstmt}.
     *
     * @param ctx the parse tree
     */
    void enterWendstmt(PuffinBasicParser.WendstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#wendstmt}.
     *
     * @param ctx the parse tree
     */
    void exitWendstmt(PuffinBasicParser.WendstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#lsetstmt}.
     *
     * @param ctx the parse tree
     */
    void enterLsetstmt(PuffinBasicParser.LsetstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#lsetstmt}.
     *
     * @param ctx the parse tree
     */
    void exitLsetstmt(PuffinBasicParser.LsetstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#rsetstmt}.
     *
     * @param ctx the parse tree
     */
    void enterRsetstmt(PuffinBasicParser.RsetstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#rsetstmt}.
     *
     * @param ctx the parse tree
     */
    void exitRsetstmt(PuffinBasicParser.RsetstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#swapstmt}.
     *
     * @param ctx the parse tree
     */
    void enterSwapstmt(PuffinBasicParser.SwapstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#swapstmt}.
     *
     * @param ctx the parse tree
     */
    void exitSwapstmt(PuffinBasicParser.SwapstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#open1stmt}.
     *
     * @param ctx the parse tree
     */
    void enterOpen1stmt(PuffinBasicParser.Open1stmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#open1stmt}.
     *
     * @param ctx the parse tree
     */
    void exitOpen1stmt(PuffinBasicParser.Open1stmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#open2stmt}.
     *
     * @param ctx the parse tree
     */
    void enterOpen2stmt(PuffinBasicParser.Open2stmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#open2stmt}.
     *
     * @param ctx the parse tree
     */
    void exitOpen2stmt(PuffinBasicParser.Open2stmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#closestmt}.
     *
     * @param ctx the parse tree
     */
    void enterClosestmt(PuffinBasicParser.ClosestmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#closestmt}.
     *
     * @param ctx the parse tree
     */
    void exitClosestmt(PuffinBasicParser.ClosestmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#filemode1}.
     *
     * @param ctx the parse tree
     */
    void enterFilemode1(PuffinBasicParser.Filemode1Context ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#filemode1}.
     *
     * @param ctx the parse tree
     */
    void exitFilemode1(PuffinBasicParser.Filemode1Context ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#filemode2}.
     *
     * @param ctx the parse tree
     */
    void enterFilemode2(PuffinBasicParser.Filemode2Context ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#filemode2}.
     *
     * @param ctx the parse tree
     */
    void exitFilemode2(PuffinBasicParser.Filemode2Context ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#access}.
     *
     * @param ctx the parse tree
     */
    void enterAccess(PuffinBasicParser.AccessContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#access}.
     *
     * @param ctx the parse tree
     */
    void exitAccess(PuffinBasicParser.AccessContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#lock}.
     *
     * @param ctx the parse tree
     */
    void enterLock(PuffinBasicParser.LockContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#lock}.
     *
     * @param ctx the parse tree
     */
    void exitLock(PuffinBasicParser.LockContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#putstmt}.
     *
     * @param ctx the parse tree
     */
    void enterPutstmt(PuffinBasicParser.PutstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#putstmt}.
     *
     * @param ctx the parse tree
     */
    void exitPutstmt(PuffinBasicParser.PutstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#getstmt}.
     *
     * @param ctx the parse tree
     */
    void enterGetstmt(PuffinBasicParser.GetstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#getstmt}.
     *
     * @param ctx the parse tree
     */
    void exitGetstmt(PuffinBasicParser.GetstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#fieldstmt}.
     *
     * @param ctx the parse tree
     */
    void enterFieldstmt(PuffinBasicParser.FieldstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#fieldstmt}.
     *
     * @param ctx the parse tree
     */
    void exitFieldstmt(PuffinBasicParser.FieldstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#inputstmt}.
     *
     * @param ctx the parse tree
     */
    void enterInputstmt(PuffinBasicParser.InputstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#inputstmt}.
     *
     * @param ctx the parse tree
     */
    void exitInputstmt(PuffinBasicParser.InputstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#inputhashstmt}.
     *
     * @param ctx the parse tree
     */
    void enterInputhashstmt(PuffinBasicParser.InputhashstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#inputhashstmt}.
     *
     * @param ctx the parse tree
     */
    void exitInputhashstmt(PuffinBasicParser.InputhashstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#lineinputstmt}.
     *
     * @param ctx the parse tree
     */
    void enterLineinputstmt(PuffinBasicParser.LineinputstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#lineinputstmt}.
     *
     * @param ctx the parse tree
     */
    void exitLineinputstmt(PuffinBasicParser.LineinputstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#lineinputhashstmt}.
     *
     * @param ctx the parse tree
     */
    void enterLineinputhashstmt(PuffinBasicParser.LineinputhashstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#lineinputhashstmt}.
     *
     * @param ctx the parse tree
     */
    void exitLineinputhashstmt(PuffinBasicParser.LineinputhashstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#readstmt}.
     *
     * @param ctx the parse tree
     */
    void enterReadstmt(PuffinBasicParser.ReadstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#readstmt}.
     *
     * @param ctx the parse tree
     */
    void exitReadstmt(PuffinBasicParser.ReadstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#datastmt}.
     *
     * @param ctx the parse tree
     */
    void enterDatastmt(PuffinBasicParser.DatastmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#datastmt}.
     *
     * @param ctx the parse tree
     */
    void exitDatastmt(PuffinBasicParser.DatastmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#restorestmt}.
     *
     * @param ctx the parse tree
     */
    void enterRestorestmt(PuffinBasicParser.RestorestmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#restorestmt}.
     *
     * @param ctx the parse tree
     */
    void exitRestorestmt(PuffinBasicParser.RestorestmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#randomizestmt}.
     *
     * @param ctx the parse tree
     */
    void enterRandomizestmt(PuffinBasicParser.RandomizestmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#randomizestmt}.
     *
     * @param ctx the parse tree
     */
    void exitRandomizestmt(PuffinBasicParser.RandomizestmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#randomizetimerstmt}.
     *
     * @param ctx the parse tree
     */
    void enterRandomizetimerstmt(PuffinBasicParser.RandomizetimerstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#randomizetimerstmt}.
     *
     * @param ctx the parse tree
     */
    void exitRandomizetimerstmt(PuffinBasicParser.RandomizetimerstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#defintstmt}.
     *
     * @param ctx the parse tree
     */
    void enterDefintstmt(PuffinBasicParser.DefintstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#defintstmt}.
     *
     * @param ctx the parse tree
     */
    void exitDefintstmt(PuffinBasicParser.DefintstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#deflngstmt}.
     *
     * @param ctx the parse tree
     */
    void enterDeflngstmt(PuffinBasicParser.DeflngstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#deflngstmt}.
     *
     * @param ctx the parse tree
     */
    void exitDeflngstmt(PuffinBasicParser.DeflngstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#defsngstmt}.
     *
     * @param ctx the parse tree
     */
    void enterDefsngstmt(PuffinBasicParser.DefsngstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#defsngstmt}.
     *
     * @param ctx the parse tree
     */
    void exitDefsngstmt(PuffinBasicParser.DefsngstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#defdblstmt}.
     *
     * @param ctx the parse tree
     */
    void enterDefdblstmt(PuffinBasicParser.DefdblstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#defdblstmt}.
     *
     * @param ctx the parse tree
     */
    void exitDefdblstmt(PuffinBasicParser.DefdblstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#defstrstmt}.
     *
     * @param ctx the parse tree
     */
    void enterDefstrstmt(PuffinBasicParser.DefstrstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#defstrstmt}.
     *
     * @param ctx the parse tree
     */
    void exitDefstrstmt(PuffinBasicParser.DefstrstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#middlrstmt}.
     *
     * @param ctx the parse tree
     */
    void enterMiddlrstmt(PuffinBasicParser.MiddlrstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#middlrstmt}.
     *
     * @param ctx the parse tree
     */
    void exitMiddlrstmt(PuffinBasicParser.MiddlrstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#sleepstmt}.
     *
     * @param ctx the parse tree
     */
    void enterSleepstmt(PuffinBasicParser.SleepstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#sleepstmt}.
     *
     * @param ctx the parse tree
     */
    void exitSleepstmt(PuffinBasicParser.SleepstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#screenstmt}.
     *
     * @param ctx the parse tree
     */
    void enterScreenstmt(PuffinBasicParser.ScreenstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#screenstmt}.
     *
     * @param ctx the parse tree
     */
    void exitScreenstmt(PuffinBasicParser.ScreenstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#repaintstmt}.
     *
     * @param ctx the parse tree
     */
    void enterRepaintstmt(PuffinBasicParser.RepaintstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#repaintstmt}.
     *
     * @param ctx the parse tree
     */
    void exitRepaintstmt(PuffinBasicParser.RepaintstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#circlestmt}.
     *
     * @param ctx the parse tree
     */
    void enterCirclestmt(PuffinBasicParser.CirclestmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#circlestmt}.
     *
     * @param ctx the parse tree
     */
    void exitCirclestmt(PuffinBasicParser.CirclestmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#linestmt}.
     *
     * @param ctx the parse tree
     */
    void enterLinestmt(PuffinBasicParser.LinestmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#linestmt}.
     *
     * @param ctx the parse tree
     */
    void exitLinestmt(PuffinBasicParser.LinestmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#colorstmt}.
     *
     * @param ctx the parse tree
     */
    void enterColorstmt(PuffinBasicParser.ColorstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#colorstmt}.
     *
     * @param ctx the parse tree
     */
    void exitColorstmt(PuffinBasicParser.ColorstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#paintstmt}.
     *
     * @param ctx the parse tree
     */
    void enterPaintstmt(PuffinBasicParser.PaintstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#paintstmt}.
     *
     * @param ctx the parse tree
     */
    void exitPaintstmt(PuffinBasicParser.PaintstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#psetstmt}.
     *
     * @param ctx the parse tree
     */
    void enterPsetstmt(PuffinBasicParser.PsetstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#psetstmt}.
     *
     * @param ctx the parse tree
     */
    void exitPsetstmt(PuffinBasicParser.PsetstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#drawstmt}.
     *
     * @param ctx the parse tree
     */
    void enterDrawstmt(PuffinBasicParser.DrawstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#drawstmt}.
     *
     * @param ctx the parse tree
     */
    void exitDrawstmt(PuffinBasicParser.DrawstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#graphicsgetstmt}.
     *
     * @param ctx the parse tree
     */
    void enterGraphicsgetstmt(PuffinBasicParser.GraphicsgetstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#graphicsgetstmt}.
     *
     * @param ctx the parse tree
     */
    void exitGraphicsgetstmt(PuffinBasicParser.GraphicsgetstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#graphicsputstmt}.
     *
     * @param ctx the parse tree
     */
    void enterGraphicsputstmt(PuffinBasicParser.GraphicsputstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#graphicsputstmt}.
     *
     * @param ctx the parse tree
     */
    void exitGraphicsputstmt(PuffinBasicParser.GraphicsputstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#graphicsbuffercopyhorstmt}.
     *
     * @param ctx the parse tree
     */
    void enterGraphicsbuffercopyhorstmt(PuffinBasicParser.GraphicsbuffercopyhorstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#graphicsbuffercopyhorstmt}.
     *
     * @param ctx the parse tree
     */
    void exitGraphicsbuffercopyhorstmt(PuffinBasicParser.GraphicsbuffercopyhorstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#fontstmt}.
     *
     * @param ctx the parse tree
     */
    void enterFontstmt(PuffinBasicParser.FontstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#fontstmt}.
     *
     * @param ctx the parse tree
     */
    void exitFontstmt(PuffinBasicParser.FontstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#drawstrstmt}.
     *
     * @param ctx the parse tree
     */
    void enterDrawstrstmt(PuffinBasicParser.DrawstrstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#drawstrstmt}.
     *
     * @param ctx the parse tree
     */
    void exitDrawstrstmt(PuffinBasicParser.DrawstrstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#loadimgstmt}.
     *
     * @param ctx the parse tree
     */
    void enterLoadimgstmt(PuffinBasicParser.LoadimgstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#loadimgstmt}.
     *
     * @param ctx the parse tree
     */
    void exitLoadimgstmt(PuffinBasicParser.LoadimgstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#saveimgstmt}.
     *
     * @param ctx the parse tree
     */
    void enterSaveimgstmt(PuffinBasicParser.SaveimgstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#saveimgstmt}.
     *
     * @param ctx the parse tree
     */
    void exitSaveimgstmt(PuffinBasicParser.SaveimgstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#clsstmt}.
     *
     * @param ctx the parse tree
     */
    void enterClsstmt(PuffinBasicParser.ClsstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#clsstmt}.
     *
     * @param ctx the parse tree
     */
    void exitClsstmt(PuffinBasicParser.ClsstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#beepstmt}.
     *
     * @param ctx the parse tree
     */
    void enterBeepstmt(PuffinBasicParser.BeepstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#beepstmt}.
     *
     * @param ctx the parse tree
     */
    void exitBeepstmt(PuffinBasicParser.BeepstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#arrayfillstmt}.
     *
     * @param ctx the parse tree
     */
    void enterArrayfillstmt(PuffinBasicParser.ArrayfillstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#arrayfillstmt}.
     *
     * @param ctx the parse tree
     */
    void exitArrayfillstmt(PuffinBasicParser.ArrayfillstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#arraycopystmt}.
     *
     * @param ctx the parse tree
     */
    void enterArraycopystmt(PuffinBasicParser.ArraycopystmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#arraycopystmt}.
     *
     * @param ctx the parse tree
     */
    void exitArraycopystmt(PuffinBasicParser.ArraycopystmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#array1dsortstmt}.
     *
     * @param ctx the parse tree
     */
    void enterArray1dsortstmt(PuffinBasicParser.Array1dsortstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#array1dsortstmt}.
     *
     * @param ctx the parse tree
     */
    void exitArray1dsortstmt(PuffinBasicParser.Array1dsortstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#array1dcopystmt}.
     *
     * @param ctx the parse tree
     */
    void enterArray1dcopystmt(PuffinBasicParser.Array1dcopystmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#array1dcopystmt}.
     *
     * @param ctx the parse tree
     */
    void exitArray1dcopystmt(PuffinBasicParser.Array1dcopystmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#array2dshifthorstmt}.
     *
     * @param ctx the parse tree
     */
    void enterArray2dshifthorstmt(PuffinBasicParser.Array2dshifthorstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#array2dshifthorstmt}.
     *
     * @param ctx the parse tree
     */
    void exitArray2dshifthorstmt(PuffinBasicParser.Array2dshifthorstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#array2dshiftverstmt}.
     *
     * @param ctx the parse tree
     */
    void enterArray2dshiftverstmt(PuffinBasicParser.Array2dshiftverstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#array2dshiftverstmt}.
     *
     * @param ctx the parse tree
     */
    void exitArray2dshiftverstmt(PuffinBasicParser.Array2dshiftverstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#loadwavstmt}.
     *
     * @param ctx the parse tree
     */
    void enterLoadwavstmt(PuffinBasicParser.LoadwavstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#loadwavstmt}.
     *
     * @param ctx the parse tree
     */
    void exitLoadwavstmt(PuffinBasicParser.LoadwavstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#playwavstmt}.
     *
     * @param ctx the parse tree
     */
    void enterPlaywavstmt(PuffinBasicParser.PlaywavstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#playwavstmt}.
     *
     * @param ctx the parse tree
     */
    void exitPlaywavstmt(PuffinBasicParser.PlaywavstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#stopwavstmt}.
     *
     * @param ctx the parse tree
     */
    void enterStopwavstmt(PuffinBasicParser.StopwavstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#stopwavstmt}.
     *
     * @param ctx the parse tree
     */
    void exitStopwavstmt(PuffinBasicParser.StopwavstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#loopwavstmt}.
     *
     * @param ctx the parse tree
     */
    void enterLoopwavstmt(PuffinBasicParser.LoopwavstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#loopwavstmt}.
     *
     * @param ctx the parse tree
     */
    void exitLoopwavstmt(PuffinBasicParser.LoopwavstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#labelstmt}.
     *
     * @param ctx the parse tree
     */
    void enterLabelstmt(PuffinBasicParser.LabelstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#labelstmt}.
     *
     * @param ctx the parse tree
     */
    void exitLabelstmt(PuffinBasicParser.LabelstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#liststmt}.
     *
     * @param ctx the parse tree
     */
    void enterListstmt(PuffinBasicParser.ListstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#liststmt}.
     *
     * @param ctx the parse tree
     */
    void exitListstmt(PuffinBasicParser.ListstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#dictstmt}.
     *
     * @param ctx the parse tree
     */
    void enterDictstmt(PuffinBasicParser.DictstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#dictstmt}.
     *
     * @param ctx the parse tree
     */
    void exitDictstmt(PuffinBasicParser.DictstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#setstmt}.
     *
     * @param ctx the parse tree
     */
    void enterSetstmt(PuffinBasicParser.SetstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#setstmt}.
     *
     * @param ctx the parse tree
     */
    void exitSetstmt(PuffinBasicParser.SetstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#structstmt}.
     *
     * @param ctx the parse tree
     */
    void enterStructstmt(PuffinBasicParser.StructstmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#structstmt}.
     *
     * @param ctx the parse tree
     */
    void exitStructstmt(PuffinBasicParser.StructstmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#compositetype}.
     *
     * @param ctx the parse tree
     */
    void enterCompositetype(PuffinBasicParser.CompositetypeContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#compositetype}.
     *
     * @param ctx the parse tree
     */
    void exitCompositetype(PuffinBasicParser.CompositetypeContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#structinstancestmt}.
     *
     * @param ctx the parse tree
     */
    void enterStructinstancestmt(PuffinBasicParser.StructinstancestmtContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#structinstancestmt}.
     *
     * @param ctx the parse tree
     */
    void exitStructinstancestmt(PuffinBasicParser.StructinstancestmtContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#string}.
     *
     * @param ctx the parse tree
     */
    void enterString(PuffinBasicParser.StringContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#string}.
     *
     * @param ctx the parse tree
     */
    void exitString(PuffinBasicParser.StringContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#number}.
     *
     * @param ctx the parse tree
     */
    void enterNumber(PuffinBasicParser.NumberContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#number}.
     *
     * @param ctx the parse tree
     */
    void exitNumber(PuffinBasicParser.NumberContext ctx);

    /**
     * Enter a parse tree produced by {@link PuffinBasicParser#integer}.
     *
     * @param ctx the parse tree
     */
    void enterInteger(PuffinBasicParser.IntegerContext ctx);

    /**
     * Exit a parse tree produced by {@link PuffinBasicParser#integer}.
     *
     * @param ctx the parse tree
     */
    void exitInteger(PuffinBasicParser.IntegerContext ctx);
}