import java.util.List;
/*
 * LeetCode 120
 * 
 * Triangle
 * 
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below.
More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[] dp = triangle.get(n - 1).stream().mapToInt(i->i).toArray();
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++)
				dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
		}
		return dp[0];
	}
	public static void main(String[] args) {
		
	}
}
