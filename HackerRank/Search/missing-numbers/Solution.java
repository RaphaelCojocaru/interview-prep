import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/missing-numbers
public class Solution {
    public static void printMissing(int n, int[] list1, int m, int[] list2) {
        int count = 0;
        int[] occurrences = new int[101];
        int minValue = Integer.MAX_VALUE;
        
        // find the minimum value in the B list:
        for (int value : list2)
            if (value < minValue)
                minValue = value;
        
        for (int value : list2)
            occurrences[value - minValue]++;
        
        for (int value : list1)
            occurrences[value - minValue]--;
        
        for (int i = 0; i < occurrences.length; i++)
            if (occurrences[i] != 0)
                System.out.print((i + minValue) + " ");
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n, m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] list1 = new int[n];
        for (int i = 0; i < n; i++)
            list1[i] = sc.nextInt();
        m = sc.nextInt();
        int[] list2 = new int[m];
        for (int i = 0; i < m; i++)
            list2[i] = sc.nextInt();
        
        printMissing(n, list1, m, list2);
        
    }
}