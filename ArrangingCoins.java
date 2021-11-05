/*
 * LeetCode 441 Easy
 * 
 * Arranging Coins
 * 
You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. 
The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

Example 1:
Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.

Example 2:
Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.
 

Constraints:

1 <= n <= 2^31 - 1
 */
public class ArrangingCoins {
	// binary search
    public int arrangeCoins(int n) {
    	long left = 1, right = n;
    	while (left <= right) {
    		long mid = left + (right - left) / 2;
    		long coins = (1 + mid) * mid / 2;
    		if (coins == n)
    			return (int) mid;
    		else if (coins < n)
    			left = mid + 1;
    		else if (coins > n)
    			right = mid - 1;
    	}
        return (int) right;
    }
	public static void main(String[] args) {
		ArrangingCoins test = new ArrangingCoins();
		System.out.println(test.arrangeCoins(1));
		System.out.println(test.arrangeCoins(2));
		System.out.println(test.arrangeCoins(3));
		System.out.println(test.arrangeCoins(5));
		System.out.println(test.arrangeCoins(8));
	}
}
