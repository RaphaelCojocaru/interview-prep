import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/find-the-median
public class Solution {
    public static void insertionSort(int n, int[] array) {
        int i, j, value;
        
        for (i = 1; i < n; i++) {
            value = array[i];
            j = i;
            while (j > 0 && array[j - 1] > value) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = value; 
        }
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
 
        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();
        
        insertionSort(n, array);
        
        System.out.println(array[n / 2]);
    }
}