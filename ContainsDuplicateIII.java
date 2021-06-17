import java.util.HashMap;
import java.util.TreeSet;

/*
 * LeetCode 220 Medium
 * 
 * Contains Duplicate III
 * 
Given an integer array nums and two integers k and t, 
return true if there are two distinct indices i and j in the array such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.

 
Example 1:
Input: nums = [1,2,3,1], k = 3, t = 0
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1, t = 2
Output: true

Example 3:
Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
 

Constraints:

0 <= nums.length <= 2 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
0 <= k <= 10^4
0 <= t <= 2^31 - 1

 */
public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Long> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				set.remove((long) nums[i - k - 1]);
			}
			Long ceil = set.floor((long) nums[i] + t); //  nums[i] <= ceil <= nums[i]+t
			Long floor = set.ceiling((long) nums[i] - t); // nums[i] - t <= floor <= nums[i]
			if ((floor != null && floor <= (long)nums[i])
					|| (ceil != null && ceil >= (long)nums[i]))
				return true;
			set.add((long) nums[i]);
		}
		return false;
	}
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 1}, nums2 = {1, 0, 1, 1}, nums3 = {1, 5, 9, 1, 5, 9};
		int[] nums4 = {-2147483648, -2147483647};
		ContainsDuplicateIII test = new ContainsDuplicateIII();
		System.out.println(test.containsNearbyAlmostDuplicate(nums, 3, 0));
		System.out.println(test.containsNearbyAlmostDuplicate(nums2, 1, 2));
		System.out.println(test.containsNearbyAlmostDuplicate(nums3, 2, 3));
		System.out.println(test.containsNearbyAlmostDuplicate(nums4, 3, 3));
	}

}
