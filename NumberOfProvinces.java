/*
 * LeetCode 547 Medium
 * 
 * Number of Provinces
 * 
There are n cities. Some of them are connected, while some are not. 
If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, 
and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

Example 1:
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

Example 2:
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 
Constraints:
1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
 */
public class NumberOfProvinces {
	// DFS
	public int findCircleNum(int[][] M) {
		int n = M.length;
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (M[i][i] == 1) {
				dFS(M, i);
				res++;
			}
		}
		return res;
	}
	// flood fill algorithm
	public void dFS(int[][] M, int i) {
		M[i][i] = 0;
		int n = M.length;
		for (int j = 0; j < n; j++) {
			if (M[j][j] != 0 && M[i][j] == 1) {
				dFS(M, j);
			}
		}
	}
    // BFS
 	public int findCircleNum2(int[][] M) {
 		int res = 0;
 		int m = M.length;
 		boolean[] visited = new boolean[m];
 		Queue<Integer> q = new LinkedList<>();
        
 		for (int i = 0; i < m; i++) {
 			if(!visited[i]) {
 				q.add(i);
 				visited[i] = true;
				res++;
 				while(!q.isEmpty()) {
 					int n = q.poll();
 					for (int j = 0; j < m; j++) {
 						if(M[n][j] == 1 && !visited[j]) {
 							visited[j] = true;
 							q.add(j);
                         }
 					}
 				}
 			}
 		}
 		return res;
 	}
	public static void main(String[] args) {
		NumberOfProvinces test = new NumberOfProvinces();
		System.out.println(test.findCircleNum(new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
		System.out.println(test.findCircleNum(new int[][] {{1,0,0},{0,1,0},{0,0,1}}));
	}

}
