import java.util.*;
public class MissingNumber {
	public static void main(String[] args) {
		System.out.println();
	}
	public int missingNumber(int[] nums) {
		int sum = 0, n = nums.length;
		
		for (int num : nums) 
			sum += num;
		
		return n * (n + 1) / 2 - sum;
	}
	public int missingNumber2(int[] nums) {
		Arrays.sort(nums);
		int l = 0, r = nums.length;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (nums[m] > m)
				r = m;
			else
				l = m + 1;
		}
		
		return r;
	}

}
