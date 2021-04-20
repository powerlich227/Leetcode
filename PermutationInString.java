/*
 * LeetCode 567 Medium
 * 
 * Permutation in String
 * 
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
 * In other words, one of the first string's permutations is the substring of the second string.

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 
Constraints:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
 */
public class PermutationInString {
	public static boolean checkInclusion(String s1, String s2) {
		int[] hash = new int[128];
		
		int m = s1.length(), n = s2.length();
		for (int i = 0; i < m; i++) {
			char c = s1.charAt(i);
			hash[c]++;
		}
		int l = 0, r = 0;
		while (r < n) {
			char c = s2.charAt(r);
			r++;
			
			if (hash[c]-- >= 1)
				m--;
			if (m == 0)
				return true;

			System.out.printf("window: [%d, %d)\n", l, r);
			while (r - l >= s1.length()) {
				char c2 = s2.charAt(l);
				l++;
				if (hash[c2]++ >=0)
					m++;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		String s1 = "ab", s2 = "eidbaooo";
		String s1_2 = "ab", s2_2 = "eidboaoo";
		System.out.println(checkInclusion(s1, s2));
		System.out.println(checkInclusion(s1_2, s2_2));
	}

}
