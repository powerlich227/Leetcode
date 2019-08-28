
public class ConvertSortedArrayToBinarySearchTree {
	public static void main(String[] args) {
		System.out.println();
	}
	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}
	public TreeNode helper(int[] nums, int left, int right) {
		if (left > right)
			return null;
		int mid = left + (right - left) / 2;
		TreeNode cur = new TreeNode(nums[mid]);
		cur.left = helper(nums, left, mid - 1);
		cur.right = helper(nums, mid + 1, right);
		return cur;
	}
}
