import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'sumXor' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long sumXor(long n) {
        int noOfZeros = countZeros(n);

        return (long) Math.pow(2, noOfZeros);
    }

    public static int countZeros(long n) {
        int noOfZeros = 0;

        while (n > 0) {
            if ((n & 1) == 0) {
                noOfZeros++;
            }

            n >>= 1;
        }

        return noOfZeros;
    }

}

// https://www.hackerrank.com/challenges/sum-vs-xor/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.sumXor(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
