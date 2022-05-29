/*
 * LeetCode 318 Medium
 * 
 * Maximum Product of Word Lengths
 * 
Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.

Example 1:
Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".

Example 2:
Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".

Example 3:
Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.
 
Constraints:
2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] consists only of lowercase English letters.

*/
public class MaximumProductOfWordLengths {
	/*
	 * Bit Manipulation
	 * 
	 * 'a' -> '1', 'b' -> '2', 'c' -> '3'...
	 */
	public int maxProduct(String[] words) {
		int n = words.length;
		int[] bitMasks = new int[n];
		
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (char c : words[i].toCharArray()) {
				int idx = c - 'a';
				bitMasks[i] |= (1 << idx); 
			}
			for (int j = 0; j < i; j++) {
				if ((bitMasks[j] & bitMasks[i]) == 0)
					res = Math.max(res, words[i].length() * words[j].length());
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String[] test1 = {"abcw","baz","foo","bar","xtfn","abcdef"};
		String[] test2 = {"a","ab","abc","d","cd","bcd","abcd"};
		String[] test3 = {"a","aa","aaa","aaaa"};
		MaximumProductOfWordLengths test = new MaximumProductOfWordLengths();
		System.out.println(test.maxProduct(test1));
		System.out.println(test.maxProduct(test2));
		System.out.println(test.maxProduct(test3));
	}

}
