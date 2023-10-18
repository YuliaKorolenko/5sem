package generators;

import info.MainInfo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TreeGen {

    private final MainInfo info;

    private final String className = "Tree.java";

    public TreeGen(final MainInfo info) {
        this.info = info;
    }

    private static final String SOURCE_CODE_TREE = """
            import java.util.ArrayList;
            import java.util.Arrays;
            import java.util.List;
                        
            public class Tree {
                private final String node;
                private final List<Tree> children;
                        
                public Tree(String node) {
                    this.node = node;
                    this.children = new ArrayList<>();
                }
                
                public Tree(String node, Tree ... children) {
                        this.node = node;
                        this.children = Arrays.asList(children);
                }
                        
                public void addChild(Tree node) {
                    children.add(node);
                }
                        
                public void addChild(String node) {
                    children.add(new Tree(node));
                }
                        
                public String getNode() {
                    return node;
                }
                        
                public List<Tree> getChildren() {
                    return children;
                }
            }
            """;
    public void generate() throws IOException {
        try (final BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(info.getPath() + "/" + className))) {
            bufferedWriter.write(String.format("""
                    package generated.%s;
                                        
                    """, info.getNameGrammar()));
            bufferedWriter.write(SOURCE_CODE_TREE);
        } catch (final IOException e) {
            throw new IOException(className + "was not created.");
        }
    }
}
