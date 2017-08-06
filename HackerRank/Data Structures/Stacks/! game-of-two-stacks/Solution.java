import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/game-of-two-stacks
public class Solution {
    public static int countPops(int[] a, int[] b, int x) {
        int i = 0, j = 0, total = 0, count = 0;
        
        // put all the elements from the first stack
        while (i < a.length &&  total + a[i] <= x) {
            total += a[i];
            i++;
        }
        
        // store the count
        count = i;
        
        while (j < b.length && i >= 0)  {
            // add the first element from the second array
            total += b[j];
            j++;
            // remove elements from the first array
            while (total > x && i > 0) {
                i--;
                total -= a[i];
            }
            
            // check if total is lower than x and we have more elements
            if (total <= x && i + j > count)
                count = i + j;
        }

        return count;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int[] b = new int[m];
            for(int b_i=0; b_i < m; b_i++){
                b[b_i] = in.nextInt();
            }
            // your code goes here
            System.out.println(countPops(a, b, x));
        }
    }
}
