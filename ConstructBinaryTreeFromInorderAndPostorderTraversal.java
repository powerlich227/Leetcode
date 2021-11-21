/*
 * LeetCode 106 Medium
 * 
 * Construct Binary Tree from Inorder and Postorder Traversal
 * 
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, 
construct and return the binary tree.

Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]
 
Constraints:
1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	// DFS
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int m = inorder.length, n = postorder.length;
		return helper(inorder, 0, m - 1, postorder, 0, n - 1);
	}
	// postorder: last treenode is root, inorder: root among the treenodes,
	// left tree: inorder:[ileft, idx - 1], postorder:[pleft, pleft+idx-1-ileft]
	// right tree: inorder:[idx + 1, iright], postorder:[pleft+idx-ileft, pright]
	public TreeNode helper(int[] inorder, int iLeft, int iRight, int[] postorder, int pLeft, int pRight) {
		if (iLeft > iRight || pLeft > pRight)
			return null;
		TreeNode root = new TreeNode(postorder[pRight]);
		int idx = 0;
		for (int i = iLeft; i < inorder.length; i++) {
			if (inorder[i] == root.val) {
				idx = i;
				break;
			}
		}
		root.left = helper(inorder, iLeft, idx - 1, postorder, pLeft, pLeft + idx - iLeft - 1);
		root.right = helper(inorder, idx + 1, iRight, postorder, pLeft + idx - iLeft, pRight - 1);
		return root;
	}
}
