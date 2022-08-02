/*
 * LeetCode 378 Medium
 * 
 * Kth Smallest Element in a Sorted Matrix
 * 
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

 
Example 1:
Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

Example 2:
Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:
n == matrix.length == matrix[i].length
1 <= n <= 300
-10^9 <= matrix[i][j] <= 10^9
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
 

Follow up:
Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
Could you solve the problem in O(n) time complexity? The solution may be too advanced for an interview but you may find reading this paper fun.
 */
public class KthSmallestElementInASortedMatrix {
	public int kthSmallest(int[][] matrix, int target) {
		int n = matrix.length;
		int l = matrix[0][0], r = matrix[n - 1][n - 1];
		while (l <= r) {
			int mid = l + (r - l) / 2;
			int cnt = helper(matrix, mid);
			if (cnt == target)
				r = mid - 1;
			else if (cnt < target)
				l = mid + 1;
			else
				r = mid - 1;
		}
		return l;
	}
	int helper(int[][] matrix, int target) {
		int n = matrix.length;
		int i = 0, j = n - 1;
		int res = 0;
		while (i < n && j >= 0) {
			if (matrix[i][j] > target) {
				j--;
			}
			else {
				res += j + 1;
				i++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		KthSmallestElementInASortedMatrix test = new KthSmallestElementInASortedMatrix();
		System.out.println(test.kthSmallest(new int[][] {{1,5,9},{10,11,13},{12,13,15}}, 8));
	}
}
