import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/time-conversion/problem
class Result {
    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String timeConversion(String s) {
        String time = s.substring(0, s.length() - 2);

        String[] tokens = time.split(":");
        int hours = Integer.parseInt(tokens[0]);

        String meridian = s.substring(s.length() - 2);
        if (meridian.equals("PM")) {
            if (hours != 12) {
                hours += 12;
            }
        } else {
            if (hours == 12) {
                hours = 0;
            }
        }

        return (hours < 10 ? "0" + hours : hours) + ":" + tokens[1] + ":" + tokens[2];
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
