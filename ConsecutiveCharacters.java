/*
 * LeetCode 1446 Easy
 * 
 * Consecutive Characters
 * 
The power of the string is the maximum length of a non-empty substring that contains only one unique character.
Given a string s, return the power of s.

Example 1:
Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.

Example 2:
Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.

Example 3:
Input: s = "triplepillooooow"
Output: 5

Example 4:
Input: s = "hooraaaaaaaaaaay"
Output: 11

Example 5:
Input: s = "tourist"
Output: 1
 
Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters.
 */
public class ConsecutiveCharacters {
	public int maxPower(String s) {
		int res = 1, n = s.length();
		for (int i = 1; i < n; i++) {
			int cnt = 1;
			while (i < n && s.charAt(i - 1) == s.charAt(i)) {
				cnt++;
				i++;
			}
			res = Math.max(res, cnt);
		}
		return res;
	}
	public static void main(String[] args) {
		ConsecutiveCharacters test = new ConsecutiveCharacters();
		System.out.println(test.maxPower("leetcode"));
		System.out.println(test.maxPower("abbcccddddeeeeedcba"));
		System.out.println(test.maxPower("triplepillooooow"));
		System.out.println(test.maxPower("hooraaaaaaaaaaay"));
		System.out.println(test.maxPower("tourist"));
	}
}
