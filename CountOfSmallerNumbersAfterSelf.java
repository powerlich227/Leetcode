import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * LeetCode 315 Hard
 * 
 * Count of Smaller Numbers After Self
 * 
You are given an integer array nums and you have to return a new counts array. 
The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 
Example 1:
Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

Example 2:
Input: nums = [-1]
Output: [0]

Example 3:
Input: nums = [-1,-1]
Output: [0,0]
 

Constraints:
1 <= nums.length <= 10^5
-104 <= nums[i] <= 10^4
 */
public class CountOfSmallerNumbersAfterSelf {
	private Pair[] temp;
	private int[] cnt;
	
	public List<Integer> countSmaller(int[] nums) {
		int n = nums.length;
		temp = new Pair[n];
		cnt = new int[n];
		Pair[] array = new Pair[n];
		for (int i = 0; i < n; i++) {
			array[i] = new Pair(nums[i], i);
		}
		mergeSort(array, 0, n - 1);
		List<Integer> res = new ArrayList<>();
		for (int c : cnt) {
			res.add(c);
		}
		return res;
	}
	// mergeSort
	private void mergeSort(Pair[] array, int l, int r) {
		if (l == r)
			return;
		int m = l + (r - l) / 2;
		mergeSort(array, l, m);
		mergeSort(array, m + 1, r);
		
		merge(array, l, m, r);
	}
	// merge
	private void merge(Pair[] array, int l, int m, int r) {
		for (int i = l; i <= r; i++) {
			temp[i] = array[i];
		}
		int i = l, j = m + 1;
		for (int p = l; p <= r; p++) {
			if (i > m) {
				array[p] = temp[j++];
			}
			else if (j > r) {
				array[p] = temp[i++];
				cnt[array[p].idx] += j - m - 1;
			}
			else if (temp[i].val <= temp[j].val) {
				array[p] = temp[i++];
				cnt[array[p].idx] += j - m - 1;
			}
			else
				array[p] = temp[j++];
		}
	}
	
	class Pair {
		int val, idx;
		public Pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) {
		CountOfSmallerNumbersAfterSelf test = new CountOfSmallerNumbersAfterSelf();
		System.out.println(test.countSmaller(new int[] {5, 2, 6, 1}));
		System.out.println(test.countSmaller(new int[] {-1, -1}));
		System.out.println(test.countSmaller(new int[] {-1}));
	}
}
