package Arrays_Strings;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

// Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
//column are set to 0.
public class Solution {

	public static void replaceZeroes(int[][] mat) {
		ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>();

		for (int i = 0; i < mat.length; i++)
			for (int j = 0; j < mat[i].length; j++)
				if (mat[i][j] == 0)
					list.add(new AbstractMap.SimpleEntry<Integer, Integer>(i, j));

		for (Map.Entry<Integer, Integer> elem : list) {
			int row = elem.getKey();
			int column = elem.getValue();

			for (int i = 0; i < mat[0].length; i++)
				mat[row][i] = 0;

			for (int i = 0; i < mat.length; i++)
				mat[i][column] = 0;
		}

	}

	public static void printMat(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++)
				if (mat[i][j] < 10)
					System.out.print(mat[i][j] + "  ");
				else
					System.out.print(mat[i][j] + " ");
			System.out.println();
		}

	}

	public static void main(String[] args) {
		int m = 5, n = 6;
		int[][] mat = new int[m][n];
		Random generator = new Random();
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				mat[i][j] = generator.nextInt(100);
				if (mat[i][j] % 13 == 0)
					mat[i][j] = 0;
			}

		printMat(mat);
		System.out.println("-----------------------------");

		replaceZeroes(mat);

		printMat(mat);

	}
}
