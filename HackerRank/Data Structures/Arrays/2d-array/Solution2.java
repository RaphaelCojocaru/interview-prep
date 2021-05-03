import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/2d-array/problem
class Solution2 {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> list) {
        int maxHourglass = Integer.MIN_VALUE, sum = 0, n = list.size();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = list.get(i).get(j);
            }
        }

        for (int i = 0; i <= n - 3; i ++) {
            for (int j = 0; j <= n - 3; j++) {
                sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                sum += arr[i + 1][j + 1];
                sum += arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                if (sum > maxHourglass) {
                    maxHourglass = sum;
                }
            }
        }

        return maxHourglass;
    }
}
