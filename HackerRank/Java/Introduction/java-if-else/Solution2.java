import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-if-else/problem
public class Solution2 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String findValueType(int n) {
        if (n % 2 == 1) {
            return "Weird";
        } else if (n >= 2 && n <= 5) {
            return "Not Weird";
        } else if (n >= 6 && n <= 20) {
            return "Weird";
        } else if (n > 20) {
            return "Not Weird";
        }

        return null;
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.println(findValueType(n));

        scanner.close();
    }
}
