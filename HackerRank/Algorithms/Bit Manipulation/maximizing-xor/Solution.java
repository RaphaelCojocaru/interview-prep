import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/maximizing-xor
public class Solution {
/*
 * Complete the function below.
 */

    public static int maxXor(int l, int r) {
        int max = Integer.MIN_VALUE;
        
        for (int i = l; i <= r; i++)
            for (int j = i; j <= r; j++)
                if ((i ^ j) > max)
                    max = i ^ j;
        
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());
        
        int _r;
        _r = Integer.parseInt(in.nextLine());
        
        res = maxXor(_l, _r);
        System.out.println(res);
        
    }
}
