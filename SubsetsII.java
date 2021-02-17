import java.util.*;
public class SubsetsII {
	public static void main(String[] args) {
		int[] nums = {1,1,2,2,2};
		System.out.println(subsetsWithDup(nums));
	}
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> out = new ArrayList<>();
		helper(nums, 0, out, res);
		return res;
	}
	public static void helper(int[] nums, int level, List<Integer> out, List<List<Integer>> res) {
		res.add(new ArrayList<>(out));
		for (int i = level; i < nums.length; i++) {
			out.add(nums[i]);
			helper(nums, i + 1, out ,res);
			out.remove(out.size() - 1);
			while (i + 1 < nums.length && nums[i] == nums[i + 1] )
				i++;
		}
	}

}
