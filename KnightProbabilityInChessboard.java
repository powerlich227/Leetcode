/*
 * LeetCode 688 Medium
 * 
 * Knight Probability in Chessboard
 * 
On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. 
The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).

A chess knight has eight possible moves it can make, as illustrated below. 
Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.

Each time the knight is to move, it chooses one of eight possible moves uniformly at random 
(even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly k moves or has moved off the chessboard.
Return the probability that the knight remains on the board after it has stopped moving.

 
Example 1:
Input: n = 3, k = 2, row = 0, column = 0
Output: 0.06250
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.

Example 2:
Input: n = 1, k = 0, row = 0, column = 0
Output: 1.00000
 

Constraints:
1 <= n <= 25
0 <= k <= 100
0 <= row, column <= n
 */
public class KnightProbabilityInChessboard {
	public double knightProbability(int n, int k, int row, int column) {
		if (k == 0)
			return 1.0;
		double[][] dp = new double[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = 1;
			}
		}
		int[][] direction = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
		for (int m = 0; m < k; m++) {
			double[][] temp = new double[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int[] dir : direction) {
						int x = i + dir[0], y = j + dir[1];
						if (x < 0 || x >= n || y < 0 || y >=n )
							continue;
						temp[i][j] += dp[x][y];
					}
				}
			}
			dp = temp;
		}
		return dp[row][column] / Math.pow(8, k);
	}
	public static void main(String[] args) {
		KnightProbabilityInChessboard test = new KnightProbabilityInChessboard();
		System.out.println(test.knightProbability(3, 2, 0, 0));
		System.out.println(test.knightProbability(1, 0, 0, 0));
		System.out.println(test.knightProbability(7, 2, 4, 4));
	}
}
