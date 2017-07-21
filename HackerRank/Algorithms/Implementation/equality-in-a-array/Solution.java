import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/equality-in-a-array
public class Solution {

    public static void solveIt(int[] arr, int n) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int count = 0, mostAppearances = 0, mostFreqElem = 0;
        
        for (int value : arr)
            if (!hash.containsKey(value))
                hash.put(value, 1);
            else
                hash.put(value, hash.get(value) + 1);
        
        // learn this!
        for (Map.Entry<Integer, Integer> entry : hash.entrySet())
            if (entry.getValue() > mostAppearances) {
                mostAppearances = entry.getValue();
                mostFreqElem = entry.getKey();
            }
                                        
        for (Map.Entry<Integer, Integer> entry : hash.entrySet())                                        
            if (entry.getKey() != mostFreqElem)
                count += entry.getValue();
        
        System.out.println(count);
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        solveIt(arr, n);
    }
}