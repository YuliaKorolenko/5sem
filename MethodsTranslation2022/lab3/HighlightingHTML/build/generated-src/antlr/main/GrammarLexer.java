// Generated from Grammar.g4 by ANTLR 4.9.3

   package org.example;
   import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, AddMinus=7, MulDiv=8, 
		BoolFun=9, MyEquals=10, OutInput=11, If=12, For=13, While=14, Else=15, 
		Semi=16, Types=17, WS=18, ModAv=19, Integer=20, VarName=21, ClassName=22, 
		String=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "AddMinus", "MulDiv", 
			"BoolFun", "MyEquals", "OutInput", "If", "For", "While", "Else", "Semi", 
			"Types", "WS", "ModAv", "Integer", "VarName", "ClassName", "String"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'='", "'System.out.'", "'{'", "'}'", null, null, 
			null, null, null, "'if'", "'for'", "'while'", "'else'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "AddMinus", "MulDiv", "BoolFun", 
			"MyEquals", "OutInput", "If", "For", "While", "Else", "Semi", "Types", 
			"WS", "ModAv", "Integer", "VarName", "ClassName", "String"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u00f1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\5\nP\n\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13[\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fs\n\f"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\5\22\u00b3\n\22\3\23\6\23\u00b6\n\23\r\23"+
		"\16\23\u00b7\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00d2"+
		"\n\24\3\25\3\25\7\25\u00d6\n\25\f\25\16\25\u00d9\13\25\3\26\3\26\7\26"+
		"\u00dd\n\26\f\26\16\26\u00e0\13\26\3\27\3\27\7\27\u00e4\n\27\f\27\16\27"+
		"\u00e7\13\27\3\30\3\30\7\30\u00eb\n\30\f\30\16\30\u00ee\13\30\3\30\3\30"+
		"\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\3\2\f\4\2--//\5\2\'\',,"+
		"\61\61\4\2>>@@\5\2\13\f\17\17\"\"\3\2\63;\3\2\62;\3\2c|\5\2\62;C\\c|\3"+
		"\2C\\\4\2$$^^\2\u0107\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\63\3\2\2\2\7\65\3\2\2\2\t\67\3"+
		"\2\2\2\13C\3\2\2\2\rE\3\2\2\2\17G\3\2\2\2\21I\3\2\2\2\23O\3\2\2\2\25Z"+
		"\3\2\2\2\27r\3\2\2\2\31t\3\2\2\2\33w\3\2\2\2\35{\3\2\2\2\37\u0081\3\2"+
		"\2\2!\u0086\3\2\2\2#\u00b2\3\2\2\2%\u00b5\3\2\2\2\'\u00d1\3\2\2\2)\u00d3"+
		"\3\2\2\2+\u00da\3\2\2\2-\u00e1\3\2\2\2/\u00e8\3\2\2\2\61\62\7*\2\2\62"+
		"\4\3\2\2\2\63\64\7+\2\2\64\6\3\2\2\2\65\66\7?\2\2\66\b\3\2\2\2\678\7U"+
		"\2\289\7{\2\29:\7u\2\2:;\7v\2\2;<\7g\2\2<=\7o\2\2=>\7\60\2\2>?\7q\2\2"+
		"?@\7w\2\2@A\7v\2\2AB\7\60\2\2B\n\3\2\2\2CD\7}\2\2D\f\3\2\2\2EF\7\177\2"+
		"\2F\16\3\2\2\2GH\t\2\2\2H\20\3\2\2\2IJ\t\3\2\2J\22\3\2\2\2KL\7(\2\2LP"+
		"\7(\2\2MN\7~\2\2NP\7~\2\2OK\3\2\2\2OM\3\2\2\2P\24\3\2\2\2Q[\t\4\2\2RS"+
		"\7?\2\2S[\7?\2\2TU\7#\2\2U[\7?\2\2VW\7@\2\2W[\7?\2\2XY\7>\2\2Y[\7?\2\2"+
		"ZQ\3\2\2\2ZR\3\2\2\2ZT\3\2\2\2ZV\3\2\2\2ZX\3\2\2\2[\26\3\2\2\2\\]\7r\2"+
		"\2]^\7t\2\2^_\7k\2\2_`\7p\2\2`a\7v\2\2ab\7n\2\2bs\7p\2\2cd\7t\2\2de\7"+
		"g\2\2ef\7c\2\2fg\7f\2\2gh\7n\2\2hs\7p\2\2ij\7r\2\2jk\7t\2\2kl\7k\2\2l"+
		"m\7p\2\2ms\7v\2\2no\7t\2\2op\7g\2\2pq\7c\2\2qs\7f\2\2r\\\3\2\2\2rc\3\2"+
		"\2\2ri\3\2\2\2rn\3\2\2\2s\30\3\2\2\2tu\7k\2\2uv\7h\2\2v\32\3\2\2\2wx\7"+
		"h\2\2xy\7q\2\2yz\7t\2\2z\34\3\2\2\2{|\7y\2\2|}\7j\2\2}~\7k\2\2~\177\7"+
		"n\2\2\177\u0080\7g\2\2\u0080\36\3\2\2\2\u0081\u0082\7g\2\2\u0082\u0083"+
		"\7n\2\2\u0083\u0084\7u\2\2\u0084\u0085\7g\2\2\u0085 \3\2\2\2\u0086\u0087"+
		"\7=\2\2\u0087\"\3\2\2\2\u0088\u0089\7k\2\2\u0089\u008a\7p\2\2\u008a\u00b3"+
		"\7v\2\2\u008b\u008c\7d\2\2\u008c\u008d\7q\2\2\u008d\u008e\7q\2\2\u008e"+
		"\u008f\7n\2\2\u008f\u0090\7g\2\2\u0090\u0091\7c\2\2\u0091\u00b3\7p\2\2"+
		"\u0092\u0093\7e\2\2\u0093\u0094\7j\2\2\u0094\u0095\7c\2\2\u0095\u00b3"+
		"\7t\2\2\u0096\u0097\7d\2\2\u0097\u0098\7{\2\2\u0098\u0099\7v\2\2\u0099"+
		"\u00b3\7g\2\2\u009a\u009b\7u\2\2\u009b\u009c\7j\2\2\u009c\u009d\7q\2\2"+
		"\u009d\u009e\7t\2\2\u009e\u00b3\7v\2\2\u009f\u00a0\7n\2\2\u00a0\u00a1"+
		"\7q\2\2\u00a1\u00a2\7p\2\2\u00a2\u00b3\7i\2\2\u00a3\u00a4\7x\2\2\u00a4"+
		"\u00a5\7q\2\2\u00a5\u00a6\7k\2\2\u00a6\u00b3\7f\2\2\u00a7\u00a8\7h\2\2"+
		"\u00a8\u00a9\7n\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab\7c\2\2\u00ab\u00b3"+
		"\7v\2\2\u00ac\u00ad\7f\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7w\2\2\u00af"+
		"\u00b0\7d\2\2\u00b0\u00b1\7n\2\2\u00b1\u00b3\7g\2\2\u00b2\u0088\3\2\2"+
		"\2\u00b2\u008b\3\2\2\2\u00b2\u0092\3\2\2\2\u00b2\u0096\3\2\2\2\u00b2\u009a"+
		"\3\2\2\2\u00b2\u009f\3\2\2\2\u00b2\u00a3\3\2\2\2\u00b2\u00a7\3\2\2\2\u00b2"+
		"\u00ac\3\2\2\2\u00b3$\3\2\2\2\u00b4\u00b6\t\5\2\2\u00b5\u00b4\3\2\2\2"+
		"\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9"+
		"\3\2\2\2\u00b9\u00ba\b\23\2\2\u00ba&\3\2\2\2\u00bb\u00bc\7r\2\2\u00bc"+
		"\u00bd\7t\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7x\2\2\u00bf\u00c0\7c\2\2"+
		"\u00c0\u00c1\7v\2\2\u00c1\u00d2\7g\2\2\u00c2\u00c3\7r\2\2\u00c3\u00c4"+
		"\7w\2\2\u00c4\u00c5\7d\2\2\u00c5\u00c6\7n\2\2\u00c6\u00c7\7k\2\2\u00c7"+
		"\u00d2\7e\2\2\u00c8\u00c9\7r\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb\7q\2\2"+
		"\u00cb\u00cc\7v\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7e\2\2\u00ce\u00cf"+
		"\7v\2\2\u00cf\u00d0\7g\2\2\u00d0\u00d2\7f\2\2\u00d1\u00bb\3\2\2\2\u00d1"+
		"\u00c2\3\2\2\2\u00d1\u00c8\3\2\2\2\u00d2(\3\2\2\2\u00d3\u00d7\t\6\2\2"+
		"\u00d4\u00d6\t\7\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5"+
		"\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8*\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da"+
		"\u00de\t\b\2\2\u00db\u00dd\t\t\2\2\u00dc\u00db\3\2\2\2\u00dd\u00e0\3\2"+
		"\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df,\3\2\2\2\u00e0\u00de"+
		"\3\2\2\2\u00e1\u00e5\t\n\2\2\u00e2\u00e4\t\t\2\2\u00e3\u00e2\3\2\2\2\u00e4"+
		"\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6.\3\2\2\2"+
		"\u00e7\u00e5\3\2\2\2\u00e8\u00ec\7$\2\2\u00e9\u00eb\n\13\2\2\u00ea\u00e9"+
		"\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u00ef\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\7$\2\2\u00f0\60\3\2\2\2"+
		"\r\2OZr\u00b2\u00b7\u00d1\u00d7\u00de\u00e5\u00ec\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}