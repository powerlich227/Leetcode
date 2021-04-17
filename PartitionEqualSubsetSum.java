/*
 * LeetCode 416 Medium
 * 
 * Partition Equal Subset Sum
 * 
 * Given a non-empty array nums containing only positive integers, 
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * 
Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 * 
 * dp[i] = dp[i] || dp[i - num[j]] (num[j] < i < sum)
 */
public class PartitionEqualSubsetSum {
	public static boolean canPartition(int[] nums) {
		if (nums.length == 1)
			return false;
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (sum % 2 != 0)
			return false;
		sum /= 2;
		boolean[] dp = new boolean[sum + 1];
		
		dp[0] = true;		
		for (int num : nums) {
			for (int i = sum; i >= num; i--) {
				dp[i] = dp[i] || dp[i - num];
			}
		}		
		return dp[sum];
	}
	public static void main(String[] args) {
		int[] nums = {1, 5, 11, 5}, nums2 = {1, 2, 3, 5}, nums3 = {1, 2, 5};
		System.out.println(canPartition(nums));
		System.out.println(canPartition(nums2));
		System.out.println(canPartition(nums3));
	}
}
