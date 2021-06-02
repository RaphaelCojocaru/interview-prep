import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'findDigits' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */
    public static int findDigits(int n) {
        // Write your code here
        int noOfDivisors = 0, originalValue = n, lastDigit;

        while (n > 0) {
            lastDigit = n % 10;
            n /= 10;

            if (lastDigit == 0) {
                continue;
            }

            if (originalValue % lastDigit == 0) {
                noOfDivisors++;
            }
        }

        return noOfDivisors;
    }
}

// https://www.hackerrank.com/challenges/find-digits/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            int result = Result.findDigits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
