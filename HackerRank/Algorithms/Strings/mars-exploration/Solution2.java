import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int marsExploration(String s) {
        int noOfAlterations = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i % 3 == 0 && s.charAt(i) != 'S') {
                noOfAlterations++;
            } else if (i % 3 == 1 && s.charAt(i) != 'O') {
                noOfAlterations++;
            } else if (i % 3 == 2 && s.charAt(i) != 'S') {
                noOfAlterations++;
            }
        }

        return noOfAlterations;
    }

}

// https://www.hackerrank.com/challenges/mars-exploration/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
