import java.util.*;
/*
 * LeetCode 112 Easy
 * 
 * Path Sum
 * 
Given the root of a binary tree and an integer targetSum, 
return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.


Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true

Example 2:
Input: root = [1,2,3], targetSum = 5
Output: false

Example 3:
Input: root = [1,2], targetSum = 0
Output: false
 
Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */
public class PathSum {
	public static void main(String[] args) {
		System.out.println();
	}
	// DFS: recursion
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.val == sum)
			return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	// DFS; iteration with stack
	public boolean hasPathSum2(TreeNode root, int sum) {
		if (root == null)
			return false;
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		while (!st.isEmpty()) {
			TreeNode t = st.pop();
			if (t.left == null && t.right == null && t.val == sum)
				return true;
			if (t.left != null) {
				t.left.val += t.val;
				st.push(t.left);
			}
			if (t.right != null) {
				t.right.val += t.val;
				st.push(t.right);
			}
		}
		return false;
	}
}
