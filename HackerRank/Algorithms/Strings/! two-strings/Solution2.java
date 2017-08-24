import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/two-strings
public class Solution2 {

    static String twoStrings(String s1, String s2){
        // Complete this function
        HashSet<Character> set = new HashSet<Character>();
        
        for (char ch : s1.toCharArray())
            set.add(ch);
        
        for (char ch : s2.toCharArray())
            if (set.contains(ch))
                return "YES";
        
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
