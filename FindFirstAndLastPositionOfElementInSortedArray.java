import java.util.Arrays;
/*
 * LeetCode 34 Medium
 * 
 * Find First and Last Position of Element in Sorted Array
 * 
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

 
Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non-decreasing array.
-10^9 <= target <= 10^9
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
	public static void main(String[] args) {
		FindFirstAndLastPositionOfElementInSortedArray test = new FindFirstAndLastPositionOfElementInSortedArray();
		int[] nums = {5,7,7,8,8,10}, nums2 = {};
		int target = 8, target2 = 6, target3 = 0;
		System.out.println(Arrays.toString(test.searchRange(nums, target)));
		System.out.println(Arrays.toString(test.searchRange(nums, target2)));
		System.out.println(Arrays.toString(test.searchRange(nums2, target3)));
	}
    // Binary Search
    public int[] searchRange(int[] nums, int target) {
		int[] res = {-1, -1};
		if (nums == null)
			return res;
		int left = 0, right = nums.length; // [left, right)
		while (left < right) { // First Position
			int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                right = mid;
			else if (nums[mid] < target)
				left = mid + 1;
			else if (nums[mid] > target)
				right = mid;
		}
		if (left == nums.length || nums[left] != target)
			return res;
		res[0] = left;
		
		right = nums.length;
		while (left < right) { // Last Position
			int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                left = mid + 1;
			else if (nums[mid] < target)
				left = mid + 1;
			else if (nums[mid] > target)
				right = mid;
		}
			// if (right == nums.length || nums[right] != target)
			// return res;
		res[1] = right - 1;
		return res;
	}
}
