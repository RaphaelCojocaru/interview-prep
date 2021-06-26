import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int anagram(String str) {
        int[] occurrences1 = new int[26];
        int[] occurrences2 = new int[26];
        int identicalCharacters = 0;
        String half1, half2;

        if (str.length() % 2 == 1) {
            return -1;
        }

        half1 = str.substring(0, str.length() / 2);
        half2 = str.substring(str.length() / 2, str.length());

        for (int i = 0; i < str.length() / 2; i++) {
            occurrences1[half1.charAt(i) - 'a']++;
            occurrences2[half2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            identicalCharacters += Math.min(occurrences1[i], occurrences2[i]);
        }

        return str.length() / 2 - identicalCharacters;
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

// https://www.hackerrank.com/challenges/anagram/problem
public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();

            int result = Result.anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
