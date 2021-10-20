/*
 * LeetCode 993 Easy
 * 
 * Cousins in Binary Tree
 * 
Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, 
return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.


Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 
Constraints:

The number of nodes in the tree is in the range [2, 100].
1 <= Node.val <= 100
Each node has a unique value.
x != y
x and y are exist in the tree.
 */
public class CousinsInBinaryTree {
	// DFS
	public boolean isCousins(TreeNode root, int x, int y) {
		int depthX = 0, depthY = 0;
		boolean sameParent = false;
		helper(root, x, y, 0, depthX, depthY, sameParent);
		return depthX == depthY && !sameParent;
	}
	public void helper(TreeNode root, int x, int y, int level, int depthX, int depthY, boolean sameParent) {
		if (root == null)
			return;
		if (root.val == x)
			depthX = level;
		if (root.val == y)
			depthY = level;
		if (root.left != null && root.right != null) {
			int left = root.left.val, right = root.right.val;
			if ((left == x && right == y) || (left == y && right == x))
				sameParent = true;
		}
		helper(root.left, x, y, level + 1, depthX, depthY, sameParent);
		helper(root.right, x, y, level + 1, depthX, depthY, sameParent);
	}
}
