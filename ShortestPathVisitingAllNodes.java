import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * LeetCode 847 Hard
 * 
 * Shortest Path Visiting All Nodes
 * 
You have an undirected, connected graph of n nodes labeled from 0 to n - 1. 
You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.

Return the length of the shortest path that visits every node. 
You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.

Example 1:
Input: graph = [[1,2,3],[0],[0],[0]]
Output: 4
Explanation: One possible path is [1,0,2,0,3]

Example 2:
Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
Output: 4
Explanation: One possible path is [0,1,4,2,3]
 

Constraints:
n == graph.length
1 <= n <= 12
0 <= graph[i].length < n
graph[i] does not contain i.
If graph[a] contains b, then graph[b] contains a.
The input graph is always connected.
 */
public class ShortestPathVisitingAllNodes {
	// BFS with queue
	// Bit Manipulation: end mask = (1 << n) - 1
	public int shortestPathLength(int[][] graph) {
		if (graph.length == 1)
			return 0;
		int n = graph.length;
		int mask = (1 << n) - 1;
		boolean[][] visited = new boolean[n][mask + 1];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			visited[i][1 << i] = true;
			q.offer(new int[] {i, 1 << i});
		}
		int res = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				int cur_node = cur[0], cur_mask = cur[1];
				if (cur_mask == mask)
					return res;
				for (int neighbor : graph[cur_node]) {
					int next_mask = cur_mask | (1 << neighbor);
//					if (next_mask == mask)
//						return res + 1;
					if (!visited[neighbor][next_mask]) {
						visited[neighbor][next_mask] = true;
						q.offer(new int[] {neighbor, next_mask});
					}
				}
			}
			res++;
		}
		return -1;
	}
	public static void main(String[] args) {
		ShortestPathVisitingAllNodes test = new ShortestPathVisitingAllNodes();
		System.out.println(test.shortestPathLength(new int[][] {{1,2,3},{0},{0},{0}}));
		System.out.println(test.shortestPathLength(new int[][] {{1},{0,2,4},{1,3,4},{2},{1,2}}));
	}
}
