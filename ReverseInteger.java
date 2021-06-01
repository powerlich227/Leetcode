/*
 * LeetCode 7 Easy
 * 
 * Reverse Integer
 * 
Given a signed 32-bit integer x, return x with its digits reversed. 
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0
 

Constraints:
-2^31 <= x <= 2^31 - 1
 */
public class ReverseInteger {
	public int reverse(int x) {
		int res = 0;
		while (x != 0) {
			if (Math.abs(x) > Integer.MAX_VALUE / 10)
				return 0;
			res = res * 10 + x % 10;
			x /= 10;
		}
		return res;
	} 
	public static void main(String[] args) {
		ReverseInteger test = new ReverseInteger();
		System.out.println(test.reverse(123));
		System.out.println(test.reverse(-123));
		System.out.println(test.reverse(120));
		System.out.println(test.reverse(0));
	}

}
