import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public static void main(String args[]) {
		System.out.println();
	}
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null)
			return res;
		if (root.left == null && root.right == null) {
			res.add(Integer.toString(root.val));
			return res;
		}
		for (String str : binaryTreePaths(root.left))
			res.add(Integer.toString(root.val) + "->" + str);
		for (String str : binaryTreePaths(root.right))
			res.add(Integer.toString(root.val) + "->" + str);
		return res;
	}

}
