import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/largest-permutation
public class Solution {
    public static void largestPermutation(int n, int[] arr, int k, Integer[] sorted, HashMap<Integer, Integer> hash) {
        int maxValue, maxIndex, temp;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] != sorted[i]) {
                int index = hash.get(sorted[i]);
                hash.put(sorted[i], i);
                hash.put(arr[i], index);
                
                temp = arr[i];
                arr[i] = sorted[i];
                arr[index] = temp;
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
        Integer[] sorted = new Integer[n];
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sorted[i] = arr[i];
            hash.put(arr[i], i);
        }
        
        Arrays.sort(sorted, Collections.reverseOrder());
        largestPermutation(n, arr, k, sorted, hash);
    }
}