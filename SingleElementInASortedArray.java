/*
 * LeetCode 540 Medium
 * 
 * Single Element In a Sorted Array
 * 
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10
 
Constraints:
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5
 */
public class SingleElementInASortedArray {
    // BinarySearch
	// odd number in array
	// check the right side of mid number 
    public int singleNonDuplicate(int[] nums) {
    	int n = nums.length;
    	int left = 0, right = n - 1;
    	while (left < right) {
    		int mid = left + (right - left) / 2;
    		if (nums[mid] == nums[mid + 1]) {
    			if ((n - 1 - mid) % 2 == 1)
    				right = mid;
    			else
    				left = mid + 1;
    		}
    		else {
    			if (mid == 0 || nums[mid] != nums[mid - 1])
    				return nums[mid];
    			if ((n - mid) % 2 == 1)
    				right = mid;
    			else 
    				left = mid + 1;
    		}
    	}
        return nums[left];
    }
	public static void main(String[] args) {
		SingleElementInASortedArray test = new SingleElementInASortedArray();
		System.out.println(test.singleNonDuplicate(new int[] {1, 1, 2, 3, 3, 4, 4, 8, 8}));
		System.out.println(test.singleNonDuplicate(new int[] {3,3,7,7,10,11,11}));
	}
}
