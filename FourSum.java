import java.util.*;
/*
 * LeetCode 18 Medium
 * 
 * 4Sum
 * 
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 
Constraints:
1 <= nums.length <= 200
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
 */
public class FourSum {
	public static void main(String[] args) {
		System.out.println();
	}
    // 1.Sort 2. BinarySearch: left, right
    public List<List<Integer>> fourSum(int[] nums) {
        Arrays.sort(nums);
        return nSumTarget(nums, 4, 0, 0);
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
