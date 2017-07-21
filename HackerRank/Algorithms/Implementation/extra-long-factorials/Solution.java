import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/extra-long-factorials
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger x = BigInteger.valueOf(1);
        for (int value = 1; value <= n; value++)
            x = x.multiply(BigInteger.valueOf(value));
        System.out.println(x);
    }
}
