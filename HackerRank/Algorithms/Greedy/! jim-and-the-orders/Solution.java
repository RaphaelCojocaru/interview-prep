import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/jim-and-the-orders
public class Solution {
    
    // perform _stable_ insertion sort:
    public static void insertionSort(int[] time, int[] orderNumber) {
        for (int i = 1; i < time.length; i++) {
            int value = time[i];
            int value2 = orderNumber[i];
            int j = i;
            while (j > 0 && time[j - 1] > value) {
                time[j] = time[j - 1];
                orderNumber[j] = orderNumber[j - 1];
                j--;
            }
            time[j] = value;
            orderNumber[j] = value2;
        }
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] orderNumber = new int[n];
        int[] time = new int[n];
        
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int total = start + end;
            orderNumber[i] = i + 1;
            time[i] = total;
        }
        insertionSort(time, orderNumber);
        
        for (int value : orderNumber)
            System.out.print(value + " ");
        
    }
}