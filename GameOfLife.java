/*
 * LeetCode 289 Medium
 * 
 * Game Of Life
 * 
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). 
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. 
Given the current state of the m x n grid board, return the next state.


Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.
 

Follow up:
Could you solve it in-place? Remember that the board needs to be updated simultaneously: 
You cannot update some cells first and then use their updated values to update other cells.

In this question, we represent the board using a 2D array. 
In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). 
How would you address these problems?
 */
public class GameOfLife {
	// status 0: dead to dead
	// status 1: live to live
	// status 2: live to dead
	// status 3: dead to live
	public void gameOfLife(int[][] board) {
		int m = board.length, n = board[0].length;
		int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0}; // x, from left-up, anti-clockwise
		int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1}; // y, from left-up, anti-clockwise
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int k = 0; k < 8; k++) {
					int x = i + dx[k], y = j + dy[k];
					if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] == 1 || board[x][y] == 2)) {
						cnt++; // current live status 1&2
					}
				}
				if (board[i][j] == 1 && (cnt < 2 || cnt > 3))
					board[i][j] = 2;
				else if (board[i][j] == 0 && cnt == 3)
					board[i][j] = 3;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] %= 2;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
