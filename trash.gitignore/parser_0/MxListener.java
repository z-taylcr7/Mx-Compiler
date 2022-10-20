package undecimber.compiler.frontend.parser;// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#mxCode}.
	 * @param ctx the parse tree
	 */
	void enterMxCode(MxParser.MxCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#mxCode}.
	 * @param ctx the parse tree
	 */
	void exitMxCode(MxParser.MxCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#classConstructorDef}.
	 * @param ctx the parse tree
	 */
	void enterClassConstructorDef(MxParser.ClassConstructorDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#classConstructorDef}.
	 * @param ctx the parse tree
	 */
	void exitClassConstructorDef(MxParser.ClassConstructorDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#funcDefArgs}.
	 * @param ctx the parse tree
	 */
	void enterFuncDefArgs(MxParser.FuncDefArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#funcDefArgs}.
	 * @param ctx the parse tree
	 */
	void exitFuncDefArgs(MxParser.FuncDefArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#funcCallArgs}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallArgs(MxParser.FuncCallArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#funcCallArgs}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallArgs(MxParser.FuncCallArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#basicType}.
	 * @param ctx the parse tree
	 */
	void enterBasicType(MxParser.BasicTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#basicType}.
	 * @param ctx the parse tree
	 */
	void exitBasicType(MxParser.BasicTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#varDefType}.
	 * @param ctx the parse tree
	 */
	void enterVarDefType(MxParser.VarDefTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#varDefType}.
	 * @param ctx the parse tree
	 */
	void exitVarDefType(MxParser.VarDefTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#varDefObj}.
	 * @param ctx the parse tree
	 */
	void enterVarDefObj(MxParser.VarDefObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#varDefObj}.
	 * @param ctx the parse tree
	 */
	void exitVarDefObj(MxParser.VarDefObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#varDefSingle}.
	 * @param ctx the parse tree
	 */
	void enterVarDefSingle(MxParser.VarDefSingleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#varDefSingle}.
	 * @param ctx the parse tree
	 */
	void exitVarDefSingle(MxParser.VarDefSingleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#newExpSizeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNewExpSizeDeclaration(MxParser.NewExpSizeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#newExpSizeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNewExpSizeDeclaration(MxParser.NewExpSizeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#pack}.
	 * @param ctx the parse tree
	 */
	void enterPack(MxParser.PackContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#pack}.
	 * @param ctx the parse tree
	 */
	void exitPack(MxParser.PackContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(MxParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(MxParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#varDefStmt}.
	 * @param ctx the parse tree
	 */
	void enterVarDefStmt(MxParser.VarDefStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#varDefStmt}.
	 * @param ctx the parse tree
	 */
	void exitVarDefStmt(MxParser.VarDefStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(MxParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(MxParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(MxParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(MxParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#packStmt}.
	 * @param ctx the parse tree
	 */
	void enterPackStmt(MxParser.PackStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#packStmt}.
	 * @param ctx the parse tree
	 */
	void exitPackStmt(MxParser.PackStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void enterControlStmt(MxParser.ControlStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void exitControlStmt(MxParser.ControlStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#pureStmt}.
	 * @param ctx the parse tree
	 */
	void enterPureStmt(MxParser.PureStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#pureStmt}.
	 * @param ctx the parse tree
	 */
	void exitPureStmt(MxParser.PureStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MxParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MxParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#prefixOps}.
	 * @param ctx the parse tree
	 */
	void enterPrefixOps(MxParser.PrefixOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#prefixOps}.
	 * @param ctx the parse tree
	 */
	void exitPrefixOps(MxParser.PrefixOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#suffixOps}.
	 * @param ctx the parse tree
	 */
	void enterSuffixOps(MxParser.SuffixOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#suffixOps}.
	 * @param ctx the parse tree
	 */
	void exitSuffixOps(MxParser.SuffixOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#unaryOps}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOps(MxParser.UnaryOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#unaryOps}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOps(MxParser.UnaryOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#shiftOps}.
	 * @param ctx the parse tree
	 */
	void enterShiftOps(MxParser.ShiftOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#shiftOps}.
	 * @param ctx the parse tree
	 */
	void exitShiftOps(MxParser.ShiftOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#supOps}.
	 * @param ctx the parse tree
	 */
	void enterSupOps(MxParser.SupOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#supOps}.
	 * @param ctx the parse tree
	 */
	void exitSupOps(MxParser.SupOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#infOps}.
	 * @param ctx the parse tree
	 */
	void enterInfOps(MxParser.InfOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#infOps}.
	 * @param ctx the parse tree
	 */
	void exitInfOps(MxParser.InfOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#compareOps}.
	 * @param ctx the parse tree
	 */
	void enterCompareOps(MxParser.CompareOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#compareOps}.
	 * @param ctx the parse tree
	 */
	void exitCompareOps(MxParser.CompareOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#equalOps}.
	 * @param ctx the parse tree
	 */
	void enterEqualOps(MxParser.EqualOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#equalOps}.
	 * @param ctx the parse tree
	 */
	void exitEqualOps(MxParser.EqualOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#bitOps}.
	 * @param ctx the parse tree
	 */
	void enterBitOps(MxParser.BitOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#bitOps}.
	 * @param ctx the parse tree
	 */
	void exitBitOps(MxParser.BitOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#logicOps}.
	 * @param ctx the parse tree
	 */
	void enterLogicOps(MxParser.LogicOpsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#logicOps}.
	 * @param ctx the parse tree
	 */
	void exitLogicOps(MxParser.LogicOpsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MxParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MxParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxParser#basicExp}.
	 * @param ctx the parse tree
	 */
	void enterBasicExp(MxParser.BasicExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#basicExp}.
	 * @param ctx the parse tree
	 */
	void exitBasicExp(MxParser.BasicExpContext ctx);
}