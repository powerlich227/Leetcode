import java.util.Arrays;

/* LeetCode 322 Medium
 *
 * Coin Change
 * 
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

Example 4:
Input: coins = [1], amount = 1
Output: 1

Example 5:
Input: coins = [1], amount = 2
Output: 2
 */
public class CoinChange {
	// DP recursion with memo
	public int coinChange(int[] coins, int amount) {
		int[] memo = new int[amount + 1];
		Arrays.fill(memo, amount + 1);
		return helper(coins, amount, memo);
	}
	public int helper(int[] coins, int amount, int[] memo) {
		if (amount < 0)
			return -1;
		if (amount == 0)
			return 0;
		if (memo[amount] < amount + 1)
			return memo[amount];
		for (int coin : coins) {
			int temp = helper(coins, amount - coin, memo);
			if (temp < 0)
				continue;
			memo[amount] = Math.min(memo[amount], temp + 1);
		}
		return (memo[amount] == amount + 1) ? -1 : memo[amount];
	}
	// DP iteration
	// DP[i]: # of coins in i amount of money	
	// DP[i] = min (DP[i], DP[i - coin]
	public int coinChange2(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (coin <= i)
					dp[i] = Math.min(dp[i - coin] + 1, dp[i]); 
			}
		}
		return (dp[amount] > amount) ? -1 : dp[amount];
	}
	public static void main(String[] args) {
		CoinChange test = new CoinChange();
		int[] coins = {1, 2, 5}, coins2 = {2}, coins3 = {1};
		int amount = 11, amount2 = 3, amount3 = 0;
		System.out.println(test.coinChange(coins, amount));
		System.out.println(test.coinChange(coins2, amount2));
		System.out.println(test.coinChange(coins3, amount3));
	}
}
