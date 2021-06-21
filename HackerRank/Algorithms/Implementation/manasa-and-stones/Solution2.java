import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'stones' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER a
     *  3. INTEGER b
     */

    public static List<Integer> stones(int n, int a, int b) {
        int difference = Math.abs(a - b);
        int smaller = (n - 1) * Math.min(a, b);

        ArrayList<Integer> possibleValues = new ArrayList<>(Arrays.asList(smaller));

        if (a == b) {
            return possibleValues;
        }

        for (int i = 1; i < n; i++) {
            smaller += difference;

            possibleValues.add(smaller);
        }

        return possibleValues;
    }

}

// https://www.hackerrank.com/challenges/manasa-and-stones/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        for (int TItr = 0; TItr < T; TItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            int a = Integer.parseInt(bufferedReader.readLine().trim());

            int b = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> result = Result.stones(n, a, b);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
