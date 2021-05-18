import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Pair {
    public int key;
    public String value;

    public Pair(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

class Result {

    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
        int[] occurrences = new int[100];
        int counter = 0;

        Pair[] pairs = new Pair[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            key = Integer.parseInt(arr.get(i).get(0));
            value = arr.get(i).get(1);

            if (i < arr.size() / 2) {
                pairs[i] = new Pair(key, "-");
            } else {
                pairs[i] = new Pair(key, value);
            }
        }

        for (Pair pair : pairs) {
            occurrences[pair.key]++;
        }

        for (int i = 0; i < 100; i++) {
            counter += occurrences[i];

            occurrences[i] = counter - occurrences[i];
        }

        for (Pair pair : pairs) {
            result[occurrences[pair.key]++] = pair.value;
        }

        StringBuilder sb  = new StringBuilder();
        for (String word : result) {
            sb.append(word + " ");
        }

        System.out.println(sb);
    }

}

// https://www.hackerrank.com/challenges/countingsort4/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
        }

        Result.countSort(arr);

        bufferedReader.close();
    }
}
