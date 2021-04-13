import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
public class Solution2 {
    static class MyQueue {
        private Stack<Integer> stack;
        private Stack<Integer> reversed;

        public MyQueue() {
            this.stack = new Stack<>();
            this.reversed = new Stack<>();
        }

        public void print() {
            if (!this.reversed.isEmpty()) {
                System.out.println(reversed.peek());

                return;
            }

            while (!this.stack.isEmpty()) {
                this.reversed.push(this.stack.pop());
            }

            System.out.println(this.reversed.peek());
        }

        public void enqueue(int value) {
            stack.push(value);
        }

        public int dequeue() {
            if (!this.reversed.isEmpty()) {
                return this.reversed.pop();
            }

            while (!this.stack.isEmpty()) {
                this.reversed.push(this.stack.pop());
            }

            if (!this.reversed.isEmpty()) {
                return this.reversed.pop();
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int queries = scan.nextInt(), operation, value;

        MyQueue queue = new MyQueue();

        for (int i = 0; i < queries; i++) {
            operation = scan.nextInt();

            if (operation == 1) {
                value = scan.nextInt();

                queue.enqueue(value);
            } else if (operation == 2) {
                queue.dequeue();
            } else {
                queue.print();
            }
        }

        scan.close();
    }
}
