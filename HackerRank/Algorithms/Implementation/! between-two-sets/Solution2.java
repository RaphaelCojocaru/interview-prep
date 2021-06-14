import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    public static int greatest_common_divisor(int a, int b) {
        if (a == 0) {
            return b;
        }
        
        return greatest_common_divisor(b % a, a);
    }
    
    public static int least_common_multiple(int a, int b){
        return (a / greatest_common_divisor(a, b)) * b;
    }
    
    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int gcd = b.get(0), lcm = a.get(0), count = 0;
        
        for (int value : b) {
            gcd = greatest_common_divisor(gcd, value);
        }
        
        for (int value : a) {
            lcm = least_common_multiple(lcm, value);
        }
        
        int lcmIncrement = lcm;
        while (lcm <= gcd) {
            if (gcd % lcm == 0) {
                count++;
            }
            
            lcm += lcmIncrement;
        }
        
        return count;
    }
}

// https://www.hackerrank.com/challenges/between-two-sets/problem
public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrTemp[i]);
            brr.add(brrItem);
        }

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
