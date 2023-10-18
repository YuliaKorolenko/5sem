package generated.boolOp;

import java.util.regex.Pattern;

public enum TypeToken {
    END("\\$"),
	NUM("([a-b])"),
	AND("\\&"),
	OR("\\|"),
	XOR("\\^"),
	NOT("!"),
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
