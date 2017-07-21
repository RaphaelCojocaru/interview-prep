import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/pangrams
public class Solution {
    public static void solveIt(String s) {
        int[] chars = new int[26];
        s = s.toLowerCase();
        // avoid whitespaces!!
        for (char ch : s.toCharArray())
            if (Character.isLetter(ch) == true)
                chars[ch - 'a']++;
        
        for (int i = 0; i < chars.length; i++)
            if (chars[i] == 0) {
                System.out.println("not pangram");
                return;
            }
        
        System.out.println("pangram");
                
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        solveIt(s);
    }
}
