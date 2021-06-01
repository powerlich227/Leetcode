import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
/*
 * LeetCode 215 Medium
 * 
 * Kth Largest Element in an Array
 * 
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

 
Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:
1 <= k <= nums.length <= 10^4
-104 <= nums[i] <= 10^4

 */
public class KthLargestElementInAnArray {
	public static void main(String[] args) {
		KthLargestElementInAnArray test = new KthLargestElementInAnArray();
		int[] nums = {3, 2, 1, 5, 6, 4}, nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
		System.out.println(test.findKthLargest3(nums, 2));
		System.out.println(test.findKthLargest3(nums2, 4));
	}
	/*
	 * Arrays.sort
	 * O(NlogN), O(1)
	 */
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
	/*
	 * PQ
	 * O(Nlogk), O(N)
	 */
	public int findKthLargest2(int[] nums, int k) {
		Queue<Integer> pq = new PriorityQueue<>();
		for (int num : nums) {
			pq.offer(num);
			if (pq.size() > k)
				pq.poll();
		}
		return pq.peek();
	}
	/*
	 * Quicksort
	 * O(N), O(1)
	 */
	public int findKthLargest3(int[] nums, int k) {
		int n = nums.length, l = 0, r = n - 1;
		while (true) {
			int pos = helper(nums, l, r);
			if (pos == n - k)
				return nums[pos];
			else if (pos < n - k)
				l = pos + 1;
			else 
				r = pos - 1;
		}
	}
	
	public int helper(int[] nums, int left, int right) {
		int pivot = nums[right], l = left, r = right - 1;
		while (l <= r) {
			while (l <= r && nums[l] <= pivot)
				l++;
			while (l <= r && nums[r] >= pivot)
				r--;
			if (l < r) {
				int temp = nums[l];
				nums[l] = nums[r];
				nums[r] = temp;
				l++;
				r--;
			}				
		}
		nums[right] = nums[l];
        nums[l] = pivot;
		return l;
	}
}
