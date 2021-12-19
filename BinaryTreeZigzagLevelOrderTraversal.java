import java.util.*;

/*
 * LeetCode 103 Medium
 * 
 * Binary Tree Zigzag Level Order Traversal
 * 
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. 
(i.e., from left to right, then right to left for the next level and alternate between).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public static void main(String[] args) {
		System.out.println();
	}
	// recursion
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		helper(root, 0, res);
		return res;
	}
	// Recursion/DFS
	public void helper(TreeNode root, int level, List<List<Integer>> res) {
		if (root == null)
			return;
		if (res.size() == level)
			res.add(new ArrayList<>());
		
		if (level % 2 == 0)
			res.get(level).add(root.val);
		else
			res.get(level).add(0, root.val);
		
		helper(root.left, level + 1, res);
		helper(root.right, level + 1, res);		
	}
	// BFS: queue
	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {			
		List<List<Integer>> res = new LinkedList<>();
		if (root == null)
			return res;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		Boolean flag = true;
		
		while (!q.isEmpty()) {
			LinkedList<Integer> out = new LinkedList<>();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				if (flag)
					out.add(cur.val);
				else
					out.addFirst(cur.val);
				if (cur.left != null)
					q.offer(cur.left);
				if (cur.right != null)
					q.offer(cur.right);
			}
			flag = !flag;
			res.add(out);
		}
		return res;
	}
}
