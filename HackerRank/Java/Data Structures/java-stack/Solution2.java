import java.util.*;

// https://www.hackerrank.com/challenges/java-stack/problem
class Solution2 {
    public static boolean isOpeningParanthesis(char paranthesis) {
        if (paranthesis == '(' || paranthesis == '[' || paranthesis == '{') {
            return true;
        }

        return false;
    }

    public static char complementaryParanthesis(char paranthesis) {
        switch (paranthesis) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                return 0;
        }
    }

    public static boolean queryIsBalanced(String query) {
        Stack<Character> stack = new Stack<>();

        for (char ch : query.toCharArray()) {
            if (isOpeningParanthesis(ch)) {
                stack.push(ch);
            } else if (!stack.isEmpty() && stack.peek() == complementaryParanthesis(ch)) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {
			String query = scan.next();
            if (queryIsBalanced(query)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
		}

        scan.close();
	}
}
