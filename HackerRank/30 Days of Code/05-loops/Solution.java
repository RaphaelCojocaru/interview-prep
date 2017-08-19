import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/30-loops
public class Solution {
    public static void loop(int n) {
        for (int i = 1; i <= 10; i++)
            System.out.println(n + " x " + i + " = " + n * i);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        loop(n);
    }
}
