import java.util.Arrays;
import java.util.LinkedList;

/*
 * LeetCode 56 Medium
 * 
 * Merge Intervals
 * 
Given an array of intervals where intervals[i] = [starti, endi], 
merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 
Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:
1 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^4
 */

public class MergeIntervals {
	public static void main(String[] args) {
		int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}}, intervals2 = {{1, 4}, {4, 5}};
		MergeIntervals test = new MergeIntervals();
		System.out.println(Arrays.deepToString(test.merge(intervals)));
		System.out.println(Arrays.deepToString(test.merge(intervals2)));
	}
	public int[][] merge(int[][] intervals) {
//		if (intervals.length == 0)
//			return intervals;
		LinkedList<int[]> res = new LinkedList<>(); 
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		for (int[] interval : intervals) {
			if (res.isEmpty() || res.getLast()[1] < interval[0])
				res.add(interval);
			else
				res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
		}
		return res.toArray(new int[res.size()][]);
	}
}
