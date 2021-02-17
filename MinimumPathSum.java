
public class MinimumPathSum {
	public static void main(String[] args) {
		System.out.println();
	}
	public int minPathSum(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0)
			return 0;
		int m = grid.length, n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (i == 0 && j == 0)
					continue;
				if (i == 0)
					grid[0][j] += grid[0][j - 1];
				else if (j == 0)
					grid[i][0] += grid[i - 1][0];
				else
					grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}
		return grid[m - 1][n - 1];
	}

}
