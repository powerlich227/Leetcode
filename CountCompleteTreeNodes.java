/*
 * LeetCode 222 Medium
 * 
 * Count Complete Tree Nodes
 * 
Given the root of a complete binary tree, return the number of the nodes in the tree.
According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, 
and all nodes in the last level are as far left as possible. It can have between 1 and 2^h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

 
Example 1:
Input: root = [1,2,3,4,5,6]
Output: 6

Example 2:
Input: root = []
Output: 0

Example 3:
Input: root = [1]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [0, 5 * 10^4].
0 <= Node.val <= 5 * 10^4
The tree is guaranteed to be complete.
 */
public class CountCompleteTreeNodes {
	// Recursion/DFS
//	public int countNodes(TreeNode root) {
//		return (root == null) ? 0 : (1 + countNodes(root.left) + countNodes(root.right));
//	}
	// Recursion2/DFS O(logn*logn)
	public int countNodes(TreeNode root) {
		int left = leftHeight(root.left);
		int right = rightHeight(root.right);
		if (left == right)
			return (int) (Math.pow(2, left) - 1);
		return countNodes(root.left) + countNodes(root.right) + 1;
	}
	public int leftHeight(TreeNode root) {
		if (root == null)
			return 0;
		return leftHeight(root.left) + 1;
	}
	public int rightHeight(TreeNode root) {
		if (root == null)
			return 0;
		return rightHeight(root.right) + 1;
	}
	// Binary Search O(logn)
	// left child vs right child
	public int countNodes2(TreeNode root) {
		int res = 0;
		int height = getHeight(root); 
		if (height < 0)
			return 0;
		while (root != null) {
			// left child is complete tree 
			if (height == getHeight(root.right) + 1) {
				res += Math.pow(2, height); // root + left = 1 + 2^h - 1 
				root = root.right;
			}
			// right child is complete tree
			else {
				res += Math.pow(2, height - 1); // root + right = 1 + 2^(h-1) - 1
				root = root.left;
			}
			height--;
		}
		return res;
	}
	// max height from left 
	public int getHeight(TreeNode root) {
		return (root == null) ? -1 : getHeight(root.left) + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
