/*
 * LeetCode 1015 Medium
 * 
 * Smallest Integer Divisible by K
 * 
Given a positive integer k, you need to find the length of the smallest positive integer n such that n is divisible by k, and n only contains the digit 1.
Return the length of n. If there is no such n, return -1.

Note: n may not fit in a 64-bit signed integer.

Example 1:
Input: k = 1
Output: 1
Explanation: The smallest answer is n = 1, which has length 1.

Example 2:
Input: k = 2
Output: -1
Explanation: There is no such positive integer n divisible by 2.

Example 3:
Input: k = 3
Output: 3
Explanation: The smallest answer is n = 111, which has length 3.
 

Constraints:
1 <= k <= 10^5
 */
public class SmallestIntegerDivisibleByK {
	//Math
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0)
        	return -1;
        int remain = 0;
        for (int i = 1; i <= k; i++) {
        	remain = (remain * 10 + 1) % k;
        	if (remain == 0)
        		return i;
        }
        return -1;
    }
	public static void main(String[] args) {
		SmallestIntegerDivisibleByK test = new SmallestIntegerDivisibleByK();
		System.out.println(test.smallestRepunitDivByK(1));
		System.out.println(test.smallestRepunitDivByK(2));
		System.out.println(test.smallestRepunitDivByK(3));
		System.out.println(test.smallestRepunitDivByK(7));
	}
}
