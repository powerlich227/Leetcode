import java.util.LinkedList;
import java.util.Queue;

/*
 * LeetCode 202 Medium
 * 
 * Number of Islands
 * 
 * 
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.


Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {
	public static void main(String[] args) {
		System.out.println();
	}
	// DFS
	public int numIslands(char[][] grid) {
		int res = 0;
		int m = grid.length, n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					res++;
					dFS(grid, i, j);
				}
					
			}
		}
		return res;
	}
	// change grid[i][j] from '1' to '0'
	public void dFS(char[][] grid, int i, int j) {
		int m = grid.length, n = grid[0].length;
		if (i < 0 || i > m || j < 0 || j > m || grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		dFS(grid, i + 1, j);
		dFS(grid, i, j + 1);
		dFS(grid, i - 1, j);
		dFS(grid, i, j - 1);
	}
	// BFS
	public int numIslands2(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int m = grid.length, n = grid[0].length;
		int res = 0;
		int[][] neighbor = {{1,0}, {-1,0}, {0,1}, {0,-1}};
		boolean[][] visited = new boolean[m][n];
        Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					q.add(i * n + j);
					visited[i][j] = true;
					res++;
					while (!q.isEmpty()) {
                        int cur = q.poll();
						for (int k = 0; k < 4; k++) { // neighbor
							int x = cur / n + neighbor[k][0];
							int y = cur % n + neighbor[k][1];
							if (x >= 0 && x < m && y >= 0 && y < n 
									&& grid[x][y] == '1' && !visited[x][y]) {
								visited[x][y] = true;
								q.add(x * n + y);
							}
						}
					}
				}
			}
		}
		return res;
	}
}
