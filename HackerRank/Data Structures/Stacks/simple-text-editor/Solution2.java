import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/simple-text-editor/problem
public class Solution2 {
    static class Editor {
        public Stack<String> history;
        public StringBuilder sb;
        public StringBuilder results;

        public Editor() {
            history = new Stack<>();
            sb = new StringBuilder();
            results = new StringBuilder();
        }

        public void append(String word) {
            history.push(sb.toString());

            sb.append(word);
        }

        public void delete(int k) {
            history.push(sb.toString());

            int start = Math.max(0, sb.length() - k);

            sb.delete(start, sb.length());
        }

        public void print(int k) {
            k--;

            if (k >= 0 && k < sb.length()) {
                results.append(sb.charAt(k));
                results.append("\n");
            }
        }

        public void undo() {
            if (!history.isEmpty()) {
                sb = new StringBuilder(history.pop());
            }
        }

        public void printResults() {
            System.out.println(results);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);

        int noOfOperations = Integer.parseInt(scan.nextLine()), index, operation;
        String line, word;
        String[] tokens;

        Editor editor = new Editor();

        for (int i = 0; i < noOfOperations; i++) {
            line = scan.nextLine();
            tokens = line.split("\\s+");
            operation = Integer.parseInt(tokens[0]);

            if (operation == 1) {
                word = tokens[1];

                editor.append(word);
            } else if (operation == 2) {
                index = Integer.parseInt(tokens[1]);

                editor.delete(index);
            } else if (operation == 3) {
                index = Integer.parseInt(tokens[1]);

                editor.print(index);
            } else if (operation == 4) {
                editor.undo();
            }
        }

        editor.printResults();

        scan.close();
    }
}
