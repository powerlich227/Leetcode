import java.util.HashMap;
import java.util.Map;

/*
 * LeetCode 560 Medium
 * 
 * Subarray Sum Equals K
 * 
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2
 
Constraints:

1 <= nums.length <= 2 * 10^4
-1000 <= nums[i] <= 1000
-10^7 <= k <= 10^7

 */
public class SubarraySumEqualsK {
	// T:O(n) S:O(n)
	public static int subarraySum(int[] nums, int k) {
		int res = 0, sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				res += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return res;
	}
	// T:O(n^2) S:O(1)
	public static int subarraySum2(int[] nums, int k) {
		int res = 0, n = nums.length;
		for (int i = 0; i < n; i++) {
			int sum = nums[i];
			if (sum == k)
				res++;
			for (int j = i + 1; j < n; j++) {
				sum += nums[j];
				if (sum == k)
					res++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {1, 1, 1}, nums2 = {1, 2, 3};
		int k = 2, k2 = 3;
		System.out.println(subarraySum(nums, k));
		System.out.println(subarraySum(nums2, k2));
	}
}
