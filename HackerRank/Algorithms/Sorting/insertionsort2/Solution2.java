import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
        int i, j, value;

        for (i = 1; i < arr.size(); i++) {
            value = arr.get(i);
            j = i;

            while (j > 0 && arr.get(j - 1) > value) {
                arr.set(j, arr.get(j - 1));

                j--;
            }

            arr.set(j, value);

            printArr(arr);
        }
    }

    public static void printArr(List<Integer> arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }

        System.out.println();
    }

}

// https://www.hackerrank.com/challenges/insertionsort2/problem
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

        Result.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
