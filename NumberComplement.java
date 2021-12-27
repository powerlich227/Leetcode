/*
 * LeetCode 476 Easy
 * 
 * Number Complement
 * 
The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.

Example 1:
Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

Example 2:
Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 
Constraints:
1 <= num < 2^31
 
Note: This question is the same as 1009: 
https://leetcode.com/problems/complement-of-base-10-integer/
 */
public class NumberComplement {
	// Bit Manipulation
	// from left to right
	public int findComplement(int num) {
		if (num == 0)
			return 1;
		boolean start = false;
		for (int i = 31; i >= 0; i--) {
			if ((num & (1 << i)) != 0)
				start = true;
			if (start)
				num ^= (1 << i);
	    }
		return num;
	}
	// from right to left
	// n << 1 = n * 2
	public int findComplement2(int num) {
		if (num == 0)
			return 1;
		int n = 0;
		while (n < num) {
			n = (n << 1) | 1;
		}
		return n - num;
	}
	public static void main(String[] args) {
		NumberComplement test = new NumberComplement();
		System.out.println(test.findComplement(7));
		System.out.println(test.findComplement2(7));
	}
}
