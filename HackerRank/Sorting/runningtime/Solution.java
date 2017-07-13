import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/runningtime
public class Solution {
    public static int insertionSort(int n, int[] array) {
        int countShifts = 0;
        for (int i = 1; i < n; i++) {
            int value = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > value) {
                array[j] = array[j - 1];
                j--;
                countShifts++;
            }
            array[j] = value;
        }
        
        return countShifts;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n;
        int[] array;
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();
        
        System.out.println(insertionSort(n, array));
        
    }
}