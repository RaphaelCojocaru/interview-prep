import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/game-of-thrones
public class Solution {

    static String gameOfThrones(String s){
        // Complete this function
        int[] occurrences = new int[26];
        int odd = 0;
        
        // count the occurrences of each character
        for (char ch : s.toCharArray())
            occurrences[ch - 'a']++;
        
        for (int value : occurrences)
            if (value % 2 != 0)
                odd++;
        
        // in order to be a palindrom, a string must contain at most one
        //character having an odd number of occurrences
        if (odd > 1)
            return "NO";
        
        return "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = gameOfThrones(s);
        System.out.println(result);
    }
}
