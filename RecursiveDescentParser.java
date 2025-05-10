import java.util.List;

class RecursiveDescentParser {
    private List<String> tokens;
    private int current = 0;
    private Tokens tokenizer;

    public RecursiveDescentParser(List<String> tokens, Tokens tokenizer) {
        this.tokens = tokens;
        this.tokenizer = tokenizer;
    }

    public void parse() {
        try {
            stmt();
            if (current < tokens.size()) {
                throw new RuntimeException("Unexpected token: " + peek());
            }
            System.out.println("ACCEPTED");
        } catch (RuntimeException e) {
            System.out.println("REJECTED: " + e.getMessage());
        }
    }

    private void stmt() {
        if (match("if")) {
            expr();
            expect("then");
            stmt();
            if (match("else")) {
                stmt();
            }
        } else if (tokenizer.isIdentifier(peek())) {
            assign();
        } else {
            throw new RuntimeException("Invalid statement start: " + peek());
        }
    }

    private void assign() {
        expectIdentifier();
        expect(":=");
        expr();
    }

    private void expr() {
        term();
        while (match("+") || match("-")) {
            term();
        }
    }

    private void term() {
        factor();
        while (match("*") || match("/")) {
            factor();
        }
    }

    private void factor() {
        if (match("(")) {
            expr();
            expect(")");
        } else if (tokenizer.isNumber(peek())) {
            advance();
        } else if (tokenizer.isIdentifier(peek())) {
            advance();
        } else {
            throw new RuntimeException("Expected expression, found: " + peek());
        }
    }

    private boolean match(String expected) {
        if (peek() != null && peek().equals(expected)) {
            current++;
            return true;
        }
        return false;
    }

    private void expect(String expected) {
        if (!match(expected)) {
            throw new RuntimeException("Expected '" + expected + "', found: " + peek());
        }
    }

    private void expectIdentifier() {
        if (!tokenizer.isIdentifier(peek())) {
            throw new RuntimeException("Expected identifier, found: " + peek());
        }
        current++;
    }

    private String peek() {
        return current < tokens.size() ? tokens.get(current) : null;
    }

    private void advance() {
        current++;
    }
}
