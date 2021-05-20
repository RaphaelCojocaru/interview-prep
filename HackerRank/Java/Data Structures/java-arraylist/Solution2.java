import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-arraylist/problem
public class Solution2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> myHash = new ArrayList<>();

        int noOfLists = scan.nextInt();
        for (int i = 0; i < noOfLists; i++) {
            ArrayList<Integer> newList = new ArrayList<>();
            int noOfElements = scan.nextInt();
            for (int j = 0; j < noOfElements; j++) {
                newList.add(scan.nextInt());
            }

            myHash.add(newList);
        }

        int noOfQueries = scan.nextInt(), x, y;
        for (int i = 0; i < noOfQueries; i++) {
            x = scan.nextInt();
            y = scan.nextInt();
            if (x < 1 || y < 1) {
                System.out.println("ERROR!");
                continue;
            }

            if (x <= myHash.size()) {
                if (y <= myHash.get(x - 1).size()) {
                    System.out.println(myHash.get(x - 1).get(y - 1));
                    continue;
                }
            }

            System.out.println("ERROR!");
        }

        scan.close();
    }
}