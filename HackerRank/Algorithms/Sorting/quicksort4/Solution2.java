import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/quicksort4/problem
public class Solution2 {
    private static int quicksortSwaps = 0;
    private static int insertionsortSwaps = 0;

    public static void quickSort(int[] arr, int low, int high) {
        int i = low, j = high - 1, pivot = arr[high], temp;

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                quicksortSwaps++;

                i++;
                j--;
            }
        }

        temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        quicksortSwaps++;

        if (low < j) {
            quickSort(arr, low, j);
        }

        if (i < high) {
            quickSort(arr, i, high);
        }
    }

    public static void insertionSort(int[] arr) {
        int value, j;

        for (int i = 1; i < arr.length; i++) {
            value = arr[i];

            j = i;

            while (j > 0 && arr[j - 1] > value) {
                arr[j] = arr[j - 1];

                insertionsortSwaps++;

                j--;
            }

            arr[j] = value;
        }
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n];
        int[] arrCopy = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
            arrCopy[i] = arr[i];
        }

        quickSort(arr, 0, arr.length - 1);
        insertionSort(arrCopy);

        System.out.println(insertionsortSwaps - quicksortSwaps);

        scan.close();
    }
}
