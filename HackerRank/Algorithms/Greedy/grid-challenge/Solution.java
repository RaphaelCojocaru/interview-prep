import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        StringBuilder sb = new StringBuilder();
        char[] arr;

        for (int i = 0; i < grid.size(); i++) {
            arr = grid.get(i).toCharArray();

            quickSort(arr, 0, arr.length - 1);

            sb.setLength(0);
            sb.append(arr);

            grid.set(i, sb.toString());
        }

        for (int i = 0; i < grid.get(0).length(); i++) {
            for (int j = 1; j < grid.size(); j++) {
                if (grid.get(j).charAt(i) < grid.get(j - 1).charAt(i)) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

    public static void quickSort(char[] arr, int low, int high) {
        int i = low, j = high;
        char pivot = arr[low + (high - low) / 2], temp;

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

// https://www.hackerrank.com/challenges/grid-challenge/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> grid = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String gridItem = bufferedReader.readLine();
                grid.add(gridItem);
            }

            String result = Result.gridChallenge(grid);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
