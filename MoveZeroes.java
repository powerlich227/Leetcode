import java.util.Arrays;

/*
 * LeetCode 283 Easy
 * 
 * Move Zeroes
 * 
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

 
Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
 
Constraints:

1 <= nums.length <= 10^4
-2^31 <= nums[i] <= 2^31 - 1
 

Follow up: Could you minimize the total number of operations done?
 */
public class MoveZeroes {
	public static void main(String[] args) {
		MoveZeroes test = new MoveZeroes();
		int[] nums = new int[] {0, 1, 0, 3, 12};
		test.moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
	// Two Pointers: slow & fast
	public void moveZeroes(int[] nums) {
		int slow = 0, fast = 0;
		while (fast < nums.length) {
			if (nums[fast] != 0) {
                if (slow != fast) {
                	// swap
                    int temp = nums[fast];
                    nums[fast] = nums[slow];
                    nums[slow] = temp;
                }
				slow++;
			}
			fast++;
		}
	}
}
