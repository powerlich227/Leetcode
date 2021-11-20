/*
 * LeetCode 477 Medium
 * 
 * Total Hamming Distance
 * 
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.

Example 1:
Input: nums = [4,14,2]
Output: 6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

Example 2:
Input: nums = [4,14,4]
Output: 4
 
Constraints:
1 <= nums.length <= 10^4
0 <= nums[i] <= 10^9
The answer for the given input will fit in a 32-bit integer.
 */
public class TotalHammingDistance {
    // Bit Manipulation: Hamming Weight
	// num & (1 << i) count of 1 bit
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                if ((num & (1 << i)) == 0)
                    cnt++;
            }
            res += (n - cnt) * cnt;
        }
        return res;
    }
	public static void main(String[] args) {
		TotalHammingDistance test = new TotalHammingDistance();
		System.out.println(test.totalHammingDistance(new int[] {4, 14, 2}));
		System.out.println(test.totalHammingDistance(new int[] {4, 14, 4}));
	}
}
