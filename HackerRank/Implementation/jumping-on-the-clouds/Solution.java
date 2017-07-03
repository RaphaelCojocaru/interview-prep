import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/jumping-on-the-clouds
public class Solution {

    public static void solveIt(int[] arr, int n) {
        int count = 0;
        int currIndex = 0;
        
        if (n == 0)
            System.out.println(0);
                               
        while (currIndex != n - 1) {
            // make a double jump
            if (currIndex + 2 < n && arr[currIndex + 2] == 0) {
                currIndex += 2;
                count++;
            } else {
                currIndex++;
                count++;
            }
        }
        
        System.out.println(count);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        
        solveIt(c, n);
    }
}
