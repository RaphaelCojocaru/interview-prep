import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/anagram
public class Solution {

    static int anagram(String s){
        // Complete this function
        int[] occurrences1;
        int[] occurrences2;
        int sameCharacters = 0;
        String half1, half2;
        
        // It is not possible for two strings of unequal length to be anagram
        //for each other.
        if (s.length() % 2 == 1)
            return -1;
        
        occurrences1 = new int[26];
        occurrences2 = new int[26];
        half1 = s.substring(0, s.length() / 2);
        half2 = s.substring(s.length() / 2, s.length());
                    
        for (int i = 0; i < s.length() / 2; i++) {
            occurrences1[half1.charAt(i) - 'a']++;
            occurrences2[half2.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < 26; i++)
            sameCharacters += Math.min(occurrences1[i], occurrences2[i]);
        
        return s.length() / 2 - sameCharacters;
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = anagram(s);
            System.out.println(result);
        }
    }
}
