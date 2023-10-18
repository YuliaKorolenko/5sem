package test;

import generated.boolOp.LexicalAnalyzer;
import generated.boolOp.Parser;
import generated.boolOp.Tree;

import java.io.FileWriter;
import java.io.IOException;

public class GraphPrinter {
    public static int id = 0;

    public static void main(String[] args) {
        final Parser.S tree = new Parser(new LexicalAnalyzer("((1 + 2)/3)+2")).s();
        try (FileWriter writer = new FileWriter("C:/Users/Julko/MethodsTranslation2022/lab3/TranslatorGenerator/src/main/java/test/beforePicture.dot", false)) {
            writer.write("digraph {");
            writer.write(generator(tree));
            writer.write("}");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String generator(Tree tree) {
        StringBuilder sb = new StringBuilder("");
        rec(sb, tree, -1, 0);
        return sb.toString();
    }

    private static void rec(StringBuilder sb, Tree tree, int parent, int current) {
        sb.append(String.format("\t" + current + "[label = \"" + tree.getNode() + "\"]\n"));
        if (parent != -1) {
            sb.append(String.format("\t" + parent + " -> " + current + "\n"));
        }
        if (tree.getChildren() != null && !tree.getChildren().isEmpty()) {
            for (Tree children : tree.getChildren()) {
                rec(sb, children, current, ++id);
            }
        }
    }


}
