package Big_O;

public class StringPermutations {
	public static void permutation(String str) {
		permutation(str, "");
	}
	
	public static void permutation(String str, String prefix) {
		if (str.length() == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				String remainder = str.substring(0, i) + str.substring(i + 1);
				
				permutation(remainder, prefix + str.charAt(i));
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "ABCD";
		
		permutation(str);
	}
}
