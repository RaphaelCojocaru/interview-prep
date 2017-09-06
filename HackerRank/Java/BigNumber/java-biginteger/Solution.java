import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-biginteger
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        BigInteger b1 = scan.nextBigInteger();
        BigInteger b2 = scan.nextBigInteger();
        
        b1 = b1.add(b2);
        System.out.println(b1);
        
        b1 = b1.subtract(b2);
        b1 = b1.multiply(b2);
        System.out.println(b1);
        
        scan.close();
    }
}