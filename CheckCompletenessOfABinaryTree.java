import java.util.LinkedList;
import java.util.Queue;

/*
 * LeetCode 958 Medium
 * 
 * Check Completeness of a Binary Tree
 * 
Given the root of a binary tree, determine if it is a complete binary tree.

In a complete binary tree, every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. It can have between 1 and 2^h nodes inclusive at the last level h.

 
Example 1:
Input: root = [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.

Example 2:
Input: root = [1,2,3,4,5,null,7]
Output: false
Explanation: The node with value 7 isn't as far left as possible.
 

Constraints:
The number of nodes in the tree is in the range [1, 100].
1 <= Node.val <= 1000
 */
public class CheckCompletenessOfABinaryTree {
	// BFS 2 while loops
	public boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (q.peek() != null) {
			TreeNode cur = q.poll();
			q.offer(cur.left);
			q.offer(cur.right);
		}
		while (!q.isEmpty() && q.peek() == null) {
			q.poll();
		}
		return q.isEmpty();
	}
	// BFS 1 while loop
	// better
	public boolean isCompleteTree2(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		boolean found = false;
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			if (cur == null)
				found = true;
			else {
				if (found)
					return false;
				q.offer(cur.left);
				q.offer(cur.right);
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
