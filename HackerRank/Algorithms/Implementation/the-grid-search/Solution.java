import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'gridSearch' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY G
     *  2. STRING_ARRAY P
     */

    public static String gridSearch(List<String> grid, List<String> pattern) {
        int gridRows = grid.size(), gridColumns = grid.get(0).length();
        int patternRows = pattern.size(), patternColumns = pattern.get(0).length();

        if (gridRows < patternRows || gridColumns < patternColumns) {
            return "NO";
        }

        boolean diffs;
        for (int i = 0; i <= gridRows - patternRows; i++) {
            for (int j = 0; j <= gridColumns - patternColumns; j++) {
                diffs = false;

                for (int k = 0; k < patternRows; k++) {
                    for (int l = 0; l < patternColumns; l++) {
                        if (grid.get(i + k).charAt(j + l) != pattern.get(k).charAt(l)) {
                            diffs = true;

                            break;
                        }
                    }

                    if (diffs) {
                        diffs = true;

                        break;
                    }
                }

                if (diffs == false) {
                    return "YES";
                }
            }
        }

        return "NO";
    }

}

// https://www.hackerrank.com/challenges/the-grid-search/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int R = Integer.parseInt(firstMultipleInput[0]);

            int C = Integer.parseInt(firstMultipleInput[1]);

            List<String> G = new ArrayList<>();

            for (int i = 0; i < R; i++) {
                String GItem = bufferedReader.readLine();
                G.add(GItem);
            }

            String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int r = Integer.parseInt(secondMultipleInput[0]);

            int c = Integer.parseInt(secondMultipleInput[1]);

            List<String> P = new ArrayList<>();

            for (int i = 0; i < r; i++) {
                String PItem = bufferedReader.readLine();
                P.add(PItem);
            }

            String result = Result.gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
