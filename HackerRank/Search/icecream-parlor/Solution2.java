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
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        
        for (i = 0; i < n; i++) {
            if (hash.containsKey(m - costs[i]) == true) {
                result = new Pair(Math.min(i + 1, hash.get(m - costs[i]) + 1), Math.max(i + 1, hash.get(m - costs[i]) + 1));
                return result;
            } else
                hash.put(costs[i], i);     
        }
        
        result = new Pair(-1, -1);
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