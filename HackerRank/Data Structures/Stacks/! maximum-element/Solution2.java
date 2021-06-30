import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
        Stack<Integer> stack = new Stack<>();
        int max = -1, value;
        String[] tokens;
        List<Integer> maxs = new ArrayList<Integer>();

        for (String operation : operations) {
            tokens = operation.split("\\s+");
            if (tokens[0].equals("1")) {
                value = Integer.parseInt(tokens[1]);

                max = Math.max(max, value);

                stack.push(value);
            } else if (tokens[0].equals("2")) {
                if (stack.peek() == max) {
                    stack.pop();

                    max = findMax(stack);
                } else if (stack.peek() != null) {
                    stack.pop();
                }
            } else if (tokens[0].equals("3")) {
                maxs.add(max);
            }
        }

        return maxs;
    }

    public static int findMax(Stack<Integer> stack) {
        Stack<Integer> auxStack = new Stack<>();
        int max = -1;

        while (!stack.isEmpty()) {
            max = Math.max(max, stack.peek());

            auxStack.push(stack.pop());
        }

        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }

        return max;
    }
}

// https://www.hackerrank.com/challenges/maximum-element/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String opsItem = bufferedReader.readLine();
            ops.add(opsItem);
        }

        List<Integer> res = Result.getMax(ops);

        for (int i = 0; i < res.size(); i++) {
            bufferedWriter.write(String.valueOf(res.get(i)));

            if (i != res.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
