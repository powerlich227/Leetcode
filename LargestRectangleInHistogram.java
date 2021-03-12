import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
	public static void main(String[] args) {
		System.out.println();
	}
	public int largestRectangleArea(int[] heights) {
		int res = 0, n = heights.length;
		Stack<Integer> st = new Stack<>();
		int[] newHeights = Arrays.copyOf(heights, n + 1);
		for (int i = 0; i <= n; i++) {
//			if (st.empty() || newHeights[st.peek()] <= newheights[i])
//				st.push(i);
//			else {
//				int cur = st.pop();
//				int width = st.empty() ? i : i - st.peek() - 1;
//				res = Math.max(res, heights[cur] * width);
//				i--;
//			}
			while (!st.empty() && heights[st.peek()] > heights[i]) {
				int cur = st.pop();
				int width = st.empty() ? i : i - st.peek() - 1;
				res = Math.max(res, heights[cur] * width);
			}
			st.push(i);
		}
		return res;
	}
}
