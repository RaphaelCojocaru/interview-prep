import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/30-review-loop
public class Solution {
    public static void printString(String s) {
        for (int i = 0; i < s.length(); i += 2)
            System.out.print(s.charAt(i));
        System.out.print(" ");
        for (int i = 1; i < s.length(); i += 2)
            System.out.print(s.charAt(i));
        System.out.println();
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String line;
        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            printString(line);
        }
    }
}