import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'sansaXor' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int sansaXor2(List<Integer> list) {
        int xored = 0;
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    xored ^= arr[k];
                }
            }
        }

        return xored;
    }

    public static int sansaXor(List<Integer> list) {
        int xored = 0, i, j;
        long totalOccurrences;
        int[] arr = new int[list.size()];
        for (i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        for (i = 0; i < arr.length; i++) {
            j = arr.length - i;
            totalOccurrences = (i + 1);
            totalOccurrences = totalOccurrences * j;

            if (totalOccurrences % 2 == 1) {
                xored ^= arr[i];
            }
        }

        return xored;
    }

    public static int sansaXor3(List<Integer> list) {
        int xored = 0;

        if (list.size() % 2 == 0) {
            return 0;
        }

        for (int i = 0; i < list.size(); i += 2) {
            xored ^= list.get(i);
        }

        return xored;
    }
}

// https://www.hackerrank.com/challenges/sansa-and-xor/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            int result = Result.sansaXor(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
