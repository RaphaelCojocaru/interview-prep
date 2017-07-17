import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/countingsort4
public class Solution {
    static class Pair {
        private Integer key;
        private String value;
        
        public Pair(int k, String v) {
            key = k;
            value = v;
        }
    }
    
    public static void countingSort(Pair[] pairs, int maxKey) {
        int[] count = new int[maxKey + 1];
        int total = 0, oldCount;
        String[] output = new String[pairs.length];
        
        for (Pair p : pairs)
            count[p.key]++;
        
        // calculate the starting index for each key:
        for (int i = 0; i <= maxKey; i++) {
            oldCount = count[i];
            count[i] = total;
            total += oldCount;
        }
        
        // copy to output array, preserving order of inputs with equal keys:
        for (Pair p : pairs) {
            output[count[p.key]] = p.value;
            count[p.key]++;
        }
        
        StringBuilder res = new StringBuilder();  
        
        for (String s : output)
            res.append(s + " ");
        
        System.out.println(res);
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Pair[] pairs = new Pair[n];
        int maxKey = -1;
        
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int key = Integer.parseInt(parts[0]);
            if (key > maxKey)
                maxKey = key;
            
            if (i < n / 2)
                pairs[i] = new Pair(key, "-");
            else
                pairs[i] = new Pair(key, parts[1]);
        }
        
        countingSort(pairs, maxKey);
            
            
    }
}