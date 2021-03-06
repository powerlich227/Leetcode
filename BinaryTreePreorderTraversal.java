import java.util.*;
public class BinaryTreePreorderTraversal {
	public static void main(String[] args) {
		System.out.println();
	}
	// recursive
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;
	}
	public void helper(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		res.add(root.val);
		if (root.left != null)
			helper(root.left, res);
		if (root.right != null)
			helper(root.right, res);
	}
	//iterative
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			// root-left-right
			if (cur != null) {
				stack.push(cur);
				res.add(cur.val);
				cur = cur.left;
			}
			else {
				cur = stack.pop();
				cur = cur.right;
			}
		}
		return res;
	}
	public List<Integer> preorderTraversal3(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			res.add(cur.val);
			if (cur.right != null)
				stack.push(cur.right);
			if (cur.left != null)
				stack.push(cur.left);
		}
		return res;
	}

}
