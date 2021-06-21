import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'fairRations' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY B as parameter.
     */

    public static String fairRations(List<Integer> arr) {
        int noOfLoaves = 0;

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) % 2 == 1) {
                arr.set(i, arr.get(i) + 1);
                arr.set(i + 1, arr.get(i + 1) + 1);

                noOfLoaves += 2;
            }
        }

        if (arr.get(arr.size() - 1) % 2 == 0) {
            return String.valueOf(noOfLoaves);
        }

        return "NO";
    }

}

// https://www.hackerrank.com/challenges/fair-rations/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        String[] BTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> B = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BTemp[i]);
            B.add(BItem);
        }

        String result = Result.fairRations(B);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
