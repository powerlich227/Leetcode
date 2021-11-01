import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 * LeetCode 350 Easy
 * 
 * Intersection of Two Arrays II
 * 
Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must be unique and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */
public class IntersectionOfTwoArrays {
	// HashSet
	public int[] intersect(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int num1 : nums1)
			set.add(num1);
		for (int num2 : nums2) {
			if (set.contains(num2)) {
				list.add(num2);
				set.remove(num2);
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
	// sort and two pointers
	public int[] intersect2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int m = nums1.length, n = nums2.length;
		int i = 0, j = 0;
		ArrayList<Integer> list = new ArrayList<>();
		while (i < m && j < n) {
			if (nums1[i] == nums2[j]) {
				if (list.isEmpty() || list.get(list.size() - 1) != nums1[i])
					list.add(nums1[i]);
				i++;
				j++;
			}
			else if (nums1[i] < nums2[j])
				i++;
			else if (nums1[i] > nums2[j])
				j++;
		}
		int[] res = new int[list.size()];
		for (int k = 0; k < list.size(); k++)
			res[k] = list.get(k);
		return res;
	}
	// binary search
	public int[] intersect3(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<>();
		Arrays.sort(nums2);
		for (int num1 : nums1) {
			if (binarySearch(nums2, num1))
				set.add(num1);
		}
		int[] res = new int[set.size()];
		int i = 0;
		for (int s : set)
			res[i++] = s;
		return res;
	}
	public boolean binarySearch(int[] nums, int target) {
		int left = 0, right = nums.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target)
				return true;
			else if (nums[mid] < target)
				left = mid + 1;
			else if (nums[mid] > target)
				right = mid;
		}
		return false;
	}
	public static void main(String[] args) {
		IntersectionOfTwoArrays test = new IntersectionOfTwoArrays();
		System.out.println(Arrays.toString(test.intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2})));
		System.out.println(Arrays.toString(test.intersect(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4})));
		System.out.println(Arrays.toString(test.intersect2(new int[] {1, 2, 2, 1}, new int[] {2, 2})));
		System.out.println(Arrays.toString(test.intersect2(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4})));
		System.out.println(Arrays.toString(test.intersect3(new int[] {1, 2, 2, 1}, new int[] {2, 2})));
		System.out.println(Arrays.toString(test.intersect3(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4})));
	}
}
