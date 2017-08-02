package Arrays_Strings;

// Given an image represented by an NxN matrix, where each pixel in the image is 4
//bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
public class Solution {
	public static int[][] rotateClockwise(int[][] mat) {
		int rows = mat.length;
		if (rows == 0)
			return mat;
		int columns = mat[0].length;
		int[][] tmp = new int[rows][columns];

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				tmp[j][rows - i - 1] = mat[i][j];

		return tmp;
	}

	public static int[][] rotateClockwiseInPlace(int[][] mat) {
		int rows = mat.length;
		if (rows == 0)
			return mat;
		int columns = mat[0].length;

		// Attention at i and j indexes
		for (int i = 0; i < rows / 2; i++)
			for (int j = i; j < columns - i - 1; j++) {
				// top edge
				int tmp = mat[i][j];
				mat[i][j] = mat[columns - 1 - j][i];
				// left edge
				mat[columns - 1 - j][i] = mat[rows - 1 - i][columns - 1 - j];
				// bottom edge
				mat[rows - 1 - i][columns - 1 - j] = mat[j][rows - i - 1];
				// right edge
				mat[j][rows - i - 1] = tmp;
			}

		return mat;
	}

	public static void printMat(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int N = 3;
		int[][] mat = new int[N][N];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				mat[i][j] = i;

		printMat(mat);

		int[][] rotated = rotateClockwise(mat);

		System.out.println("--------------");
		printMat(rotated);

		System.out.println("--------------");
		printMat(rotateClockwiseInPlace(mat));
	}
}
