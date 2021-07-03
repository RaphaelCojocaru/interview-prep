import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
        int left, right, count = 0;
        BigInteger squared;
        String number;

        for (int i = p; i <= q; i++) {
            squared = BigInteger.valueOf(i);
            squared = squared.multiply(BigInteger.valueOf(i));

            number = squared.toString();

            left = 0;
            if (number.substring(0, number.length() / 2).length() > 0) {
                left = Integer.parseInt(number.substring(0, number.length() / 2));
            }

            right = Integer.parseInt(number.substring(number.length() / 2));
            if (left + right == i) {
                System.out.print(i + " ");

                count++;
            }
        }

        if (count == 0) {
            System.out.println("INVALID RANGE");
        }
    }

    public static int noOfDigits(long value) {
        int digits = 0;

        while (value > 0) {
            value /= 10;

            digits++;
        }

        return digits;
    }

}

// https://www.hackerrank.com/challenges/kaprekar-numbers/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
