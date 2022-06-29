import java.util.Arrays;

/*
 * LeetCode 1647 Medium
 * 
 * Minimum Deletions to Make Character Frequencies Uniques
 * 
 * 
A string s is called good if there are no two different characters in s that have the same frequency.
Given a string s, return the minimum number of characters you need to delete to make s good.
The frequency of a character in a string is the number of times it appears in the string. 

For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.

Example 1:
Input: s = "aab"
Output: 0
Explanation: s is already good.

Example 2:
Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".

Example 3:
Input: s = "ceabaacb"
Output: 2
Explanation: You can delete both 'c's resulting in the good string "eabaab".
Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
 

Constraints:
1 <= s.length <= 10^5
s contains only lowercase English letters.
 */
public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
	// Greedy & Sorting
	public int minDeletions(String s) {
		int[] freq = new int[26];
		for (char c : s.toCharArray())
			freq[c - 'a']++;
		Arrays.sort(freq);
		
		int res = 0, max = s.length();
		for (int i = 25; i >= 0; i--) {
			if (freq[i] > max) {
				res += freq[i] - max;
				freq[i] = max;
			}
			max = Math.max(0, freq[i] - 1);
		}
		return res;
	}
	public static void main(String[] args) {
		MinimumDeletionsToMakeCharacterFrequenciesUnique test = new MinimumDeletionsToMakeCharacterFrequenciesUnique();
		System.out.println(test.minDeletions("aab"));
		System.out.println(test.minDeletions("aaabbbcc"));
		System.out.println(test.minDeletions("ceabaacb"));
	}
}
