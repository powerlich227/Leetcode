/*
 * LeetCode 714 Medium
 * 
 * Best Time to Buy and Sell Stock with Transaction Fee
 * 
You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 
Example 1:
Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.

Example 2:
Input: prices = [1,3,7,5,10,3], fee = 3
Output: 6
 

Constraints:
1 <= prices.length <= 5 * 10^4
1 <= prices[i] < 5 * 10^4
0 <= fee < 5 * 10^4
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
	// DP
	// dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
	// dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
	// dp[-1][k][0] = 0, dp[-1][k][1] = Integer.MIN_VALUE;
	// dp[i][0][0] = 0, dp[i][0][1] = Integer.MIN_VALUE;
	
	// k = positive infinity, transaction fee
	/* 
	 * dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i])
	 * dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee)
	 * dp[-1][0] = 0, dp[-1][1] = Integer.MIN_VALUE;
	 * 
	 * dp_i_0, dp_i_1
	 */
	public int maxProfit(int[] prices, int fee) {
		int n = prices.length;
		int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
			dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i] - fee);
		}
		return dp_i_0;
	}
	public static void main(String[] args) {
		int[] prices = {1, 3, 2, 8, 4, 9}, prices2 = {1, 3, 7, 5, 10, 3};
		int fee = 2, fee2 = 3;
		BestTimeToBuyAndSellStockWithTransactionFee test = new BestTimeToBuyAndSellStockWithTransactionFee();
		System.out.println(test.maxProfit(prices, fee));
		System.out.println(test.maxProfit(prices2, fee2));
	}

}
