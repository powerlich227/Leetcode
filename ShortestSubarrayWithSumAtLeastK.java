import java.util.Deque;
import java.util.LinkedList;

/*
 * LeetCode 862 Hard
 * 
 * Shortest Subarray With Sum at Least K
 * 
Return the length of the shortest, non-empty, contiguous subarray of nums with sum at least k.
If there is no non-empty subarray with sum at least k, return -1.

 
Example 1:
Input: nums = [1], k = 1
Output: 1

Example 2:
Input: nums = [1,2], k = 4
Output: -1

Example 3:
Input: nums = [2,-1,2], k = 3
Output: 3
 

Note:

1 <= nums.length <= 50000
-10^5 <= nums[i] <= 10^5
1 <= k <= 10^9
 */
public class ShortestSubarrayWithSumAtLeastK {
	// Dequeue
	// sums[i] = nums[0] + nums[1] + ... + nums[i-1]
	// sums[y] - sums[x] >= k, y - x is small
	
	public int shortestSubarray(int[] nums, int k) {
		int n = nums.length;
		int[] sums = new int[n + 1];
		for (int i = 0; i < n; i++) {
			sums[i + 1] = sums[i] + nums[i];
		}
		int res = Integer.MAX_VALUE;
		Deque<Integer> dq = new LinkedList<>(); 
		for (int i = 0; i < sums.length; i++) {
			while (!dq.isEmpty() && sums[i] - sums[dq.getFirst()] >= k) {
				res = Math.min(res, i - dq.removeFirst());
			}
			while (!dq.isEmpty() && sums[i] <= sums[dq.getLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		return (res == Integer.MAX_VALUE) ? -1 : res;
	}
	public static void main(String[] args) {
		int[] nums = {1}, nums2 = {1, 2}, nums3 = {2, -1, 2};
		ShortestSubarrayWithSumAtLeastK test = new ShortestSubarrayWithSumAtLeastK();
		System.out.println(test.shortestSubarray(nums, 1));
		System.out.println(test.shortestSubarray(nums2, 4));
		System.out.println(test.shortestSubarray(nums3, 3));
	}
}
