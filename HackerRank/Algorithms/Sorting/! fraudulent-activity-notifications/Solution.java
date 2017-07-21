import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
public class Solution {
    // perform counting sort
    public static int[] countingSort(int[] arr, int low, int high) {
        int[] counter = new int[201];
        
        for (int i = low; i < high; i++)
            counter[arr[i]]++;
        
        return counter;
    }
    
    private static double getMedian(int[] counter, int d, int medianPosition) {
        int total = 0, i = 0, j = 0;

        while (i < counter.length && total < medianPosition) {
		    total += counter[i];
            i++;                            
		}
        // go a position backwards
        i--;
        
		if (total > medianPosition || d % 2 != 0) 
            return i;
   
       	for (j = i + 1; j < counter.length; j++)
            if (counter[j] != 0)
                break;
        
		return (i + j) / 2.0;
	} 
    
    private static int countfraudulentNotifications(int[] arr, int d) {
		int[] counter = countingSort(arr, 0, d);
		int i, j = 0, count = 0, medianPos;
        
        // compute median position
        if (d % 2 == 0)
            medianPos = d / 2;
        else
            medianPos = d / 2 + 1;
        
         for (i = d; i < arr.length; i++) {
            double median = getMedian(counter, d, medianPos);
            if (arr[i] >= 2 * median)
                count++;
			counter[arr[i]]++;
			counter[arr[j]]--;
			j++;
        }

		return count;
	}
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n, d;
        int[] arr;
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        arr = new int[n];
        d= sc.nextInt();
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println(countfraudulentNotifications(arr, d));
    }
}
