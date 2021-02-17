import java.util.*;
public class Subsets {
	public static void main(String[] args) {
		int[] nums = {2,1,3};
		System.out.println(subsets(nums));
	}
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> out = new ArrayList<>();
//		Arrays.sort(nums);
		helper(nums, 0, out, res);
		return res;
	}
	public static void helper (int[] nums, int level, List<Integer> out, List<List<Integer>> res) {
		res.add(new ArrayList<>(out));
		for (int i = level; i < nums.length; i++) {
			out.add(nums[i]);
			helper(nums, i + 1, out, res);
			out.remove(out.size() - 1);
		}
	}
}
