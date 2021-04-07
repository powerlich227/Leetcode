/*
 * LeetCode 44
 * 
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:
Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

Example 4:
Input: s = "adceb", p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".

Example 5:
Input: s = "acdcb", p = "a*c?b"
Output: false
 
Constraints:
0 <= s.length, p.length <= 2000
s contains only lowercase English letters.
p contains only lowercase English letters, '?' or '*'.
 */
public class WildcardMatch {
	public static boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		int i = 0, j = 0;
		int iStar = -1, jStar = -1;
		while (i < m) {
			if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
				i++;
				j++;
			}
			else if (j < n && p.charAt(j) == '*') {
				iStar = i;
				jStar = j++;
			}
			else if (iStar != -1) {
				i = ++iStar;
				j = jStar + 1;
			}
			else 
				return false;
		}
		while (j < n && p.charAt(j) == '*')
			j++;
		return j == n;
	}
	public static void main(String[] args) {
		String s = "aa", p = "a";
		String s2 = "aa", p2 = "*";
		String s3 = "cb", p3 = "?a";
		String s4 = "adceb", p4 = "a*b";
		String s5 = "acdcb", p5 = "a*c?b";
		System.out.println(isMatch(s, p));
		System.out.println(isMatch(s2, p2));
		System.out.println(isMatch(s3, p3));
		System.out.println(isMatch(s4, p4));
		System.out.println(isMatch(s5, p5));
	}
}
