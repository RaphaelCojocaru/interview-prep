import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/two-arrays
public class Solution {
    public static void quickSort(int[] arr, int low, int high) {
        int i = low, j = high, pivot = arr[low + (high - low) / 2], temp;
        
        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        
        if (low < j)
            quickSort(arr, low, j);
        if (i < high)
            quickSort(arr, i, high);
    }
    
    public static void quickSortReverse(int[] arr, int low, int high) {
        int i = low, j = high, pivot = arr[low + (high - low) / 2], temp;
        
        while (i <= j) {
            while (arr[i] > pivot)
                i++;
            while (arr[j] < pivot)
                j--;
            if (i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        
        if (low < j)
            quickSortReverse(arr, low, j);
        if (i < high)
            quickSortReverse(arr, i, high);
    }
    
    public static String permutationExists(int n, int[] arr1, int[] arr2, int k) {
        int sum;
        quickSort(arr1, 0, n - 1);
        quickSortReverse(arr2, 0, n - 1);

        for (int i = 0; i < n; i++) {
            sum = arr1[i] + arr2[i];
            if (sum < k)
                return "NO";
        }
        
        return "YES";
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int testsNo, n, k;
        int[] arr1;
        int[] arr2;
        Scanner sc = new Scanner(System.in);
        testsNo = sc.nextInt();
        for (int i = 0; i < testsNo; i++) {
            n = sc.nextInt();
            arr1 = new int[n];
            arr2 = new int[n];
            k = sc.nextInt();
            for (int j = 0; j < n; j++)
                arr1[j] = sc.nextInt();
            for (int j = 0; j < n; j++)
                arr2[j] = sc.nextInt();
            System.out.println(permutationExists(n, arr1, arr2, k));
        }
    }
}
}