import java.util.*;
public class BinaryTreeZigzagLevelOrderTraversal {
	public static void main(String[] args) {
		System.out.println();
	}
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		helper(root, 0, res);
		return res;
	}
	public void helper(TreeNode root, int level, List<List<Integer>> res) {
		if (root == null)
			return;
		if (res.size() == level)
			res.add(new ArrayList<>());
		
		if (level % 2 == 0)
			res.get(level).add(root.val);
		else
			res.get(level).add(0, root.val);
		
		if (root.left != null)
			helper(root.left, level + 1, res);
		if (root.right != null)
			helper(root.right, level + 1, res);		
	}
	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int cnt = 0;
		while (!queue.isEmpty()) {
			List<Integer> out = new ArrayList<>();
			for (int i = queue.size(); i > 0; i--) {
				TreeNode cur = queue.poll();
				if (cnt % 2 == 0)
					out.add(cur.val);
				else
					out.add(0, cur.val);
				if (cur.left != null)
					queue.offer(cur.left);
				if (cur.right != null)
					queue.offer(cur.right);
			}
			cnt++;
			res.add(out);
		}	
		return res;
	}

}
