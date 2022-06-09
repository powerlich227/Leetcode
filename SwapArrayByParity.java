import java.util.Arrays;

/*
 * LeetCode 905 Easy
 * 
 * Sort Array By Parity
 * 
 * 
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
Return any array that satisfies this condition.

Example 1:
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Example 2:
Input: nums = [0]
Output: [0]
 
Constraints:
1 <= nums.length <= 5000
0 <= nums[i] <= 5000
 */
public class SwapArrayByParity {
	public int[] sortArrayByParity(int[] nums) {
		int l = 0, r = nums.length - 1;
		while (l < r) {
			if (nums[l] % 2 == 1 && nums[r] % 2 == 0) {
				int temp = nums[l];
				nums[l] = nums[r];
				nums[r] = temp;
			}
			if (nums[l] % 2 == 0)
				l++;
			if (nums[r] % 2 == 1)
				r--;
		}
		return nums;
	}
	public static void main(String[] args) {
		SwapArrayByParity test = new SwapArrayByParity();
		System.out.println(Arrays.toString(test.sortArrayByParity(new int[] {3, 1, 2, 4})));
		System.out.println(Arrays.toString(test.sortArrayByParity(new int[] {0})));
	}
}
