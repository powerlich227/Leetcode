import java.util.Arrays;
import java.util.LinkedList;

/*
 * LeetCode 986 Medium
 * 
 * Interval List Intersections
 * 
You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. 
Each list of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.

A closed interval [a, b] (with a < b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. 
For example, the intersection of [1, 3] and [2, 4] is [2, 3].

 
Example 1:
Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

Example 2:
Input: firstList = [[1,3],[5,9]], secondList = []
Output: []

Example 3:
Input: firstList = [], secondList = [[4,8],[10,12]]
Output: []

Example 4:
Input: firstList = [[1,7]], secondList = [[3,10]]
Output: [[3,7]]
 

Constraints:
0 <= firstList.length, secondList.length <= 1000
firstList.length + secondList.length >= 1
0 <= starti < endi <= 10^9
endi < starti+1
0 <= startj < endj <= 10^9
endj < startj+1
 */
public class IntervalListIntersections {
	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		LinkedList<int[]> res = new LinkedList<>();
		int i = 0, j = 0;
		int m = firstList.length, n = secondList.length;
		while (i < m && j < n) {
			int a1 = firstList[i][0];
			int a2 = firstList[i][1];
			int b1 = secondList[j][0];
			int b2 = secondList[j][1];
			// not (a2 < b1 or b2 < a1)
			if (b2 >= a1 && a2 >= b1) { 
				int[] intersect = {Math.max(a1, b1), Math.min(a2, b2)};
				res.add(intersect);
			}
			if (b2 < a2)
				j++;
			else
				i++;
		}
		
		return res.toArray(new int[res.size()][]);
	}
	public static void main(String[] args) {
		int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}}, firstList2 = {{1, 3}, {5, 9}}, firstList3 = {}, firstList4 = {{1, 7}};
		int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}}, secondList2 = {}, secondList3 = {{4, 8}, {10, 12}}, secondList4 = {{3, 10}};
		IntervalListIntersections test = new IntervalListIntersections();
		System.out.println(Arrays.deepToString(test.intervalIntersection(firstList, secondList)));
		System.out.println(Arrays.deepToString(test.intervalIntersection(firstList2, secondList2)));
		System.out.println(Arrays.deepToString(test.intervalIntersection(firstList3, secondList3)));
		System.out.println(Arrays.deepToString(test.intervalIntersection(firstList4, secondList4)));
	}

}
