
public class FirstMissingPositive {
	public static void main(String[] args) {
		System.out.println();
	}
	
	/*
	 * runs in O(n)
	 * constant extra space
	 */
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
		for (int i = 0; i < n; i++) {
			if (nums[i] != i + 1)
				return i + 1;
		}
			
		return n + 1;
	}

}
