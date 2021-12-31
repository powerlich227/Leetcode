/*
 * LeetCode 55 Medium
 * 
 * Jump Game
 * 
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:
1 <= nums.length <= 3 * 10^4
0 <= nums[i] <= 10^5
 */
public class JumpGame {
	public static void main(String[] args) {
		JumpGame test = new JumpGame();
		System.out.println(test.canJump(new int[] {2, 3, 1, 1, 4}));
		System.out.println(test.canJump(new int[] {3, 2, 1, 0, 4}));
	}
	// Greedy
	public boolean canJump(int[] nums) {
		int reach = 0, n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			reach = Math.max(reach, i + nums[i]);
			if (reach <= i)
				return false;
		}
		return true;
	}
}
