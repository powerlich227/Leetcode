/*
 * LeetCode 189
 * 
 * Rotate Array
 * 
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 105

 */

public class RotateArray {
//	public static void rotate(int[] nums, int k) {
//		int n = nums.length;
//		int[] temp = Arrays.copyOf(nums, n);
//		for (int i = 0; i < n; i++)
//			nums[(i + k) % n] = temp[i];
//	}
	public static void rotate(int[] nums, int k) {		
		int start = 0, cur = nums[0];
		int pre = 0, idx = 0, n = nums.length;	
		
		if (k % n == 0)
			return;
		
		for (int i = 0; i < n; i++) {
			pre = cur;
			idx = (idx + k) % n;
			cur = nums[idx];
			nums[idx] = pre;
			if (idx == start) {
				start++;
				idx = start;
				cur = nums[idx];
			}
		}
	}
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7}, nums2 = {-1, -100, 3, 99}, nums3 = {1};
		int k = 3, k2 = 2, k3 = 0;
		rotate(nums, k);
		rotate(nums2, k2);
		for (int num : nums)
			System.out.println(num);
		for (int num2 : nums2)
			System.out.println(num2);
		for (int num3 : nums3)
			System.out.println(num3);
	}
}
