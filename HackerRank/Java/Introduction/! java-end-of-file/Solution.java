import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-end-of-file
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int i = 0;
        
        while (scan.hasNext()) {
            i++;
            String line = scan.nextLine();
            System.out.println(i + " " + line);
        }
        
        scan.close();
    }
}