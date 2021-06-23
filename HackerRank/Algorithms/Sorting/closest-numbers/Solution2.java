import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        int minDifference = Integer.MAX_VALUE;
        List<Integer> pairs = new ArrayList<>();

        // Collections.sort(arr);
        quickSort(arr, 0, arr.size() - 1);

        for (int i = 1; i < arr.size(); i++) {
            if (Math.abs(arr.get(i) - arr.get(i - 1)) < minDifference) {
                minDifference = Math.abs(arr.get(i) - arr.get(i - 1));
            }
        }

        for (int i = 1; i < arr.size(); i++) {
            if (Math.abs(arr.get(i) - arr.get(i - 1)) == minDifference) {
                pairs.add(arr.get(i - 1));
                pairs.add(arr.get(i));
            }
        }

        return pairs;
    }

    public static void quickSort(List<Integer> arr, int low, int high) {
        int i = low, j = high, pivot = arr.get(low + (high - low) / 2), temp;

        while (i <= j) {
            while (arr.get(i) < pivot) {
                i++;
            }

            while (arr.get(j) > pivot) {
                j--;
            }

            if (i <= j) {
                temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);

                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(arr, low, j);
        }

        if (i < high) {
            quickSort(arr, i, high);
        }
    }
}

// https://www.hackerrank.com/challenges/closest-numbers/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = Result.closestNumbers(arr);

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
