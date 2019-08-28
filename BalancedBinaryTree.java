
public class BalancedBinaryTree {
	public static void main(String[] args) {
		System.out.println();
	}
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		if (Math.abs(helper(root.left) - helper(root.right)) > 1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}
	public int helper(TreeNode root) {
		if (root == null)
			return 0;	
		return 1 + Math.max(helper(root.left), helper(root.right));
	}
	public boolean isBalanced2(TreeNode root) {
		if (helper2(root) == -1)
			return false;
		return true;
	}
	public int helper2(TreeNode root) {
		if (root == null) 
			return 0;
		int left = helper2(root.left);
		if (left == -1)
			return -1;
		int right = helper2(root.right);
		if (right == -1)
			return -1;
		int diff = Math.abs(left - right);
		if (diff > 1)
			return -1;
		return 1 + Math.max(left, right);
	}
}
