import java.util.Arrays;

/*
 * LeetCode 462 Medium
 * 
 * Minimum Moves to Equal Array Elements II
 * 
Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
In one move, you can increment or decrement an element of the array by 1.

Test cases are designed so that the answer will fit in a 32-bit integer.

Example 1:
Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]

Example 2:
Input: nums = [1,10,2,9]
Output: 16
 
Constraints:
n == nums.length
1 <= nums.length <= 10^5
-109 <= nums[i] <= 10^9 
 */
public class MinimumMovesToEqualArrayElementsII {
	// Math: find median
	// Sorting
	public int minMoves2(int[] nums) {
		Arrays.sort(nums);
		int res = 0, median = nums[nums.length / 2];
		for (int num : nums)
			res += Math.abs(num - median);
		return res;
	}
	public static void main(String[] args) {
		MinimumMovesToEqualArrayElementsII test = new MinimumMovesToEqualArrayElementsII();
		System.out.println(test.minMoves2(new int[] {1, 2, 3}));
		System.out.println(test.minMoves2(new int[] {1, 10, 2, 9}));
	}
}
