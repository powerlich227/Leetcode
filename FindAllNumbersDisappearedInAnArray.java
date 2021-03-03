import java.util.*;
public class FindAllNumbersDisappearedInAnArray {
	public static void main(String[] args) {
		System.out.println();
	}
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int idx = Math.abs(nums[i]) - 1;
			nums[idx] = nums[idx] > 0 ? - nums[idx] : nums[idx];
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				res.add(i + 1);
		}
		return res;
	}
}
