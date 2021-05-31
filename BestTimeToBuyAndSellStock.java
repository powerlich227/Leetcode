/*
 * LeetCode 121 Easy
 * 
 * Best Time to Buy and Sell Stock
 * 
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:
1 <= prices.length <= 10^5
0 <= prices[i] <= 10^4
 */
public class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4}, prices2 = {7,6,4,3,1};
		BestTimeToBuyAndSellStock test = new BestTimeToBuyAndSellStock();
		System.out.println(test.maxProfit2(prices));
		System.out.println(test.maxProfit2(prices2));
	}
	public int maxProfit(int[] prices) {
		int res = 0;
		int minBuy = Integer.MAX_VALUE;
		for (int price : prices) {
			minBuy = Math.min(minBuy, price);
			res = Math.max(res, price - minBuy);
		}
		return res;
	}
	
	// DP
	// dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
	// dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
	// base cases:
	// dp[-1][k][0] = 0, dp[-1][k][1] = Integer.MIN_VALUE;
	// dp[i][0][0] = 0, dp[i][0][1] = Integer.MIN_VALUE;
	
	// k = 1
	/* 
	 * dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i])
	 * dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i-1][0][0] - prices[i]) // dp[i-1][0][0] = 0
	 * 
	 * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
	 * dp[i][1] = Math.max(dp[i - 1][1], - prices[i])
	 * base cases:
	 * dp[-1][0] = 0, dp[-1][1] = Integer.MIN_VALUE;
	 * 
	 * to save the memory
	 * dp_i_0, dp_i_1
	 */
	public int maxProfit2(int[] prices) {
		int n = prices.length, dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, -prices[i]);
		}
		return dp_i_0;
	}
}
