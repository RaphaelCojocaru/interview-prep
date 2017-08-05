import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/larrys-array
public class Solution {
    // return the number of swaps needed to sort the array
    public static int insertionSort(int[] arr) {
        int count = 0, value, j;
        
        for (int i = 1; i < arr.length; i++) {
            value = arr[i];
            j = i;
            while (j > 0 && arr[j - 1] > value) {
                arr[j] = arr[j - 1];
                j--;
                count++;
            }
            arr[j] = value;
        }
        
        return count;
    }
    
    public static String canBeSorted(int n, int[] arr) {
        int swapsNeeded = insertionSort(arr);
        
        if (swapsNeeded % 2 == 0)
            return "YES";
        
        return "NO";
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len;
        int[] arr;
        
        for (int i = 0; i < n; i++) {
            len = sc.nextInt();
            arr = new int[len];
            for (int j = 0; j < len; j++)
                arr[j] = sc.nextInt();
            
            System.out.println(canBeSorted(len, arr));
        }
        
        sc.close();
    }
}
                               