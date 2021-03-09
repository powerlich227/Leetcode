import java.util.Stack;

public class TrappingRainWater {
	public static void main(String[] args) {
		System.out.println();
	}
	
	// twice traversal
	public int trap(int[] height) {
		int res = 0, max_left = 0, max_right = 0, n = height.length;
		int[] dp = new int[n];
		// dp = left max
		for (int i = 0; i < n; i++) {
			dp[i] = max_left;
			max_left = Math.max(max_left, height[i]);
		}
		// dp = min(max_left, max_right)
		for (int i = n - 1; i > 0; i--) {
			dp[i] = Math.min(max_right, dp[i]);
			max_right = Math.max(max_right, height[i]);
			if (dp[i] > height[i])
				res += dp[i] - height[i];
		}
		return res;
	}
	// once traversal
	public int trap2(int[] height) {
		int res = 0, l = 0, r = height.length - 1, level = 0;
		while (l < r) {
			int base = height[(height[l] < height[r] ? l++ : r--)];
			level = Math.max(level, base);
			res += level - base;
		}
		return res;
	}
	
	// stack
	public int trap3(int[] height) {
		int res = 0, i = 0, cur = 0, n = height.length;
		Stack<Integer> st = new Stack<>();
		while (i < n) {
			if (st.empty() || height[i] <= height[st.peek()])
				st.push(i++);
			else {
				int idx = st.pop();
				if (st.empty())
					continue;
				int dist = i - st.peek() - 1;
				int h = Math.min(height[i], height[st.peek()]) - height[idx];
				res = dist * h;
			}
		}
		return res;
	}
}
