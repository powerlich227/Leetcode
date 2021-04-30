import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * LeetCode 773 Hard
 * 
 * Sliding Puzzle
 * 
On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given a puzzle board, return the least number of moves required so that the state of the board is solved. 
If it is impossible for the state of the board to be solved, return -1.

Examples:
Input: board = [[1,2,3],[4,0,5]]
Output: 1
Explanation: Swap the 0 and the 5 in one move.

Input: board = [[1,2,3],[5,4,0]]
Output: -1
Explanation: No number of moves will make the board solved.

Input: board = [[4,1,2],[5,0,3]]
Output: 5
Explanation: 5 is the smallest number of moves that solves the board.
An example path:
After move 0: [[4,1,2],[5,0,3]]
After move 1: [[4,1,2],[0,5,3]]
After move 2: [[0,1,2],[4,5,3]]
After move 3: [[1,0,2],[4,5,3]]
After move 4: [[1,2,0],[4,5,3]]
After move 5: [[1,2,3],[4,5,0]]

Input: board = [[3,2,4],[1,5,0]]
Output: 14

Note:
board will be a 2 x 3 array as described above.
board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
 */
public class SlidingPuzzle {
	public int slidingPuzzle(int[][] board) {
		int[][] neighbor = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
		
		String start = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++)
				start += board[i][j];
		}
		String target = "123450";
		
		HashSet<String> visit = new HashSet<>();
		visit.add(start);		
		Queue<String> q = new LinkedList<>();
		q.add(start);
		
		int res = 0;
		while (!q.isEmpty()) {
			int n = q.size();
			for (int i = 0; i < n; i++) {
				String cur = q.poll();
				
				if (cur.equals(target))
					return res;
				
				int idx = cur.indexOf('0');
				
				for (int neigh : neighbor[idx]) {
					StringBuilder sb = new StringBuilder(cur);
					sb.setCharAt(idx, cur.charAt(neigh));
					sb.setCharAt(neigh, cur.charAt(idx));
		
					String next = sb.toString();
					if (!visit.contains(next)) {
						visit.add(next);
						q.offer(next);
					}
				}
			}
			res++;
		}
		return -1;
	}
	public static void main(String[] args) {
		int[][] board = {{1, 2, 3}, {4, 0, 5}}, board2 = {{1, 2, 3}, {5, 4, 0}}, board3 = {{4, 1, 2}, {5, 0, 3}}, board4 = {{3, 2, 4},{1, 5, 0}};
		SlidingPuzzle test = new SlidingPuzzle();
		System.out.println(test.slidingPuzzle(board));
		System.out.println(test.slidingPuzzle(board2));
		System.out.println(test.slidingPuzzle(board3));
		System.out.println(test.slidingPuzzle(board4));
	}
}
