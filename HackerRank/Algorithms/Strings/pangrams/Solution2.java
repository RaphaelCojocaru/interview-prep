import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/pangrams
public class Solution {
    public static void solveIt(String s) {
        s = s.toLowerCase();

        boolean[] occurrences = new boolean[26];

        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                occurrences[ch - 'a'] = true;
            }
        }

        for (boolean occurrence : occurrences) {
            if (occurrence == false) {
                return "not pangram";
            }
        }

        return "pangram";
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        solveIt(s);
    }
}
