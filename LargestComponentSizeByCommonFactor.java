import java.util.HashMap;

/*
 * LeetCode 952 Hard
 * 
 * Largest Component Size by Common Factor

You are given an integer array of unique positive integers nums. Consider the following graph:

There are nums.length nodes, labeled nums[0] to nums[nums.length - 1],
There is an undirected edge between nums[i] and nums[j] if nums[i] and nums[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.

Example 1:
Input: nums = [4,6,15,35]
Output: 4

Example 2:
Input: nums = [20,50,9,63]
Output: 2

Example 3:
Input: nums = [2,3,6,7,4,12,21,39]
Output: 8
 
Constraints:
1 <= nums.length <= 2 * 10^4
1 <= nums[i] <= 10^5
All the values of nums are unique.
 */
public class LargestComponentSizeByCommonFactor {
	// Union find
    public int largestComponentSize(int[] nums) {
    	HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0, res = 0;
        for (int num : nums)
        	max = Math.max(max, num);
        int[] root = new int[max + 1];
        for (int i = 1; i <= max; i++)
        	root[i] = i;
        for (int num : nums) {
        	for (int i = (int) Math.sqrt(num); i >= 2; i--) {
        		if (num % i == 0) {
        			root[helper(root, num)] = root[helper(root, i)];
        			root[helper(root, num)] = root[helper(root, num / i)];
        		}
        	}
        }
        for (int num : nums) {
        	int cur = helper(root, num);
        	map.put(cur, map.getOrDefault(cur, 0) + 1);
        	res = Math.max(res, map.get(cur));
        }
        return res;
    }
    public int helper(int[] root, int x) {
    	if (root[x] == x)
    		return x;
    	root[x] = helper(root, root[x]);
    	return root[x];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
