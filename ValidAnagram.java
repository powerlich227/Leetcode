/*
 * LeetCode 242 Easy
 * 
 * Valid Anagram
 * 
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
 
Constraints:

1 <= s.length, t.length <= 5 * 10^4
s and t consist of lowercase English letters.
 
Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 
 */
public class ValidAnagram {
	public static void main(String[] args) {
		ValidAnagram test = new ValidAnagram();
		System.out.println(test.isAnagram("anagram", "nagaram"));
		System.out.println(test.isAnagram("rat", "car"));
	}
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] map = new int[26];
		for (char c : s.toCharArray())
			map[c - 'a']++;
		for (char c : t.toCharArray()) {
            map[c - 'a']--;
			if (map[c - 'a'] < 0) 
				return false;
		}
        for (int i : map) {
            if (i != 0)
                return false;
        }
		return true;
	}
}
