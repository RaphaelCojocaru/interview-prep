import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    static class Pair {
        public int pos;
        public long value;

        public Pair(int pos, long value) {
            this.pos = pos;
            this.value = value;
        }
    }

    /*
     * Complete the 'minimumLoss' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts LONG_INTEGER_ARRAY price as parameter.
     */

    public static int minimumLoss(List<Long> price) {
        long minDiff = Integer.MAX_VALUE;
        Pair[] prices = new Pair[price.size()];
        for (int i = 0; i < price.size(); i++) {
            prices[i] = new Result.Pair(i, price.get(i));
        }

        quickSort(prices, 0, prices.length - 1);

        for (int i = 1; i < prices.length; i++) {
            if (prices[i].pos > prices[i - 1].pos) {
                minDiff = Math.min(minDiff, prices[i - 1].value - prices[i].value);
            }
        }

        return (int) minDiff;
    }

    public static void quickSort(Pair[] arr, int low, int high) {
        int i = low, j = high;
        Pair pivot = arr[low + (high - low) / 2], temp;

        while (i <= j) {
            while (arr[i].value > pivot.value) {
                i++;
            }

            while (arr[j].value < pivot.value) {
                j--;
            }

            if (i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

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

// https://www.hackerrank.com/challenges/minimum-loss/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] priceTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> price = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceTemp[i]);
            price.add(priceItem);
        }

        int result = Result.minimumLoss(price);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
