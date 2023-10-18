package generated.calc;

import java.util.regex.Pattern;

public enum TypeToken {
    END("\\$"),
	NUM("(0|[1-9][0-9]*)"),
	POW("\\^"),
	DIV("/"),
	MUL("\\*"),
	SUB("-"),
	ADD("\\+"),
	LBRACKET("\\("),
	RBRACKET("\\)");
    private final Pattern pattern;

    TypeToken (String regexp) {
        this.pattern = Pattern.compile(regexp);
    }

    public boolean match(String text) {
        return pattern.matcher(text).matches();
    }
}
