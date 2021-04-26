/*
 * LeetCode 538 Medium
 * 
 * Convert BST to Greater Tree
 * 
 * Note: This question is the same as 1038

 * Given the root of a Binary Search Tree (BST), 
convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

Constraints:

The number of nodes in the tree is in the range [0, 10^4].
-10^4 <= Node.val <= 10^4
All the values in the tree are unique.
root is guaranteed to be a valid binary search tree.
 
 */
public class GreaterSumTree {
	int sum = 0;
	public TreeNode convertBST(TreeNode root) {
		helper(root);
		return root;
	}
	public void helper(TreeNode root) {
		if (root == null)
			return;
		
		helper(root.right);
		sum += root.val;
		root.val = sum;
		helper(root.left);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
