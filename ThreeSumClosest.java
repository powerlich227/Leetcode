import java.util.*;

public class ThreeSumClosest {
	public static void main(String[] args) {
		System.out.println();
	}
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length && diff != 0; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (Math.abs(target - sum) < Math.abs(diff)) {
					diff = target - sum;
				}
				if (sum < target)
					j++;
				else
					k--;
			}
		}
		return target - diff;
	}
}
