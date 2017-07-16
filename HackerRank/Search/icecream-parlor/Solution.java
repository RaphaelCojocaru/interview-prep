import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/icecream-parlor
public class Solution {
    static class Pair {
        private int index1, index2;
        
        public Pair(int i1, int i2) {
            index1 = i1;
            index2 = i2;
        }
        
        public String toString() {
            return (index1 + " " + index2);
        }
    }
    
    public static Pair getPairWithSum(int m, int n, int[] costs) {
        Pair result;
        boolean found = false;
        int i = 0, j = 0;
        
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
                if (costs[i] + costs[j] == m && i != j) {
                    found = true;
                    break;
                }
            if (found == true)
                break;
        }
        
        result = new Pair(Math.min(i + 1, j + 1), Math.max(i + 1, j + 1));
        
        return result;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        int money, n;
        int[] costs;
        
        for (int i = 0; i < tests; i++) {
            money = sc.nextInt();
            n = sc.nextInt();
            costs = new int[n];
            for (int j = 0; j < n; j++)
                costs[j] = sc.nextInt();
            
            System.out.println(getPairWithSum(money, n, costs));
        }
    }
}