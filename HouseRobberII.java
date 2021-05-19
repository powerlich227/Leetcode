/*
 * LeetCode 213 Medium
 * 
 * House Robber II
 * 
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. 
All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 
Example 1:
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

Example 2:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 3:
Input: nums = [0]
Output: 0

 
Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 1000
 */
public class HouseRobberII {

	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];
		return Math.max(robRange(nums, 0, n - 1), robRange(nums, 1, n));
	}
	// dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])
	public int robRange(int[] nums, int start, int end) {
		int n = nums.length;
		int dp_i_2 = 0, dp_i_1 = 0, dp_i = 0;
		
		for (int i = start; i < end; i++) {
			dp_i = Math.max(dp_i_2 + nums[i], dp_i_1);
			dp_i_2 = dp_i_1;
			dp_i_1 = dp_i;
		}
		return dp_i;
	}
	public static void main(String[] args) {
		int[] nums = {2, 3, 2}, nums2 = {1, 2, 3, 1}, nums3 = {0};
		HouseRobberII test = new HouseRobberII();
		System.out.println(test.rob(nums));
		System.out.println(test.rob(nums2));
		System.out.println(test.rob(nums3));
	}
}
