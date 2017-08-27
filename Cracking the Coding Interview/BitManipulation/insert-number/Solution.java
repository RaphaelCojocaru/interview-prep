package BitManipulation;

// You are given two 32-bit numbers, N and M, and two bit positions, land j. Write
//a method to insert M into N such that M starts at bit j and ends at bit i. You can
//assume that the bits j through i have enough space to fit all of M.
public class Solution {
	public static void printBits(int num) {
		for (int i = 0; i < 32; i++) {
			int value = num;
			value >>= i;
			if ((value & 1) == 1)
				System.out.print(1);
			else
				System.out.print(0);
		}
		System.out.println();
	}

	public static int setBit(int num, int index) {
		int mask = (1 << index);

		return (num | mask);
	}

	public static int unsetBit(int num, int index) {
		int mask = ~(1 << index);

		return (num & mask);
	}

	public static int insertNumber(int N, int M, int start, int end) {
		// check if there is enough space for insertion
		if (end > 31)
			return N;

		M <<= start;

		N = N | M;

		return N;
	}

	public static void main(String[] args) {
		int N = 1536;
		printBits(N);
		int M = 22;
		printBits(M);
		int start = 20;
		int end = 6;
		int result = insertNumber(N, M, start, end);
		printBits(result);
	}
}
