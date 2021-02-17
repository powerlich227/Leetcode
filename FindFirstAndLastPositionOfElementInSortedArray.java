import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
	public static void main(String[] args) {
		int[] nums = {1,1,5};
		int[] res = searchRange(nums, 1);
		System.out.println(Arrays.toString(res));
	}
	public static int[] searchRange(int[] nums, int target) {
		int[] res = {-1, -1};
		if (nums == null)
			return res;
		int left = 0, right = nums.length;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] < target)
				left = mid + 1;
			else
				right = mid;
		}
		if (right == nums.length || nums[right] != target)
			return res;
		res[0] = left;
		
		right = nums.length;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] <= target)
				left = mid + 1;
			else
				right = mid;
		}
		res[1] = right - 1;
		return res;
	}
}
