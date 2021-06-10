import java.util.LinkedList;
import java.util.List;

/*
 * LeetCode 969 Medium
 * 
 * Pancake Sorting
 * 
Given an array of integers arr, sort the array by performing a series of pancake flips.
In one pancake flip we do the following steps:

Choose an integer k where 1 <= k <= arr.length.
Reverse the sub-array arr[0...k-1] (0-indexed).
For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3, 
we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the pancake flip at k = 3.

Return an array of the k-values corresponding to a sequence of pancake flips that sort arr. 
Any valid answer that sorts the array within 10 * arr.length flips will be judged as correct.

 
Example 1:
Input: arr = [3,2,4,1]
Output: [4,2,4,3]
Explanation: 
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: arr = [3, 2, 4, 1]
After 1st flip (k = 4): arr = [1, 4, 2, 3]
After 2nd flip (k = 2): arr = [4, 1, 2, 3]
After 3rd flip (k = 4): arr = [3, 2, 1, 4]
After 4th flip (k = 3): arr = [1, 2, 3, 4], which is sorted.

Example 2:
Input: arr = [1,2,3]
Output: []
Explanation: The input is already sorted, so there is no need to flip anything.
Note that other answers, such as [3, 3], would also be accepted.
 

Constraints:
1 <= arr.length <= 100
1 <= arr[i] <= arr.length
All integers in arr are unique (i.e. arr is a permutation of the integers from 1 to arr.length).
 */
public class PancakeSorting {
	// Recursion
	// 1 sort(arr, n);
	// 1.1 reverse(arr, 0, maxIndex) max...
	// 1.2 reverse(arr, 0, n-1) ...max
	// 3. sort(arr, n-1)
	List<Integer> res = new LinkedList<>();
	public List<Integer> pancakeSort(int[] arr) {
		sort(arr, arr.length);
		return res;
	}
	public void sort(int[] cakes, int n) {
		if (n == 1)
			return;
		int max = 0;
		int maxIndex = 0;
		for (int i = 0; i < n; i++) {
			if (cakes[i] > max) {
				max = cakes[i];
				maxIndex = i;
			}
		}
		reverse(cakes, 0, maxIndex);
		res.add(maxIndex + 1);
		reverse(cakes, 0, n - 1);
		res.add(n);
		sort(cakes, n - 1);
	}
	public void reverse(int[] cakes, int i, int j) {
		while (i < j) {
			int temp = cakes[i];
			cakes[i] = cakes[j];
			cakes[j] = temp;
			i++;
			j--;
		}
	}
	public static void main(String[] args) {
		int[] arr = {3, 2, 4, 1}, arr2 = {1, 2, 3};
		PancakeSorting test = new PancakeSorting();
		System.out.println(test.pancakeSort(arr));
		System.out.println(test.pancakeSort(arr2));
	}

}
