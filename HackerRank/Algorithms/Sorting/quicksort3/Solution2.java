import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/quicksort3/problem
public class Solution2 {
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high], i = low, temp;

        for (int j = low; j < high; j++){
            if(arr[j] < pivot){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }

        temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    public static void quickSort(int[] arr, int low, int high){
        int pivot;

        if (low < high){
            pivot = partition(arr, low, high);

            printArray(arr);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static void printArray(int[] arr){
        for(int value : arr){
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        quickSort(arr, 0, n - 1);
    }
}
