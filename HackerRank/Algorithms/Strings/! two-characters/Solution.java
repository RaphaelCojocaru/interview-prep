import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/two-characters
public class Solution {

    public static int maxLength(String s) {
        int max = -1, count, last;
        // transform each character into an index: a -> 0, b -> 1 etc.
        // check if combination of characters
        for (int i = 0; i < 26; i++)
            for (int j = i + 1; j < 26; j++) {
                // initialize the counter and the last character seen
                count = 0;
                last = -1;
                // itarate through all the string
                for (char ch : s.toCharArray()) {
                    // if we have a character twice in a row, then return 0
                    if (ch - 'a' == last) {
                        count = 0;
                        break;
                    }
                    // if we have an alternation, increment the counter
                    if ((ch - 'a' == i || ch - 'a' == j) && ch - 'a' != last) {
                        count++;
                        last = ch - 'a';
                    }
                        
                }
                // update the maximum value
                if (count > max)
                    max = count;
            }
        
        // if we have at least two characters, return max
        if (max > 1)
            return max;
        
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        
        System.out.println(maxLength(s));
    }
}
