import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        HashMap<Integer, Integer> arrOccurrences = new HashMap<>();
        HashMap<Integer, Integer> brrOccurrences = new HashMap<>();
        List<Integer> missingValues = new ArrayList<>();
        HashSet<Integer> missingValuesSet = new HashSet<>();

        for (int value : arr) {
            if (arrOccurrences.containsKey(value)) {
                arrOccurrences.put(value, arrOccurrences.get(value) + 1);
            } else {
                arrOccurrences.put(value, 1);
            }
        }

        for (int value : brr) {
            if (brrOccurrences.containsKey(value)) {
                brrOccurrences.put(value, brrOccurrences.get(value) + 1);
            } else {
                brrOccurrences.put(value, 1);
            }
        }

        for (int value : brr) {
            if (missingValuesSet.contains(value)) {
                continue;

            }
            if (!arrOccurrences.containsKey(value)) {
                missingValues.add(value);
                missingValuesSet.add(value);
            } else if (arrOccurrences.get(value) < brrOccurrences.get(value)) {
                missingValues.add(value);
                missingValuesSet.add(value);
            }
        }

        // Collections.sort(missingValues);
        insertionSort(missingValues);

        return missingValues;
    }

    public static void insertionSort(List<Integer> arr) {
        int i, j, value;

        for (i = 1; i < arr.size(); i++) {
            value = arr.get(i);
            j = i;

            while (j > 0 && arr.get(j - 1) > value) {
                arr.set(j, arr.get(j - 1));

                j--;
            }

            arr.set(j, value);
        }
    }

}

// https://www.hackerrank.com/challenges/missing-numbers/problem
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

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrTemp[i]);
            brr.add(brrItem);
        }

        List<Integer> result = Result.missingNumbers(arr, brr);

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
