import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * LeetCode 1675 Hard
 * 
 * Minimize Deviation in Array
 * 
You are given an array nums of n positive integers.
You can perform two types of operations on any element of the array any number of times:

If the element is even, divide it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the last element, and the array will be [1,2,3,2].
If the element is odd, multiply it by 2.
For example, if the array is [1,2,3,4], then you can do this operation on the first element, and the array will be [2,2,3,4].
The deviation of the array is the maximum difference between any two elements in the array.

Return the minimum deviation the array can have after performing some number of operations.

Example 1:
Input: nums = [1,2,3,4]
Output: 1
Explanation: You can transform the array to [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 = 1.

Example 2:
Input: nums = [4,1,5,20,3]
Output: 3
Explanation: You can transform the array after two operations to [4,2,5,5,3], then the deviation will be 5 - 2 = 3.

Example 3:
Input: nums = [2,10,8]
Output: 3
 
Constraints:
n == nums.length
2 <= n <= 10^5
1 <= nums[i] <= 10^9
 */
public class MinimizeDeviationInArray {
	public int minimumDeviation(int[] nums) {
		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num % 2 == 1)
				num *= 2;
			pq.add(num);
			min = Math.min(min, num);
		}
		int res = Integer.MAX_VALUE;
		while (true) {
			int max = pq.poll();
			res = Math.min(res, max - min);
			if (max % 2 == 1)
				break;
			max /= 2;
			min = Math.min(min, max);
			pq.add(max);
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 4}, nums2 = {4, 1, 5, 20, 3}, nums3 = {2, 10, 8};
		MinimizeDeviationInArray test = new MinimizeDeviationInArray();
		System.out.println(test.minimumDeviation(nums1));
		System.out.println(test.minimumDeviation(nums2));
		System.out.println(test.minimumDeviation(nums3));	
	}
}
