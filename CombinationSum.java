import java.util.*;

public class CombinationSum {
	public static void main(String[] args) {
		System.out.println();
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>>	res = new ArrayList<>();
		List<Integer> out = new ArrayList<>();
		
//		Arrays.sort(candidates);
		helper(candidates, target, 0, out, res);
		return res;
	}
	// DFS
	public void helper(int[] candidates, int target, int start, List<Integer> out, List<List<Integer>> res) {
		if (target < 0)
			return;
		if (target == 0) {
			List<Integer> temp = new ArrayList<>(out);
			res.add(temp);
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			out.add(candidates[i]);
			helper(candidates, target - candidates[i], i , out, res);
			out.remove(out.size() - 1);
		}
	}
}
