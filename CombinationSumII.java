import java.util.*;
public class CombinationSumII {
	public static void main(String[] args) {
		System.out.println();
	}
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		
		Arrays.sort(candidates);
		List<Integer> out = new ArrayList<>();
		helper(candidates, target, out, res, 0);
		
		return res;
	}
	public void helper(int[] candidates, int target, List<Integer> out, List<List<Integer>> res, int start) {
		if (target < 0)
			return;
		if (target == 0) {
			res.add(new ArrayList<>(out));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			// to avoid the duplicate combinations in the result
			if (i > start && candidates[i] == candidates[i - 1])
				continue;
			
			out.add(candidates[i]);
			helper(candidates, target - candidates[i], out, res, i + 1);
			out.remove(out.size() - 1);
		}
	}
}
