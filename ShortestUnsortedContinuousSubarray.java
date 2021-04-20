/*
 * LeetCode 581 Medium
 * 
 * Shortest Unsorted Continuous Subarray
 * 
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

Example 1:
Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

Example 2:
Input: nums = [1,2,3,4]
Output: 0

Example 3:
Input: nums = [1]
Output: 0
 
Constraints:

1 <= nums.length <= 10^4
-10^5 <= nums[i] <= 10^5
 

Follow up: Can you solve it in O(n) time complexity?

 */
public class ShortestUnsortedContinuousSubarray {
	public static int findUnsortedSubarray(int[] nums) {
		int n = nums.length, l = n - 1, r = 0;
		int min = nums[n - 1], max = nums[0];
		for (int i = 1; i < n; i++) {
			min = Math.min(min, nums[n - 1 - i]);
			max = Math.max(max, nums[i]);
			if (min < nums[n - 1 - i])
				l = n - 1 - i;
			if (max > nums[i])
				r = i;
		}
		return r - l <= 0 ? 0 : r - l + 1;
	}
	public static void main(String[] args) {
		int[] nums = {2, 6, 4, 8, 10, 9, 15}, nums2 = {1, 2, 3, 4}, nums3 = {1};
		System.out.println(findUnsortedSubarray(nums));
		System.out.println(findUnsortedSubarray(nums2));
		System.out.println(findUnsortedSubarray(nums3));
	}

}
