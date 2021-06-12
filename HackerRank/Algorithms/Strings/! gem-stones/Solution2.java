import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'gemstones' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY arr as parameter.
     */

    public static int gemstones(List<String> arr) {
        int noOfGemstones = 0, stoneIndex;
        char ch;

        for (int i = 0; i < 26; i++) {
            ch = (char) ('a' + i);

            for (stoneIndex = 0; stoneIndex < arr.size(); stoneIndex++) {
                if (!contains(arr.get(stoneIndex), ch)) {
                    break;
                }
            }

            if (stoneIndex == arr.size()) {
                noOfGemstones++;
            }
        }

        return noOfGemstones;
    }

    public static boolean contains(String str, char search) {
        for (char ch : str.toCharArray()) {
            if (ch == search) {
                return true;
            }
        }

        return false;
    }
}

// https://www.hackerrank.com/challenges/gem-stones/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String arrItem = bufferedReader.readLine();
            arr.add(arrItem);
        }

        int result = Result.gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
