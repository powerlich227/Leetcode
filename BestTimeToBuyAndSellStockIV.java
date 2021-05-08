/*
 * LeetCode 188 Hard
 * 
 * Best time to Buy and Sell Stock IV
 * 
You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
Find the maximum profit you can achieve. You may complete at most k transactions.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 
Example 1:
Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

Example 2:
Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. 
Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 

Constraints:
0 <= k <= 100
0 <= prices.length <= 1000
0 <= prices[i] <= 1000
*/
public class BestTimeToBuyAndSellStockIV {
	// DP
	// dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
	// dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
	// dp[-1][k][0] = 0, dp[-1][k][1] = Integer.MIN_VALUE;
	// dp[i][0][0] = 0, dp[i][0][1] = Integer.MIN_VALUE;
	// k?
	public int maxProfit(int k, int[] prices) {
		int n = prices.length;
        if (n == 0)
            return 0;
		if (k > n / 2)
			maxProfit2(prices);
		int[][][] dp = new int[n][k + 1][2];
		for (int j = 1; j <= k; j++) {
			for (int i = 0; i < n; i++) {
				if (i == 0) {
					dp[i][j][0] = 0;
					dp[i][j][1] = -prices[i];
					continue;
				}
				dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
				dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
			}
		}
		return dp[n - 1][k][0];
	}
	public int maxProfit2(int[] prices) {
		int n = prices.length, dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
		}
		return dp_i_0;
	}
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockIV test = new BestTimeToBuyAndSellStockIV();
		int[] prices = {2, 4, 1}, prices2 = {3, 2, 6, 5, 0, 3};
		int k = 2;
		System.out.println(test.maxProfit(k, prices));
		System.out.println(test.maxProfit(k, prices2));
	}
}
