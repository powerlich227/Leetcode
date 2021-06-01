/*
 * LeetCode 344 Easy
 * 
 * Reverse String
 * 
Write a function that reverses a string. The input string is given as an array of characters s.

 
Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 

Constraints:
1 <= s.length <= 10^5
s[i] is a printable ascii character.
 

Follow up: Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {
	public void reverseString(char[] s) {
		int n = s.length;
		int i = 0, j = n - 1;
		while (i < j) {
			char ci = s[i], cj = s[j];
			s[i++] = cj;
			s[j--] = ci;
		}
	}
	public static void main(String[] args) {
		ReverseString test = new ReverseString();
		char[] s = "hello".toCharArray();
		char[] s2 = "Hannah".toCharArray();
		test.reverseString(s);
		test.reverseString(s2);
		System.out.println(new String(s));
		System.out.println(new String(s2));
	}
}
