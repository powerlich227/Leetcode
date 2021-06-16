import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode 386 Medium
 * 
 * Lexicographical Numbers
 * 
Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

 
Example 1:
Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

Example 2:
Input: n = 2
Output: [1,2]
 

Constraints:
1 <= n <= 5 * 10^4
 */
public class LexicographicalNumbers {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<>();
		int cur = 1;
		for (int i = 0; i < n; i++) {
			res.add(cur);
			if (cur * 10 <= n)
				cur *= 10;
			else {
				if (cur >= n) {
					cur /= 10;
				}
				cur++;
				while (cur % 10 == 0) {
					cur /= 10;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		LexicographicalNumbers test = new LexicographicalNumbers();
		System.out.println(test.lexicalOrder(13));
		System.out.println(test.lexicalOrder(2));
	}
}
