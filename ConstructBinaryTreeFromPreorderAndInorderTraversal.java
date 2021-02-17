
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public static void main(String[] args) {
		System.out.println();
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int m = preorder.length, n = inorder.length;
		return helper(preorder, inorder, 0, m - 1, 0, n - 1);
	}
	public TreeNode helper(int[] preorder, int[] inorder, int preleft, int preright, int inleft, int inright) {
		if (preleft > preright || inleft > inright)
			return null;
		
		TreeNode cur = new TreeNode(preorder[preleft]);
		int i = 0;
		for (i = inleft; i <= inright; i++) {
			if (inorder[i] == cur.val)
				break;
		}
		cur.left = helper(preorder, inorder, preleft + 1, preleft + i - inleft, inleft, i - 1);
		cur.right = helper(preorder, inorder, preleft + i - inleft + 1, preright, i + 1, inright);
		return cur;
	}
}
