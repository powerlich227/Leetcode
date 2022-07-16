import java.util.Arrays;

/*
 * LeetCode 576 Medium
 * 
 * Out of Boundary Paths
 * 
There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. 
You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). 
You can apply at most maxMove moves to the ball.

Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. 
Since the answer can be very large, return it modulo 10^9 + 7.

 
Example 1:
Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
Output: 6

Example 2:
Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
Output: 12
 
Constraints:
1 <= m, n <= 50
0 <= maxMove <= 50
0 <= startRow < m
0 <= startColumn < n
 */
public class OutOfBoundaryPaths {
    // DFS with memo
    private int[][][] memo;
    private int M = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new int[m][n][maxMove + 1];
        for (int[][] mem : memo) {
            for (int[] me : mem) {
                Arrays.fill(me, -1);
            }
        }
        return dFS(startRow, startColumn, m, n, maxMove);
    }
    public int dFS(int i, int j, int m, int n, int max) {
        if (max < 0)
            return 0;
        if (i < 0 || j < 0 || i >= m || j >= n)
            return 1;
        if (memo[i][j][max] != -1)
            return memo[i][j][max];
        memo[i][j][max] = ((dFS(i + 1, j, m, n, max - 1) + dFS(i - 1, j, m, n, max - 1)) % M 
        		+ (dFS(i, j - 1, m, n, max - 1) + dFS(i, j + 1, m, n, max - 1)) % M) % M;
        return memo[i][j][max];
    }
	public static void main(String[] args) {
		OutOfBoundaryPaths test = new OutOfBoundaryPaths();
		System.out.println(test.findPaths(2, 2, 2, 0, 0));
		System.out.println(test.findPaths(1, 3, 3, 0, 1));
		System.out.println(test.findPaths(50, 50, 50, 0, 0));
	}
}
