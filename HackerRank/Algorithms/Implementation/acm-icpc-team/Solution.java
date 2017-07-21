import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/acm-icpc-team
public class Solution {

    public static void solveIt(int[][] arr, int n, int m) {
        int maxTopics = 0;
        int maxTeams = 0;
        
        int[][] teams = new int[n][n];
        
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++) {
                int countTopics = 0;
                for (int k = 0; k < m; k++)
                    if (arr[i][k] == 1 || arr[j][k] == 1)
                        countTopics++; 
                if (countTopics > maxTopics)
                    maxTopics = countTopics;
                
                teams[i][j] = countTopics;
                    
            }
        
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (teams[i][j] == maxTopics)
                    maxTeams++;
        
        System.out.println(maxTopics);
        System.out.println(maxTeams);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] mat = new int[n][m];
        String topic[] = new String[n];
        for(int topic_i=0; topic_i < n; topic_i++){
            topic[topic_i] = in.next();
            for (int j = 0; j < m; j++)
                mat[topic_i][j] = Character.getNumericValue(topic[topic_i].charAt(j));
        }
        
        solveIt(mat, n, m);
        /*
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
        */
    }
}
