import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/the-love-letter-mystery
public class Solution {

    public static int theLoveLetterMystery(String s){
        // Complete this function
        int count = 0, i = 0, j = s.length() - 1;
        while (i < j) {
            count += Math.abs(s.charAt(i) - s.charAt(j));
            i++;
            j--;
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = theLoveLetterMystery(s);
            System.out.println(result);
        }
    }
}
