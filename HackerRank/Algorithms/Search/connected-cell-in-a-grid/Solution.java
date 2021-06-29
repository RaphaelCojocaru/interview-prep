import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int connectedCell(List<List<Integer>> matrix) {
        int maxRegion = 0;
        int[][] mat = new int[matrix.size()][matrix.get(0).size()];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = matrix.get(i).get(j);
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                maxRegion = Math.max(maxRegion, countRegion(mat, i, j));
            }
        }

        return maxRegion;
    }

    public static int countRegion(int[][] mat, int i, int j) {
        if (i >= mat.length || i < 0) {
            return 0;
        }

        if (j >= mat[0].length || j < 0) {
            return 0;
        }

        if (mat[i][j] == 0) {
            return 0;
        }

        mat[i][j] = 0;

        int sameRow = countRegion(mat, i, j + 1) + countRegion(mat, i, j - 1);
        int sameColumn = countRegion(mat, i + 1, j) + countRegion(mat, i - 1, j);
        int firstDiag = countRegion(mat, i + 1, j + 1) + countRegion(mat, i - 1, j - 1);
        int secDiag = countRegion(mat, i + 1, j - 1) + countRegion(mat, i - 1, j + 1);

        return 1 + sameRow + sameColumn + firstDiag + secDiag;
    }
}

// https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
