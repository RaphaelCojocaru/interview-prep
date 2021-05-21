import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-negative-subarray/problem
public class Solution3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = scan.nextInt();
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = scan.nextInt();
        }

        int negativePartialSums = 0, partialSum = 0;
        for (int i = 0; i < length; i++) {
            partialSum = 0;
            for (int j = i; j < length; j++) {
                partialSum += array[j];
                if (partialSum < 0) {
                    negativePartialSums++;
                }
            }
        }

        System.out.println(negativePartialSums);

        scan.close();
    }
}
