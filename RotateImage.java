import java.util.Arrays;

public class RotateImage {
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		rotate(matrix);
		for (int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
	}
	public static void rotate(int[][] matrix) {
		int m = matrix.length;
		for (int i = 0; i < m / 2; i++) {
			for (int j = i; j < m - 1 - i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[m - 1 - j][i];
				matrix[m - 1 - j][i] = matrix[m - 1 - i][m - 1 - j];
				matrix[m - 1 - i][m - 1 - j] = matrix[j][m - 1 - i];
				matrix[j][m - 1 - i] = temp;
			}
		}
	}

}
