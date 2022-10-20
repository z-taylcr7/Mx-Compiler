// Generated from java-escape by ANTLR 4.11.1
package undecimber.compiler.frontend.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Comment=1, SelfAdd=2, Add=3, SelfMinus=4, Minus=5, Multiply=6, Divide=7, 
		Mod=8, LogicAnd=9, LogicOr=10, LogicNegative=11, LeftShift=12, RightShift=13, 
		Greater=14, Less=15, Equal=16, GEQ=17, LEQ=18, NEQ=19, And=20, Or=21, 
		Xor=22, Negative=23, Assign=24, Object=25, LBracket=26, RBracket=27, LParen=28, 
		RParen=29, LBrace=30, RBrace=31, SemiColon=32, Comma=33, LambdaStart=34, 
		LambdaArrow=35, BoolType=36, IntType=37, StringType=38, VoidType=39, New=40, 
		Class=41, This=42, Null=43, True=44, False=45, If=46, Else=47, For=48, 
		While=49, Break=50, Continue=51, Return=52, WhiteSpace=53, NewLine=54, 
		ID=55, IntLiteral=56, BoolLiteral=57, EscapeEnter=58, EscapeBackslash=59, 
		EscapeQuote=60, StringContent=61, StringLiteral=62, NullLiteral=63;
	public static final int
		RULE_mxCode = 0, RULE_classDef = 1, RULE_classConstructorDef = 2, RULE_funcDef = 3, 
		RULE_funcDefArgs = 4, RULE_funcCallArgs = 5, RULE_basicType = 6, RULE_varDefType = 7, 
		RULE_varDefObj = 8, RULE_varDefSingle = 9, RULE_newExpSizeDeclaration = 10, 
		RULE_pack = 11, RULE_ifStmt = 12, RULE_whileStmt = 13, RULE_varDefStmt = 14, 
		RULE_forInit = 15, RULE_returnStmt = 16, RULE_forStmt = 17, RULE_packStmt = 18, 
		RULE_controlStmt = 19, RULE_pureStmt = 20, RULE_statement = 21, RULE_prefixOps = 22, 
		RULE_suffixOps = 23, RULE_unaryOps = 24, RULE_shiftOps = 25, RULE_supOps = 26, 
		RULE_infOps = 27, RULE_compareOps = 28, RULE_equalOps = 29, RULE_bitOps = 30, 
		RULE_logicOps = 31, RULE_expression = 32, RULE_basicExp = 33, RULE_parenExp = 34, 
		RULE_newExp = 35, RULE_arrayExp = 36, RULE_memberExp = 37, RULE_functionCallExp = 38, 
		RULE_lambdaExp = 39, RULE_prefixExp = 40, RULE_suffixExp = 41, RULE_unaryExp = 42, 
		RULE_binaryExp = 43, RULE_assignExp = 44, RULE_commaExp = 45;
	private static String[] makeRuleNames() {
		return new String[] {
			"mxCode", "classDef", "classConstructorDef", "funcDef", "funcDefArgs", 
			"funcCallArgs", "basicType", "varDefType", "varDefObj", "varDefSingle", 
			"newExpSizeDeclaration", "pack", "ifStmt", "whileStmt", "varDefStmt", 
			"forInit", "returnStmt", "forStmt", "packStmt", "controlStmt", "pureStmt", 
			"statement", "prefixOps", "suffixOps", "unaryOps", "shiftOps", "supOps", 
			"infOps", "compareOps", "equalOps", "bitOps", "logicOps", "expression", 
			"basicExp", "parenExp", "newExp", "arrayExp", "memberExp", "functionCallExp", 
			"lambdaExp", "prefixExp", "suffixExp", "unaryExp", "binaryExp", "assignExp", 
			"commaExp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'++'", "'+'", "'--'", "'-'", "'*'", "'/'", "'%'", "'&&'", 
			"'||'", "'!'", "'<<'", "'>>'", "'>'", "'<'", "'=='", "'>='", "'<='", 
			"'!='", "'&'", "'|'", "'^'", "'~'", "'='", "'.'", "'['", "']'", "'('", 
			"')'", "'{'", "'}'", "';'", "','", "'[&]'", "'->'", "'bool'", "'int'", 
			"'string'", "'void'", "'new'", "'class'", "'this'", "'null'", "'true'", 
			"'false'", "'if'", "'else'", "'for'", "'while'", "'break'", "'continue'", 
			"'return'", null, null, null, null, null, "'\\n'", "'\\\\'", "'\\\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Comment", "SelfAdd", "Add", "SelfMinus", "Minus", "Multiply", 
			"Divide", "Mod", "LogicAnd", "LogicOr", "LogicNegative", "LeftShift", 
			"RightShift", "Greater", "Less", "Equal", "GEQ", "LEQ", "NEQ", "And", 
			"Or", "Xor", "Negative", "Assign", "Object", "LBracket", "RBracket", 
			"LParen", "RParen", "LBrace", "RBrace", "SemiColon", "Comma", "LambdaStart", 
			"LambdaArrow", "BoolType", "IntType", "StringType", "VoidType", "New", 
			"Class", "This", "Null", "True", "False", "If", "Else", "For", "While", 
			"Break", "Continue", "Return", "WhiteSpace", "NewLine", "ID", "IntLiteral", 
			"BoolLiteral", "EscapeEnter", "EscapeBackslash", "EscapeQuote", "StringContent", 
			"StringLiteral", "NullLiteral"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MxCodeContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MxParser.EOF, 0); }
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<ClassDefContext> classDef() {
			return getRuleContexts(ClassDefContext.class);
		}
		public ClassDefContext classDef(int i) {
			return getRuleContext(ClassDefContext.class,i);
		}
		public List<VarDefStmtContext> varDefStmt() {
			return getRuleContexts(VarDefStmtContext.class);
		}
		public VarDefStmtContext varDefStmt(int i) {
			return getRuleContext(VarDefStmtContext.class,i);
		}
		public MxCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mxCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterMxCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitMxCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitMxCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MxCodeContext mxCode() throws RecognitionException {
		MxCodeContext _localctx = new MxCodeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_mxCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 36032026834370560L) != 0) {
				{
				setState(95);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(92);
					funcDef();
					}
					break;
				case 2:
					{
					setState(93);
					classDef();
					}
					break;
				case 3:
					{
					setState(94);
					varDefStmt();
					}
					break;
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDefContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(MxParser.Class, 0); }
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public TerminalNode LBrace() { return getToken(MxParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(MxParser.RBrace, 0); }
		public TerminalNode SemiColon() { return getToken(MxParser.SemiColon, 0); }
		public List<VarDefStmtContext> varDefStmt() {
			return getRuleContexts(VarDefStmtContext.class);
		}
		public VarDefStmtContext varDefStmt(int i) {
			return getRuleContext(VarDefStmtContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<ClassConstructorDefContext> classConstructorDef() {
			return getRuleContexts(ClassConstructorDefContext.class);
		}
		public ClassConstructorDefContext classConstructorDef(int i) {
			return getRuleContext(ClassConstructorDefContext.class,i);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(Class);
			setState(103);
			match(ID);
			setState(104);
			match(LBrace);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 36029827811115008L) != 0) {
				{
				setState(108);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(105);
					varDefStmt();
					}
					break;
				case 2:
					{
					setState(106);
					funcDef();
					}
					break;
				case 3:
					{
					setState(107);
					classConstructorDef();
					}
					break;
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			match(RBrace);
			setState(114);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassConstructorDefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public PackContext pack() {
			return getRuleContext(PackContext.class,0);
		}
		public ClassConstructorDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classConstructorDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterClassConstructorDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitClassConstructorDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitClassConstructorDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassConstructorDefContext classConstructorDef() throws RecognitionException {
		ClassConstructorDefContext _localctx = new ClassConstructorDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classConstructorDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(ID);
			setState(117);
			match(LParen);
			setState(118);
			match(RParen);
			setState(119);
			pack();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefContext extends ParserRuleContext {
		public VarDefTypeContext varDefType() {
			return getRuleContext(VarDefTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public PackContext pack() {
			return getRuleContext(PackContext.class,0);
		}
		public FuncDefArgsContext funcDefArgs() {
			return getRuleContext(FuncDefArgsContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			varDefType();
			setState(122);
			match(ID);
			setState(123);
			match(LParen);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 36029827811115008L) != 0) {
				{
				setState(124);
				funcDefArgs();
				}
			}

			setState(127);
			match(RParen);
			setState(128);
			pack();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefArgsContext extends ParserRuleContext {
		public List<VarDefTypeContext> varDefType() {
			return getRuleContexts(VarDefTypeContext.class);
		}
		public VarDefTypeContext varDefType(int i) {
			return getRuleContext(VarDefTypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(MxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MxParser.ID, i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public FuncDefArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDefArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFuncDefArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFuncDefArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFuncDefArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefArgsContext funcDefArgs() throws RecognitionException {
		FuncDefArgsContext _localctx = new FuncDefArgsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcDefArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			varDefType();
			setState(131);
			match(ID);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(132);
				match(Comma);
				setState(133);
				varDefType();
				setState(134);
				match(ID);
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallArgsContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public FuncCallArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCallArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFuncCallArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFuncCallArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFuncCallArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallArgsContext funcCallArgs() throws RecognitionException {
		FuncCallArgsContext _localctx = new FuncCallArgsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcCallArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(LParen);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4719839497150269500L) != 0) {
				{
				setState(142);
				expression(0);
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(143);
					match(Comma);
					setState(144);
					expression(0);
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(152);
			match(RParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BasicTypeContext extends ParserRuleContext {
		public TerminalNode BoolType() { return getToken(MxParser.BoolType, 0); }
		public TerminalNode IntType() { return getToken(MxParser.IntType, 0); }
		public TerminalNode StringType() { return getToken(MxParser.StringType, 0); }
		public TerminalNode VoidType() { return getToken(MxParser.VoidType, 0); }
		public BasicTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBasicType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBasicType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBasicType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicTypeContext basicType() throws RecognitionException {
		BasicTypeContext _localctx = new BasicTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_basicType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 1030792151040L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefTypeContext extends ParserRuleContext {
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public List<TerminalNode> LBracket() { return getTokens(MxParser.LBracket); }
		public TerminalNode LBracket(int i) {
			return getToken(MxParser.LBracket, i);
		}
		public List<TerminalNode> RBracket() { return getTokens(MxParser.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(MxParser.RBracket, i);
		}
		public VarDefTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVarDefType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVarDefType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVarDefType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefTypeContext varDefType() throws RecognitionException {
		VarDefTypeContext _localctx = new VarDefTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varDefType);
		int _la;
		try {
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				basicType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BoolType:
				case IntType:
				case StringType:
				case VoidType:
					{
					setState(158);
					basicType();
					}
					break;
				case ID:
					{
					setState(159);
					match(ID);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBracket) {
					{
					{
					setState(162);
					match(LBracket);
					setState(163);
					match(RBracket);
					}
					}
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefObjContext extends ParserRuleContext {
		public VarDefTypeContext varDefType() {
			return getRuleContext(VarDefTypeContext.class,0);
		}
		public List<VarDefSingleContext> varDefSingle() {
			return getRuleContexts(VarDefSingleContext.class);
		}
		public VarDefSingleContext varDefSingle(int i) {
			return getRuleContext(VarDefSingleContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxParser.Comma, i);
		}
		public VarDefObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefObj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVarDefObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVarDefObj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVarDefObj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefObjContext varDefObj() throws RecognitionException {
		VarDefObjContext _localctx = new VarDefObjContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varDefObj);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			varDefType();
			setState(172);
			varDefSingle();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(173);
				match(Comma);
				setState(174);
				varDefSingle();
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefSingleContext extends ParserRuleContext {
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDefSingleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefSingle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVarDefSingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVarDefSingle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVarDefSingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefSingleContext varDefSingle() throws RecognitionException {
		VarDefSingleContext _localctx = new VarDefSingleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varDefSingle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BoolType:
			case IntType:
			case StringType:
			case VoidType:
				{
				setState(180);
				basicType();
				}
				break;
			case ID:
				{
				setState(181);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(184);
				match(Assign);
				setState(185);
				expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NewExpSizeDeclarationContext extends ParserRuleContext {
		public TerminalNode LBracket() { return getToken(MxParser.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(MxParser.RBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NewExpSizeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpSizeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewExpSizeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewExpSizeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewExpSizeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewExpSizeDeclarationContext newExpSizeDeclaration() throws RecognitionException {
		NewExpSizeDeclarationContext _localctx = new NewExpSizeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_newExpSizeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(LBracket);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4719839497150269500L) != 0) {
				{
				setState(189);
				expression(0);
				}
			}

			setState(192);
			match(RBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PackContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(MxParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(MxParser.RBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public PackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pack; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterPack(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitPack(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitPack(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackContext pack() throws RecognitionException {
		PackContext _localctx = new PackContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pack);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(LBrace);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4728636626333337660L) != 0) {
				{
				{
				setState(195);
				statement();
				}
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(201);
			match(RBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(MxParser.If, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(MxParser.Else, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(If);
			setState(204);
			match(LParen);
			setState(205);
			expression(0);
			setState(206);
			match(RParen);
			setState(207);
			statement();
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(208);
				match(Else);
				setState(209);
				statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(MxParser.While, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(While);
			setState(213);
			match(LParen);
			setState(214);
			expression(0);
			setState(215);
			match(RParen);
			{
			setState(216);
			statement();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefStmtContext extends ParserRuleContext {
		public VarDefObjContext varDefObj() {
			return getRuleContext(VarDefObjContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(MxParser.SemiColon, 0); }
		public VarDefStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterVarDefStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitVarDefStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitVarDefStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefStmtContext varDefStmt() throws RecognitionException {
		VarDefStmtContext _localctx = new VarDefStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_varDefStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			varDefObj();
			setState(219);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForInitContext extends ParserRuleContext {
		public VarDefObjContext varDefObj() {
			return getRuleContext(VarDefObjContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forInit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(221);
				varDefObj();
				}
				break;
			case 2:
				{
				setState(222);
				expression(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(MxParser.Return, 0); }
		public TerminalNode SemiColon() { return getToken(MxParser.SemiColon, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(Return);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4719839497150269500L) != 0) {
				{
				setState(226);
				expression(0);
				}
			}

			setState(229);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends ParserRuleContext {
		public ExpressionContext forCond;
		public ExpressionContext forIncr;
		public TerminalNode For() { return getToken(MxParser.For, 0); }
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public List<TerminalNode> SemiColon() { return getTokens(MxParser.SemiColon); }
		public TerminalNode SemiColon(int i) {
			return getToken(MxParser.SemiColon, i);
		}
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(For);
			setState(232);
			match(LParen);
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4719840527942420540L) != 0) {
				{
				setState(233);
				forInit();
				}
			}

			setState(236);
			match(SemiColon);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4719839497150269500L) != 0) {
				{
				setState(237);
				((ForStmtContext)_localctx).forCond = expression(0);
				}
			}

			setState(240);
			match(SemiColon);
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4719839497150269500L) != 0) {
				{
				setState(241);
				((ForStmtContext)_localctx).forIncr = expression(0);
				}
			}

			setState(244);
			match(RParen);
			{
			setState(245);
			statement();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PackStmtContext extends ParserRuleContext {
		public PackContext pack() {
			return getRuleContext(PackContext.class,0);
		}
		public PackStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterPackStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitPackStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitPackStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackStmtContext packStmt() throws RecognitionException {
		PackStmtContext _localctx = new PackStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_packStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			pack();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ControlStmtContext extends ParserRuleContext {
		public TerminalNode SemiColon() { return getToken(MxParser.SemiColon, 0); }
		public TerminalNode Break() { return getToken(MxParser.Break, 0); }
		public TerminalNode Continue() { return getToken(MxParser.Continue, 0); }
		public ControlStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterControlStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitControlStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitControlStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ControlStmtContext controlStmt() throws RecognitionException {
		ControlStmtContext _localctx = new ControlStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_controlStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_la = _input.LA(1);
			if ( !(_la==Break || _la==Continue) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(250);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PureStmtContext extends ParserRuleContext {
		public TerminalNode SemiColon() { return getToken(MxParser.SemiColon, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PureStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pureStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterPureStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitPureStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitPureStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PureStmtContext pureStmt() throws RecognitionException {
		PureStmtContext _localctx = new PureStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_pureStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4719839497150269500L) != 0) {
				{
				setState(252);
				expression(0);
				}
			}

			setState(255);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public PackStmtContext packStmt() {
			return getRuleContext(PackStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public ControlStmtContext controlStmt() {
			return getRuleContext(ControlStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public VarDefStmtContext varDefStmt() {
			return getRuleContext(VarDefStmtContext.class,0);
		}
		public PureStmtContext pureStmt() {
			return getRuleContext(PureStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_statement);
		try {
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				packStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				ifStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(259);
				whileStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(260);
				forStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(261);
				controlStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(262);
				returnStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(263);
				varDefStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(264);
				pureStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrefixOpsContext extends ParserRuleContext {
		public TerminalNode SelfAdd() { return getToken(MxParser.SelfAdd, 0); }
		public TerminalNode SelfMinus() { return getToken(MxParser.SelfMinus, 0); }
		public PrefixOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterPrefixOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitPrefixOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitPrefixOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixOpsContext prefixOps() throws RecognitionException {
		PrefixOpsContext _localctx = new PrefixOpsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_prefixOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			_la = _input.LA(1);
			if ( !(_la==SelfAdd || _la==SelfMinus) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SuffixOpsContext extends ParserRuleContext {
		public TerminalNode SelfAdd() { return getToken(MxParser.SelfAdd, 0); }
		public TerminalNode SelfMinus() { return getToken(MxParser.SelfMinus, 0); }
		public SuffixOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suffixOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSuffixOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSuffixOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSuffixOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuffixOpsContext suffixOps() throws RecognitionException {
		SuffixOpsContext _localctx = new SuffixOpsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_suffixOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			_la = _input.LA(1);
			if ( !(_la==SelfAdd || _la==SelfMinus) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOpsContext extends ParserRuleContext {
		public TerminalNode LogicNegative() { return getToken(MxParser.LogicNegative, 0); }
		public TerminalNode Negative() { return getToken(MxParser.Negative, 0); }
		public TerminalNode Add() { return getToken(MxParser.Add, 0); }
		public TerminalNode Minus() { return getToken(MxParser.Minus, 0); }
		public UnaryOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterUnaryOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitUnaryOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitUnaryOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOpsContext unaryOps() throws RecognitionException {
		UnaryOpsContext _localctx = new UnaryOpsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_unaryOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 8390696L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ShiftOpsContext extends ParserRuleContext {
		public TerminalNode LeftShift() { return getToken(MxParser.LeftShift, 0); }
		public TerminalNode RightShift() { return getToken(MxParser.RightShift, 0); }
		public ShiftOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterShiftOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitShiftOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitShiftOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShiftOpsContext shiftOps() throws RecognitionException {
		ShiftOpsContext _localctx = new ShiftOpsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_shiftOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_la = _input.LA(1);
			if ( !(_la==LeftShift || _la==RightShift) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SupOpsContext extends ParserRuleContext {
		public TerminalNode Multiply() { return getToken(MxParser.Multiply, 0); }
		public TerminalNode Divide() { return getToken(MxParser.Divide, 0); }
		public TerminalNode Mod() { return getToken(MxParser.Mod, 0); }
		public SupOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_supOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSupOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSupOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSupOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SupOpsContext supOps() throws RecognitionException {
		SupOpsContext _localctx = new SupOpsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_supOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 448L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InfOpsContext extends ParserRuleContext {
		public TerminalNode Add() { return getToken(MxParser.Add, 0); }
		public TerminalNode Minus() { return getToken(MxParser.Minus, 0); }
		public InfOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterInfOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitInfOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitInfOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InfOpsContext infOps() throws RecognitionException {
		InfOpsContext _localctx = new InfOpsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_infOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_la = _input.LA(1);
			if ( !(_la==Add || _la==Minus) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompareOpsContext extends ParserRuleContext {
		public TerminalNode Greater() { return getToken(MxParser.Greater, 0); }
		public TerminalNode Less() { return getToken(MxParser.Less, 0); }
		public TerminalNode GEQ() { return getToken(MxParser.GEQ, 0); }
		public TerminalNode LEQ() { return getToken(MxParser.LEQ, 0); }
		public CompareOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterCompareOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitCompareOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitCompareOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompareOpsContext compareOps() throws RecognitionException {
		CompareOpsContext _localctx = new CompareOpsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_compareOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 442368L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualOpsContext extends ParserRuleContext {
		public TerminalNode NEQ() { return getToken(MxParser.NEQ, 0); }
		public TerminalNode Equal() { return getToken(MxParser.Equal, 0); }
		public EqualOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterEqualOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitEqualOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitEqualOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualOpsContext equalOps() throws RecognitionException {
		EqualOpsContext _localctx = new EqualOpsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_equalOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_la = _input.LA(1);
			if ( !(_la==Equal || _la==NEQ) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BitOpsContext extends ParserRuleContext {
		public TerminalNode Or() { return getToken(MxParser.Or, 0); }
		public TerminalNode Xor() { return getToken(MxParser.Xor, 0); }
		public TerminalNode And() { return getToken(MxParser.And, 0); }
		public BitOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBitOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBitOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBitOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitOpsContext bitOps() throws RecognitionException {
		BitOpsContext _localctx = new BitOpsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_bitOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicOpsContext extends ParserRuleContext {
		public TerminalNode LogicAnd() { return getToken(MxParser.LogicAnd, 0); }
		public TerminalNode LogicOr() { return getToken(MxParser.LogicOr, 0); }
		public LogicOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterLogicOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitLogicOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitLogicOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicOpsContext logicOps() throws RecognitionException {
		LogicOpsContext _localctx = new LogicOpsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_logicOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			_la = _input.LA(1);
			if ( !(_la==LogicAnd || _la==LogicOr) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public BasicExpContext basicExp() {
			return getRuleContext(BasicExpContext.class,0);
		}
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public List<NewExpSizeDeclarationContext> newExpSizeDeclaration() {
			return getRuleContexts(NewExpSizeDeclarationContext.class);
		}
		public NewExpSizeDeclarationContext newExpSizeDeclaration(int i) {
			return getRuleContext(NewExpSizeDeclarationContext.class,i);
		}
		public TerminalNode LambdaStart() { return getToken(MxParser.LambdaStart, 0); }
		public TerminalNode LambdaArrow() { return getToken(MxParser.LambdaArrow, 0); }
		public PackContext pack() {
			return getRuleContext(PackContext.class,0);
		}
		public FuncCallArgsContext funcCallArgs() {
			return getRuleContext(FuncCallArgsContext.class,0);
		}
		public FuncDefArgsContext funcDefArgs() {
			return getRuleContext(FuncDefArgsContext.class,0);
		}
		public PrefixOpsContext prefixOps() {
			return getRuleContext(PrefixOpsContext.class,0);
		}
		public UnaryOpsContext unaryOps() {
			return getRuleContext(UnaryOpsContext.class,0);
		}
		public InfOpsContext infOps() {
			return getRuleContext(InfOpsContext.class,0);
		}
		public SupOpsContext supOps() {
			return getRuleContext(SupOpsContext.class,0);
		}
		public ShiftOpsContext shiftOps() {
			return getRuleContext(ShiftOpsContext.class,0);
		}
		public CompareOpsContext compareOps() {
			return getRuleContext(CompareOpsContext.class,0);
		}
		public EqualOpsContext equalOps() {
			return getRuleContext(EqualOpsContext.class,0);
		}
		public LogicOpsContext logicOps() {
			return getRuleContext(LogicOpsContext.class,0);
		}
		public BitOpsContext bitOps() {
			return getRuleContext(BitOpsContext.class,0);
		}
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public TerminalNode Comma() { return getToken(MxParser.Comma, 0); }
		public TerminalNode LBracket() { return getToken(MxParser.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(MxParser.RBracket, 0); }
		public TerminalNode Object() { return getToken(MxParser.Object, 0); }
		public SuffixOpsContext suffixOps() {
			return getRuleContext(SuffixOpsContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case This:
			case Null:
			case True:
			case False:
			case ID:
			case IntLiteral:
			case StringLiteral:
				{
				setState(288);
				basicExp();
				}
				break;
			case LParen:
				{
				setState(289);
				match(LParen);
				setState(290);
				expression(0);
				setState(291);
				match(RParen);
				}
				break;
			case New:
				{
				setState(293);
				match(New);
				setState(296);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(294);
					match(ID);
					}
					break;
				case BoolType:
				case IntType:
				case StringType:
				case VoidType:
					{
					setState(295);
					basicType();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(301);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(298);
						newExpSizeDeclaration();
						}
						} 
					}
					setState(303);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				}
				setState(306);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(304);
					match(LParen);
					setState(305);
					match(RParen);
					}
					break;
				}
				}
				break;
			case LambdaStart:
				{
				setState(308);
				match(LambdaStart);
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LParen) {
					{
					setState(309);
					match(LParen);
					setState(311);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((_la) & ~0x3f) == 0 && ((1L << _la) & 36029827811115008L) != 0) {
						{
						setState(310);
						funcDefArgs();
						}
					}

					setState(313);
					match(RParen);
					}
				}

				setState(316);
				match(LambdaArrow);
				setState(317);
				pack();
				setState(318);
				funcCallArgs();
				}
				break;
			case SelfAdd:
			case SelfMinus:
				{
				setState(320);
				prefixOps();
				setState(321);
				expression(11);
				}
				break;
			case Add:
			case Minus:
			case LogicNegative:
			case Negative:
				{
				setState(323);
				unaryOps();
				setState(324);
				expression(10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(376);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(374);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(328);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(329);
						infOps();
						setState(330);
						expression(10);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(332);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(333);
						supOps();
						setState(334);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(336);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(337);
						shiftOps();
						setState(338);
						expression(8);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(340);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(341);
						compareOps();
						setState(342);
						expression(7);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(344);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(345);
						equalOps();
						setState(346);
						expression(6);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(348);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(349);
						logicOps();
						setState(350);
						expression(5);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(352);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(353);
						bitOps();
						setState(354);
						expression(4);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(356);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(357);
						match(Assign);
						setState(358);
						expression(2);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(359);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(360);
						match(Comma);
						setState(361);
						expression(2);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(362);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(363);
						match(LBracket);
						setState(364);
						expression(0);
						setState(365);
						match(RBracket);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(367);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(368);
						match(Object);
						setState(369);
						match(ID);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(370);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(371);
						funcCallArgs();
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(372);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(373);
						suffixOps();
						}
						break;
					}
					} 
				}
				setState(378);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BasicExpContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public TerminalNode True() { return getToken(MxParser.True, 0); }
		public TerminalNode False() { return getToken(MxParser.False, 0); }
		public TerminalNode This() { return getToken(MxParser.This, 0); }
		public TerminalNode IntLiteral() { return getToken(MxParser.IntLiteral, 0); }
		public TerminalNode StringLiteral() { return getToken(MxParser.StringLiteral, 0); }
		public TerminalNode Null() { return getToken(MxParser.Null, 0); }
		public BasicExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBasicExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBasicExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBasicExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BasicExpContext basicExp() throws RecognitionException {
		BasicExpContext _localctx = new BasicExpContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_basicExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 4719838380181946368L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParenExpContext extends ParserRuleContext {
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public ParenExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterParenExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitParenExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitParenExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenExpContext parenExp() throws RecognitionException {
		ParenExpContext _localctx = new ParenExpContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_parenExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(LParen);
			setState(382);
			expression(0);
			setState(383);
			match(RParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NewExpContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(MxParser.New, 0); }
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public List<NewExpSizeDeclarationContext> newExpSizeDeclaration() {
			return getRuleContexts(NewExpSizeDeclarationContext.class);
		}
		public NewExpSizeDeclarationContext newExpSizeDeclaration(int i) {
			return getRuleContext(NewExpSizeDeclarationContext.class,i);
		}
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public NewExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterNewExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitNewExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitNewExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewExpContext newExp() throws RecognitionException {
		NewExpContext _localctx = new NewExpContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_newExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			match(New);
			setState(388);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(386);
				match(ID);
				}
				break;
			case BoolType:
			case IntType:
			case StringType:
			case VoidType:
				{
				setState(387);
				basicType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBracket) {
				{
				{
				setState(390);
				newExpSizeDeclaration();
				}
				}
				setState(395);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(398);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LParen) {
				{
				setState(396);
				match(LParen);
				setState(397);
				match(RParen);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayExpContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LBracket() { return getToken(MxParser.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(MxParser.RBracket, 0); }
		public ArrayExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterArrayExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitArrayExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitArrayExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayExpContext arrayExp() throws RecognitionException {
		ArrayExpContext _localctx = new ArrayExpContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_arrayExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			expression(0);
			setState(401);
			match(LBracket);
			setState(402);
			expression(0);
			setState(403);
			match(RBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MemberExpContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Object() { return getToken(MxParser.Object, 0); }
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public MemberExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterMemberExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitMemberExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitMemberExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberExpContext memberExp() throws RecognitionException {
		MemberExpContext _localctx = new MemberExpContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_memberExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			expression(0);
			setState(406);
			match(Object);
			setState(407);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallExpContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FuncCallArgsContext funcCallArgs() {
			return getRuleContext(FuncCallArgsContext.class,0);
		}
		public FunctionCallExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterFunctionCallExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitFunctionCallExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitFunctionCallExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallExpContext functionCallExp() throws RecognitionException {
		FunctionCallExpContext _localctx = new FunctionCallExpContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_functionCallExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			expression(0);
			setState(410);
			funcCallArgs();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaExpContext extends ParserRuleContext {
		public TerminalNode LambdaStart() { return getToken(MxParser.LambdaStart, 0); }
		public TerminalNode LambdaArrow() { return getToken(MxParser.LambdaArrow, 0); }
		public PackContext pack() {
			return getRuleContext(PackContext.class,0);
		}
		public FuncCallArgsContext funcCallArgs() {
			return getRuleContext(FuncCallArgsContext.class,0);
		}
		public TerminalNode LParen() { return getToken(MxParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(MxParser.RParen, 0); }
		public FuncDefArgsContext funcDefArgs() {
			return getRuleContext(FuncDefArgsContext.class,0);
		}
		public LambdaExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterLambdaExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitLambdaExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitLambdaExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaExpContext lambdaExp() throws RecognitionException {
		LambdaExpContext _localctx = new LambdaExpContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_lambdaExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			match(LambdaStart);
			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LParen) {
				{
				setState(413);
				match(LParen);
				setState(415);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 36029827811115008L) != 0) {
					{
					setState(414);
					funcDefArgs();
					}
				}

				setState(417);
				match(RParen);
				}
			}

			setState(420);
			match(LambdaArrow);
			setState(421);
			pack();
			setState(422);
			funcCallArgs();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrefixExpContext extends ParserRuleContext {
		public PrefixOpsContext prefixOps() {
			return getRuleContext(PrefixOpsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrefixExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterPrefixExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitPrefixExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitPrefixExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixExpContext prefixExp() throws RecognitionException {
		PrefixExpContext _localctx = new PrefixExpContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_prefixExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			prefixOps();
			setState(425);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SuffixExpContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SuffixOpsContext suffixOps() {
			return getRuleContext(SuffixOpsContext.class,0);
		}
		public SuffixExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suffixExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterSuffixExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitSuffixExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitSuffixExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuffixExpContext suffixExp() throws RecognitionException {
		SuffixExpContext _localctx = new SuffixExpContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_suffixExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			expression(0);
			setState(428);
			suffixOps();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExpContext extends ParserRuleContext {
		public UnaryOpsContext unaryOps() {
			return getRuleContext(UnaryOpsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterUnaryExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitUnaryExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitUnaryExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpContext unaryExp() throws RecognitionException {
		UnaryExpContext _localctx = new UnaryExpContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_unaryExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			unaryOps();
			setState(431);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BinaryExpContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public InfOpsContext infOps() {
			return getRuleContext(InfOpsContext.class,0);
		}
		public SupOpsContext supOps() {
			return getRuleContext(SupOpsContext.class,0);
		}
		public ShiftOpsContext shiftOps() {
			return getRuleContext(ShiftOpsContext.class,0);
		}
		public CompareOpsContext compareOps() {
			return getRuleContext(CompareOpsContext.class,0);
		}
		public EqualOpsContext equalOps() {
			return getRuleContext(EqualOpsContext.class,0);
		}
		public LogicOpsContext logicOps() {
			return getRuleContext(LogicOpsContext.class,0);
		}
		public BitOpsContext bitOps() {
			return getRuleContext(BitOpsContext.class,0);
		}
		public BinaryExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterBinaryExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitBinaryExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitBinaryExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryExpContext binaryExp() throws RecognitionException {
		BinaryExpContext _localctx = new BinaryExpContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_binaryExp);
		try {
			setState(461);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(433);
				expression(0);
				setState(434);
				infOps();
				setState(435);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(437);
				expression(0);
				setState(438);
				supOps();
				setState(439);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(441);
				expression(0);
				setState(442);
				shiftOps();
				setState(443);
				expression(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(445);
				expression(0);
				setState(446);
				compareOps();
				setState(447);
				expression(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(449);
				expression(0);
				setState(450);
				equalOps();
				setState(451);
				expression(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(453);
				expression(0);
				setState(454);
				logicOps();
				setState(455);
				expression(0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(457);
				expression(0);
				setState(458);
				bitOps();
				setState(459);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignExpContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public AssignExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAssignExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAssignExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAssignExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignExpContext assignExp() throws RecognitionException {
		AssignExpContext _localctx = new AssignExpContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_assignExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			expression(0);
			setState(464);
			match(Assign);
			setState(465);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommaExpContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Comma() { return getToken(MxParser.Comma, 0); }
		public CommaExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commaExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterCommaExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitCommaExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitCommaExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommaExpContext commaExp() throws RecognitionException {
		CommaExpContext _localctx = new CommaExpContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_commaExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			expression(0);
			setState(468);
			match(Comma);
			setState(469);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 32:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 1);
		case 9:
			return precpred(_ctx, 16);
		case 10:
			return precpred(_ctx, 15);
		case 11:
			return precpred(_ctx, 14);
		case 12:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001?\u01d8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000`\b\u0000\n\u0000"+
		"\f\u0000c\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001m\b\u0001\n\u0001"+
		"\f\u0001p\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003~\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004\u0089\b\u0004\n\u0004\f\u0004\u008c\t\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0092\b\u0005\n\u0005"+
		"\f\u0005\u0095\t\u0005\u0003\u0005\u0097\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\u00a1\b\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00a5\b"+
		"\u0007\n\u0007\f\u0007\u00a8\t\u0007\u0003\u0007\u00aa\b\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0005\b\u00b0\b\b\n\b\f\b\u00b3\t\b\u0001\t\u0001"+
		"\t\u0003\t\u00b7\b\t\u0001\t\u0001\t\u0003\t\u00bb\b\t\u0001\n\u0001\n"+
		"\u0003\n\u00bf\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u00c5\b\u000b\n\u000b\f\u000b\u00c8\t\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00d3\b\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u00e0\b\u000f\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u00e4\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u00eb\b\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u00ef\b\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00f3\b\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0003\u0014\u00fe\b\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u010a\b\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f"+
		"\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0003 \u0129\b \u0001 \u0005 \u012c\b \n \f \u012f\t \u0001 \u0001 "+
		"\u0003 \u0133\b \u0001 \u0001 \u0001 \u0003 \u0138\b \u0001 \u0003 \u013b"+
		"\b \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0003 \u0147\b \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0005 \u0177"+
		"\b \n \f \u017a\t \u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"#\u0001#\u0001#\u0003#\u0185\b#\u0001#\u0005#\u0188\b#\n#\f#\u018b\t#"+
		"\u0001#\u0001#\u0003#\u018f\b#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0003"+
		"\'\u01a0\b\'\u0001\'\u0003\'\u01a3\b\'\u0001\'\u0001\'\u0001\'\u0001\'"+
		"\u0001(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001*\u0001*\u0001*\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0001+\u0003+\u01ce\b+\u0001"+
		",\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0001-\u0000\u0001"+
		"@.\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\u0000\f\u0001\u0000$\'\u0001"+
		"\u000023\u0002\u0000\u0002\u0002\u0004\u0004\u0004\u0000\u0003\u0003\u0005"+
		"\u0005\u000b\u000b\u0017\u0017\u0001\u0000\f\r\u0001\u0000\u0006\b\u0002"+
		"\u0000\u0003\u0003\u0005\u0005\u0002\u0000\u000e\u000f\u0011\u0012\u0002"+
		"\u0000\u0010\u0010\u0013\u0013\u0001\u0000\u0014\u0016\u0001\u0000\t\n"+
		"\u0003\u0000*-78>>\u01ec\u0000a\u0001\u0000\u0000\u0000\u0002f\u0001\u0000"+
		"\u0000\u0000\u0004t\u0001\u0000\u0000\u0000\u0006y\u0001\u0000\u0000\u0000"+
		"\b\u0082\u0001\u0000\u0000\u0000\n\u008d\u0001\u0000\u0000\u0000\f\u009a"+
		"\u0001\u0000\u0000\u0000\u000e\u00a9\u0001\u0000\u0000\u0000\u0010\u00ab"+
		"\u0001\u0000\u0000\u0000\u0012\u00b6\u0001\u0000\u0000\u0000\u0014\u00bc"+
		"\u0001\u0000\u0000\u0000\u0016\u00c2\u0001\u0000\u0000\u0000\u0018\u00cb"+
		"\u0001\u0000\u0000\u0000\u001a\u00d4\u0001\u0000\u0000\u0000\u001c\u00da"+
		"\u0001\u0000\u0000\u0000\u001e\u00df\u0001\u0000\u0000\u0000 \u00e1\u0001"+
		"\u0000\u0000\u0000\"\u00e7\u0001\u0000\u0000\u0000$\u00f7\u0001\u0000"+
		"\u0000\u0000&\u00f9\u0001\u0000\u0000\u0000(\u00fd\u0001\u0000\u0000\u0000"+
		"*\u0109\u0001\u0000\u0000\u0000,\u010b\u0001\u0000\u0000\u0000.\u010d"+
		"\u0001\u0000\u0000\u00000\u010f\u0001\u0000\u0000\u00002\u0111\u0001\u0000"+
		"\u0000\u00004\u0113\u0001\u0000\u0000\u00006\u0115\u0001\u0000\u0000\u0000"+
		"8\u0117\u0001\u0000\u0000\u0000:\u0119\u0001\u0000\u0000\u0000<\u011b"+
		"\u0001\u0000\u0000\u0000>\u011d\u0001\u0000\u0000\u0000@\u0146\u0001\u0000"+
		"\u0000\u0000B\u017b\u0001\u0000\u0000\u0000D\u017d\u0001\u0000\u0000\u0000"+
		"F\u0181\u0001\u0000\u0000\u0000H\u0190\u0001\u0000\u0000\u0000J\u0195"+
		"\u0001\u0000\u0000\u0000L\u0199\u0001\u0000\u0000\u0000N\u019c\u0001\u0000"+
		"\u0000\u0000P\u01a8\u0001\u0000\u0000\u0000R\u01ab\u0001\u0000\u0000\u0000"+
		"T\u01ae\u0001\u0000\u0000\u0000V\u01cd\u0001\u0000\u0000\u0000X\u01cf"+
		"\u0001\u0000\u0000\u0000Z\u01d3\u0001\u0000\u0000\u0000\\`\u0003\u0006"+
		"\u0003\u0000]`\u0003\u0002\u0001\u0000^`\u0003\u001c\u000e\u0000_\\\u0001"+
		"\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_^\u0001\u0000\u0000\u0000"+
		"`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000"+
		"\u0000bd\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000de\u0005\u0000"+
		"\u0000\u0001e\u0001\u0001\u0000\u0000\u0000fg\u0005)\u0000\u0000gh\u0005"+
		"7\u0000\u0000hn\u0005\u001e\u0000\u0000im\u0003\u001c\u000e\u0000jm\u0003"+
		"\u0006\u0003\u0000km\u0003\u0004\u0002\u0000li\u0001\u0000\u0000\u0000"+
		"lj\u0001\u0000\u0000\u0000lk\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000"+
		"\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000oq\u0001\u0000"+
		"\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u0005\u001f\u0000\u0000rs\u0005"+
		" \u0000\u0000s\u0003\u0001\u0000\u0000\u0000tu\u00057\u0000\u0000uv\u0005"+
		"\u001c\u0000\u0000vw\u0005\u001d\u0000\u0000wx\u0003\u0016\u000b\u0000"+
		"x\u0005\u0001\u0000\u0000\u0000yz\u0003\u000e\u0007\u0000z{\u00057\u0000"+
		"\u0000{}\u0005\u001c\u0000\u0000|~\u0003\b\u0004\u0000}|\u0001\u0000\u0000"+
		"\u0000}~\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0005\u001d\u0000\u0000\u0080\u0081\u0003\u0016\u000b\u0000\u0081"+
		"\u0007\u0001\u0000\u0000\u0000\u0082\u0083\u0003\u000e\u0007\u0000\u0083"+
		"\u008a\u00057\u0000\u0000\u0084\u0085\u0005!\u0000\u0000\u0085\u0086\u0003"+
		"\u000e\u0007\u0000\u0086\u0087\u00057\u0000\u0000\u0087\u0089\u0001\u0000"+
		"\u0000\u0000\u0088\u0084\u0001\u0000\u0000\u0000\u0089\u008c\u0001\u0000"+
		"\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000"+
		"\u0000\u0000\u008b\t\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000"+
		"\u0000\u008d\u0096\u0005\u001c\u0000\u0000\u008e\u0093\u0003@ \u0000\u008f"+
		"\u0090\u0005!\u0000\u0000\u0090\u0092\u0003@ \u0000\u0091\u008f\u0001"+
		"\u0000\u0000\u0000\u0092\u0095\u0001\u0000\u0000\u0000\u0093\u0091\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0097\u0001"+
		"\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u008e\u0001"+
		"\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0098\u0001"+
		"\u0000\u0000\u0000\u0098\u0099\u0005\u001d\u0000\u0000\u0099\u000b\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0007\u0000\u0000\u0000\u009b\r\u0001\u0000"+
		"\u0000\u0000\u009c\u00aa\u0003\f\u0006\u0000\u009d\u00aa\u00057\u0000"+
		"\u0000\u009e\u00a1\u0003\f\u0006\u0000\u009f\u00a1\u00057\u0000\u0000"+
		"\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a6\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005\u001a\u0000\u0000"+
		"\u00a3\u00a5\u0005\u001b\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9\u009c\u0001\u0000\u0000\u0000"+
		"\u00a9\u009d\u0001\u0000\u0000\u0000\u00a9\u00a0\u0001\u0000\u0000\u0000"+
		"\u00aa\u000f\u0001\u0000\u0000\u0000\u00ab\u00ac\u0003\u000e\u0007\u0000"+
		"\u00ac\u00b1\u0003\u0012\t\u0000\u00ad\u00ae\u0005!\u0000\u0000\u00ae"+
		"\u00b0\u0003\u0012\t\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b2\u0011\u0001\u0000\u0000\u0000\u00b3\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b7\u0003\f\u0006\u0000\u00b5\u00b7\u0005"+
		"7\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b7\u00ba\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005\u0018"+
		"\u0000\u0000\u00b9\u00bb\u0003@ \u0000\u00ba\u00b8\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u0013\u0001\u0000\u0000\u0000"+
		"\u00bc\u00be\u0005\u001a\u0000\u0000\u00bd\u00bf\u0003@ \u0000\u00be\u00bd"+
		"\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\u001b\u0000\u0000\u00c1\u0015"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c6\u0005\u001e\u0000\u0000\u00c3\u00c5"+
		"\u0003*\u0015\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c8\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c9\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c9\u00ca\u0005\u001f\u0000\u0000\u00ca\u0017\u0001"+
		"\u0000\u0000\u0000\u00cb\u00cc\u0005.\u0000\u0000\u00cc\u00cd\u0005\u001c"+
		"\u0000\u0000\u00cd\u00ce\u0003@ \u0000\u00ce\u00cf\u0005\u001d\u0000\u0000"+
		"\u00cf\u00d2\u0003*\u0015\u0000\u00d0\u00d1\u0005/\u0000\u0000\u00d1\u00d3"+
		"\u0003*\u0015\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d3\u0019\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005"+
		"1\u0000\u0000\u00d5\u00d6\u0005\u001c\u0000\u0000\u00d6\u00d7\u0003@ "+
		"\u0000\u00d7\u00d8\u0005\u001d\u0000\u0000\u00d8\u00d9\u0003*\u0015\u0000"+
		"\u00d9\u001b\u0001\u0000\u0000\u0000\u00da\u00db\u0003\u0010\b\u0000\u00db"+
		"\u00dc\u0005 \u0000\u0000\u00dc\u001d\u0001\u0000\u0000\u0000\u00dd\u00e0"+
		"\u0003\u0010\b\u0000\u00de\u00e0\u0003@ \u0000\u00df\u00dd\u0001\u0000"+
		"\u0000\u0000\u00df\u00de\u0001\u0000\u0000\u0000\u00e0\u001f\u0001\u0000"+
		"\u0000\u0000\u00e1\u00e3\u00054\u0000\u0000\u00e2\u00e4\u0003@ \u0000"+
		"\u00e3\u00e2\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005 \u0000\u0000\u00e6"+
		"!\u0001\u0000\u0000\u0000\u00e7\u00e8\u00050\u0000\u0000\u00e8\u00ea\u0005"+
		"\u001c\u0000\u0000\u00e9\u00eb\u0003\u001e\u000f\u0000\u00ea\u00e9\u0001"+
		"\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001"+
		"\u0000\u0000\u0000\u00ec\u00ee\u0005 \u0000\u0000\u00ed\u00ef\u0003@ "+
		"\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f2\u0005 \u0000\u0000"+
		"\u00f1\u00f3\u0003@ \u0000\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f2\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f5"+
		"\u0005\u001d\u0000\u0000\u00f5\u00f6\u0003*\u0015\u0000\u00f6#\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f8\u0003\u0016\u000b\u0000\u00f8%\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fa\u0007\u0001\u0000\u0000\u00fa\u00fb\u0005 \u0000\u0000"+
		"\u00fb\'\u0001\u0000\u0000\u0000\u00fc\u00fe\u0003@ \u0000\u00fd\u00fc"+
		"\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe\u00ff"+
		"\u0001\u0000\u0000\u0000\u00ff\u0100\u0005 \u0000\u0000\u0100)\u0001\u0000"+
		"\u0000\u0000\u0101\u010a\u0003$\u0012\u0000\u0102\u010a\u0003\u0018\f"+
		"\u0000\u0103\u010a\u0003\u001a\r\u0000\u0104\u010a\u0003\"\u0011\u0000"+
		"\u0105\u010a\u0003&\u0013\u0000\u0106\u010a\u0003 \u0010\u0000\u0107\u010a"+
		"\u0003\u001c\u000e\u0000\u0108\u010a\u0003(\u0014\u0000\u0109\u0101\u0001"+
		"\u0000\u0000\u0000\u0109\u0102\u0001\u0000\u0000\u0000\u0109\u0103\u0001"+
		"\u0000\u0000\u0000\u0109\u0104\u0001\u0000\u0000\u0000\u0109\u0105\u0001"+
		"\u0000\u0000\u0000\u0109\u0106\u0001\u0000\u0000\u0000\u0109\u0107\u0001"+
		"\u0000\u0000\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u010a+\u0001\u0000"+
		"\u0000\u0000\u010b\u010c\u0007\u0002\u0000\u0000\u010c-\u0001\u0000\u0000"+
		"\u0000\u010d\u010e\u0007\u0002\u0000\u0000\u010e/\u0001\u0000\u0000\u0000"+
		"\u010f\u0110\u0007\u0003\u0000\u0000\u01101\u0001\u0000\u0000\u0000\u0111"+
		"\u0112\u0007\u0004\u0000\u0000\u01123\u0001\u0000\u0000\u0000\u0113\u0114"+
		"\u0007\u0005\u0000\u0000\u01145\u0001\u0000\u0000\u0000\u0115\u0116\u0007"+
		"\u0006\u0000\u0000\u01167\u0001\u0000\u0000\u0000\u0117\u0118\u0007\u0007"+
		"\u0000\u0000\u01189\u0001\u0000\u0000\u0000\u0119\u011a\u0007\b\u0000"+
		"\u0000\u011a;\u0001\u0000\u0000\u0000\u011b\u011c\u0007\t\u0000\u0000"+
		"\u011c=\u0001\u0000\u0000\u0000\u011d\u011e\u0007\n\u0000\u0000\u011e"+
		"?\u0001\u0000\u0000\u0000\u011f\u0120\u0006 \uffff\uffff\u0000\u0120\u0147"+
		"\u0003B!\u0000\u0121\u0122\u0005\u001c\u0000\u0000\u0122\u0123\u0003@"+
		" \u0000\u0123\u0124\u0005\u001d\u0000\u0000\u0124\u0147\u0001\u0000\u0000"+
		"\u0000\u0125\u0128\u0005(\u0000\u0000\u0126\u0129\u00057\u0000\u0000\u0127"+
		"\u0129\u0003\f\u0006\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0128\u0127"+
		"\u0001\u0000\u0000\u0000\u0129\u012d\u0001\u0000\u0000\u0000\u012a\u012c"+
		"\u0003\u0014\n\u0000\u012b\u012a\u0001\u0000\u0000\u0000\u012c\u012f\u0001"+
		"\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d\u012e\u0001"+
		"\u0000\u0000\u0000\u012e\u0132\u0001\u0000\u0000\u0000\u012f\u012d\u0001"+
		"\u0000\u0000\u0000\u0130\u0131\u0005\u001c\u0000\u0000\u0131\u0133\u0005"+
		"\u001d\u0000\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0132\u0133\u0001"+
		"\u0000\u0000\u0000\u0133\u0147\u0001\u0000\u0000\u0000\u0134\u013a\u0005"+
		"\"\u0000\u0000\u0135\u0137\u0005\u001c\u0000\u0000\u0136\u0138\u0003\b"+
		"\u0004\u0000\u0137\u0136\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000"+
		"\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u013b\u0005\u001d"+
		"\u0000\u0000\u013a\u0135\u0001\u0000\u0000\u0000\u013a\u013b\u0001\u0000"+
		"\u0000\u0000\u013b\u013c\u0001\u0000\u0000\u0000\u013c\u013d\u0005#\u0000"+
		"\u0000\u013d\u013e\u0003\u0016\u000b\u0000\u013e\u013f\u0003\n\u0005\u0000"+
		"\u013f\u0147\u0001\u0000\u0000\u0000\u0140\u0141\u0003,\u0016\u0000\u0141"+
		"\u0142\u0003@ \u000b\u0142\u0147\u0001\u0000\u0000\u0000\u0143\u0144\u0003"+
		"0\u0018\u0000\u0144\u0145\u0003@ \n\u0145\u0147\u0001\u0000\u0000\u0000"+
		"\u0146\u011f\u0001\u0000\u0000\u0000\u0146\u0121\u0001\u0000\u0000\u0000"+
		"\u0146\u0125\u0001\u0000\u0000\u0000\u0146\u0134\u0001\u0000\u0000\u0000"+
		"\u0146\u0140\u0001\u0000\u0000\u0000\u0146\u0143\u0001\u0000\u0000\u0000"+
		"\u0147\u0178\u0001\u0000\u0000\u0000\u0148\u0149\n\t\u0000\u0000\u0149"+
		"\u014a\u00036\u001b\u0000\u014a\u014b\u0003@ \n\u014b\u0177\u0001\u0000"+
		"\u0000\u0000\u014c\u014d\n\b\u0000\u0000\u014d\u014e\u00034\u001a\u0000"+
		"\u014e\u014f\u0003@ \t\u014f\u0177\u0001\u0000\u0000\u0000\u0150\u0151"+
		"\n\u0007\u0000\u0000\u0151\u0152\u00032\u0019\u0000\u0152\u0153\u0003"+
		"@ \b\u0153\u0177\u0001\u0000\u0000\u0000\u0154\u0155\n\u0006\u0000\u0000"+
		"\u0155\u0156\u00038\u001c\u0000\u0156\u0157\u0003@ \u0007\u0157\u0177"+
		"\u0001\u0000\u0000\u0000\u0158\u0159\n\u0005\u0000\u0000\u0159\u015a\u0003"+
		":\u001d\u0000\u015a\u015b\u0003@ \u0006\u015b\u0177\u0001\u0000\u0000"+
		"\u0000\u015c\u015d\n\u0004\u0000\u0000\u015d\u015e\u0003>\u001f\u0000"+
		"\u015e\u015f\u0003@ \u0005\u015f\u0177\u0001\u0000\u0000\u0000\u0160\u0161"+
		"\n\u0003\u0000\u0000\u0161\u0162\u0003<\u001e\u0000\u0162\u0163\u0003"+
		"@ \u0004\u0163\u0177\u0001\u0000\u0000\u0000\u0164\u0165\n\u0002\u0000"+
		"\u0000\u0165\u0166\u0005\u0018\u0000\u0000\u0166\u0177\u0003@ \u0002\u0167"+
		"\u0168\n\u0001\u0000\u0000\u0168\u0169\u0005!\u0000\u0000\u0169\u0177"+
		"\u0003@ \u0002\u016a\u016b\n\u0010\u0000\u0000\u016b\u016c\u0005\u001a"+
		"\u0000\u0000\u016c\u016d\u0003@ \u0000\u016d\u016e\u0005\u001b\u0000\u0000"+
		"\u016e\u0177\u0001\u0000\u0000\u0000\u016f\u0170\n\u000f\u0000\u0000\u0170"+
		"\u0171\u0005\u0019\u0000\u0000\u0171\u0177\u00057\u0000\u0000\u0172\u0173"+
		"\n\u000e\u0000\u0000\u0173\u0177\u0003\n\u0005\u0000\u0174\u0175\n\f\u0000"+
		"\u0000\u0175\u0177\u0003.\u0017\u0000\u0176\u0148\u0001\u0000\u0000\u0000"+
		"\u0176\u014c\u0001\u0000\u0000\u0000\u0176\u0150\u0001\u0000\u0000\u0000"+
		"\u0176\u0154\u0001\u0000\u0000\u0000\u0176\u0158\u0001\u0000\u0000\u0000"+
		"\u0176\u015c\u0001\u0000\u0000\u0000\u0176\u0160\u0001\u0000\u0000\u0000"+
		"\u0176\u0164\u0001\u0000\u0000\u0000\u0176\u0167\u0001\u0000\u0000\u0000"+
		"\u0176\u016a\u0001\u0000\u0000\u0000\u0176\u016f\u0001\u0000\u0000\u0000"+
		"\u0176\u0172\u0001\u0000\u0000\u0000\u0176\u0174\u0001\u0000\u0000\u0000"+
		"\u0177\u017a\u0001\u0000\u0000\u0000\u0178\u0176\u0001\u0000\u0000\u0000"+
		"\u0178\u0179\u0001\u0000\u0000\u0000\u0179A\u0001\u0000\u0000\u0000\u017a"+
		"\u0178\u0001\u0000\u0000\u0000\u017b\u017c\u0007\u000b\u0000\u0000\u017c"+
		"C\u0001\u0000\u0000\u0000\u017d\u017e\u0005\u001c\u0000\u0000\u017e\u017f"+
		"\u0003@ \u0000\u017f\u0180\u0005\u001d\u0000\u0000\u0180E\u0001\u0000"+
		"\u0000\u0000\u0181\u0184\u0005(\u0000\u0000\u0182\u0185\u00057\u0000\u0000"+
		"\u0183\u0185\u0003\f\u0006\u0000\u0184\u0182\u0001\u0000\u0000\u0000\u0184"+
		"\u0183\u0001\u0000\u0000\u0000\u0185\u0189\u0001\u0000\u0000\u0000\u0186"+
		"\u0188\u0003\u0014\n\u0000\u0187\u0186\u0001\u0000\u0000\u0000\u0188\u018b"+
		"\u0001\u0000\u0000\u0000\u0189\u0187\u0001\u0000\u0000\u0000\u0189\u018a"+
		"\u0001\u0000\u0000\u0000\u018a\u018e\u0001\u0000\u0000\u0000\u018b\u0189"+
		"\u0001\u0000\u0000\u0000\u018c\u018d\u0005\u001c\u0000\u0000\u018d\u018f"+
		"\u0005\u001d\u0000\u0000\u018e\u018c\u0001\u0000\u0000\u0000\u018e\u018f"+
		"\u0001\u0000\u0000\u0000\u018fG\u0001\u0000\u0000\u0000\u0190\u0191\u0003"+
		"@ \u0000\u0191\u0192\u0005\u001a\u0000\u0000\u0192\u0193\u0003@ \u0000"+
		"\u0193\u0194\u0005\u001b\u0000\u0000\u0194I\u0001\u0000\u0000\u0000\u0195"+
		"\u0196\u0003@ \u0000\u0196\u0197\u0005\u0019\u0000\u0000\u0197\u0198\u0005"+
		"7\u0000\u0000\u0198K\u0001\u0000\u0000\u0000\u0199\u019a\u0003@ \u0000"+
		"\u019a\u019b\u0003\n\u0005\u0000\u019bM\u0001\u0000\u0000\u0000\u019c"+
		"\u01a2\u0005\"\u0000\u0000\u019d\u019f\u0005\u001c\u0000\u0000\u019e\u01a0"+
		"\u0003\b\u0004\u0000\u019f\u019e\u0001\u0000\u0000\u0000\u019f\u01a0\u0001"+
		"\u0000\u0000\u0000\u01a0\u01a1\u0001\u0000\u0000\u0000\u01a1\u01a3\u0005"+
		"\u001d\u0000\u0000\u01a2\u019d\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001"+
		"\u0000\u0000\u0000\u01a3\u01a4\u0001\u0000\u0000\u0000\u01a4\u01a5\u0005"+
		"#\u0000\u0000\u01a5\u01a6\u0003\u0016\u000b\u0000\u01a6\u01a7\u0003\n"+
		"\u0005\u0000\u01a7O\u0001\u0000\u0000\u0000\u01a8\u01a9\u0003,\u0016\u0000"+
		"\u01a9\u01aa\u0003@ \u0000\u01aaQ\u0001\u0000\u0000\u0000\u01ab\u01ac"+
		"\u0003@ \u0000\u01ac\u01ad\u0003.\u0017\u0000\u01adS\u0001\u0000\u0000"+
		"\u0000\u01ae\u01af\u00030\u0018\u0000\u01af\u01b0\u0003@ \u0000\u01b0"+
		"U\u0001\u0000\u0000\u0000\u01b1\u01b2\u0003@ \u0000\u01b2\u01b3\u0003"+
		"6\u001b\u0000\u01b3\u01b4\u0003@ \u0000\u01b4\u01ce\u0001\u0000\u0000"+
		"\u0000\u01b5\u01b6\u0003@ \u0000\u01b6\u01b7\u00034\u001a\u0000\u01b7"+
		"\u01b8\u0003@ \u0000\u01b8\u01ce\u0001\u0000\u0000\u0000\u01b9\u01ba\u0003"+
		"@ \u0000\u01ba\u01bb\u00032\u0019\u0000\u01bb\u01bc\u0003@ \u0000\u01bc"+
		"\u01ce\u0001\u0000\u0000\u0000\u01bd\u01be\u0003@ \u0000\u01be\u01bf\u0003"+
		"8\u001c\u0000\u01bf\u01c0\u0003@ \u0000\u01c0\u01ce\u0001\u0000\u0000"+
		"\u0000\u01c1\u01c2\u0003@ \u0000\u01c2\u01c3\u0003:\u001d\u0000\u01c3"+
		"\u01c4\u0003@ \u0000\u01c4\u01ce\u0001\u0000\u0000\u0000\u01c5\u01c6\u0003"+
		"@ \u0000\u01c6\u01c7\u0003>\u001f\u0000\u01c7\u01c8\u0003@ \u0000\u01c8"+
		"\u01ce\u0001\u0000\u0000\u0000\u01c9\u01ca\u0003@ \u0000\u01ca\u01cb\u0003"+
		"<\u001e\u0000\u01cb\u01cc\u0003@ \u0000\u01cc\u01ce\u0001\u0000\u0000"+
		"\u0000\u01cd\u01b1\u0001\u0000\u0000\u0000\u01cd\u01b5\u0001\u0000\u0000"+
		"\u0000\u01cd\u01b9\u0001\u0000\u0000\u0000\u01cd\u01bd\u0001\u0000\u0000"+
		"\u0000\u01cd\u01c1\u0001\u0000\u0000\u0000\u01cd\u01c5\u0001\u0000\u0000"+
		"\u0000\u01cd\u01c9\u0001\u0000\u0000\u0000\u01ceW\u0001\u0000\u0000\u0000"+
		"\u01cf\u01d0\u0003@ \u0000\u01d0\u01d1\u0005\u0018\u0000\u0000\u01d1\u01d2"+
		"\u0003@ \u0000\u01d2Y\u0001\u0000\u0000\u0000\u01d3\u01d4\u0003@ \u0000"+
		"\u01d4\u01d5\u0005!\u0000\u0000\u01d5\u01d6\u0003@ \u0000\u01d6[\u0001"+
		"\u0000\u0000\u0000&_aln}\u008a\u0093\u0096\u00a0\u00a6\u00a9\u00b1\u00b6"+
		"\u00ba\u00be\u00c6\u00d2\u00df\u00e3\u00ea\u00ee\u00f2\u00fd\u0109\u0128"+
		"\u012d\u0132\u0137\u013a\u0146\u0176\u0178\u0184\u0189\u018e\u019f\u01a2"+
		"\u01cd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}