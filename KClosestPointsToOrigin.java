import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * LeetCode 973 Medium
 * 
 * K Closest Points to Origin
 * 
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, 
return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

Example 1:
Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 
Constraints:
1 <= k <= points.length <= 10^4
-10^4 < xi, yi < 10^4
 */
public class KClosestPointsToOrigin {
	// maxPQ
	public int[][] kClosest(int[][] points, int k) {
		Queue<int[]> maxPQ = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
		for (int i = 0; i < points.length; i++) {
			int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
			int[] cur = {dist, i};
			if (maxPQ.size() < k)
				maxPQ.offer(cur);
			else if (dist < maxPQ.peek()[0]) {
				maxPQ.poll();
				maxPQ.offer(cur);
			}
		}
		int[][] res = new int[k][2];
		for (int i = 0; i < k; i++)
			res[i] = points[maxPQ.poll()[1]];
		return res;
	}
	public static void main(String[] args) {
		KClosestPointsToOrigin test = new KClosestPointsToOrigin();
		System.out.println(Arrays.deepToString(test.kClosest(new int[][] {{1, 3}, {-2, 2}}, 1)));
		System.out.println(Arrays.deepToString(test.kClosest(new int[][] {{3, 3}, {5, -1}, {-2, 4}}, 2)));
	}
}
