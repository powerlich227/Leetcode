import java.util.HashMap;

/*
 * LeetCode 383 Easy
 * 
 * Ransom Note
 * 
Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.


Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

1 <= ransomNote.length, magazine.length <= 10^5
ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote {
	// hash-array
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (char c : magazine.toCharArray())
            map[c - 'a']++;
        for (char c : ransomNote.toCharArray()) {
            map[c - 'a']--;
            if (map[c - 'a'] < 0)
                return false;
        }
        return true;
    }
    // hashmap
    public boolean canConstruct2(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : ransomNote.toCharArray()) {
        	map.put(c, map.getOrDefault(c, 0) - 1);
        	if (map.get(c) < 0)
        		return false;
        }
        return true;
    }
	public static void main(String[] args) {
		RansomNote test = new RansomNote();
		System.out.println(test.canConstruct("s", "b"));
		System.out.println(test.canConstruct("aa", "ab"));
		System.out.println(test.canConstruct("aa", "aab"));
		System.out.println(test.canConstruct2("s", "b"));
		System.out.println(test.canConstruct2("aa", "ab"));
		System.out.println(test.canConstruct2("aa", "aab"));
	}
}
