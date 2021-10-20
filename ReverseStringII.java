/*
 * LeetCode 541 Easy
 * 
 * Reverse String II
 * 
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. 
If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.

Example 1:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"

Example 2:
Input: s = "abcd", k = 2
Output: "bacd"
 
Constraints:

1 <= s.length <= 10^4
s consists of only lowercase English letters.
1 <= k <= 10^4
 */
public class ReverseStringII {
	// Two Pointers
	public String reverseStr(String s, int k) {
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i += 2 * k) {
			int left = i, right = Math.min(i + k - 1, c.length - 1);
			while (left < right) {
				char temp = c[left];
				c[left++] = c[right];
				c[right--] = temp;
			}
		}
		return new String(c);
	}
	public static void main(String[] args) {
		ReverseStringII test = new ReverseStringII();
		System.out.println(test.reverseStr("abcdefg", 2));
		System.out.println(test.reverseStr("abcd", 2));
	}
}
