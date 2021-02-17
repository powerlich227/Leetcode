import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
	public static void main(String[] args) {
		System.out.println();
	}
	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] == nums[i])
				return true;
		}
		return false;
	}
	public boolean containsDuplicate2(int[] nums) {
		HashSet<Integer> set = new HashSet<>(nums.length);
		for (int num : nums) {
			if (!set.add(num))
				return true;
//			if (set.contains(num))
//				return true;
//			set.add(num);
		}
		return false;
	}
}
