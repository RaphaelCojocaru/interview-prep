package BitManipulation;

public class Helper {
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

	public static void main(String[] args) {
		int v1 = Integer.MAX_VALUE;
		printBits(v1);
		v1 = unsetBit(v1, 3);
		printBits(v1);
		int v2 = 24;
		printBits(v2);
		v2 = setBit(v2, 10);
		printBits(v2);
	}
}
