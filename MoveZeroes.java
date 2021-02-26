
public class MoveZeroes {
	public static void main(String[] args) {
		System.out.println();
	}
	public void movezeroes(int[] nums) {
		for (int i = 0, j = 0, temp = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				j++;
			}		
		}
	}
}
