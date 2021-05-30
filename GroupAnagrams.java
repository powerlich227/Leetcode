import java.util.*;
/*
 * LeetCode 49 Medium
 * 
 * Group Anagrams
 * 
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 
Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]
 

Constraints:
1 <= strs.length <= 10^4
0 <= strs[i].length <= 100
strs[i] consists of lower-case English letters.
 */
public class GroupAnagrams {
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"}, strs2 = {""}, strs3 = {"a"};
		System.out.println(groupAnagrams(strs));
		System.out.println(groupAnagrams(strs2));
		System.out.println(groupAnagrams(strs3));
	}
	// sort
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String key = String.valueOf(ch);
			if (!map.containsKey(key)) 
				map.put(key, new ArrayList<>());
			map.get(key).add(str);
		}
		return new ArrayList<>(map.values());
	}
}
