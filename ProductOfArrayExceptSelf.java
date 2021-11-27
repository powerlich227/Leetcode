import java.util.Arrays;

/* LeetCode 238
 * 
 * Product of Array Except Self
 * 
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 
Constraints:

2 <= nums.length <= 10^5
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 
Follow up:
Could you solve it in O(n) time complexity and without using division?
Could you solve it with O(1) constant space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
	// Prefix Product
	// follow up : O(1) extra space complexity
	// right: product of right side of i
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length, right = 1;
		int[] res = new int[n]; 
		res[0] = 1;
		for (int i = 1; i < n; i++)
			res[i] = res[i - 1] * nums[i - 1];
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;
	}
//	public static int[] productExceptSelf2(int[] nums) {
//		int n = nums.length;
//		int[] pre = new int[n], post = new int[n], res = new int[n]; 
//		pre[0] = 1; post[n - 1] = 1;
//		for (int i = 1; i < n; i++) {
//			pre[i] = pre[i - 1] * nums[i - 1];
//		}
//		for (int i = n - 2; i >= 0; i--) {
//			post[i] = post[i + 1] * nums[i + 1];
//		}
//		for (int i = 0; i < n; i++) 
//			res[i] = pre[i] * post[i];
//		return res;
//	}
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		ProductOfArrayExceptSelf test = new ProductOfArrayExceptSelf();
		System.out.println(Arrays.toString(test.productExceptSelf(nums)));
		System.out.println(Arrays.toString(test.productExceptSelf(new int[] {-1, 1, 0, -3, 3})));
	}
}
