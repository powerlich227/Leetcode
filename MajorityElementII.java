import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode 229 Medium
 * 
 * Majority Element II
 * 
Given an integer array of size n, find all elements that appear more than ⌊n/3⌋ times.

Follow-up: Could you solve the problem in linear time and in O(1) space?

Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1,2]
Output: [1,2]
 
Constraints:

1 <= nums.length <= 5 * 10^4
-10^9 <= nums[i] <= 10^9
 */
public class MajorityElementII {
	// Moore Voting
	// at most 2 results return
	// a: cnt1, b: cnt2
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int a = 0, b = 0, cnt1 = 0, cnt2 = 0, n = nums.length;
		for (int num : nums) {
			if (num == a)
				cnt1++;
			else if (num == b)
				cnt2++;
			else if (cnt1 == 0) {
				a = num;
				cnt1 = 1;
			}
			else if (cnt2 == 0) {
				b = num;
				cnt2 = 1;
			}
			else {
				cnt1--;
				cnt2--;
			}
		}
		cnt1 = cnt2 = 0;
		for (int num : nums) {
			if (num == a)
				cnt1++;
			if (num == b)
				cnt2++;
		}
		if (cnt1 > n / 3 )
			res.add(a);
		if (cnt2 > n / 3)
			res.add(b);
		return res;
	}
	public static void main(String[] args) {
		MajorityElementII test = new MajorityElementII();
		int[] nums = {3, 2, 3}, nums2 = {1}, nums3 = {1, 2};
		System.out.println(test.majorityElement(nums));
		System.out.println(test.majorityElement(nums2));
		System.out.println(test.majorityElement(nums3));
	}

}
