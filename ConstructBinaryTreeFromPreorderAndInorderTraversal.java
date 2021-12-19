/*
 * LeetCode 105 Medium
 * 
 * Construct Binary Tree from Preorder and Inorder Traversal
 * 
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal 
of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
 
Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public static void main(String[] args) {
		System.out.println();
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int m = preorder.length, n = inorder.length;
		return helper(preorder, 0, m, inorder, 0, n);
	}
	// build binary tree
	public TreeNode helper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
		if (preLeft > preRight || inLeft > inRight)
			return null;
		int rootVal = preorder[preLeft];
		int idx = 0;
		for (int i = inLeft; i <= inRight; i++) {
			if (inorder[i] == rootVal) {
				idx = i;
				break;
			}
		}
		TreeNode root = new TreeNode(rootVal);
		root.left = helper(preorder, preLeft + 1, preLeft + idx - inLeft, inorder, inLeft, idx - 1);
		root.right = helper(preorder, preLeft + idx - inLeft + 1, preRight, inorder, idx + 1, inRight);
		return root;
	}
}
