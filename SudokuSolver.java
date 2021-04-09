/*
 * LeetCode 37
 * 
 * Sudoku Solver
 * 
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Input: 
board = 
[["5","3",".",".","7",".",".",".","."],
["6",".",".","1","9","5",".",".","."],
[".","9","8",".",".",".",".","6","."]
["8",".",".",".","6",".",".",".","3"],
["4",".",".","8",".","3",".",".","1"],
["7",".",".",".","2",".",".",".","6"],
[".","6",".",".",".",".","2","8","."],
[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]]

Output: 
[["5","3","4","6","7","8","9","1","2"],
["6","7","2","1","9","5","3","4","8"],
["1","9","8","3","4","2","5","6","7"],
["8","5","9","7","6","1","4","2","3"],
["4","2","6","8","5","3","7","9","1"],
["7","1","3","9","2","4","8","5","6"],
["9","6","1","5","3","7","2","8","4"],
["2","8","7","4","1","9","6","3","5"],
["3","4","5","2","8","6","1","7","9"]]

Explanation: The input board is shown above and the only valid solution is shown below:
 */
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		helper(board, 0, 0);
	}
	public boolean helper(char[][] board, int i, int j) {
		if (i == 9)
			return true;
		if (j == 9)
			return helper(board, i + 1, 0);
		if (board[i][j] != '.')
			return helper(board, i, j + 1);
		for (char c = '1'; c <= '9'; c++) {
			if (isValid(board, i, j, c)) {
				board[i][j] = c;
				if (helper(board, i, j + 1))
					return true;
				board[i][j] = '.';
			}
		}
		return false;
	}
	public boolean isValid(char[][] board, int i, int j, char val) {
		for (int x = 0; x < 9; x++) {
			if (board[x][j] == val)
				return false;
		}
		for (int y = 0; y < 9; y++) {
			if (board[i][y] == val)
				return false;
		}
		int row = i - i % 3, col = j - j % 3;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (board[row + x][col + y] == val)
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
