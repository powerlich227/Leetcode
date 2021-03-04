
public class DiameterOfBinaryTree {
	public static void main(String[] args) {
		System.out.println();
	}
	// diameter is the length of the longest path between any two nodes;
	// DFS
	int res;
	public int diameterOfBinaryTree(TreeNode root) {
		res = 0;
		helper(root);
		return res;
	}
	public int helper(TreeNode root) {
		if (root == null )
			return 0;
		int l = helper(root.left);
		int r = helper(root.right);
		res = Math.max(res, l + r + 1);
		return Math.max(l, r) + 1;
	}

}
