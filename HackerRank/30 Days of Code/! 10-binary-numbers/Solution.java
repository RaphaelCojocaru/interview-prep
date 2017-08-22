import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/30-binary-numbers
public class Solution {

    public static int consecutiveOnes(int n) {
        int count = 0, max = 0;
        
        while (n > 0) {
            // get the last bit
            int last = n % 2;
            // check if it is one or zero
            if (last == 1) {
                // if one then update the count/max
                count++;
                if (count > max)
                    max = count;
            } else
                count = 0;
            // shift right all the bits
            n >>= 1;
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        System.out.println(consecutiveOnes(n));
    }
}
