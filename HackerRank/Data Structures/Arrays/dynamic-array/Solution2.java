import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/dynamic-array/problem
class Solution2 {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> results = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>();
        int lastAnswer = 0, x, y, idx;
        
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<Integer>());
        }
        
        for (List<Integer> query : queries) {
            x = query.get(1);
            y = query.get(2);
            idx = (x ^ lastAnswer) % n;

            // Query Append
            if (query.get(0) == 1) {
                arr.get(idx).add(y);
            } else {
                lastAnswer = arr.get(idx).get(y % arr.get(idx).size());
                
                results.add(lastAnswer);
            }
        }

        return results;
    }
}
