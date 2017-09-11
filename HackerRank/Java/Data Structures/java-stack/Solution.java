import java.util.*;

class Solution {
    
    // https://www.hackerrank.com/challenges/java-stack
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else if (stack.isEmpty() == false) {
                if (ch == ')' && stack.peek() == '(')
                    stack.pop();
                else if (ch == '}' && stack.peek() == '{')
                    stack.pop();
                else if (ch == ']' && stack.peek() == '[')
                    stack.pop();
            } else
                return false;
        }
        
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        while (sc.hasNext()) {
            String input = sc.next();
            //Complete the code
            System.out.println(isBalanced(input));
        }
    }
}
