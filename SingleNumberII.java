
public class SingleNumberII {
	public static void main(String[] args) {
		System.out.println();
	}
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int j = 0; j < nums.length; j++)
				sum += (nums[j] >> i) & 1;
			res |= (sum % 3) << i;
		}
		return res;
	}
}
