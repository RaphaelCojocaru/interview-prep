import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/find-digits
public class Solution {

    public static int countDigits(int n) {
        int count = 0;
        int copy = n;
        
        while (n > 0) {
            // pay attention at division by zero
            if (n % 10 != 0 && copy % (n % 10) == 0)
                count++;
            n /= 10;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(countDigits(n));
        }
    }
}
