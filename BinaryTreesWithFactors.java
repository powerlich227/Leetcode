import java.util.Arrays;
import java.util.HashMap;

/*
 * LeetCode 823 Medium
 * 
 * Binary Trees With Factors
 * 
Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.

We make a binary tree using these integers, and each number may be used for any number of times. 
Each non-leaf node's value should be equal to the product of the values of its children.

Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.


Example 1:
Input: arr = [2,4]
Output: 3
Explanation: We can make these trees: [2], [4], [4, 2, 2]

Example 2:
Input: arr = [2,4,5,10]
Output: 7
Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 
Constraints:
1 <= arr.length <= 1000
2 <= arr[i] <= 10^9
All the values of arr are unique.
 */
public class BinaryTreesWithFactors {
	public int numFactoredBinaryTrees(int[] arr) {
		int MOD = 1000000007;
		int n = arr.length;
//		Arrays.sort(arr);
		long[] dp = new long[n];
		Arrays.fill(dp, 1);
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++)
			map.put(arr[i], i);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] % arr[j] == 0) {
					int right = arr[i] / arr[j];
					if (map.containsKey(right))
						dp[i] += (dp[j] * dp[map.get(right)]) % MOD;
				}
			}
		}
		long res = 0;
		for (long d : dp)
			res += d;
		return (int) (res % MOD);
	}
	public static void main(String[] args) {
		BinaryTreesWithFactors test = new BinaryTreesWithFactors();
		System.out.println(test.numFactoredBinaryTrees(new int[] {2,4}));
		System.out.println(test.numFactoredBinaryTrees(new int[] {2,4,5,10}));
	}
}
