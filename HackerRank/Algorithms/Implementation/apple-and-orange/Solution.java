import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int apples = 0, oranges = 0;

    public static void count(int s, int t, int a, int b, int[] apple, int[] orange){
        int apples = 0, oranges = 0;
        for(int i =0;i<apple.length;i++)
            if(a + apple[i] >= s && a + apple[i] <= t)
                apples++;
        for(int i =0;i<orange.length;i++)
            if(b + orange[i] >= s && b + orange[i] <= t)
                oranges++;
        Solution.apples = apples;
        Solution.oranges = oranges;
    }
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        count(s, t, a, b, apple, orange);
        System.out.println(Solution.apples);
        System.out.println(Solution.oranges);
    }
    

}
