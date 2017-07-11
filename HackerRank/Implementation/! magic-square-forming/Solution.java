import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/magic-square-forming
public class Solution {
    private static int size = 3;
    // build the solutions
    private static int[][][] solutions = {{{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                                          {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                                          {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                                          {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}}, 
                                          {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}}, 
                                          {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}}, 
                                          {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}}, 
                                          {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}};
    
    public static int magicSquareCost(int[][] s) {
        int min_cost = Integer.MAX_VALUE, crt_cost;
        
        // compute the min_cost comparing with each of the solutions built before
        for (int k = 0; k < 8; k++) {
            crt_cost = 0;
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    crt_cost += Math.abs(s[i][j] - solutions[k][i][j]);
            if (crt_cost < min_cost)
                min_cost = crt_cost;
        }
        
        return min_cost;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i=0; s_i < 3; s_i++){
            for(int s_j=0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        }
        //  Print the minimum cost of converting 's' into a magic square
        System.out.println(magicSquareCost(s));
    }
}
