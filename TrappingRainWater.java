import java.util.Stack;

/*
 * LeetCode 42 Hard
 * 
 * Trapping Rain Water
 * 
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 
Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
0 <= n <= 3 * 10^4
0 <= height[i] <= 10^5
 */

public class TrappingRainWater {
	public static void main(String[] args) {
		TrappingRainWater test = new TrappingRainWater();
		System.out.println(test.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println(test.trap2(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		System.out.println(test.trap(new int[] {4,2,0,3,2,5}));
		System.out.println(test.trap2(new int[] {4,2,0,3,2,5}));
	}
	// water[i] = min(max(height[0...i]), max(height[i...n])) - height[i]
	
	// 2 pointers, once traversal
	public int trap(int[] height) {
		if (height.length == 0)
			return 0;
		
		int n = height.length;
		int l = 0, r = n - 1;
		int l_max = 0; // max height before l
		int r_max = 0; // max height after r
		
		int res = 0;
		while (l < r) {
			l_max = Math.max(height[l], l_max);
			r_max = Math.max(height[r], r_max);
			
			if (l_max > r_max) {
				res += r_max - height[r];
				r--;
			}
			else {
				res += l_max - height[l];
				l++;
			}
		}
		return res;
	}
	// memo array
	public int trap2(int[] height) {
		if (height.length == 0)
			return 0;
		
		int n = height.length;
		int[] l_max = new int[n], r_max = new int[n];
		l_max[0] = height[0];
		r_max[n - 1] = height[n - 1];
		for (int i = 1; i < n; i++)
			l_max[i] = Math.max(height[i], l_max[i - 1]);
		for (int i = n - 2; i >= 0; i--)
			r_max[i] = Math.max(height[i], r_max[i + 1]);
		int res = 0;
		for (int i = 1; i < n - 1; i++)
			res += Math.min(l_max[i], r_max[i]) - height[i];
		
		return res;	
	}
	// stack
	public int trap3(int[] height) {
		int res = 0, i = 0, n = height.length;
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
