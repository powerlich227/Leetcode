import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	public static void main(String[] args) {
		System.out.println();
	}
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		int res = 0;
		int[][] neighbor = {{1,0}, {-1,0}, {0,1}, {0,-1}};
		boolean[][] visited = new boolean[m][n];
        Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					q.add(i * n + j);
					visited[i][j] = true;
					res++;
					while(!q.isEmpty()) {
                        int point = q.poll();
						for (int k = 0; k < 4; k++) {
							int x = point / n + neighbor[k][0];
							int y = point % n + neighbor[k][1];
							if (x >= 0 && x < m && y >= 0 && y < n 
									&& grid[x][y] == '1' && !visited[x][y]) {
								visited[x][y] = true;
								q.add(x * n + y);
							}
						}
					}
				}
			}
		}
		return res;
	}
}
