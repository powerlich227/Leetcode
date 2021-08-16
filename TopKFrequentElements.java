import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
/*
 * LeetCode 347, Medium
 * 
 * Top K Frequent Elements
 * 
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 
Constraints:

1 <= nums.legth <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 
Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
Actually: O(k log k)
 */

public class TopKFrequentElements {
	// Counting & Map & PQ
	public int[] topKFrequent(int[] nums, int k) {
		if (nums.length == k)
			return nums;
		int[] res = new int[k];
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) 
			map.put(num, map.getOrDefault(num, 0) + 1);
		Queue<Integer> q = new PriorityQueue<>((a, b) -> (map.get(b) - map.get(a)));
		for (int i : map.keySet())
			q.offer(i);
		for (int i = 0; i < k; i++) {
			res[i] = q.poll();
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5};
		int k = 4;
		TopKFrequentElements test = new TopKFrequentElements();
		System.out.println(Arrays.toString(test.topKFrequent(nums, k)));
	}
}
