import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'alternate' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternate(String s) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        int maxLength = 0;

        if (s.length() < 2) {
            return 0;
        }

        for (char first : alphabet.toCharArray()) {
            for (char second : alphabet.toCharArray()) {
                sb.setLength(0);

                for (char ch : s.toCharArray()) {
                    if (ch == first || ch == second) {
                        sb.append(ch);
                    }
                }

                for (int i = 0; i < sb.length() - 1; i++) {
                    if (sb.charAt(i) == sb.charAt(i + 1)) {
                        sb.setLength(0);
                    }
                }

                maxLength = Math.max(maxLength, sb.length());
            }
        }

        return maxLength;
    }

}

// https://www.hackerrank.com/challenges/two-characters/problem
public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = Result.alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
