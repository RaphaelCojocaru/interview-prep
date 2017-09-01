import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/30-sorting
public class Solution {
    
    public static int bubbleSort(int[] array, int n) {
        int totalSwaps = 0, currSwaps = 0;
        
        for (int i = 0; i < n; i++) {
            currSwaps = 0;
            for (int j = 0; j < n - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    currSwaps++;
                }
            }
            
            if (currSwaps == 0)
                break;
            else
                totalSwaps += currSwaps;
        }
        
        return totalSwaps;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        // Write Your Code Here
        int swaps = bubbleSort(a, n);
        System.out.println("Array is sorted in " + swaps  + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n - 1]);
    }
}
