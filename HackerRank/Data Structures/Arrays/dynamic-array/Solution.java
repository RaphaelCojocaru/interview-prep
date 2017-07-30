import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/dynamic-array
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> seq = new ArrayList<>();
        for (int i = 0; i < n; i++)
            seq.add(new ArrayList<Integer>());
        
        int q = sc.nextInt();
        int lastAnswer = 0;
        for (int i = 0; i < q; i++) {
            int op = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            int index = (x ^ lastAnswer) % n;
            if (op == 1)
                seq.get(index).add(y);
            else {
                int size = seq.get(index).size();
                lastAnswer = seq.get(index).get(y % size);
                System.out.println(lastAnswer);
            }
        }
    }
}