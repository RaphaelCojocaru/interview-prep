import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'cavityMap' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static List<String> cavityMap(List<String> grid) {
        int top, right, bottom, left, current;

        for (int i = 1; i < grid.size() - 1; i++) {
            for (int j = 1; j < grid.get(i).length() - 1; j++) {
                current = Character.getNumericValue(grid.get(i).charAt(j));

                top = Character.getNumericValue(grid.get(i - 1).charAt(j));
                right = Character.getNumericValue(grid.get(i).charAt(j + 1));
                bottom = Character.getNumericValue(grid.get(i + 1).charAt(j));
                left = Character.getNumericValue(grid.get(i).charAt(j - 1));

                if (current > top && current > bottom) {
                    if (current > right && current > left) {
                        grid.set(i, grid.get(i).substring(0, j) + "X" + grid.get(i).substring(j + 1));
                    }
                }
            }
        }

        return grid;
    }

}

// https://www.hackerrank.com/challenges/cavity-map/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String gridItem = bufferedReader.readLine();
            grid.add(gridItem);
        }

        List<String> result = Result.cavityMap(grid);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
