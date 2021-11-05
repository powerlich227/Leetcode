import java.util.*;

/*
 * LeetCode 144 Easy
 * 
 * Binary Tree Preorder Traversal
 * 
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Example 4:
Input: root = [1,2]
Output: [1,2]

Example 5:
Input: root = [1,null,2]
Output: [1,2]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
	public static void main(String[] args) {
		System.out.println();
	}
	// recursive
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;
	}
	public void helper(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		res.add(root.val);
		helper(root.left, res);
		helper(root.right, res);
	}
	// follow-up: iterative
	// stack
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			// root-left-right
			if (cur != null) {
				stack.push(cur);
				res.add(cur.val);
				cur = cur.left;
			}
			else {
				cur = stack.pop();
				cur = cur.right;
			}
		}
		return res;
	}
	public List<Integer> preorderTraversal3(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			res.add(cur.val);
			if (cur.right != null)
				stack.push(cur.right);
			if (cur.left != null)
				stack.push(cur.left);
		}
		return res;
	}

}
