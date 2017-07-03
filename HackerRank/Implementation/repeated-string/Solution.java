import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/repeated-string
public class Solution {

    public static void solveIt(String s, long n) {
        // pay attention to count
        long count = 0;
        int noOfA = 0;
        
        for (char ch : s.toCharArray())
            if (ch == 'a')
                noOfA++;
        
        count = noOfA * (n / s.length());
        
        for (int i = 0; i < n % s.length(); i++)
            if (s.charAt(i) == 'a')
                count++;
        
        System.out.println(count);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        
        solveIt(s, n);
    }
}
