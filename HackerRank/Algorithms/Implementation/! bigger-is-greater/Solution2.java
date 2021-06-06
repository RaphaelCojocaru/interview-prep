import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'biggerIsGreater' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING w as parameter.
     */

    public static String biggerIsGreater(String w) {
        int pivot;

        StringBuilder bigger = new StringBuilder();

        // finding the pivot, starting from bottom to top
        for (pivot = w.length() - 1; pivot > 0; pivot--) {
            if (w.charAt(pivot) > w.charAt(pivot - 1)) {
                break;
            }
        }

        // no pivot => descended order => nothing to improve
        if (pivot == 0) {
            return "no answer";
        }

        pivot--;

        // add the string before pivot
        bigger.append(w.substring(0, pivot));

        StringBuilder tail = new StringBuilder(w.substring(pivot + 1, w.length()));
        for (int i = tail.length() - 1; i >= 0; i--) {
            if (tail.charAt(i) > w.charAt(pivot)) {
                bigger.append(tail.charAt(i));

                tail.setCharAt(i, w.charAt(pivot));

                break;
            }
        }

        // add back the tail
        bigger.append(tail.reverse().toString());

        return bigger.toString();
    }

}

// https://www.hackerrank.com/challenges/bigger-is-greater/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        for (int TItr = 0; TItr < T; TItr++) {
            String w = bufferedReader.readLine();

            String result = Result.biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
