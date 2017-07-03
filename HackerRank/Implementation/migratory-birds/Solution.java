package Implementation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/migratory-birds
public class Solution {

    static int migratoryBirds(int n, int[] arr) {
        // Complete this function
        HashMap<Integer, Integer> hash = new HashMap<>();
        int max = -1, maxKey = 0;
        
        if (n == 0)
        	return 0;
        
        for (int i : arr) {
        	if (!hash.containsKey(i))
        		hash.put(i, 1);
        	else
        		hash.put(i, hash.get(i) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
        	int key = entry.getKey();
            int value = entry.getValue();
            
            if (value > max || (value == max && key < maxKey)) {
            	max = value;
            	maxKey = key;
            }
        }
        
        return maxKey;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}