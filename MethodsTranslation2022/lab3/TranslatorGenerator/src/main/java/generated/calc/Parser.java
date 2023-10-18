package generated.calc;

public class Parser {
    private final LexicalAnalyzer tokens;
    private Token token;

    private void nextToken() {
        tokens.nextToken();
        token = tokens.getToken();
    }

    public Parser(LexicalAnalyzer tokens) {
        this.tokens = tokens;
        nextToken();
    }

    public Factor factor() {
        Factor res = new Factor("factor");
        switch(token.typeToken()) {
            case NUM -> {
                if (token.typeToken() != TypeToken.NUM) {
                    throw new AssertionError("No valid token: " + token.text());
                }
                String NUM0 = token.text();
                res.addChild(token.text());
                nextToken();
                res.val = Integer.parseInt(NUM0);
            }
            case LBRACKET -> {
                if (token.typeToken() != TypeToken.LBRACKET) {
                    throw new AssertionError("No valid token: " + token.text());
                }
                String LBRACKET0 = token.text();
                res.addChild(token.text());
                nextToken();
                Expression expression1 = expression();
                res.addChild(expression1);
                if (token.typeToken() != TypeToken.RBRACKET) {
                    throw new AssertionError("No valid token: " + token.text());
                }
                String RBRACKET2 = token.text();
                res.addChild(token.text());
                nextToken();
                res.val = expression1.val;
            }
            case SUB -> {
                if (token.typeToken() != TypeToken.SUB) {
                    throw new AssertionError("No valid token: " + token.text());
                }
                String SUB0 = token.text();
                res.addChild(token.text());
                nextToken();
                Factor factor1 = factor();
                res.addChild(factor1);
                res.val = -1 * factor1.val;
            }
            default ->
                throw new AssertionError("No valid token: " + token.text());
        }
        return res;
    }

    public Expression expression() {
        Expression res = new Expression("expression");
        switch(token.typeToken()) {
            case SUB, NUM, LBRACKET -> {
                Term term0 = term();
                res.addChild(term0);
                ExpressionPrime expressionPrime1 = expressionPrime(term0.val);
                res.addChild(expressionPrime1);
                res.val =  expressionPrime1.val;
            }
            default ->
                throw new AssertionError("No valid token: " + token.text());
        }
        return res;
    }

    public Term term() {
        Term res = new Term("term");
        switch(token.typeToken()) {
            case SUB, NUM, LBRACKET -> {
                Degree degree0 = degree();
                res.addChild(degree0);
                TermPrime termPrime1 = termPrime(degree0.val);
                res.addChild(termPrime1);
                res.val = termPrime1.val;
            }
            default ->
                throw new AssertionError("No valid token: " + token.text());
        }
        return res;
    }

    public ExpressionPrime expressionPrime(int left) {
        ExpressionPrime res = new ExpressionPrime("expressionPrime");
        switch(token.typeToken()) {
            case ADD -> {
                if (token.typeToken() != TypeToken.ADD) {
                    throw new AssertionError("No valid token: " + token.text());
                }
                String ADD0 = token.text();
                res.addChild(token.text());
                nextToken();
                Term term1 = term();
                res.addChild(term1);
                res.val = left + term1.val;
                ExpressionPrime expressionPrime2 = expressionPrime(res.val);
                res.addChild(expressionPrime2);
                res.val = expressionPrime2.val;
            }
            case SUB -> {
                if (token.typeToken() != TypeToken.SUB) {
                    throw new AssertionError("No valid token: " + token.text());
                }
                String SUB0 = token.text();
                res.addChild(token.text());
                nextToken();
                Term term1 = term();
                res.addChild(term1);
                res.val = left - term1.val;
                ExpressionPrime expressionPrime2 = expressionPrime(res.val);
                res.addChild(expressionPrime2);
                res.val = expressionPrime2.val;
            }
            case END, RBRACKET -> {
                res.addChild("eps");
                res.val = left;
            }
            default ->
                throw new AssertionError("No valid token: " + token.text());
        }
        return res;
    }

    public DegreePrime degreePrime(int left) {
        DegreePrime res = new DegreePrime("degreePrime");
        switch(token.typeToken()) {
            case POW -> {
                if (token.typeToken() != TypeToken.POW) {
                    throw new AssertionError("No valid token: " + token.text());
                }
                String POW0 = token.text();
                res.addChild(token.text());
                nextToken();
                Degree degree1 = degree();
                res.addChild(degree1);
                res.val = (int) Math.pow(left, degree1.val);
            }
            case DIV, ADD, SUB, MUL, END, RBRACKET -> {
                res.addChild("eps");
                res.val = left;
            }
            default ->
                throw new AssertionError("No valid token: " + token.text());
        }
        return res;
    }

    public TermPrime termPrime(int left) {
        TermPrime res = new TermPrime("termPrime");
        switch(token.typeToken()) {
            case MUL -> {
                if (token.typeToken() != TypeToken.MUL) {
                    throw new AssertionError("No valid token: " + token.text());
                }
                String MUL0 = token.text();
                res.addChild(token.text());
                nextToken();
                Degree degree1 = degree();
                res.addChild(degree1);
                res.val = left * degree1.val;
                TermPrime termPrime2 = termPrime(res.val);
                res.addChild(termPrime2);
                res.val = termPrime2.val;
            }
            case DIV -> {
                if (token.typeToken() != TypeToken.DIV) {
                    throw new AssertionError("No valid token: " + token.text());
                }
                String DIV0 = token.text();
                res.addChild(token.text());
                nextToken();
                Degree degree1 = degree();
                res.addChild(degree1);
                res.val = left / degree1.val;
                TermPrime termPrime2 = termPrime(res.val);
                res.addChild(termPrime2);
                res.val = termPrime2.val;
            }
            case ADD, SUB, END, RBRACKET -> {
                res.addChild("eps");
                res.val = left;
            }
            default ->
                throw new AssertionError("No valid token: " + token.text());
        }
        return res;
    }

    public Degree degree() {
        Degree res = new Degree("degree");
        switch(token.typeToken()) {
            case SUB, NUM, LBRACKET -> {
                Factor factor0 = factor();
                res.addChild(factor0);
                DegreePrime degreePrime1 = degreePrime(factor0.val);
                res.addChild(degreePrime1);
                res.val = degreePrime1.val;
            }
            default ->
                throw new AssertionError("No valid token: " + token.text());
        }
        return res;
    }


    public static class Factor extends Tree{
        public int val;
        public Factor(String node) {
            super(node);
        }
    }

    public static class Expression extends Tree{
        public int val;
        public Expression(String node) {
            super(node);
        }
    }

    public static class Term extends Tree{
        public int val;
        public Term(String node) {
            super(node);
        }
    }

    public static class ExpressionPrime extends Tree{
        public int val;
        public ExpressionPrime(String node) {
            super(node);
        }
    }

    public static class DegreePrime extends Tree{
        public int val;
        public DegreePrime(String node) {
            super(node);
        }
    }

    public static class TermPrime extends Tree{
        public int val;
        public TermPrime(String node) {
            super(node);
        }
    }

    public static class Degree extends Tree{
        public int val;
        public Degree(String node) {
            super(node);
        }
    }

}
