/*
 * LeetCode 123 Hard
 * 
 * Best Time to Buy and Sell Stock III
 * 
You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete at most two transactions.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 
Example 1:
Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.

Example 3:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

Example 4:
Input: prices = [1]
Output: 0
 

Constraints:
1 <= prices.length <= 10^5
0 <= prices[i] <= 10^5
 */
public class BestTimeToBuyAndSellStockIII {
	// DP
	// dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
	// dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
	// dp[-1][k][0] = 0, dp[-1][k][1] = Integer.MIN_VALUE;
	// dp[i][0][0] = 0, dp[i][0][1] = Integer.MIN_VALUE;
	// k = 2
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][][] dp = new int[n][3][2];
		dp[0][0][0] = 0;
		dp[0][0][1] = Integer.MIN_VALUE;	
		dp[0][1][0] = 0;
		dp[0][1][1] = Integer.MIN_VALUE;
		dp[0][2][0] = 0;
		dp[0][2][1] = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
				dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
				dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
				dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
				dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
		}
		return dp[n - 1][2][0];
	}
	public int maxProfit2(int[] prices) {
		int n = prices.length;
		int dp_i_1_0 = 0, dp_i_1_1 = Integer.MIN_VALUE, dp_i_2_0 = 0, dp_i_2_1 = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + prices[i]);
			dp_i_1_1 = Math.max(dp_i_1_1, -prices[i]);
			dp_i_2_0 = Math.max(dp_i_2_0, dp_i_2_1 + prices[i]);
			dp_i_2_1 = Math.max(dp_i_2_1, dp_i_1_0 - prices[i]);
		}
		return dp_i_2_0;
	}
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockIII test = new BestTimeToBuyAndSellStockIII();
		int[] prices = {3, 3, 5, 0, 0, 3, 1, 4}, prices2 = {1, 2, 3, 4, 5}, prices3 = {7, 6, 4, 3, 1}, prices4 = {1};
		System.out.println(test.maxProfit2(prices));
		System.out.println(test.maxProfit2(prices2));
		System.out.println(test.maxProfit2(prices3));
		System.out.println(test.maxProfit2(prices4));
	}
}
