import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * LeetCode 1044 Hard
 * 
 * Longest Duplicate Substring
 * 
Given a string s, consider all duplicated substrings: (contiguous) substrings of s that occur 2 or more times. The occurrences may overlap.
Return any duplicated substring that has the longest possible length. If s does not have a duplicated substring, the answer is "".

Example 1:
Input: s = "banana"
Output: "ana"

Example 2:
Input: s = "abcd"
Output: ""

Constraints:

2 <= s.length <= 3 * 10^4
s consists of lowercase English letters.
 */
public class LongestDuplicateSubstring {
	// Binary Search
	public String longestDupSubstring(String s) {
		String res = "";
		int n = s.length(), left = 0, right = n, m = 1000007;
		int[] power = new int[n];
		for (int i = 0; i < n; i++)
			power[i] = (i == 0) ? 1 : (power[i - 1] * 26) % m;
		while (left < right) {
			int mid = left + (right - left) / 2;
			String cur = rabinKarp(s, mid, power);
			System.out.println("mid:" + mid);
			System.out.println("cur:" + cur);
			if (cur.length() == res.length()) {
				right = mid;
			}
			else if (cur.length() < res.length())
				right = mid;
			else if (cur.length() > res.length()) {
				res = cur;
				left = mid + 1;
			}
		}

		return res;
	}
	// Rabin-Karp Algorithm
	public String rabinKarp(String s, int len, int[] power) {
		if (len == 0)
			return "";
		System.out.println("len:" + len);
		int n = s.length(), cur = 0, m = 1000007;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < len; i++)
			cur = (cur * 26 + (s.charAt(i) - 'a')) % m;
		map.put(cur, new ArrayList<>(Arrays.asList(0)));
		System.out.println(map);

		
		for (int i = len; i < n; i++) {
			cur = ((cur - power[len - 1] * (s.charAt(i - len) - 'a')) % m + m) % m;
			cur = (cur * 26 + (s.charAt(i) - 'a')) % m;
			if (!map.containsKey(cur))
				map.put(cur, new ArrayList<>(Arrays.asList(i - len + 1)));
			else {
				for (int idx : map.get(cur)) {
					String sub = s.substring(idx, idx + len);
					if (sub.equals(s.substring(i - len + 1, i + 1))) {
						return sub;
					}
				}
				map.get(cur).add(i - len + 1);
			}
				
		}
		return "";
	}
	public static void main(String[] args) {
		LongestDuplicateSubstring test = new LongestDuplicateSubstring();
		System.out.println(test.longestDupSubstring("banana"));
//		System.out.println(test.longestDupSubstring("abcd"));
	}
}
