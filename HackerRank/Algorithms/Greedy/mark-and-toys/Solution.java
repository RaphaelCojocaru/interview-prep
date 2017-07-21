import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/mark-and-toys
public class Solution {
    
    public static void quickSort(int[] array, int low, int high) {
		int i = low, j = high, temp;
		int pivot = array[low + (high - low) / 2];
        
		while (i <= j) {
			while (array[i] < pivot)
				i++;
			while (array[j] > pivot)
				j--;
			
			if (i <= j) {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
				
		}
		
		if (low < j)
			quickSort(array, low, j);
		if (i < high)
			quickSort(array, i, high);
	}
    
    public static int countMaxToys(int n, int k, int[] prices) {
        int toysNo = 0;
        
        quickSort(prices, 0, n - 1);
        
        for (int i = 0; i < n; i++) {
            if (prices[i] <= k) {
                toysNo++;
                k -= prices[i];
            } else
                return toysNo;
        }
        
        return toysNo;
    }
    
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt(), k = stdin.nextInt();
        int prices[] = new int[n];
        int answer = 0;
        
        for(int i = 0; i < n; i++)
            prices[i] = stdin.nextInt();
  
        answer = countMaxToys(n, k, prices);
        
        // Compute the final answer from n,k,prices 
        System.out.println(answer);
    }
}
