import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-end-of-file/problem
public class Solution2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            int lineCounter = 1;
            Scanner scanner = new Scanner(System.in);
            String line;

            while (scanner.hasNext()) {
                line = scanner.nextLine();

                System.out.println(lineCounter + " " + line);

                lineCounter++;
            }

            scanner.close();
    }
}