/*
 * LeetCode 28 Easy
 * 
 * Implement strStr()
 * 
Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:
What should we return when needle is an empty string? This is a great question to ask during an interview.
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

Example 1:
Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:
Input: haystack = "aaaaa", needle = "bba"
Output: -1

Example 3:
Input: haystack = "", needle = ""
Output: 0
 
Constraints:
0 <= haystack.length, needle.length <= 5 * 10^4
haystack and needle consist of only lower-case English characters.
 */
public class ImplementstrStr {
	public static void main(String[] args) {
		ImplementstrStr test = new ImplementstrStr();
		System.out.println(test.strStr("hello", "ll"));
		System.out.println(test.strStr("aaaaa", "bba"));
		System.out.println(test.strStr("", ""));
	}
	// String Matching
	// Two Pointers:
	// i: index of haystack
	// j: index of needle
    public int strStr(String haystack, String needle) {
    	int m = haystack.length(), n = needle.length();
    	if (m < n)
    		return -1;    	
    	for (int i = 0; i <= m - n; i++) {
    		int j = 0;
    		for (; j < n; j++) {
    			if (haystack.charAt(i + j) != needle.charAt(j))
    				break;
    		}
    		if (j == n)
    			return i;
    	}   	
    	if (needle.isEmpty())
    		return 0;
    	return -1;
    }
}
