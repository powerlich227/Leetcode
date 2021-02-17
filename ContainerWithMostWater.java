
public class ContainerWithMostWater {
	public static void main(String[] args) {
		System.out.println();
	}
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
