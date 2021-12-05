import java.util.HashMap;
import java.util.Map;

/*
 * LeetCode 337
 * 
 * Medium House Robber III
 * 
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. 
It will automatically contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police. 


Example 1:
Input: root = [3,2,3,null,3,null,1]
Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:
Input: root = [3,4,5,1,3,null,1]
Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 

Constraints:
The number of nodes in the tree is in the range [1, 10^4].
0 <= Node.val <= 10^4
 */
public class HouseRobberIII {
	// DP without memo
	public int rob(TreeNode root) {
		int[] res = helper(root);
		return Math.max(res[0], res[1]); // (root, non-root)
	}
	// return [root, non-root]
	public int[] helper(TreeNode root) {
		if (root == null)
			return new int[2];
		int[] left = helper(root.left);
		int[] right = helper(root.right);
		
		int[] res = new int[2];
		res[0] = left[1] + right[1] + root.val; // rob the root
		res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // not rob the root
		return res;
	}
	
	// DP with memo
	Map<TreeNode, Integer> memo = new HashMap<>();
	public int rob2(TreeNode root) {
		if (root == null)
			return 0;
		if (memo.containsKey(root))
			return memo.get(root);
		int a = root.val + (root.left == null ? 0 : (rob2(root.left.left) + rob2(root.left.right))) 
				+ (root.right == null ? 0 : (rob2(root.right.left) + rob2(root.right.right)));
		int b = rob2(root.left) + rob2(root.right);
		int res = Math.max(a, b);
		memo.put(root, res);
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
