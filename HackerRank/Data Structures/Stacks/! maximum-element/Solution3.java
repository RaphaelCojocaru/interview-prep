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
        int value;
        String[] tokens;
        List<Integer> maxs = new ArrayList<Integer>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(10, Collections.reverseOrder());

        for (String operation : operations) {
            tokens = operation.split("\\s+");

            if (tokens[0].equals("1")) {
                value = Integer.parseInt(tokens[1]);

                stack.push(value);
                queue.add(value);
            } else if (tokens[0].equals("2") && !stack.isEmpty()) {
                    value = stack.pop();
                    queue.remove(value);
            } else if (tokens[0].equals("3")) {
                maxs.add(queue.peek());
            }
        }

        return maxs;
    }
}

// https://www.hackerrank.com/challenges/maximum-element/problem
public class Solution3 {
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
