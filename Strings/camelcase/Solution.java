import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/camelcase
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        
        int count = 0;
        if (s.length() != 0)
            count ++;
        for (char ch : s.toCharArray())
            if (Character.isUpperCase(ch))
                count++;
        
        System.out.println(count);
    }
}