
public class ContructBinaryTreeFromInorderAndPostorderTraversal {
	public static void main(String[] args) {
		System.out.println();
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int m = inorder.length, n = postorder.length;
		return helper(inorder, postorder, 0, m - 1, 0, n - 1);
	}
	public TreeNode helper(int[] inorder, int[] postorder, int inleft, int inright, int postleft, int postright) {
		if (inleft > inright || postleft > postright)
			return null;
		TreeNode cur = new TreeNode(postorder[postright]);
		int i = 0;
		for (i = inleft; i <= inright; i++) {
			if (inorder[i] == cur.val)
				break;
		}
		cur.left = helper(inorder, postorder, inleft, i - 1, postleft, postleft + i - inleft - 1);
		cur.right = helper(inorder, postorder, i + 1, inright, postleft + i - inleft, postright - 1);
		return cur;
	}
}
