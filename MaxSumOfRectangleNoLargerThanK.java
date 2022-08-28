import java.util.TreeSet;

/*
 * LeetCode 363 Hard
 * 
 * Max Sum of Rectangle No Larger Than K
 * 
Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.

It is guaranteed that there will be a rectangle with a sum no larger than k.

Example 1:
Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).

Example 2:
Input: matrix = [[2,2,-1]], k = 3
Output: 3
 
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-100 <= matrix[i][j] <= 100
-10^5 <= k <= 10^5
 
Follow up: What if the number of rows is much larger than the number of columns?
 */
public class MaxSumOfRectangleNoLargerThanK {
	// TreeSet
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int m = matrix.length, n = matrix[0].length;
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			int[] array = new int[n];
			for (int row = i; row >= 0; row--) {
				int sum = 0;
				TreeSet<Integer> set = new TreeSet<Integer>();
				set.add(0);
				for (int j = 0; j < n; j++) {
					array[j] += matrix[row][j];
					sum += array[j];
					Integer s = set.ceiling(sum - k);
					if (s != null)
						res = Math.max(res, sum - s);
					set.add(sum);
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		MaxSumOfRectangleNoLargerThanK test = new MaxSumOfRectangleNoLargerThanK();
		System.out.println(test.maxSumSubmatrix(new int[][] {{1,0,1},{0,-2,3}}, 2));
		System.out.println(test.maxSumSubmatrix(new int[][] {{2,2,-1}}, 3));
	}
}
