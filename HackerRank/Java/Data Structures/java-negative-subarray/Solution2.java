import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-negative-subarray/problem
public class Solution2 {
    public static int[][] computePartialSums(int[] array, int length) {
        int[][] partialSums = new int[length][length];

        for (int i = 0; i < length; i++) {
            partialSums[i][i] = array[i];
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                partialSums[j][j + i] = partialSums[j][j + i - 1] + partialSums[j + 1][j + i] - partialSums[j + 1][j + i - 1];
            }
        }

        return partialSums;
    }

    public static void printMatrix(int[][] matrix, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = scan.nextInt();
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = scan.nextInt();
        }

        int[][] partialSums = computePartialSums(array, length);

        int negativePartialSums = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (partialSums[i][j] < 0) {
                    negativePartialSums++;
                }
            }
        }

        System.out.println(negativePartialSums);

        scan.close();
    }
}