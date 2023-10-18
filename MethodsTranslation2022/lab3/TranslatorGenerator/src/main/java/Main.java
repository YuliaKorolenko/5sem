import generators.LexerGen;
import generators.ParserGen;
import info.MainInfo;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        final CharStream charStream = CharStreams.fromFileName("calc.gramm");

        final MyGrammarLexer lexer = new MyGrammarLexer(charStream);
        final MyGrammarParser parser = new MyGrammarParser(new CommonTokenStream(lexer));

        final MainInfo info = parser.myGrammar().info;
        info.setPath("./src/main/java/generated/");

        final LexerGen analyzer = new LexerGen(info);
        analyzer.generate();
        final ParserGen generatorParser = new ParserGen(info);
        generatorParser.generate();
    }
}