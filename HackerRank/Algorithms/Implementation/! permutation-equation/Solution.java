import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/permutation-equation
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        // We are going to store our numbers in hashmap in format: value -> position
        // Thus we can simply find out what position a value is stored on
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int value = sc.nextInt();
            hash.put(value, i);
        }
        
        for (int i = 1; i <= n; i++) {
            int pos1 = hash.get(i);
            System.out.println(hash.get(pos1));
                
        }
    }
}
