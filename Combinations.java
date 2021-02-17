import java.util.*;
public class Combinations {
	public static void main(String[] args) {
		System.out.println(combine(4,2));
	}
	// DFS
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> out = new ArrayList<>();
		helper(n, k, 1, out, res);
		return res;
	}
	public static void helper(int n, int k, int level, List<Integer> out, List<List<Integer>> res) {
		if (out.size() == k) {
			res.add(new ArrayList<>(out));
			return;
		}
		for (int i = level; i <= n; i++) {
			out.add(i);
			helper(n, k, i + 1, out, res);
			out.remove(out.size() - 1);
		}
	}
}
