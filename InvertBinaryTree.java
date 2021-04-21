import java.util.*;
/*
 * LeetCode 226 Easy
 * 
 * Invert Binary Tree
 * 
 * Given the root of a binary tree, invert the tree, and return its root.
 * 

Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Input: root = [2,1,3]
Output: [2,3,1]

Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */
public class InvertBinaryTree {
	public static void main(String[] args) {
		System.out.println();
	}
	// Recursion
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		invertTree(root.left);
		invertTree(root.right);
//      TreeNode temp = invertTree(root.left);
//		root.left = invertTree(root.right);
//		root.right = temp;
		
		return root;
	}
	// Iteration with Queue
	public TreeNode invertTree2(TreeNode root) {
		if (root == null)
			return null;
		Queue<TreeNode> q = new LinkedList<> (); 
		q.offer(root);
		
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			
			if (node.left != null)
				q.offer(node.left);
			if (node.right != null)
				q.offer(node.right);
		}
		return root;
	}

}
