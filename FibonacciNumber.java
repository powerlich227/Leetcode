/*
 * LeetCode 509 Easy
 * 
 * Fibonacci Number
 * 
 * 
 */
public class FibonacciNumber {
	// Recursion
	public int fib(int n) {
		int[] memo = new int[n + 1];
		return helper(n, memo);
	}
	public int helper(int n, int[] memo) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		if (memo[n] != 0)
			return memo[n];
		memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
		return memo[n];
	}
	// Iteration
	public int fib2(int n) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		int[] dp = new int[n + 1];
		dp[1] = 1; 
		dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
	// Optimized Iteration
	public int fib3(int n) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		int pre = 1, cur = 1;
		for (int i = 3; i <= n; i++) {
			int sum = pre + cur;
			pre = cur;
			cur = sum;
		}
		return cur;
	}
	public static void main(String[] args) {
		FibonacciNumber test = new FibonacciNumber();
		System.out.println(test.fib3(10));
	}
}
