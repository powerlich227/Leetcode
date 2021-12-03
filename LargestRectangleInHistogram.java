import java.util.Arrays;
import java.util.Stack;
/*
 * LeetCode 84 Hard
 * 
 * Largest Rectangle In Histogram
 * 
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, 
return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4
 
Constraints:
1 <= heights.length <= 10^5
0 <= heights[i] <= 10^4
 */
public class LargestRectangleInHistogram {
	public static void main(String[] args) {
		LargestRectangleInHistogram test = new LargestRectangleInHistogram();
		System.out.println(test.largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3}));
		System.out.println(test.largestRectangleArea(new int[] {2, 4}));
		System.out.println(test.largestRectangleArea(new int[] {1, 2, 2}));
	}
	// Monotonic stack
	// st: to store the index of increasing height
	public int largestRectangleArea(int[] heights) {
		int res = 0, n = heights.length;
		Stack<Integer> st = new Stack<>();
		int[] newHeights = Arrays.copyOf(heights, n + 1);
		for (int i = 0; i <= n; i++) {
			while (!st.empty() && newHeights[st.peek()] > newHeights[i]) {
				int cur = st.pop(); // idx
				int width = st.empty() ? i : i - st.peek() - 1;
				res = Math.max(res, newHeights[cur] * width);
			}
			st.push(i);
		}
		return res;
	}
}
