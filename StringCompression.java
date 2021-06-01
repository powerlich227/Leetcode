/*
 * Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead be stored in the input character array chars. 
Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.
You must write an algorithm that uses only constant extra space.
 

Example 1:
Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

Example 2:
Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.

Example 3:
Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".

Example 4:
Input: chars = ["a","a","a","b","b","a","a"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","3","b","2","a","2"].
Explanation: The groups are "aaa", "bb", and "aa". This compresses to "a3b2a2". 
Note that each group is independent even if two groups have the same character.
 */
public class StringCompression {
	// 2 pointers
	public int compress(char[] chars) {
		int n = chars.length;
		int i = 0, cur = 0;
		while (i < n && cur < n) {
			char c = chars[i];
			int count = 0;
			while (i < n && chars[i] == c) {
				i++;
				count++;
			}
			chars[cur++] = c;
			if (count == 1)
				continue;
			for (char ch : String.valueOf(count).toCharArray())
				chars[cur++] = ch;
		}
		return cur;
	}
	public static void main(String[] args) {
		char[] chars = {'a','a','b','b','c','c','c'}, chars2 = {'a'};
		String str = "abbbbbbbbbbbb";
		String str2 = "aaabbaa";
		StringCompression test = new StringCompression();
		System.out.println(test.compress(chars));
		System.out.println(test.compress(chars2));
		System.out.println(test.compress(str.toCharArray()));
		System.out.println(test.compress(str2.toCharArray()));
	}
}
