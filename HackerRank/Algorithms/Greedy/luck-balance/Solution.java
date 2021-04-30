import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    static class Pair {
        public int luck;
        public int importance;

        public Pair(int luck, int importance) {
            this.luck = luck;
            this.importance = importance;
        }
    }

    /*
     * Complete the 'luckBalance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. 2D_INTEGER_ARRAY contests
     */

    public static int luckBalance(int k, List<List<Integer>> list) {
        Pair[] contests = new Pair[list.size()];
        int luck = 0, noOfImportantContests = 0, noOfWins;

        for (List<Integer> contest : list) {
            if (contest.get(1) != 0) {
                noOfImportantContests++;
            }
        }

        noOfWins = Math.max(0, noOfImportantContests - k);

        for (int i = 0; i < list.size(); i++) {
            contests[i] = new Pair(list.get(i).get(0), list.get(i).get(1));
        }

        quickSort(contests, 0, contests.length - 1);



        for (Pair contest : contests) {
            if (noOfWins > 0 && contest.importance > 0) {
                luck -= contest.luck;

                noOfWins--;

                continue;
            }

            luck += contest.luck;
        }

        return luck;
    }

    public static void quickSort(Pair[] arr, int low, int high) {
        int i = low, j = high;
        Pair pivot = arr[low + (high - low) / 2], temp;

        while (i <= j) {
            while (arr[i].luck < pivot.luck) {
                i++;
            }
            while (arr[j].luck > pivot.luck) {
                j--;
            }

            if (i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(arr, low, j);
        }

        if (i < high) {
            quickSort(arr, i, high);
        }
    }
}

// https://www.hackerrank.com/challenges/luck-balance/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> contests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] contestsRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> contestsRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowTempItems[j]);
                contestsRowItems.add(contestsItem);
            }

            contests.add(contestsRowItems);
        }

        int result = Result.luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
