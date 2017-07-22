import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/array-left-rotation
public class Solution {

    public static void leftRotation(int n, int[] arr, int d) {
        for (int i = 0; i < d; i++) {
            int first = arr[0];
            for (int j = 0; j < n - 1; j++)
                arr[j] = arr[j + 1];
            arr[n - 1] = first;
        }
    }
    
    public static void printArray(int[] arr) {
        for (int value : arr)
            System.out.print(value + " ");
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n, d;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        leftRotation(n, arr, d);
        printArray(arr);
    }
}