import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-2d-array
public class Solution {
    public static int computeLargestSum(int[][] arr) {
        int largestSum = -81;

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                int temp = 0;
                temp += arr[i][j];
                temp += arr[i][j + 1];
                temp += arr[i][j + 2];
                temp += arr[i + 1][j + 1];
                temp += arr[i + 2][j];
                temp += arr[i + 2][j + 1];
                temp += arr[i + 2][j + 2];
                if (temp > largestSum)
                    largestSum = temp;
            }

        return largestSum;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(computeLargestSum(arr));
    }
}

