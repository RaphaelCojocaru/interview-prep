import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] solve(int[] arr){
        // Complete this function
        int[] res = new int[arr.length];
        
        for (int i = 0 ;i < arr.length;i++)
            if (arr[i] < 38)
                res[i] = arr[i];
            else if (arr[i] % 5 > 2)
                res[i] = arr[i] - arr[i] % 5 + 5;
            else
                res[i] = arr[i];
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
        

    }
}
