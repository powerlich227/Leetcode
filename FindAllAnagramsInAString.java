import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * LeetCode 438 Medium
 * 
 * Find All Anagrams In a String
 * 
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

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
    // Sliding Window
    public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		HashMap<Character, Integer> mapS = new HashMap<>();
		HashMap<Character, Integer> mapT = new HashMap<>();
		int m = s.length(), n = p.length();
        int left = 0, right = 0, valid = 0;
		for (char c : p.toCharArray()) {
			mapT.put(c, mapT.getOrDefault(c, 0) + 1);
		}
		while (right < m) {
			char r = s.charAt(right);
			mapS.put(r, mapS.getOrDefault(r, 0) + 1);
			if (mapS.get(r).equals(mapT.get(r)))
				valid++;
			right++;
			
			while (right - left >= n) {
				if (valid == mapT.size())
					res.add(left);
				char l = s.charAt(left);
				if (mapT.containsKey(l)) {
					if (mapS.get(l).equals(mapT.get(l)))
						valid--;
					mapS.put(l, mapS.get(l) - 1);
				}
				left++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		FindAllAnagramsInAString test = new FindAllAnagramsInAString();
		String s = "cbaebabacd", s2 = "abab";
		String p = "abc", p2 = "ab";
		System.out.println(test.findAnagrams(s, p));
		System.out.println(test.findAnagrams(s2, p2));
	}
}
