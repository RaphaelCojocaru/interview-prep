import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array
public class Solution {

    // perform quicksort
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
    
    // find the minimum absolute difference between any two elements of the array
    public static int minimumAbsoluteDifference(int n, int[] arr) {
        int minimumDifference = Integer.MAX_VALUE;
        
        // first sort the array in increasing order
        quickSort(arr, 0, n - 1);
        
        // check only the adjacent elements
        for (int i = 0; i < n - 1; i++) 
            if (Math.abs(arr[i + 1]  - arr[i]) < minimumDifference)
                minimumDifference = Math.abs(arr[i + 1]  - arr[i]);
        
        return minimumDifference;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        // your code goes here
        System.out.println(minimumAbsoluteDifference(n , a));
    }
}
