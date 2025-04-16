import java.io.*;
import java.util.*;

public class LexicalAnalyzer {

    public static void main(String[] args) {
        try {
            File myObj = new File("Code.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                System.out.println(line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void tokenize(String line) {
        System.out.println("Tokenizing the line: " + line + "...");
        List<String> tokens = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        int i = 0;
        while (i < line.length()) {
            if (Character.isWhitespace(line.charAt(i))) {
                if (str.length() > 0) {
                    tokens.add(str.toString());
                    str.setLength(0);
                }
                i++;
                continue;
            }

        }

        Tokens newTokenizer = new Tokens();
        newTokenizer.checkTokens(tokens);
    }
}
