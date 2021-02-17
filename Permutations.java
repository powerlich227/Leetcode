import java.util.*;
public class Permutations {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		System.out.println(permute(nums));
	}
	// DFS
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> out = new ArrayList<>();
		int[] visited = new int[nums.length];
		Arrays.fill(visited, 0);
		helper(nums, 0, out, visited, res);
		return res;
	}
	public static void helper(int[] nums, int level, List<Integer> out, int[] visited, List<List<Integer>> res) {
		if (level >= nums.length) {
			System.out.println(level + " " + out + " saved" + " ");
			res.add(new ArrayList<>(out));
			return;
		}
		for (int i = 0 ; i < nums.length; i++) {
			System.out.print(level + " " + i + " " + out + " ");
			if (visited[i] == 1) {
				System.out.println("skip 1");
				continue;
			}
			System.out.println();
			visited[i] = 1;
			out.add(nums[i]);
			helper(nums, level + 1, out, visited, res);
			out.remove(out.size() - 1);
			visited[i] = 0;
			System.out.println(level + " " + i + " " + out + " recovered");
		}
	}

}
