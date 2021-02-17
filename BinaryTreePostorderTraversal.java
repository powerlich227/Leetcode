import java.util.*;
public class BinaryTreePostorderTraversal {
	public static void main(String[] args) {
		System.out.println();
	}
	//recursive
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;
	}
	public void helper(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		if (root.left != null)
			helper(root.left, res);
		if (root.right != null)
			helper(root.right, res);
		res.add(root.val);
	}
	//iterative
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			// root-right-left to left-right-root
			if (cur != null) {
				stack.push(cur);
				res.add(0, cur.val);
				cur = cur.right;
			}
			else {
				cur = stack.pop();
				cur = cur.left;
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
