import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/tutorial-intro
public class Solution {
    public static int binarySearch(int n, int[] array, int value) {
        int low = 0, high = array.length - 1;
        int middle;
        
        while (low <= high) {
            middle = low + (high - low) / 2;
            
            if (array[middle] == value)
                return middle;
            else if (value < array[middle])
                high = middle - 1;
            else if (value > array[middle])
                low = middle + 1;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int value = sc.nextInt();
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();
        
        System.out.println(binarySearch(n, array, value));
    }
}