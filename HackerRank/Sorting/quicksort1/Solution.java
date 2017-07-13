import java.util.*;

// https://www.hackerrank.com/challenges/quicksort1
public class Solution {
       
    public static void partition(int[] arr) {
        int low = 0, high = arr.length - 1, temp;      
        int pivot = arr[0];
        
        // put the pivot into the middle of the array
        temp = arr[0];
        arr[0] = arr[low + (high - low) / 2];
        arr[low + (high - low) / 2] = temp;
        
        while (low <= high) {
            while (arr[low] < pivot)
                low++;
            
            while (arr[high] > pivot)
                high--;
            
            if (low <= high) {
                temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                
                low++;
                high--;
            }
        }
        
        printArray(arr);
    }   
    
    public static void printArray(int[] ar) {
        for(int n : ar)
            System.out.print(n + " ");
        
        System.out.println();
    }
       
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        
        for (int i = 0; i < n; i++)
            ar[i]=in.nextInt(); 
        
        partition(ar);
   }    
}
