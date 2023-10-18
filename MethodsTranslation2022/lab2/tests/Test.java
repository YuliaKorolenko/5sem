package tests;

import org.junit.rules.ExpectedException;
import parser.Parser;

import java.io.*;
import java.text.ParseException;

public class Test {
    Parser parser = new Parser();

    private void helper(String pathname){
        File file = new File(pathname);
        try (InputStream in = new FileInputStream(file)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null) {
                parser.parse(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @org.junit.Test
    public void test_01_rightExpression() {
        helper("tests/test1");
    }

    @org.junit.Rule
    public final ExpectedException exception = ExpectedException.none();

    @org.junit.Test
    public void test_02_wrongExpression() {

        exception.expect(AssertionError.class);
        helper("tests/test2");

    }


}
