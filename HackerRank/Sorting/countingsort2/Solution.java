import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/countingsort2
public class Solution {
    public static void countingSort(int[] array) {
        int[] occurrences = new int[array.length];
        
        for (int value : array)
            occurrences[value]++;
        
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < occurrences[i]; j++)
                System.out.print(i + " ");
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();
        
        countingSort(array);
    }
}