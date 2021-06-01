import java.util.HashMap;

/*
 * LeetCode 387 Easy
 * 
 * First Unique Character in a String
 * 
Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1.

 
Example 1:
Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 10^5
s consists of only lowercase English letters.
 */
public class FirstUniqueCharacterInAString {
	public int firstUniqChar(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (int i = 0; i < n; i++) {
			if (map.get(s.charAt(i)) == 1) {
				return i;
			}
		}	
		return -1;
	}
	public static void main(String[] args) {
		FirstUniqueCharacterInAString test = new FirstUniqueCharacterInAString();
		System.out.println(test.firstUniqChar("leetcode"));
		System.out.println(test.firstUniqChar("loveleetcode"));
		System.out.println(test.firstUniqChar("aabb"));
	}

}
