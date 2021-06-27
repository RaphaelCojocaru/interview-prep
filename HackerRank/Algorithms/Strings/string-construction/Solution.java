import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/string-construction
public class Solution {

    static int stringConstruction(String s) {
        // Complete this function
        ArrayList<Character> list = new ArrayList<>();
        int cost = 0;

        for (char ch : s.toCharArray()) {
            if (list.contains(ch) == false) {
                list.add(ch);
                cost++;
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = stringConstruction(s);
            System.out.println(result);
        }
        in.close();
    }
}
