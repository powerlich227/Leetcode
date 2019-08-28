import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
	public static void main(String[] args) {
		System.out.println();
	}
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			List<Integer> cur = new ArrayList<>();
			for(int i = q.size(); i > 0; i--) {
				TreeNode t = q.poll();
				cur.add(t.val);
				if (t.left != null)
					q.offer(t.left);
				if (t.right != null)
					q.offer(t.right);
			}
			res.add(0, cur);
		}
		return res;		
	}
	public List<List<Integer>> levelOrderBottom2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		return res;
	}
}
