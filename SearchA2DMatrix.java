
public class SearchA2DMatrix {
	public static void main(String[] args) {
		System.out.println();
	}
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return false;
		int m = matrix.length, n = matrix[0].length;
		int left = 0, right = m * n;
		while (left < right) {
			int mid = (left + right) / 2;
			if (matrix[mid / n][mid % n] == target)
				return true;
			if (matrix[mid / n][mid % n] < target)
				left = mid + 1;
			else
				right = mid;
		}
		return false;
	}

}
