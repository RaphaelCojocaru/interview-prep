import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'almostSorted' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void almostSorted(List<Integer> list) {
        int diffPositions = 0, start = list.size(), end = -1;
        int[] arr = new int[list.size()];
        int[] sorted = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
            sorted[i] = list.get(i);
        }

        quickSort(sorted, 0, sorted.length - 1);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != sorted[i]) {
                diffPositions++;

                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }

        if (diffPositions == 0) {
            System.out.println("yes");

            return;
        } else if (diffPositions == 2) {
            start++;
            end++;

            System.out.println("yes");
            System.out.println("swap " + start + " " + end);

            return;
        }

        for (int i = start; i < end; i++) {
            if (arr[i] < arr[i + 1]) {
                System.out.println("no");

                return;
            }
        }

        start++;
        end++;

        System.out.println("yes");
        System.out.println("reverse " + start + " " + end);
    }

    public static void quickSort(int[] arr, int low, int high) {
        int i = low, j = high, pivot = arr[low + (high - low) / 2], temp;

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
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

// https://www.hackerrank.com/challenges/almost-sorted
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.almostSorted(arr);

        bufferedReader.close();
    }
}

