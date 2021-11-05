import java.util.*;
/*
 * LeetCode 145 Easy
 * 
 * Binary Tree Postorder Traversal
 * 
Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Example 4:
Input: root = [1,2]
Output: [2,1]

Example 5:
Input: root = [1,null,2]
Output: [2,1]
 
Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversal {
	public static void main(String[] args) {
		System.out.println();
	}
	// recursive
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;
	}
	public void helper(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		helper(root.left, res);
		helper(root.right, res);
		res.add(root.val);
	}
	// follow up: iterative
	// stack
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			// root-right-left to left-right-root
			if (cur != null) {
				stack.push(cur);
				res.add(0, cur.val);
				cur = cur.right;
			}
			else {
				cur = stack.pop();
				cur = cur.left;
			}
		}
		return res;
	}
	// stack
	public List<Integer> preorderTraversal3(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		List<Integer> res = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			res.add(0, cur.val);
			if (cur.left != null)
				stack.push(cur.left);
			if (cur.right != null)
				stack.push(cur.right);
		}
		return res;
	}
}
