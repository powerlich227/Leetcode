import java.util.Arrays;
import java.util.Comparator;
/*
 * LeetCode 179
 * 
 * Largest Number
Given a list of non-negative integers nums, arrange them such that they form the largest number.
Note: The result may be very large, so you need to return a string instead of an integer.

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
Example 3:

Input: nums = [1]
Output: "1"
Example 4:

Input: nums = [10]
Output: "10"
 */
public class LargestNumber {
	public static String largestNumber(int[] nums) {
		String res = "";
		int n = nums.length;
		String[] str_nums = new String[n];
		for (int i = 0; i < n; i++) 
			str_nums[i] = nums[i] + "";
		Arrays.sort(str_nums, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
		if (str_nums[0].equals("0"))
			return "0";
		for (String str : str_nums)
			res += str;
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {3, 30, 34, 5, 9}, nums2 = {0, 0, 0};
		System.out.println(largestNumber(nums));
		System.out.println(largestNumber(nums2));
	}
}
