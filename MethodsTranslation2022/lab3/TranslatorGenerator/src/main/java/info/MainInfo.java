package info;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainInfo {
    private String nameGrammar = "";

    private final List<TerminalToken> tokens = new ArrayList<>();

    private Path path = Path.of("");

    public void setPath(String pathString){
        this.path = Path.of(pathString + this.getNameGrammar());
    }

    public Path getPath(){
        return this.path;
    }

    public final List<TerminalToken> getTokens() {
        return this.tokens;
    }

    private final List<Rule> rules = new ArrayList<>();

    public List<Rule> getRules() {return this.rules;}

    public void setName(final String nameGrammar) {
        this.nameGrammar = nameGrammar;
    }

    public String getNameGrammar() {
        return this.nameGrammar;
    }

    public void addToken(final String name, final String regexp) {
        tokens.add(new TerminalToken(name, regexp));
    }

    public void addRule(NonTerminalToken token, List<Part> parts) {
        rules.add(new Rule(token, parts));
    }

    public List<String> withoutCode(List<Part> parts) {
        return parts.stream().flatMap(p -> p.calls().stream().map(Call::nameRule)).collect(Collectors.toList());
    }



}

