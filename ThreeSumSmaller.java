import java.util.*;

public class ThreeSumSmaller {
	public static void main(String[] args) {
		int[] nums = {-2, 0, 1, 3};
		int target = 10;
		int res = threeSumSmaller(nums, target);
		System.out.println(res);
	}
	public static int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
				int j = i + 1;
				int k = nums.length - 1;
				while (j < k) {
					int sum = nums[i] + nums[j] + nums[k];
					if (sum < target) {
						res += k - j;
						j++;
					}
					else
						k--;
				}
			}
		}
		return res;
	}

}
