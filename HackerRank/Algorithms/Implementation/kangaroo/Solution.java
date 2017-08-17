import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        System.out.println(meet(x1, v1, x2, v2));
    }
    
    public static String meet(int x1, int v1, int x2, int v2){
        float N = (float)(x1 - x2)/(v2 - v1);
        if(N > 0 && N == Math.round(N))
            return "YES";
        return "NO";
    }
}
