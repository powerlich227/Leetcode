import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode 438 Medium
 * 
 * Find All Anagrams In a String
 * 
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 10^4
s and p consist of lowercase English letters.
 */
public class FindAllAnagramsInAString {
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		int[] hash = new int[256]; // ASCII
		
		int m = s.length(), n = p.length(), l = 0, r = 0;
		for (int i = 0; i < n; i++) {
			char c = p.charAt(i);
			hash[c]++;
		}
		while (r < m) {
			if (hash[s.charAt(r)] >= 1)
				n--;
			hash[s.charAt(r)]--;
			r++;
			
			if (n == 0)
				res.add(l);
			
			if (r - l == p.length()) {
				if (hash[s.charAt(l)] >= 0) {
					n++;
				}
				hash[s.charAt(l)]++;
				l++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String s = "cbaebabacd", s2 = "abab";
		String p = "abc", p2 = "ab";
		System.out.println(findAnagrams(s, p));
		System.out.println(findAnagrams(s2, p2));
	}

}
