import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/crush
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[n + 1];
        
        int m = in.nextInt();
        for(int a0 = 0; a0 < m; a0++) {
            int a = in.nextInt();
            int b = in.nextInt();
            long k = in.nextInt();
            arr[a] += k;
            if (b + 1 <= n)
                arr[b + 1] -= k;
        }
        
        long counter = 0, max = 0;
        for(int i = 1; i <= n; i++) {
           counter = counter + arr[i];
           if(max < counter)
               max = counter;
        }
        
        System.out.println(max);
        
        in.close();
    }
}
