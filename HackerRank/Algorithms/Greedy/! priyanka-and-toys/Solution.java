import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/priyanka-and-toys
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
    
    public static int minimumUnits(int[] arr, int n) {
        int count = 0, last;
        
        quickSort(arr, 0, n - 1);
        
        for (int i = 0; i < n; i++) {
            last = arr[i];
            while (i < n && arr[i] <= last + 4)
                i++;

            // if we found at least one value get a position backwards
            if (i < n && arr[i] != last)
                i--;
            
            count++;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println(minimumUnits(arr, n));
    }
}