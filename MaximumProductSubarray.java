/*
 * LeetCode 152 Medium
 * 
 * Maximum Product Subarray
 * 
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
It is guaranteed that the answer will fit in a 32-bit integer.
A subarray is a contiguous subsequence of the array.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 
Constraints:
1 <= nums.length <= 2 * 10^4
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class MaximumProductSubarray {
	public static void main(String[] args) {
		MaximumProductSubarray test = new MaximumProductSubarray();
		System.out.println(test.maxProduct(new int[] {2, 3, -2, 4}));
		System.out.println(test.maxProduct(new int[] {-2, 0, -1}));
	}
	
	/* DP: min & max
	 * swap(min, max) only if nums[i] < 0
	 * max = max(max*nums[i], nums[i])
	 * min = min(min*nums[i], nums[i])
	 */
	public int maxProduct(int[] nums) {
		if (nums.length == 0)
			return 0;
		int res = nums[0], min = nums[0], max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < 0) { // swap(max, min)
				int temp = max;
				max = min;
				min = temp;
			}
			max = Math.max(nums[i], max * nums[i]);
			min = Math.min(nums[i], min * nums[i]);
			res = Math.max(res, max);
		}
		return res;
	}
}
