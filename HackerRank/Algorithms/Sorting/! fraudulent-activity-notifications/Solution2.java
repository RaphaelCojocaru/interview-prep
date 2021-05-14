import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {
        int[] arr = new int[expenditure.size()];
        for (int i = 0; i < expenditure.size(); i++) {
            arr[i] = expenditure.get(i);
        }

        int noOfNotifications = 0;

        int medianIndex1 = d / 2;
        int medianIndex2 = d % 2 == 1 ? medianIndex1 : medianIndex1 - 1;
        int median1 = 0, median2 = 0;

        int[] counter = new int[201];
        for (int i = 0; i < d; i++) {
            counter[arr[i]]++;
        }

        for (int i = d; i < arr.length; i++) {
            for (int j = 0, total = 0; total <= medianIndex1; total += counter[j], j++) {
                median1 = j;
            }

            int j = 0, total = 0;
            while (total <= medianIndex2) {
                median2 = j;

                total += counter[j];
                j++;
            }

            if (arr[i] >= median1 + median2) {
                noOfNotifications++;
            }

            counter[arr[i - d]]--;
            counter[arr[i]]++;
        }

        return noOfNotifications;
    }
}

// https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        String[] expenditureTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> expenditure = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureTemp[i]);
            expenditure.add(expenditureItem);
        }

        int result = Result.activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
