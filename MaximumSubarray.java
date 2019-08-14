
public class MaximumSubarray {
	public static void main(String args[]) {
		int[] num = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		MaximumSubarray test = new MaximumSubarray();
		System.out.println(test.maxSubArray(num));
	}
	public int maxSubArray(int[] nums) {
		int res = Integer.MIN_VALUE;
		int sum = 0;
		for (int i : nums) {
			sum = Math.max(sum + i, i);
			res = Math.max(res, sum);
		}
		return res;
	}
}
