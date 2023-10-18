// Generated from java-escape by ANTLR 4.11.1

   import info.*;
   import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MyGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, EPS=2, GRAMMAR=3, COLON=4, START_FUNC=5, REGEXP=6, SEMICOLON=7, 
		ATTR=8, RETURN_VALUES=9, CODE=10, TOKEN_NAME=11, NAME=12, WHITESPACE=13;
	public static final int
		RULE_myGrammar = 0, RULE_grammarHeader = 1, RULE_rules = 2, RULE_rule = 3, 
		RULE_terminalRule = 4, RULE_nonTerminalRule = 5, RULE_parts = 6, RULE_part = 7, 
		RULE_call = 8, RULE_name = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"myGrammar", "grammarHeader", "rules", "rule", "terminalRule", "nonTerminalRule", 
			"parts", "part", "call", "name"
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

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MyGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MyGrammarContext extends ParserRuleContext {
		public MainInfo info;
		public GrammarHeaderContext grammarHeader() {
			return getRuleContext(GrammarHeaderContext.class,0);
		}
		public RulesContext rules() {
			return getRuleContext(RulesContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MyGrammarParser.EOF, 0); }
		public MyGrammarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_myGrammar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterMyGrammar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitMyGrammar(this);
		}
	}

	public final MyGrammarContext myGrammar() throws RecognitionException {
		MyGrammarContext _localctx = new MyGrammarContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_myGrammar);
		MainInfo info = new MainInfo();
		    ((MyGrammarContext)_localctx).info =  info;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			grammarHeader(info);
			setState(21);
			rules(info);
			setState(22);
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
	public static class GrammarHeaderContext extends ParserRuleContext {
		public MainInfo info;
		public NameContext name;
		public TerminalNode GRAMMAR() { return getToken(MyGrammarParser.GRAMMAR, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MyGrammarParser.SEMICOLON, 0); }
		public GrammarHeaderContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public GrammarHeaderContext(ParserRuleContext parent, int invokingState, MainInfo info) {
			super(parent, invokingState);
			this.info = info;
		}
		@Override public int getRuleIndex() { return RULE_grammarHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterGrammarHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitGrammarHeader(this);
		}
	}

	public final GrammarHeaderContext grammarHeader(MainInfo info) throws RecognitionException {
		GrammarHeaderContext _localctx = new GrammarHeaderContext(_ctx, getState(), info);
		enterRule(_localctx, 2, RULE_grammarHeader);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(GRAMMAR);
			setState(25);
			((GrammarHeaderContext)_localctx).name = name();
			setState(26);
			match(SEMICOLON);
			info.setName((((GrammarHeaderContext)_localctx).name!=null?_input.getText(((GrammarHeaderContext)_localctx).name.start,((GrammarHeaderContext)_localctx).name.stop):null));
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
	public static class RulesContext extends ParserRuleContext {
		public MainInfo info;
		public List<RuleContext> rule_() {
			return getRuleContexts(RuleContext.class);
		}
		public RuleContext rule_(int i) {
			return getRuleContext(RuleContext.class,i);
		}
		public RulesContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public RulesContext(ParserRuleContext parent, int invokingState, MainInfo info) {
			super(parent, invokingState);
			this.info = info;
		}
		@Override public int getRuleIndex() { return RULE_rules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitRules(this);
		}
	}

	public final RulesContext rules(MainInfo info) throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState(), info);
		enterRule(_localctx, 4, RULE_rules);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TOKEN_NAME || _la==NAME) {
				{
				{
				setState(29);
				rule_(info);
				}
				}
				setState(34);
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
	public static class RuleContext extends ParserRuleContext {
		public MainInfo info;
		public TerminalRuleContext terminalRule() {
			return getRuleContext(TerminalRuleContext.class,0);
		}
		public NonTerminalRuleContext nonTerminalRule() {
			return getRuleContext(NonTerminalRuleContext.class,0);
		}
		public RuleContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public RuleContext(ParserRuleContext parent, int invokingState, MainInfo info) {
			super(parent, invokingState);
			this.info = info;
		}
		@Override public int getRuleIndex() { return RULE_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitRule(this);
		}
	}

	public final RuleContext rule_(MainInfo info) throws RecognitionException {
		RuleContext _localctx = new RuleContext(_ctx, getState(), info);
		enterRule(_localctx, 6, RULE_rule);
		try {
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				terminalRule(info);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				nonTerminalRule(info);
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
	public static class TerminalRuleContext extends ParserRuleContext {
		public MainInfo info;
		public NameContext name;
		public Token REGEXP;
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(MyGrammarParser.COLON, 0); }
		public TerminalNode REGEXP() { return getToken(MyGrammarParser.REGEXP, 0); }
		public TerminalNode SEMICOLON() { return getToken(MyGrammarParser.SEMICOLON, 0); }
		public TerminalRuleContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public TerminalRuleContext(ParserRuleContext parent, int invokingState, MainInfo info) {
			super(parent, invokingState);
			this.info = info;
		}
		@Override public int getRuleIndex() { return RULE_terminalRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterTerminalRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitTerminalRule(this);
		}
	}

	public final TerminalRuleContext terminalRule(MainInfo info) throws RecognitionException {
		TerminalRuleContext _localctx = new TerminalRuleContext(_ctx, getState(), info);
		enterRule(_localctx, 8, RULE_terminalRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			((TerminalRuleContext)_localctx).name = name();
			setState(40);
			match(COLON);
			setState(41);
			((TerminalRuleContext)_localctx).REGEXP = match(REGEXP);
			setState(42);
			match(SEMICOLON);
			 _localctx.info.addToken((((TerminalRuleContext)_localctx).name!=null?_input.getText(((TerminalRuleContext)_localctx).name.start,((TerminalRuleContext)_localctx).name.stop):null), (((TerminalRuleContext)_localctx).REGEXP!=null?((TerminalRuleContext)_localctx).REGEXP.getText():null)); 
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
	public static class NonTerminalRuleContext extends ParserRuleContext {
		public MainInfo info;
		public NameContext name;
		public Token ATTR;
		public Token RETURN_VALUES;
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode ATTR() { return getToken(MyGrammarParser.ATTR, 0); }
		public TerminalNode RETURN_VALUES() { return getToken(MyGrammarParser.RETURN_VALUES, 0); }
		public TerminalNode START_FUNC() { return getToken(MyGrammarParser.START_FUNC, 0); }
		public PartsContext parts() {
			return getRuleContext(PartsContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MyGrammarParser.SEMICOLON, 0); }
		public NonTerminalRuleContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public NonTerminalRuleContext(ParserRuleContext parent, int invokingState, MainInfo info) {
			super(parent, invokingState);
			this.info = info;
		}
		@Override public int getRuleIndex() { return RULE_nonTerminalRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterNonTerminalRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitNonTerminalRule(this);
		}
	}

	public final NonTerminalRuleContext nonTerminalRule(MainInfo info) throws RecognitionException {
		NonTerminalRuleContext _localctx = new NonTerminalRuleContext(_ctx, getState(), info);
		enterRule(_localctx, 10, RULE_nonTerminalRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			((NonTerminalRuleContext)_localctx).name = name();
			setState(46);
			((NonTerminalRuleContext)_localctx).ATTR = match(ATTR);
			setState(47);
			((NonTerminalRuleContext)_localctx).RETURN_VALUES = match(RETURN_VALUES);
			setState(48);
			match(START_FUNC);
			NonTerminalToken token = new NonTerminalToken((((NonTerminalRuleContext)_localctx).name!=null?_input.getText(((NonTerminalRuleContext)_localctx).name.start,((NonTerminalRuleContext)_localctx).name.stop):null), (((NonTerminalRuleContext)_localctx).ATTR!=null?((NonTerminalRuleContext)_localctx).ATTR.getText():null), (((NonTerminalRuleContext)_localctx).RETURN_VALUES!=null?((NonTerminalRuleContext)_localctx).RETURN_VALUES.getText():null));
			setState(50);
			parts(info, token);
			setState(51);
			match(SEMICOLON);
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
	public static class PartsContext extends ParserRuleContext {
		public MainInfo info;
		public NonTerminalToken token;
		public List<PartContext> part() {
			return getRuleContexts(PartContext.class);
		}
		public PartContext part(int i) {
			return getRuleContext(PartContext.class,i);
		}
		public PartsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PartsContext(ParserRuleContext parent, int invokingState, MainInfo info, NonTerminalToken token) {
			super(parent, invokingState);
			this.info = info;
			this.token = token;
		}
		@Override public int getRuleIndex() { return RULE_parts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterParts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitParts(this);
		}
	}

	public final PartsContext parts(MainInfo info,NonTerminalToken token) throws RecognitionException {
		PartsContext _localctx = new PartsContext(_ctx, getState(), info, token);
		enterRule(_localctx, 12, RULE_parts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			part(info, token);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(54);
				match(T__0);
				setState(55);
				part(info, token);
				}
				}
				setState(60);
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
	public static class PartContext extends ParserRuleContext {
		public MainInfo info;
		public NonTerminalToken token;
		public CallContext call;
		public Token CODE;
		public List<CallContext> call() {
			return getRuleContexts(CallContext.class);
		}
		public CallContext call(int i) {
			return getRuleContext(CallContext.class,i);
		}
		public TerminalNode EPS() { return getToken(MyGrammarParser.EPS, 0); }
		public TerminalNode CODE() { return getToken(MyGrammarParser.CODE, 0); }
		public PartContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PartContext(ParserRuleContext parent, int invokingState, MainInfo info, NonTerminalToken token) {
			super(parent, invokingState);
			this.info = info;
			this.token = token;
		}
		@Override public int getRuleIndex() { return RULE_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitPart(this);
		}
	}

	public final PartContext part(MainInfo info,NonTerminalToken token) throws RecognitionException {
		PartContext _localctx = new PartContext(_ctx, getState(), info, token);
		enterRule(_localctx, 14, RULE_part);
		List<Part> parts = new ArrayList<>();
		int _la;
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TOKEN_NAME:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(61);
					((PartContext)_localctx).call = call();
					parts.add(((PartContext)_localctx).call.part_);
					}
					}
					setState(66); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==TOKEN_NAME || _la==NAME );
				info.addRule(token, parts);
				}
				break;
			case EPS:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				match(EPS);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CODE) {
					{
					setState(71);
					((PartContext)_localctx).CODE = match(CODE);
					}
				}

				_localctx.info.addRule(token, List.of(new Part(List.of(), (((PartContext)_localctx).CODE!=null?((PartContext)_localctx).CODE.getText():null))));
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class CallContext extends ParserRuleContext {
		public Part part_;
		public NameContext name;
		public Token ATTR;
		public Token CODE;
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TerminalNode CODE() { return getToken(MyGrammarParser.CODE, 0); }
		public List<TerminalNode> ATTR() { return getTokens(MyGrammarParser.ATTR); }
		public TerminalNode ATTR(int i) {
			return getToken(MyGrammarParser.ATTR, i);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitCall(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_call);

		  List<Call> calls = new ArrayList<>();
		  
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(83); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(77);
					((CallContext)_localctx).name = name();
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ATTR) {
						{
						setState(78);
						((CallContext)_localctx).ATTR = match(ATTR);
						}
					}

					Call call_ = new Call((((CallContext)_localctx).name!=null?_input.getText(((CallContext)_localctx).name.start,((CallContext)_localctx).name.stop):null), (((CallContext)_localctx).ATTR!=null?((CallContext)_localctx).ATTR.getText():null));
					                   calls.add(call_);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(85); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CODE) {
				{
				setState(87);
				((CallContext)_localctx).CODE = match(CODE);
				}
			}

			((CallContext)_localctx).part_ =  new Part(calls, (((CallContext)_localctx).CODE!=null?((CallContext)_localctx).CODE.getText():null));
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
	public static class NameContext extends ParserRuleContext {
		public TerminalNode TOKEN_NAME() { return getToken(MyGrammarParser.TOKEN_NAME, 0); }
		public TerminalNode NAME() { return getToken(MyGrammarParser.NAME, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyGrammarListener ) ((MyGrammarListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_la = _input.LA(1);
			if ( !(_la==TOKEN_NAME || _la==NAME) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001\r_\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0005\u0002\u001f\b\u0002\n\u0002\f\u0002\"\t\u0002\u0001\u0003\u0001"+
		"\u0003\u0003\u0003&\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u00069\b\u0006\n\u0006\f\u0006<\t\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0004\u0007A\b\u0007\u000b\u0007\f\u0007"+
		"B\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007I\b\u0007"+
		"\u0001\u0007\u0003\u0007L\b\u0007\u0001\b\u0001\b\u0003\bP\b\b\u0001\b"+
		"\u0001\b\u0004\bT\b\b\u000b\b\f\bU\u0001\b\u0003\bY\b\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0000\u0000\n\u0000\u0002\u0004\u0006\b\n\f"+
		"\u000e\u0010\u0012\u0000\u0001\u0001\u0000\u000b\f]\u0000\u0014\u0001"+
		"\u0000\u0000\u0000\u0002\u0018\u0001\u0000\u0000\u0000\u0004 \u0001\u0000"+
		"\u0000\u0000\u0006%\u0001\u0000\u0000\u0000\b\'\u0001\u0000\u0000\u0000"+
		"\n-\u0001\u0000\u0000\u0000\f5\u0001\u0000\u0000\u0000\u000eK\u0001\u0000"+
		"\u0000\u0000\u0010S\u0001\u0000\u0000\u0000\u0012\\\u0001\u0000\u0000"+
		"\u0000\u0014\u0015\u0003\u0002\u0001\u0000\u0015\u0016\u0003\u0004\u0002"+
		"\u0000\u0016\u0017\u0005\u0000\u0000\u0001\u0017\u0001\u0001\u0000\u0000"+
		"\u0000\u0018\u0019\u0005\u0003\u0000\u0000\u0019\u001a\u0003\u0012\t\u0000"+
		"\u001a\u001b\u0005\u0007\u0000\u0000\u001b\u001c\u0006\u0001\uffff\uffff"+
		"\u0000\u001c\u0003\u0001\u0000\u0000\u0000\u001d\u001f\u0003\u0006\u0003"+
		"\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000"+
		" \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\u0005\u0001"+
		"\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000#&\u0003\b\u0004\u0000$&"+
		"\u0003\n\u0005\u0000%#\u0001\u0000\u0000\u0000%$\u0001\u0000\u0000\u0000"+
		"&\u0007\u0001\u0000\u0000\u0000\'(\u0003\u0012\t\u0000()\u0005\u0004\u0000"+
		"\u0000)*\u0005\u0006\u0000\u0000*+\u0005\u0007\u0000\u0000+,\u0006\u0004"+
		"\uffff\uffff\u0000,\t\u0001\u0000\u0000\u0000-.\u0003\u0012\t\u0000./"+
		"\u0005\b\u0000\u0000/0\u0005\t\u0000\u000001\u0005\u0005\u0000\u00001"+
		"2\u0006\u0005\uffff\uffff\u000023\u0003\f\u0006\u000034\u0005\u0007\u0000"+
		"\u00004\u000b\u0001\u0000\u0000\u00005:\u0003\u000e\u0007\u000067\u0005"+
		"\u0001\u0000\u000079\u0003\u000e\u0007\u000086\u0001\u0000\u0000\u0000"+
		"9<\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000"+
		"\u0000;\r\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=>\u0003\u0010"+
		"\b\u0000>?\u0006\u0007\uffff\uffff\u0000?A\u0001\u0000\u0000\u0000@=\u0001"+
		"\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000"+
		"BC\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DE\u0006\u0007\uffff"+
		"\uffff\u0000EL\u0001\u0000\u0000\u0000FH\u0005\u0002\u0000\u0000GI\u0005"+
		"\n\u0000\u0000HG\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0001"+
		"\u0000\u0000\u0000JL\u0006\u0007\uffff\uffff\u0000K@\u0001\u0000\u0000"+
		"\u0000KF\u0001\u0000\u0000\u0000L\u000f\u0001\u0000\u0000\u0000MO\u0003"+
		"\u0012\t\u0000NP\u0005\b\u0000\u0000ON\u0001\u0000\u0000\u0000OP\u0001"+
		"\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0006\b\uffff\uffff\u0000"+
		"RT\u0001\u0000\u0000\u0000SM\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000"+
		"\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VX\u0001\u0000"+
		"\u0000\u0000WY\u0005\n\u0000\u0000XW\u0001\u0000\u0000\u0000XY\u0001\u0000"+
		"\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0006\b\uffff\uffff\u0000[\u0011"+
		"\u0001\u0000\u0000\u0000\\]\u0007\u0000\u0000\u0000]\u0013\u0001\u0000"+
		"\u0000\u0000\t %:BHKOUX";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}