import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-string-tokens
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();   
        // one of the delimiters using the bar: "_|@|\\s"
        String[] parts = s.split("[\\s\\!,\\?\\._'@]+");
        
        if (parts.length > 0) {
            if (parts[0].length() == 0)
                System.out.println(parts.length - 1);
            else
                System.out.println(parts.length);
        } else
            System.out.println(0);
        
        for (String str : parts)
            if (str.length() > 0)
                System.out.println(str);
        
        scan.close();
    }
}
