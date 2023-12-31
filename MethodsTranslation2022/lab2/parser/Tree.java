package parser;

import java.util.Arrays;
import java.util.List;

public class Tree {
    String node;
    List<Tree> children;

    public Tree(String node, Tree ... children) {
        this.node = node;
        this.children = Arrays.asList(children);
    }

    public Tree(String node) {
        this.node = node;
    }

    public String getNode() {
        return node;
    }

    public List<Tree> getChildren() {
        return children;
    }
}

