import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/sherlock-and-squares
public class Solution {

    public static int solveIt(int low, int high) {
        int count = 0;
        
        for (int value = low; value <= high; value++) {
            // test to check if a given number is whether or nor a square integer
            int sqrtValue = (int) Math.sqrt(value);
            if (sqrtValue * sqrtValue == value)
                count++;
        }
        
        return count;
    }
    
    public static int solveItSmarter(int low, int high) {
        int lowSqrt, highSqrt;
        
        lowSqrt = (int) Math.ceil(Math.sqrt(low));
        highSqrt = (int) Math.floor(Math.sqrt(high));
          
        return highSqrt - lowSqrt + 1;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int testsNo = sc.nextInt();
        for (int test = 0; test < testsNo; test++) {
            int low = sc.nextInt();
            int high = sc.nextInt();
                
            System.out.println(solveItSmarter(low, high));
        }
    }
}