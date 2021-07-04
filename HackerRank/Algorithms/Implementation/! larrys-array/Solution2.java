import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'larrysArray' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY A as parameter.
     */

    public static String larrysArray(List<Integer> A) {
        int[] arr = new int[A.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = A.get(i);
        }

        return insertionSort(arr) % 2 == 0 ? "YES" : "NO";

    }

    public static int insertionSort(int[] arr) {
        int j, value, count = 0;

        for (int i = 1; i < arr.length; i++) {
            value = arr[i];
            j = i;

            while (j > 0 && arr[j - 1] > value) {
                arr[j] = arr[j - 1];

                j--;

                count++;
            }

            arr[j] = value;
        }

        return count;
    }
}

// https://www.hackerrank.com/challenges/larrys-array/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] ATemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> A = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int AItem = Integer.parseInt(ATemp[i]);
                A.add(AItem);
            }

            String result = Result.larrysArray(A);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
