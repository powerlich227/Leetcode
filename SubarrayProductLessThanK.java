/*
 * LeetCode 713 Medium
 * 
 * Subarray Product Less Than K
 * 
Given an array of integers nums and an integer k, 
return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

Example 1:
Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

Example 2:
Input: nums = [1,2,3], k = 0
Output: 0
 
Constraints:
1 <= nums.length <= 3 * 10^4
1 <= nums[i] <= 1000
0 <= k <= 10^6
 */
public class SubarrayProductLessThanK {
	// Sliding Windows
    public int numSubarrayProductLessThanK(int[] nums, int k) {
    	if (k <= 1)
    		return 0;
    	int n = nums.length;
        int left = 0, right = 0;
        int res = 0, product = 1;
        while (right < n) {
        	product *= nums[right];
        	right++;
        	while (left <= right && product >= k) {
        		product /= nums[left];
        		left++;
        	}
        	res += right - left; // [left, right - 1]
        }
        return res;
    }
	public static void main(String[] args) {
		SubarrayProductLessThanK test = new SubarrayProductLessThanK();
		System.out.println(test.numSubarrayProductLessThanK(new int[] {10,5,2,6}, 100));
		System.out.println(test.numSubarrayProductLessThanK(new int[] {1,2,3}, 0));
	}
}
