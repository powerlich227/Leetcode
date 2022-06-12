/*
 * LeetCode 1658 Medium
 * 
 * Minimum Operations to Reduce X to Zero
 * 
You are given an integer array nums and an integer x. 
In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. 
Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.


Example 1:
Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.

Example 2:
Input: nums = [5,6,7,8,9], x = 4
Output: -1

Example 3:
Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 

Constraints:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^4
1 <= x <= 10^9 
 */
public class MinimumOperationsToReduceXToZero {
	public int minOperations(int[] nums, int x) {
		int sum = 0, n = nums.length;
		for (int num : nums)
			sum += num;
		if (sum < x)
			return -1;
		if (sum == x)
			return 1;
		
		int l = 0, r = 0, min = Integer.MAX_VALUE, curSum = 0;
		while (r < n) {
			int cur = nums[r];
			r++;
			curSum += cur;
			while (curSum >= sum - x) {
				if (curSum == sum - x)
					min = Math.min(min, n - r + l);
				int cur2 = nums[l];
				l++;
				curSum -= cur2;
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}
	public static void main(String[] args) {
		MinimumOperationsToReduceXToZero test = new MinimumOperationsToReduceXToZero();
		System.out.println(test.minOperations(new int[] {1, 1, 4, 2, 3}, 5));
		System.out.println(test.minOperations(new int[] {5, 6, 7, 8, 9}, 4));
		System.out.println(test.minOperations(new int[] {3, 2, 20, 1, 1, 3}, 10));
	}

}
