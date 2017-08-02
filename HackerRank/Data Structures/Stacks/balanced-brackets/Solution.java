import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/balanced-brackets
public class Solution {

    static String isBalanced(String s) {
        // Complete this function
        Stack<Character> stack = new Stack<Character>();
        
        for (char ch : s.toCharArray())
            // put all the open brackets in the stack
            if (ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            // remove brackets from the stack if they match the current ch
            else if (ch == ')' && stack.isEmpty() == false && stack.peek() == '(')
                stack.pop();
            else if (ch == ']' && stack.isEmpty() == false && stack.peek() == '[')
                stack.pop();
            else if (ch == '}' && stack.isEmpty() == false && stack.peek() == '{')
                stack.pop();
            else
                return "NO";
        
        // check if the stack is empty
        if (stack.isEmpty() == true)
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }
}
