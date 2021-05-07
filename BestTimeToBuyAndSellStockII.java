/*
 * LeetCode 122 Easy
 * 
 * Best Time to Buy and Sell Stock II
 * 
You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).


Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.

Example 3:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e., max profit = 0.
 

Constraints:
1 <= prices.length <= 3 * 10^4
0 <= prices[i] <= 10^
 */
public class BestTimeToBuyAndSellStockII {
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4}, prices2 = {7,6,4,3,1}, prices3 = {1, 2, 3, 4, 5};
		BestTimeToBuyAndSellStockII test = new BestTimeToBuyAndSellStockII();
		System.out.println(test.maxProfit2(prices));
		System.out.println(test.maxProfit2(prices2));
		System.out.println(test.maxProfit2(prices3));
	}
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (prices[i] < prices[i + 1]) {
				res += prices[i + 1] - prices[i];
			}
		}
		return res;
	}
	
	// DP
	// dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
	// dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
	// dp[-1][k][0] = 0, dp[-1][k][1] = Integer.MIN_VALUE;
	// dp[i][0][0] = 0, dp[i][0][1] = Integer.MIN_VALUE;
	
	// k = positive infinity
	/* 
	 * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
	 * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i])
	 * dp[-1][0] = 0, dp[-1][1] = Integer.MIN_VALUE;
	 * 
	 * dp_i_0, dp_i_1
	 */
	public int maxProfit2(int[] prices) {
		int n = prices.length, dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
		}
		return dp_i_0;
	}
}
