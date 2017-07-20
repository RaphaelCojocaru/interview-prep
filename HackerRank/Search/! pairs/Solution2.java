import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/pairs
public class Solution2 {
    
    public static void quickSort(int[] array, int low, int high) {
        int i = low, j = high, pivot = array[low + (high - low) / 2];
        int temp;
        
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
    
    public static int pairs(int[] a, int k) {
        /* Complete this function */
        int count = 0, i = 0, j = 1;
        quickSort(a, 0, a.length - 1);
        
        while (j < a.length) {
            if (a[j] - a[i] == k) {
                count++;
                i++;
                j++;
            } else if (a[j] - a[i] < k) 
                j++;
            else
                i++;
        }
              
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        String n = in.nextLine();
        String[] n_split = n.split(" ");
        
        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);
        
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = pairs(_a,_k);
        System.out.println(res);
    }
}
