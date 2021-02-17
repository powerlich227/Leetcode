

public class BinaryTreeMaximumPathSum {
	int res = Integer.MIN_VALUE; // store the global max path sum
	public static void main(String[] args) {
		System.out.println();
	}
	public int maxPathSum(TreeNode root) {
		helper(root);
		return res;
	}
	public int helper(TreeNode root) {
		if (root == null)
			return 0;
		int left = Math.max(helper(root.left), 0);
		int right = Math.max(helper(root.right), 0);
		res = Math.max(left + root.val + right, res);
		return Math.max(left + root.val, right + root.val);
	}

}
