import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/sherlock-and-valid-string
public class Solution {

    public static String isValid(String s){
        // Complete this function
        int[] occurrences = new int[26];
        int count = 0, min = 0;
        
        for (char ch : s.toCharArray())
            occurrences[ch - 'a']++;
        
        for (int i = 0; i < 25; i++)
            if (occurrences[i] == occurrences[i + 1] && occurrences[i] != 0)
                min = occurrences[i];
        
        for (int i = 0; i < 26; i++) {
            if (occurrences[i] - min > 1)
                return "NO";
            else if (occurrences[i] - min == 1)
                count++;
            if (count > 1)
                return "NO";
        }
        
        return "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
