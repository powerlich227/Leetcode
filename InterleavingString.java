/*
 * LeetCode 97 Medium
 * 
 * Interleaving String
 * 
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

Example 1:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true

Example 2:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false

Example 3:
Input: s1 = "", s2 = "", s3 = ""
Output: true
 
Constraints:
0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1, s2, and s3 consist of lowercase English letters.
 
Follow up: Could you solve it using only O(s2.length) additional memory space?
 */
public class InterleavingString {
    
	// dp[i][j] = (dp[i - 1][j] && s1[i - 1] == s3[i - 1 + j]) || (dp[i][j - 1] && s2[j - 1] == s3[j - 1 + i]);
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1 + l2 != l3)
            return false;
        Boolean[][] dp = new Boolean[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++ ) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0) // dp[i][j] = dp[i][j-1] & s2[j-1]=s3[j-1]
                    dp[i][j] = dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
                else if (j == 0) // dp[i][j] = dp[i-1][j] & s1[i-1]=s3[i-1]
                    dp[i][j] = dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i - 1));
                else // dp[i][j] = dp[i-1][j] & s1[i-1]=s3[i-1+j] || dp[i][j-1] & s2[j-1]=s3[j-1+i]
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1 + j)) 
                    || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1 + i));
            }
        }
        return dp[l1][l2];
    }
	public static void main(String[] args) {
		InterleavingString test = new InterleavingString();
		System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(test.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
		System.out.println(test.isInterleave("", "", ""));
	}
}
