import java.util.*;
public class SpiralMatrix {
	public static void main(String[] args) {
		System.out.println();
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix.length == 0 || matrix[0].length == 0)
			return res;
		int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
		while (top <= bottom && left <= right) {
			for (int i = left; i <= right; i++) 
				res.add(matrix[top][i]);
			for (int j = top + 1; j <= bottom; j++)
				res.add(matrix[j][right]);
			if (left < right && top < bottom) {
				for (int i = right - 1; i >= left; i--)
					res.add(matrix[bottom][i]);
				for (int j = bottom - 1; j > top; j--)
					res.add(matrix[j][left]);
			}
            left++;
            top++;
            right--;
            bottom--;
		}
		return res;
	}
}
