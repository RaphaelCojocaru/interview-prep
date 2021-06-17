import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String superReducedString(String s) {
        StringBuilder sb = new StringBuilder(s);

        boolean deletionPerformed = true;

        while (deletionPerformed) {
            deletionPerformed = false;

            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.deleteCharAt(i + 1);
                    sb.deleteCharAt(i);

                    i--;

                    deletionPerformed = true;
                }
            }

            // for (int i = 1; i < sb.length(); i++) {
            //     if (sb.charAt(i) == sb.charAt(i - 1)) {
            //         sb.deleteCharAt(i);
            //         sb.deleteCharAt(i - 1);

            //         i--;

            //         deletionPerformed = true;
            //     }
            // }
        }

        if (sb.length() == 0) {
            return "Empty String";
        }

        return sb.toString();
    }
}

// https://www.hackerrank.com/challenges/reduced-string/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
