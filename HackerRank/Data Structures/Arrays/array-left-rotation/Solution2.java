import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/array-left-rotation/problem
class Solution2 {

    /*
     * Complete the 'rotateLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */
    public static List<Integer> rotateLeft2(int d, List<Integer> list) {
        List<Integer> rotated = new ArrayList<>();
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        d = d % arr.length;

        for (int i = 0; i < d; i++) {
            int firstValue = arr[0];

            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }

            arr[arr.length - 1] = firstValue;
        }

        for (int value : arr) {
            rotated.add(value);

        }

        return rotated;
    }

    public static List<Integer> rotateLeft(int d, List<Integer> list) {
        d = d % list.size();

        List<Integer> before = list.subList(0, d);
        List<Integer> after = list.subList(d, list.size());

        after.addAll(before);

        return after;
    }
}
