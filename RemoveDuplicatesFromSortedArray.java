
public class RemoveDuplicatesFromSortedArray {
	public static void main(String args[]) {
		
	}
	
	public int removeDuplicates(int[] nums) {
		if(nums == null)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
			}
		}
		return i + 1;
	}

}
