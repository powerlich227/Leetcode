/*
 * 
 */
public class HouseRobberIII {
	public int rob(TreeNode root) {
		int[] res = helper(root);
		return Math.max(res[0], res[1]);
	}
	public int[] helper(TreeNode root) {
		if (root == null)
			return new int[2];
		int[] res = new int[2];
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		res[0] = left[1] + right[1] + root.val; // root
		res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
