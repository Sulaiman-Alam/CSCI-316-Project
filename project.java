import java.util.*;
import java.io.*;

public class project {
    public static void main(String args[]) {
        try {
            File myObj = new File("Code.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                // Will add a check to make sure job is correct if time permits
                System.out.println(line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
