import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/queue-using-two-stacks
public class Solution {
    static class MyQueue {
        Stack<Integer> s1, s2;

        public MyQueue() {
            s1 = new Stack<Integer>();
            s2 = new Stack<Integer>();
        }
        
        public void enqueue(int value) {
            s1.push(value);
        }
        
        public void dequeue() {
            // use the s2 stack to store the elements in reverse order
            if (s2.isEmpty() == false) {
                s2.pop();
                return;
            }
            
            // if s2 became empty, then put all the elements from s1
            while (s1.isEmpty() == false)
                s2.push(s1.pop());
            
            // pop the first elements
            s2.pop();
        }
        
        public int first() {
            // if s2 (queue) has elements, return the peek
            if (s2.isEmpty() == false)
                return s2.peek();
            
            // put the elements from s1 to s2
            while (s1.isEmpty() == false) 
                s2.push(s1.pop());
            
            // return peek
            return s2.peek();
        }
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        int queries = Integer.parseInt(line);
        MyQueue queue = new MyQueue();
        for (int i = 0; i < queries; i++) {
            line = scan.nextLine();
            String[] parts = line.split("\\s+");
            if (Integer.parseInt(parts[0]) == 1)
                queue.enqueue(Integer.parseInt(parts[1]));
            else if (Integer.parseInt(parts[0]) == 2)
                queue.dequeue();
            else
                System.out.println(queue.first());
        }
    }
}