import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/picking-numbers
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        // count the appearances for each number:
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int value : a)
            if (hash.containsKey(value))
                hash.put(value, hash.get(value) + 1);
            else
                hash.put(value, 1);

        int max = -1;
        int sum1, sum2;
        // for each number X in the array check if there exists any number Y having an
        //absolute diffence <= 1 and if so, then sum them up together
        for (int value : a) {
            sum1 = hash.get(value);
            sum2 = sum1;
            if (hash.containsKey(value - 1))
                sum1 += hash.get(value - 1);
            if (hash.containsKey(value + 1))
                sum2 += hash.get(value + 1);
            if (sum1 > sum2 && sum1 > max)
                max = sum1;
            else if (sum2 >= sum1 && sum2 > max)
                max = sum2;
            
        }
        System.out.println(max);
            
    }
}
