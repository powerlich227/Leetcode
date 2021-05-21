import java.util.Arrays;

/*
 * LeetCode 1288 Medium
 * 
 * Remove Covered Interval
 * 
Given a list of intervals, remove all intervals that are covered by another interval in the list.
Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
After doing so, return the number of remaining intervals.


Example 1:
Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.

Example 2:
Input: intervals = [[1,4],[2,3]]
Output: 1

Example 3:
Input: intervals = [[0,10],[5,12]]
Output: 2

Example 4:
Input: intervals = [[3,10],[4,10],[5,11]]
Output: 2

Example 5:
Input: intervals = [[1,2],[1,4],[3,4]]
Output: 1
 

Constraints:
1 <= intervals.length <= 1000
intervals[i].length == 2
0 <= intervals[i][0] < intervals[i][1] <= 10^5
All the intervals are unique.
 */
public class RemoveCoveredIntervals {
	public int removeCoveredIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> {
			if (a[0] == b[0])
				return b[1] - a[1];
			return a[0] - b[0];
		});
		
		int left = intervals[0][0];
		int right = intervals[0][1];
		
		int n = intervals.length, res = n;
		for (int i = 1; i < n; i++) {
			int[] interval = intervals[i];
			
			if (left <= interval[0] && right >= interval[1])
				res--;
			
			if (right >= interval[0] && right <= interval[1])
				right = interval[1];
			
			if (right < interval[0]) {
				left = interval[0];
				right = interval[1];
			}
		}
		return res;
	}
	// optimized
	public int removeCoveredIntervals2(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> {
			if (a[0] == b[0])
				return b[1] - a[1];
			return a[0] - b[0];
		});

		int right = 0, res = 0;	
		for (int[] interval : intervals) {			
			if (interval[1] > right) {
				res++;
				right = interval[1];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] intervals = {{1, 4}, {3, 6}, {2, 8}}, intervals2 = {{1, 4}, {2, 3}}, intervals3 = {{0, 10}, {5, 12}};
		int[][] intervals4 = {{3, 10}, {4, 10}, {5, 11}}, intervals5 = {{1, 2}, {1, 4}, {3, 4}};
		RemoveCoveredIntervals test = new RemoveCoveredIntervals();
		System.out.println(test.removeCoveredIntervals(intervals));
		System.out.println(test.removeCoveredIntervals(intervals2));
		System.out.println(test.removeCoveredIntervals(intervals3));
		System.out.println(test.removeCoveredIntervals(intervals4));
		System.out.println(test.removeCoveredIntervals(intervals5));
		System.out.println(test.removeCoveredIntervals2(intervals));
		System.out.println(test.removeCoveredIntervals2(intervals2));
		System.out.println(test.removeCoveredIntervals2(intervals3));
		System.out.println(test.removeCoveredIntervals2(intervals4));
		System.out.println(test.removeCoveredIntervals2(intervals5));
	}
}
