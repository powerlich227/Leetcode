/*
 * LeetCode 394 Medium
 * 
 * Decode String
 * 
 * Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. 
For example, there won't be input like 3a or 2[4].

Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

Example 4:
Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
 */
public class DecodeString {
	public static String decodeString(String s) {
		StringBuilder res = new StringBuilder();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int cnt = 0;
				while (Character.isDigit(s.charAt(i))) {
					cnt = cnt * 10 + s.charAt(i) - '0';
					i++; 
				} // i: index of '['
				int start = ++i; // index of char after '[' 
				int num = 1;
				while (num > 0) { // find the matching ']'
					if (s.charAt(i) == ']')
						num--;
					else if (s.charAt(i) == '[')
						num++;
					i++; // index of char after ']'
				}
				i--;  // index of ']'
				String str = decodeString(s.substring(start, i));
				for (int j = 0; j < cnt; j++) {
					res.append(str);
				}
			}
			else 
				res.append(c);
		}
		return res.toString();	
	}
	
	public static void main(String[] args) {
		String s = "3[a]2[bc]", s2 = "3[a2[c]]", s3 = "2[abc]3[cd]ef", s4 = "abc3[cd]xyz";
		System.out.println(decodeString(s));
		System.out.println(decodeString(s2));
		System.out.println(decodeString(s3));
		System.out.println(decodeString(s4));
	}

}
