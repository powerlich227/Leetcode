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
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
In this case, the max area of water (blue section) the container can contain is 49.

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
		ContainerWithMostWater test = new ContainerWithMostWater();
		System.out.println(test.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
		System.out.println(test.maxArea(new int[] {1,1}));
		System.out.println(test.maxArea(new int[] {4,3,2,1,4}));
		System.out.println(test.maxArea(new int[] {1,2,1}));
	}
	// Two pointers: l & r
	public int maxArea(int[] height) {
		int l = 0, r = height.length - 1;
		int res = 0;
		while (l < r) {
			int area = Math.min(height[l], height[r]) * (r - l);
			res = Math.max(res, area);
			if (height[l] < height[r])
				l++;
			else
				r--;
		}
		return res;
	}
}
