import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] getRecord(int[] s){
        // Complete this function
        int max, min;
        int[] res = new int[2];
        
        res[0] = 0;
        res[1] = 0;
        if (s.length == 0)
            return res;
   
        max = s[0];
        min = s[0];
        for (int value : s)
            if (value > max) {
                res[0]++;
                max = value;
            } else if (value < min) {
                res[1]++;
                min = value;
            }
        
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }
}
