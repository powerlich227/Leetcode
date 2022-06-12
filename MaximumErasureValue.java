import java.util.HashMap;

/*
 * LeetCode 1695 Medium
 * 
 * Maximum Erasure Value
 * 
You are given an array of positive integers nums and want to erase a subarray containing unique elements. 
The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.
An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).


Example 1:
Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].

Example 2:
Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 

Constraints:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^4
 */
public class MaximumErasureValue {
	public int maximumUniqueSubarray(int[] nums) {
		int l = 0, r = 0, n = nums.length, max = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		while (r < nums.length) {
			int cur = nums[r];
			r++;
			map.put(cur, map.getOrDefault(cur, 0) + 1);
			while (map.get(cur) > 1) {
				int cur2 = nums[l];
				l++;
				map.put(cur2, map.get(cur2) - 1);
			}
			int sum = 0;
			for (int i = l; i < r; i++)
				sum += nums[i];
			max = Math.max(max, sum);
		}
		return max;
	}
	public static void main(String[] args) {
		MaximumErasureValue test = new MaximumErasureValue();
		System.out.println(test.maximumUniqueSubarray(new int[] {4, 2, 4, 5, 6}));
		System.out.println(test.maximumUniqueSubarray(new int[] {5, 2, 1, 2, 5, 2, 1, 2, 5}));
	}
}
