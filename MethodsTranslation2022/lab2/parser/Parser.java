package parser;

import parser.LexicalAnalyzer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;

public class Parser {
    LexicalAnalyzer lex;



    Tree R() throws ParseException {
        System.out.println("CurrentChar" + lex.curToken + " R ");
        switch (lex.curToken()) {
            case NOT, N, LPAREN:
                return new Tree("R", S(), RPrime());
            default:
                throw new AssertionError("Expected : '!', N, (. Actual: " + lex.curToken);
        }
    }


    Tree RPrime() throws ParseException {
        System.out.println("CurrentChar" + lex.curToken + " RPrime ");
        switch (lex.curToken()) {
            case PIER:
                lex.nextToken();
                return new Tree("RPrime", new Tree("XOR") , S(), RPrime());
            case RPAREN, END:
                return new Tree("Eps");
            default:
                throw new AssertionError("Expected : '^', '(' or end of string. Actual: " + lex.curToken);
        }
    }


    Tree S() throws ParseException {
        System.out.println("CurrentChar" + lex.curToken + " S ");
        switch (lex.curToken()) {
            case NOT, N, LPAREN:
                return new Tree("S", T(), SPrime());
            default:
                throw new AssertionError("Expected : '!', N, (. Actual: " + lex.curToken);
        }
    }


    Tree SPrime() throws ParseException {
        System.out.println("CurrentChar" + lex.curToken + " SPrime ");
        switch (lex.curToken()) {
            case XOR:
                lex.nextToken();
                return new Tree("SPrime", new Tree("XOR") , T(), SPrime());
            case RPAREN, END, PIER:
                return new Tree("Eps");
            default:
                throw new AssertionError("Expected : '^', '(' or end of string. Actual: " + lex.curToken);
        }
    }

    Tree T() throws ParseException {
        System.out.println("CurrentChar" + lex.curToken + " T ");
        return switch (lex.curToken()) {
            case NOT, N, LPAREN -> new Tree("T", F(), TPrime());
            default -> throw new AssertionError("Expected : '(' '!' or variable. Actual: " + lex.curToken);
        };
    }

    Tree TPrime() throws ParseException {
        System.out.println("CurrentChar" + lex.curToken + " TPrime ");
        switch (lex.curToken()) {
            case OR:
                lex.nextToken();
                return new Tree("TPrime", new Tree("OR"), F(), TPrime());
            case RPAREN, END, XOR, PIER:
                return new Tree("Eps");
            default:
                throw new AssertionError("Expected : '(' '!' or variable. Actual: " + lex.curToken);
        }
    }

    Tree F() throws ParseException {
        System.out.println("CurrentChar" + lex.curToken + " F ");
        return switch (lex.curToken()) {
            case NOT, N, LPAREN -> new Tree("F", K(), FPrime());
            default -> throw new AssertionError("Expected : '!' '(' or variable. Actual: " + lex.curToken);
        };
    }

    Tree FPrime() throws ParseException {
        System.out.println("CurrentChar" + lex.curToken + " FPrime ");
        switch (lex.curToken()) {
            case AND:
                lex.nextToken();
                return new Tree("FPrime", new Tree("AND"), K(), FPrime());
            case OR, XOR, END, RPAREN, PIER:
                return new Tree("Eps");
            default:
                throw new AssertionError("Expected : '&', '|', '^', variable or end of string." +
                        " Actual: " + lex.curToken);
        }
    }

    Tree K() throws ParseException {
        System.out.println("CurrentChar" + lex.curToken + " K ");
        switch (lex.curToken()) {
            case NOT:
                lex.nextToken();
                return new Tree("K", new Tree("NOT"), K());
            case N:
                lex.nextToken();
                return new Tree("N");
            case LPAREN:
                lex.nextToken();
                Tree curS = S();
                if (lex.curToken != Token.RPAREN) {
                    throw new AssertionError("Expected : ')'. Actual: " + lex.curToken);
                }
                lex.nextToken();
                return new Tree("K", new Tree("LParen"), curS, new Tree("RParen"));
            default:
                throw new AssertionError("Expected : '!' '(' or variable. Actual: " + lex.curToken);
        }
    }


    Tree parse(InputStream is) throws ParseException {
        lex = new LexicalAnalyzer(is);
        lex.nextToken();
        return S();
    }

    public Tree parse(String s) throws ParseException{
        lex = new LexicalAnalyzer(new ByteArrayInputStream(s.getBytes()));
        lex.nextToken();
        return R();
    }
}
