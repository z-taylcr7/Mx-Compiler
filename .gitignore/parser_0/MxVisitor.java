package undecimber.compiler.frontend.parser;// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxParser#mxCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMxCode(MxParser.MxCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(MxParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#classConstructorDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassConstructorDef(MxParser.ClassConstructorDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(MxParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#funcDefArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDefArgs(MxParser.FuncDefArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#funcCallArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallArgs(MxParser.FuncCallArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#basicType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicType(MxParser.BasicTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#varDefType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefType(MxParser.VarDefTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#varDefObj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefObj(MxParser.VarDefObjContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#varDefSingle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefSingle(MxParser.VarDefSingleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#newExpSizeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpSizeDeclaration(MxParser.NewExpSizeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#pack}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPack(MxParser.PackContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(MxParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(MxParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#varDefStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefStmt(MxParser.VarDefStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(MxParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(MxParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(MxParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#packStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackStmt(MxParser.PackStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#controlStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlStmt(MxParser.ControlStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#pureStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPureStmt(MxParser.PureStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MxParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#prefixOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixOps(MxParser.PrefixOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#suffixOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffixOps(MxParser.SuffixOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#unaryOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOps(MxParser.UnaryOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#shiftOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftOps(MxParser.ShiftOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#supOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSupOps(MxParser.SupOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#infOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfOps(MxParser.InfOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#compareOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareOps(MxParser.CompareOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#equalOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualOps(MxParser.EqualOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#bitOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitOps(MxParser.BitOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#logicOps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOps(MxParser.LogicOpsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MxParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxParser#basicExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBasicExp(MxParser.BasicExpContext ctx);
}