import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/sum-vs-xor 
public class Solution {
    
    // 5 -> 1 0 1 => 2
    // 10 -> 1 0 1 0 => 4
    public static long solve(long n) {
        // Complete this function
        int countZeroes = 0;
        // Count the number of zero bits in integer except leading zeros
        while (n > 0) {
            if ((n & 1) == 0)
                countZeroes++;
            n >>= 1;
        }
        
        return (long) Math.pow(2, countZeroes);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long result = solve(n);
        System.out.println(result);
    }
}
