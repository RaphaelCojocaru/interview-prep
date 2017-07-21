import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/service-lane
public class Solution {

    public static int getMinWidth(int[] width, int start, int end) {
        int min = Integer.MAX_VALUE;
        
        for (int i = start; i <= end; i++) {
            if (width[i] < min)
                min = width[i];
        }
        
        return min;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int width[] = new int[n];
        for(int width_i=0; width_i < n; width_i++){
            width[width_i] = in.nextInt();
        }
        
        for(int a0 = 0; a0 < t; a0++){
            int i = in.nextInt();
            int j = in.nextInt();
            System.out.println(getMinWidth(width, i, j));
        }
    }
}
