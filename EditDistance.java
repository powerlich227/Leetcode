
public class EditDistance {
	public static void main(String[] args) {
		System.out.println();
	}
	/* two strings word1, word2
	 * min operations: insert/delete/replace, 
	 * dp 
	 * 		0 a b c d (j)
	 * 0	0 1 2 3 4
	 * b	1 1 1 2 3
	 * b	2 2 1 2 3 
	 * c	3 3 2 1 2
	 * (i)
	 * 
	 * if word1[i] = word2[j]
	 * dp[i][j] = dp[i-1][j-1]
	 * 
	 * else
	 * dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
	 */
	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			dp[i][0] = i;
		for (int j = 0; j <= n; j++)
			dp[0][j] = j;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else 
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
			}
		}
		return dp[m][n];
	}

}
