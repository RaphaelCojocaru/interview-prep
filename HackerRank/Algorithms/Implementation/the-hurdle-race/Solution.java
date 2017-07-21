import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/the-hurdle-race
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] height = new int[n];
        for(int height_i=0; height_i < n; height_i++){
            height[height_i] = in.nextInt();
        }
        // your code goes here
        int maxHeight = -1;
        for (int h : height)
            if (h > maxHeight)
                maxHeight = h;
        
        if (k >= maxHeight)
           System.out.println(0);
        else
            System.out.println(maxHeight - k);
    }
}
