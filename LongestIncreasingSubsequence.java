import java.util.Arrays;

/*
 * LeetCode 300
 * 
 * Longest Increasing Subsequence
 * 
Given an integer array nums, return the length of the longest strictly increasing subsequence.
A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. 
For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1

Constraints:
1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 
Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
public class LongestIncreasingSubsequence {
	// dp + binarySearch (follow-up)
	// return length of "non-zero" dp array
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int res = 0;
		for (int num : nums) {
			int i = Arrays.binarySearch(dp, 0, res, num); 
			if (i < 0) // i: the index of the first element in the range greater than "num", or "res" if all elements less than "num".
				i = -(i + 1); // return (-i - 1)
			dp[i] = num;
			if (i == res)
				res++;
		}
		return res;
	}
	
	// dp:
	// dp[i]: length of LIS end with nums[i];
	public int lengthOfLIS2(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		int res = 0;
		for (int d : dp)
			res = Math.max(res, d);
		return res;
	}
	public static void main(String[] args) {
		LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
		
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		int[] nums2 = {0, 1, 0, 3, 2, 3};
		int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
		System.out.println(test.lengthOfLIS(nums));
		System.out.println(test.lengthOfLIS(nums2));
		System.out.println(test.lengthOfLIS(nums3));
		System.out.println(test.lengthOfLIS2(nums));
		System.out.println(test.lengthOfLIS2(nums2));
		System.out.println(test.lengthOfLIS2(nums3));
	}
}
