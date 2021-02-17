import java.util.*;

public class PathSumII {
	public static void main(String[] args) {
		System.out.println();
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		helper(root, sum, path, res);
		return res;
	}
	public void helper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
		if (root == null)
			return;
		path.add(root.val);
        List<Integer> out = new ArrayList<>(path);
		if (root.left == null && root.right == null && root.val == sum)
			res.add(out);
		helper(root.left, sum - root.val, path, res);
		helper(root.right, sum - root.val, path, res);
		path.remove(path.size() - 1);
	}
}