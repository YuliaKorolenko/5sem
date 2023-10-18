package generated.boolOp;

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

    public SPrime sPrime() {
        SPrime res = new SPrime("sPrime");
        switch(token.typeToken()) {
            case XOR -> {
                if (token.typeToken() != TypeToken.XOR) {
                    throw new AssertionError("No valid token: " + token.text());
                }
                String XOR0 = token.text();
                res.addChild(token.text());
                nextToken();
                Term term1 = term();
                res.addChild(term1);
                SPrime sPrime2 = sPrime();
                res.addChild(sPrime2);
            }
            case END, RBRACKET -> {
                res.addChild("eps");
                
            }
            default ->
                throw new AssertionError("No valid token: " + token.text());
        }
        return res;
    }

    public FPrime fPrime() {
        FPrime res = new FPrime("fPrime");
        switch(token.typeToken()) {
            case AND -> {
                if (token.typeToken() != TypeToken.AND) {
                    throw new AssertionError("No valid token: " + token.text());
                }
                String AND0 = token.text();
                res.addChild(token.text());
                nextToken();
                K k1 = k();
                res.addChild(k1);
                FPrime fPrime2 = fPrime();
                res.addChild(fPrime2);
            }
            case OR, END, XOR, RBRACKET -> {
                res.addChild("eps");
                
            }
            default ->
                throw new AssertionError("No valid token: " + token.text());
        }
        return res;
    }

    public F f() {
        F res = new F("f");
        switch(token.typeToken()) {
            case NOT, NUM, LBRACKET -> {
                K k0 = k();
                res.addChild(k0);
                FPrime fPrime1 = fPrime();
                res.addChild(fPrime1);
            }
            default ->
                throw new AssertionError("No valid token: " + token.text());
        }
        return res;
    }

    public S s() {
        S res = new S("s");
        switch(token.typeToken()) {
            case NOT, NUM, LBRACKET -> {
                Term term0 = term();
                res.addChild(term0);
                SPrime sPrime1 = sPrime();
                res.addChild(sPrime1);
            }
            default ->
                throw new AssertionError("No valid token: " + token.text());
        }
        return res;
    }

    public Term term() {
        Term res = new Term("term");
        switch(token.typeToken()) {
            case NOT, NUM, LBRACKET -> {
                F f0 = f();
                res.addChild(f0);
                TermPrime termPrime1 = termPrime();
                res.addChild(termPrime1);
            }
            default ->
                throw new AssertionError("No valid token: " + token.text());
        }
        return res;
    }

    public K k() {
        K res = new K("k");
        switch(token.typeToken()) {
            case NUM -> {
                if (token.typeToken() != TypeToken.NUM) {
                    throw new AssertionError("No valid token: " + token.text());
                }
                String NUM0 = token.text();
                res.addChild(token.text());
                nextToken();
            }
            case LBRACKET -> {
                if (token.typeToken() != TypeToken.LBRACKET) {
                    throw new AssertionError("No valid token: " + token.text());
                }
                String LBRACKET0 = token.text();
                res.addChild(token.text());
                nextToken();
                S s1 = s();
                res.addChild(s1);
                if (token.typeToken() != TypeToken.RBRACKET) {
                    throw new AssertionError("No valid token: " + token.text());
                }
                String RBRACKET2 = token.text();
                res.addChild(token.text());
                nextToken();
            }
            case NOT -> {
                if (token.typeToken() != TypeToken.NOT) {
                    throw new AssertionError("No valid token: " + token.text());
                }
                String NOT0 = token.text();
                res.addChild(token.text());
                nextToken();
                K k1 = k();
                res.addChild(k1);
            }
            default ->
                throw new AssertionError("No valid token: " + token.text());
        }
        return res;
    }

    public TermPrime termPrime() {
        TermPrime res = new TermPrime("termPrime");
        switch(token.typeToken()) {
            case OR -> {
                if (token.typeToken() != TypeToken.OR) {
                    throw new AssertionError("No valid token: " + token.text());
                }
                String OR0 = token.text();
                res.addChild(token.text());
                nextToken();
                F f1 = f();
                res.addChild(f1);
                TermPrime termPrime2 = termPrime();
                res.addChild(termPrime2);
            }
            case END, XOR, RBRACKET -> {
                res.addChild("eps");
                
            }
            default ->
                throw new AssertionError("No valid token: " + token.text());
        }
        return res;
    }


    public static class SPrime extends Tree{
        public SPrime(String node) {
            super(node);
        }
    }

    public static class FPrime extends Tree{
        public FPrime(String node) {
            super(node);
        }
    }

    public static class F extends Tree{
        public F(String node) {
            super(node);
        }
    }

    public static class S extends Tree{
        public S(String node) {
            super(node);
        }
    }

    public static class Term extends Tree{
        public Term(String node) {
            super(node);
        }
    }

    public static class K extends Tree{
        public K(String node) {
            super(node);
        }
    }

    public static class TermPrime extends Tree{
        public TermPrime(String node) {
            super(node);
        }
    }

}
