/*
 * LeetCode 169 Easy
 * 
 * Majority Element
 * 
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. 
You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 
Constraints:

n == nums.length
1 <= n <= 5 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
 
Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {
	public static void main(String[] args) {
		int[] nums = {3, 2, 3}, nums2 = {2, 2, 1, 1, 1, 2, 2};
		MajorityElement test = new MajorityElement();
		System.out.println(test.majorityElement(nums));
		System.out.println(test.majorityElement(nums2));
	}
	// Moore Voting
	public int majorityElement(int[] nums) {
		int res = 0, cnt = 0;
		for (int num : nums) {
			if (num == res)
				cnt++;
			else if (cnt == 0) {
				res = num;
				cnt++;
			}
			else
				cnt--;
		}
		return res;
	}
}
