/*
 * LeetCode 461 Easy
 * 
 * Hamming Distance
 * 
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

Example 1:
Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.

Example 2:
Input: x = 3, y = 1
Output: 1
 
Constraints:

0 <= x, y <= 2^31 - 1
 */
public class HammingDistance {
    // bit manipulation: hamming weight -- # 1 bit
    // xor & (xor - 1): remove the last 1 bit
    public int hammingDistance(int x, int y) {
        int res = 0, xor = x ^ y;
        while (xor != 0) {
            xor &= xor - 1; // xor = xor & (xor - 1)
            res++;
        }
        return res;
    }
	public static void main(String[] args) {
		HammingDistance test = new HammingDistance();
		System.out.println(test.hammingDistance(1, 4));
		System.out.println(test.hammingDistance(3, 1));
	}
}
