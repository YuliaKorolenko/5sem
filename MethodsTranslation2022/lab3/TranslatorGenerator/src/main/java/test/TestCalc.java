package test;

import generated.calc.LexicalAnalyzer;
import generated.calc.Parser;

public class TestCalc {
    public static void main(String[] args) {
        int answer = new Parser(new LexicalAnalyzer("2^2^3")).expression().val;
        System.out.println(answer);
    }
}
