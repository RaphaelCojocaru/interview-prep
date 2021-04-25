import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'maximumToys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER k
     */

    public static int maximumToys(List<Integer> prices, int k) {
        int noOfToys = 0;
        int[] arr = new int[prices.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = prices.get(i);
        }

        insertionSort(arr);

        for (int value : arr) {
            k -= value;

            if (k < 0) {
                break;
            }

            noOfToys++;
        }

        return noOfToys;
    }

    public static void insertionSort(int[] arr) {
        int j, value;

        for (int i = 1; i < arr.length; i++) {
            j = i;
            value = arr[i];

            while (j > 0 && arr[j - 1] > value) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = value;
        }
    }

}

// https://www.hackerrank.com/challenges/mark-and-toys/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] pricesTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> prices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesTemp[i]);
            prices.add(pricesItem);
        }

        int result = Result.maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
