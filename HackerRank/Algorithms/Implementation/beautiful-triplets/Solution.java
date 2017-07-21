import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/beautiful-triplets
public class Solution {

    public static int countTriplets(int n, int d, int[] a) {
        // we map each value from the array to its position inside the array
        // i.e. 1 3 5 9 => a[1] = 0, a[3] = 1, a[5] = 3
        int maxFromSeq = a[n-1]; // max value from the numbers array
        int[] map = new int[maxFromSeq + 1]; // the mapping array
        int count = 0;
        // set the mapping array content
        for (int i = 0; i < n; i++)
            map[a[i]] = i;
        // count the beautiful triplets
        for (int i = 0; i < n; i++)
            if (a[i] + 2 * d <= maxFromSeq)
                if (map[a[i] + d] != 0 && map[a[i] + 2 * d] != 0)
                    count++;
                     
        return count;
    }
    
    public static int countTriplets_orig(int n, int d, int[] a) {
        int count = 0, i, j, k;
        boolean found;      
        for (i = 0; i < n; i++) {
            found = false;
            for (j = i + 1; j < n; j++)
                if (a[j] - a[i] == d) {
                    found = true;
                    break;
                }
            if (found == false)
                continue;
            for (k = j + 1; k < n; k++)
                if (a[k] - a[j] == d) {
                    count++;
                    break;
                }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n, d;
        int[] a;
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = sc.nextInt();
        a = new int[n];
        
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        
        System.out.println(countTriplets(n, d, a));
    }
}