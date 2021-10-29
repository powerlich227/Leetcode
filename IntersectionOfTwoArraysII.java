import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * LeetCode 350 Easy
 * 
 * Intersection of Two Arrays II
 * 
Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.

Constraints:
1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better? BinarySearch
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once? 
 */
public class IntersectionOfTwoArraysII {
	// HashMap
	// O(m+n)
	public int[] intersect(int[] nums1, int[] nums2) {
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num1 : nums1) {
			map.put(num1, map.getOrDefault(num1, 0) + 1);
		}
		for (int num2 : nums2) {
			if (map.containsKey(num2) && map.get(num2) > 0) {
				map.put(num2, map.get(num2) - 1);
				list.add(num2);
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
	// follow up 1: sort and two pointers
	// O(max(m,n)) if sorted
	public int[] intersect2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int m = nums1.length, n = nums2.length;
		int i = 0, j = 0;
		ArrayList<Integer> list = new ArrayList<>();
		while (i < m && j < n) {
			if (nums1[i] == nums2[j]) {
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
	public static void main(String[] args) {
		IntersectionOfTwoArraysII test = new IntersectionOfTwoArraysII();
		System.out.println(Arrays.toString(test.intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2})));
		System.out.println(Arrays.toString(test.intersect(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4})));
		System.out.println(Arrays.toString(test.intersect2(new int[] {1, 2, 2, 1}, new int[] {2, 2})));
		System.out.println(Arrays.toString(test.intersect2(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4})));
	}
}
