/*
 * LeetCode 130 Medium
 * 
 * Surrounded Regions
 * 
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example 1:
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. 
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. 
Two cells are connected if they are adjacent cells connected horizontally or vertically.

Example 2:
Input: board = [["X"]]
Output: [["X"]]
 
Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    dFS(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }           
    }
    public void dFS(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        if (board[i][j] == 'O') {
            board[i][j] = '*';
            if (i > 0 && board[i - 1][j] == 'O')
                dFS(board, i - 1, j);
            if (j > 0 && board[i][j - 1] == 'O')
                dFS(board, i, j - 1);
            if (i < m - 1 && board[i + 1][j] == 'O')
                dFS(board, i + 1, j);
            if (j < n - 1 && board[i][j + 1] == 'O')
                dFS(board, i, j + 1);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
