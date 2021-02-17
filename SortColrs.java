import java.util.*;
public class SortColrs {
	public static void main(String[] args) {
		int[] nums = {2,0,2,1,1,0,1};
		sortColors2(nums);
		System.out.println(Arrays.toString(nums));
	}
	// Counting Sort
	public static void sortColors(int[] nums) {
		int[] colors = new int[3];
//		Arrays.fill(colors, 0);
		for (int num : nums)
			colors[num]++;
		for (int i = 0, cur = 0; i < 3; i++) {
			for (int j = 0; j < colors[i]; j++)
				nums[cur++] = i;
		}
	}
	public static void sortColors2(int[] nums) {
		int left = 0, right = nums.length - 1;
		for (int i = left; i <= right; i++) {
			if (nums[i] == 0) {
				int temp = nums[left];
				nums[left] = nums[i];
				nums[i] = temp;
				left++;
			}
			else if (nums[i] == 2) {
				int temp = nums[i];
				nums[i] = nums[right];
				nums[right] = temp;
				right--;
				i--;
			}
		}
	}

}
