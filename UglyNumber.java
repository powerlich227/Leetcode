/*
 * LeetCode 263 Easy
 * 
 * Ugly Number
 * 
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
Given an integer n, return true if n is an ugly number.

Example 1:
Input: n = 6
Output: true
Explanation: 6 = 2 × 3

Example 2:
Input: n = 8
Output: true
Explanation: 8 = 2 × 2 × 2

Example 3:
Input: n = 14
Output: false
Explanation: 14 is not ugly since it includes the prime factor 7.

Example 4:
Input: n = 1
Output: true
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 
 
Constraints:

-2^31 <= n <= 2^31 - 1
 */
public class UglyNumber {
	public static void main(String[] args) {
		UglyNumber test = new UglyNumber();
		System.out.println(test.isUgly(6));
		System.out.println(test.isUgly(8));
		System.out.println(test.isUgly(14));
		System.out.println(test.isUgly(1));
	}
	public boolean isUgly(int num) {
		if (num <= 0)
			return false;
		while (num % 2 == 0)
			num /= 2;
		while (num % 3 == 0)
			num /= 3;
		while (num % 5 == 0)
			num /= 5;
		return num == 1;
	}
}
