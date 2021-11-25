/*
 * LeetCode 53 Easy
 * 
 * Maximum Subarray
 * 
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
A subarray is a contiguous part of an array.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:
Input: nums = [1]
Output: 1

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
 
Constraints:
1 <= nums.length <= 10^5
-104 <= nums[i] <= 10^4
 
Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {
	public static void main(String args[]) {
		int[] num = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		MaximumSubarray test = new MaximumSubarray();
		System.out.println(test.maxSubArray(num));
		System.out.println(test.maxSubArray(new int[] {1}));
		System.out.println(test.maxSubArray(new int[] {5, 4, -1, 7, 8}));
		System.out.println(test.maxSubArray2(num));
		System.out.println(test.maxSubArray2(new int[] {1}));
		System.out.println(test.maxSubArray2(new int[] {5, 4, -1, 7, 8}));
		System.out.println(test.maxSubArray3(num));
		System.out.println(test.maxSubArray3(new int[] {1}));
		System.out.println(test.maxSubArray3(new int[] {5, 4, -1, 7, 8}));
	}
	// binary search & recursion
	public int maxSubArray(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}
	// post-order
	public int helper(int[] nums, int left, int right) {
		if (left >= right)
			return nums[left];
		int mid = left + (right - left) / 2;
		int mMax = nums[mid];
		int lMax = helper(nums, left, mid - 1);
		int rMax = helper(nums, mid + 1, right);
		int sum = mMax;
		for (int i = mid - 1; i >= left; i--) {
			sum += nums[i];
			mMax = Math.max(mMax, sum);
		}
		sum = mMax;
		for (int i = mid + 1; i <= right; i++) {
			sum += nums[i];
			mMax = Math.max(mMax, sum);
		}
		return Math.max(mMax, Math.max(lMax, rMax));
	}
 	// dp: space O(1)
	public int maxSubArray2(int[] nums) {
		int res = Integer.MIN_VALUE;
		int sum = 0;
		for (int i : nums) {
			sum = Math.max(sum + i, i);
			res = Math.max(res, sum);
		}
		return res;
	}
	// dp: space O(n)
	public int maxSubArray3(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		for (int i = 1; i < n; i++)
			dp[i] = Math.max(dp[i], dp[i - 1] + nums[i]);
		int res = Integer.MIN_VALUE;
		for (int d : dp)
			res = Math.max(res, d);
		return res;
	}
}
