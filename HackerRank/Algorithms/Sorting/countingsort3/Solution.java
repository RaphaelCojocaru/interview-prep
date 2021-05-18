import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/countingsort3/problem
public class Solution {
    public static int[] countingSort(int[] arr, int n) {
        int[] occurrences = new int[100];

        for (int value : arr) {
            occurrences[value]++;
        }

        return occurrences;
    }

    public static void printArray(int[] arr) {
        int index = 0;

        for (int value = 0; value < 100; value++) {
            index += arr[value];

            System.out.print(index + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            String[] tokens = line.split("\\s+");
            arr[i] = Integer.parseInt(tokens[0]);
        }

        int[] sorted = countingSort(arr, n);

        printArray(sorted);

        scan.close();
    }
}
