/*
 * LeetCode 410 Hard
 * 
 * Split Array Largest Sum
 * 
Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
Write an algorithm to minimize the largest sum among these m subarrays.

 
Example 1:
Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.

Example 2:
Input: nums = [1,2,3,4,5], m = 2
Output: 9

Example 3:
Input: nums = [1,4,4], m = 3
Output: 4
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 10^6
1 <= m <= min(50, nums.length)
 */
public class SplitArrayLargestSum {
	// Binary Search [left, right)
	public int splitArray(int[] nums, int m) {
		int left = 0, right = 1;
		for (int num : nums) {
			left = Math.max(left, num);
			right += num;
		}
		while (left < right) {
			int mid = left + (right - left) / 2;
			int sub = split(nums, mid);
			if (sub == m)
				right = mid;
			else if (sub < m)
				right = mid;
			else if (sub > m)
				left = mid + 1;
		}
		return left;
	}
	// get min m;
	public int split(int[] nums, int max) {
		int m = 1, sum = 0;
		for (int num : nums) {
			if (sum + num > max) {
				m++;
				sum = num;
			}
			else {
				sum += num;
			}
		}
		return m;
	}
	public static void main(String[] args) {
		SplitArrayLargestSum test = new SplitArrayLargestSum();
		System.out.println(test.splitArray(new int[] {7,2,5,10,8}, 2));
		System.out.println(test.splitArray(new int[] {1,2,3,4,5}, 2));
		System.out.println(test.splitArray(new int[] {1,4,4}, 3));
	}
}
