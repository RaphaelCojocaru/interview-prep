import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String gameOfThrones(String str) {
        int[] occurrences = new int[26];
        int noOfOddChars = 0;


        for (char ch : str.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (occurrences[i] % 2 == 1) {
                noOfOddChars++;
            }

            if (noOfOddChars > 1) {
                return "NO";
            }
        }

        return "YES";
    }

}

// https://www.hackerrank.com/challenges/game-of-thrones/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
