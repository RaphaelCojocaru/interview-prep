import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/plus-minus/problem
class Result {
    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void plusMinus(List<Integer> arr) {
        float negatives = 0, positives = 0, zeros = 0;

        if (arr.size() > 0) {
            for (int value : arr) {
                if (value > 0) {
                    positives++;
                } else if (value < 0) {
                    negatives++;
                } else {
                    zeros++;
                }
            }

            positives /= arr.size();
            negatives /= arr.size();
            zeros /= arr.size();
        }

        System.out.println(positives);
        System.out.println(negatives);
        System.out.println(zeros);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
