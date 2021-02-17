
public class SpiralMatrixII {
	public static void main(String[] args) {
		System.out.println();
	}
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int left = 0, right = n - 1, top = 0, bottom = n - 1, value = 1;
		while (left <= right && top <= bottom) {
			for (int i = left; i <= right; i++)
				res[top][i] = value++;
			for (int j = ++top; j <= bottom; j++)
				res[j][right] = value++;
			for (int i = --right; i >= left; i--)
				res[bottom][i] = value++;
			for (int j = --bottom; j >= top; j--)
					res[j][left] = value++;
			left++;
//			top++;
//			right--;
//			bottom--;
		}
		return res;
	}

}
