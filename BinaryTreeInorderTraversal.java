import java.util.*;

public class BinaryTreeInorderTraversal {
	public static void main(String[] args) {
		System.out.println();
	}
	// recursive
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;
	}
	public void helper(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		if (root.left != null)
			helper(root.left, res);
		res.add(root.val);
		if (root.right != null)
			helper(root.right, res);
	}
	// iterative
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			// left-root-right
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			else {
				cur = stack.pop();
				res.add(cur.val);
				cur = cur.right;
			}
		}
		return res;
	}

}
