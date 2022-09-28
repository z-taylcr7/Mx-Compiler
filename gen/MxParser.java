// Generated from C:/Users/Cristiano/IdeaProjects/Mx-Compiler/src/antlr\Mx.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Comment=1, Void=2, Bool=3, Int=4, String=5, New=6, Class=7, Null=8, True=9, 
		False=10, This=11, If=12, Else=13, For=14, While=15, Break=16, Continue=17, 
		Return=18, SelfAdd=19, Add=20, SelfMinus=21, Minus=22, Multiply=23, Divide=24, 
		Mod=25, LogicAnd=26, LogicOr=27, LogicNegative=28, LeftShift=29, RightShift=30, 
		Greater=31, Less=32, Equal=33, GEQ=34, LEQ=35, NEQ=36, And=37, Or=38, 
		Xor=39, Negative=40, Assign=41, Object=42, LBlanket=43, RBlanket=44, LParel=45, 
		RParel=46, LBrace=47, RBrace=48, SemiColon=49, Comma=50, ID=51, Literal=52, 
		BoolLiteral=53, IntLiteral=54, StringLiteral=55, NullLiteral=56, WhiteSpace=57, 
		NewLine=58, Expr=59;
	public static final int
		RULE_assign = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"assign"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'void'", "'bool'", "'int'", "'string'", "'new'", "'class'", 
			"'null'", "'true'", "'false'", "'this'", "'if'", "'else'", "'for'", "'while'", 
			"'break'", "'continue'", "'return'", "'++'", "'+'", "'--'", "'-'", "'*'", 
			"'/'", "'%'", "'&&'", "'||'", "'!'", "'<<'", "'>>'", "'>'", "'<'", "'=='", 
			"'>='", "'<='", "'!='", "'&'", "'|'", "'^'", "'~'", "'='", "'.'", "'['", 
			"']'", "'('", "')'", "'{'", "'}'", "';'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Comment", "Void", "Bool", "Int", "String", "New", "Class", "Null", 
			"True", "False", "This", "If", "Else", "For", "While", "Break", "Continue", 
			"Return", "SelfAdd", "Add", "SelfMinus", "Minus", "Multiply", "Divide", 
			"Mod", "LogicAnd", "LogicOr", "LogicNegative", "LeftShift", "RightShift", 
			"Greater", "Less", "Equal", "GEQ", "LEQ", "NEQ", "And", "Or", "Xor", 
			"Negative", "Assign", "Object", "LBlanket", "RBlanket", "LParel", "RParel", 
			"LBrace", "RBrace", "SemiColon", "Comma", "ID", "Literal", "BoolLiteral", 
			"IntLiteral", "StringLiteral", "NullLiteral", "WhiteSpace", "NewLine", 
			"Expr"
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
	public String getGrammarFileName() { return "Mx.g4"; }

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

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MxParser.ID, 0); }
		public TerminalNode Assign() { return getToken(MxParser.Assign, 0); }
		public TerminalNode Expr() { return getToken(MxParser.Expr, 0); }
		public TerminalNode SemiColon() { return getToken(MxParser.SemiColon, 0); }
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxListener ) ((MxListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxVisitor ) return ((MxVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2);
			match(ID);
			setState(3);
			match(Assign);
			setState(4);
			match(Expr);
			setState(5);
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

	public static final String _serializedATN =
		"\u0004\u0001;\b\u0002\u0000\u0007\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0000\u0000"+
		"\u0000\u0006\u0000\u0002\u0001\u0000\u0000\u0000\u0002\u0003\u00053\u0000"+
		"\u0000\u0003\u0004\u0005)\u0000\u0000\u0004\u0005\u0005;\u0000\u0000\u0005"+
		"\u0006\u00051\u0000\u0000\u0006\u0001\u0001\u0000\u0000\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}