import java.util.*;
public class UniquePathsII {
	public static void main(String[] args) {
		System.out.println();
	}
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1)
			return 0;
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] res = new int[m + 1][n + 1]; // int[0][n] int[m][0] initial value = 0 		
		for(int i = 0; i < m; i++)
			Arrays.fill(res[i], 0);
		res[0][1] = 1;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (obstacleGrid[i - 1][j - 1] == 1)
					continue;
				res[i][j] = res[i - 1][j] + res[i][j - 1];
			}
		}
		return res[m][n];
	}
	// 1D Array
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1)
			return 0;
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[] res = new int[n];	
		Arrays.fill(res, 0);
		res[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 1)
					continue;
				else if (j > 0)
					res[j] += res[j - 1];
			}
		}
		return res[n];
	}

}
