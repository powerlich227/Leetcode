import java.util.Arrays;
import java.util.HashSet;

/* LeetCode 217 Easy
 * 
 * Contains Duplicate
 * 
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 
Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 

Constraints:
1 <= nums.length <= 10^5
-109 <= nums[i] <= 10^9
 */
public class ContainsDuplicate {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 1}, nums2 = {1, 2, 3, 4}, nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
		ContainsDuplicate test = new ContainsDuplicate();
		System.out.println(test.containsDuplicate2(nums));
		System.out.println(test.containsDuplicate2(nums2));
		System.out.println(test.containsDuplicate2(nums3));
	}
	// sort
	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] == nums[i])
				return true;
		}
		return false;
	}
	// hashset
	public boolean containsDuplicate2(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (!set.add(num))
				return true;
//			if (set.contains(num))
//				return true;
//			set.add(num);
		}
		return false;
	}
}
