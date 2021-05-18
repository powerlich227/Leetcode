import java.util.LinkedList;
import java.util.List;

/*
 * LeetCode 51 Hard
 * 
 * N-Queens
 * 
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 */
public class NQueens {
	static List<List<String>> res = new LinkedList<>();
	public static List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		backTrack(board, 0);
		return res;
	}
	public static void backTrack(char[][] board, int row) {
		if (row == board.length) {
			res.add(helper(board));
			return;
		}
		int n = board[row].length;
		for (int col = 0; col < n; col++) {
			if (!isValid(board, row, col))
				continue;
			board[row][col] = 'Q';
			backTrack(board, row + 1);
			board[row][col] = '.';
		}
	}
	public static List<String> helper(char[][] board) {
		List<String> res = new LinkedList<>();
		for (int i = 0; i < board.length; i++) {
			String s = new String(board[i]);
			res.add(s);
		}
		return res;
	}
	public static boolean isValid(char[][] board, int row, int col) {
		int n = board.length;
		for (int i = 0; i < n; i++) {
			if (board[i][col] == 'Q' || board[row][i] == 'Q')
				return false;
		}
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 'Q')
				return false;
		}
		for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
			if (board[i][j] == 'Q')
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(solveNQueens(4));
	}
}
