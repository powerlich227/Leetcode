/*
 * LeetCode 309 Medium
 * 
 * Best Time To Buy and Sell Stock with Cooldown
 * 
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like 
(i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 
Example 1:
Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]

Example 2:
Input: prices = [1]
Output: 0
 

Constraints:
1 <= prices.length <= 5000
0 <= prices[i] <= 1000
 */
public class BestTimeToBuyAndSellStockWithCooldown {
	// DP
	// dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
	// dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
	// dp[-1][k][0] = 0, dp[-1][k][1] = Integer.MIN_VALUE;
	// dp[i][0][0] = 0, dp[i][0][1] = Integer.MIN_VALUE;
	
	// k = positive infinity, i with cooldown
	/* 
	 * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
	 * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i])
	 * dp[-1][0] = 0, dp[-1][1] = Integer.MIN_VALUE;
	 * 
	 * dp_i_0, dp_i_1
	 */
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE, dp_pre_0 = 0;
		for (int i = 0; i < n; i++) {
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
			dp_pre_0 = temp;
		}
		return dp_i_0;
	}
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 0, 2}, prices2 = {1};
		BestTimeToBuyAndSellStockWithCooldown test = new BestTimeToBuyAndSellStockWithCooldown();
		System.out.println(test.maxProfit(prices));
		System.out.println(test.maxProfit(prices2));
	}
}
