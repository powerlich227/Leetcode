import java.util.*;

public class PathSum {
	public static void main(String[] args) {
		System.out.println();
	}
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.val == sum)
			return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	public boolean hasPathSum2(TreeNode root, int sum) {
		if (root == null)
			return false;
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		while (!st.isEmpty()) {
			TreeNode t = st.pop();
			if (t.left == null && t.right == null && t.val == sum)
				return true;
			if (t.left != null) {
				t.left.val += t.val;
				st.push(t.left);
			}
			if (t.right != null) {
				t.right.val += t.val;
				st.push(t.right);
			}
		}
		return false;
	}
}
