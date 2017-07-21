import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/funny-string
public class Solution {

    static String funnyString(String s){
        // Complete this function
        String reverse = new StringBuffer(s).reverse().toString(); // nice reverse method
        for (int i = 0; i < s.length() - 1; i++) {
            int diff1 = Math.abs(s.charAt(i) - s.charAt(i + 1));
            int diff2 = Math.abs(reverse.charAt(i) - reverse.charAt(i + 1));
            
            if (diff1 != diff2)
                return "Not Funny";
        }
        
        return "Funny";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = funnyString(s);
            System.out.println(result);
        }
    }
}
