import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(func(n));
        }
    }
    public static int func(int n){
        if(n < 1)
            return 1;
        int count = 1;
        count = (int)Math.pow(2, 1+((n+1)/2)) - (1 + (n%2));
        return count;
    }
}
