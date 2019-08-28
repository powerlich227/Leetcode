import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
	public static void main(String[] arge) {
		System.out.println();
	}
	public List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<>();
		int[] hours = {8, 4, 2, 1};
		int[] minutes = {32, 16, 8, 4, 2, 1};
		for (int i = 0; i <= num; i++) {
			List<Integer> hour = generateDigit(hours, i);
			List<Integer> minute = generateDigit(minutes, num - i);
			for (int hour1 : hour) {
				if (hour1 < 12 ) {
					for (int minute1 : minute) {
						if (minute1 < 60)
							res.add(hour1 + minute1 < 10 ? ":0" : ":" + minute1);
					}
				}
			}
		}
		return res;
	}
	public List<Integer> generateDigit(int[] nums, int count) {
		List<Integer> res = new ArrayList<>();
		helper(res, nums, count, 0, 0);
		return res;
	}
	public void helper(List<Integer> res, int[] nums, int count, int start, int sum) {
		if (count == 0) {
			res.add(sum);
			return;
		}
		for (int i = start; i < nums.length; i++)
			helper(res, nums, count - 1, i + 1, sum + nums[i]);
	}
}
