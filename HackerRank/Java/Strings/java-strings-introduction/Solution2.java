import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-strings-introduction/problem
public class Solution2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.next();
        String B = scanner.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());

        if (A.compareTo(B) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println(Character.toUpperCase(A.charAt(0)) + A.substring(1, A.length()) + " " + Character.toUpperCase(B.charAt(0)) + B.substring(1, B.length()));
    }
}



