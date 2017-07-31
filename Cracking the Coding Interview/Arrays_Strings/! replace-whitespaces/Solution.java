package Arrays_Strings;

// Write a method to replace all spaces in a string with '%20'
public class Solution {

	public static char[] replaceSpaces(char[] array, int length) {
		// compute the new length:
		int newLength = length - 1;
		
		for (int i = 0; i < length; i++)
			if (array[i] == ' ')
				newLength += 2;

		// iterate through the array, in reverse order
		for (int i = length - 1; i >= 0; i--)
			if (array[i] == ' ') {
				array[newLength] = '0';
				array[newLength - 1] = '2';
				array[newLength - 2] = '%';
				newLength -= 3;
			} else {
				array[newLength] = array[i];
				newLength--;
			}

		return array;
	}

	public static void main(String[] args) {
		String[] words = { "an a  ", "code is fun.    " };
		int[] lengths = {4, 12};
		
		for (int i = 0; i < words.length; i++) {
			char[] array = replaceSpaces(words[i].toCharArray(), lengths[i]);
			System.out.println(array);
		}

	}
}
