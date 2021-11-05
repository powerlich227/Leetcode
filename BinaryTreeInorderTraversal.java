import java.util.*;
/*
 * LeetCode 94 Easy
 * 
 * Binary Tree Inorder Traversal
 * 
Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

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
Output: [1,2]
 

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 
Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
	public static void main(String[] args) {
		System.out.println();
	}
	// recursive
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;
	}
	public void helper(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		helper(root.left, res);
		res.add(root.val);
		helper(root.right, res);
	}
	// follow up: iterative
	// stack
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !st.isEmpty()) {
			if (cur != null) {
				st.push(cur);
				cur = cur.left;
			}
			else {
				cur = st.pop(); 
				res.add(cur.val); // left-root-right
				cur = cur.right;
			}
		}
		return res;
	}
}
