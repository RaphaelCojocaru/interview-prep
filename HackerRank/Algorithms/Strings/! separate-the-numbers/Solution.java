import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
        long firstValue;

        StringBuilder copy = new StringBuilder();

        for (int i = 1; i <= s.length() / 2; i++) {
            firstValue = Long.parseLong(s.substring(0, i));

            copy.setLength(0);

            copy.append(s.substring(0, i));

            while (copy.length() < s.length()) {
                firstValue++;

                copy.append(firstValue);
            }

            if (s.equals(copy.toString())) {
                System.out.println("YES " + s.substring(0, i));

                return;
            }
        }

        System.out.println("NO");
    }
}

// https://www.hackerrank.com/challenges/separate-the-numbers/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();

            Result.separateNumbers(s);
        }

        bufferedReader.close();
    }
}
