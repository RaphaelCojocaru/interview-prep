package Interview;

// Facebook
public interface StringPerm {

	public static int getPermutationNo(String s) {
		int countLeft, countRight;
		// System.out.println(s);
		if (s.length() < 2)
			return s.length();

		int middle = s.length() / 2;

		countLeft = getPermutationNo(s.substring(0, middle));
		countRight = getPermutationNo(s.substring(middle, s.length()));

		int number = Character.getNumericValue(s.charAt(middle - 1)) * 10 + Character.getNumericValue(s.charAt(middle));
		if (number <= 26)
		//if (s.charAt(middle - 1) < '2' || (s.charAt(middle - 1) == '2' && s.charAt(middle) <= '6'))
			return countLeft * countRight + 1;
		else
			return countLeft * countRight;
	}

	public static void main(String[] args) {
		// 1 -> A
		// 2 -> B
		// .. 26 -> Z 1 2 1: 1 2 1; 12 1; 1 21
		String s = "12211221"; // 1 2 3; 12 3; 1 23
		System.out.println(s + " " + getPermutationNo(s));
		/*
		 * 12 21 12 21
		 * 
		 * 12 12 [2] [2] + 1
		 * 
		 * 1 2 1 2 {1 2, 12} {1 2, 12}
		 * 
		 * 
		 * 1 2 1 2 12 1 2 1 21 2 1 2 12 12 12
		 */
	}
}
