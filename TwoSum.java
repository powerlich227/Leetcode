import java.util.HashMap;

public class TwoSum {
	public static void main(String[] args) {
		System.out.println();
	}
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) 
                    return new int[] {i, j};
            }
        }
        throw new IllegalArgumentException("No solution");
    }
	public int[] twoSum2(int[] nums, int target) {
		int[] res = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++)
			map.put(nums[i], i);
		for (int j = 0; j < nums.length; j++) {
			if (map.containsKey(target - nums[j]) 
					&& map.get(target - nums[j]) != j) {
				res[0] = j;
				res[1] = map.get(target - nums[j]);
				break;
			}
		}
		return res;
	}
	public int[] twoSum3(int[] nums, int target) {
		int[] res = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res[0] = i;
				res[1] = map.get(target - nums[i]);
				break;
			}
			map.put(nums[i], i);
		}
		return res;
	}
}
