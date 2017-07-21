import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
public class Solution {
    
    public static int binarySearch(int n, int[] scores, int value) {
        int start = 0, end = n - 1;
        int mid = (start + end) / 2;
        
        if (value < scores[n - 1])
            return n + 1;
        if (value > scores[0])
            return 1;
        
        while (start <= end) {
            mid = (start + end) / 2;
            if (value < scores[mid])
                start = mid + 1;
            else if (value > scores[mid])
                end = mid - 1;
            else
                return mid + 1;
        }
                   
       return start + 1;     
    }
    
    public static void climbLeaderboard(int n, int[] scores, int m, int[] alice) {

        for (int alice_score : alice)
            System.out.println(binarySearch(n, scores, alice_score));
        
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        int scores_read = 0;
        int lastRead;
        for(int scores_i = 0; scores_i < n; scores_i++){
            lastRead = in.nextInt();
            scores_read++;
            while (scores_i > 0 && scores_read < n && lastRead == scores[scores_i - 1]) {
                lastRead = in.nextInt();
                scores_read++;
                n--;
            }
            scores[scores_i] = lastRead;
        }
        
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i = 0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();
        }
        // your code goes here
        climbLeaderboard(n, scores, m, alice);
    }
}
