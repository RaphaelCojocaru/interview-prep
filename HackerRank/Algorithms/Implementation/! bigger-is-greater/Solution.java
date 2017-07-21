import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/bigger-is-greater
public class Solution {

    public static String nextPermutation(String s) {
		// Find non-increasing suffix
        char[] array = s.toCharArray();
		int i = array.length - 1;
		while (i > 0 && array[i - 1] >= array[i])
			i--;
		if (i <= 0)
			return "no answer";
		
		// Find successor to pivot
		int j = array.length - 1;
		while (array[j] <= array[i - 1])
			j--;
		char temp = array[i - 1];
		array[i - 1] = array[j];
		array[j] = temp;
		
		// Reverse suffix
		j = array.length - 1;
		while (i < j) {
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}
		return String.valueOf(array);
	}
    
    public static String solveIt(String s) {
        char[] arr = s.toCharArray();
        char aux;
        int start = 0, end = arr.length - 1;
        int j = 0, i = 0;
        
        // find the first switching situation
        for (i = arr.length - 1; i > 0; i--) {
            j = i - 1;
            if (arr[i] > arr[j])
                break;
        }
        
        if (i == 0)
            return "no answer";
        
        // find the minimum/first character bigger than the pivot
        for (i = end; i > j; i--)
            if (arr[i] > arr[j]) {
                aux = arr[i];
                arr[i] = arr[j];
                arr[j] = aux;             
                break;
            }
        
        // reorder/reverse the suffix of the string
		i = arr.length - 1;
        j++;
		while (j < i) {
			aux = arr[i];
			arr[i] = arr[j];
			arr[j] = aux;
			i--;
			j++;
		}   
     
        return String.valueOf(arr);            
    }
    
    public static String solveIt_orig(String s) {
        char[] arr = s.toCharArray();
        int start = 0, end = arr.length - 1;
        boolean change = false;
        int j = 0;
        
        for (int i = end; i > 0; i--) {
            for (j = i - 1; j >= 0; j--)
                if (arr[i] > arr[j]) {
                    char aux = arr[i];
                    arr[i] = arr[j];
                    arr[j] = aux;
                    change = true;
                    break;
                }
            
            if (change == true)
                break;
        }
        
        if (change == false)
            return "no answer";
        
        if (arr.length - j < 3)
            return String.valueOf(arr);
        
        for (int i = j + 1; i < arr.length - 1; i++)
            for (int k = i + 1; k < arr.length; k++)
                if (arr[i] > arr[k]) {
                    char aux = arr[i];
                    arr[i] = arr[k];
                    arr[k] = aux;
                }
        
        return String.valueOf(arr);            
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int noWords = sc.nextInt();
        for (int i = 0; i < noWords; i++) {
            String s = sc.next();
            System.out.println(solveIt(s));
           // System.out.println(nextPermutation(s));
        }
            
    }
}