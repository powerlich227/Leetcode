
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}
	public TreeNode helper(int[] inorder, int iLeft, int iRight, int[] postorder, int pLeft, int pRight) {
		if (iLeft > iRight || pLeft > pRight)
			return null;
		TreeNode root = new TreeNode(postorder[pRight]);
		int i = 0;
		for (i = iLeft; i < inorder.length; i++) {
			if (inorder[i] == root.val)
				break;
		}
		root.left = helper(inorder, iLeft, i - 1, postorder, pLeft, pLeft + i - iLeft - 1);
		root.right = helper(inorder, i + 1, iRight, postorder, pLeft + i - iLeft, pRight - 1);
		return root;
	}
}
