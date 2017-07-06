import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/cavity-map
public class Solution {
    
    public static void markCavities(String[] grid) {
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (i == 0 || j == 0 || i == grid[0].length() - 1 || j == grid[0].length() - 1)
                    System.out.print(grid[i].charAt(j));
                else if (grid[i - 1].charAt(j) < grid[i].charAt(j) && grid[i + 1].charAt(j) < grid[i].charAt(j) &&
                         grid[i].charAt(j - 1) < grid[i].charAt(j) && grid[i].charAt(j) > grid[i].charAt(j + 1))
                    System.out.print('X');
                else 
                    System.out.print(grid[i].charAt(j));
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] grid = new String[n];
        for(int grid_i=0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        
        markCavities(grid);
    }
}
