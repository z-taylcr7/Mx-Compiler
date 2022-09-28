// Generated from C:/Users/Cristiano/IdeaProjects/Mx-Compiler/src/antlr\Mx.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxParser}.
 */
public interface MxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(MxParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(MxParser.AssignContext ctx);
}