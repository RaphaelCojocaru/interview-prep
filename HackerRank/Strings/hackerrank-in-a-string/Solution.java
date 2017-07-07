import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/hackerrank-in-a-string
public class Solution {
    
    public static String containsHackerrank(String s) {
        HashMap<Character, Integer> hash = new HashMap<>();
        hash.put('h', -1);
        hash.put('a', -1);
        hash.put('c', -1);
        hash.put('k', -1);
        hash.put('e', -1);
        hash.put('r', -1);
        hash.put('n', -1);
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'h') {
                hash.put(ch, 1);
                continue;
            }
            if (ch == 'a' && hash.get('h') > 0) {
                hash.put(ch, 1);
                continue;
            }
            if (ch == 'c' && hash.get('a') > 0) {
                hash.put(ch, 1);
                continue;
            }
            if (ch == 'k' && hash.get('c') > 0) {
                hash.put(ch, 1);
                continue;
            }
            if (ch == 'e' && hash.get('k') > 0) {
                hash.put(ch, 1);
                continue;
            }
            if (ch == 'r' && hash.get('e') > 0) {
                hash.put(ch, 1);
                continue;
            }
            if (ch == 'r' && hash.get('r') > 0) {
                hash.put(ch, 2);
                continue;
            }
            if (ch == 'a' && hash.get('r') > 1) {
                hash.put(ch, 2);
                continue;
            }
            if (ch == 'n' && hash.get('a') > 1) {
                hash.put(ch, 1);
                continue;
            }
            if (ch == 'k' && hash.get('n') > 0)
                hash.put(ch, 2);
        }
        
        if (hash.get('k') == 2)
            return "YES";
        return "NO";
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            // your code goes here
            System.out.println(containsHackerrank(s));
        }
    }
}
