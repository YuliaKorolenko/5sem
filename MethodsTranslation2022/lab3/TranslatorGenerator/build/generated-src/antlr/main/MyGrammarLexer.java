// Generated from java-escape by ANTLR 4.11.1

   import info.*;
   import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MyGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, EPS=2, GRAMMAR=3, COLON=4, START_FUNC=5, REGEXP=6, SEMICOLON=7, 
		ATTR=8, RETURN_VALUES=9, CODE=10, TOKEN_NAME=11, NAME=12, WHITESPACE=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "EPS", "GRAMMAR", "COLON", "START_FUNC", "REGEXP", "SEMICOLON", 
			"ATTR", "RETURN_VALUES", "CODE", "TOKEN_NAME", "NAME", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'|'", "'\\u03B5'", "'grammar'", "':'", "'->'", null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "EPS", "GRAMMAR", "COLON", "START_FUNC", "REGEXP", "SEMICOLON", 
			"ATTR", "RETURN_VALUES", "CODE", "TOKEN_NAME", "NAME", "WHITESPACE"
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


	public MyGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MyGrammar.g4"; }

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
		"\u0004\u0000\re\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0005\u0005/\b\u0005\n\u0005"+
		"\f\u00052\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0005\u0007:\b\u0007\n\u0007\f\u0007=\t\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0005\bC\b\b\n\b\f\bF\t\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0005\tL\b\t\n\t\f\tO\t\t\u0001\t\u0001\t\u0001\n\u0004"+
		"\nT\b\n\u000b\n\f\nU\u0001\u000b\u0001\u000b\u0005\u000bZ\b\u000b\n\u000b"+
		"\f\u000b]\t\u000b\u0001\f\u0004\f`\b\f\u000b\f\f\fa\u0001\f\u0001\f\u0004"+
		"0;DM\u0000\r\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u0001"+
		"\u0000\u0004\u0001\u0000AZ\u0001\u0000az\u0002\u0000AZaz\u0003\u0000\t"+
		"\n\r\r  k\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0001\u001b\u0001\u0000\u0000\u0000"+
		"\u0003\u001d\u0001\u0000\u0000\u0000\u0005\u001f\u0001\u0000\u0000\u0000"+
		"\u0007\'\u0001\u0000\u0000\u0000\t)\u0001\u0000\u0000\u0000\u000b,\u0001"+
		"\u0000\u0000\u0000\r5\u0001\u0000\u0000\u0000\u000f7\u0001\u0000\u0000"+
		"\u0000\u0011@\u0001\u0000\u0000\u0000\u0013I\u0001\u0000\u0000\u0000\u0015"+
		"S\u0001\u0000\u0000\u0000\u0017W\u0001\u0000\u0000\u0000\u0019_\u0001"+
		"\u0000\u0000\u0000\u001b\u001c\u0005|\u0000\u0000\u001c\u0002\u0001\u0000"+
		"\u0000\u0000\u001d\u001e\u0005\u03b5\u0000\u0000\u001e\u0004\u0001\u0000"+
		"\u0000\u0000\u001f \u0005g\u0000\u0000 !\u0005r\u0000\u0000!\"\u0005a"+
		"\u0000\u0000\"#\u0005m\u0000\u0000#$\u0005m\u0000\u0000$%\u0005a\u0000"+
		"\u0000%&\u0005r\u0000\u0000&\u0006\u0001\u0000\u0000\u0000\'(\u0005:\u0000"+
		"\u0000(\b\u0001\u0000\u0000\u0000)*\u0005-\u0000\u0000*+\u0005>\u0000"+
		"\u0000+\n\u0001\u0000\u0000\u0000,0\u0005\"\u0000\u0000-/\t\u0000\u0000"+
		"\u0000.-\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000\u000001\u0001\u0000"+
		"\u0000\u00000.\u0001\u0000\u0000\u000013\u0001\u0000\u0000\u000020\u0001"+
		"\u0000\u0000\u000034\u0005\"\u0000\u00004\f\u0001\u0000\u0000\u000056"+
		"\u0005;\u0000\u00006\u000e\u0001\u0000\u0000\u00007;\u0005(\u0000\u0000"+
		"8:\t\u0000\u0000\u000098\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000"+
		";<\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<>\u0001\u0000\u0000"+
		"\u0000=;\u0001\u0000\u0000\u0000>?\u0005)\u0000\u0000?\u0010\u0001\u0000"+
		"\u0000\u0000@D\u0005[\u0000\u0000AC\t\u0000\u0000\u0000BA\u0001\u0000"+
		"\u0000\u0000CF\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000DB\u0001"+
		"\u0000\u0000\u0000EG\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000"+
		"GH\u0005]\u0000\u0000H\u0012\u0001\u0000\u0000\u0000IM\u0005{\u0000\u0000"+
		"JL\t\u0000\u0000\u0000KJ\u0001\u0000\u0000\u0000LO\u0001\u0000\u0000\u0000"+
		"MN\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000NP\u0001\u0000\u0000"+
		"\u0000OM\u0001\u0000\u0000\u0000PQ\u0005}\u0000\u0000Q\u0014\u0001\u0000"+
		"\u0000\u0000RT\u0007\u0000\u0000\u0000SR\u0001\u0000\u0000\u0000TU\u0001"+
		"\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000"+
		"V\u0016\u0001\u0000\u0000\u0000W[\u0007\u0001\u0000\u0000XZ\u0007\u0002"+
		"\u0000\u0000YX\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001"+
		"\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\\u0018\u0001\u0000\u0000"+
		"\u0000][\u0001\u0000\u0000\u0000^`\u0007\u0003\u0000\u0000_^\u0001\u0000"+
		"\u0000\u0000`a\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001"+
		"\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cd\u0006\f\u0000\u0000d\u001a"+
		"\u0001\u0000\u0000\u0000\b\u00000;DMU[a\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}