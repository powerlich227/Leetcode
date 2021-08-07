/*
 * LeetCode 87 Hard
 * 
 * Scramble String
 * 
 * 
 * We can scramble a string s to get a string t using the following algorithm:
If the length of the string is 1, stop.
If the length of the string is > 1, do the following:
Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
Apply step 1 recursively on each of the two substrings x and y.
Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.

Example 1:
Input: s1 = "great", s2 = "rgeat"
Output: true
Explanation: One possible scenario applied on s1 is:
"great" --> "gr/eat" // divide at random index.
"gr/eat" --> "gr/eat" // random decision is not to swap the two substrings and keep them in order.
"gr/eat" --> "g/r / e/at" // apply the same algorithm recursively on both substrings. divide at ranom index each of them.
"g/r / e/at" --> "r/g / e/at" // random decision was to swap the first substring and to keep the second substring in the same order.
"r/g / e/at" --> "r/g / e/ a/t" // again apply the algorithm recursively, divide "at" to "a/t".
"r/g / e/ a/t" --> "r/g / e/ a/t" // random decision is to keep both substrings in the same order.
The algorithm stops now and the result string is "rgeat" which is s2.
As there is one possible scenario that led s1 to be scrambled to s2, we return true.

Example 2:
Input: s1 = "abcde", s2 = "caebd"
Output: false

Example 3:
Input: s1 = "a", s2 = "a"
Output: true
 
Constraints:
s1.length == s2.length
1 <= s1.length <= 30
s1 and s2 consist of lower-case English letters.
 */
public class ScrambleString {
	
	// DP: (i...i+k = j...j+k & i+k...i+l = j+k...j+l) or (i...i+k = j+l-k...j+l & i+k...i+l = j...j+l-k)
	// dp[i][j][l] = (dp[i][j][k] && dp[i+k][j+k][l-k]) || dp[i][j+l-k][k] && dp[i+k][j][l-k]
    public boolean isScramble(String s1, String s2) {
        int m = s1.length(), n = s2.length();
//        if (m != n)
//            return false;
        if (s1.equals(s2))
            return true;

        boolean[][][] dp = new boolean[m][n][m + 1];
        for (int l = 1; l <= m; l++) { // l: length
            for (int i = 0; i <= m - l; i++) { // i: start char of s1
                for (int j = 0; j <= n - l; j++) { // j: start char of s2
                    if (l == 1)
                        dp[i][j][l] = (s1.charAt(i) == s2.charAt(j));
                    else {
                        for (int k = 1; k < l; k++) {
                            if ((dp[i][j][k] && dp[i + k][j + k][l - k]) || (dp[i][j + l - k][k] && dp[i + k][j][l - k]))
                                dp[i][j][l] = true;
                        }
                    }
                }
            }
        }
        return dp[0][0][m];
    }
	public static void main(String[] args) {
		ScrambleString test = new ScrambleString();
		System.out.println(test.isScramble("abcde", "caebd"));
		System.out.println(test.isScramble("great", "rgeat"));
	}
}
