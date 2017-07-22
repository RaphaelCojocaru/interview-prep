import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/largest-permutation
public class Solution {
    public static void largestPermutation(int n, int[] arr, int k) {
        int maxValue, maxIndex, temp;
        
        for (int i = 0; i < n - 1; i++) {
            maxValue = -1;
            maxIndex = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] > maxValue) {
                    maxValue = arr[j];
                    maxIndex = j;
                }
            if (arr[i] < maxValue) {
                temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
                k--;
            }
            
            if (k == 0)
                break;
        }
        
        printArray(arr);
    }
    
    public static void printArray(int[] arr) {
        for (int value : arr)
            System.out.print(value + " ");
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        largestPermutation(n, arr, k);
    }
}