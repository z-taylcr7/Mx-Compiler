// Generated from MxLexer.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

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
		RParel=46, LBrace=47, RBrace=48, SemiColon=49, Comma=50, Identifier=51, 
		BoolLiteral=52, IntLiteral=53, StringLiteral=54, NullLiteral=55, WhiteSpace=56, 
		Enter=57;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Comment", "Void", "Bool", "Int", "String", "New", "Class", "Null", "True", 
			"False", "This", "If", "Else", "For", "While", "Break", "Continue", "Return", 
			"SelfAdd", "Add", "SelfMinus", "Minus", "Multiply", "Divide", "Mod", 
			"LogicAnd", "LogicOr", "LogicNegative", "LeftShift", "RightShift", "Greater", 
			"Less", "Equal", "GEQ", "LEQ", "NEQ", "And", "Or", "Xor", "Negative", 
			"Assign", "Object", "LBlanket", "RBlanket", "LParel", "RParel", "LBrace", 
			"RBrace", "SemiColon", "Comma", "Digit", "DigitExceptZero", "Letter", 
			"Symbol", "IdentifierCharacter", "EscapeCharacter", "StringCharacter", 
			"Identifier", "BoolLiteral", "IntLiteral", "StringLiteral", "NullLiteral", 
			"WhiteSpace", "Enter"
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
			"LBrace", "RBrace", "SemiColon", "Comma", "Identifier", "BoolLiteral", 
			"IntLiteral", "StringLiteral", "NullLiteral", "WhiteSpace", "Enter"
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


	public MxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MxLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2;\u017f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\3\2\3\2\3\2\3\2\7\2\u0088\n\2\f\2\16\2\u008b"+
		"\13\2\3\2\5\2\u008e\n\2\3\2\3\2\3\2\3\2\3\2\7\2\u0095\n\2\f\2\16\2\u0098"+
		"\13\2\3\2\3\2\5\2\u009c\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3"+
		"\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3"+
		"#\3$\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-"+
		"\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3"+
		"\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3:\3:\5:\u0156\n:\3;\3;\7;\u015a"+
		"\n;\f;\16;\u015d\13;\3<\3<\5<\u0161\n<\3=\3=\3=\7=\u0166\n=\f=\16=\u0169"+
		"\13=\5=\u016b\n=\3>\3>\6>\u016f\n>\r>\16>\u0170\3>\3>\3?\3?\3@\3@\3@\5"+
		"@\u017a\n@\3@\3@\3A\3A\3\u0096\2B\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60"+
		"_\61a\62c\63e\64g\2i\2k\2m\2o\2q\2s\2u\65w\66y\67{8}9\177:\u0081;\3\2"+
		"\b\4\2\f\f\17\17\4\2C\\c|\7\2#\61<A]]_b}\u0080\6\2\62;C\\aac|\5\2\f\f"+
		"$$^^\4\2\13\f\"\"\2\u0184\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2u\3\2\2\2\2w\3\2"+
		"\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\3"+
		"\u009b\3\2\2\2\5\u009f\3\2\2\2\7\u00a4\3\2\2\2\t\u00a9\3\2\2\2\13\u00ad"+
		"\3\2\2\2\r\u00b4\3\2\2\2\17\u00b8\3\2\2\2\21\u00be\3\2\2\2\23\u00c3\3"+
		"\2\2\2\25\u00c8\3\2\2\2\27\u00ce\3\2\2\2\31\u00d3\3\2\2\2\33\u00d6\3\2"+
		"\2\2\35\u00db\3\2\2\2\37\u00df\3\2\2\2!\u00e5\3\2\2\2#\u00eb\3\2\2\2%"+
		"\u00f4\3\2\2\2\'\u00fb\3\2\2\2)\u00fe\3\2\2\2+\u0100\3\2\2\2-\u0103\3"+
		"\2\2\2/\u0105\3\2\2\2\61\u0107\3\2\2\2\63\u0109\3\2\2\2\65\u010b\3\2\2"+
		"\2\67\u010e\3\2\2\29\u0111\3\2\2\2;\u0113\3\2\2\2=\u0116\3\2\2\2?\u0119"+
		"\3\2\2\2A\u011b\3\2\2\2C\u011d\3\2\2\2E\u0120\3\2\2\2G\u0123\3\2\2\2I"+
		"\u0126\3\2\2\2K\u0129\3\2\2\2M\u012b\3\2\2\2O\u012d\3\2\2\2Q\u012f\3\2"+
		"\2\2S\u0131\3\2\2\2U\u0133\3\2\2\2W\u0135\3\2\2\2Y\u0137\3\2\2\2[\u0139"+
		"\3\2\2\2]\u013b\3\2\2\2_\u013d\3\2\2\2a\u013f\3\2\2\2c\u0141\3\2\2\2e"+
		"\u0143\3\2\2\2g\u0145\3\2\2\2i\u0147\3\2\2\2k\u0149\3\2\2\2m\u014b\3\2"+
		"\2\2o\u014d\3\2\2\2q\u014f\3\2\2\2s\u0155\3\2\2\2u\u0157\3\2\2\2w\u0160"+
		"\3\2\2\2y\u016a\3\2\2\2{\u016c\3\2\2\2}\u0174\3\2\2\2\177\u0179\3\2\2"+
		"\2\u0081\u017d\3\2\2\2\u0083\u0084\7\61\2\2\u0084\u0085\7\61\2\2\u0085"+
		"\u0089\3\2\2\2\u0086\u0088\n\2\2\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2"+
		"\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008d\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008c\u008e\7\17\2\2\u008d\u008c\3\2\2\2\u008d\u008e\3"+
		"\2\2\2\u008e\u008f\3\2\2\2\u008f\u009c\7\f\2\2\u0090\u0091\7\61\2\2\u0091"+
		"\u0092\7,\2\2\u0092\u0096\3\2\2\2\u0093\u0095\13\2\2\2\u0094\u0093\3\2"+
		"\2\2\u0095\u0098\3\2\2\2\u0096\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097"+
		"\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009a\7,\2\2\u009a\u009c\7\61"+
		"\2\2\u009b\u0083\3\2\2\2\u009b\u0090\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009e\b\2\2\2\u009e\4\3\2\2\2\u009f\u00a0\7x\2\2\u00a0\u00a1\7q\2\2\u00a1"+
		"\u00a2\7k\2\2\u00a2\u00a3\7f\2\2\u00a3\6\3\2\2\2\u00a4\u00a5\7d\2\2\u00a5"+
		"\u00a6\7q\2\2\u00a6\u00a7\7q\2\2\u00a7\u00a8\7n\2\2\u00a8\b\3\2\2\2\u00a9"+
		"\u00aa\7k\2\2\u00aa\u00ab\7p\2\2\u00ab\u00ac\7v\2\2\u00ac\n\3\2\2\2\u00ad"+
		"\u00ae\7u\2\2\u00ae\u00af\7v\2\2\u00af\u00b0\7t\2\2\u00b0\u00b1\7k\2\2"+
		"\u00b1\u00b2\7p\2\2\u00b2\u00b3\7i\2\2\u00b3\f\3\2\2\2\u00b4\u00b5\7p"+
		"\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7y\2\2\u00b7\16\3\2\2\2\u00b8\u00b9"+
		"\7e\2\2\u00b9\u00ba\7n\2\2\u00ba\u00bb\7c\2\2\u00bb\u00bc\7u\2\2\u00bc"+
		"\u00bd\7u\2\2\u00bd\20\3\2\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7w\2\2\u00c0"+
		"\u00c1\7n\2\2\u00c1\u00c2\7n\2\2\u00c2\22\3\2\2\2\u00c3\u00c4\7v\2\2\u00c4"+
		"\u00c5\7t\2\2\u00c5\u00c6\7w\2\2\u00c6\u00c7\7g\2\2\u00c7\24\3\2\2\2\u00c8"+
		"\u00c9\7h\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb\7n\2\2\u00cb\u00cc\7u\2\2"+
		"\u00cc\u00cd\7g\2\2\u00cd\26\3\2\2\2\u00ce\u00cf\7v\2\2\u00cf\u00d0\7"+
		"j\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7u\2\2\u00d2\30\3\2\2\2\u00d3\u00d4"+
		"\7k\2\2\u00d4\u00d5\7h\2\2\u00d5\32\3\2\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8"+
		"\7n\2\2\u00d8\u00d9\7u\2\2\u00d9\u00da\7g\2\2\u00da\34\3\2\2\2\u00db\u00dc"+
		"\7h\2\2\u00dc\u00dd\7q\2\2\u00dd\u00de\7t\2\2\u00de\36\3\2\2\2\u00df\u00e0"+
		"\7y\2\2\u00e0\u00e1\7j\2\2\u00e1\u00e2\7k\2\2\u00e2\u00e3\7n\2\2\u00e3"+
		"\u00e4\7g\2\2\u00e4 \3\2\2\2\u00e5\u00e6\7d\2\2\u00e6\u00e7\7t\2\2\u00e7"+
		"\u00e8\7g\2\2\u00e8\u00e9\7c\2\2\u00e9\u00ea\7m\2\2\u00ea\"\3\2\2\2\u00eb"+
		"\u00ec\7e\2\2\u00ec\u00ed\7q\2\2\u00ed\u00ee\7p\2\2\u00ee\u00ef\7v\2\2"+
		"\u00ef\u00f0\7k\2\2\u00f0\u00f1\7p\2\2\u00f1\u00f2\7w\2\2\u00f2\u00f3"+
		"\7g\2\2\u00f3$\3\2\2\2\u00f4\u00f5\7t\2\2\u00f5\u00f6\7g\2\2\u00f6\u00f7"+
		"\7v\2\2\u00f7\u00f8\7w\2\2\u00f8\u00f9\7t\2\2\u00f9\u00fa\7p\2\2\u00fa"+
		"&\3\2\2\2\u00fb\u00fc\7-\2\2\u00fc\u00fd\7-\2\2\u00fd(\3\2\2\2\u00fe\u00ff"+
		"\7-\2\2\u00ff*\3\2\2\2\u0100\u0101\7/\2\2\u0101\u0102\7/\2\2\u0102,\3"+
		"\2\2\2\u0103\u0104\7/\2\2\u0104.\3\2\2\2\u0105\u0106\7,\2\2\u0106\60\3"+
		"\2\2\2\u0107\u0108\7\61\2\2\u0108\62\3\2\2\2\u0109\u010a\7\'\2\2\u010a"+
		"\64\3\2\2\2\u010b\u010c\7(\2\2\u010c\u010d\7(\2\2\u010d\66\3\2\2\2\u010e"+
		"\u010f\7~\2\2\u010f\u0110\7~\2\2\u01108\3\2\2\2\u0111\u0112\7#\2\2\u0112"+
		":\3\2\2\2\u0113\u0114\7>\2\2\u0114\u0115\7>\2\2\u0115<\3\2\2\2\u0116\u0117"+
		"\7@\2\2\u0117\u0118\7@\2\2\u0118>\3\2\2\2\u0119\u011a\7@\2\2\u011a@\3"+
		"\2\2\2\u011b\u011c\7>\2\2\u011cB\3\2\2\2\u011d\u011e\7?\2\2\u011e\u011f"+
		"\7?\2\2\u011fD\3\2\2\2\u0120\u0121\7@\2\2\u0121\u0122\7?\2\2\u0122F\3"+
		"\2\2\2\u0123\u0124\7>\2\2\u0124\u0125\7?\2\2\u0125H\3\2\2\2\u0126\u0127"+
		"\7#\2\2\u0127\u0128\7?\2\2\u0128J\3\2\2\2\u0129\u012a\7(\2\2\u012aL\3"+
		"\2\2\2\u012b\u012c\7~\2\2\u012cN\3\2\2\2\u012d\u012e\7`\2\2\u012eP\3\2"+
		"\2\2\u012f\u0130\7\u0080\2\2\u0130R\3\2\2\2\u0131\u0132\7?\2\2\u0132T"+
		"\3\2\2\2\u0133\u0134\7\60\2\2\u0134V\3\2\2\2\u0135\u0136\7]\2\2\u0136"+
		"X\3\2\2\2\u0137\u0138\7_\2\2\u0138Z\3\2\2\2\u0139\u013a\7*\2\2\u013a\\"+
		"\3\2\2\2\u013b\u013c\7+\2\2\u013c^\3\2\2\2\u013d\u013e\7}\2\2\u013e`\3"+
		"\2\2\2\u013f\u0140\7\177\2\2\u0140b\3\2\2\2\u0141\u0142\7=\2\2\u0142d"+
		"\3\2\2\2\u0143\u0144\7.\2\2\u0144f\3\2\2\2\u0145\u0146\4\62;\2\u0146h"+
		"\3\2\2\2\u0147\u0148\4\63;\2\u0148j\3\2\2\2\u0149\u014a\t\3\2\2\u014a"+
		"l\3\2\2\2\u014b\u014c\t\4\2\2\u014cn\3\2\2\2\u014d\u014e\t\5\2\2\u014e"+
		"p\3\2\2\2\u014f\u0150\t\6\2\2\u0150r\3\2\2\2\u0151\u0156\5g\64\2\u0152"+
		"\u0156\5k\66\2\u0153\u0156\5m\67\2\u0154\u0156\5q9\2\u0155\u0151\3\2\2"+
		"\2\u0155\u0152\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0154\3\2\2\2\u0156t"+
		"\3\2\2\2\u0157\u015b\5k\66\2\u0158\u015a\5o8\2\u0159\u0158\3\2\2\2\u015a"+
		"\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015cv\3\2\2\2"+
		"\u015d\u015b\3\2\2\2\u015e\u0161\5\23\n\2\u015f\u0161\5\25\13\2\u0160"+
		"\u015e\3\2\2\2\u0160\u015f\3\2\2\2\u0161x\3\2\2\2\u0162\u016b\7\62\2\2"+
		"\u0163\u0167\5i\65\2\u0164\u0166\5g\64\2\u0165\u0164\3\2\2\2\u0166\u0169"+
		"\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u016b\3\2\2\2\u0169"+
		"\u0167\3\2\2\2\u016a\u0162\3\2\2\2\u016a\u0163\3\2\2\2\u016bz\3\2\2\2"+
		"\u016c\u016e\7$\2\2\u016d\u016f\5s:\2\u016e\u016d\3\2\2\2\u016f\u0170"+
		"\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172\3\2\2\2\u0172"+
		"\u0173\7$\2\2\u0173|\3\2\2\2\u0174\u0175\5\21\t\2\u0175~\3\2\2\2\u0176"+
		"\u017a\t\7\2\2\u0177\u0178\7\61\2\2\u0178\u017a\7\61\2\2\u0179\u0176\3"+
		"\2\2\2\u0179\u0177\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017c\b@\2\2\u017c"+
		"\u0080\3\2\2\2\u017d\u017e\t\2\2\2\u017e\u0082\3\2\2\2\16\2\u0089\u008d"+
		"\u0096\u009b\u0155\u015b\u0160\u0167\u016a\u0170\u0179\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}