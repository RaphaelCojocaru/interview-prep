import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/cats-and-a-mouse
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            
            int distX = Math.abs(x - z);
            int distY = Math.abs(y - z);
            if (distX < distY)
                System.out.println("Cat A");
            else if (distY < distX)
                System.out.println("Cat B");
           else
               System.out.println("Mouse C");
        }
    }
}