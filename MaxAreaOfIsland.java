/*
 * LeetCode 695 Medium
 * 
 * Max Area of Island
 * 
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) 
You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.


Example 1:
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],
[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.

Example 2:
Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
    	int m = grid.length, n = grid[0].length;
    	int res = 0;
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (grid[i][j] == 1)
    				res = Math.max(res, dFS(grid, i, j));
    		}
    	}
    	return res;
    }
    // return area of island
    public int dFS(int[][] grid, int i, int j) {
    	int m = grid.length, n = grid[0].length;
    	if (i < 0 || j < 0 || i >= m || j >= n)
    		return 0;
    	if (grid[i][j] == 0)
    		return 0;
    	grid[i][j] = 0;
    	return dFS(grid, i - 1, j) + dFS(grid, i + 1, j) + dFS(grid, i, j - 1) + dFS(grid, i, j + 1) + 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
