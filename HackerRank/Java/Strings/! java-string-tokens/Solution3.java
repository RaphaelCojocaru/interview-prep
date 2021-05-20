import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-string-tokens/problem
public class Solution3 {
    public static boolean charIsAlphabetic(char ch) {
        // return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
        return Character.isLetter(ch);
    }

    public static ArrayList<String> extractTokens(String str) {
        if (str.trim().length() < 1 || str.trim().length() > 400000) {
            return null;
        }

        ArrayList<String> tokens = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (charIsAlphabetic(ch)) {
                sb.append(ch);
            } else if (sb.length() != 0) {
                tokens.add(sb.toString());
                sb.setLength(0);
            }
        }

        if (sb.length() > 0) {
            tokens.add(sb.toString());
        }

        return tokens;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        ArrayList<String> tokens = extractTokens(s);
        if (tokens == null) {
            System.out.println(0);
        } else {
            System.out.println(tokens.size());
            for (String token : tokens) {
                System.out.println(token);
            }
        }

        // Write your code here.
        scan.close();
    }
}
