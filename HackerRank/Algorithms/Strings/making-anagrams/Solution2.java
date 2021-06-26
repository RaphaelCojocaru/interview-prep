import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
        int[] occurrences1 = new int[26];
        int[] occurrences2 = new int[26];
        int identicalCharacters = 0;

        for (char ch : s1.toCharArray()) {
            occurrences1[ch - 'a']++;
        }

        for (char ch : s2.toCharArray()) {
            occurrences2[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            identicalCharacters += Math.min(occurrences1[i], occurrences2[i]);
        }

        return s1.length() + s2.length() - identicalCharacters * 2;
    }

}

// https://www.hackerrank.com/challenges/making-anagrams/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
// learn this!
for (Map.Entry<Integer, Integer> entry : hash.entrySet())
    if (entry.getValue() > mostAppearances) {
        mostAppearances = entry.getValue();
        mostFreqElem = entry.getKey();
    }
}