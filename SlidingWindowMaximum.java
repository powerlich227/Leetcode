import java.util.*;

public class SlidingWindowMaximum {
	/*
	 * Brute Force
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] res = new int[n - k + 1];
		
		for (int i = 0; i < n - k + 1; i++) {
			int max = nums[i];
			for (int j = i; j < i + k; j++) {
				if (nums[j] > max)
					max = nums[j];
			}
			res[i] = max;
		}
		return res;
	}
	/*
	 * Deque
	 */
	public int[] maxSlidingWindow2(int[] nums, int k) {
		int n = nums.length;
		int[] res = new int[n - k + 1];
		
		Deque<Integer> dq = new ArrayDeque<>(); // store index of max number
		for (int i = 0; i < n; i++) {
			while (!dq.isEmpty() && dq.peekFirst() <= i - k) // check left bound of window
				dq.pollFirst();
			while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) // remove index of small number in the window
				dq.pollLast();
			dq.offerLast(i);
			if (i > k - 2)
				res[i - k + 1] = nums[dq.peekFirst()];
		}
		return res;
	}
}
