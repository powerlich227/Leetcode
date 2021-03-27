/*
 * Leetcode 230
 * 
 * Given the root of a binary search tree, and an integer k, 
 * 
 * return the kth (1-indexed) smallest element in the tree.
 */

import java.util.*;

public class KthSmallestElementInABST {
	
	/*
	 * Inorder traversal
	 * 
	 * Recursion
	 */
	public int kthSmallest(TreeNode root, int k) {
		List<Integer> nums = helper(root, new ArrayList<Integer>());
		return nums.get(k - 1);
	}
	public List<Integer> helper(TreeNode root, ArrayList<Integer> res) {
		if (root == null)
			return res;
		helper(root.left, res);
		res.add(root.val);
		helper(root.right, res);
		return res;
	}
	/*
	 * Iteration
	 */
	public int kthSmallest2(TreeNode root, int k) {
		if (root == null)
			return 0;
		
		Stack<TreeNode> stack = new Stack<>();
		while (true) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}
			root = stack.pop();
			if (--k == 0)
				return root.val;
			root = root.right;
		}
	}
}
