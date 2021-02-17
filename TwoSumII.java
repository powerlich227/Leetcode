
public class TwoSumII {
	public static void main(String[] args) {
		System.out.println();
	}
	public int[] twoSum(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;

		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == target) {
				int[] res = new int[]{left + 1, right + 1};
				return res;
			}
			else if (sum < target)
				left++;
			else
				right--;
		}
		return null;
	}
}
