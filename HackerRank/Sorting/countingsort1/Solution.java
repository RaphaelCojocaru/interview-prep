import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/countingsort1
public class Solution {
    public static void countElements(int[] array) {
        int[] occurrences = new int[array.length];
        
        for (int value : array)
            occurrences[value]++;
        
        if (array.length == 100)
            for (int i = 0; i < occurrences.length; i++)
                System.out.print(occurrences[i] + " ");
        else
            for (int i = 0; i < occurrences.length; i++)
                if (occurrences[i] != 0)
                    System.out.print(occurrences[i] + " ");
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();
        
        countElements(array);
    }
}