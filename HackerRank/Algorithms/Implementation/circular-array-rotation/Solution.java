import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int noElements, noRotations, noQueries;
        String line;
        String[] splits;
        line = in.nextLine();
        splits = line.split(" ");
        noElements = Integer.parseInt(splits[0]);
        noRotations = Integer.parseInt(splits[1]);
        noQueries = Integer.parseInt(splits[2]);        
        int[] arr = new int[noElements];
        int[] arr2 = new int[noElements];
        line = in.nextLine();
        splits = line.split(" ");
        for(int i=0;i<splits.length;i++)
            arr[i] = Integer.parseInt(splits[i]);
        int[] pos = new int[noQueries];
        for(int i=0;i<noQueries;i++){
            pos[i] = Integer.parseInt(in.nextLine());
        }
		
        // We are doining the entire rotation in one single step:
        noRotations %= noElements;
        int index;
        if(noRotations != 0){
            for(int i=0;i<noElements;i++){
                index = (i + noRotations)%noElements;
                arr2[index] = arr[i];
            }
            for(int i=0;i<noQueries;i++)
                System.out.println(arr2[pos[i]]);
        }else{
            for(int i=0;i<noQueries;i++)
                System.out.println(arr[pos[i]]);
        }
    }
}