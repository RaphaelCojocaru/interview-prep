package Implementation;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	static int getMoneySpent_s(int[] keyboards, int[] drives, int s) {
		// Complete this function
		int max = -1;
		for (int k : keyboards)
			for (int d : drives) {
				int temp = k + d;
				if (temp <= s && temp > max)
					max = temp;
			}

		return max;
	}

	static int getMoneySpent(int[] keyboards, int[] drives, int s) {
		// Complete this function
		int max = -1;

		Integer[] key = new Integer[keyboards.length];
		for (int i = 0; i < keyboards.length; i++)
			key[i] = Integer.valueOf(keyboards[i]);

		Arrays.sort(key, Collections.reverseOrder());
		Arrays.sort(drives);
		for (int i = 0, j = 0; i < key.length; i++)
			for (; j < drives.length; j++) {
				if (key[i] + drives[j] > s) break;
				if (key[i] + drives[j] > max)
					max = key[i] + drives[j];
			}

		return max;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int n = in.nextInt();
		int m = in.nextInt();
		int[] keyboards = new int[n];
		for (int keyboards_i = 0; keyboards_i < n; keyboards_i++) {
			keyboards[keyboards_i] = in.nextInt();
		}
		int[] drives = new int[m];
		for (int drives_i = 0; drives_i < m; drives_i++) {
			drives[drives_i] = in.nextInt();
		}
		// The maximum amount of money she can spend on a keyboard and USB drive, or -1
		// if she can't purchase both items
		int moneySpent = getMoneySpent(keyboards, drives, s);
		System.out.println(moneySpent);
	}
}