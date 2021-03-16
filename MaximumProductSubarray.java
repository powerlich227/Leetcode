
public class MaximumProductSubarray {
	public static void main(String[] args) {
		System.out.println();
	}
	/*
	 * Max[i] = max(Max[i-1] * nums[i], Min[i-1] * nums[i], nums[i])
	 * Min[j] = min(Min[j-1] * nums[j], Max[j-1] * nums[j], nums[j])
	 */
	public int maxProduct(int[] nums) {
		if (nums.length == 0)
			return 0;
		int res = nums[0], min = nums[0], max = nums[0];
		for (int i = 0; i < nums.length; i++) {
//			int minTemp = min, maxTemp = max; // Optimized Space
//			max = Math.max(Math.max(nums[i], maxTemp * nums[i]), minTemp * nums[i]);
//			min = Math.min(Math.min(nums[i], minTemp * nums[i]), maxTemp * nums[i]);
			if (nums[i] < 0) {
				int temp = max;
				max = min;
				min = temp;
			}
			max = Math.max(nums[i], max * nums[i]);
			min = Math.min(nums[i], min * nums[i]);
			res = Math.max(res, max);
		}
		return res;
	}
}
