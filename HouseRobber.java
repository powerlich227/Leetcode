
public class HouseRobber {
	public static void main(String[] args) {
		System.out.println();
	}
	/*
	 * dp[i] = max(dp[i-2]+nums[i], dp[i-1])
	 */
	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 1) // n >= 1
			return nums[0];
		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		if (n > 2) {
			for (int i = 2; i < n; i++)
				dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[n - 1];
	}
}
