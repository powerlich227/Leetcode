import java.util.*;
public class FindAllDuplicateInAnArray {
	public static void main(String[] args) {
		System.out.println();
	}
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int idx = nums[i] - 1;
			if (nums[idx] < 0)
				res.add(idx + 1);
			nums[idx] = -nums[idx];
		}
		return res;
	}
}
