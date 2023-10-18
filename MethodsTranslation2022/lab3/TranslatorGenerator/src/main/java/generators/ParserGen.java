package generators;


import info.MainInfo;
import info.NonTerminalToken;
import info.Part;
import info.Rule;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ParserGen {
    private static final String EPS = "ε";
    private static final String TAB = "    ";

    private final String className = "Parser.java";
    private final MainInfo info;
    private final First first;
    private final Follow follow;

    public ParserGen(final MainInfo info) {
        this.info = info;
        this.first = new First(info);
        this.follow = new Follow(info, first);
    }

    public void generate() throws IOException {
        Files.createDirectories(info.getPath());
        TreeGen tree = new TreeGen(info);
        tree.generate();
        generateParser();
    }

    private void generateClass(final String sourceCode, final String nameClass) throws IOException {
        try (final BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(info.getPath() + "/" + nameClass))) {
            bufferedWriter.write(String.format("""
                    package generated.%s;
                                        
                    """, info.getNameGrammar()));
            bufferedWriter.write(sourceCode);
        } catch (final IOException e) {
            throw new IOException("Can't create " + nameClass + ".");
        }
    }

    private void generateParser() throws IOException {
        final Map<NonTerminalToken, List<List<Part>>> map = info.getRules().stream()
                .collect(Collectors.groupingBy(Rule::token, Collectors.mapping(Rule::parts, Collectors.toList())));

        final StringBuilder sourceCode = new StringBuilder();
        final String sourceCodeHeadParser = """            
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
                                
                """;

        sourceCode.append(sourceCodeHeadParser);

        generateFun(map, sourceCode);
        generateNodes(map.keySet(), sourceCode);
        generateClass(sourceCode + """
                }
                """, className);
    }

    private static String nameClass(final String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    private static String getCode(final String code) {
        if (code == null) {
            return "";
        }
        return code.substring(1, code.length() - 1);
    }

    private static void generateCases(final StringBuilder sourceCode, final Set<String> tokens) {
        sourceCode.append(String.format("""
                            case %s -> {
                """, String.join(", ", tokens)));
    }

    private void generateFun(final Map<NonTerminalToken, List<List<Part>>> map, final StringBuilder sourceCode) {
        for (final var partsList : map.entrySet()) {
            final String nameToken = partsList.getKey().name();
            final String nameClass = nameClass(nameToken);

            sourceCode.append(String.format("""
                                public %s %s%s {
                                    %s res = new %s("%s");
                                    switch(token.typeToken()) {
                            """,
                    nameClass, nameToken, partsList.getKey().attr(), nameClass, nameClass, nameToken)
            );

            boolean isEps = false;
            String codeForFollow = "";

            for (final var parts : partsList.getValue()) {
                final Set<String> firsts = first.getFirst(info.withoutCode(parts));
                if (firsts.contains(EPS)) {
                    isEps = true;
                    codeForFollow = parts.get(0).code();
                }
                firsts.remove(EPS);

                if (firsts.size() == 0) {
                    continue;
                }

                generateCases(sourceCode, firsts);
                int i = 0;
                for (final var part : parts) {
                    for (final var token : part.calls()) {
                        if (token.nameRule().matches("[A-Z]+")) {
                            sourceCode.append(String.format("""   
                                                    if (token.typeToken() != TypeToken.%s) {
                                                        throw new AssertionError("No valid token: " + token.text());
                                                    }
                                                    String %s%d = token.text();
                                                    res.addChild(token.text());
                                                    nextToken();
                                    """, token.nameRule(), token.nameRule(), i));
                        } else {
                            sourceCode.append(String.format("""
                                                            %s %s%d = %s%s;
                                                            res.addChild(%s%d);
                                            """,
                                    nameClass(token.nameRule()),
                                    token.nameRule(), i, token.nameRule(), token.returnVal(), token.nameRule(), i
                            ).replaceAll("\\$", "res."));
                        }
                        i++;
                    }

                    final String code = getCode(part.code());
                    if (!code.isEmpty())
                        sourceCode.append(String.format("""
                                                %s 
                                """, code).replaceAll("\\$", "res."));
                }
                sourceCode.append("""
                                    }
                        """);
            }
            if (isEps) {
                generateCases(sourceCode, follow.getFollow().get(nameToken));
                sourceCode.append(String.format("""
                                        res.addChild("eps");
                                        %s
                                    }
                        """, getCode(codeForFollow)).replaceAll("\\$", "res."));
            }
            sourceCode.append("""
                                default ->
                                    throw new AssertionError("No valid token: " + token.text());
                            }             
                            return res;
                        }
                        
                    """);
        }
    }


    private static void generateNodes(final Set<NonTerminalToken> nonTerminals, final StringBuilder sourceCode) {
        sourceCode.append("\n");

        for (final var nonTerm : nonTerminals) {
            final String nameClass = nameClass(nonTerm.name());

            sourceCode.append(String.format("""
                        public static class %s extends Tree{
                    """, nameClass));

            if (!nonTerm.returnTypes().equals("[]")) {
                sourceCode.append(Arrays.stream(getCode(nonTerm.returnTypes()).split(",")).map(returnTypes -> TAB + TAB + "public " + returnTypes + ";\n")
                        .collect(Collectors.joining()));
            }

            sourceCode.append(String.format("""
                            public %s(String node) {
                                super(node);
                            }
                        }
                        
                    """, nameClass));
        }
    }

}
