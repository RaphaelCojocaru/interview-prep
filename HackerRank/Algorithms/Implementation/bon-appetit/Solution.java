import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int sum = 0;
        for(int i=0;i<n;i++){
            int el = in.nextInt();
            if(i!=k)
                sum += el;
        }
        int cash = in.nextInt();
        sum /= 2;
        if(sum != cash)
            System.out.println(cash - sum);
        else
            System.out.println("Bon Appetit");
    }
}