import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode 131 Medium
 * 
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]
 
Constraints:
1 <= s.length <= 16
s contains only lowercase English letters.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> res = new ArrayList<>();
        List<String> out = new ArrayList<>();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) { // i: end
            for (int j = 0; j <= i; j++) { // j: start
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1]))
                    dp[j][i] = true;
            }
        }
        dFS(s, 0, out, dp, res);
        return res;
    }
    public void dFS(String s, int start, List<String> out, boolean[][] dp, List<List<String>> res) {
        if (start >= s.length())
            res.add(new ArrayList<>(out));
        for (int i = start; i < s.length(); i++) { // i: end
            if (dp[start][i]) {
                out.add(s.substring(start, i + 1));
                dFS(s, i + 1, out, dp, res);
                out.remove(out.size() - 1);
            }
        }
    }
	public static void main(String[] args) {
		PalindromePartitioning test = new PalindromePartitioning();
		System.out.println(test.partition("abbab"));
	}
}
