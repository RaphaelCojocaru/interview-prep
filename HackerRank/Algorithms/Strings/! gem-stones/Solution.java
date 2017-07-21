import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/gem-stones
public class Solution {

    static int gemstones(String[] arr) {
        // Complete this function
        // count in how many strings each character appears
        int[] count = new int[26];
        
        for (String s : arr ) {
            char[] chars = s.toCharArray();
            // temporary array to mark the characters already seen
            int[] count_string = new int[26];
            for (char ch : chars) {
                if (count_string[ch - 'a'] == 0) {
                    count_string[ch - 'a'] = 1;
                    count[ch - 'a']++;
                }
            }
        }
        
        int gem_elements = 0;
        for (int value : count)
            if (value == arr.length)
                gem_elements++;
        
        return gem_elements;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.next();
        }
        int result = gemstones(arr);
        System.out.println(result);
    }
}
