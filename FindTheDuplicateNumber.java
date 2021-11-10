/*
 * LeetCode 287 Medium
 * 
 * Find the Duplicated Number
 * 
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Example 3:
Input: nums = [1,1]
Output: 1

Example 4:
Input: nums = [1,1,2]
Output: 1
 
Constraints:
1 <= n <= 10^5
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 
Follow up:
How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
 */
public class FindTheDuplicateNumber {
	public static void main(String[] args) {
		FindTheDuplicateNumber test = new FindTheDuplicateNumber();
		System.out.println(test.findDuplicate(new int[] {1, 3, 4, 2, 2}));
		System.out.println(test.findDuplicate(new int[] {3, 1, 3, 4, 2}));
		System.out.println(test.findDuplicate(new int[] {1, 1}));
		System.out.println(test.findDuplicate(new int[] {1, 1, 2}));
		System.out.println(test.findDuplicate2(new int[] {1, 3, 4, 2, 2}));
		System.out.println(test.findDuplicate2(new int[] {3, 1, 3, 4, 2}));
		System.out.println(test.findDuplicate2(new int[] {1, 1}));
		System.out.println(test.findDuplicate2(new int[] {1, 1, 2}));
	}
	// follow up 1: pigeonhole theory
	// follow up 2: O(n)
	// Two Pointers: slow, fast
	
	/*      x_0     = k (for some k)
    		x_1     = f(x_0)
    		x_2     = f(f(x_0))
    		...
    		x_{n+1} = f(x_n)
    		
    x_0 -> x_1 -> ... x_k -> x_{k+1} ... -> x_{k+j}
                         ^                       |
                         |                       |
                         +-----------------------+
     x_{l'} = x_{2l'}
                  
	 */
	public int findDuplicate(int[] nums) {
		int slow = 0, fast = 0;
		while (true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			if (slow == fast)
				break;
		}
		slow = 0;
		while (true) {
			slow = nums[slow];
			fast = nums[fast];
			if (slow == fast)
				break;
		}
		return slow;	
	}
	
	// binary search, pigeonhole theory
	// left, right: value in the nums, not indice.
	public int findDuplicate2(int[] nums) {
		int n = nums.length;
		int left = 1, right = n - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			int cnt = 0;
			for (int num : nums) {
				if (num <= mid)
					cnt++;
			}
			if (cnt <= mid)
				left = mid + 1;
			else if (cnt > mid)
				right = mid;
		}
		return left;
	}
}
