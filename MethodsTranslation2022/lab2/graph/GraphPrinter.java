package graph;

import parser.Parser;
import parser.Tree;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class GraphPrinter {

    public static int id = 0;

    public static void main(String[] args) {
        final Parser parser = new Parser();
        try {
            final Tree tree = parser.parse("c P v & a |  f ^ d  $");
            try (FileWriter writer = new FileWriter("graph/beforePicture.dot", false)) {
                writer.write("digraph {");
                writer.write(generator(tree));
                writer.write("}");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static String generator(Tree tree) {
        StringBuilder sb = new StringBuilder("");
        rec(sb, tree, -1, 0);
        return sb.toString();
    }

    private static void rec(StringBuilder sb, Tree tree, int parent, int current) {
        sb.append(String.format("\t" + current + "[label = " + tree.getNode() + "]\n"));
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

