import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-negative-subarray
public class Solution {
    public static int countNegativeSubarrays(int n, int[] arr) {
        int counter = 0;
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum < 0)
                    counter++;
            }
        }
        
        return counter;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        
        System.out.println(countNegativeSubarrays(n, arr));
    }
}