/*
 * LeetCode 494 Medium
 * 
 * Target Sum
 * 
 * You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

Example 1:
Input: nums = [1,1,1,1,1], target = 3
Output: 5

Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

Example 2:
Input: nums = [1], target = 1
Output: 1

Constraints:
1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 1000
 */
public class TargetSum {
	public static int findTargetSumWays(int[] nums, int target) {
		int n = nums.length;
		int[] dp = new int[2001]; //0 <= sum(nums[i]) <= 1000
		dp[1000 + nums[0]] += 1;
		dp[1000 - nums[0]] += 1;
		for (int i = 1; i < n; i++) {
			int[] temp = new int[2001];
			for (int j = -1000; j <= 1000; j++) {
				if (dp[j + 1000] > 0) {
					temp[j + 1000 + nums[i]] += dp[j + 1000];
					temp[j + 1000 - nums[i]] += dp[j + 1000];
				}
			}
			dp = temp;
		}
		return dp[1000 + target];
	}
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(findTargetSumWays(nums, target));
	}
}
