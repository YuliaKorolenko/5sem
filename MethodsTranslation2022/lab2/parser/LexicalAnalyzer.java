package parser;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class LexicalAnalyzer {
    InputStream is;
    int curChar;
    int curPos;
    Token curToken;

    public LexicalAnalyzer(InputStream is) throws ParseException {
        this.is = is;
        curPos = 0;
        nextChar();
    }

    private boolean isBlank(int c) {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }

    private void nextChar() throws ParseException {
        curPos++;
        try {
            curChar = is.read();
        } catch (IOException e) {
            throw new ParseException(e.getMessage(), curPos);
        }
    }

    public void nextToken() throws ParseException {
        while (isBlank(curChar)) {
            nextChar();
        }
        if (curChar >= 'a' && curChar <= 'z') {
            nextChar();
            curToken = Token.N;
        } else {
            switch (curChar) {
                case '&' -> {
                    nextChar();
                    curToken = Token.AND;
                }
                case 'P' -> {
                    nextChar();
                    curToken = Token.PIER;
                }
                case '^' -> {
                    nextChar();
                    curToken = Token.XOR;
                }
                case '|' -> {
                    nextChar();
                    curToken = Token.OR;
                }
                case '!' -> {
                    nextChar();
                    curToken = Token.NOT;
                }
                case ')' -> {
                    nextChar();
                    curToken = Token.RPAREN;
                }
                case '(' -> {
                    nextChar();
                    curToken = Token.LPAREN;
                }
                case '$' -> {
                    curToken = Token.END;
                }
                default -> throw new ParseException(" Illegal character " + (char) curChar, curPos);
            }
        }
    }

    public Token curToken() {
        return curToken;
    }

    public int curPos() {
        return curPos();
    }
}
