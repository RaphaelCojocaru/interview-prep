import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/reduced-string
public class Solution {

    static String super_reduced_string(String s){
        // Complete this function
        boolean hasPair = true;
        int length = s.length();
        while (hasPair == true) {
            hasPair = false;
            for (int i = 0; i < length - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    String firstHalf = "";
                    if (i >= 0)
                        firstHalf = s.substring(0, i);
                    String secondHalf = "";
                    if (length >= i + 2)
                        secondHalf = s.substring(i + 2, length);
                    s = firstHalf + secondHalf;
                    length -= 2;
                    i--;
                    hasPair = true;
                }
            }
        }
        
        if (length == 0)
            return "Empty String";
        
        return s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
