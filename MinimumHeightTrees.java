import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * LeetCode 310 Medium
 * 
 * Minimum Height Trees
 * 
A tree is an undirected graph in which any two vertices are connected by exactly one path. 
In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] 
indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. 
When you select a node x as the root, the result tree has height h. 
Among all possible rooted trees, those with minimum height (i.e. min(h)) are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.

Example 1:
Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.

Example 2:
Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]

Example 3:
Input: n = 1, edges = []
Output: [0]

Example 4:
Input: n = 2, edges = [[0,1]]
Output: [0,1]
 
Constraints:

1 <= n <= 2 * 10^4
edges.length == n - 1
0 <= ai, bi < n
ai != bi
All the pairs (ai, bi) are distinct.
The given input is guaranteed to be a tree and there will be no repeated edges.
 */
public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1)
			return new ArrayList<>(Arrays.asList(0));
		List<Integer> res = new ArrayList<>();
		List<Set<Integer>> adjacent = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjacent.add(new HashSet<>());
		for (int[] edge : edges) {
			adjacent.get(edge[0]).add(edge[1]);
			adjacent.get(edge[1]).add(edge[0]);
		}
		for (int i = 0; i < n; i++) {
			if (adjacent.get(i).size() == 1)
				res.add(i);
		}
		while (n > 2) {
			n -= res.size();
			List<Integer> temp = new ArrayList<>();
			for (int i : res) {
				int t = adjacent.get(i).iterator().next();
				adjacent.get(t).remove(i);
				if (adjacent.get(t).size() == 1)
					temp.add(t);
			}
			res = temp;
		}
		return res;
	}
	public static void main(String[] args) {
		MinimumHeightTrees test = new MinimumHeightTrees();
		System.out.println(test.findMinHeightTrees(1, new int[][] {{}}));
	}
}
