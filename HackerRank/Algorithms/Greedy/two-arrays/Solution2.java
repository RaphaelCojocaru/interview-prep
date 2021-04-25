import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    enum Order {
        ASC,
        DESC
    }

    /*
     * Complete the 'twoArrays' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     *  3. INTEGER_ARRAY B
     */

    public static String twoArrays(int k, List<Integer> listA, List<Integer> listB) {
        int[] A = toArray(listA);
        int[] B = toArray(listB);

        quickSort(A, 0, A.length - 1, Order.ASC);
        quickSort(B, 0, B.length - 1, Order.DESC);

        for (int i = 0; i < A.length; i++) {
            if (A[i] + B[i] < k) {
                return "NO";
            }
        }

        return "YES";
    }

    public static void quickSort(int[] arr, int low, int high, Order order) {
        int i = low, j = high, pivot = arr[low + (high - low) / 2], temp;

        while (i <= j) {
            if (order == Order.ASC) {
                while (arr[i] < pivot) {
                    i++;
                }
                while (arr[j] > pivot) {
                    j--;
                }
            } else {
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
            quickSort(arr, low, j, order);
        }

        if (i < high) {
            quickSort(arr, i, high, order);
        }
    }

    public static int[] toArray(List<Integer> list) {
        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}

// https://www.hackerrank.com/challenges/two-arrays/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int k = Integer.parseInt(firstMultipleInput[1]);

            String[] ATemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> A = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int AItem = Integer.parseInt(ATemp[i]);
                A.add(AItem);
            }

            String[] BTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> B = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int BItem = Integer.parseInt(BTemp[i]);
                B.add(BItem);
            }

            String result = Result.twoArrays(k, A, B);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
