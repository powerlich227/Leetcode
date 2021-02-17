import java.util.*;
public class UniquePaths {
	public static void main(String[] args) {
		System.out.println();
	}
	// 1D-Array
	public int uniquePaths(int m, int n) {
		int[] res = new int[n];
		Arrays.fill(res, 1);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++)
				res[j] += res[j - 1];
		}
		return res[n - 1];
	}
	// 2D-Array
	public int uniquePaths2(int m, int n) {
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++)
			Arrays.fill(res[i], 1);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++)
				res[i][j] += res[i - 1][j] + res[i][j - 1];
		}
		return res[m - 1][n - 1];
	}

}
