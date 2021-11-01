import java.util.*;
/*
 * 
 * LeetCode 36 Medium
 * 
 * Valid Sudoku
 * 
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:
Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:
Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
 */
public class ValidSudoku {
	public static void main(String[] args) {
		System.out.println();
	}
	// Hash with array
	public boolean isValidSoduku(char[][] board) {
		boolean[][] rowFlag = new boolean[9][9];
		boolean[][] colFlag = new boolean[9][9];
		boolean[][] cellFlag = new boolean[9][9];
		for (int i = 0; i < 9; i++) {
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
	// Hash with hashset
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
