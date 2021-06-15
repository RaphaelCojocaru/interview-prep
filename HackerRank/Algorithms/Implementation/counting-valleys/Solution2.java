import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        int altitude = 0, noOfValleys = 0;
        boolean valleyStarts = false;
        
        for (char step : path.toCharArray()) {
            if (step == 'U') {
                altitude++;
            } else {
                altitude--;
            }
            
            if (altitude < 0) {
                valleyStarts = true;
            }
            
            if (altitude >= 0 && valleyStarts) {
                noOfValleys++;
                
                valleyStarts = false;
            }
        }
        
        return noOfValleys;
    }

}

// https://www.hackerrank.com/challenges/counting-valleys/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
