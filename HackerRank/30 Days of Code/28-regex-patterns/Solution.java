import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/30-regex-patterns
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<String> names = new ArrayList<String>();
        
        for(int a0 = 0; a0 < N; a0++){
            String firstName = in.next();
            String emailID = in.next();
            if (emailID.endsWith("@gmail.com"))
                names.add(firstName);
        }
                
        Collections.sort(names);
        for (String name : names)
                System.out.println(name);
    }
}
