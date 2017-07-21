import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/fibonacci-modified
public class Solution {
    
    // pay attention at the accumulator
    public static BigInteger solveIt(BigInteger t1, BigInteger t2, long n) {
        if (n == 0)
            return t2;
        
        return solveIt(t2, t1.add(t2.multiply(t2)), n - 1);
    }
    
    public static BigInteger solveIt2(int t1, int t2, long n) {
        BigInteger big1 = BigInteger.valueOf(t1);
        BigInteger big2 = BigInteger.valueOf(t2);
        BigInteger aux;
        
        while(n > 0) {
            aux = big2;
            big2 = big1.add(big2.multiply(big2));
            big1 = aux;
            n--;
        }
        
        return big2;
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int t1, t2, n;
        Scanner sc = new Scanner(System.in);
        
        t1 = sc.nextInt();
        t2 = sc.nextInt();
        n = sc.nextInt();
        BigInteger b1 = BigInteger.valueOf(t1);
        BigInteger b2 = BigInteger.valueOf(t2);
        System.out.println(solveIt(b1, b2, n-2));
        // System.out.println(solveIt2(t1, t2, n - 2)); non recursive
    }
}
