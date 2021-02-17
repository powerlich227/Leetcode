import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
	public static void main(String[] args) {
		System.out.println();
	}
	public int singleNumber(int[] nums) {
		Set<Integer> s = new HashSet<>();
		for (int num : nums) {
			if (!s.add(num))
				s.remove(num);
		}
		return s.iterator().next();
	}
	// Bit Manipulation XOR
	public int singleNumber2(int[] nums) {
		int res = 0;
		for (int n : nums) {
			res ^= n;
		}
		return res;
	}
}
