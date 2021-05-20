import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-2d-array/problem
public class Solution2 {
    public static int computeLargestHourglass(int[][] matrix, int n) {
        int maxSum = Integer.MIN_VALUE, hourglassSum = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                hourglassSum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2];
                hourglassSum += matrix[i + 1][j + 1];
                hourglassSum += matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];

                if (hourglassSum > maxSum) {
                    maxSum = hourglassSum;
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int[][] matrix = new int[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        System.out.println(computeLargestHourglass(matrix, 6));

        scan.close();
    }
}
