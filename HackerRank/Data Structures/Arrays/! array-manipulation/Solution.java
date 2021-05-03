import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/crush/problem
class Solution {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] arr = new long[n + 1];
        long maxValue = 0, sum = 0;
        int start, end;
        long value;

        for (List<Integer> query : queries) {
            start = query.get(0);
            end = query.get(1);
            value = query.get(2);
            for (long a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
            arr[start] += value;
            if (end + 1 < arr.length) {
                arr[end + 1] -= value;
            }
            for (long a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }

        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];

            if (sum > maxValue) {
                maxValue = sum;
            }
        }

        return maxValue;
    }

    public static long arrayManipulation2(int n, List<List<Integer>> queries) {
        long maxValue = Long.MIN_VALUE;
        long[] arr = new long[n + 1];
        int a, b, k;

        for (List<Integer> query : queries) {
            a = query.get(0);
            b = query.get(1);
            k = query.get(2);

            for (int i = a; i <= b; i++) {
                arr[i] += k;

                if (arr[i] > maxValue) {
                    maxValue = arr[i];
                }
            }
        }

        return maxValue;
    }
}
