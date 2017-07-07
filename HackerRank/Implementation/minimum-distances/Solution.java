import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/minimum-distances
public class Solution {
    public static int minDistance(int n, int[] array) {
        HashMap<Integer, Integer> lastIndex = new HashMap<Integer, Integer>();
        int minDistance = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int value = array[i];
            if (lastIndex.containsKey(value)) {
                if (minDistance > i - lastIndex.get(value))
                    minDistance = i - lastIndex.get(value);
            }
            lastIndex.put(value, i);    
        }
        
        if (minDistance == Integer.MAX_VALUE)
            return -1;
        
        return minDistance;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        System.out.println(minDistance(n, A));
    }
}
