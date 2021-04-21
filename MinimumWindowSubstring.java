import java.util.HashMap;
/*
 * LeetCode 76 Hard
 * 
 * Minimum Window Substring
 * 
Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"

Example 2:
Input: s = "a", t = "a"
Output: "a"
 
Constraints:

1 <= s.length, t.length <= 105
s and t consist of English letters.

Follow up: Could you find an algorithm that runs in O(n) time?
 */
public class MinimumWindowSubstring {
	public static void main(String[] args) {
		String s = "ADOBECODEBANC", t = "ABC";
		System.out.println(minWindow(s, t));
	}
	public static String minWindow(String s, String t) {
		String res = "";
		int m = s.length(), n = t.length();
		HashMap<Character, Integer> hash = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			char c = t.charAt(i);
			hash.put(c, hash.getOrDefault(c, 0) + 1);
		}
		
		int l = 0, r = 0, width = Integer.MAX_VALUE;
		while (r < m) {
			char c = s.charAt(r);
			r++;
			
			if (hash.containsKey(c)) {
				hash.put(c, hash.get(c) - 1);
				if (hash.get(c) >= 0)
					n--;                
			}
			while (n == 0) {
				if (width > r - l + 1) {
					width = r - l + 1;
					res = s.substring(l, r);
				}
				
				char c2 = s.charAt(l);
				l++;

				if (hash.containsKey(c2) ) {
					hash.put(c2, hash.get(c2) + 1);
					if (hash.get(c2) >= 1)
						n++;
				}
			}
		}
		return res;
	}
}
