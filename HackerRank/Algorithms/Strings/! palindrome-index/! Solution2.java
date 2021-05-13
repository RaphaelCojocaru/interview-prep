import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    public static int palindromeIndex(String str) {
        int start = 0, end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {

                // check if the issue is at the beginning
                if (isPalindrome(str, start + 1, end)) {
                    return start;
                }

                // check if the issue is at the end
                if (isPalindrome(str, start, end - 1)) {
                    return end;
                }

                return -1;
            }

            start++;
            end--;
        }

        return -1;
    }

    public static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static int palindromeIndex_V2(String s) {
        // Complete this function
        int index = -1;
        int start = 0, end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                if (s.charAt(start + 1) == s.charAt(end)) {
                    if (start + 2 <= end - 1) {
                        if (s.charAt(end - 1) != s.charAt(start + 2)) {
                            return end;
                        }
                    }

                    return start;
                }

                if (s.charAt(start) == s.charAt(end - 1)) {
                    if (start + 1 <= end - 2) {
                        if (s.charAt(start + 1) != s.charAt(end - 2)) {
                            return start;
                        }
                    }

                    return end;
                }
            }

            start++;
            end--;
        }

        return index;
    }

    public static int palindromeIndex_V3(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s);

            sb.deleteCharAt(i);

            if (isPalindrome(sb.toString())) {
                return i;
            }

            sb.setLength(0);
        }

        return -1;
    }

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}

// https://www.hackerrank.com/challenges/palindrome-index/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();

            int result = Result.palindromeIndex(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
