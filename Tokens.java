import java.util.*;

public class Tokens {
    public Tokens() {
        System.out.println("New Tokenizer Created!");
    }

    public Set<String> keywords = new HashSet<>(
            Arrays.asList("program", "const", "begin", "end", "if", "then", "else", "while", "do", "for", "case"));

    public Set<String> operators = new HashSet<>(
            Arrays.asList("+", "-", "/", "%", "*", ":=", "="));

    public Set<String> parentheses = new HashSet<>(
            Arrays.asList("(", ")", "(*", "*)"));

    public Set<String> delimeter = new HashSet<>(
            Arrays.asList(";", ":"));

    public Set<String> bool = new HashSet<>(
            Arrays.asList("and", "or", "xor", "not"));

    public Set<String> text = new HashSet<>(Arrays.asList("'"));

    public boolean isIdentifier(String token) {
        return token.matches("^[a-zA-Z_][a-zA-Z0-9_]*$");
    }

    public boolean isNumber(String token) {
        return token.matches("^\\d+(\\.\\d+)?$");
    }

    public void checkTokens(List<String> tokens) {
        for (String token : tokens) {
            if (keywords.contains(token.toLowerCase())) {
                System.out.println(token + " -> is a KEYWORD");
            } else if (operators.contains(token)) {
                System.out.println(token + " -> is an OPERATOR");
            } else if (parentheses.contains(token)) {
                System.out.println(token + " -> is a PARENTHESES");
            } else if (delimeter.contains(token)) {
                System.out.println(token + " -> is a DELIMETER");
            } else if (bool.contains(token)) {
                System.out.println(token + " -> is a BOOLEAN OPERATOR");
            } else if (text.contains(token)) {
                System.out.println(token + " -> is a TEXT DELIMITER");
            } else if (isIdentifier(token)) {
                System.out.println(token + " -> is an IDENTIFIER");
            } else if (isNumber(token)) {
                System.out.println(token + " -> is a NUMBER");
            } else {
                System.out.println(token + " -> is UNKNOWN :(");
            }
        }
    }
}
