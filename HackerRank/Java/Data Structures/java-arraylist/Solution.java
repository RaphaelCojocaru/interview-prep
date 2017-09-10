import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-arraylist
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int listsNo = scan.nextInt();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < listsNo; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int values = scan.nextInt();
            for (int j = 0; j < values; j++) {
                int value = scan.nextInt();
                list.add(value);
            }
            lists.add(list);
        }
        int queries = scan.nextInt();
        for (int i = 0; i < queries; i++) {
            int listIndex = scan.nextInt();
            int elementIndex = scan.nextInt();
            if (listIndex < 1 || elementIndex < 1) {
                System.out.println("ERROR!");
                continue;
            }
            
            if (listIndex > lists.size())
                System.out.println("ERROR!");
            else if (elementIndex > lists.get(listIndex - 1).size())
                System.out.println("ERROR!");
            else
                System.out.println(lists.get(listIndex - 1).get(elementIndex - 1));
        }
        scan.close();
    }
}