import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'largestPermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY arr
     */

    public static List<Integer> largestPermutation(int k, List<Integer> arr) {
        int max = arr.size(), position;
        HashMap<Integer, Integer> positions = new HashMap<>();

        for (int i = 0; i < arr.size();i ++) {
            positions.put(arr.get(i), i);
        }

        for (int i = 0; i < arr.size() && k > 0; i++, max--) {
            if (arr.get(i) != max) {
                position = positions.get(max);

                positions.put(max, i);
                positions.put(arr.get(i), position);

                arr.set(position, arr.get(i));
                arr.set(i, max);

                k--;
            }
        }

        return arr;
    }

}

// https://www.hackerrank.com/challenges/largest-permutation/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = Result.largestPermutation(k, arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
