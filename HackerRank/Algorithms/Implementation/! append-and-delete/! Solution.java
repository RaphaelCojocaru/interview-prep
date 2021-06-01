import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */
    public static String appendAndDelete(String s, String t, int k) {
        int charsToBeRemovedFromS, charsToBeAddedToT, totalOperations, i;

        for (i = 0; i < s.length() && i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                break;
            }
        }

        charsToBeRemovedFromS = s.length() - i;

        charsToBeAddedToT = t.length() - i;

        totalOperations = charsToBeRemovedFromS + charsToBeAddedToT;

        if (totalOperations <= k) {
            if (k >= s.length() + t.length()) {
                return "Yes";
            }

            if (totalOperations % 2 == k % 2) {
                return "Yes";
            }
        }

        return "No";
    }
}

// https://www.hackerrank.com/challenges/append-and-delete/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
