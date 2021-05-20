import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-string-tokens/problem
public class Solution2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        if (s.trim().length() < 1 || s.trim().length() > 400000) {
            System.out.println(0);
            return;
        }

        String[] tokens = s.trim().split("[ !,?._'@]+");
        System.out.println(tokens.length);

        for (String token : tokens) {
            System.out.println(token);
        }

        // Write your code here.
        scan.close();
    }
}

