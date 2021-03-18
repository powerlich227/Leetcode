import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
	public static void main(String[] args) {
		System.out.println();
	}
	/*
	 * Arrays.sort
	 */
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return (nums.length - k - 1);
	}
	/*
	 * PQ
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
	 */
	public int findKthLargest3(int[] nums, int k) {
		int n = nums.length, l = 0, r = n - 1;
		while (true) {
			int pos = helper(nums, l, r);
			if (pos == k - 1)
				return nums[pos];
			if (pos > k)
				r = pos - 1;
			else
				l = pos + 1;
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
		return l;
	}
}
