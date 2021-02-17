import java.util.*;

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
			for (int i = q.size(); i > 0; i--) {
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
	// recursive
	public List<List<Integer>> levelOrderBottom2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		helper(root, 0, res);
		Collections.reverse(res);
		return res;
	}
	public void helper(TreeNode root, int level, List<List<Integer>> res) {
		if (root == null) 
			return;
		if (res.size() == level)
			res.add(new ArrayList<>());
		res.get(level).add(root.val);
		if (root.left != null)
			helper(root.left, level + 1, res);
		if (root.right != null)
			helper(root.right, level + 1, res);
	}
}
