import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/30-2d-arrays
public class Solution {
    public static int maximumSum(int[][] arr) {
        int max = Integer.MIN_VALUE, currSum = 0;
        
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                currSum = 0;
                currSum += arr[i][j];
                currSum += arr[i][j + 1];
                currSum += arr[i][j + 2];
                currSum += arr[i + 1][j + 1];
                currSum += arr[i + 2][j];
                currSum += arr[i + 2][j + 1];
                currSum += arr[i + 2][j + 2];
                if (currSum > max)
                    max = currSum;
            }
        
        return max;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        
        System.out.println(maximumSum(arr));
    }
}
