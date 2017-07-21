import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/anagram
public class Solution2 {

    static int anagram(String s){
        // Complete this function
        HashMap<Character, Integer> occurrences1;
        HashMap<Character, Integer> occurrences2;
        int sameCharacters = 0;
        String half1, half2;
        
        // It is not possible for two strings of unequal length to be anagram
        //for each other.
        if (s.length() % 2 == 1)
            return -1;
        
        occurrences1 = new HashMap<Character, Integer>();
        occurrences2 = new HashMap<Character, Integer>();
        half1 = s.substring(0, s.length() / 2);
        half2 = s.substring(s.length() / 2, s.length());
                    
        for (int i = 0; i < s.length() / 2; i++) {
            if (occurrences1.containsKey(half1.charAt(i)))
                occurrences1.put(half1.charAt(i), occurrences1.get(half1.charAt(i)) + 1);
            else
                occurrences1.put(half1.charAt(i), 1);
           
            if (occurrences2.containsKey(half2.charAt(i)))
                occurrences2.put(half2.charAt(i), occurrences2.get(half2.charAt(i)) + 1);
            else
                occurrences2.put(half2.charAt(i), 1);
        }
        
        for (char ch : half1.toCharArray())
            if (occurrences2.containsKey(ch)) {
                sameCharacters += Math.min(occurrences1.get(ch), occurrences2.get(ch));
                occurrences2.remove(ch);
            }
        
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
