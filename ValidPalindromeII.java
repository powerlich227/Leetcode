/*
 * LeetCode 680 Easy
 * 
 * Valid Palindrome II
 * 
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:
Input: s = "aba"
Output: true

Example 2:
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:
Input: s = "abc"
Output: false
 
Constraints:
1 <= s.length <= 10^5
s consists of lowercase English letters.
 */
public class ValidPalindromeII {
	// Two Pointers
	public boolean validPalindrome(String s) {
		int l = 0, r = s.length() - 1;
		while (l < r) {
			if(s.charAt(l) != s.charAt(r))
				return helper(s, l, r - 1) || helper(s, l + 1, r);
			l++;
			r--;
		}
		return true;
	}
	// Valid Palindrome
	public boolean helper(String s, int l, int r) {
		while (l < r) {
			if (s.charAt(l) != s.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}
}
