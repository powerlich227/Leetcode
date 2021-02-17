
public class RemoveDuplicatesFromSortedArray {
	public static void main(String args[]) {
		System.out.println();
	}
	
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] != nums[j])
                nums[++i] = nums[j];
		}
		return i + 1;
	}
	public int removeDuplicates2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int i = 0, j = 1;
		while (j < nums.length) {
			if (nums[i] == nums[j])
				j++;
			else
				nums[++i] = nums[j++]; // equivalent to nums[++i] = nums[j]
		}
		return i + 1;
	}
	public int removeDuplicates3(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;	
		int i = 0;
		for (int n : nums) {
			if (i == 0 || n != nums[i - 1])
				nums[i++] = n;
		}
		return i;
	}

}
