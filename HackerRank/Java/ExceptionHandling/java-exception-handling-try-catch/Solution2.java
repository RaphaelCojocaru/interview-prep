import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem
public class Solution2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            int firstValue = scan.nextInt();
            int secondValue = scan.nextInt();

            System.out.println(firstValue / secondValue);
        } catch (InputMismatchException e) {
            System.out.println("java.util.InputMismatchException");
        } catch (Exception e){
            System.out.println(e.toString());
        }

        scan.close();
    }
}
