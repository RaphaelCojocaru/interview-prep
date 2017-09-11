import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-list
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // fill the list
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int value = scan.nextInt();
            list.add(value);
        }
        
        // perform the queries
        int q = scan.nextInt();
        for (int i = 0; i < q; i++) {
            String command = scan.next();
            if (command.equals("Insert") == true) {
                int index = scan.nextInt(); 
                int value = scan.nextInt();
                list.add(index, value);
            } else if (command.equals("Delete") == true) {
                int index = scan.nextInt();
                list.remove(index);
            }
        }
        
        // print the list
        for (int value : list) 
            System.out.print(value + " ");
        
        scan.close();
    }
}
