import java.util.Arrays;

/*
 * LeetCode 435 Medium
 * 
 * Non-overlapping Intervals
 *  
Given an array of intervals intervals where intervals[i] = [starti, endi], 
return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.


Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

Example 2:
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

Example 3:
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 

Constraints:

1 <= intervals.length <= 2 * 10^4
intervals[i].length == 2
-2 * 104 <= starti < endi <= 2 * 10^4
 */
public class NonOverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
		int cnt = 0;
		int end = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			int start = intervals[i][0];
			if (start < end)
				cnt++;
			else
				end = intervals[i][1];
		}
		return cnt;
	}
	public static void main(String[] args) {
		NonOverlappingIntervals test = new NonOverlappingIntervals();
		int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}}, intervals2 = {{1,2}, {1,2}, {1,2}}, intervals3 = {{1,2}, {2,3}};
		System.out.println(test.eraseOverlapIntervals(intervals));
		System.out.println(test.eraseOverlapIntervals(intervals2));
		System.out.println(test.eraseOverlapIntervals(intervals3));
	}
}
