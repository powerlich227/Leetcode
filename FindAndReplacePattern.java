import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * LeetCode 890 Medium
 * 
 * Find and Replace Pattern
 * 
Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), 
we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: 
every letter maps to another letter, and no two letters map to the same letter.

Example 1:
Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.

Example 2:
Input: words = ["a","b","c"], pattern = "a"
Output: ["a","b","c"]
 
Constraints:
1 <= pattern.length <= 20
1 <= words.length <= 50
words[i].length == pattern.length
pattern and words[i] are lowercase English letters. 
 */
public class FindAndReplacePattern {
	// HashMap
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> res = new ArrayList<>();
		for (String word : words) {
			if (match(word, pattern))
				res.add(word);
		}
		return res;
	}
	boolean match(String word, String pattern) {
		HashMap<Character, Character> mapW = new HashMap<>();
		HashMap<Character, Character> mapP = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			char w = word.charAt(i);
			char p = pattern.charAt(i);
			if (!mapW.containsKey(w))
				mapW.put(w, p);
			if (!mapP.containsKey(p))
				mapP.put(p, w);
			if (mapW.get(w) != p || mapP.get(p) != w)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		FindAndReplacePattern test = new FindAndReplacePattern();
		System.out.println(test.findAndReplacePattern(new String[] {"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
		System.out.println(test.findAndReplacePattern(new String[] {"a","b","c"}, "a"));
	}
}
