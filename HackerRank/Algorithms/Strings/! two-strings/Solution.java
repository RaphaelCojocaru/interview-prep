import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/two-strings
public class Solution {

    static String twoStrings(String s1, String s2){
        // Complete this function
        HashMap<Character, Integer> hash1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hash2 = new HashMap<Character, Integer>();
        
        for (char ch : s1.toCharArray()) 
            if (hash1.containsKey(ch) == true)
                hash1.put(ch, hash1.get(ch) + 1);
            else
                hash1.put(ch, 1);
             
        for (char ch : s2.toCharArray())
            if (hash2.containsKey(ch) == true)
                hash2.put(ch, hash2.get(ch) + 1);
            else
                hash2.put(ch, 1);
        
        // iterating through a HashMap
        for (Map.Entry entry : hash1.entrySet()) {
            if (hash2.containsKey(entry.getKey()))
                return "YES";
        }
        
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s1 = in.next();
            String s2 = in.next();
            String result = twoStrings(s1, s2);
            System.out.println(result);
        }
    }
}
