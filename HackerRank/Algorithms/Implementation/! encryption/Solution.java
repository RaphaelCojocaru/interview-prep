import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String encryption(String s) {
        s = removeSpaces(s);

        int rows = (int) Math.floor(Math.sqrt(s.length()));
        int columns = (int) Math.ceil(Math.sqrt(s.length()));

        StringBuilder encryptedText = new StringBuilder();

        if (rows * columns < s.length()) {
            rows++;
        }

        char[][] matrix = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i * columns + j < s.length()) {
                    matrix[i][j] = s.charAt(i * columns + j);
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (matrix[j][i] != ' ') {
                    encryptedText.append(matrix[j][i]);
                }
            }

            encryptedText.append(" ");
        }

        return encryptedText.toString();
    }

    public static String removeSpaces(String s) {
        StringBuilder withoutSpaces = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch != ' ' && ch != '\t') {
                withoutSpaces.append(ch);
            }
        }

        return withoutSpaces.toString();

        // return s.replaceAll("\\s","");
    }

}

// https://www.hackerrank.com/challenges/encryption/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
