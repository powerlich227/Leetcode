
public class Search2DMatrixII {
	public static void main(String[] args) {
		System.out.println();
	}
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return false;
		int m = matrix.length, n = 0;
		while (m >= 0 && n < matrix[0].length) {
			if (matrix[m][n] == target)
				return true;
			if (matrix[m][n] < target)
				n++;
			else
				m--;
		}
		return false;
	}

}
