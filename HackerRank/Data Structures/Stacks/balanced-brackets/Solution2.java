import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    public static HashMap<Character, Character> pairs = new HashMap<>();

    static {
        pairs.put('(', ')');
        pairs.put('{', '}');
        pairs.put('[', ']');
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');
    }

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (isOpeningBracket(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || ch != pairs.get(stack.peek())) {
                    return "NO";
                }

                stack.pop();
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    public static boolean isOpeningBracket(char bracket) {
        return bracket == '(' || bracket == '{' || bracket == '[';
    }
}

// https://www.hackerrank.com/challenges/balanced-brackets/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String s = bufferedReader.readLine();

            String result = Result.isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
