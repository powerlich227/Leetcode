import java.util.*;

public class ValidSudoku {
	public static void main(String[] args) {
		System.out.println();
	}
	public boolean isValidSoduku(char[][] board) {
		boolean[][] rowFlag = new boolean[9][9];
		boolean[][] colFlag = new boolean[9][9];
		boolean[][] cellFlag = new boolean[9][9];
		// row
		for (int i = 0; i < 9; i++) {
			// column
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					continue;
				int c = board[i][j] - '1';
				int cell = 3 * (i / 3) + j / 3; // cell	
				if (rowFlag[i][c] || colFlag[c][j] || cellFlag[cell][c])
					return false;
				rowFlag[i][c] = true;
				colFlag[c][j] = true;
				cellFlag[cell][c] = true;
			}
		}
		return true;
	}
	public boolean isValidSoduku2(char[][] board) {
		HashSet<Object> set = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					continue;
				String str = "(" + board[i][j] + ")";
				String row = Integer.toString(i) + str;
				String col = str + Integer.toString(j);
				String cell = Integer.toString(i / 3) + str + Integer.toString(j / 3);
				if(set.contains(row) || set.contains(col) || set.contains(cell))
					return false;
				set.add(row);
				set.add(col);
				set.add(cell);
			}
		}
		return true;
	}

}
