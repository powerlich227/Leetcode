import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/*
 * LeetCode 15 Medium
 * 
 * 3 Sum
 * 
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, 
and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: []

Constraints:
0 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5
 */
public class ThreeSum {
	public static void main(String[] args) {
		System.out.println();
	}
	// 3 sum, target = 0
	// Two Pointers: left & right
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return nSumTarget(nums, 3, 0, 0);
    }
    // Recursion
    public List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        
        if (n < 2 || n > len)
            return res;
        
        if (n == 2) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                List<Integer> out = new ArrayList<>();
                int sum = nums[left] + nums[right];
                int l = nums[left], r = nums[right];
                if (sum == target) {
                    out.add(l);
                    out.add(r);
                    res.add(new ArrayList<>(out));
                    while (left < right && nums[left] == l)
                        left++;
                    while (left < right && nums[right] == r)
                        right--;
                }
                else if (sum < target) {
                    while (left < right && nums[left] == l)
                        left++;
                }
                else if (sum > target) {
                    while (left < right && nums[right] == r)
                        right--;
                }
            }
        }
        else { // n > 2
            for (int i = start; i < len; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> s : sub) {
                    s.add(nums[i]);
                    res.add(new ArrayList<>(s));
                }
                while (i < len - 1 && nums[i] == nums[i + 1])
                    i++;
            }
        }
        return res;
    }
}
