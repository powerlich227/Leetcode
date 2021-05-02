import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * LeetCode 698 Medium
 * 
 * Partition to K Equal Sum Subsets
 * 
 * 
Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

Example 2:
Input: nums = [1,2,3,4], k = 3
Output: false
 
Constraints:
1 <= k <= nums.length <= 16
0 <= nums[i] <= 10^4
 */
public class PartitionToKEqualSumSubsets {
	// DFS 1
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (sum % k != 0)
			return false;
		int target = sum / k;
		
		Arrays.sort(nums);
		boolean[] visited = new boolean[nums.length];
		int bucketSum = 0;
		
		return dFS(nums, nums.length - 1, visited, k, bucketSum, target);
	}
	public boolean dFS(int[] nums, int numsIndex, boolean[] visited, int bucketIndex, int bucketSum, int target) {
		if (bucketIndex == 0)
			return true;
		
		if (bucketSum == target)
			return dFS(nums, nums.length - 1, visited, bucketIndex - 1, 0, target);
		
		for (int i = numsIndex; i >= 0; i--) {
			if (visited[i])
				continue;
			if (bucketSum + nums[i] > target)
				continue;
			bucketSum += nums[i];
			visited[i] = true;
			
			if (dFS(nums, i - 1, visited, bucketIndex, bucketSum, target))
				return true;
			
			bucketSum -= nums[i];
			visited[i] = false;
			if (bucketSum == 0)
				break;
		}
		return false;
	}
	
	// DFS 2 (better)
	public boolean canPartitionKSubsets2(int[] nums, int k) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (sum % k != 0)
			return false;
		int target = sum / k;
		
		int[] bucket = new int[k];
		Arrays.sort(nums);

		return dFS2(nums, nums.length - 1, bucket, target);
	}
	public boolean dFS2(int[] nums, int index, int[] bucket, int target) {
		if (index == -1) {
			for (int b : bucket) {
				if (b != target)
					return false;
			}
			return true;
		}		
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] + nums[index] > target)
				continue;
			bucket[i] += nums[index];
			if (dFS2(nums, index - 1, bucket, target)) {
				return true;
			}
			bucket[i] -= nums[index];
            if (bucket[i] == 0)
                break;
		}
		return false;	
	}
	public static void main(String[] args) {
		int[] nums = {4,3,2,3,5,2,1}, nums2 = {1, 2, 3, 4}, nums3 = {0, 127};
		int k = 4, k2 = 3, k3 = 1;
		PartitionToKEqualSumSubsets test = new PartitionToKEqualSumSubsets();
		System.out.println(test.canPartitionKSubsets2(nums, k));
		System.out.println(test.canPartitionKSubsets2(nums2, k2));
		System.out.println(test.canPartitionKSubsets2(nums3, k3));
	}

}
