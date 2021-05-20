import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-string-reverse/problem
public class Solution2 {
    public static String isPalindrome(String input) {
        if (input == null || input.length() == 0) {
            return "No";
        }

        int i = 0, j = input.length() - 1;

        while (i < j) {
            if (input.charAt(i) != input.charAt(j)) {
                return "No";
            }

            i++;
            j--;
        }

        return "Yes";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        /* Enter your code here. Print output to STDOUT. */

        System.out.println(isPalindrome(input));
    }
}
