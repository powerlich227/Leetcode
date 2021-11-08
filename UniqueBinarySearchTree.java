/*
 * LeetCode 96 Medium
 * 
 * Unique Binary Search Trees
 * 
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

Example 1:
Input: n = 3
Output: 5

Example 2:
Input: n = 1
Output: 1
 
Constraints:
1 <= n <= 19
 */
public class UniqueBinarySearchTree {
	public static void main(String[] args) {
		UniqueBinarySearchTree test = new UniqueBinarySearchTree();
		System.out.println(test.numTrees(3));
		System.out.println(test.numTrees(1));
	}
	// Catalan Number
	// dp: dp[0] = 1, dp[1] = 1
	// dp[i]=sum(dp[0]*dp[i-1]+dp[1]dp[i-2]+...+dp[i-1]dp[0])
	public int numTrees(int n) {
		int[] res = new int[n + 1];
		res[0] = 1; res[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++)
				res[i] += res[j] * res[i - j - 1];
		}
		return res[n];
	}
}
