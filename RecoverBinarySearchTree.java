import java.util.*;

public class RecoverBinarySearchTree {
	public static void main(String[] args) {
		System.out.println(2+123);
	}
	public void recoverTree(TreeNode root) {
		List<TreeNode> node = new ArrayList<>();
		List<Integer> val = new ArrayList<>();

		helper(root, node, val);
		Collections.sort(val);
		TreeNode[] treenode = new TreeNode[node.size()];
		for (int i = 0; i < node.size(); i++) {
			treenode[i] = node.get(i);
			treenode[i].val = val.get(i);
		}
	}
	public void helper(TreeNode root, List<TreeNode> node, List<Integer> val) {
		if (root == null)
			return;
		helper(root.left, node, val);
		node.add(root);
		val.add(root.val);
		helper(root.right, node, val);
	}

}
