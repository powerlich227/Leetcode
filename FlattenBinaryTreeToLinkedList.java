import java.util.*;

public class FlattenBinaryTreeToLinkedList {
	public static void main(String[] args) {
		System.out.println();
	}
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		if (root.left != null)
			flatten(root.left);
		if (root.right != null)
			flatten(root.right);
		TreeNode temp = root.right;
		root.right = root.left;
		root.left = null;
		while (root.right != null) {
			root = root.right;
		}
		root.right = temp;
	}
	// iterative
	public void flatten2(TreeNode root) {
		if (root == null)
			return;
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left != null) {
				TreeNode temp = cur.left;
				while (temp.right != null)
					temp = temp.right;
				temp.right = cur.right;
				cur.right = cur.left;
				cur.left = null;
			}
			cur = cur.right;
		}
		
	}
	// pre-order stack
	public void flatten3(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			if (cur.left != null) {
				TreeNode temp = cur.left;
				while (temp.right != null)
					temp = temp.right;
				temp.right = cur.right;
				cur.right = cur.left;
				cur.left = null;
			}
			if (cur.right != null)
				stack.push(cur.right);
		}
	}

}
