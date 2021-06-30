import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int height1 = 0, height2 = 0, height3 = 0, maxHeight;

        for (Integer height : h1) {
            height1 += height.intValue();
        }

        for (Integer height : h2){
            height2 += height.intValue();
        }

        for (Integer height : h3) {
            height3 += height.intValue();
        }

        while (height1 != height2 || height1 != height3) {
            maxHeight = Math.max(height1, Math.max(height2, height3));

            if (height1 == maxHeight) {
                height1 -= h1.remove(0);
            }

            if (height2 == maxHeight) {
                height2 -= h2.remove(0);
            }

            if (height3 == maxHeight) {
                height3 -= h3.remove(0);
            }
        }

        return height1;
    }

}

// https://www.hackerrank.com/challenges/equal-stacks/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        String[] h1Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h1 = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            int h1Item = Integer.parseInt(h1Temp[i]);
            h1.add(h1Item);
        }

        String[] h2Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h2 = new ArrayList<>();

        for (int i = 0; i < n2; i++) {
            int h2Item = Integer.parseInt(h2Temp[i]);
            h2.add(h2Item);
        }

        String[] h3Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h3 = new ArrayList<>();

        for (int i = 0; i < n3; i++) {
            int h3Item = Integer.parseInt(h3Temp[i]);
            h3.add(h3Item);
        }

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
