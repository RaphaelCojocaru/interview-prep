import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    private static final String[] numToWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine" };


    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
        switch (m) {
            case 0 : return numToWords[h] + " o' clock";
            case 1 : return numToWords[m] + " minute past " + numToWords[h];
            case 15: return "quarter past " + numToWords[h];
            case 30: return "half past " + numToWords[h];
            case 45: return "quarter to " + numToWords[h + 1];
            case 59: return numToWords[m - 1] + " minute to " + numToWords[h + 1];
        }

        if (m < 30) {
            return numToWords[m] + " minutes past " + numToWords[h];
        }

        return numToWords[60 - m] + " minutes to " + numToWords[h + 1];
    }

}

// https://www.hackerrank.com/challenges/the-time-in-words/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
