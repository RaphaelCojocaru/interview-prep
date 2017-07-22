import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/sparse-arrays
public class Solution {
    public static void countOccurrences(int n, String[] input, int q, String[] queries) {
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        for (String in : input) {
            if (hash.containsKey(in) == true)
                hash.put(in, hash.get(in) + 1);
            else
                hash.put(in, 1);
        }
        for (String query : queries) {
            if (hash.containsKey(query) == true)
                System.out.println(hash.get(query));
            else 
                System.out.println(0);
        }
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n, q;
        Scanner sc = new Scanner(System.in);
        n = Integer.valueOf(sc.nextLine());
        String[] input = new String[n];
        for (int i = 0; i < n; i++)
            input[i] = sc.nextLine();
        q = Integer.valueOf(sc.nextLine());
        String[] queries =new String[q];
        for (int i = 0; i < q; i++)
            queries[i] = sc.nextLine(); 
        countOccurrences(n, input, q, queries);
    }
}