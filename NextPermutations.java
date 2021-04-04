
public class NextPermutations {
	public static void nextPermutations(int[] nums) {
		int n = nums.length;
		int i = n - 2, j = n - 1;
		while (i >= 0 && nums[i] >= nums[i + 1])
			i--;
		if (i >= 0) {
			while (nums[j] <= nums[i])
				j--;
			int temp = nums[j];
			nums[j] = nums[i];
			nums[i] = temp;
		}
		i++;
		j = n - 1;
		while (i < j) {
			int temp = nums[j];
			nums[j] = nums[i];
			nums[i] = temp;
			i++;
			j--;
		}
	}
	public static void main(String[] args) {
		int[] nums = {1, 5, 8, 4, 7, 6, 5, 3, 1};;
		nextPermutations(nums);
		for (int i : nums)
			System.out.println(i);
	}
}
