import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'maximizingXor' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER l
     *  2. INTEGER r
     */

    public static int maximizingXor(int l, int r) {
        int xor = l ^ r;
        int leadingZeros = countLeadingZeros(xor);

        return (1 << (32 - leadingZeros)) - 1;
    }

    public static int countLeadingZeros(int value) {
        int leadingZeroes = 32;

        while (value > 0) {
            value >>= 1;

            leadingZeroes--;
        }

        return leadingZeroes;
    }

    public static void printInteger(int value) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((value & (1 << i)) != 0 ? 1 : 0);
        }

        System.out.println();
    }

}

// https://www.hackerrank.com/challenges/maximizing-xor/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        int r = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.maximizingXor(l, r);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
