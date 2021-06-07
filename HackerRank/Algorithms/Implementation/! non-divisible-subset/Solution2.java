import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> arr) {
        int maxLength = 0;
        int[] remainders = new int[k];

        for (int value : arr) {
            remainders[value % k]++;
        }

        if (remainders[0] > 0) {
            maxLength++;
        }

        if (k % 2 == 0 && remainders[k / 2] > 0) {
            maxLength++;
        }

        for (int i = 1; i <= (k - 1) / 2; i++) {
            if (remainders[i] > remainders[(k - i) % k]) {
                maxLength += remainders[i];
            } else {
                maxLength += remainders[k - i];
            }
        }

        return maxLength;
    }

    public static int nonDivisibleSubset2(int k, List<Integer> arr) {
        int maxLength = 0;
        int[] remainders = new int[k];
        HashSet<Integer> set = new HashSet<>();

        for (int value : arr) {
            remainders[value % k]++;
        }

        for (int value : remainders) {
            System.out.print(value + " ");
        }

        if (remainders[0] > 0) {
            maxLength++;

            set.add(0);
        }

        if (k % 2 == 0 && remainders[k / 2] > 0) {
            maxLength++;

            set.add(k / 2);
        }

        for (int i = 1; i < k; i++) {
            if (!set.contains(i)) {
                if (remainders[i] > remainders[k - i]) {
                    maxLength += remainders[i];
                } else {
                    maxLength += remainders[k - i];
                }

                set.add(k - i);
            }
        }

        return maxLength;
    }
}

// https://www.hackerrank.com/challenges/non-divisible-subset/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] sTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sTemp[i]);
            s.add(sItem);
        }

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
