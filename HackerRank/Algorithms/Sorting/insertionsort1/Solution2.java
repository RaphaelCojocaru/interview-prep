import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        int value = arr.get(n - 1), i = n - 1;

        while (i > 0 && arr.get(i - 1) > value) {
            arr.set(i, arr.get(i - 1));

            i--;

            printArray(arr);
        }

        arr.set(i, value);

        printArray(arr);
    }

    public static void printArray(List<Integer> arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }

        System.out.println();
    }

}

// https://www.hackerrank.com/challenges/insertionsort1/problem
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

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
