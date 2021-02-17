
public class JumpGame {
	public static void main(String[] args) {
		System.out.println();
	}
	//Greedy
	public boolean canJump(int[] nums) {
		int reach = 0;
		for (int i = 0; i < nums.length; i++) {
			if (reach < i || reach >= nums.length - 1)
				break;
			reach = Math.max(reach, i + nums[i]);
		}
		return (reach >= nums.length - 1);
	}
	//Greedy2
	public boolean canJump2(int[] nums) {
		int index = nums.length - 1;
		for (int i = index; i >= 0; i--) {
			if (i + nums[i] > index)
				index = i;
		}
		return index == 0;
	}

}
