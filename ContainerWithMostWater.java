/*
 * LeetCode 11 Medium
 * 
 * Container With Most Water
 * 
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). 
Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1

Example 3:
Input: height = [4,3,2,1,4]
Output: 16

Example 4:
Input: height = [1,2,1]
Output: 2
 
Constraints:

n == height.length
2 <= n <= 10^5
0 <= height[i] <= 10^4
 */
public class ContainerWithMostWater {
	public static void main(String[] args) {
		System.out.println();
	}
	// Two pointers: left & right
	public int maxArea(int[] height) {
		int res = 0, i = 0, j = height.length - 1;
		while (i < j) {
			int area = Math.min(height[i], height[j]) * (j - i);
			res = Math.max(res, area);
			if (height[i] < height[j])
				i++;
			else
				j--;
		}
		return res;
	}
	public int maxArea2(int[] height) {
		int res = 0, i = 0, j = height.length - 1;
		while (i < j) {
			int h = Math.min(height[i], height[j]);
			res = Math.max(res, h * (j - i));
			while (i < j && height[i] == h)
				i++;
			while (i < j && height[j] == h)
				j++;
		}
		return res;
	}

}
