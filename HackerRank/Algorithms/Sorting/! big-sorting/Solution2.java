import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class LexicographicComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int digit1, digit2;

        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                digit1 = Character.getNumericValue(s1.charAt(i));
                digit2 = Character.getNumericValue(s2.charAt(i));

                if (digit1 == digit2) {
                    continue;
                }

                return digit1 - digit2;
            }
        }

        return s1.length() - s2.length();
    }
}

class Result {

    /*
     * Complete the 'bigSorting' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY unsorted as parameter.
     */

    public static List<String> bigSorting(List<String> unsorted) {
        Collections.sort(unsorted, new LexicographicComparator());

        return unsorted;
    }
}

// https://www.hackerrank.com/challenges/big-sorting/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> unsorted = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String unsortedItem = bufferedReader.readLine();
            unsorted.add(unsortedItem);
        }

        List<String> result = Result.bigSorting(unsorted);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
