import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/mini-max-sum/problem
class Result {
    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void miniMaxSum(List<Integer> arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        long sum = 0;

        for (int value : arr) {
            if (value < min) {
                min = value;
            }

            if (value > max) {
                max = value;
            }

            sum += value;
        }

        System.out.println((sum - max) + " " + (sum - min));
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
