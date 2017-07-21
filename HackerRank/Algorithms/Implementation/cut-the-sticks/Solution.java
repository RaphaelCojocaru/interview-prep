import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/cut-the-sticks
public class Solution {

    public static void solveIt(int[] arr) {
        boolean done = false;
        int count = 0;
        int min = Integer.MAX_VALUE;
        
        while (!done) {
            done = true;
            // find min value:
            min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                // min should be _different_ than 0
                if (arr[i] < min && arr[i] > 0)
                    min = arr[i];
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    count++;
                    arr[i] -= min;
                    done = false;
                }
            }
            
            if (count != 0)
                System.out.println(count);
            count = 0;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        solveIt(arr);
    }
}
