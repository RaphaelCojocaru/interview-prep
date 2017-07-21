import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/sherlock-and-array
public class Solution {

    static String solve(int n, int[] a){
        // Complete this function
        
        if (n == 1)
            return "YES";
        
        // Compute the sums on the left/right of the current element:
        int[] sumL = new int[n];
        int[] sumR = new int[n];
        
        sumL[0] = a[0];
        sumR[n - 1] = a[n - 1];
        
        for (int i = 1; i < n; i++) {
            sumL[i] = sumL[i - 1] + a[i];
            sumR[n - 1 - i] = sumR[n - i] + a[n - 1 - i];
        }
        
        for (int i = 1; i < n - 1; i++)
            if (sumL[i - 1] == sumR[i + 1])
                return "YES";
        
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(n, a);
            System.out.println(result);
        }
    }
}
