import java.util.*;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		System.out.println();
	}
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int left = (m + n + 1) / 2, right = (m + n + 2) / 2;
		return (helper(nums1, nums2, 0, 0, left) + helper(nums1, nums2, 0, 0, right)) / 2.0;
	}
	public int helper(int[] nums1, int[] nums2, int start1, int start2, int k) {
		int m = nums1.length, n = nums2.length;
		if (start1 >= m)
			return nums2[start2 + k - 1];
		if (start2 >= n)
			return nums1[start1 + k - 1];
		if (k == 1)
			return Math.min(nums1[start1], nums2[start2]);
		int mid1 = start1 + k / 2 - 1, mid2 = start2 + k / 2 - 1;
		int num1 = (mid1 < m) ? nums1[mid1] : Integer.MAX_VALUE;
		int num2 = (mid2 < n) ? nums2[mid2] : Integer.MAX_VALUE;
		if  (num1 < num2)
			return helper(nums1, nums2, start1 + k / 2, start2, k - k / 2);
		else
			return helper(nums1, nums2, start1, start2 + k / 2, k - k / 2);
	}
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
