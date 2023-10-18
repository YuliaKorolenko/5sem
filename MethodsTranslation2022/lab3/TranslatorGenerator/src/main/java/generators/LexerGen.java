package generators;

import info.MainInfo;
import info.TerminalToken;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
public class LexerGen {
    private static final String TAB = "\t";
    private final MainInfo info;

    private final String className = "/LexicalAnalyzer.java";
    public LexerGen(final MainInfo grammarInfo){
        this.info = grammarInfo;
    }

    public void generate() throws IOException {
        try {
            Files.createDirectories(info.getPath());
        } catch (final IOException ignored) {
        }

        generateTokenClass();
        generateTypeToken();
        generateLexicalAnalyzer();
    }

    private void generateTokenClass() throws IOException {
        final String sourceCodeToken = String.format("""
                package generated.%s;

                public record Token (TypeToken typeToken, String text) {
                    @Override
                    public String toString() {
                        return typeToken.name();
                    }
                }""", info.getNameGrammar());

        try (final BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(info.getPath() + "/Token.java"))) {
            bufferedWriter.write(sourceCodeToken);
        } catch (final IOException e) {
            throw new IOException("Can't create Token.java.");
        }
    }

    private void generateTypeToken() throws IOException {
        final String startClass = String.format("""
                package generated.%s;
                                
                import java.util.regex.Pattern;
                                
                public enum TypeToken {
                    END("\\\\$"),""", info.getNameGrammar());

        final String endClass = """
                    private final Pattern pattern;
                                
                    TypeToken (String regexp) {
                        this.pattern = Pattern.compile(regexp);
                    }
                                
                    public boolean match(String text) {
                        return pattern.matcher(text).matches();
                    }
                }
                """;
        try (final BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(info.getPath() + "/TypeToken.java"))) {
            bufferedWriter.write(startClass
                    + info.getTokens().stream().map(entry -> TAB + entry.name() + "(" + entry.regexp() + ")")
                    .collect(Collectors.joining(",\n", "\n", ";\n"))
                    + endClass);
        } catch (final IOException e) {
            throw new IOException("Can't create TypeToken.java");
        }
    }

    private void generateLexicalAnalyzer() throws IOException {
        final String startClass = String.format("""
                        package generated.%s;
                               
                        import java.util.regex.Matcher;
                        import java.util.regex.Pattern;
                                        
                        public class LexicalAnalyzer {
                                        
                            private final static Pattern PATTERN_EXPRESSION = Pattern.compile(""",
                info.getNameGrammar());

        final String endClass = """
                );
                                
                    private final Matcher tokenMatcher;
                                
                    private Token curToken;
                                
                    public LexicalAnalyzer(String expression) {
                        this.tokenMatcher = PATTERN_EXPRESSION.matcher(expression);
                    }
                                
                    public void nextToken() {
                        while (tokenMatcher.find()) {
                                
                            if (Character.isWhitespace(tokenMatcher
                                    .group()
                                    .charAt(0))
                            ) {
                                continue;
                            }
                                
                            for (var typeToken : TypeToken.values()) {
                                String tokenStr = tokenMatcher.group();
                                if (typeToken.match(tokenStr)) {
                                    curToken = new Token(typeToken, tokenStr);
                                    return;
                                }
                            }
                                
                            throw new AssertionError("No valid token on pos: " + tokenMatcher.start());
                        }
                                
                        curToken = new Token(TypeToken.END, "$");
                    }
                                
                    public Token getToken() {
                        return curToken;
                    }
                }
                """;
        try (final BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(info.getPath() + className))) {
            bufferedWriter.write(startClass
                    + info
                    .getTokens().stream().map(TerminalToken::regexp).map(s -> s.substring(1, s.length() - 1))
                    .collect(Collectors.joining("|", "\"", "|.\""))
                    + endClass);
        } catch (final IOException e) {
            throw new IOException("Can't create TypeToken.java");
        }
    }
}
