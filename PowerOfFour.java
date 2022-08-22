/*
 * LeetCode 342 Easy
 * 
 * Power of Four
 * 
Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

Example 1:
Input: n = 16
Output: true

Example 2:
Input: n = 5
Output: false

Example 3:
Input: n = 1
Output: true
 
Constraints:
-2^31 <= n <= 2^31 - 1
 
Follow up: Could you solve it without loops/recursion?

 */
public class PowerOfFour {
	// 
	public boolean isPowerOfFour(int n) {
		while (n > 0 && n % 4 == 0)
			n /= 4;
		return n == 1;
	}
	// follow up: without loops
	// Bit Manipulation: n & (n - 1) == 0
	// 4 ^ n = 2 ^ (2n) = (2 ^ n) ^ 2
	public boolean isPowerOfFour2(int n) {
		if (n < 0)
			return false;
		int m = (int) Math.sqrt(n);
		if (m * m != n)
			return false;
		return (n & (n - 1)) == 0;
	}
	public static void main(String[] args) {
		PowerOfFour test = new PowerOfFour();
		System.out.println(test.isPowerOfFour(16));
		System.out.println(test.isPowerOfFour2(16));
		System.out.println(test.isPowerOfFour(5));
		System.out.println(test.isPowerOfFour2(5));
		System.out.println(test.isPowerOfFour(1));
		System.out.println(test.isPowerOfFour2(1));
	}
}
