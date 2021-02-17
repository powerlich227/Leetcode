import java.util.*;

public class InvertBinaryTree {
	public static void main(String[] args) {
		System.out.println();
	}
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		
        TreeNode temp = invertTree(root.left);
		root.left = invertTree(root.right);
		root.right = temp;
		
		return root;
	}
	public TreeNode invertTree2(TreeNode root) {
		if (root == null)
			return null;
		Queue<TreeNode> q = new LinkedList<> (); 
		q.offer(root);
		
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			
			if (node.left != null)
				q.offer(node.left);
			if (node.right != null)
				q.offer(node.right);
		}
		return root;
	}

}
