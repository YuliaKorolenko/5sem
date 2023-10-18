package org.example;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(final String[] args) throws IOException {
        final org.example.GrammarLexer lexer = new org.example.GrammarLexer(CharStreams.fromFileName("src/main/resources/test"));
        final org.example.GrammarParser parser = new org.example.GrammarParser(new CommonTokenStream(lexer));
        try {
            try (FileWriter writer = new FileWriter("output.html", false)) {
                String[] res = parser.file().res;
                for (int i = 0; i < res.length; i++) {
                    System.out.println(res[i]);
                    writer.write(res[i] + "\n");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (final IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }


}