
public class LongestValidParentheses {
	public static void main(String[] args) {
		System.out.println();
	}
	/*
	 *  DP
	 *  1. dp[i] = dp[i-2] + 2
	 *  2. dp[i] = dp[i-dp[i-1]-2] + dp[i-1] + 2
	 */
	public int longestValidParentheses(String s) {
		int res = 0, n = s.length();
		int[] dp = new int[n];
		for (int i = 1; i < n; i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(')
					dp[i] = (i > 1 ? dp[i - 2] : 0) + 2;
				else if (i > dp[i - 1] && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = (i > dp[i - 1] + 1 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
				}
				res = Math.max(res, dp[i]);
			}				
		}
		return res;
	}
}
