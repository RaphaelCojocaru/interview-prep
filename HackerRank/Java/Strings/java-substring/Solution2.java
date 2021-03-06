import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-substring/problem
public class Solution2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();

        // System.out.println(S.substring(start, end));

        StringBuilder sb = new StringBuilder();

        for (int i = start; i < end; i++) {
            sb.append(S.charAt(i));
        }

        System.out.println(sb.toString());
    }
}