import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/lonely-integer
public class Solution {

    public static int lonelyinteger(int[] a) {
        // Complete this function
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int value : a) {
            if (set.contains(value))
                set.remove(value);
            else
                set.add(value);
        }
        
        Iterator<Integer> it = set.iterator();  
        return it.next();  
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = lonelyinteger(a);
        System.out.println(result);
    }
}
