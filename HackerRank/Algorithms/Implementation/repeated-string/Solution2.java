import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        int noOfAInFullString = 0, noOfAInRemainder = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                noOfAInFullString++;

                if (i < n % s.length()) {
                    noOfAInRemainder++;
                }
            }
        }

        // return (n / s.length()) * noOfAInFullString + noOfAInRemainder;

        // OR
        long totalOfA = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                totalOfA++;
            }
        }

        totalOfA *= (n / s.length());

        for (int i = 0; i < n % s.length(); i++) {
            if (s.charAt(i) == 'a') {
                totalOfA++;
            }
        }

        return totalOfA;
    }

}

// https://www.hackerrank.com/challenges/repeated-string/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
