import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    enum Order {
        ASCENDING,
        DESCENDING
    }

    /*
     * Complete the 'Lily's Homework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int lilysHomework(List<Integer> list) {
        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        int[] arr2 = Arrays.copyOf(arr, arr.length);
        int[] sortedAscending = Arrays.copyOf(arr, arr.length);
        int[] sortedDescending = Arrays.copyOf(arr, arr.length);

        HashMap<Integer, Integer> originalPosition1 = new HashMap<>();
        HashMap<Integer, Integer> originalPosition2 = new HashMap<>();

        int noOfSwapsAscending = 0, noOfSwapsDescending = 0, temp, sortedPosition;

        quickSort(sortedAscending, 0, arr.length - 1, Order.ASCENDING);
        quickSort(sortedDescending, 0, arr.length - 1, Order.DESCENDING);

        for (int i = 0; i < arr.length; i++) {
            originalPosition1.put(arr[i], i);
            originalPosition2.put(arr[i], i);
        }

        noOfSwapsAscending = countSwaps(arr, sortedAscending, originalPosition1);
        noOfSwapsDescending = countSwaps(arr2, sortedDescending, originalPosition2);

        return Math.min(noOfSwapsAscending, noOfSwapsDescending);
    }

    public static int countSwaps(int[] arr, int[] sorted, HashMap<Integer, Integer> positions) {
        int noOfSwaps = 0, sortedPosition, temp;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != sorted[i]) {
                sortedPosition = positions.get(sorted[i]);
                positions.put(sorted[i], i);
                positions.put(arr[i], sortedPosition);


                temp = arr[i];
                arr[i] = sorted[i];
                arr[sortedPosition] = temp;

                noOfSwaps++;
            }
        }

        return noOfSwaps;
    }

    public static void quickSort(int[] arr, int low, int high, Order sort) {
        int i = low, j = high, pivot = arr[low + (high - low) / 2], temp;

        while (i <= j) {
            if (sort == Order.ASCENDING) {
                while (arr[i] < pivot) {
                    i++;
                }
                while (arr[j] > pivot) {
                    j--;
                }
            } else if (sort == Order.DESCENDING) {
                while (arr[i] > pivot) {
                    i++;
                }
                while (arr[j] < pivot) {
                    j--;
                }
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
            quickSort(arr, low, j, sort);
        }

        if (i < high) {
            quickSort(arr, i, high, sort);
        }
    }
}

// https://www.hackerrank.com/challenges/lilys-homework/problem
public class Solution {
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

        int result = Result.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
