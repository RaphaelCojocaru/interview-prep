import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/minimum-loss
public class Solution { 
    static class Price {
        private int year;
        private long value;
        
        public Price(int year, long value) {
            this.year = year;
            this.value = value;
        }
    }
    
    static class PricesComparator implements Comparator<Price> {
        @Override
        public int compare(Price p1, Price p2) {
            if (p1.value > p2.value)
                return 1;
            else if (p1.value < p2.value)
                return -1;
            
            return 0;
        }
    }
    
    
    public static long minimumLoss(int n, Price[] prices) {
        long min = Long.MAX_VALUE;
        
        Arrays.sort(prices, new PricesComparator());
        
        for (int i = 0; i < n - 1; i++)
            if (prices[i + 1].year < prices[i].year) 
                if (Math.abs(prices[i + 1].value - prices[i].value) < min)
                    min = Math.abs(prices[i + 1].value - prices[i].value);
        
        return min;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n;
        Price[] prices;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        prices = new Price[n];
        
        for (int i = 0; i < n; i++)
            prices[i] = new Price(i, sc.nextLong());
        
        System.out.println(minimumLoss(n, prices));
    }
}