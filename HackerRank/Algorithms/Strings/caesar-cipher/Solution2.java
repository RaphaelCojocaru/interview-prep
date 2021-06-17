import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        StringBuilder sb = new StringBuilder(s);

        char ch;

        k %= 26;

        for (int i = 0; i < sb.length(); i++) {
            if (Character.isLetter(sb.charAt(i))) {
                ch = (char) (sb.charAt(i) + k);

                if ((Character.isLowerCase(s.charAt(i)) && ch > 'z') || (Character.isUpperCase(s.charAt(i)) && ch > 'Z')) {
                    ch -= 26;
                }

                sb.setCharAt(i, ch);
            }
        }

        return sb.toString();
    }

}

// https://www.hackerrank.com/challenges/caesar-cipher-1/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
