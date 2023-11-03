import java.util.Arrays;

//Given an integer array nums, return the number of longest increasing subsequences.

//Notice that the sequence has to be strictly increasing.

//Example 1:
//Input: nums = [1,3,5,4,7]
//Output: 2
//Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].


//Example 2:
//Input: nums = [2,2,2,2,2]
//Output: 5
//Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
// 
//
//Constraints:
//
//1 <= nums.length <= 2000
//-106 <= nums[i] <= 106


public class NumberOfLongestIncreasingSubsequence {
    // based on Q 300: Longest Increasing Subsequence
	//
    // dp[i]: length of LIS end with nums[i]
    // cnt[i]: count of LIS end with nums[i]
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n], cnt = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] == dp[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                    else if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
        }
        int max = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (max == dp[i]) {
                res += cnt[i];
            }
            else if (max < dp[i]) {
                max = dp[i];
                res = cnt[i];
            }
        }
        return res;
    }
	public static void main(String[] args) {
		int[] test1 = new int[] {1,3,5,4,7}, test2 = new int[] {2,2,2,2,2};
		NumberOfLongestIncreasingSubsequence test = new NumberOfLongestIncreasingSubsequence();
		System.out.println(test.findNumberOfLIS(test1));
		System.out.println(test.findNumberOfLIS(test2));
		// TODO Auto-generated method stub

	}
}
