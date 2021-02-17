
public class WordSearch {
	public static void main(String[] args) {
		System.out.println();
	}
	public boolean exist(char[][] board, String word) {
		if (board.length == 0 || board[0].length == 0)
			return false;
		int m = board.length, n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (helper(board, word, 0, i, j))
					return true;
			}
		}
		return false;
	}
	public boolean helper(char[][] board, String word, int level, int i, int j) {
		if (level == word.length())
			return true;
		int m = board.length, n = board[0].length;
		if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(level))
			return false;
		char temp = board[i][j];
		board[i][j] = '*';
		boolean res = helper(board, word, level + 1, i - 1, j) || helper(board, word, level + 1, i, j + 1)
				|| helper(board, word, level + 1, i + 1, j) || helper(board, word, level + 1, i, j - 1);
		board[i][j] = temp;
		return res;
	}

}
