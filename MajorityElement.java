
public class MajorityElement {
	public static void main(String[] args) {
		System.out.println();
	}
	public int majorityElement(int[] nums) {
		int l = nums.length / 2;
		for (int num1 : nums) {
			int count = 0;
			for (int num2 : nums) {
				if (num1 == num2)
					count++;
			}
			if (count > l) {
				return num1;
			}
			
		}
		return 0;
	}
	//Moore Voting
	public int majorityElement2(int[] nums) {
		int res = 0;
		int count = 0;
		for (int num: nums) {
			if (count == 0) {
				res = num;
				count++;
			}
			else if (num == res)
				count++;
			else
				count--;
		}		
		return res;
	}
}
