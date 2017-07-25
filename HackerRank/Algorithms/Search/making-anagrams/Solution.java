import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/making-anagrams
public class Solution {

    static int makingAnagrams(String s1, String s2){
        // Complete this function
        // The English alphabet is consisting of exactly 26 letters
        int[] occurrences1 = new int[26];
        int[] occurrences2 = new int[26];
        int deletesNo = 0;
        
        for (char ch : s1.toCharArray())
            occurrences1[ch - 'a']++;
        for (char ch : s2.toCharArray())
            occurrences2[ch - 'a']++;
        
        for (int i = 0; i < 26; i++) {
           deletesNo += Math.abs(occurrences1[i] - occurrences2[i]);
        }
     
        return deletesNo;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = makingAnagrams(s1, s2);
        System.out.println(result);
    }
}
