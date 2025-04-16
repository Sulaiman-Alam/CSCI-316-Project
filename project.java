import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class project {
    // Define sets of known tokens
    static Set<String> keywords = new HashSet<>(Arrays.asList(
            "program", "var", "begin", "end", "integer", "real", "boolean"));

    static Set<String> operators = new HashSet<>(Arrays.asList(
            ":=", "+", "-", "*", "/", "="));

    static Set<String> delimiters = new HashSet<>(Arrays.asList(
            ";", ".", ":", ","));

    static Set<String> brackets = new HashSet<>(Arrays.asList(
            "(", ")"));

    public static boolean isIdentifier(String token) {
        return token.matches("^[a-zA-Z_][a-zA-Z0-9_]*$");
    }

    public static boolean isNumber(String token) {
        return token.matches("^\\d+(\\.\\d+)?$");
    }

    public static List<String> tokenize(String statement) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = Pattern.compile("[a-zA-Z_][a-zA-Z0-9_]*|\\d+(\\.\\d+)?|:=|[+\\-*/=;:,.()]")
                .matcher(statement);
        while (matcher.find()) {
            tokens.add(matcher.group());
        }
        return tokens;
    }

    public static void analyze(List<String> tokens) {
        System.out.println("\nToken analysis:");
        for (String token : tokens) {
            if (keywords.contains(token)) {
                System.out.println(token + " → Keyword");
            } else if (operators.contains(token)) {
                System.out.println(token + " → Operator");
            } else if (delimiters.contains(token)) {
                System.out.println(token + " → Delimiter");
            } else if (brackets.contains(token)) {
                System.out.println(token + " → Bracket");
            } else if (isNumber(token)) {
                System.out.println(token + " → Number");
            } else if (isIdentifier(token)) {
                System.out.println(token + " → Identifier");
            } else {
                System.out.println(token + " → Invalid Token ❌");
            }
        }
    }

    public static void checkPascalSyntax(String statement) {
        List<String> tokens = tokenize(statement);
        analyze(tokens);

        if (tokens.contains(":=")) {
            int idx = tokens.indexOf(":=");
            if (idx == 0 || idx == tokens.size() - 1) {
                System.out.println("Syntax Error: ':=' not used correctly ❌");
            } else if (!isIdentifier(tokens.get(idx - 1))) {
                System.out.println("Syntax Error: Left side of ':=' must be an identifier ❌");
            } else if (!(isIdentifier(tokens.get(idx + 1)) || isNumber(tokens.get(idx + 1)))) {
                System.out.println("Syntax Error: Right side of ':=' must be identifier or number ❌");
            } else if (!tokens.get(tokens.size() - 1).equals(";")) {
                System.out.println("Syntax Error: Statement must end with ';' ❌");
            } else {
                System.out.println("Syntax seems correct ✅");
            }
        } else {
            System.out.println("No assignment operator found. Only basic syntax checks applied.");
        }
    }

    public static void main(String args[]) {
        try {
            File myObj = new File("Code.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                checkPascalSyntax(line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
