/*
 * LeetCode 654 Medium
 * 
 * Maximum Binary Tree
 * 
 * You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:

Create a root node whose value is the maximum value in nums.
Recursively build the left subtree on the subarray prefix to the left of the maximum value.
Recursively build the right subtree on the subarray suffix to the right of the maximum value.
Return the maximum binary tree built from nums.

Example 1:
Input: nums = [3,2,1,6,0,5]
Output: [6,3,5,null,2,0,null,null,1]

Example 2:
Input: nums = [3,2,1]
Output: [3,null,2,null,1]

Constraints:
1 <= nums.length <= 1000
0 <= nums[i] <= 1000
All integers in nums are unique.
 */
public class MaximumBinaryTree {
	// recursion
	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}
	public static TreeNode helper(int[] nums, int l, int r) {
		if (l > r)
			return null;
		
		int idx = 0, max = Integer.MIN_VALUE;
		for (int i = l; i <= r; i++) {
			if (nums[i] > max) {
				max = nums[i];
				idx = i;
			}
		}
		
		TreeNode root = new TreeNode(max);
		root.left = helper(nums, l, idx - 1);
		root.right = helper(nums, idx + 1, r);
		
		return root;
	}
	public static void main(String[] args) {
		int[] nums = {3, 2, 1, 6, 0, 5};
		System.out.println(constructMaximumBinaryTree(nums));
	}

}
