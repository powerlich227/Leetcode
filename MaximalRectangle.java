import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
	public static void main(String[] args) {
		System.out.println();
	}
	
//	public int maximalRectangle(char[][] matrix) {
//		if (matrix.length == 0)
//			return 0;
//		int res = 0, m = matrix.length, n = matrix[0].length;
//		int[] heights = new int[n];
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++)
//				heights[j] = (matrix[i][j] == '0') ? 0 : heights[j] + 1;
//			res = Math.max(res, largestRectangleArea(heights));
//		}
//		return res;	
//	}
//	public int largestRectangleArea(int[] heights) {
//		int res = 0, n = heights.length;
//		Stack<Integer> st = new Stack<>();
//		int[] newHeights = Arrays.copyOf(heights, n + 1);
//		for (int i = 0; i <= n; i++) {
//			while (!st.empty() && newHeights[st.peek()] > newHeights[i]) {
//				int cur = st.pop();
//				int width = st.empty() ? i : i - st.peek() - 1;
//				res = Math.max(res, newHeights[cur] * width);
//			}
//			st.push(i);
//		}
//		return res;
//	}
	
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int res = 0, m = matrix.length, n = matrix[0].length;
		int[] heights = new int[n + 1];
		for (int i = 0; i < m; i++) {
			Stack<Integer> st = new Stack<>();
			for (int j = 0; j <= n; j++) {
				if (j < n)
					heights[j] = (matrix[i][j] == '0') ? 0 : heights[j] + 1;
				while (!st.empty() && heights[st.peek()] > heights[j]) {
					int cur = st.pop();
					int width = st.empty() ? j : j - st.peek() - 1;
					res = Math.max(res, heights[cur] * width);
				}
				st.push(j);
			}
		}
		return res;	
	}
}
