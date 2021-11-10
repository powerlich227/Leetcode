/*
 * LeetCode 162 Medium
 * 
 * Find Peak Element
 * 
A peak element is an element that is strictly greater than its neighbors.
Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that nums[-1] = nums[n] = -∞.
You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 
Constraints:
1 <= nums.length <= 1000
-2^31 <= nums[i] <= 2^31 - 1
"nums[i] != nums[i + 1] for all valid i."
 */
public class FindPeakElement {
	// O(logn)
	// Binary Search: [left, right)
	// break: left==right
	public int findPeakElement(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[mid + 1])
				left = mid + 1;
			else if (nums[mid] > nums[mid + 1])
				right = mid;
		}
		return right;
	}
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 1}, nums2 = {1, 2, 1, 3, 5, 6, 4};
		FindPeakElement test = new FindPeakElement();
		System.out.println(test.findPeakElement(nums1));
		System.out.println(test.findPeakElement(nums2));
	}
}
