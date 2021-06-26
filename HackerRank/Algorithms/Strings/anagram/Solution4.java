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
        HashMap<Character, Integer> occurrences1 = new HashMap<>();
        HashMap<Character, Integer> occurrences2 = new HashMap<>();
        int identicalCharacters = 0;
        String half1 = str.substring(0, str.length() / 2);
        String half2 = str.substring(str.length() / 2, str.length());
        char ch;

        if (half1.length() != half2.length()) {
            return -1;
        }

        for (int i = 0; i < half1.length(); i++) {
            ch = half1.charAt(i);
            if (occurrences1.containsKey(ch)) {
                occurrences1.put(ch, occurrences1.get(ch) + 1);
            } else {
                occurrences1.put(ch, 1);
            }

            ch = half2.charAt(i);
            if (occurrences2.containsKey(ch)) {
                occurrences2.put(ch, occurrences2.get(ch) + 1);
            } else {
                occurrences2.put(ch, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : occurrences1.entrySet()) {
            if (occurrences2.containsKey(entry.getKey())) {
                identicalCharacters += Math.min(entry.getValue(), occurrences2.get(entry.getKey()));
            }
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
public class Solution4 {
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
