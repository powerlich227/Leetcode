import java.util.*;

/*
 * LeetCode 77 Medium
 * 
 * Combination
 * 
Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
You may return the answer in any order.

Example 1:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

Example 2:
Input: n = 1, k = 1
Output: [[1]]
 

Constraints:
1 <= n <= 20
1 <= k <= n
 */
public class Combinations {
	public static void main(String[] args) {
		Combinations test = new Combinations();
		System.out.println(test.combine(4,2));
	}
	// DFS
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> out = new ArrayList<>();
		helper(n, k, 1, out, res);
		return res;
	}
	public void helper(int n, int k, int level, List<Integer> out, List<List<Integer>> res) {
		if (out.size() == k) {
			res.add(new ArrayList<>(out));
			return;
		}
		for (int i = level; i <= n; i++) {
			out.add(i);
			helper(n, k, i + 1, out, res);
			out.remove(out.size() - 1);
		}
	}
}
