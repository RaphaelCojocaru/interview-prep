import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-list/problem
public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> myList = new ArrayList<>();

        int size = scan.nextInt();

        for (int i = 0; i < size; i++) {
            myList.add(scan.nextInt());
        }

        int noOfQueries = scan.nextInt();

        for (int i = 0; i < noOfQueries; i++) {
            String operation = scan.next();
            if (operation.equals("Insert")) {
                int index = scan.nextInt();
                int value = scan.nextInt();

                if (index < 0 || index > myList.size()) {
                    continue;
                } else {
                    myList.add(index, value);
                }
            } else if (operation.equals("Delete")) {
                int index = scan.nextInt();
                if (index < 0 || index > myList.size()) {
                    continue;
                } else {
                    myList.remove(index);
                }
            }
        }

        for (int value : myList) {
            System.out.print(value + " ");
        }

        scan.close();    }
}