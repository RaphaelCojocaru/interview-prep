import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/big-sorting
public class Solution_quick {
    
    public static int compareLexicographically(String s1, String s2) {
        char ch;
        
        if (s1.length() > s2.length())
            return 1;
        else if (s1.length() < s2.length())
            return -1;
            
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) < s2.charAt(i))
                return -1;
            else if (s1.charAt(i) > s2.charAt(i))
                return 1;
            else 
                continue;
        }
        
        return 0;
    }

    public static void swap(String[] array, int i, int j) {
        String temp;
        
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void quickSort(String[] array, int low, int high) {
        int i = low, j = high;
        String pivot = array[low + (high - low) / 2];
        
        while (i <= j) {
            while (compareLexicographically(array[i], pivot) < 0)    
                i++;
            while (compareLexicographically(array[j], pivot) > 0)    
                j--;
            
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        
        if (low < j)
            quickSort(array, low, j);
        if (i < high)
            quickSort(array, i, high);
    }
    
    public static void bigSorting(int n, String[] array) {
        quickSort(array, 0, n - 1);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        // your code goes here
        bigSorting(n, unsorted);
		for (String s : unsorted)
			System.out.println(s);
    }
}
