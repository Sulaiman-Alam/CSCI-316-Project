import java.io.*;
import java.util.*;

public class LexicalAnalyzer {

    public static void main(String[] args) {
        try {
            File myObj = new File("Code.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                tokenize(line);
                System.out.println();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void tokenize(String line) {
        System.out.println("Tokenizing the line: " + line + " ...");
        List<String> tokens = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        int i = 0;
        while (i < line.length()) {
            char current = line.charAt(i);

            // Skip whitespace
            if (Character.isWhitespace(current)) {
                if (str.length() > 0) {
                    tokens.add(str.toString());
                    str.setLength(0);
                }
                i++;
                continue;
            }

            // Handle two-character tokens
            if (i < line.length() - 1) {
                String twoChar = "" + current + line.charAt(i + 1);
                if (twoChar.equals(":=") || twoChar.equals("(*") || twoChar.equals("*)")) {
                    if (str.length() > 0) {
                        tokens.add(str.toString());
                        str.setLength(0);
                    }
                    tokens.add(twoChar);
                    i += 2;
                    continue;
                }
            }

            // Handle single-character symbols
            if (isSymbol(current)) {
                if (str.length() > 0) {
                    tokens.add(str.toString());
                    str.setLength(0);
                }
                tokens.add(Character.toString(current));
                i++;
                continue;
            }

            // Add valid identifier characters
            str.append(current);
            i++;
        }

        if (str.length() > 0) {
            tokens.add(str.toString());
        }

        Tokens newTokenizer = new Tokens();
        newTokenizer.checkTokens(tokens);

        System.out.println("Parsing...");
        RecursiveDescentParser parser = new RecursiveDescentParser(tokens, newTokenizer);
        parser.parse();
    }

    public static boolean isSymbol(char ch) {
        return ":;.,()=+-*/<>".indexOf(ch) != -1;
    }
}
