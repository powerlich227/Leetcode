import java.util.Arrays;

/*
 * LeetCode 260 Medium
 * 
 * Single Number III
 * 
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
Find the two elements that appear only once. You can return the answer in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 
Example 1:
Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.

Example 2:
Input: nums = [-1,0]
Output: [-1,0]

Example 3:
Input: nums = [0,1]
Output: [1,0]
 
Constraints:
2 <= nums.length <= 3 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
Each integer in nums will appear twice, only two integers will appear once.
 */
public class SingleNumberIII {
	// Bit manipulation
	// a^0=a, a^a=0
	// a & (-a): different bit
	public int[] singleNumber(int[] nums) {
		int diff = 0;
		for (int num : nums)
			diff ^= num; // get XOR of 2 numbers we need to find
		diff &= - diff; // get their last different bit
		
		int[] res = new int[2];
		for (int num : nums) {
			if ((num & diff) == 0) // for one number
				res[0] ^= num;
			else // for another number
				res[1] ^= num;
		}
		return res;
	}
	public static void main(String[] args) {
		SingleNumberIII test = new SingleNumberIII();
		int[] nums = {1, 2, 1, 3, 2, 5}, nums2 = {-1, 0}, nums3 = {0, 1};
		System.out.println(Arrays.toString(test.singleNumber(nums)));
		System.out.println(Arrays.toString(test.singleNumber(nums2)));
		System.out.println(Arrays.toString(test.singleNumber(nums3)));
	}
}
