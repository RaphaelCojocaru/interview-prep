import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/solve-me-first/problem
public class Solution {
    public static int solveMeFirst(int a, int b) {
        return a + b;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();

        System.out.println(solveMeFirst(a, b));
	}
}
