import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/save-the-prisoner
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for(int i =0;i<tests;i++){
            int prisoners = in.nextInt();
            int sweets = in.nextInt();
            int start = in.nextInt();
            System.out.println(save(prisoners, sweets, start));
        }
    }
    
    public static int save(int p, int sw, int st){
        int last = -1;
        while(sw > 0){
            sw--;
            last = st;
            st++;
            if(st>p)
                st=1;
        }
        return last;
    }
}