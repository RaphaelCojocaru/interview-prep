import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> ratings = new ArrayList<Integer>();

        for (int i = 1; i < ranked.size(); i++) {
            if (ranked.get(i - 1).intValue() == ranked.get(i).intValue()) {
                ranked.remove(i);
                i--;
            }
        }

        for (int score : player) {
            ratings.add(binarySearch(ranked, score));
        }

        return ratings;
    }

    public static int binarySearch(List<Integer> rank, int score) {
        int low = 0, high = rank.size() - 1, middle;

        if (score > rank.get(0)) {
            return 1;
        }

        if (score < rank.get(rank.size() - 1)) {
            return rank.size() + 1;
        }

        while (low <= high) {
            middle = low + (high - low) / 2;

            if (score < rank.get(middle)) {
                low = middle + 1;
            } else if (score > rank.get(middle)) {
                high = middle - 1;
            } else {
                return middle + 1;
            }
        }

        return low + 1;
    }
}

// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] rankedTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> ranked = new ArrayList<>();

        for (int i = 0; i < rankedCount; i++) {
            int rankedItem = Integer.parseInt(rankedTemp[i]);
            ranked.add(rankedItem);
        }

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] playerTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> player = new ArrayList<>();

        for (int i = 0; i < playerCount; i++) {
            int playerItem = Integer.parseInt(playerTemp[i]);
            player.add(playerItem);
        }

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
