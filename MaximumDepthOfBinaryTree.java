import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
	public static void main(String[] args) {
		System.out.println();
	}
	//Recursion
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	//Traverse
	public int maxDepth2(TreeNode root) {
		int res = 0;
		if (root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			res++;
			for (int i = q.size(); i > 0; i--) {
				TreeNode t = q.poll();
				if (t.left != null)
					q.offer(t.left);
				if (t.right != null)
					q.offer(t.right);
			}	
		}
		return res;
	}
}
