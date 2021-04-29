import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'marcsCakewalk' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY calorie as parameter.
     */

    public static long marcsCakewalk(List<Integer> calorie) {
        long noOfMiles = 0;

        insertionSort(calorie);

        for (int i = 0; i < calorie.size(); i++) {
            noOfMiles += Math.pow(2, i) * calorie.get(i);
        }

        return noOfMiles;
    }

    public static void insertionSort(List<Integer> calorie) {
        int j, value;

        for (int i = 1; i < calorie.size(); i++) {
            value = calorie.get(i);
            j = i;

            while (j > 0 && calorie.get(j - 1) < value) {
                calorie.set(j, calorie.get(j - 1));

                j--;
            }

            calorie.set(j, value);
        }
    }
}

// https://www.hackerrank.com/challenges/marcs-cakewalk/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] calorieTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> calorie = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int calorieItem = Integer.parseInt(calorieTemp[i]);
            calorie.add(calorieItem);
        }

        long result = Result.marcsCakewalk(calorie);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
