import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-string-reverse
public class Solution {
    public static String isPalindrom(String str) {
        if (str == null)
            return "No";
        
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return "No";
        }
        
        return "Yes";
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(isPalindrom(A));
    }
}
