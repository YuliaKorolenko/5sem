// Generated from java-escape by ANTLR 4.11.1

   import info.*;
   import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyGrammarParser}.
 */
public interface MyGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#myGrammar}.
	 * @param ctx the parse tree
	 */
	void enterMyGrammar(MyGrammarParser.MyGrammarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#myGrammar}.
	 * @param ctx the parse tree
	 */
	void exitMyGrammar(MyGrammarParser.MyGrammarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#grammarHeader}.
	 * @param ctx the parse tree
	 */
	void enterGrammarHeader(MyGrammarParser.GrammarHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#grammarHeader}.
	 * @param ctx the parse tree
	 */
	void exitGrammarHeader(MyGrammarParser.GrammarHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#rules}.
	 * @param ctx the parse tree
	 */
	void enterRules(MyGrammarParser.RulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#rules}.
	 * @param ctx the parse tree
	 */
	void exitRules(MyGrammarParser.RulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#rule}.
	 * @param ctx the parse tree
	 */
	void enterRule(MyGrammarParser.RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#rule}.
	 * @param ctx the parse tree
	 */
	void exitRule(MyGrammarParser.RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#terminalRule}.
	 * @param ctx the parse tree
	 */
	void enterTerminalRule(MyGrammarParser.TerminalRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#terminalRule}.
	 * @param ctx the parse tree
	 */
	void exitTerminalRule(MyGrammarParser.TerminalRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#nonTerminalRule}.
	 * @param ctx the parse tree
	 */
	void enterNonTerminalRule(MyGrammarParser.NonTerminalRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#nonTerminalRule}.
	 * @param ctx the parse tree
	 */
	void exitNonTerminalRule(MyGrammarParser.NonTerminalRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#parts}.
	 * @param ctx the parse tree
	 */
	void enterParts(MyGrammarParser.PartsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#parts}.
	 * @param ctx the parse tree
	 */
	void exitParts(MyGrammarParser.PartsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#part}.
	 * @param ctx the parse tree
	 */
	void enterPart(MyGrammarParser.PartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#part}.
	 * @param ctx the parse tree
	 */
	void exitPart(MyGrammarParser.PartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(MyGrammarParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(MyGrammarParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyGrammarParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(MyGrammarParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyGrammarParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(MyGrammarParser.NameContext ctx);
}