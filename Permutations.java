import java.util.*;
/*
 * 
 * LeetCode 46 Medium
 * 
 * Permutations
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * 
 *  
Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
 
Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */
public class Permutations {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		Permutations test = new Permutations();
		System.out.println(test.permute(nums));
	}
	// DFS
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> track = new ArrayList<>();
		helper(nums, track, res);
		return res;
	}
	public void helper(int[] nums, List<Integer> track, List<List<Integer>> res) {
		if (track.size() == nums.length) {
			res.add(new LinkedList<>(track));
			return;
		}
		for (int i = 0 ; i < nums.length; i++) {
			if (track.contains(nums[i])) {
				continue;
			}
			track.add(nums[i]);
			helper(nums, track, res);
			track.remove(track.size() - 1);
		}
	}
}
