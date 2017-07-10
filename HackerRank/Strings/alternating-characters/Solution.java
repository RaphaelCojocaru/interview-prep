import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/alternating-characters
public class Solution {

    static int alternatingCharacters(String s){
        // Complete this function
        int count = 0;
        // save the last character seen
        char lastCharacter = s.charAt(0);
        
        // compare the current character with the last seen one
        for (int i = 1; i < s.length(); i++) {
            // if equal then count++
            if (s.charAt(i) == lastCharacter)
                count++;
            else // else update the last character seen
                lastCharacter = s.charAt(i);
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = alternatingCharacters(s);
            System.out.println(result);
        }
    }
}
