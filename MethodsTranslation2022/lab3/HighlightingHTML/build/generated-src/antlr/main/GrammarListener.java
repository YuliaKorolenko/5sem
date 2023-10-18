// Generated from Grammar.g4 by ANTLR 4.9.3

   package org.example;
   import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(GrammarParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(GrammarParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(GrammarParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(GrammarParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(GrammarParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(GrammarParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#declarationVar}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationVar(GrammarParser.DeclarationVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#declarationVar}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationVar(GrammarParser.DeclarationVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(GrammarParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(GrammarParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#newVariableValue}.
	 * @param ctx the parse tree
	 */
	void enterNewVariableValue(GrammarParser.NewVariableValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#newVariableValue}.
	 * @param ctx the parse tree
	 */
	void exitNewVariableValue(GrammarParser.NewVariableValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#outInput}.
	 * @param ctx the parse tree
	 */
	void enterOutInput(GrammarParser.OutInputContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#outInput}.
	 * @param ctx the parse tree
	 */
	void exitOutInput(GrammarParser.OutInputContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#outHelper}.
	 * @param ctx the parse tree
	 */
	void enterOutHelper(GrammarParser.OutHelperContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#outHelper}.
	 * @param ctx the parse tree
	 */
	void exitOutHelper(GrammarParser.OutHelperContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#controlStructure}.
	 * @param ctx the parse tree
	 */
	void enterControlStructure(GrammarParser.ControlStructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#controlStructure}.
	 * @param ctx the parse tree
	 */
	void exitControlStructure(GrammarParser.ControlStructureContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#area}.
	 * @param ctx the parse tree
	 */
	void enterArea(GrammarParser.AreaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#area}.
	 * @param ctx the parse tree
	 */
	void exitArea(GrammarParser.AreaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#myIf}.
	 * @param ctx the parse tree
	 */
	void enterMyIf(GrammarParser.MyIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#myIf}.
	 * @param ctx the parse tree
	 */
	void exitMyIf(GrammarParser.MyIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#myElse}.
	 * @param ctx the parse tree
	 */
	void enterMyElse(GrammarParser.MyElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#myElse}.
	 * @param ctx the parse tree
	 */
	void exitMyElse(GrammarParser.MyElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#myWhile}.
	 * @param ctx the parse tree
	 */
	void enterMyWhile(GrammarParser.MyWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#myWhile}.
	 * @param ctx the parse tree
	 */
	void exitMyWhile(GrammarParser.MyWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#myFor}.
	 * @param ctx the parse tree
	 */
	void enterMyFor(GrammarParser.MyForContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#myFor}.
	 * @param ctx the parse tree
	 */
	void exitMyFor(GrammarParser.MyForContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(GrammarParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(GrammarParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#boolF}.
	 * @param ctx the parse tree
	 */
	void enterBoolF(GrammarParser.BoolFContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#boolF}.
	 * @param ctx the parse tree
	 */
	void exitBoolF(GrammarParser.BoolFContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#boolFS}.
	 * @param ctx the parse tree
	 */
	void enterBoolFS(GrammarParser.BoolFSContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#boolFS}.
	 * @param ctx the parse tree
	 */
	void exitBoolFS(GrammarParser.BoolFSContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#equal}.
	 * @param ctx the parse tree
	 */
	void enterEqual(GrammarParser.EqualContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#equal}.
	 * @param ctx the parse tree
	 */
	void exitEqual(GrammarParser.EqualContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#equalS}.
	 * @param ctx the parse tree
	 */
	void enterEqualS(GrammarParser.EqualSContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#equalS}.
	 * @param ctx the parse tree
	 */
	void exitEqualS(GrammarParser.EqualSContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#addMin}.
	 * @param ctx the parse tree
	 */
	void enterAddMin(GrammarParser.AddMinContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#addMin}.
	 * @param ctx the parse tree
	 */
	void exitAddMin(GrammarParser.AddMinContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#addMinS}.
	 * @param ctx the parse tree
	 */
	void enterAddMinS(GrammarParser.AddMinSContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#addMinS}.
	 * @param ctx the parse tree
	 */
	void exitAddMinS(GrammarParser.AddMinSContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#mulDiv}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(GrammarParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#mulDiv}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(GrammarParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#mulDivS}.
	 * @param ctx the parse tree
	 */
	void enterMulDivS(GrammarParser.MulDivSContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#mulDivS}.
	 * @param ctx the parse tree
	 */
	void exitMulDivS(GrammarParser.MulDivSContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#myVars}.
	 * @param ctx the parse tree
	 */
	void enterMyVars(GrammarParser.MyVarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#myVars}.
	 * @param ctx the parse tree
	 */
	void exitMyVars(GrammarParser.MyVarsContext ctx);
}