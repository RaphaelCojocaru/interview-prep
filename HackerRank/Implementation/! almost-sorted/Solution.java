import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/almost-sorted
public class Solution {
    
    // method for testing whether an array is sorted or not
    public static boolean isSorted(int[] array) {
        if (array.length < 2)
            return true;
              
        for (int i = 0; i < array.length - 1; i++)
            if (array[i] > array[i + 1]) 
                return false;
        
        return true;
    }
    
    public static void isAlmostSorted(int[] array) {
        // if the array is already sorted
        if (isSorted(array) == true) {
            System.out.println("yes");
            return;
        }
        
        int swapL = -1, swapR = -1;
        int i = 0, j = array.length - 1;
        int aux;
        
        // find the values that must be swapped
        // the values that don't follow the sorting order
        while (i < array.length && j > 0) {
            if (array[i] > array[i + 1] && swapL == - 1)
                swapL = i;
            if (array[j] < array[j - 1] && swapR == - 1)
                swapR = j;
            if (swapL != -1 && swapR != -1)  
                break;
            i++;
            j--;
        }
        
        // swap the values and test if array is sorted
        if (swapL != -1 && swapR != -1) {
            aux = array[swapL];
            array[swapL] = array[swapR];
            array[swapR] = aux;
            
            if (isSorted(array) == true) {
                System.out.println("yes");
                System.out.println("swap " + (swapL + 1) + " " + (swapR + 1));
                return;
            }
            
            // if the array is not sorted yet, then swap the 
            //values again and test for reverse
            aux = array[swapL];
            array[swapL] = array[swapR];
            array[swapR] = aux;
        }
        
        // reverse all the elements between the indices found previously
        int reverseL = swapL, reverseR = swapR;
        while (swapL < swapR) {
            aux = array[swapL];
            array[swapL] = array[swapR];
            array[swapR] = aux;
            swapL++;
            swapR--;
        }
        
        // test if the array is sorted or not
        if (isSorted(array) == true) {
            System.out.println("yes");
            System.out.println("reverse " + (reverseL + 1) + " " + (reverseR + 1));
        } else
            System.out.println("no");

    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();
        
        isAlmostSorted(array);
    }
}