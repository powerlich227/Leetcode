import java.util.*;
/*
 * LeetCode 279
 * 
 * Perfect Squares
 * 
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 
Constraints:

1 <= n <= 104
 */
public class PerfectSquares {
	public int numSquares(int n) {
		while (n % 4 == 0)
			n /= 4;
		if (n % 8 == 7)
			return 4;
		for (int i = 0; i * i < n; i++) {
			int j = (int) Math.sqrt(n - i * i);
			if (i * i + j * j == n)
				return (i != 0 && j != 0) ? 2 : 1;
		}
		return 3;
	}
}
