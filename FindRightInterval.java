import java.util.Arrays;
import java.util.TreeMap;

/*
 * LeetCode 436 Medium
 * 
 * Find Right Interval
 * 
You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.
The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.
Return an array of right interval indices for each interval i. If no right interval exists for interval i, then put -1 at index i.

Example 1:
Input: intervals = [[1,2]]
Output: [-1]
Explanation: There is only one interval in the collection, so it outputs -1.

Example 2:
Input: intervals = [[3,4],[2,3],[1,2]]
Output: [-1,0,1]
Explanation: There is no right interval for [3,4].
The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.

Example 3:
Input: intervals = [[1,4],[2,3],[3,4]]
Output: [-1,2,-1]
Explanation: There is no right interval for [1,4] and [3,4].
The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
 
Constraints:
1 <= intervals.length <= 2 * 10^4
intervals[i].length == 2
-10^6 <= starti <= endi <= 10^6
The start point of each interval is unique.
 */
public class FindRightInterval {
	// TreeMap
	public int[] findRightInterval(int[][] intervals) {
		int[] res = new int[intervals.length];
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < intervals.length; i++) {
			map.put(intervals[i][0], i);
		}
		for (int i = 0; i < intervals.length; i++) {
			Integer start = map.ceilingKey(intervals[i][1]);
			res[i] = start == null ? -1 : map.get(start);
		}
		return res;
	}
	public static void main(String[] args) {
		int[][] intervals = {{1, 2}}, intervals2 = {{3, 4}, {2, 3}, {1, 2}}, intervals3 = {{1, 4}, {2, 3}, {3, 4}};
		FindRightInterval test = new FindRightInterval();
		System.out.println(Arrays.toString(test.findRightInterval(intervals)));
		System.out.println(Arrays.toString(test.findRightInterval(intervals2)));
		System.out.println(Arrays.toString(test.findRightInterval(intervals3)));
	}
}
