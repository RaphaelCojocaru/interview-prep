import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/maximum-element
public class Solution {
    static class MyStack {
        Stack<Integer> stack; 
        PriorityQueue<Integer> queue; 
        
        public MyStack() {
            stack = new Stack<Integer>();
            queue = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        }

        public void push(int value) {
            stack.push(value);
            queue.add(value);
        }
        
        public void pop() {
            int value = stack.pop();
            queue.remove(value);
        }
        
        public int getMax() {
            return queue.peek();
        }
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution.MyStack myStack = new Solution.MyStack();
        for (int i = 0; i < n; i++) {
            int op = sc.nextInt();
            
            if (op == 1) {
                int value = sc.nextInt();
                myStack.push(value);
            } else if (op == 2) {
                myStack.pop();
            } else if (op == 3) {
                System.out.println(myStack.getMax());
            }
        }
    }
}