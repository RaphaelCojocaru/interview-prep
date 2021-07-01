import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'twoStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER maxSum
     *  2. INTEGER_ARRAY a
     *  3. INTEGER_ARRAY b
     */

    public static int twoStacks(int x, List<Integer> aList, List<Integer> bList) {
        int[] a = new int[aList.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = aList.get(i).intValue();
        }
        int[] b = new int[bList.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = bList.get(i).intValue();
        }
        int i = 0, j = 0, total = 0, count = 0;

        // put all the elements from the first stack
        while (i < a.length &&  total + a[i] <= x) {
            total += a[i];
            i++;
        }

        // store the count
        count = i;

        while (j < b.length && i >= 0)  {
            // add the first element from the second array
            total += b[j];
            j++;
            // remove elements from the first array
            while (total > x && i > 0) {
                i--;
                total -= a[i];
            }

            // check if total is lower than x and we have more elements
            if (total <= x && i + j > count)
                count = i + j;
        }

        return count;
    }

}

// https://www.hackerrank.com/challenges/game-of-two-stacks/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            int maxSum = Integer.parseInt(firstMultipleInput[2]);

            String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> a = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aTemp[i]);
                a.add(aItem);
            }

            String[] bTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> b = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int bItem = Integer.parseInt(bTemp[i]);
                b.add(bItem);
            }

            int result = Result.twoStacks(maxSum, a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
