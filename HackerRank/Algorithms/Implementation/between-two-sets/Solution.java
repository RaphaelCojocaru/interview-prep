import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        System.out.println(between(a, b));
    }
    
    public static int between(int[] a, int[] b){
        if(a.length == 0 || b.length == 0)
            return 0;
        int counter = 0;
        Arrays.sort(a);
        int max = a[a.length-1];
        Arrays.sort(b);
        int min = b[0];
        boolean ok = false;
        for(int value=max;value<=min;value++){
            ok = true;
            for(int i:a)
                if(value % i != 0)
                    ok = false;
            if(ok == false)
                continue;
            for(int i:b)
                if(i % value != 0)
                    ok = false;
            if(ok == true)
                counter++;
        }
            
       // System.out.println(max + " " +min);
        return counter;
    }
}
