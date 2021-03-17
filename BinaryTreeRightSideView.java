import java.util.*;
public class BinaryTreeRightSideView {
	public static void main(String[] args) {
		System.out.println();
	}
	
	/*
	 * Q102 Binary Tree Level Order Traversal
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			for (int i = q.size(); i > 0; i--) {
				TreeNode cur = q.poll();
				if (i == 1) 
					res.add(cur.val);
				if (cur.left != null)
					q.offer(cur.left);
				if (cur.right != null)
					q.offer(cur.right);
			}
		}
		return res;
	}
}
