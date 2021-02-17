import java.util.*;

public class SummaryRanges {
	public static void main(String[] args) {
		System.out.println();
	}

	public List<String> summaryRanges(int[] nums) {
		List<String> res = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			int left = nums[i];
			while (i + 1 < nums.length && nums[i+1] - nums[i] == 1 )
				i++;
			if (nums[i] != left)
				res.add(left + "->" + nums[i]);
			else 
				res.add(Integer.toString(nums[i]));
		}
		
		return res;
	}

}
