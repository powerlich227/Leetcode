/*
 * LeetCode 98 Medium
 * 
 * Validate Binary Search Tree
 * 
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * 
Example 1:
Input: root = [2,1,3]
Output: true

Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

Constraints:
The number of nodes in the tree is in the range [1, 104].
-2^31 <= Node.val <= 2^31 - 1
 */
public class ValidBinarySearchTree {
	public static void main(String[] args) {
		System.out.println();
	}
	public boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}
	public boolean helper(TreeNode root, TreeNode min, TreeNode max) {
		if (root == null)
			return true;
		if (min != null && root.val <= min.val)
			return false;
		if (max != null && root.val >= max.val)
			return false;
		return helper(root.left, min, root) && helper(root.right, root, max);
	}
}
