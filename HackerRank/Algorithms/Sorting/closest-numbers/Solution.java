import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/closest-numbers
public class Solution {
    public static void quickSort(int[] array, int low, int high) {
        int i = low, j = high, pivot = array[low + (high - low) / 2];
        
        while (i <= j) {
            while (array[i] < pivot)
                i++;
            
            while (array[j] > pivot)
                j--;
            
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        
        if (low < j)
            quickSort(array, low, j);
        if (i < high)
            quickSort(array, i, high);
    }
    
    public static void closestNumbers(int n, int[] array) {
        quickSort(array, 0, n - 1);
        int minDifference = Integer.MAX_VALUE;
        
        for (int i = 0; i < n - 1; i++)
            if (array[i + 1] - array[i] < minDifference)
                minDifference = array[i + 1] - array[i];

        for (int i = 0; i < n - 1; i++)
            if (array[i + 1] - array[i] == minDifference)
                System.out.print(array[i] + " " + array[i + 1] + " ");
        
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        
        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();
        
        closestNumbers(n, array);
    }
}