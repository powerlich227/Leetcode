import java.util.*;

public class ContainsDuplicateII {
	public static void main(String[] args) {
		System.out.println();
	}
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashSet<Integer> set = new HashSet<>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			if (i > k)
				set.remove(nums[i - k - 1]);
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}

}
