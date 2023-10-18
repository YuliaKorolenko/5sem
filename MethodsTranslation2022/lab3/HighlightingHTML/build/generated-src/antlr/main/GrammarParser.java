// Generated from Grammar.g4 by ANTLR 4.9.3

   package org.example;
   import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, AddMinus=7, MulDiv=8, 
		BoolFun=9, MyEquals=10, OutInput=11, If=12, For=13, While=14, Else=15, 
		Semi=16, Types=17, WS=18, ModAv=19, Integer=20, VarName=21, ClassName=22, 
		String=23;
	public static final int
		RULE_file = 0, RULE_function = 1, RULE_statements = 2, RULE_declarationVar = 3, 
		RULE_variableDeclaration = 4, RULE_newVariableValue = 5, RULE_outInput = 6, 
		RULE_outHelper = 7, RULE_controlStructure = 8, RULE_area = 9, RULE_myIf = 10, 
		RULE_myElse = 11, RULE_myWhile = 12, RULE_myFor = 13, RULE_operation = 14, 
		RULE_boolF = 15, RULE_boolFS = 16, RULE_equal = 17, RULE_equalS = 18, 
		RULE_addMin = 19, RULE_addMinS = 20, RULE_mulDiv = 21, RULE_mulDivS = 22, 
		RULE_myVars = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "function", "statements", "declarationVar", "variableDeclaration", 
			"newVariableValue", "outInput", "outHelper", "controlStructure", "area", 
			"myIf", "myElse", "myWhile", "myFor", "operation", "boolF", "boolFS", 
			"equal", "equalS", "addMin", "addMinS", "mulDiv", "mulDivS", "myVars"
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

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public String[] res;
		public FunctionContext function;
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			ArrayList<String> functions = new ArrayList<>();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ModAv) {
				{
				{
				setState(49);
				((FileContext)_localctx).function = function();
				Collections.addAll(functions,((FileContext)_localctx).function.res);
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			match(EOF);

			    ((FileContext)_localctx).res =  functions.toArray(String[]::new);
			    
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

	public static class FunctionContext extends ParserRuleContext {
		public String[] res;
		public Token ModAv;
		public Token Types;
		public Token ClassName;
		public DeclarationVarContext declarationVar;
		public AreaContext area;
		public TerminalNode ModAv() { return getToken(GrammarParser.ModAv, 0); }
		public TerminalNode Types() { return getToken(GrammarParser.Types, 0); }
		public TerminalNode ClassName() { return getToken(GrammarParser.ClassName, 0); }
		public AreaContext area() {
			return getRuleContext(AreaContext.class,0);
		}
		public List<DeclarationVarContext> declarationVar() {
			return getRuleContexts(DeclarationVarContext.class);
		}
		public DeclarationVarContext declarationVar(int i) {
			return getRuleContext(DeclarationVarContext.class,i);
		}
		public List<TerminalNode> Semi() { return getTokens(GrammarParser.Semi); }
		public TerminalNode Semi(int i) {
			return getToken(GrammarParser.Semi, i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			String declarations = "";
			setState(61);
			((FunctionContext)_localctx).ModAv = match(ModAv);
			setState(62);
			((FunctionContext)_localctx).Types = match(Types);
			setState(63);
			((FunctionContext)_localctx).ClassName = match(ClassName);
			setState(64);
			match(T__0);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Types) {
				{
				{
				setState(65);
				((FunctionContext)_localctx).declarationVar = declarationVar();
				setState(66);
				match(Semi);
				declarations+= ((FunctionContext)_localctx).declarationVar.resString + ";";
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			match(T__1);
			setState(75);
			((FunctionContext)_localctx).area = area();

			        ArrayList<String> myfunction = new ArrayList<>();
			        String funString = "<span style=\"color:#E67E22;\">" + (((FunctionContext)_localctx).ModAv!=null?((FunctionContext)_localctx).ModAv.getText():null) + "</span>"
			                         + " " + "<span style=\"color:#E67E22;\">" + (((FunctionContext)_localctx).Types!=null?((FunctionContext)_localctx).Types.getText():null) + "</span>"
			                         + " " + "<span style=\"color:#F4D03F;\">" + (((FunctionContext)_localctx).ClassName!=null?((FunctionContext)_localctx).ClassName.getText():null) + "</span>"
			                         + "(" + declarations + ")" + " {";
			        myfunction.add(funString);
			        Collections.addAll(myfunction, ((FunctionContext)_localctx).area.res);
			        ((FunctionContext)_localctx).res =  myfunction.toArray(String[]::new);
			    
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

	public static class StatementsContext extends ParserRuleContext {
		public String[] res;
		public ControlStructureContext controlStructure;
		public VariableDeclarationContext variableDeclaration;
		public NewVariableValueContext newVariableValue;
		public OutInputContext outInput;
		public ControlStructureContext controlStructure() {
			return getRuleContext(ControlStructureContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public NewVariableValueContext newVariableValue() {
			return getRuleContext(NewVariableValueContext.class,0);
		}
		public OutInputContext outInput() {
			return getRuleContext(OutInputContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statements);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case If:
			case For:
			case While:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				((StatementsContext)_localctx).controlStructure = controlStructure();
				((StatementsContext)_localctx).res =  ((StatementsContext)_localctx).controlStructure.res;
				}
				break;
			case Types:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				((StatementsContext)_localctx).variableDeclaration = variableDeclaration();
				((StatementsContext)_localctx).res =  new String[]{((StatementsContext)_localctx).variableDeclaration.resString+"<br>"};
				}
				break;
			case VarName:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				((StatementsContext)_localctx).newVariableValue = newVariableValue();
				((StatementsContext)_localctx).res =  new String[]{((StatementsContext)_localctx).newVariableValue.resString + ";<br>"};
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(87);
				((StatementsContext)_localctx).outInput = outInput();
				((StatementsContext)_localctx).res =  new String[]{((StatementsContext)_localctx).outInput.resString};
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

	public static class DeclarationVarContext extends ParserRuleContext {
		public String resString;
		public Token Types;
		public Token VarName;
		public TerminalNode Types() { return getToken(GrammarParser.Types, 0); }
		public TerminalNode VarName() { return getToken(GrammarParser.VarName, 0); }
		public DeclarationVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterDeclarationVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitDeclarationVar(this);
		}
	}

	public final DeclarationVarContext declarationVar() throws RecognitionException {
		DeclarationVarContext _localctx = new DeclarationVarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declarationVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			((DeclarationVarContext)_localctx).Types = match(Types);
			setState(93);
			((DeclarationVarContext)_localctx).VarName = match(VarName);

			        ((DeclarationVarContext)_localctx).resString =  "<span style=\"color:#E67E22;\">" + (((DeclarationVarContext)_localctx).Types!=null?((DeclarationVarContext)_localctx).Types.getText():null) + "</span>" + " " + (((DeclarationVarContext)_localctx).VarName!=null?((DeclarationVarContext)_localctx).VarName.getText():null);
			    
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public String resString;
		public DeclarationVarContext declarationVar;
		public OperationContext operation;
		public DeclarationVarContext declarationVar() {
			return getRuleContext(DeclarationVarContext.class,0);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode Semi() { return getToken(GrammarParser.Semi, 0); }
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitVariableDeclaration(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			((VariableDeclarationContext)_localctx).declarationVar = declarationVar();
			setState(97);
			match(T__2);
			setState(98);
			((VariableDeclarationContext)_localctx).operation = operation();
			setState(99);
			match(Semi);

			    ((VariableDeclarationContext)_localctx).resString =  ((VariableDeclarationContext)_localctx).declarationVar.resString + " = " + ((VariableDeclarationContext)_localctx).operation.resString + "  ;";
			    
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

	public static class NewVariableValueContext extends ParserRuleContext {
		public String resString;
		public Token VarName;
		public OperationContext operation;
		public TerminalNode VarName() { return getToken(GrammarParser.VarName, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public NewVariableValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newVariableValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNewVariableValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNewVariableValue(this);
		}
	}

	public final NewVariableValueContext newVariableValue() throws RecognitionException {
		NewVariableValueContext _localctx = new NewVariableValueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_newVariableValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			((NewVariableValueContext)_localctx).VarName = match(VarName);
			setState(103);
			match(T__2);
			setState(104);
			((NewVariableValueContext)_localctx).operation = operation();

			        ((NewVariableValueContext)_localctx).resString =  (((NewVariableValueContext)_localctx).VarName!=null?((NewVariableValueContext)_localctx).VarName.getText():null) + " = " + ((NewVariableValueContext)_localctx).operation.resString;
			    
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

	public static class OutInputContext extends ParserRuleContext {
		public String resString;
		public Token OutInput;
		public OutHelperContext outHelper;
		public Token Semi;
		public TerminalNode OutInput() { return getToken(GrammarParser.OutInput, 0); }
		public OutHelperContext outHelper() {
			return getRuleContext(OutHelperContext.class,0);
		}
		public TerminalNode Semi() { return getToken(GrammarParser.Semi, 0); }
		public OutInputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outInput; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOutInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOutInput(this);
		}
	}

	public final OutInputContext outInput() throws RecognitionException {
		OutInputContext _localctx = new OutInputContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_outInput);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__3);
			setState(108);
			((OutInputContext)_localctx).OutInput = match(OutInput);
			setState(109);
			match(T__0);
			setState(110);
			((OutInputContext)_localctx).outHelper = outHelper();
			setState(111);
			match(T__1);
			setState(112);
			((OutInputContext)_localctx).Semi = match(Semi);

			        ((OutInputContext)_localctx).resString =   "System." + "<span style=\"color:#8E44AD;\">" + "out" + "</span>" + "."
			        + (((OutInputContext)_localctx).OutInput!=null?((OutInputContext)_localctx).OutInput.getText():null) + "(" + ((OutInputContext)_localctx).outHelper.resString + ")" + (((OutInputContext)_localctx).Semi!=null?((OutInputContext)_localctx).Semi.getText():null) + "<br>";
			    
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

	public static class OutHelperContext extends ParserRuleContext {
		public String resString;
		public Token Integer;
		public Token VarName;
		public Token String;
		public TerminalNode Integer() { return getToken(GrammarParser.Integer, 0); }
		public TerminalNode VarName() { return getToken(GrammarParser.VarName, 0); }
		public TerminalNode String() { return getToken(GrammarParser.String, 0); }
		public OutHelperContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outHelper; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOutHelper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOutHelper(this);
		}
	}

	public final OutHelperContext outHelper() throws RecognitionException {
		OutHelperContext _localctx = new OutHelperContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_outHelper);
		try {
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integer:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				((OutHelperContext)_localctx).Integer = match(Integer);
				((OutHelperContext)_localctx).resString =  (((OutHelperContext)_localctx).Integer!=null?((OutHelperContext)_localctx).Integer.getText():null);
				}
				break;
			case VarName:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				((OutHelperContext)_localctx).VarName = match(VarName);
				((OutHelperContext)_localctx).resString =  (((OutHelperContext)_localctx).VarName!=null?((OutHelperContext)_localctx).VarName.getText():null);
				}
				break;
			case String:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				((OutHelperContext)_localctx).String = match(String);
				((OutHelperContext)_localctx).resString =   (((OutHelperContext)_localctx).String!=null?((OutHelperContext)_localctx).String.getText():null);
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

	public static class ControlStructureContext extends ParserRuleContext {
		public String[] res;
		public MyIfContext myIf;
		public MyForContext myFor;
		public MyWhileContext myWhile;
		public MyIfContext myIf() {
			return getRuleContext(MyIfContext.class,0);
		}
		public MyForContext myFor() {
			return getRuleContext(MyForContext.class,0);
		}
		public MyWhileContext myWhile() {
			return getRuleContext(MyWhileContext.class,0);
		}
		public ControlStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlStructure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterControlStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitControlStructure(this);
		}
	}

	public final ControlStructureContext controlStructure() throws RecognitionException {
		ControlStructureContext _localctx = new ControlStructureContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_controlStructure);
		try {
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case If:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				((ControlStructureContext)_localctx).myIf = myIf();
				((ControlStructureContext)_localctx).res =  ((ControlStructureContext)_localctx).myIf.res;
				}
				break;
			case For:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				((ControlStructureContext)_localctx).myFor = myFor();
				((ControlStructureContext)_localctx).res =  ((ControlStructureContext)_localctx).myFor.res;
				}
				break;
			case While:
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				((ControlStructureContext)_localctx).myWhile = myWhile();
				((ControlStructureContext)_localctx).res =  ((ControlStructureContext)_localctx).myWhile.res;
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

	public static class AreaContext extends ParserRuleContext {
		public String[] res;
		public StatementsContext statements;
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public AreaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_area; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterArea(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitArea(this);
		}
	}

	public final AreaContext area() throws RecognitionException {
		AreaContext _localctx = new AreaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_area);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ArrayList<String> myStatements = new ArrayList<>();
			        myStatements.add("<br>");
			      
			setState(135);
			match(T__4);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << If) | (1L << For) | (1L << While) | (1L << Types) | (1L << VarName))) != 0)) {
				{
				{
				setState(136);
				((AreaContext)_localctx).statements = statements();
				 Collections.addAll(myStatements,((AreaContext)_localctx).statements.res);
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(144);
			match(T__5);

			        for (int i = 0; i < myStatements.size(); i++){
			            myStatements.set(i, "&nbsp;&nbsp;&nbsp;&nbsp;" + myStatements.get(i));
			        }
			        myStatements.add("}<br>");

			        ((AreaContext)_localctx).res =  myStatements.toArray(String[]::new);
			    
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

	public static class MyIfContext extends ParserRuleContext {
		public String[] res;
		public Token If;
		public OperationContext operation;
		public AreaContext area;
		public MyElseContext myElse;
		public TerminalNode If() { return getToken(GrammarParser.If, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public AreaContext area() {
			return getRuleContext(AreaContext.class,0);
		}
		public MyElseContext myElse() {
			return getRuleContext(MyElseContext.class,0);
		}
		public MyIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_myIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterMyIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitMyIf(this);
		}
	}

	public final MyIfContext myIf() throws RecognitionException {
		MyIfContext _localctx = new MyIfContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_myIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			((MyIfContext)_localctx).If = match(If);
			setState(148);
			match(T__0);
			setState(149);
			((MyIfContext)_localctx).operation = operation();
			setState(150);
			match(T__1);
			setState(151);
			((MyIfContext)_localctx).area = area();
			setState(152);
			((MyIfContext)_localctx).myElse = myElse();

			        ArrayList<String> ifStrings = new ArrayList<>();
			        ifStrings.add("<span style=\"color:#2980B9;\">" + (((MyIfContext)_localctx).If!=null?((MyIfContext)_localctx).If.getText():null) + "</span>"
			        + " (" + ((MyIfContext)_localctx).operation.resString + ") {");
			        Collections.addAll(ifStrings, ((MyIfContext)_localctx).area.res);
			        Collections.addAll(ifStrings, ((MyIfContext)_localctx).myElse.res);
			        ((MyIfContext)_localctx).res =  ifStrings.toArray(String[]::new);
			    
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

	public static class MyElseContext extends ParserRuleContext {
		public String[] res;
		public Token Else;
		public AreaContext area;
		public MyIfContext myIf;
		public TerminalNode Else() { return getToken(GrammarParser.Else, 0); }
		public AreaContext area() {
			return getRuleContext(AreaContext.class,0);
		}
		public MyIfContext myIf() {
			return getRuleContext(MyIfContext.class,0);
		}
		public MyElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_myElse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterMyElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitMyElse(this);
		}
	}

	public final MyElseContext myElse() throws RecognitionException {
		MyElseContext _localctx = new MyElseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_myElse);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				((MyElseContext)_localctx).Else = match(Else);
				setState(156);
				((MyElseContext)_localctx).area = area();

				         ArrayList<String> elseStrings = new ArrayList<>();
				         elseStrings.add("<span style=\"color:#2980B9;\">" + (((MyElseContext)_localctx).Else!=null?((MyElseContext)_localctx).Else.getText():null) + "</span>" +" {");
				         Collections.addAll(elseStrings, ((MyElseContext)_localctx).area.res);
				         ((MyElseContext)_localctx).res =  elseStrings.toArray(String[]::new);
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				((MyElseContext)_localctx).Else = match(Else);
				setState(160);
				((MyElseContext)_localctx).myIf = myIf();

				        ArrayList<String> elseStrings = new ArrayList<>();
				        elseStrings.add("<span style=\"color:#2980B9;\">" + (((MyElseContext)_localctx).Else!=null?((MyElseContext)_localctx).Else.getText():null) + "</span>");
				        Collections.addAll(elseStrings, ((MyElseContext)_localctx).myIf.res);
				        ((MyElseContext)_localctx).res =  elseStrings.toArray(String[]::new);
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				((MyElseContext)_localctx).res =  new String[0];
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

	public static class MyWhileContext extends ParserRuleContext {
		public String[] res;
		public Token While;
		public OperationContext operation;
		public AreaContext area;
		public TerminalNode While() { return getToken(GrammarParser.While, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public AreaContext area() {
			return getRuleContext(AreaContext.class,0);
		}
		public MyWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_myWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterMyWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitMyWhile(this);
		}
	}

	public final MyWhileContext myWhile() throws RecognitionException {
		MyWhileContext _localctx = new MyWhileContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_myWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			((MyWhileContext)_localctx).While = match(While);
			setState(167);
			match(T__0);
			setState(168);
			((MyWhileContext)_localctx).operation = operation();
			setState(169);
			match(T__1);
			setState(170);
			((MyWhileContext)_localctx).area = area();

			        ArrayList<String> whileStrings = new ArrayList<>();
			        whileStrings.add("<span style=\"color:#2980B9;\">" + (((MyWhileContext)_localctx).While!=null?((MyWhileContext)_localctx).While.getText():null) + "</span>"
			        + " (" + ((MyWhileContext)_localctx).operation.resString + ") {");
			        Collections.addAll(whileStrings, ((MyWhileContext)_localctx).area.res);
			        ((MyWhileContext)_localctx).res =  whileStrings.toArray(String[]::new);
			    
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

	public static class MyForContext extends ParserRuleContext {
		public String[] res;
		public Token For;
		public VariableDeclarationContext variableDeclaration;
		public OperationContext operation;
		public NewVariableValueContext newVariableValue;
		public AreaContext area;
		public TerminalNode For() { return getToken(GrammarParser.For, 0); }
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode Semi() { return getToken(GrammarParser.Semi, 0); }
		public NewVariableValueContext newVariableValue() {
			return getRuleContext(NewVariableValueContext.class,0);
		}
		public AreaContext area() {
			return getRuleContext(AreaContext.class,0);
		}
		public MyForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_myFor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterMyFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitMyFor(this);
		}
	}

	public final MyForContext myFor() throws RecognitionException {
		MyForContext _localctx = new MyForContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_myFor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			((MyForContext)_localctx).For = match(For);
			setState(174);
			match(T__0);
			setState(175);
			((MyForContext)_localctx).variableDeclaration = variableDeclaration();
			setState(176);
			((MyForContext)_localctx).operation = operation();
			setState(177);
			match(Semi);
			setState(178);
			((MyForContext)_localctx).newVariableValue = newVariableValue();
			setState(179);
			match(T__1);
			setState(180);
			((MyForContext)_localctx).area = area();

			        ArrayList<String> forStrings = new ArrayList<>();
			        forStrings.add("<span style=\"color:#2980B9;\">" + (((MyForContext)_localctx).For!=null?((MyForContext)_localctx).For.getText():null) +  "</span>"
			        + " (" + ((MyForContext)_localctx).variableDeclaration.resString + " " + ((MyForContext)_localctx).operation.resString + " ; "
			        + ((MyForContext)_localctx).newVariableValue.resString + ") {");
			        Collections.addAll(forStrings, ((MyForContext)_localctx).area.res);
			        ((MyForContext)_localctx).res =  forStrings.toArray(String[]::new);
			    
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

	public static class OperationContext extends ParserRuleContext {
		public String resString;
		public BoolFContext boolF;
		public BoolFContext boolF() {
			return getRuleContext(BoolFContext.class,0);
		}
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOperation(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			((OperationContext)_localctx).boolF = boolF();
			((OperationContext)_localctx).resString =  ((OperationContext)_localctx).boolF.resString;
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

	public static class BoolFContext extends ParserRuleContext {
		public String resString;
		public EqualContext equal;
		public BoolFSContext boolFS;
		public EqualContext equal() {
			return getRuleContext(EqualContext.class,0);
		}
		public BoolFSContext boolFS() {
			return getRuleContext(BoolFSContext.class,0);
		}
		public BoolFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBoolF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBoolF(this);
		}
	}

	public final BoolFContext boolF() throws RecognitionException {
		BoolFContext _localctx = new BoolFContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_boolF);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			((BoolFContext)_localctx).equal = equal();
			setState(187);
			((BoolFContext)_localctx).boolFS = boolFS();
			((BoolFContext)_localctx).resString =  ((BoolFContext)_localctx).equal.resString + ((BoolFContext)_localctx).boolFS.resString;
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

	public static class BoolFSContext extends ParserRuleContext {
		public String resString;
		public Token BoolFun;
		public EqualContext equal;
		public BoolFSContext boolFS;
		public TerminalNode BoolFun() { return getToken(GrammarParser.BoolFun, 0); }
		public EqualContext equal() {
			return getRuleContext(EqualContext.class,0);
		}
		public BoolFSContext boolFS() {
			return getRuleContext(BoolFSContext.class,0);
		}
		public BoolFSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolFS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBoolFS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBoolFS(this);
		}
	}

	public final BoolFSContext boolFS() throws RecognitionException {
		BoolFSContext _localctx = new BoolFSContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_boolFS);
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BoolFun:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				((BoolFSContext)_localctx).BoolFun = match(BoolFun);
				setState(191);
				((BoolFSContext)_localctx).equal = equal();
				setState(192);
				((BoolFSContext)_localctx).boolFS = boolFS();
				((BoolFSContext)_localctx).resString =  "abf" + (((BoolFSContext)_localctx).BoolFun!=null?((BoolFSContext)_localctx).BoolFun.getText():null) + "bbf" + ((BoolFSContext)_localctx).equal.resString + ((BoolFSContext)_localctx).boolFS.resString;
				}
				break;
			case T__1:
			case T__3:
			case T__5:
			case If:
			case For:
			case While:
			case Semi:
			case Types:
			case VarName:
				enterOuterAlt(_localctx, 2);
				{
				((BoolFSContext)_localctx).resString = "";
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

	public static class EqualContext extends ParserRuleContext {
		public String resString;
		public AddMinContext addMin;
		public EqualSContext equalS;
		public AddMinContext addMin() {
			return getRuleContext(AddMinContext.class,0);
		}
		public EqualSContext equalS() {
			return getRuleContext(EqualSContext.class,0);
		}
		public EqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEqual(this);
		}
	}

	public final EqualContext equal() throws RecognitionException {
		EqualContext _localctx = new EqualContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_equal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			((EqualContext)_localctx).addMin = addMin();
			setState(199);
			((EqualContext)_localctx).equalS = equalS();
			((EqualContext)_localctx).resString =  ((EqualContext)_localctx).addMin.resString + ((EqualContext)_localctx).equalS.resString;
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

	public static class EqualSContext extends ParserRuleContext {
		public String resString;
		public Token MyEquals;
		public AddMinContext addMin;
		public EqualSContext equalS;
		public TerminalNode MyEquals() { return getToken(GrammarParser.MyEquals, 0); }
		public AddMinContext addMin() {
			return getRuleContext(AddMinContext.class,0);
		}
		public EqualSContext equalS() {
			return getRuleContext(EqualSContext.class,0);
		}
		public EqualSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterEqualS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitEqualS(this);
		}
	}

	public final EqualSContext equalS() throws RecognitionException {
		EqualSContext _localctx = new EqualSContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_equalS);
		try {
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MyEquals:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				((EqualSContext)_localctx).MyEquals = match(MyEquals);
				setState(203);
				((EqualSContext)_localctx).addMin = addMin();
				setState(204);
				((EqualSContext)_localctx).equalS = equalS();
				((EqualSContext)_localctx).resString =  " " + (((EqualSContext)_localctx).MyEquals!=null?((EqualSContext)_localctx).MyEquals.getText():null) + " " + ((EqualSContext)_localctx).addMin.resString  + ((EqualSContext)_localctx).equalS.resString;
				}
				break;
			case T__1:
			case T__3:
			case T__5:
			case BoolFun:
			case If:
			case For:
			case While:
			case Semi:
			case Types:
			case VarName:
				enterOuterAlt(_localctx, 2);
				{
				((EqualSContext)_localctx).resString =  "";
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

	public static class AddMinContext extends ParserRuleContext {
		public String resString;
		public MulDivContext mulDiv;
		public AddMinSContext addMinS;
		public MulDivContext mulDiv() {
			return getRuleContext(MulDivContext.class,0);
		}
		public AddMinSContext addMinS() {
			return getRuleContext(AddMinSContext.class,0);
		}
		public AddMinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addMin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAddMin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAddMin(this);
		}
	}

	public final AddMinContext addMin() throws RecognitionException {
		AddMinContext _localctx = new AddMinContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_addMin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			((AddMinContext)_localctx).mulDiv = mulDiv();
			setState(211);
			((AddMinContext)_localctx).addMinS = addMinS();
			((AddMinContext)_localctx).resString =  ((AddMinContext)_localctx).mulDiv.resString + ((AddMinContext)_localctx).addMinS.resString;
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

	public static class AddMinSContext extends ParserRuleContext {
		public String resString;
		public Token AddMinus;
		public MulDivContext mulDiv;
		public AddMinSContext addMinS;
		public TerminalNode AddMinus() { return getToken(GrammarParser.AddMinus, 0); }
		public MulDivContext mulDiv() {
			return getRuleContext(MulDivContext.class,0);
		}
		public AddMinSContext addMinS() {
			return getRuleContext(AddMinSContext.class,0);
		}
		public AddMinSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addMinS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAddMinS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAddMinS(this);
		}
	}

	public final AddMinSContext addMinS() throws RecognitionException {
		AddMinSContext _localctx = new AddMinSContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_addMinS);
		try {
			setState(220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AddMinus:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				((AddMinSContext)_localctx).AddMinus = match(AddMinus);
				setState(215);
				((AddMinSContext)_localctx).mulDiv = mulDiv();
				setState(216);
				((AddMinSContext)_localctx).addMinS = addMinS();
				((AddMinSContext)_localctx).resString =  " " + (((AddMinSContext)_localctx).AddMinus!=null?((AddMinSContext)_localctx).AddMinus.getText():null) + " " + ((AddMinSContext)_localctx).mulDiv.resString + ((AddMinSContext)_localctx).addMinS.resString;
				}
				break;
			case T__1:
			case T__3:
			case T__5:
			case BoolFun:
			case MyEquals:
			case If:
			case For:
			case While:
			case Semi:
			case Types:
			case VarName:
				enterOuterAlt(_localctx, 2);
				{
				((AddMinSContext)_localctx).resString =  "";
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

	public static class MulDivContext extends ParserRuleContext {
		public String resString;
		public MyVarsContext myVars;
		public MulDivSContext mulDivS;
		public MyVarsContext myVars() {
			return getRuleContext(MyVarsContext.class,0);
		}
		public MulDivSContext mulDivS() {
			return getRuleContext(MulDivSContext.class,0);
		}
		public MulDivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulDiv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitMulDiv(this);
		}
	}

	public final MulDivContext mulDiv() throws RecognitionException {
		MulDivContext _localctx = new MulDivContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_mulDiv);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			((MulDivContext)_localctx).myVars = myVars();
			setState(223);
			((MulDivContext)_localctx).mulDivS = mulDivS();
			((MulDivContext)_localctx).resString =  ((MulDivContext)_localctx).myVars.resString + ((MulDivContext)_localctx).mulDivS.resString;
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

	public static class MulDivSContext extends ParserRuleContext {
		public String resString;
		public Token MulDiv;
		public MyVarsContext myVars;
		public MulDivSContext mulDivS;
		public TerminalNode MulDiv() { return getToken(GrammarParser.MulDiv, 0); }
		public MyVarsContext myVars() {
			return getRuleContext(MyVarsContext.class,0);
		}
		public MulDivSContext mulDivS() {
			return getRuleContext(MulDivSContext.class,0);
		}
		public MulDivSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulDivS; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterMulDivS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitMulDivS(this);
		}
	}

	public final MulDivSContext mulDivS() throws RecognitionException {
		MulDivSContext _localctx = new MulDivSContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_mulDivS);
		try {
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MulDiv:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				((MulDivSContext)_localctx).MulDiv = match(MulDiv);
				setState(227);
				((MulDivSContext)_localctx).myVars = myVars();
				setState(228);
				((MulDivSContext)_localctx).mulDivS = mulDivS();
				 ((MulDivSContext)_localctx).resString =  " " + (((MulDivSContext)_localctx).MulDiv!=null?((MulDivSContext)_localctx).MulDiv.getText():null) + " " + ((MulDivSContext)_localctx).myVars.resString + ((MulDivSContext)_localctx).mulDivS.resString;
				}
				break;
			case T__1:
			case T__3:
			case T__5:
			case AddMinus:
			case BoolFun:
			case MyEquals:
			case If:
			case For:
			case While:
			case Semi:
			case Types:
			case VarName:
				enterOuterAlt(_localctx, 2);
				{
				((MulDivSContext)_localctx).resString =  "";
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

	public static class MyVarsContext extends ParserRuleContext {
		public String resString;
		public OperationContext operation;
		public Token Integer;
		public Token VarName;
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode Integer() { return getToken(GrammarParser.Integer, 0); }
		public TerminalNode VarName() { return getToken(GrammarParser.VarName, 0); }
		public MyVarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_myVars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterMyVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitMyVars(this);
		}
	}

	public final MyVarsContext myVars() throws RecognitionException {
		MyVarsContext _localctx = new MyVarsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_myVars);
		try {
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				match(T__0);
				setState(235);
				((MyVarsContext)_localctx).operation = operation();
				setState(236);
				match(T__1);
				((MyVarsContext)_localctx).resString =  "(" + ((MyVarsContext)_localctx).operation.resString + ")" ;
				}
				break;
			case Integer:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				((MyVarsContext)_localctx).Integer = match(Integer);
				((MyVarsContext)_localctx).resString =  (((MyVarsContext)_localctx).Integer!=null?((MyVarsContext)_localctx).Integer.getText():null);
				}
				break;
			case VarName:
				enterOuterAlt(_localctx, 3);
				{
				setState(241);
				((MyVarsContext)_localctx).VarName = match(VarName);
				((MyVarsContext)_localctx).resString =  (((MyVarsContext)_localctx).VarName!=null?((MyVarsContext)_localctx).VarName.getText():null);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31\u00f8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\7\3H\n\3\f\3\16\3K\13\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4]\n\4\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\5\t|\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\n\u0087\n\n\3\13\3\13\3\13\3\13\3\13\7\13\u008e\n\13\f\13\16\13\u0091"+
		"\13\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u00a7\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00c7\n\22\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00d3\n\24\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00df\n\26\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00eb\n\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\5\31\u00f6\n\31\3\31\2\2\32\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\2\2\2\u00f1\2\62\3\2\2\2\4>\3\2\2\2\6\\"+
		"\3\2\2\2\b^\3\2\2\2\nb\3\2\2\2\fh\3\2\2\2\16m\3\2\2\2\20{\3\2\2\2\22\u0086"+
		"\3\2\2\2\24\u0088\3\2\2\2\26\u0095\3\2\2\2\30\u00a6\3\2\2\2\32\u00a8\3"+
		"\2\2\2\34\u00af\3\2\2\2\36\u00b9\3\2\2\2 \u00bc\3\2\2\2\"\u00c6\3\2\2"+
		"\2$\u00c8\3\2\2\2&\u00d2\3\2\2\2(\u00d4\3\2\2\2*\u00de\3\2\2\2,\u00e0"+
		"\3\2\2\2.\u00ea\3\2\2\2\60\u00f5\3\2\2\2\628\b\2\1\2\63\64\5\4\3\2\64"+
		"\65\b\2\1\2\65\67\3\2\2\2\66\63\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2"+
		"\2\29;\3\2\2\2:8\3\2\2\2;<\7\2\2\3<=\b\2\1\2=\3\3\2\2\2>?\b\3\1\2?@\7"+
		"\25\2\2@A\7\23\2\2AB\7\30\2\2BI\7\3\2\2CD\5\b\5\2DE\7\22\2\2EF\b\3\1\2"+
		"FH\3\2\2\2GC\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2"+
		"LM\7\4\2\2MN\5\24\13\2NO\b\3\1\2O\5\3\2\2\2PQ\5\22\n\2QR\b\4\1\2R]\3\2"+
		"\2\2ST\5\n\6\2TU\b\4\1\2U]\3\2\2\2VW\5\f\7\2WX\b\4\1\2X]\3\2\2\2YZ\5\16"+
		"\b\2Z[\b\4\1\2[]\3\2\2\2\\P\3\2\2\2\\S\3\2\2\2\\V\3\2\2\2\\Y\3\2\2\2]"+
		"\7\3\2\2\2^_\7\23\2\2_`\7\27\2\2`a\b\5\1\2a\t\3\2\2\2bc\5\b\5\2cd\7\5"+
		"\2\2de\5\36\20\2ef\7\22\2\2fg\b\6\1\2g\13\3\2\2\2hi\7\27\2\2ij\7\5\2\2"+
		"jk\5\36\20\2kl\b\7\1\2l\r\3\2\2\2mn\7\6\2\2no\7\r\2\2op\7\3\2\2pq\5\20"+
		"\t\2qr\7\4\2\2rs\7\22\2\2st\b\b\1\2t\17\3\2\2\2uv\7\26\2\2v|\b\t\1\2w"+
		"x\7\27\2\2x|\b\t\1\2yz\7\31\2\2z|\b\t\1\2{u\3\2\2\2{w\3\2\2\2{y\3\2\2"+
		"\2|\21\3\2\2\2}~\5\26\f\2~\177\b\n\1\2\177\u0087\3\2\2\2\u0080\u0081\5"+
		"\34\17\2\u0081\u0082\b\n\1\2\u0082\u0087\3\2\2\2\u0083\u0084\5\32\16\2"+
		"\u0084\u0085\b\n\1\2\u0085\u0087\3\2\2\2\u0086}\3\2\2\2\u0086\u0080\3"+
		"\2\2\2\u0086\u0083\3\2\2\2\u0087\23\3\2\2\2\u0088\u0089\b\13\1\2\u0089"+
		"\u008f\7\7\2\2\u008a\u008b\5\6\4\2\u008b\u008c\b\13\1\2\u008c\u008e\3"+
		"\2\2\2\u008d\u008a\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093\7\b"+
		"\2\2\u0093\u0094\b\13\1\2\u0094\25\3\2\2\2\u0095\u0096\7\16\2\2\u0096"+
		"\u0097\7\3\2\2\u0097\u0098\5\36\20\2\u0098\u0099\7\4\2\2\u0099\u009a\5"+
		"\24\13\2\u009a\u009b\5\30\r\2\u009b\u009c\b\f\1\2\u009c\27\3\2\2\2\u009d"+
		"\u009e\7\21\2\2\u009e\u009f\5\24\13\2\u009f\u00a0\b\r\1\2\u00a0\u00a7"+
		"\3\2\2\2\u00a1\u00a2\7\21\2\2\u00a2\u00a3\5\26\f\2\u00a3\u00a4\b\r\1\2"+
		"\u00a4\u00a7\3\2\2\2\u00a5\u00a7\b\r\1\2\u00a6\u009d\3\2\2\2\u00a6\u00a1"+
		"\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\31\3\2\2\2\u00a8\u00a9\7\20\2\2\u00a9"+
		"\u00aa\7\3\2\2\u00aa\u00ab\5\36\20\2\u00ab\u00ac\7\4\2\2\u00ac\u00ad\5"+
		"\24\13\2\u00ad\u00ae\b\16\1\2\u00ae\33\3\2\2\2\u00af\u00b0\7\17\2\2\u00b0"+
		"\u00b1\7\3\2\2\u00b1\u00b2\5\n\6\2\u00b2\u00b3\5\36\20\2\u00b3\u00b4\7"+
		"\22\2\2\u00b4\u00b5\5\f\7\2\u00b5\u00b6\7\4\2\2\u00b6\u00b7\5\24\13\2"+
		"\u00b7\u00b8\b\17\1\2\u00b8\35\3\2\2\2\u00b9\u00ba\5 \21\2\u00ba\u00bb"+
		"\b\20\1\2\u00bb\37\3\2\2\2\u00bc\u00bd\5$\23\2\u00bd\u00be\5\"\22\2\u00be"+
		"\u00bf\b\21\1\2\u00bf!\3\2\2\2\u00c0\u00c1\7\13\2\2\u00c1\u00c2\5$\23"+
		"\2\u00c2\u00c3\5\"\22\2\u00c3\u00c4\b\22\1\2\u00c4\u00c7\3\2\2\2\u00c5"+
		"\u00c7\b\22\1\2\u00c6\u00c0\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7#\3\2\2\2"+
		"\u00c8\u00c9\5(\25\2\u00c9\u00ca\5&\24\2\u00ca\u00cb\b\23\1\2\u00cb%\3"+
		"\2\2\2\u00cc\u00cd\7\f\2\2\u00cd\u00ce\5(\25\2\u00ce\u00cf\5&\24\2\u00cf"+
		"\u00d0\b\24\1\2\u00d0\u00d3\3\2\2\2\u00d1\u00d3\b\24\1\2\u00d2\u00cc\3"+
		"\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\'\3\2\2\2\u00d4\u00d5\5,\27\2\u00d5\u00d6"+
		"\5*\26\2\u00d6\u00d7\b\25\1\2\u00d7)\3\2\2\2\u00d8\u00d9\7\t\2\2\u00d9"+
		"\u00da\5,\27\2\u00da\u00db\5*\26\2\u00db\u00dc\b\26\1\2\u00dc\u00df\3"+
		"\2\2\2\u00dd\u00df\b\26\1\2\u00de\u00d8\3\2\2\2\u00de\u00dd\3\2\2\2\u00df"+
		"+\3\2\2\2\u00e0\u00e1\5\60\31\2\u00e1\u00e2\5.\30\2\u00e2\u00e3\b\27\1"+
		"\2\u00e3-\3\2\2\2\u00e4\u00e5\7\n\2\2\u00e5\u00e6\5\60\31\2\u00e6\u00e7"+
		"\5.\30\2\u00e7\u00e8\b\30\1\2\u00e8\u00eb\3\2\2\2\u00e9\u00eb\b\30\1\2"+
		"\u00ea\u00e4\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb/\3\2\2\2\u00ec\u00ed\7"+
		"\3\2\2\u00ed\u00ee\5\36\20\2\u00ee\u00ef\7\4\2\2\u00ef\u00f0\b\31\1\2"+
		"\u00f0\u00f6\3\2\2\2\u00f1\u00f2\7\26\2\2\u00f2\u00f6\b\31\1\2\u00f3\u00f4"+
		"\7\27\2\2\u00f4\u00f6\b\31\1\2\u00f5\u00ec\3\2\2\2\u00f5\u00f1\3\2\2\2"+
		"\u00f5\u00f3\3\2\2\2\u00f6\61\3\2\2\2\168I\\{\u0086\u008f\u00a6\u00c6"+
		"\u00d2\u00de\u00ea\u00f5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}