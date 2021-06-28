import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String str) {
        int[] occurrences = new int[26];
        int firstOccNo, secondOccNo, lastOccNo, lastButOne, start;

        for (char ch : str.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        quickSort(occurrences, 0, occurrences.length - 1);

        for (start = 0; start < occurrences.length; start++) {
            if (occurrences[start] != 0) {
                break;
            }
        }

        if (start == occurrences.length) {
            return "NO";
        } else if (start == occurrences.length - 1) {
            return "YES";
        }

        firstOccNo = occurrences[start];
        secondOccNo = occurrences[start + 1];

        lastOccNo = occurrences[occurrences.length - 1];
        lastButOne = occurrences[occurrences.length - 2];

        if (firstOccNo == lastOccNo) {
            return "YES";
        }

        if (lastOccNo - firstOccNo == 1 && lastOccNo != lastButOne) {
            return "YES";
        }

        if (firstOccNo == 1 && secondOccNo == lastOccNo) {
            return "YES";
        }

        return "NO";
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

// https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
