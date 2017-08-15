import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/simple-text-editor
public class Solution {
    static class MyEditor {
        // current text into editor
        private StringBuilder text;
        // stack for saving the old texts
        private Stack<String> stack;
        
        public MyEditor() {
            text = new StringBuilder();
            stack = new Stack<String>();
        }
        
        public void append(String w) {
            stack.push(text.toString());
            text.append(w);
        }
        
        public void delete(int k) {
            stack.push(text.toString());
            int end = text.length();
            int start = end - k;
            
            if (start < 0)
                start = 0;
            
            text.delete(start, end);
        }
        
        public void printKth(int k) {
            k--;
            if (k < 0 || k >= text.length())
                return;
            System.out.println(text.charAt(k));
        }
        
        public void undo() {
            if (stack.isEmpty() == true)
                return;
            
            String old = stack.pop();
            // create new StringBuilder
            text = new StringBuilder(old);
        }
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String line;
        String[] parts;
        int n;
        line = sc.nextLine();
        n = Integer.parseInt(line);
        Solution.MyEditor myEditor = new Solution.MyEditor();
        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            parts = line.split(" ");
            int op = Integer.parseInt(parts[0]);
            if (op == 1) {
                myEditor.append(parts[1]);
            } else if (op == 2) {
                int k = Integer.parseInt(parts[1]);
                myEditor.delete(k);
            } else if (op == 3) {
                int k = Integer.parseInt(parts[1]);
                myEditor.printKth(k);
            } else if (op == 4) {
                myEditor.undo();
            }
        }
    }
}