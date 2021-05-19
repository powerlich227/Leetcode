import java.util.Arrays;

/*
 * LeetCode 198 Medium
 * 
 * House Robber
 * 
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected 
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.

 
Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 400
 */
public class HouseRobber {
	/* 
	 * dp[i] = max(dp[i-2]+nums[i], dp[i-1])
	 */
	
	// iteration (bottom-up)
	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];
		
		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n; i++)
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		
		return dp[n - 1];
	}
	
	// recursion (top-down)
	int[] memo;
	public int rob2(int[] nums) {
		memo = new int[nums.length];
		Arrays.fill(memo, -1);
		return dp(nums, 0);
	}
	public int dp(int[] nums, int start) {
		if (start >= nums.length)
			return 0;
		if (memo[start] != -1)
			return memo[start];
		
		int res = Math.max(dp(nums, start + 1), dp(nums, start + 2) + nums[start]);
		memo[start] = res;
		return res;
	}
	public static void main(String[] args) {
		HouseRobber test = new HouseRobber();
		int[] nums = {1, 2, 3, 1}, nums2 = {2, 7, 9, 3, 1};
		System.out.println(test.rob(nums));
		System.out.println(test.rob(nums2));
		System.out.println(test.rob2(nums));
		System.out.println(test.rob2(nums2));
	}
}
