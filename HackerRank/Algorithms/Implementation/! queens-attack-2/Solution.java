import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        int totalAttacks = 0;

        // compute all distances to the ends of the board
        int left = c_q - 1;
        int right = n - c_q;
        int top = n - r_q;
        int bottom = r_q - 1;
        int top_left = Math.min(top, left);
        int top_right = Math.min(top, right);
        int bottom_left = Math.min(bottom, left);
        int bottom_right = Math.min(bottom, right);

        // check if obstacle
        int r_obstacle, c_obstacle;
        for (List<Integer> obstacle : obstacles) {
            r_obstacle = obstacle.get(0);
            c_obstacle = obstacle.get(1);

            // same row
            if (r_obstacle == r_q) {
                if (c_obstacle > c_q) {
                    right = Math.min(right, c_obstacle - c_q - 1);
                } else {
                    left = Math.min(left, c_q - c_obstacle - 1);
                }
            }

            // same column
            if (c_obstacle == c_q) {
                if (r_obstacle > r_q) {
                    top = Math.min(top, r_obstacle - r_q - 1);
                } else {
                    bottom = Math.min(bottom, r_q - r_obstacle - 1);
                }
            }

            // same diagonal
            if (Math.abs(c_obstacle - c_q) == Math.abs(r_obstacle - r_q)) {
                // first diagonal
                if (c_obstacle < c_q && r_obstacle < r_q || c_obstacle > c_q && r_obstacle > r_q ) {
                    if (c_obstacle > c_q) {
                        top_right = Math.min(top_right, c_obstacle - c_q - 1);
                    } else {
                        bottom_left = Math.min(bottom_left, c_q - c_obstacle - 1);
                    }
                } else {
                    if (c_obstacle > c_q) {
                        bottom_right = Math.min(bottom_right, c_obstacle - c_q - 1);
                    } else {
                        top_left = Math.min(top_left, c_q - c_obstacle - 1);
                    }
                }
            }
        }

        return right + left + top + bottom + top_left + top_right + bottom_left + bottom_right;
    }

}

// https://www.hackerrank.com/challenges/queens-attack-2/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> obstaclesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowTempItems[j]);
                obstaclesRowItems.add(obstaclesItem);
            }

            obstacles.add(obstaclesRowItems);
        }

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
