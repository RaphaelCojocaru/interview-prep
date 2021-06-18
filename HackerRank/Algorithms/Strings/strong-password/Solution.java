import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */
    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int minAdditions = 0, hasDigit = 1, hasLowercase = 1, hasUppercase = 1, hasSpecial = 1;

        HashSet<Character> specialCharacters = new HashSet<>();
        String special = "!@#$%^&*()-+";

        for (char ch : special.toCharArray()) {
            specialCharacters.add(ch);
        }

        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                hasDigit = 0;
            }

            if (Character.isUpperCase(ch)) {
                hasUppercase = 0;
            }

            if (Character.isLowerCase(ch)) {
                hasLowercase = 0;
            }

            if (specialCharacters.contains(ch)) {
                hasSpecial = 0;
            }
        }

        minAdditions = hasDigit + hasUppercase + hasLowercase + hasSpecial;

        if (password.length() + minAdditions >= 6) {
            return minAdditions;
        }

        return 6 - password.length();
    }

}

// https://www.hackerrank.com/challenges/strong-password/problem
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
