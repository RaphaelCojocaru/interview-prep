import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/beautiful-binary-string
public class Solution {

    static int minSteps(int n, String B){
        // Complete this function      
        int count = 0;
        char[] chars = B.toCharArray();
        
        for (int i = 2; i < n; i++) {
            if (chars[i] == '0' && chars[i - 1] == '1' && chars[i - 2] == '0') {
                chars[i] = 1;
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String B = in.next();
        int result = minSteps(n, B);
        System.out.println(result);
    }
}
