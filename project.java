import java.util.*;
import java.io.*;

public class project {
    static Set<String> operators = new HashSet<>(Arrays.asList(
            ":=", "+", "-", "*", "/", "=", "%"));

    static Set<String> parentheses = new HashSet<>(Arrays.asList("(", ")", "(*", "*)"));

    static Set<String> symbols = new HashSet<>(Arrays.asList("*", ";", ".", "'", ""));

    static Set<String> keywords = new HashSet<>(Arrays.asList("VAR", "CONST"));

    public static void checkSyntax(String line) { // Function to check syntax

    }

    public static void main(String args[]) {
        try {
            File myObj = new File("Code.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                System.out.println(line);
                checkSyntax(line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
