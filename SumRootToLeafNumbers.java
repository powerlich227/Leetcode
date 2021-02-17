import java.util.*;

public class SumRootToLeafNumbers {
	public static void main(String[] args) {
		System.out.println();
	}
	public int sumNumbers(TreeNode root) {
		return helper(root, 0);
	}
	public int helper(TreeNode root, int res) {
		if (root == null)
			return 0;
		res = root.val + 10 * res;
		if (root.left == null && root.right == null)
			return res;
		return helper(root.left, res) + helper(root.right, res);
	}
}
