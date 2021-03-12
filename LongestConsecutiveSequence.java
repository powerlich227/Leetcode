import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		System.out.println();
	}
	public int longestConsecutive(int[] nums) {
		int res = 0;
		Set<Integer> hashSet = new HashSet<>();
		for (int num : nums)
			hashSet.add(num);
		for (int num : nums) {
			if (hashSet.contains(num)) {
				hashSet.remove(num);
				int pre = num - 1, post = num + 1;
				while (hashSet.contains(pre)) {
					hashSet.remove(pre);
					pre--;
				}
				while (hashSet.contains(post)) {
					hashSet.remove(post);
					post++;
				}
				res = Math.max(res, post - pre - 1); 
			}
		}
		return res;
	}
}
