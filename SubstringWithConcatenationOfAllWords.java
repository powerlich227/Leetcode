import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * LeetCode 30 Hard
 * 
 * Substring with Concatenation of All Words
 * 
You are given a string s and an array of strings words of the same length. 
Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, 
in any order, and without any intervening characters.

You can return the answer in any order.

Example 1:
Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.

Example 2:
Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []

Example 3:
Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
 
Constraints:
1 <= s.length <= 10^4
1 <= words.length <= 5000
1 <= words[i].length <= 30
s and words[i] consist of lowercase English letters.
 */
public class SubstringWithConcatenationOfAllWords {
	private HashMap<String, Integer> map;
	
	public List<Integer> findSubstring(String s, String[] words) {
		map = new HashMap<>();
		for (String word : words)
			map.put(word, map.getOrDefault(word, 0) + 1);
		
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i <= s.length() - words.length * words[0].length(); i++) {
			if (helper(s, words, i))
				res.add(i);
		}
		return res;
	}
	boolean helper(String s, String[] words, int i) {
		int n = words.length, l = words[0].length();
		HashMap<String, Integer> map2 = new HashMap<>(map);
		
		int cnt = 0;
		for (int j = i; j < i + n * l; j += l) {
			String sub = s.substring(j, j + l);
			if (map2.getOrDefault(sub, 0) == 0)
				break;
			cnt++;
			map2.put(sub, map2.get(sub) - 1);
		}
		
		return cnt == n;
	}
	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords test = new SubstringWithConcatenationOfAllWords();
		System.out.println(test.findSubstring("barfoothefoobarman", new String[] {"foo","bar"}));
		System.out.println(test.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","word"}));
		System.out.println(test.findSubstring("barfoofoobarthefoobarman", new String[] {"bar","foo","the"}));
	}
}
