import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/30-bitwise-and
public class Solution {

    public static int getMaxValue(int range, int max) {
        int result = 0;
        for (int i = 1; i < range; i++)
            for (int j = i + 1; j <= range; j++) {
                int temp = (i & j);
                if (temp < max && temp > result)
                    result = temp;
            }
        
        return result;
    }
    
    public static void main(String[] args) { 
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            System.out.println(getMaxValue(n, k));
        }
    }
}
