
public class RemoveDuplicatesFromSortedArrayII {
	public static void main(String args[]) {
		System.out.println();
	}
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int i = 0;
		for (int num : nums) {
			if (i < 2 || num != nums[i-2])
				nums[i++] = num;
		}
		return i;
	}
	public int removeDuplicates2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int i = 0, count = 1;
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] == nums[j] && count == 0)
				continue;
			else {
				if (nums[i] == nums[j])
					count--;
				else
					count = 1;
				nums[++i] = nums[j];
			}
		}
		return i + 1;
	}
	public int removeDuplicates3(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int i = 0, j = 1, count = 1;
		while (j < nums.length) {
			if (nums[i] == nums[j] && count == 0)
				j++;
			else {
				if (nums[i] == nums[j])
					count--;
				else
					count = 1;
				nums[++i] = nums[j++];
			}
		}
		return i + 1;
	}
}
