import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'beautifulBinaryString' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING b as parameter.
     */
    public static int beautifulBinaryString(String str) {
        int noOfChanges = 0;

        for (int i = 0; i < str.length() - 2;) {
            if (str.charAt(i) == '0' && str.charAt(i + 1) == '1'
             && str.charAt(i + 2) == '0') {
                noOfChanges++;
                i += 3;
            } else {
                i++;
            }
        }

        return noOfChanges;
    }
}

// https://www.hackerrank.com/challenges/beautiful-binary-string/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String b = bufferedReader.readLine();

        int result = Result.beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
