
import java.util.*;

// https://www.hackerrank.com/challenges/quicksort2/problem
public class Solution {

    static int partition(int arr[], int low, int high) {
        ArrayList<Integer> leftList = new ArrayList<Integer>();
        ArrayList<Integer> rightList = new ArrayList<Integer>();

        int pivot = arr[low];

        for (int i = low + 1; i <= high; i++) {
               if (arr[i] < pivot) {
                   leftList.add(arr[i]);
               } else {
                   rightList.add(arr[i]);
               }
        }

        copy(leftList, arr, low);

        int pivotPosition = leftList.size() + low;
        arr[pivotPosition] = pivot;

        copy(rightList, arr, pivotPosition + 1);

        return pivotPosition;
    }

    static void copy(ArrayList<Integer> list, int arr[], int start) {
            for(int value : list) {
               arr[start++] = value;
            }
    }

    static void quickSort(int arr[], int low, int high) {
        if (low >= high) {
            return;
        }

        int middle = partition(arr, low, high);

        quickSort(arr, low, middle - 1);
        quickSort(arr, middle + 1, high);

        printArray(arr, low, high);
   }

    static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void printArray(int[] arr, int low, int high) {
        for (int i = low; i <= high; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        quickSort(arr);
    }
}
