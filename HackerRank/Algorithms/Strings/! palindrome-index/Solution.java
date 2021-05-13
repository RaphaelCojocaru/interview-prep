import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/palindrome-index
public class Solution {

    public static int palindromeIndex(String s){
        // Complete this function
        int index = -1;
        int start = 0, end = s.length() - 1;
        
        // check the beginning with the end of the array
        while (start < end) {
            // if the characters differs, we found the issue
            if (s.charAt(start) != s.charAt(end)) {
                // if there are some more characters, look at the next ones
                if (s.charAt(start) == s.charAt(end - 1)) {
                    if (start + 1 <= end - 2)
                        if (s.charAt(start + 1) != s.charAt(end - 2))
                            return start;
              
                    return end;
                }
                if (s.charAt(end) == s.charAt(start + 1)) {
                    if (end - 1 >= start + 2)
                        if (s.charAt(end -1) != s.charAt(start + 2))
                            return end;
              
                    return start;
                }
            }
            start++;
            end--;
        }
        
        return index;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = palindromeIndex(s);
            System.out.println(result);
        }
    }
}
