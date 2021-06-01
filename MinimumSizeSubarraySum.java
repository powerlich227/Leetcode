/*
 * LeetCode 209 Medium
 * 
 * Minimum Size Subarray Sum
 * 
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray 
[numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 
Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
 

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */
public class MinimumSizeSubarraySum {
	// 2 pointers
	public int minSubArrayLen(int target, int[] nums) {
		int l = 0, r = 0, n = nums.length;
		int sum = 0, res = Integer.MAX_VALUE;
		while (r < n) {
			while (r < n && sum < target) {
				sum += nums[r++];
			}
			while (l < n && sum >= target) {
				res = Math.min(res, r - l);
				sum -= nums[l++];
			}
		}
		return (res == Integer.MAX_VALUE) ? 0 : res;
	}
	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 2, 4, 3}, nums2 = {1, 4, 4}, nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
		MinimumSizeSubarraySum test = new MinimumSizeSubarraySum();
		System.out.println(test.minSubArrayLen(7, nums));
		System.out.println(test.minSubArrayLen(4, nums2));
		System.out.println(test.minSubArrayLen(11, nums3));
	}
}
