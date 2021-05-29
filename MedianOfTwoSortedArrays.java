import java.util.*;

/*
 * LeetCode 4 Hard
 * 
 * Median of Two Sorted Arrays
 * 
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

 
Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Example 3:
Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000

Example 4:
Input: nums1 = [], nums2 = [1]
Output: 1.00000

Example 5:
Input: nums1 = [2], nums2 = []
Output: 2.00000
 

Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-10^6 <= nums1[i], nums2[i] <= 10^6
 */

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		System.out.println();
	}
	
	// Binary Search within 2 arrays
	// median = (left + right) / 2 
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int left = (m + n + 1) / 2, right = (m + n + 2) / 2;
		return (helper(nums1, nums2, 0, 0, left) + helper(nums1, nums2, 0, 0, right)) / 2.0;
	}
	// BinarySearch, return left and right
	public int helper(int[] nums1, int[] nums2, int start1, int start2, int k) {
		int m = nums1.length, n = nums2.length;
		if (start1 >= m) // base case 1
			return nums2[start2 + k - 1];
		if (start2 >= n) // base case 2
			return nums1[start1 + k - 1];
		if (k == 1) // base case 3
			return Math.min(nums1[start1], nums2[start2]);
		int mid1 = start1 + k / 2 - 1, mid2 = start2 + k / 2 - 1;
		int num1 = (mid1 < m) ? nums1[mid1] : Integer.MAX_VALUE; // Max_Value to make num2 jump to next start
		int num2 = (mid2 < n) ? nums2[mid2] : Integer.MAX_VALUE; // Max_Value to make num1 jump to next start
		if  (num1 < num2)
			return helper(nums1, nums2, start1 + k / 2, start2, k - k / 2);
		else
			return helper(nums1, nums2, start1, start2 + k / 2, k - k / 2);
	}
	
	// Arrays.copyOfRange
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int left = (m + n + 1) / 2, right = (m + n + 2) / 2;
		return (helper2(nums1, nums2, left) + helper2(nums1, nums2, right)) / 2.0;
	}
	public int helper2(int[] nums1, int[] nums2, int k) {
		int m = nums1.length, n = nums2.length;
		if (m == 0)
			return nums2[k - 1];
		if (n == 0)
			return nums1[k - 1];
		if (k == 1)
			return Math.min(nums1[0], nums2[0]);
		int i = Math.max(m, k / 2), j = k - i; // j = Math.max(n, k / 2)
		if (nums1[i - 1] < nums2[j - 1])
			return helper2(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
		else
			return helper2(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
	}
}
