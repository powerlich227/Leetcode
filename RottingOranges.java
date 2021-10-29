import java.util.LinkedList;
import java.util.Queue;

/*
 * LeetCode 994 Medium
 * 
 * Rotting Oranges
 * 
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.


Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
 */
public class RottingOranges {
	// BFS with Queue
	// from rotten to fresh
	public int orangesRotting(int[][] grid) {
		int res = 0, fresh = 0, m = grid.length, n = grid[0].length;
		int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1)
					fresh++;
				else if (grid[i][j] == 2)
					q.offer(new int[] {i, j});
			}
		}
		if (fresh == 0)
			return res;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				for (int[] dir : dirs) {
					int x = cur[0] + dir[0];
					int y = cur[1] + dir[1];
					if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1)
						continue;
					fresh--;
					if (fresh == 0) // break and return res + 1
						return ++res;
					grid[x][y] = 2;
					q.offer(new int[] {x, y});
				}
			}
			res++;
		}
		return (fresh == 0) ? res : -1;
	}
	public static void main(String[] args) {
		RottingOranges test = new RottingOranges();
		System.out.println(test.orangesRotting(new int[][] {{2,1,1},{1,1,0},{0,1,1}}));
		System.out.println(test.orangesRotting(new int[][] {{2,1,1},{0,1,1},{1,0,1}}));
		System.out.println(test.orangesRotting(new int[][] {{0,2}}));
	}
}
