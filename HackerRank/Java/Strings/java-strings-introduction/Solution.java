import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-strings-introduction
public class Solution {
    public static int sumLengths(String s1, String s2) {
        if (s1 == null || s2 == null)
            return -1;
        
        return s1.length() + s2.length();
    }
    
    public static String isBigger(String s1, String s2) throws IllegalArgumentException {
        if (s1 == null || s2 == null)    
            throw new IllegalArgumentException();
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) > s2.charAt(i))
                return "Yes";
            else
                return "No";
        }
        
        return "No";
    }
    
    public static String capitalizeWords(String s1, String s2) {
        if (s1 == null || s2 == null)
            return null;
        
        s1 = Character.toUpperCase(s1.charAt(0)) + s1.substring(1);
        s2 = Character.toUpperCase(s2.charAt(0)) + s2.substring(1);
        
        return (s1 + " " + s2);
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(sumLengths(s1, s2));
        System.out.println(isBigger(s1, s2));
        System.out.println(capitalizeWords(s1, s2));
    }
}
